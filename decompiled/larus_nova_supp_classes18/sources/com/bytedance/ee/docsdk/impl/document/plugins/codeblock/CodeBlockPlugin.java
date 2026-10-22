package com.bytedance.ee.docsdk.impl.document.plugins.codeblock;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.block.codeblock.CodeBlockViewModel;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.google.gson.JsonObject;
import com.ss.android.lark.chameleon.api.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.api.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.CallBackFunction;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\nH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeBlockPlugin;", "Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin;", "()V", "callback", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "viewModel", "Lcom/bytedance/ee/bear/block/codeblock/CodeBlockViewModel;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/ss/android/lark/chameleon/api/pluginapi/ChameleonPluginHost;", "onDetachFromUIContainer", "uiContainer", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/UIContainer;", "CodeBlockLanguageSelectHandler", "Companion", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CodeBlockPlugin extends AbsChameleonPlugin {
    public static final Companion Companion = null;
    private static final String SELECT_CODE_BLOCK_LANGUAGE = "biz.util.selectCodeBlockLanguage";
    private static final String TAG = null;
    private CallBackFunction callback;
    private CodeBlockViewModel viewModel;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeBlockPlugin$CodeBlockLanguageSelectHandler;", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeLanguageData;", "(Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeBlockPlugin;)V", "handle", "", WikiFolderPushPlugin.DATA, "callback", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class CodeBlockLanguageSelectHandler implements BridgeHandlerV2<CodeLanguageData> {
        final /* synthetic */ CodeBlockPlugin this$0;

        public CodeBlockLanguageSelectHandler(CodeBlockPlugin r1) {
            this.this$0 = r1;
        }

        public void handle(CodeLanguageData r5, CallBackFunction r6) {
            CodeBlockPlugin.access$setCallback$p(this.this$0, r6);
            if (r5 == null) goto L13;
            CodeBlockPlugin r7 = this.this$0;
            Log.d(CodeBlockPlugin.access$getTAG$cp(), "JS dispatch data: " + r5);
            CodeBlockViewModel r0 = CodeBlockPlugin.access$getViewModel$p(r7);
            CodeBlockViewModel r1 = null;
            if (r0 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r0 = null;
        L7:
            r0.isShowingCodeLanguageSelectionPanel().setValue(Boolean.TRUE);
            CodeBlockViewModel r8 = CodeBlockPlugin.access$getViewModel$p(r7);
            if (r8 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L11:
            r1.getCodeLanguageData().setValue(r5);
            return;
        L10:
            r1 = r8;
            goto L11
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, CallBackFunction r2) {
            handle((CodeLanguageData) r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeBlockPlugin$Companion;", "", "()V", "SELECT_CODE_BLOCK_LANGUAGE", "", "TAG", "kotlin.jvm.PlatformType", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    public static /* synthetic */ void a(CodeBlockPlugin r0, String r1) {
        onAttachToHost$lambda$0(r0, r1);
    }

    static {
        Companion = new Companion(null);
        TAG = "CodeBlockPlugin";
    }

    public CodeBlockPlugin() {
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public static final /* synthetic */ Context access$getContext(CodeBlockPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ UIContainer access$getUIContainer(CodeBlockPlugin r0) {
        return r0.getUIContainer();
    }

    public static final /* synthetic */ CodeBlockViewModel access$getViewModel$p(CodeBlockPlugin r0) {
        return r0.viewModel;
    }

    public static final /* synthetic */ void access$removeFragment(CodeBlockPlugin r0) {
        r0.removeFragment();
    }

    public void getBridgeHandlers(Map<String, BridgeHandlerV2<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put(SELECT_CODE_BLOCK_LANGUAGE, new CodeBlockLanguageSelectHandler(this));
    }

    public void onAttachToHost(ChameleonPluginHost r5) {
        super/*com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin*/.onAttachToHost(r5);
        CodeBlockViewModel r6 = viewModel(CodeBlockViewModel.class);
        this.viewModel = r6;
        CodeBlockViewModel r0 = null;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r6 = null;
    L5:
        r6.isShowingCodeLanguageSelectionPanel().observe(getLifecycleOwner(), new AnonymousClass1(this));
        CodeBlockViewModel r7 = this.viewModel;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L9:
        r0.getOnSelectCodeLanguage().observe(getLifecycleOwner(), new a(this));
        return;
    L8:
        r0 = r7;
        goto L9
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public static final /* synthetic */ Fragment access$instantiateFragment(CodeBlockPlugin r0, Class r1) {
        return r0.instantiateFragment(r1);
    }

    public static final /* synthetic */ void access$setCallback$p(CodeBlockPlugin r0, CallBackFunction r1) {
        r0.callback = r1;
    }

    private static final void onAttachToHost$lambda$0(CodeBlockPlugin r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        JsonObject r0 = new JsonObject();
        r0.addProperty("value", r3);
        CallBackFunction r4 = r2.callback;
        if (r4 == null) goto L6;
        r4.onCallBack(r0);
        return;
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r1, UIContainer r2) {
        super/*com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
        CodeBlockViewModel r3 = this.viewModel;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L5:
        r3.isShowingCodeLanguageSelectionPanel().setValue(Boolean.FALSE);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, UIContainer r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
