package com.bytedance.ee.bear.document.ai.citation;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.widget.utils.SingleLiveEvent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\f\u001a\u00020\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000fH\u0016J\u001c\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "currentCallback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "callbackBridgeViewModel", "Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationCallbackBridgeViewModel;", "callbackObserver", "Landroidx/lifecycle/Observer;", "Lkotlin/Pair;", "", "getBridgeHandlers", "", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToUIContainer", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "Companion", "ShowCitationHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocAICitationPlugin extends DocumentPluginV2 {
    public static final a Companion = null;
    private static final String FRAGMENT_TAG = "CitationFragment";
    public static final String JS_API_SHOW_CITATION = "biz.util.showCitations";
    public static final String TAG = "DocAICitationPlugin";
    private DocAICitationCallbackBridgeViewModel callbackBridgeViewModel;
    private Observer<Pair<String, String>> callbackObserver;
    private m currentCallback;

    public static final class a {
        public a() {
        }
    }

    public final class b implements tb5.i<ShowCitationData> {
        public final /* synthetic */ DocAICitationPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(DocAICitationPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r5, m r6) {
            ShowCitationData r7 = (ShowCitationData) r5;
            if (r7 != null) goto L5;
            tt5.a.d(DocAICitationPlugin.TAG, "ShowCitationHandler: data is null");
            return;
        L5:
            FragmentActivity r1 = this.a.getHost().getActivity();
            if (r1 != null) goto L8;
            tt5.a.d(DocAICitationPlugin.TAG, "ShowCitationHandler: activity is null");
            return;
        L8:
            DocAICitationPlugin.access$setCurrentCallback$p(this.a, r6);
            StringBuilder r2 = new StringBuilder("ShowCitationHandler: callback--> ,data.citations?.size =  ");
            List<Citation> r3 = r7.getCitations();
            if (r3 == null) goto L11;
            Integer r4 = Integer.valueOf(r3.size());
        L12:
            r2.append(r4);
            r2.append(", callback = ");
            r2.append(r6);
            tt5.a.h(DocAICitationPlugin.TAG, r2.toString());
            r1.runOnUiThread(new i(r1, this.a, r7));
            return;
        L11:
            r4 = null;
            goto L12
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ DocAICitationPlugin a;

        public c(DocAICitationPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Pair r5 = (Pair) r4;
            Intrinsics.checkNotNullParameter(r5, "<destruct>");
            String r0 = (String) r5.component1();
            String r6 = (String) r5.component2();
            JSONObject r1 = new JSONObject();
            r1.put("id", r0);
            r1.put("type", r6);
            tt5.a.h(DocAICitationPlugin.TAG, "onAttachToUIContainer: callback params = " + r1 + ", callback = " + DocAICitationPlugin.access$getCurrentCallback$p(this.a));
            m r7 = DocAICitationPlugin.access$getCurrentCallback$p(this.a);
            if (r7 == null) goto L6;
            r7.b(r1);
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DocAICitationPlugin() {
    }

    public static final /* synthetic */ m access$getCurrentCallback$p(DocAICitationPlugin r0) {
        return r0.currentCallback;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put(JS_API_SHOW_CITATION, new b(this));
    }

    public static final /* synthetic */ void access$setCurrentCallback$p(DocAICitationPlugin r0, m r1) {
        r0.currentCallback = r1;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r3, t r4) {
        super.onAttachToUIContainer(r3, r4);
        tt5.a.h(TAG, "onAttachToUIContainer: host = " + r3 + ", uiContainer = " + r4);
        if (r3 == null) goto L12;
        FragmentActivity r5 = r3.getActivity();
        if (r5 == null) goto L13;
        DocAICitationCallbackBridgeViewModel r6 = (DocAICitationCallbackBridgeViewModel) new ViewModelProvider(r5).get(DocAICitationCallbackBridgeViewModel.class);
        this.callbackBridgeViewModel = r6;
        Observer<Pair<String, String>> r0 = this.callbackObserver;
        if (r0 == null) goto L10;
        r6.getCallbackEvent().removeObserver(r0);
    L10:
        c r1 = new c(this);
        this.callbackObserver = r1;
        r6.getCallbackEvent().observe(r3.getLifecycleOwner(), r1);
        return;
    L13:
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r3, t r4) {
        Observer<Pair<String, String>> r0 = this.callbackObserver;
        if (r0 == null) goto L9;
        DocAICitationCallbackBridgeViewModel r1 = this.callbackBridgeViewModel;
        if (r1 == null) goto L9;
        SingleLiveEvent<Pair<String, String>> r2 = r1.getCallbackEvent();
        if (r2 == null) goto L9;
        r2.removeObserver(r0);
    L9:
        this.callbackObserver = null;
        this.callbackBridgeViewModel = null;
        this.currentCallback = null;
        super.onDetachFromUIContainer(r3, r4);
    }
}
