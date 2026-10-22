package o91;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.UserInfoFlipperLayout;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.list.UserTabList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import s91.f;
import w91.e;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements s91.a<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f522455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserInfoFlipperLayout f522456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f522457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w91.b f522458d;

    @Override // s91.a
    public final boolean a(Class<? extends b> r100) {
        Intrinsics.checkNotNullParameter(r100, "tabType");
        View r101 = this.f522456b.getCurDisplayView();
        if (r101 == null) goto L9;
        e r102 = com.bytedance.android.live.room.navi.userinfo_p.flipper.core.e.b(r101);
        if (r102 == null) goto L9;
        b r103 = r102.getTabType();
        if (r103 == null) goto L9;
        Class<?> r104 = r103.getClass();
    L11:
        return Intrinsics.areEqual(r104, r100);
    L9:
        r104 = null;
        goto L11
    }

    @Override // s91.a
    public final void c(f r100) {
        f r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        c r102 = this.f522455a;
        List r103 = this.f522457c;
        w91.b r104 = this.f522458d;
        UserInfoFlipperLayout r105 = this.f522456b;
        r102.getClass();
        ALogger.d("UserInfoTabManager", "change tab dataSet.the operate is " + r101.f541054d.getClass() + "\tthe tabData is " + r101.f541055e);
        s91.d r106 = r101.f541054d;
        if ((r106 instanceof s91.d.a) == false) goto L11;
        r103.add(r101.f541055e);
        if (r104 == null) goto L8;
        r104.notifyDataSetChange();
    L8:
        if (r101.f541051a == false) goto L21;
        r105.j(r103.indexOf(r101.f541055e), r101.f541052b);
        return;
    L21:
        return;
    L11:
        if ((r106 instanceof s91.d.c) == false) goto L16;
        r103.remove(r101.f541055e);
        if (r104 == null) goto L23;
        r104.notifyDataSetChange();
        return;
    L23:
        return;
    L16:
        if ((r106 instanceof s91.d.b) == false) goto L25;
        Integer r107 = r101.f541053c;
        if (r107 == null) goto L26;
        int r108 = r107.intValue();
        ALogger.d("UserInfoTabManager", "reload tab and the render type is " + r108);
        r102.b(r108);
        return;
    L26:
        return;
    }

    public d(c r100, UserInfoFlipperLayout r101, UserTabList r102, com.bytedance.android.live.room.navi.userinfo_p.flipper.core.b r103) {
        this.f522455a = r100;
        this.f522456b = r101;
        this.f522457c = r102;
        this.f522458d = r103;
    }
}
