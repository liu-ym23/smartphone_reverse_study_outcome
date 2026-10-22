package ld3;

import com.bytedance.android.ec.ab.opt.OptSetting;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.dataplatform.config.SettingPanel;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@OptSetting(business = "短视频商品内流UI更新")
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f508688a = 0;

    @SettingPanel("新内流页-深色主题")
    public static final int a() {
        int r100 = p.f45243a;
        Object r101 = 0;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("video_inner_new_dark_background", Integer.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r104).intValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("新内流页")
    public static final int b() {
        int r100 = p.f45243a;
        Object r101 = 1;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("video_inner_new", Integer.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r104).intValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("新内流页-服务和卖点信息")
    public static final int c() {
        int r100 = p.f45243a;
        Object r101 = 0;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("video_inner_new_service_and_selling", Integer.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r104).intValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    @SettingPanel("新内流页-服务信息")
    public static final int d() {
        int r100 = p.f45243a;
        Object r101 = 1;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r103 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r104 = jj4.a.a("video_inner_new_service_only", Integer.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r104).intValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }

    static {
    }

    public static boolean e(int r100) {
        int r101 = c.f508687a;
        if (b() == 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L13;
        if (r100 == 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L14;
        return true;
    L14:
        return false;
    L9:
        r103 = false;
        goto L10
    L13:
        return false;
    L5:
        r102 = false;
        goto L6
    }
}
