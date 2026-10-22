package xna;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Function2<? super String, ? super String, Unit> f564652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Function2<? super String, ? super String, Unit> f564653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Function2<? super String, ? super String, Unit> f564654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Function2<? super String, ? super String, Unit> f564655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Function2<? super String, ? super String, Unit> f564656e;

    static {
    }

    @JvmStatic
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter("ObricInteractionService2", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        Function2<? super String, ? super String, Unit> r101 = f564655d;
        if (r101 == null) goto L6;
        r101.invoke("SVA-ObricInteractionService2", r100);
        return;
    }

    @JvmStatic
    public static final void d(String r100) {
        Intrinsics.checkNotNullParameter("ObricInteractionService2", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        Function2<? super String, ? super String, Unit> r101 = f564654c;
        if (r101 == null) goto L6;
        r101.invoke("SVA-ObricInteractionService2", r100);
        return;
    }

    @JvmStatic
    public static final void e(String r100) {
        Intrinsics.checkNotNullParameter("ObricInteractionService2", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        Function2<? super String, ? super String, Unit> r101 = f564653b;
        if (r101 == null) goto L6;
        r101.invoke("SVA-ObricInteractionService2", r100);
        return;
    }

    @JvmStatic
    public static final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Function2<? super String, ? super String, Unit> r102 = f564656e;
        if (r102 == null) goto L6;
        r102.invoke("SVA-".concat(r100), r101);
        return;
    }

    @JvmStatic
    public static final void c(Function2<? super String, ? super String, Unit> r100, Function2<? super String, ? super String, Unit> r101, Function2<? super String, ? super String, Unit> r102, Function2<? super String, ? super String, Unit> r103, Function2<? super String, ? super String, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r101, "d");
        Intrinsics.checkNotNullParameter(r102, RXScreenCaptureService.KEY_INDEX);
        Intrinsics.checkNotNullParameter(r103, "w");
        Intrinsics.checkNotNullParameter(r104, "e");
        f564654c = r100;
        f564652a = r101;
        f564656e = r102;
        f564653b = r103;
        f564655d = r104;
    }
}
