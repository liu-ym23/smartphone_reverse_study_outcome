package com.bytedance.ee.bear.document.folder.creation;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import iw4.h;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010\u0013\u001a\u00020\r2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/document/folder/creation/CreationPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "mMenuManager", "Lcom/bytedance/ee/bear/document/folder/creation/DocumentSelectCreationMenuManager;", "mDocumentTypeMenuObserver", "Landroidx/lifecycle/Observer;", "", "mRecommendTemplateObserver", "", "getMenuManager", "onAttachToUIContainer", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "getBridgeHandlers", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Companion", "ShowCreationPanelHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationPlugin extends DocumentPlugin {
    private static final String BIZ_UTIL_CREATION_PANEL = "biz.util.showCreationPanel";
    public static final a Companion = null;
    private static final String TAG = "CreationPlugin";
    private Observer<Integer> mDocumentTypeMenuObserver;
    private m15.b mMenuManager;
    private Observer<Object> mRecommendTemplateObserver;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<CreationPanelModel> {
        public final /* synthetic */ CreationPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(CreationPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r5, m r6) {
            CreationPanelModel r7 = (CreationPanelModel) r5;
            StringBuilder r0 = new StringBuilder("handle data= ");
            if ((r7 instanceof Object) == false) goto L5;
            CreationPanelModel r1 = r7;
        L6:
            r0.append(du5.b.f(r1));
            tt5.a.h(CreationPlugin.TAG, r0.toString());
            if (r7 != null) goto L10;
            return;
        L10:
            if (CreationPlugin.access$getMenuManager(this.a).a(CreationPlugin.access$getActivity(this.a)) == false) goto L12;
            tt5.a.h(CreationPlugin.TAG, "create menu is already showing");
            return;
        L12:
            h r2 = new h();
            r2.b = "";
            r2.c = "";
            r2.d = "";
            r2.g = true;
            r2.e = false;
            r2.f = false;
            r2.a = r7.getParentWikiToken();
            r2.h = r7.getSpaceId();
            m15.b r8 = CreationPlugin.access$getMenuManager(this.a);
            r8.b = r6;
            r8.b(CreationPlugin.access$getActivity(this.a), r2, ((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.a.class, null, null, 6)).i(), null);
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ CreationPlugin a;

        public c(CreationPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            tt5.a.h(CreationPlugin.TAG, "on select creation type = " + ((Number) r3).intValue());
            CreationPlugin.access$getMenuManager(this.a).a(CreationPlugin.access$getActivity(this.a));
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ CreationPlugin a;

        public d(CreationPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            tt5.a.h(CreationPlugin.TAG, "on select template type");
            CreationPlugin.access$getMenuManager(this.a).a(CreationPlugin.access$getActivity(this.a));
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final m15.b getMenuManager() {
        m15.b r0 = this.mMenuManager;
        if (r0 != null) goto L6;
        m15.b r1 = new m15.b();
        this.mMenuManager = r1;
        return r1;
    L6:
        return r0;
    }

    public CreationPlugin() {
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(CreationPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ m15.b access$getMenuManager(CreationPlugin r0) {
        return r0.getMenuManager();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super.getBridgeHandlers(r3);
        r3.put(BIZ_UTIL_CREATION_PANEL, new b(this));
    }

    public void onAttachToUIContainer(DocumentPluginHost r3, t r4) {
        super.onAttachToUIContainer(r3, r4);
        tt5.a.h(TAG, "onAttachToUIContainer");
        c r5 = new c(this);
        ((SelectCreationMenuViewModel) ViewModelProviders.of(getActivity()).get(SelectCreationMenuViewModel.class)).getSelectedCreationTypeLiveData().observe(getLifecycleOwner(), r5);
        this.mDocumentTypeMenuObserver = r5;
        d r6 = new d(this);
        ((wn5.a) org.koin.java.a.c(wn5.a.class, null, null, 6)).p(getActivity()).observe(getLifecycleOwner(), r6);
        this.mRecommendTemplateObserver = r6;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r3, t r4) {
        super.onDetachFromUIContainer(r3, r4);
        tt5.a.h(TAG, "onDetachFromUIContainer");
        Observer<Integer> r5 = this.mDocumentTypeMenuObserver;
        if (r5 == null) goto L5;
        ((SelectCreationMenuViewModel) ViewModelProviders.of(getActivity()).get(SelectCreationMenuViewModel.class)).getSelectedCreationTypeLiveData().removeObserver(r5);
    L5:
        Observer<Object> r6 = this.mRecommendTemplateObserver;
        if (r6 == null) goto L9;
        ((wn5.a) org.koin.java.a.c(wn5.a.class, null, null, 6)).p(getActivity()).removeObserver(r6);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
