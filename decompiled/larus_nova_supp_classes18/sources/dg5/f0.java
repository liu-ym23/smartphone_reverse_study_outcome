package dg5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larksuite.component.universe_design.menu.PositionAlign;
import io.reactivex.Flowable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f0 implements View.OnClickListener {
    public final /* synthetic */ a0 a;

    public class a implements com.larksuite.component.universe_design.menu.g {
        public final /* synthetic */ com.larksuite.component.universe_design.menu.c[] a;
        public final /* synthetic */ f0 b;

        public final /* synthetic */ int b() {
            return 0;
        }

        public final /* synthetic */ int c() {
            return 2131108927;
        }

        public final /* synthetic */ void getDescription() {
        }

        public final int getIcon() {
            return 2131254251;
        }

        public final /* synthetic */ int getTextColor() {
            return 0;
        }

        public final void a() {
            a0 r0 = this.b.a;
            final d1 r1 = r0.l;
            final FragmentActivity r2 = r0.a;
            if (r1.j == true) goto L6;
            r1.j = true;
            tt5.a.h("PanelViewModel", "setReadAll... ");
            final long r3 = System.currentTimeMillis();
            r1.a(Flowable.just(Boolean.TRUE).map(new w0(r1, r3)).flatMap(new x0()).subscribeOn(fo5.d.e()).observeOn(fo5.d.d()).doOnCancel(new y0(r1)).subscribe(new z0(r1, r2), new a1(r1, r2)));
        L6:
            bg5.a.h("read_all");
            com.larksuite.component.universe_design.menu.c r4 = this.a[0];
            if (r4 == null) goto L10;
            r4.a();
            return;
        }

        public final String getName() {
            if (Boolean.TRUE.equals(this.b.a.l.p.getValue()) == false) goto L7;
            return com.bytedance.ee.util.ui.n.x(this.b.a.a, 2131889195);
        L7:
            return com.bytedance.ee.util.ui.n.x(this.b.a.a, 2131889193);
        }

        public final boolean isEnabled() {
            return Boolean.TRUE.equals(this.b.a.l.p.getValue());
        }

        public a(f0 r1, com.larksuite.component.universe_design.menu.c[] r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements com.larksuite.component.universe_design.menu.g {
        public final /* synthetic */ com.larksuite.component.universe_design.menu.c[] a;
        public final /* synthetic */ f0 b;

        public final /* synthetic */ int b() {
            return 0;
        }

        public final /* synthetic */ int c() {
            return 2131108927;
        }

        public final /* synthetic */ void getDescription() {
        }

        public final /* synthetic */ int getTextColor() {
            return 0;
        }

        public final /* synthetic */ boolean isEnabled() {
            return true;
        }

        public final void a() {
            Boolean r0 = (Boolean) this.b.a.l.h.getValue();
            if (r0 == null) goto L12;
            final boolean r1 = !r0.booleanValue();
            uf5.r r2 = bg5.a.b;
            if (r1 == false) goto L7;
            String r3 = "remind";
        L8:
            bg5.a.h(r3);
            a0 r4 = this.b.a;
            final d1 r5 = r4.l;
            final FragmentActivity r6 = r4.a;
            if (r5.i == true) goto L12;
            r5.i = true;
            Toast.showLoading(r6, r6.getString(2131887769));
            tt5.a.h("PanelViewModel", "setRemindState " + r1);
            r5.a(Flowable.just(Boolean.TRUE).map(new b1(r5, r1)).flatMap(new c1()).subscribeOn(fo5.d.e()).observeOn(fo5.d.d()).doOnCancel(new l0(r5)).subscribe(new m0(r5, r1, r6), new n0(r5, r6)));
            goto L12
        L7:
            r3 = "mute";
        L12:
            com.larksuite.component.universe_design.menu.c r7 = this.a[0];
            if (r7 == null) goto L16;
            r7.a();
            return;
        }

        public final int getIcon() {
            if (Boolean.TRUE.equals(this.b.a.l.h.getValue()) == false) goto L5;
            return 2131243943;
        L5:
            return 2131243945;
        }

        public final String getName() {
            boolean r0 = Boolean.TRUE.equals(this.b.a.l.h.getValue());
            FragmentActivity r1 = this.b.a.a;
            if (r0 == false) goto L5;
            int r2 = 2131889144;
        L7:
            return com.bytedance.ee.util.ui.n.x(r1, r2);
        L5:
            r2 = 2131889334;
            goto L7
        }

        public b(f0 r1, com.larksuite.component.universe_design.menu.c[] r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public f0(a0 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        com.larksuite.component.universe_design.menu.c.f r0 = new com.larksuite.component.universe_design.menu.c.f();
        ArrayList r1 = new ArrayList();
        com.larksuite.component.universe_design.menu.c[] r2 = new com.larksuite.component.universe_design.menu.c[1];
        if (this.a.q == false) goto L6;
        r1.add(new a(this, r2));
    L6:
        if (this.a.h() == false) goto L8;
        r1.add(new b(this, r2));
    L8:
        r0.c(80);
        r0.b(PositionAlign.END);
        r0.f(r1);
        com.larksuite.component.universe_design.menu.c r3 = r0.a();
        r2[0] = r3;
        Intrinsics.checkNotNullParameter(r5, "anchorView");
        r3.c(r5);
    }
}
