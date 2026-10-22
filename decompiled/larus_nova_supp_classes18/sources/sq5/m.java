package sq5;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.quoto.FullQuotoConfig;
import com.bytedance.ee.bear.quoto.SingleFileQuotaConfig;
import com.bytedance.ee.bear.quoto.t;
import com.bytedance.ee.bear.wikiv2.wikitreev2.makecopy.WikiMakeCopyToWikiViewModel;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements td5.d {
    public final Fragment a;
    public final String b;
    public final int c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final Long l;
    public final boolean m;
    public final a n;
    public final WikiDialogs o;
    public Disposable p;
    public final Bundle q;

    @Override // td5.d
    public final void destroy() {
        tt5.a.h("WikiMakeCopyToWikiCommand", "destroy()...");
        Disposable r0 = this.p;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        this.p.dispose();
        return;
    }

    @Override // td5.d
    public final void execute() {
        tt5.a.h("WikiMakeCopyToWikiCommand", "doCommand()...");
        Disposable r0 = this.p;
        if (r0 != null) goto L5;
    L7:
        WikiMakeCopyToWikiViewModel r1 = WikiMakeCopyToWikiViewModel.get(this.a);
        final Context r2 = this.a.getContext();
        boolean r3 = this.m;
        if (r3 == false) goto L10;
        String r4 = this.j;
    L11:
        final String r11 = r4;
        if (r3 == false) goto L14;
        String r5 = this.k;
    L15:
        int r6 = this.c;
        Flowable r7 = r1.makeCopy(new f(r2, r11, r6, r5, this.e, this.f, this.h, this.g)).doOnSubscribe(new j(this, r2));
        WikiDialogs r8 = this.o;
        Objects.requireNonNull(r8);
        this.p = r7.doFinally(new com.bytedance.ee.bear.wikiv2.browser.plugin.n(r8)).subscribe(new k(this), new l(this, r2, r11));
        return;
    L14:
        r5 = this.d;
        goto L15
    L10:
        r4 = this.b;
        goto L11
    L5:
        if (r0.isDisposed() == true) goto L7;
        this.p.dispose();
        goto L7
    }

    public m(e r3) {
        this.o = new WikiDialogs();
        this.a = r3.a;
        this.q = r3.b;
        this.b = r3.c;
        this.c = r3.d;
        this.d = r3.e;
        this.e = r3.f;
        this.f = r3.g;
        this.h = r3.i;
        this.g = r3.h;
        this.i = r3.j;
        this.j = r3.k;
        this.k = r3.l;
        this.l = Long.valueOf(r3.m);
        this.m = r3.n;
        this.n = r3.o;
    }

    public final void a(FragmentActivity r9, Throwable r10) {
        t r1 = (t) org.koin.java.a.a(t.class);
        if (r9 != null) goto L5;
    L7:
        if (r9 != null) goto L9;
    L11:
        if (r9 != null) goto L13;
    L15:
        if (r9 != null) goto L17;
    L21:
        if (r9 != null) goto L23;
    L25:
        WikiDialogs r0 = this.o;
        Map<String, Integer> r2 = q.a;
        int r11 = q.b(WikiAction.MAKE_COPY, r10);
        r0.getClass();
        WikiDialogs.j(r9, r11);
        return;
    L23:
        if (r1.o(ax4.d.a(r10)) == false) goto L25;
        r1.a(r10, r9);
        return;
    L17:
        if (r1.g(ax4.d.a(r10)) == false) goto L21;
        if (this.c != sbb.e.l.b) goto L21;
        r1.f(r9, SingleFileQuotaConfig.DUPLICATE, this.l);
        return;
    L13:
        if (r1.s(ax4.d.a(r10)) == false) goto L15;
        r1.c(this.a.getActivity(), null, null, false, true, "");
        return;
    L9:
        if (r1.k(ax4.d.a(r10)) == false) goto L11;
        r1.c(this.a.getActivity(), null, null, false, false, "");
        return;
    L5:
        if (r1.q(ax4.d.a(r10)) == false) goto L7;
        r1.j(r9, FullQuotoConfig.MAKE_COPY);
    }
}
