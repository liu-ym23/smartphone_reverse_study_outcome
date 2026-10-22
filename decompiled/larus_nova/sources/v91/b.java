package v91;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.UserInfoFlipperLayout;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.core.BaseTabFlipper;
import kotlin.jvm.internal.Intrinsics;
import w91.f;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements v91.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f553771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BaseTabFlipper f553772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f553773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BaseTabFlipper f553774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BaseTabFlipper f553775e;

    public static final class a {
    }

    static {
    }

    public static void c(String r100) {
        ALogger.d("UserInfoTabFlipSynchronizer", "no need to sync tab because: " + r100);
    }

    @Override // v91.a
    public final boolean a(BaseTabFlipper r110) {
        Intrinsics.checkNotNullParameter(r110, "wannaSyncFlipper");
        if (this.f553773c == true) goto L5;
        return false;
    L5:
        ALogger.d("UserInfoTabFlipSynchronizer", "judge is need to sync tab");
        if (Intrinsics.areEqual(this.f553774d, r110) == false) goto L8;
        BaseTabFlipper r100 = this.f553775e;
    L9:
        w91.b<? extends Object, ? extends f> r101 = r100.getAdapter();
        w91.b<? extends Object, ? extends f> r102 = null;
        if ((r101 instanceof w91.b) == true) goto L12;
        r101 = null;
    L12:
        if (r101 != null) goto L15;
        c("the compare flipper layout's adapter is null");
        return false;
    L15:
        w91.b<? extends Object, ? extends f> r103 = r110.getAdapter();
        if ((r103 instanceof w91.b) == false) goto L19;
        r102 = r103;
    L19:
        if (r102 != null) goto L22;
        c("the flipper layout's adapter is null");
        return false;
    L22:
        View r104 = r110.getCurDisplayView();
        if (r104 == null) goto L25;
        int r111 = r110.f(r104);
    L26:
        int r105 = r102.getItemSize();
        if (r111 <= 0) goto L30;
        r105 = r105 - 1;
    L30:
        if (r105 == r101.getItemSize()) goto L33;
        c("the flipper tab item size is not same");
        return false;
    L33:
        int r106 = 0;
    L35:
        if (r106 >= r105) goto L48;
        if (r111 == (-1)) goto L39;
        if (r106 < r111) goto L39;
        int r107 = r106 + 1;
    L60:
    L45:
        e = move-exception;
        c("compare tab data fail.error:" + e);
        ALogger.e("UserInfoTabFlipSynchronizer", e);
        return false;
    L41:
        if ((true ^ Intrinsics.areEqual(r101.getData(r106), r102.getData(r107))) == true) goto L42;
        r106 = r106 + 1;
        goto L35
    L42:
        c("the flipper data is not match");     // Catch: Exception -> L45
        return false;
    L39:
        r107 = r106;
        goto L60
    L48:
        View r112 = r100.getCurDisplayView();
        if (r112 == null) goto L58;
        this.f553771a = Integer.valueOf(r100.f(r112) + 1);
        this.f553772b = r100;
        StringBuilder r113 = new StringBuilder("should sync:");
        if (this.f553771a == null) goto L53;
        boolean r108 = true;
    L54:
        r113.append(r108);
        ALogger.d("UserInfoTabFlipSynchronizer", r113.toString());
        if (this.f553771a == null) goto L64;
        return true;
    L64:
        return false;
    L53:
        r108 = false;
        goto L54
    L58:
        c("the compare flipper does not display a tab now");
        return false;
    L25:
        r111 = -1;
        goto L26
    L8:
        r100 = this.f553774d;
        goto L9
    }

    @Override // v91.a
    public final void b(BaseTabFlipper r100) {
        Intrinsics.checkNotNullParameter(r100, "wannaSyncFlipper");
        BaseTabFlipper r101 = this.f553772b;
        Integer r102 = this.f553771a;
        this.f553772b = null;
        this.f553771a = null;
        if (r102 == null) goto L8;
        int r103 = r102.intValue();
        ALogger.i("UserInfoTabFlipSynchronizer", "do sync tab,target pos is" + r103);
        if (r101 == null) goto L7;
        r101.j(r103, true);
    L7:
        r100.j(r103, true);
        return;
    L8:
        ALogger.i("UserInfoTabFlipSynchronizer", "do sync tab,just show next");
        r100.i();
    }

    public b(boolean r100, UserInfoFlipperLayout r101, UserInfoFlipperLayout r102) {
        Intrinsics.checkNotNullParameter(r101, "firstTab");
        Intrinsics.checkNotNullParameter(r102, "second");
        this.f553773c = r100;
        this.f553774d = r101;
        this.f553775e = r102;
    }
}
