package com.bytedance.ee.bear.document.doccomponent;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.doccomponent.api.entity.DocComponentBizEvent;
import com.bytedance.ee.bear.doccomponent.api.entity.contentevent.DCLoadStateChangedEvent;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.a5;
import com.bytedance.ee.bear.document.doccomponent.impl.DoComponentConfigVM;
import com.bytedance.ee.bear.document.doccomponent.impl.WebDocComponentImpl;
import com.bytedance.ee.bear.document.fail.DocException;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.document.y4;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0017J\u001c\u0010\u0013\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/document/doccomponent/DocComponentPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/document/ITitleBarAbility$BackPressedInterceptor;", "Lcom/bytedance/ee/bear/doccomponent/api/ability/IDocComponentAbility;", "<init>", "()V", "webDocComponentImpl", "Lcom/bytedance/ee/bear/document/doccomponent/impl/WebDocComponentImpl;", "loadingCb", "Lcom/bytedance/ee/bear/document/DocumentLoader$LoadingCallback;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "getLeftImageResource", "", "onDetachFromUIContainer", "onDetachFromHost", "processContentEvent", "", "loadStateChangedEvent", "Lcom/bytedance/ee/bear/doccomponent/api/IDocComponentContentEvent;", "onPressed", "padModel", "onTitleMenuClick", "id", "", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocComponentPlugin extends DocumentPlugin implements a5.a, rz4.a {
    public static final a Companion = null;
    public static final String TAG = "DComponent_DocComponentPlugin";
    private x2.b loadingCb;
    private WebDocComponentImpl webDocComponentImpl;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DocComponentPlugin a;

        public b(DocComponentPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            HashMap r5 = (HashMap) r4;
            if (r5 == null) goto L12;
            tt5.a.h(DocComponentPlugin.TAG, "livePatchDocComponentConfig start exec updateSettingConfig");     // Catch: Throwable -> L7
            DocComponentPlugin.access$execJS(this.a, "javascript:lark.biz.doccomponent.configChange", JSON.parseObject(JSON.toJSONString(r5)));     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            tt5.a.f(DocComponentPlugin.TAG, th, false);
            return;
        }
    }

    public static final class c implements x2.b {
        public final /* synthetic */ DocComponentPlugin a;

        @Override // com.bytedance.ee.bear.document.x2.b
        public final /* synthetic */ void onLoadCancel() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final /* synthetic */ void onSSRLoadSuccess() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadStart() {
            tt5.a.h(DocComponentPlugin.TAG, "onLoadStart() called");
            this.a.processContentEvent(new DCLoadStateChangedEvent(DCLoadStateChangedEvent.LoadState.Loading));
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadSuccess() {
            tt5.a.h(DocComponentPlugin.TAG, "onLoadSuccess() called");
            this.a.processContentEvent(new DCLoadStateChangedEvent(DCLoadStateChangedEvent.LoadState.LoadSuccess));
        }

        public c(DocComponentPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadFail(int r3, Throwable r4) {
            tt5.a.h(DocComponentPlugin.TAG, "onLoadFail() called with: code = " + r3 + ", e = " + r4);
            this.a.processContentEvent(new DCLoadStateChangedEvent(DCLoadStateChangedEvent.LoadState.LoadFail));
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ DocComponentPlugin a;

        public d(DocComponentPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            this.a.processContentEvent(new sz4.d((String) r3));
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ DocumentPluginHost a;
        public final /* synthetic */ DocComponentPlugin b;

        public e(DocumentPluginHost r1, DocComponentPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r6) {
            if (Intrinsics.areEqual((Boolean) r6, Boolean.TRUE) == false) goto L22;
            int r7 = DocComponentDeletedDispatcher.a;
            x2 r8 = this.a.getDocumentLoader();
            boolean r0 = DocComponentPlugin.access$getDocViewModel(this.b).isEditionDoc();
            int r2 = -55;
            String r3 = "";
            DocException r1 = new DocException(-55, "");
            Intrinsics.checkNotNullParameter(r8, "loader");
            Intrinsics.checkNotNullParameter(r1, "deletedException");
            if ((r8 instanceof y4) == false) goto L8;
            ((y4) r8).c(-55, r1);
            DocComponentDeletedDispatcher.DispatchResult r9 = DocComponentDeletedDispatcher.DispatchResult.LegacyDispatched;
            return;
        L8:
            if ((r8 instanceof DocumentLoaderV3) == false) goto L20;
            if (r0 == false) goto L12;
            r2 = -57;
        L12:
            if (r1.getCode() == r2) goto L19;
            String r4 = r1.getMessage();
            if (r4 == null) goto L18;
            r3 = r4;
        L18:
            r1 = new DocException(r2, r3);
        L19:
            ((DocumentLoaderV3) r8).d(r2, r1, MapsKt.emptyMap());
            DocComponentDeletedDispatcher.DispatchResult r10 = DocComponentDeletedDispatcher.DispatchResult.LegacyDispatched;
            return;
        L20:
            DocComponentDeletedDispatcher.DispatchResult r11 = DocComponentDeletedDispatcher.DispatchResult.LegacyDispatched;
            return;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ DocComponentPlugin a;

        public f(DocComponentPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (this.a.processContentEvent(new sz4.a()) == false) goto L5;
            return;
        L5:
            DocComponentPlugin.access$getActivity(this.a).onBackPressed();
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // rz4.a
    public int getLeftImageResource() {
        WebDocComponentImpl r0 = this.webDocComponentImpl;
        if (r0 == null) goto L9;
        qz4.c r1 = r0.a;
        if (r1 == null) goto L10;
        r1.getConfig();
        return 2131254998;
    L10:
        return 2131254998;
    L9:
        return 2131254998;
    }

    @Override // com.bytedance.ee.bear.document.a5.a
    public boolean onPressed() {
        return processContentEvent(new sz4.a());
    }

    @Override // rz4.a
    public boolean padModel() {
        WebDocComponentImpl r0 = this.webDocComponentImpl;
        if (r0 == null) goto L9;
        qz4.c r1 = r0.a;
        if (r1 == null) goto L10;
        r1.getConfig();
        return false;
    L10:
        return false;
    L9:
        return false;
    }

    public DocComponentPlugin() {
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DocComponentPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(DocComponentPlugin r0) {
        return r0.getDocViewModel();
    }

    public void onAttachToHost(DocumentPluginHost r5) {
        Intrinsics.checkNotNullParameter(r5, "host");
        super.onAttachToHost(r5);
        r5.registerHostAbility(this);
        WebDocComponentImpl r0 = new WebDocComponentImpl(r5, r5.c(), getWeb(), r5.a().getToken());
        this.webDocComponentImpl = r0;
        qz4.c r1 = r0.a;
        if (r1 == null) goto L5;
        r1.getConfig();
    L5:
        tt5.a.h(TAG, "config=null");
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L14;
        Window r3 = r2.getWindow();
        if (r3 == null) goto L14;
        WindowManager.LayoutParams r4 = r3.getAttributes();
        if (r4 == null) goto L14;
        if (r4.softInputMode != 51) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == true) goto L21;
        tt5.a.h(TAG, "setSoftInputMode to 51");
        FragmentActivity r7 = getActivity();
        if (r7 == null) goto L21;
        Window r8 = r7.getWindow();
        if (r8 == null) goto L21;
        r8.setSoftInputMode(51);
    L21:
        ((DoComponentConfigVM) viewModel(DoComponentConfigVM.class)).getLivePatchDocComponentConfig().observe(getLifecycleOwner(), new b(this));
        x2 r9 = r5.getDocumentLoader();
        c r10 = new c(this);
        this.loadingCb = r10;
        r9.S3(r10);
        getDocViewModel().getDocName().observe(getLifecycleOwner(), new d(this));
        getDocViewModel().getDeleted().observe(getLifecycleOwner(), new e(r5, this));
        return;
    L14:
        r6 = false;
        goto L15
    }

    public void onDetachFromHost(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        r2.unregisterHostAbility(this);
        x2.b r0 = this.loadingCb;
        if (r0 == null) goto L6;
        r2.getDocumentLoader().S(r0);
        return;
    }

    @Override // rz4.a
    public void onTitleMenuClick(String r7) {
        WebDocComponentImpl r0 = this.webDocComponentImpl;
        if (r0 == null) goto L36;
        s05.d r1 = r0.c;
        qz4.c r2 = r0.a;
        if (r2 == null) goto L7;
        r2.getConfig();
    L7:
        qz4.b r3 = r1.a("track", "");
        if (r3 == null) goto L38;
        DocComponentBizEvent r4 = new DocComponentBizEvent();
        r4.setCommand("track");
        qz4.c r5 = r0.a;
        if (r5 == null) goto L13;
        r5.getConfig();
    L13:
        r4.setModule("");
        HashMap<String, ? extends Serializable> r6 = new HashMap();
        HashMap r8 = new HashMap();
        r6.put("eventName", "vc_meeting_onthecall_click");
        r6.put("params", r8);
        r4.setPayload(r6);
        if (r7 == null) goto L37;
        int r9 = r7.hashCode();
        if (r9 == (-452179334)) goto L31;
        if (r9 == 78862271) goto L27;
        if (r9 == 1672907751) goto L23;
        return;
    L23:
        if (r7.equals("MESSAGE") == false) goto L40;
        r8.put("click", "notes_notification");
    L34:
        tt5.a.h("DComponent_DocComponentWebImpl", "onTitleMenuClick event ret=" + r4);
        r3.onEvent(r4);
        return;
    L40:
        return;
    L27:
        if (r7.equals("SHARE") == false) goto L41;
        r8.put("click", "notes_share");
        goto L34
    L41:
        return;
    L31:
        if (r7.equals("MORE_OPERATE") == false) goto L42;
        r8.put("click", "notes_more");
        goto L34
    L42:
        return;
    L37:
        return;
    L38:
        return;
    }

    @Override // rz4.a
    public boolean processContentEvent(qz4.d r2) {
        Intrinsics.checkNotNullParameter(r2, "loadStateChangedEvent");
        WebDocComponentImpl r0 = this.webDocComponentImpl;
        if (r0 == null) goto L7;
        r0.a(r2);
        return false;
    L7:
        return false;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r2, t r3) {
        super.onAttachToUIContainer(r2, r3);
        WebDocComponentImpl r0 = this.webDocComponentImpl;
        if (r0 == null) goto L7;
        qz4.c r1 = r0.a;
        if (r1 == null) goto L7;
        r1.getConfig();
    L7:
        if (r2 == null) goto L11;
        a5 r4 = (a5) r2.getHostAbilityOrNull(a5.class);
        if (r4 == null) goto L11;
        r4.addBackPressedInterceptor(this);
    L11:
        if (r3 == null) goto L18;
        TitleBar r5 = r3.getTitleBar();
        if (r5 == null) goto L19;
        BaseTitleBar r6 = r5.getTitleBarLayout();
        if (r6 == null) goto L20;
        r6.setLeftClickListener(new f(this));
        return;
    L20:
        return;
    L19:
        return;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        if (r1 == null) goto L8;
        a5 r3 = (a5) r1.getHostAbilityOrNull(a5.class);
        if (r3 == null) goto L9;
        r3.removeBackPressedInterceptor(this);
        return;
    L9:
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

    public static final /* synthetic */ void access$execJS(DocComponentPlugin r0, String r1, JSONObject r2) {
        r0.execJS(r1, r2);
    }
}
