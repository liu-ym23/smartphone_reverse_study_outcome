package com.bytedance.dataplatform;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class ABExtraProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        return 0;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.dataplatform.ExperimentPanelDataManager");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.dataplatform.ExperimentPanelDataManager");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.dataplatform.ExperimentPanelDataManager");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.dataplatform.ExperimentPanelDataManager");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.dataplatform.ExperimentPanelDataManager");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.dataplatform.ExperimentPanelDataManager");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.dataplatform.ExperimentPanelDataManager");
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context r100 = getContext();
        ComponentName r101 = new ComponentName(r100.getPackageName(), ABExtraProvider.class.getName());
        Bundle r102 = r100.getPackageManager().getProviderInfo(r101, 128).metaData;     // Catch: Throwable -> L18
        if (r102 == null) goto L34;
        HashMap r103 = new HashMap();     // Catch: Throwable -> L18
        Iterator<String> r104 = r102.keySet().iterator();     // Catch: Throwable -> L18
    L7:
        if (r104.hasNext() == false) goto L16;
        String r105 = r104.next();     // Catch: Throwable -> L18
        if ("____libra____ab____panel".equals(r105) == true) goto L11;
        Object r106 = r102.get(r105);     // Catch: Throwable -> L18
        if (r106 == null) goto L7;
        r103.put(r105, r106.toString());     // Catch: Throwable -> L18
        goto L7
    L11:
        if (r102.getBoolean(r105, false) == false) goto L7;
        p.f204357a = (p.a) a().getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L18
        goto L7
    L16:
        o.a(r103);     // Catch: Throwable -> L18
        return true;
    L34:
        return true;
    L18:
        th = move-exception;
        th.printStackTrace();
        return true;
    }

    public ABExtraProvider() {
    }
}
