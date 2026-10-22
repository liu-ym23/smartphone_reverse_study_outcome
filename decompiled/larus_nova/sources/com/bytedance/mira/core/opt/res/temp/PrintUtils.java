package com.bytedance.mira.core.opt.res.temp;

import android.app.ResourcesManager;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.ResourcesImpl;
import android.os.Build;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.mira.util.ReflectUtils;
import com.bytedance.mira.util.ResUtil;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes21.dex */
public class PrintUtils {
    private static final Method sFindKeyForResourceImplLockedMethod = null;
    private static final Method sGetImplMethod = null;

    public PrintUtils() {
    }

    static {
        sGetImplMethod = ReflectUtils.findDeclaredMethod(Resources.class, "getImpl", new Class[0]);
        sFindKeyForResourceImplLockedMethod = ReflectUtils.findDeclaredMethod(ResourcesManager.class, "findKeyForResourceImplLocked", new Class[]{ResourcesImpl.class});
    }

    public static String buildDebugInfo(Context r100) {
        if (Build.VERSION.SDK_INT >= 24) goto L6;
        return "less than api 24, return empty info";
    L6:
        StringBuilder r101 = new StringBuilder("context = ");
        r101.append(r100);
        r101.append("; resources = ");
        r101.append(r100.getResources());
        r101.append("; all path = ");
        r101.append(ResUtil.getAssetPathsStr(r100.getResources().getAssets()));
        r101.append("; new mira resources split = ");
        r101.append(NewMiraResourcesManager.getInstance().getSplitPathMaps().values());
        r101.append("; ");
        Method r102 = sGetImplMethod;
        if (r102 != null) goto L9;
        r101.append("getImpl method is null.; ");
        Object r103 = null;
    L10:
        Method r104 = sFindKeyForResourceImplLockedMethod;
        if (r104 == null) goto L15;
        if (r103 == null) goto L15;
        r101.append("ResourcesKey = ");
        r101.append(safeMethoInvoke(r104, ResourcesManager.getInstance(), new Object[]{r103}));
        r101.append("; ");
    L16:
        r101.append("configuration = ");
        r101.append(r100.getResources().getConfiguration());
        return r101.toString();
    L15:
        r101.append("findKeyForResourceImplLocked method is null or impl is null.; ");
        goto L16
    L9:
        r103 = safeMethoInvoke(r102, r100.getResources(), new Object[0]);
        r101.append("ResourcesImpl = ");
        r101.append(r103);
        r101.append("; ");
        goto L10
    }

    private static Object safeMethoInvoke(Method r100, Object r101, Object... r102) {
        return r100.invoke(r101, r102);
    L4:
        th = move-exception;
        return th.toString();
    }
}
