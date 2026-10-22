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

/* JADX INFO: loaded from: classes16.dex */
public final class a extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DocumentPluginHost f483436c;

    /* JADX INFO: renamed from: h05.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC6087a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f483437a;

        public ViewOnClickListenerC6087a(a r100) {
            this.f483437a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f483437a;
            Context r102 = r101.getHost().getHostFragment().getContext();
            if (r102 == null) goto L7;
            oj5.c r103 = r101.c();
            if (r103 == null) goto L7;
            int r104 = r05.a.f535453a;
            r05.a.b.a(r102, r103.getToken(), r103.getType(), new d(r101));
        L7:
            r101.getHost().a();
            e05.a r105 = (e05.a) r101.f483436c.getHostAbilityOrNull(e05.a.class);
            if (r105 == null) goto L11;
            r105.reportCcmApplicationDocsPluginClick();
            return;
        }
    }

    public static final class b implements e05.a.InterfaceC5726a {
        public b() {
        }
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final k a() {
        return h(f.l.f234871c, new e.f(false, false, false), CollectionsKt.listOf(new c(this)), CollectionsKt.listOf(new h05.b(this)), new ViewOnClickListenerC6087a(this));
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g, com.bytedance.ee.bear.more.protocol3.b
    public final void create() {
        e05.a r100 = (e05.a) this.f483436c.getHostAbilityOrNull(e05.a.class);
        if (r100 == null) goto L6;
        r100.observerAssociateDataChanged(new b());
        return;
    }

    public a(DocumentPluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        this.f483436c = r100;
    }
}
