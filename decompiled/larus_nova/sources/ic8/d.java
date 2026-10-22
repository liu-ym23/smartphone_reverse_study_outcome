package ic8;

import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f489181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<f, Unit> f489182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<f, Unit> f489183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f489184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f489185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function5<nr9.g, String, String, String, Message, Unit> f489186f;

    public d() {
        this(false, null, null, false, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f489181a == r101.f489181a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f489182b, r101.f489182b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f489183c, r101.f489183c) == true) goto L18;
        return false;
    L18:
        if (this.f489184d == r101.f489184d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f489185e, r101.f489185e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f489186f, r101.f489186f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f489181a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((r101 * 31) + this.f489182b.hashCode()) * 31) + this.f489183c.hashCode()) * 31;
        if (this.f489184d == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (((r102 + r100) * 31) + this.f489185e.hashCode()) * 31;
        Function5<nr9.g, String, String, String, Message, Unit> r104 = this.f489186f;
        if (r104 != null) goto L13;
        int r105 = 0;
    L15:
        return r103 + r105;
    L13:
        r105 = r104.hashCode();
        goto L15
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "AIEditParams(showAiEditFunction=" + this.f489181a + ", toAiEditFunctionPage=" + this.f489182b + ", onAiEditFunctionActionShown=" + this.f489183c + ", showVideoExtendFunction=" + this.f489184d + ", onVideoExtendFunctionActionShown=" + this.f489185e + ", toVideoExtendPage=" + this.f489186f + ')';
    }

    public static d a(d r100, Function1 r110, Function5 r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        boolean r101 = r100.f489181a;
    L7:
        if ((r112 & 2) == 0) goto L9;
        r110 = r100.f489182b;
    L9:
        Function1 r102 = r110;
        if ((r112 & 4) == 0) goto L12;
        Function1<f, Unit> r103 = r100.f489183c;
    L14:
        if ((r112 & 8) == 0) goto L16;
        boolean r104 = r100.f489184d;
    L18:
        if ((r112 & 16) == 0) goto L20;
        Function0<Unit> r105 = r100.f489185e;
    L22:
        if ((r112 & 32) == 0) goto L24;
        r111 = r100.f489186f;
    L24:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "toAiEditFunctionPage");
        Intrinsics.checkNotNullParameter(r103, "onAiEditFunctionActionShown");
        Intrinsics.checkNotNullParameter(r105, "onVideoExtendFunctionActionShown");
        return new d(r101, r102, r103, r104, r105, r111);
    L20:
        r105 = null;
        goto L22
    L16:
        r104 = false;
        goto L18
    L12:
        r103 = null;
        goto L14
    L5:
        r101 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(boolean r100, Function1<? super f, Unit> r101, Function1<? super f, Unit> r102, boolean r103, Function0<Unit> r104, Function5<? super nr9.g, ? super String, ? super String, ? super String, ? super Message, Unit> r105) {
        Intrinsics.checkNotNullParameter(r101, "toAiEditFunctionPage");
        Intrinsics.checkNotNullParameter(r102, "onAiEditFunctionActionShown");
        Intrinsics.checkNotNullParameter(r104, "onVideoExtendFunctionActionShown");
        this.f489181a = r100;
        this.f489182b = r101;
        this.f489183c = r102;
        this.f489184d = r103;
        this.f489185e = r104;
        this.f489186f = r105;
    }

    public /* synthetic */ d(boolean r100, Function1 r101, Function1 r102, boolean r103, Function0 r110, jy9.p r111, int r112) {
        boolean r104 = false;
        if ((r112 & 1) == 0) goto L5;
        boolean r105 = false;
    L7:
        if ((r112 & 2) == 0) goto L9;
        r101 = new a();
    L9:
        Function1 r106 = r101;
        if ((r112 & 4) == 0) goto L12;
        r102 = new b();
    L12:
        Function1 r107 = r102;
        if ((r112 & 8) != 0) goto L17;
        r104 = r103;
    L17:
        if ((r112 & 16) == 0) goto L19;
        r110 = new c();
    L19:
        Function0 r108 = r110;
        if ((r112 & 32) == 0) goto L22;
        r111 = null;
    L22:
        boolean r109 = r105;
        boolean r113 = r104;
        this(r109, r106, r107, r113, r108, r111);
        return;
    L5:
        r105 = r100;
        goto L7
    }
}
