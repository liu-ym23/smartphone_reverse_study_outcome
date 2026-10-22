package com.bytedance.ee.bear.wikiv2.browser.plugin;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.BasePluginV2;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.DelNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog.WikiDeleteConfirmDialog;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiDeletePlugin extends BasePluginV2 {
    private static final String TAG = "WikiDeletePlugin";
    private final CompositeDisposable disposables;
    private NetService netService;

    public class a implements WikiDeleteConfirmDialog.b {
        public final /* synthetic */ WikiDialogs a;
        public final /* synthetic */ WikiViewModel b;
        public final /* synthetic */ WikiDeletePlugin c;

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog.WikiDeleteConfirmDialog.b
        public final void onCancel() {
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog.WikiDeleteConfirmDialog.b
        public final void a() {
            this.c.deleteCurrentOnly(this.a, this.b.getSpaceId(), this.b.getWikiToken(), this.b.getObjToken(), this.b.getObjType(), false);
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog.WikiDeleteConfirmDialog.b
        public final void b() {
            this.c.deleteWithSub(this.a, this.b.getSpaceId(), this.b.getWikiToken(), this.b.getObjToken(), this.b.getObjType(), false);
        }

        public a(WikiDeletePlugin r1, WikiDialogs r2, WikiViewModel r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class b implements com.bytedance.ee.bear.wikiv2.browser.plugin.a {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ WikiDeletePlugin d;

        @Override // com.bytedance.ee.bear.wikiv2.browser.plugin.a
        public final void onDelete() {
            tt5.a.h(WikiDeletePlugin.TAG, "onDelete objToken: " + du5.b.k(this.a) + " wikiToken: " + du5.b.k(this.b));
            if (this.d.isVCFollow() == false) goto L5;
            return;
        L5:
            if (this.c == true) goto L15;
            FragmentActivity r0 = WikiDeletePlugin.access$000(this.d);
            if (((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).D4(this.b) == false) goto L10;
            return;
        L10:
            if (ForsetiHelper.s(this.d.getHost().getHostFragment()) == false) goto L12;
            r0.onBackPressed();
            return;
        L12:
            r0.finish();
            return;
        }

        public b(WikiDeletePlugin r1, String r2, String r3, boolean r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public class c implements com.bytedance.ee.bear.wikiv2.browser.plugin.a {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ WikiDeletePlugin b;

        @Override // com.bytedance.ee.bear.wikiv2.browser.plugin.a
        public final void onDelete() {
            if (this.b.isVCFollow() == false) goto L5;
            return;
        L5:
            if (this.a == true) goto L12;
            FragmentActivity r0 = WikiDeletePlugin.access$100(this.b);
            if (ForsetiHelper.s(this.b.getHost().getHostFragment()) == false) goto L9;
            r0.onBackPressed();
            return;
        L9:
            r0.finish();
            return;
        }

        public c(WikiDeletePlugin r1, boolean r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public WikiDeletePlugin() {
        this.disposables = new CompositeDisposable();
    }

    public void delete() {
        WikiViewModel r0 = g1.a(getHost());
        String r4 = r0.getSpaceId();
        String r5 = r0.getWikiToken();
        Boolean r6 = Boolean.valueOf(r0.isShortcut());
        String r7 = r0.getObjToken();
        String r8 = r0.getObjTypeValueString();
        if (r0.getWikiMeta() != null) goto L5;
    L7:
        boolean r9 = false;
    L8:
        gq5.d.d(new gq5.d.a("delete", "ccm_wiki_delete_confirm_view", r4, r5, r6, r7, r8, r9));
        WikiDialogs r11 = new WikiDialogs();
        r11.h(getContext(), r0.getWikiMeta(), r0.getWikiPerm(), new a(this, r11, r0), r0.isMyLib(), r0.getSpaceName());
        return;
    L5:
        if (r0.getWikiMeta().origin_is_external == false) goto L7;
        r9 = true;
        goto L8
    }

    public boolean isVCFollow() {
        PluginHost r0 = getHost();
        if (r0 == null) goto L10;
        e4 r1 = r0.getHostAbilityOrNull(e4.class);
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.getDocumentMetadata().getOpenSource() != DocsOpenSource.vc) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public static /* synthetic */ FragmentActivity access$000(WikiDeletePlugin r0) {
        return r0.getActivity();
    }

    public static /* synthetic */ FragmentActivity access$100(WikiDeletePlugin r0) {
        return r0.getActivity();
    }

    public void onAttachToHost(PluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        tt5.a.h(TAG, "onAttachToHost. ");
        this.netService = (NetService) r3.getUserComponent().a(NetService.class);
    }

    public void onDetachFromHost(PluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r1);
        this.disposables.clear();
    }

    public void deleteCurrentOnly(WikiDialogs r10, String r11, String r12, String r13, int r14, boolean r15) {
        this.disposables.add(t.a(this.netService, getActivity(), r10, r11, r12, r13, r14, new c(this, r15)));
    }

    public void deleteWithSub(final WikiDialogs r10, final String r11, final String r12, final String r13, final int r14, boolean r15) {
        CompositeDisposable r0 = this.disposables;
        NetService r1 = this.netService;
        final FragmentActivity r8 = getActivity();
        final b r7 = new b(this, r13, r12, r15);
        Flowable r16 = new DelNodePuller(r1).d(new DelNodePuller.Params(r11, r12, String.valueOf(System.currentTimeMillis()))).doOnSubscribe(new q(r10, r8));
        Objects.requireNonNull(r10);
        r0.add(r16.doFinally(new n(r10)).subscribe(new r(r14, r13, r12, r8, r7), new s(r14, r10, r8, r12, r11)));
    }
}
