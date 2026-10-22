package com.larus.camera.impl.edulibs.camera.internal;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.lightning.edu.ei.edgealgorithm.InferenceHelper;
import com.lightning.edu.ei.edgealgorithm.Params;
import com.lightning.edu.ei.edgealgorithm.Result;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f321603c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static WeakReference<c> f321604d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InferenceHelper f321605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Params f321606b;

    public static final class a {
        public a() {
        }

        public final synchronized c a(Context r100) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L16
            WeakReference<c> r101 = c.f321604d;     // Catch: Throwable -> L16
            if (r101 == null) goto L6;
            c r102 = r101.get();     // Catch: Throwable -> L16
        L7:
            if (r102 != null) goto L13;
            c.f321604d = new WeakReference(new c(r100));     // Catch: Throwable -> L16
            LinkedHashMap<Object, Object> r103 = f.f321612a;     // Catch: Throwable -> L16
            LinkedHashMap<Object, Object> r104 = f.f321612a;     // Catch: Throwable -> L16
            WeakReference<c> r105 = c.f321604d;     // Catch: Throwable -> L16
            if (r105 == null) goto L11;
            c r106 = r105.get();     // Catch: Throwable -> L16
        L12:
            Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L16
            r104.put(r106, null);     // Catch: Throwable -> L16
            goto L13
        L11:
            r106 = null;
        L13:
            WeakReference<c> r107 = c.f321604d;     // Catch: Throwable -> L16
            Intrinsics.checkNotNull(r107);     // Catch: Throwable -> L16
            c r108 = r107.get();     // Catch: Throwable -> L16
            Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L16
            c r109 = r108;     // Catch: Throwable -> L16
            monitor-exit(this);
            return r109;
        L6:
            r102 = null;
        L16:
            th = move-exception;
            throw th;
        }
    }

    static {
        f321603c = new a();
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = String.valueOf(r100.getExternalCacheDir());
        this.f321606b = InferenceHelper.getVaildParams();
        this.f321605a = InferenceHelper.initModel(r100.getAssets(), 1, 0, r101, this.f321606b);
    }

    public final Result a(Context r110, Bitmap r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, SimplayerImageStrategy.RESULT_BITMAP);
        Params r100 = InferenceHelper.getVaildParams();
        Params r101 = this.f321606b;
        int r102 = 1;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        boolean r104 = !r103;
        if (r101 != null) goto L11;
    L13:
        boolean r105 = false;
    L14:
        boolean r106 = !r105;
        if (r101 != null) goto L17;
    L19:
        boolean r107 = false;
    L20:
        boolean r108 = !r107;
        if (r101 != null) goto L23;
    L25:
        boolean r109 = false;
    L26:
        boolean r112 = !r109;
        if (r101 != null) goto L29;
    L31:
        boolean r113 = false;
    L32:
        boolean r114 = !r113;
        if (r104 == true) goto L40;
        if (r106 == true) goto L40;
        if (r108 == true) goto L40;
        if (r114 == true) goto L40;
        if (r112 == true) goto L40;
        boolean r115 = false;
    L41:
        this.f321606b = r100;
        if (this.f321605a != null) goto L44;
        this.f321605a = InferenceHelper.initModel(r110.getAssets(), 1, 0, String.valueOf(r110.getExternalCacheDir()), this.f321606b);
    L46:
        InferenceHelper r116 = this.f321605a;
        Params r117 = new Params();
        Params r118 = this.f321606b;
        if (r118 == null) goto L49;
        int r119 = r118.blur_status;
    L50:
        r117.blur_status = r119;
        if (r118 == null) goto L53;
        int r120 = r118.dark_status;
    L54:
        r117.dark_status = r120;
        if (r118 == null) goto L57;
        int r121 = r118.orientation_status;
    L58:
        r117.orientation_status = r121;
        if (r118 == null) goto L61;
        int r122 = r118.scene_status;
    L62:
        r117.scene_status = r122;
        if (r118 == null) goto L65;
        r102 = r118.questions_status;
    L65:
        r117.questions_status = r102;
        if (r116 != null) goto L68;
        return null;
    L68:
        return r116.runPredict(r111, r117);
    L61:
        r122 = 1;
        goto L62
    L57:
        r121 = 1;
        goto L58
    L53:
        r120 = 1;
        goto L54
    L49:
        r119 = 1;
        goto L50
    L44:
        if (r115 == false) goto L46;
        String r123 = String.valueOf(r110.getExternalCacheDir());
        this.f321605a = null;
        this.f321605a = InferenceHelper.initModel(r110.getAssets(), 1, 0, r123, this.f321606b);
    L40:
        r115 = true;
        goto L41
    L29:
        if (r100.questions_status != r101.questions_status) goto L31;
        r113 = true;
        goto L32
    L23:
        if (r100.scene_status != r101.scene_status) goto L25;
        r109 = true;
        goto L26
    L17:
        if (r100.orientation_status != r101.orientation_status) goto L19;
        r107 = true;
        goto L20
    L11:
        if (r100.dark_status != r101.dark_status) goto L13;
        r105 = true;
        goto L14
    L5:
        if (r100.blur_status != r101.blur_status) goto L7;
        r103 = true;
        goto L8
    }
}
