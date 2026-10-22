package fq5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiTreeMenuPlugin;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements Runnable {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ t b;
    public final /* synthetic */ g c;

    public final void a() {
        if (com.bytedance.ee.util.ui.b.a(this.a) == true) goto L5;
        return;
    L5:
        g r0 = this.c;
        t r1 = this.b;
        final FragmentActivity r2 = this.a;
        r0.getClass();
        View r3 = r1.getTitleBar().findMenuView(WikiTreeMenuPlugin.MENU_ID_WIKI_TREE_ACTION);
        if (r3 != null) goto L8;
        tt5.a.d("WikiTreeMenuOnBoarding", "show wiki tree onboarding failed, wikiTree == null");
        return;
    L8:
        final e r4 = new e(r0, r3);
        ((sk5.b) org.koin.java.a.a(sk5.b.class)).b().e().subscribe(new a(r4, r2), new b());
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(g r1, FragmentActivity r2, t r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
