package tq5;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.wikiv2.wikitreev2.move.WikiMovToFragment;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ WikiMovToFragment a;

    public f(WikiMovToFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        com.bytedance.ee.bear.list.move.b r8 = (com.bytedance.ee.bear.list.move.b) r7;
        Intrinsics.checkNotNullParameter(r8, "state");
        tt5.a.h("Wiki_WikiMovToFragment", "getApplyState()...state = " + r8);
        if (r8.a != 1) goto L21;
        WikiMovToFragment r0 = this.a;
        String r3 = r8.b;
        String r9 = r8.c;
        int r4 = WikiMovToFragment.x;
        r0.getClass();
        tt5.a.h("Wiki_WikiMovToFragment", "finishWhenApplySuccess() called with: wikiToken = " + du5.b.k(r3) + ", oldToken = " + du5.b.k(r9));
        com.bytedance.ee.bear.route.h r1 = (com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
        if (TextUtils.isEmpty(r3) == true) goto L13;
        if (r1.Xb(r9) == false) goto L13;
        com.suite.lark.component.navroute.forseti.g r2 = com.suite.lark.component.navroute.forseti.f.b(r0);
        if (r2 == null) goto L11;
        r2.c(103, new Bundle());
    L11:
        r1.Pb(r9, com.bytedance.ee.bear.route.c.c(r3, s45.p.a().A9(DocumentType.WIKI_NAME, r3), com.bytedance.ee.bear.route.c.b(r9), com.bytedance.ee.bear.route.c.a(r3)), true);
        return;
    L13:
        if (ForsetiHelper.s(r0) == false) goto L17;
        com.suite.lark.component.navroute.forseti.g r10 = com.suite.lark.component.navroute.forseti.f.b(r0);
        if (r10 == null) goto L23;
        Bundle r5 = new Bundle();
        r5.putString("move_wiki_token", r3);
        Unit r6 = Unit.INSTANCE;
        r10.c(100, r5);
        return;
    L23:
        return;
    L17:
        FragmentActivity r11 = r0.getActivity();
        if (r11 == null) goto L25;
        r11.getIntent().putExtra("move_wiki_token", r3);
        r11.setResult(100, r11.getIntent());
        r11.finish();
        return;
    L25:
        return;
    }
}
