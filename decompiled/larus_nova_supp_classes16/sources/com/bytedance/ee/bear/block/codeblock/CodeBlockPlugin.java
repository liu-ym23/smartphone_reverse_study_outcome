package com.bytedance.ee.bear.block.codeblock;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.doc.codeblock.CodeLanguageData;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/block/codeblock/CodeBlockPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "viewModel", "Lcom/bytedance/ee/bear/doc/codeblock/CodeBlockViewModel;", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onDetachFromUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "Companion", "CodeBlockLanguageSelectHandler", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CodeBlockPlugin extends DocumentPlugin {
    public static final b Companion = null;
    private static final String SELECT_CODE_BLOCK_LANGUAGE = "biz.util.selectCodeBlockLanguage";
    private static final String TAG = null;
    private m callback;
    private com.bytedance.ee.bear.doc.codeblock.CodeBlockViewModel viewModel;

    public final class a implements i<CodeLanguageData> {
        public final /* synthetic */ CodeBlockPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(CodeBlockPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r5, m r6) {
            CodeLanguageData r7 = (CodeLanguageData) r5;
            CodeBlockPlugin.access$setCallback$p(this.a, r6);
            if (r7 == null) goto L13;
            CodeBlockPlugin r8 = this.a;
            tt5.a.b(CodeBlockPlugin.access$getTAG$cp(), "JS dispatch data: " + r7);
            com.bytedance.ee.bear.doc.codeblock.CodeBlockViewModel r0 = CodeBlockPlugin.access$getViewModel$p(r8);
            com.bytedance.ee.bear.doc.codeblock.CodeBlockViewModel r1 = null;
            if (r0 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r0 = null;
        L7:
            r0.isShowingCodeLanguageSelectionPanel().setValue(Boolean.TRUE);
            com.bytedance.ee.bear.doc.codeblock.CodeBlockViewModel r9 = CodeBlockPlugin.access$getViewModel$p(r8);
            if (r9 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L11:
            r1.getCodeLanguageData().setValue(r7);
            return;
        L10:
            r1 = r9;
            goto L11
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ CodeBlockPlugin a;

        public c(CodeBlockPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            JSONObject r0 = new JSONObject();
            r0.put("value", (String) r3);
            m r4 = CodeBlockPlugin.access$getCallback$p(this.a);
            if (r4 == null) goto L6;
            r4.b(r0);
            return;
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    static {
        Companion = new b();
        TAG = "CodeBlockPlugin";
    }

    public CodeBlockPlugin() {
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public static final /* synthetic */ m access$getCallback$p(CodeBlockPlugin r0) {
        return r0.callback;
    }

    public static final /* synthetic */ Context access$getContext(CodeBlockPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ t access$getUIContainer(CodeBlockPlugin r0) {
        return r0.getUIContainer();
    }

    public static final /* synthetic */ com.bytedance.ee.bear.doc.codeblock.CodeBlockViewModel access$getViewModel$p(CodeBlockPlugin r0) {
        return r0.viewModel;
    }

    public static final /* synthetic */ void access$removeFragment(CodeBlockPlugin r0) {
        r0.removeFragment();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put(SELECT_CODE_BLOCK_LANGUAGE, new a(this));
    }

    public void onAttachToHost(DocumentPluginHost r5) {
        super.onAttachToHost(r5);
        com.bytedance.ee.bear.doc.codeblock.CodeBlockViewModel r6 = (com.bytedance.ee.bear.doc.codeblock.CodeBlockViewModel) viewModel(com.bytedance.ee.bear.doc.codeblock.CodeBlockViewModel.class);
        this.viewModel = r6;
        com.bytedance.ee.bear.doc.codeblock.CodeBlockViewModel r0 = null;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r6 = null;
    L5:
        r6.isShowingCodeLanguageSelectionPanel().observe(getLifecycleOwner(), new AnonymousClass1(this));
        com.bytedance.ee.bear.doc.codeblock.CodeBlockViewModel r7 = this.viewModel;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L9:
        r0.getOnSelectCodeLanguage().observe(getLifecycleOwner(), new c(this));
        return;
    L8:
        r0 = r7;
        goto L9
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ Fragment access$instantiateFragment(CodeBlockPlugin r0, Class r1) {
        return r0.instantiateFragment(r1);
    }

    public static final /* synthetic */ void access$setCallback$p(CodeBlockPlugin r0, m r1) {
        r0.callback = r1;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        com.bytedance.ee.bear.doc.codeblock.CodeBlockViewModel r3 = this.viewModel;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L5:
        r3.isShowingCodeLanguageSelectionPanel().setValue(Boolean.FALSE);
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
