package h05;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.more.protocol3.e;
import com.bytedance.ee.bear.more.protocol3.f;
import com.bytedance.ee.bear.more.protocol3.g;
import com.bytedance.ee.bear.more.protocol3.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends g {
    public final DocumentPluginHost c;

    /* JADX INFO: renamed from: h05.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0234a implements View.OnClickListener {
        public final /* synthetic */ a a;

        public ViewOnClickListenerC0234a(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            a r6 = this.a;
            Context r0 = r6.getHost().getHostFragment().getContext();
            if (r0 == null) goto L7;
            oj5.c r1 = r6.c();
            if (r1 == null) goto L7;
            int r2 = r05.a.a;
            r05.a.b.a(r0, r1.getToken(), r1.getType(), new d(r6));
        L7:
            r6.getHost().a();
            e05.a r7 = (e05.a) r6.c.getHostAbilityOrNull(e05.a.class);
            if (r7 == null) goto L11;
            r7.reportCcmApplicationDocsPluginClick();
            return;
        }
    }

    public static final class b implements e05.a.InterfaceC0215a {
        public b() {
        }
    }

    public final k a() {
        return h(f.l.c, new e.f(false, false, false), CollectionsKt.listOf(new c(this)), CollectionsKt.listOf(new h05.b(this)), new ViewOnClickListenerC0234a(this));
    }

    public final void create() {
        e05.a r0 = (e05.a) this.c.getHostAbilityOrNull(e05.a.class);
        if (r0 == null) goto L6;
        r0.observerAssociateDataChanged(new b());
        return;
    }

    public a(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        this.c = r2;
    }
}
