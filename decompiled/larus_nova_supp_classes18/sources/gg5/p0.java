package gg5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.feed.v2.FeedPluginV2;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larksuite.component.universe_design.menu.PositionAlign;
import io.reactivex.Flowable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p0 implements View.OnClickListener {
    public final /* synthetic */ i0 a;

    public class a implements com.larksuite.component.universe_design.menu.g {
        public final /* synthetic */ com.larksuite.component.universe_design.menu.c[] a;
        public final /* synthetic */ p0 b;

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
            m r0 = this.b.a.m;
            r0.getClass();
            tt5.a.h("PanelViewModelV2", "read all...");
            FeedPluginV2.c r1 = r0.c;
            r1.getClass();
            tt5.a.h("FeedPluginV2", "feed readAll,   " + FeedPluginV2.access$1300(r1.h));
            if (FeedPluginV2.access$1300(r1.h) == null) goto L5;
            FeedPluginV2.access$1700(r1.h);
        L6:
            bg5.a.h("read_all");
            com.larksuite.component.universe_design.menu.c r2 = this.a[0];
            if (r2 == null) goto L10;
            r2.a();
            return;
        L10:
            return;
        L5:
            tt5.a.h("FeedPluginV2", "mReadListener is null");
            goto L6
        }

        public final String getName() {
            if (Boolean.TRUE.equals(this.b.a.m.l.getValue()) == false) goto L7;
            return com.bytedance.ee.util.ui.n.x(this.b.a.a, 2131889195);
        L7:
            return com.bytedance.ee.util.ui.n.x(this.b.a.a, 2131889193);
        }

        public final boolean isEnabled() {
            return Boolean.TRUE.equals(this.b.a.m.l.getValue());
        }

        public a(p0 r1, com.larksuite.component.universe_design.menu.c[] r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements com.larksuite.component.universe_design.menu.g {
        public final /* synthetic */ com.larksuite.component.universe_design.menu.c[] a;
        public final /* synthetic */ p0 b;

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
            Boolean r0 = (Boolean) this.b.a.m.g.getValue();
            if (r0 == null) goto L12;
            final boolean r1 = !r0.booleanValue();
            uf5.r r2 = bg5.a.b;
            if (r1 == false) goto L7;
            String r3 = "remind";
        L8:
            bg5.a.h(r3);
            i0 r4 = this.b.a;
            final m r5 = r4.m;
            final FragmentActivity r6 = r4.a;
            if (r5.h == true) goto L12;
            r5.h = true;
            Toast.showLoading(r6, r6.getString(2131887769));
            tt5.a.h("PanelViewModelV2", "setRemindState " + r1);
            r5.a(Flowable.just(Boolean.TRUE).map(new h(r5, r1)).flatMap(new i()).subscribeOn(fo5.d.e()).observeOn(fo5.d.d()).doOnCancel(new j(r5)).subscribe(new k(r5, r1, r6), new l(r5, r6)));
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
            if (Boolean.TRUE.equals(this.b.a.m.g.getValue()) == false) goto L5;
            return 2131243943;
        L5:
            return 2131243945;
        }

        public final String getName() {
            boolean r0 = Boolean.TRUE.equals(this.b.a.m.g.getValue());
            FragmentActivity r1 = this.b.a.a;
            if (r0 == false) goto L5;
            int r2 = 2131889144;
        L7:
            return com.bytedance.ee.util.ui.n.x(r1, r2);
        L5:
            r2 = 2131889334;
            goto L7
        }

        public b(p0 r1, com.larksuite.component.universe_design.menu.c[] r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public p0(i0 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        com.larksuite.component.universe_design.menu.c.f r0 = new com.larksuite.component.universe_design.menu.c.f();
        ArrayList r1 = new ArrayList();
        boolean r2 = true;
        com.larksuite.component.universe_design.menu.c[] r3 = new com.larksuite.component.universe_design.menu.c[1];
        i0 r4 = this.a;
        if (r4.r == true) goto L5;
    L7:
        r2 = false;
    L8:
        if (r2 == false) goto L11;
        r1.add(new a(this, r3));
    L11:
        if (this.a.f() == false) goto L13;
        r1.add(new b(this, r3));
    L13:
        r0.c(80);
        r0.b(PositionAlign.END);
        r0.f(r1);
        com.larksuite.component.universe_design.menu.c r5 = r0.a();
        r3[0] = r5;
        Intrinsics.checkNotNullParameter(r8, "anchorView");
        r5.c(r8);
        return;
    L5:
        if (r4.m.d().isSupportReadAll() == false) goto L7;
        goto L7
    }
}
