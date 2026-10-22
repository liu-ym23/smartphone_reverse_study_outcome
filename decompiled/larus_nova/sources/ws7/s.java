package ws7;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dtf.face.log.RecordService;
import com.larus.nova.R;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, Integer> f561104a;

    static {
        f561104a = new HashMap();
    }

    private static Context getContext() {
        Activity r100 = us7.h.f551544b.b();
        if (r100 == null) goto L9;
        if (r100.isFinishing() == true) goto L9;
        if (r100.isDestroyed() == true) goto L9;
        return r100;
    L9:
        return hs7.a.h().getContext();
    }

    public static void a(int r100) {
        Context r101 = getContext();
        if (r101 != null) goto L5;
        return;
    L5:
        ArrayList r102 = new ArrayList();
        r102.add("toyger_verify_video.mp4");
        if (hs7.a.h().D == false) goto L8;
        if (1 == r100) goto L8;
    L21:
        f.c(new PolarisFileWrapper(r101.getCacheDir(), "Phontinus"), r102);
        StringBuilder r103 = new StringBuilder();
        r103.append(r101.getFilesDir().getAbsolutePath());
        String r104 = File.separator;
        r103.append(r104);
        r103.append("toyger_verify_video.zip");
        f.e(r103.toString());
        f.e(r101.getFilesDir().getAbsolutePath() + r104 + "toyger_verify_video.mp4");
        return;
    L8:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r101.getCacheDir() + "/Phontinus", "toyger_verify_video.mp4");
        if (r105.exists() == true) goto L11;
        String r106 = "notPresent";
    L15:
        if (r100 != 0) goto L21;
        if (hs7.a.h().D == true) goto L21;
        if (hs7.a.h().E == false) goto L21;
        RecordService.getInstance().recordEvent(2, "deleteVideoFile", new String[]{"state", r106});
        goto L21
    L11:
        if (r105.delete() == false) goto L13;
        r106 = "success";
        goto L15
    L13:
        r106 = "fail";
        goto L15
    }

    public static Configuration b(Context r100) {
        if (r100 != null) goto L4;
        r100 = getContext();
    L4:
        if (r100 == null) goto L10;
        return r100.getResources().getConfiguration();
    L7:
        th = move-exception;
        RecordService.getInstance().recordEvent(4, "ResourceError", new String[]{com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, RecordService.getStackTraceString(th)});
    L10:
        return new Configuration();
    }

    public static int e(String r100) {
        Map<String, Integer> r101 = f561104a;
        if (r101 != null) goto L5;
        return -1;
    L5:
        if (r101.containsKey(r100) == true) goto L8;
        return -1;
    L8:
        return f561104a.get(r100).intValue();
    }

    public static String[] g(Context r100) {
        if (r100 != null) goto L5;
        r100 = getContext();
    L5:
        if (r100 == null) goto L11;
        return r100.getResources().getStringArray(R.array.type_list);
    L8:
        th = move-exception;
        RecordService.getInstance().recordEvent(4, "ResourceError", new String[]{com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, RecordService.getStackTraceString(th)});
    L11:
        return new String[0];
    }

    public static float c(Context r100, int r101) {
        if (r100 != null) goto L4;
        r100 = getContext();
    L4:
        if (r100 == null) goto L13;
        return r100.getResources().getDimension(r101);
    L7:
        th = move-exception;
        RecordService.getInstance().recordEvent(4, "ResourceError", new String[]{com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, RecordService.getStackTraceString(th)});
        return 0.0f;
    L13:
        return 0.0f;
    }

    public static String f(Context r100, int r101) {
        if (r100 != null) goto L4;
        r100 = getContext();
    L4:
        if (r100 == null) goto L13;
        return r100.getResources().getString(r101);
    L7:
        th = move-exception;
        RecordService.getInstance().recordEvent(4, "ResourceError", new String[]{com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, RecordService.getStackTraceString(th)});
        return "";
    L13:
        return "";
    }

    public static int d(Context r100, String r101, int r110) {
        if (TextUtils.isEmpty(r101) == false) goto L16;
    L8:
        if (r100 != null) goto L10;
        r100 = getContext();
    L10:
        if (r100 == null) goto L20;
        return r100.getResources().getColor(r110);
    L13:
        th = move-exception;
        RecordService.getInstance().recordEvent(4, "ResourceError", new String[]{com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, RecordService.getStackTraceString(th)});
        return 0;
    L20:
        return 0;
    L16:
        return Color.parseColor(r101);
    L6:
        th = move-exception;
        RecordService.getInstance().recordEvent(4, "ResourceError", new String[]{com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, RecordService.getStackTraceString(th)});
        goto L8
    }
}
