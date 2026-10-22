package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeObserver;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.PinPuller$Params;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.PinPuller$Result;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.UnPinPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u000eJ\u0018\u0010\u0015\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u000eJ\"\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/browser/plugin/WikiPinPlugin;", "Lcom/bytedance/ee/bear/wikiv2/browser/plugin/WikiBasePlugin;", "<init>", "()V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "showSuccessText", "stringRes", "", "text", "", "showFailureText", "pin", WikiFolderPushPlugin.WIKI_TOKEN, "documentType", "unpin", "notifyDoPin", "wikiViewModel", "Lcom/bytedance/ee/bear/wikiv2/browser/plugin/WikiViewModel;", "switchOn", "", "onDetachFromHost", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiPinPlugin extends WikiBasePlugin {
    public static final a Companion = null;
    public static final String TAG = "WikiPinPlugin";
    private final CompositeDisposable disposables;
    private NetService netService;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ WikiPinPlugin a;
        public final /* synthetic */ WikiViewModel b;
        public final /* synthetic */ String c;

        public b(WikiPinPlugin r1, WikiViewModel r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            PinPuller$Result r5 = (PinPuller$Result) r4;
            WikiPinPlugin.access$notifyDoPin(this.a, this.b, this.c, true);
            String r6 = xo5.a.c(WikiPinPlugin.access$getContext(this.a), 2131889648, "SidebarSection", WikiPinPlugin.access$getContext(this.a).getString(2131889647));
            if (qc5.a.h() == false) goto L5;
            WikiPinPlugin r0 = this.a;
            Intrinsics.checkNotNull(r6);
            WikiPinPlugin.access$showSuccessText(r0, r6);
            return;
        L5:
            WikiPinPlugin.access$showSuccessText(this.a, 2131887877);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ WikiPinPlugin a;

        public c(WikiPinPlugin r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            tt5.a.d(WikiPinPlugin.TAG, "wiki pin fail. " + r4);
            if (ax4.d.b(r4, 4001) == false) goto L5;
            WikiPinPlugin.access$showFailureText(this.a, 2131887875);
            return;
        L5:
            WikiPinPlugin.access$showFailureText(this.a, 2131887874);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ WikiPinPlugin a;
        public final /* synthetic */ WikiViewModel b;
        public final /* synthetic */ String c;

        public d(WikiPinPlugin r1, WikiViewModel r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            UnPinPuller.Result r5 = (UnPinPuller.Result) r4;
            WikiPinPlugin.access$notifyDoPin(this.a, this.b, this.c, false);
            String r6 = xo5.a.c(WikiPinPlugin.access$getContext(this.a), 2131889644, "SidebarSection", WikiPinPlugin.access$getContext(this.a).getString(2131889647));
            if (qc5.a.h() == false) goto L5;
            WikiPinPlugin r0 = this.a;
            Intrinsics.checkNotNull(r6);
            WikiPinPlugin.access$showSuccessText(r0, r6);
            return;
        L5:
            WikiPinPlugin.access$showSuccessText(this.a, 2131887960);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ WikiPinPlugin a;

        public e(WikiPinPlugin r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            tt5.a.d(WikiPinPlugin.TAG, "wiki unpin fail. " + ((Throwable) r3));
            WikiPinPlugin.access$showFailureText(this.a, 2131887959);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.wikiv2.browser.plugin.WikiBasePlugin
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public WikiPinPlugin() {
        this.disposables = new CompositeDisposable();
    }

    public static final /* synthetic */ Context access$getContext(WikiPinPlugin r0) {
        return r0.getContext();
    }

    private final void showFailureText(int r4) {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == true) goto L7;
        return;
    L7:
        Toast.showFailureText(r0, r0.getString(r4), 0);
    }

    private final void showSuccessText(int r4) {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == true) goto L7;
        return;
    L7:
        Toast.showSuccessText(r0, r0.getString(r4), 0);
    }

    public void onAttachToHost(PluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        tt5.a.h(TAG, "onAttachToHost. ");
        if (r3 == null) goto L7;
        vo5.a r4 = r3.getUserComponent();
        if (r4 == null) goto L7;
        NetService r5 = (NetService) r4.a(NetService.class);
    L8:
        this.netService = r5;
        return;
    L7:
        r5 = null;
        goto L8
    }

    public void onDetachFromHost(PluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r2);
        tt5.a.h(TAG, "onDetachFromHost. ");
        this.disposables.clear();
    }

    private final void showSuccessText(String r4) {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == true) goto L7;
        return;
    L7:
        Toast.showSuccessText(r0, r4, 0);
    }

    public static final /* synthetic */ void access$showFailureText(WikiPinPlugin r0, int r1) {
        r0.showFailureText(r1);
    }

    public static final /* synthetic */ void access$showSuccessText(WikiPinPlugin r0, int r1) {
        r0.showSuccessText(r1);
    }

    public final void pin(String r13, int r14) {
        WikiViewModel r0 = wikiViewModel();
        String r4 = r0.getSpaceId();
        String r5 = r0.getWikiToken();
        TreeNode r1 = r0.getWikiMeta();
        if (r1 == null) goto L5;
        boolean r2 = r1.isShortcut();
    L6:
        Boolean r7 = Boolean.valueOf(r2);
        String r8 = r0.getObjToken();
        String r9 = r0.getObjTypeValueString();
        TreeNode r3 = r0.getWikiMeta();
        if (r3 == null) goto L9;
        boolean r11 = r3.origin_is_external;
    L10:
        gq5.d.d(new gq5.d.a("add_to_quickaccess", "none", r4, r5, r7, r8, r9, r11));
        NetService r6 = this.netService;
        if (r6 == null) goto L14;
        this.disposables.add(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.l0.d(new PinPuller$Params(r13, r14), r6).subscribe(new b(this, r0, r13), new c(this)));
        return;
    L14:
        return;
    L9:
        r11 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public final void unpin(String r13, int r14) {
        WikiViewModel r0 = wikiViewModel();
        String r4 = r0.getSpaceId();
        String r5 = r0.getWikiToken();
        TreeNode r1 = r0.getWikiMeta();
        if (r1 == null) goto L5;
        boolean r2 = r1.isShortcut();
    L6:
        Boolean r7 = Boolean.valueOf(r2);
        String r8 = r0.getObjToken();
        String r9 = r0.getObjTypeValueString();
        TreeNode r3 = r0.getWikiMeta();
        if (r3 == null) goto L9;
        boolean r11 = r3.origin_is_external;
    L10:
        gq5.d.d(new gq5.d.a("remove_from_quickaccess", "none", r4, r5, r7, r8, r9, r11));
        this.disposables.add(new UnPinPuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).c(new UnPinPuller.Params(r13, r14)).subscribe(new d(this, r0, r13), new e(this)));
        return;
    L9:
        r11 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public static final /* synthetic */ void access$showSuccessText(WikiPinPlugin r0, String r1) {
        r0.showSuccessText(r1);
    }

    private final void notifyDoPin(WikiViewModel r4, String r5, boolean r6) {
        TreeNode r0 = r4.getWikiMeta();
        if (r0 == null) goto L5;
        r0.is_explorer_pin = r6;
    L5:
        WikiTreeObserver.a r1 = WikiTreeObserver.d;
        String r2 = r4.getSpaceId();
        if (r5 != null) goto L8;
        r5 = r4.getWikiToken();
    L8:
        r1.e(new com.bytedance.ee.bear.wikiv2.wikitreev2.d(r2, r5, r6));
    }

    public static final /* synthetic */ void access$notifyDoPin(WikiPinPlugin r0, WikiViewModel r1, String r2, boolean r3) {
        r0.notifyDoPin(r1, r2, r3);
    }
}
