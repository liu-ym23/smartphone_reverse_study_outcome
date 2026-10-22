package w81;

import com.bytedance.android.live.base.model.message.a4;
import com.bytedance.android.live.room.incentiveinfo.model.CarouselTabType;
import kotlin.jvm.internal.Intrinsics;
import tlc.d;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f558609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f558610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f558611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f558612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CarouselTabType f558613e;

    /* JADX INFO: renamed from: w81.a$a, reason: collision with other inner class name */
    public static final class C8080a {
    }

    static {
    }

    public final int hashCode() {
        return this.f558613e.hashCode();
    }

    public final String toString() {
        return "IncentiveInfoModel(carouselTabType=" + this.f558613e + ", messageData=" + this.f558609a + ')';
    }

    public a(CarouselTabType r100) {
        Intrinsics.checkNotNullParameter(r100, "carouselTabType");
        this.f558613e = r100;
        this.f558610b = Boolean.TRUE;
        this.f558612d = 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        Long r101 = null;
        if (r100 == null) goto L8;
        Class<?> r102 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(a.class, r102)) == false) goto L12;
        return false;
    L12:
        CarouselTabType r103 = this.f558613e;
        if ((r100 instanceof a) == true) goto L15;
        Object r104 = null;
    L16:
        a r105 = (a) r104;
        if (r105 == null) goto L19;
        CarouselTabType r106 = r105.f558613e;
    L20:
        if (r103 == r106) goto L22;
        return false;
    L22:
        d r107 = this.f558609a;
        if ((r107 instanceof a4) == true) goto L25;
        r107 = null;
    L25:
        a4 r108 = (a4) r107;
        if (r108 == null) goto L28;
        Long r109 = r108.G();
    L29:
        a r110 = (a) r100;
        if (r110 == null) goto L32;
        d r111 = r110.f558609a;
    L34:
        if ((r111 instanceof a4) == true) goto L36;
        r111 = null;
    L36:
        a4 r112 = (a4) r111;
        if (r112 == null) goto L40;
        r101 = r112.G();
    L40:
        if ((!Intrinsics.areEqual(r109, r101)) == false) goto L42;
        return false;
    L42:
        return true;
    L32:
        r111 = null;
        goto L34
    L28:
        r109 = null;
        goto L29
    L19:
        r106 = null;
        goto L20
    L15:
        r104 = r100;
        goto L16
    L8:
        r102 = null;
        goto L10
    }
}
