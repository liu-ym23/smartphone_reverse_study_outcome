package pf0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.model.interact.OrderSingItemAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f528836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f528837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f528838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IBaseUser f528839e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f528835a, r101.f528835a) == true) goto L8;
        return false;
    L8:
        if (this.f528836b == r101.f528836b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f528837c, r101.f528837c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528838d, r101.f528838d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f528839e, r101.f528839e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f528835a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f528836b) * 31;
        Integer r104 = this.f528837c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f528838d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        IBaseUser r110 = this.f528839e;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "userId:" + this.f528835a + ",gold:" + this.f528836b + ",action:" + this.f528837c + ",increase:" + this.f528838d;
    }

    public a(String r100, int r101, Integer r102, Integer r103, IBaseUser r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r102 = Integer.valueOf(OrderSingItemAction.ORDER_SING_ACTION_UNKNOWN.getValue());
    L6:
        if ((r105 & 8) == 0) goto L9;
        r103 = 0;
    L9:
        if ((r105 & 16) == 0) goto L11;
        r104 = null;
    L11:
        this.f528835a = r100;
        this.f528836b = r101;
        this.f528837c = r102;
        this.f528838d = r103;
        this.f528839e = r104;
    }
}
