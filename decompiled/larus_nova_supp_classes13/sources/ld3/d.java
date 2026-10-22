package ld3;

import com.bytedance.android.ec.ab.opt.OptSetting;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.dataplatform.config.SettingPanel;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@OptSetting(business = "短视频商品内流UI更新")
public final class d {
    public static final /* synthetic */ int a = 0;

    @SettingPanel("新内流页-深色主题")
    public static final int a() {
        int r0 = p.a;
        Object r2 = 0;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r4 = jj4.b.b;     // Catch: Throwable -> L7
        Object r1 = jj4.a.a("video_inner_new_dark_background", Integer.class, r2, false);     // Catch: Throwable -> L7
        if (r1 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r1).intValue();
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r6) == true) goto L12;
        r2 = r6;
    L12:
        r1 = r2;
        goto L14
    }

    @SettingPanel("新内流页")
    public static final int b() {
        int r0 = p.a;
        Object r1 = 1;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r3 = jj4.b.b;     // Catch: Throwable -> L7
        Object r4 = jj4.a.a("video_inner_new", Integer.class, r1, false);     // Catch: Throwable -> L7
        if (r4 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r4).intValue();
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r6) == true) goto L12;
        r1 = r6;
    L12:
        r4 = r1;
        goto L14
    }

    @SettingPanel("新内流页-服务和卖点信息")
    public static final int c() {
        int r0 = p.a;
        Object r2 = 0;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r4 = jj4.b.b;     // Catch: Throwable -> L7
        Object r1 = jj4.a.a("video_inner_new_service_and_selling", Integer.class, r2, false);     // Catch: Throwable -> L7
        if (r1 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r1).intValue();
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r6) == true) goto L12;
        r2 = r6;
    L12:
        r1 = r2;
        goto L14
    }

    @SettingPanel("新内流页-服务信息")
    public static final int d() {
        int r0 = p.a;
        Object r1 = 1;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r3 = jj4.b.b;     // Catch: Throwable -> L7
        Object r4 = jj4.a.a("video_inner_new_service_only", Integer.class, r1, false);     // Catch: Throwable -> L7
        if (r4 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r4).intValue();
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r6) == true) goto L12;
        r1 = r6;
    L12:
        r4 = r1;
        goto L14
    }

    static {
    }

    public static boolean e(int r3) {
        int r0 = c.a;
        if (b() == 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L13;
        if (r3 == 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L14;
        return true;
    L14:
        return false;
    L9:
        r4 = false;
        goto L10
    L13:
        return false;
    L5:
        r1 = false;
        goto L6
    }
}
