package vc5;

import android.app.Activity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.homepage.navigation.NavigationEnum;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.compose.foundation.toast.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {

    /* JADX INFO: renamed from: vc5.a$a, reason: collision with other inner class name */
    public static final class C0320a implements UDToast.b {
        public final /* synthetic */ int a;
        public final /* synthetic */ h b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Function0<Unit> d;

        public final void a(b r3) {
            Intrinsics.checkNotNullParameter(r3, Notice.CLICK_TYPE_TOAST);
            if (this.a == 4) goto L5;
            this.b.u5(this.c);
        L10:
            Function0<Unit> r4 = this.d;
            if (r4 == null) goto L14;
            r4.invoke();
            return;
        L14:
            return;
        L5:
            if (qc5.a.h() == false) goto L7;
            int r5 = NavigationEnum.SIDEBAR_DRIVE.id;
        L8:
            this.b.w2("/list/space/activity").j("extra_destination", r5).e();
            goto L10
        L7:
            r5 = NavigationEnum.MY_SPACE.id;
            goto L8
        }

        public C0320a(int r1, h r2, String r3, Function0<Unit> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final void a(int r3, boolean r4, String r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r5, "folderUrl");
        h r0 = (h) org.koin.java.a.c(h.class, null, null, 6);
        Activity r1 = r0.getActivity();
        if (r1 != null) goto L6;
        return;
    L6:
        if (r4 == false) goto L8;
    L11:
        Toast.showSuccessText(r1, 2131887528);
        return;
    L8:
        if (AppInfoUtils.f().booleanValue() == true) goto L11;
        UDToast.a r7 = UDToast.build(r1);
        r7.b.e(2131887528);
        r7.d(Toast.getSuccessIcon());
        r7.b(2131887465, new C0320a(r3, r0, r5, r6));
        r7.h();
    }
}
