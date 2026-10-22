package com.bytedance.ee.docsdk.impl.document.plugins.keyboard;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.JsBridgeConstants;
import com.bytedance.ee.docsdk.impl.utils.keyboard.utils.KeyBoardUtils;
import com.ss.android.lark.chameleon.api.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.CallBackFunction;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0003\t\n\u000bB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/keyboard/KeyboardPlugin;", "Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin;", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "Companion", "HideKeyBoardHandler", "ShowKeyBoardHandler", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KeyboardPlugin extends AbsChameleonPlugin {
    public static final Companion Companion = null;
    private static final String TAG = "KeyboardPlugin";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/keyboard/KeyboardPlugin$Companion;", "", "()V", "TAG", "", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/keyboard/KeyboardPlugin$HideKeyBoardHandler;", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "Ljava/lang/Void;", "(Lcom/bytedance/ee/docsdk/impl/document/plugins/keyboard/KeyboardPlugin;)V", "handle", "", WikiFolderPushPlugin.DATA, "callback", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class HideKeyBoardHandler implements BridgeHandlerV2<Void> {
        final /* synthetic */ KeyboardPlugin this$0;

        public HideKeyBoardHandler(KeyboardPlugin r1) {
            this.this$0 = r1;
        }

        public void handle(Void r1, CallBackFunction r2) {
            KeyBoardUtils.hideKeyboard(this.this$0.getHost().getContext());
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, CallBackFunction r2) {
            handle((Void) r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/keyboard/KeyboardPlugin$ShowKeyBoardHandler;", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "Ljava/lang/Void;", "(Lcom/bytedance/ee/docsdk/impl/document/plugins/keyboard/KeyboardPlugin;)V", "handle", "", WikiFolderPushPlugin.DATA, "callback", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class ShowKeyBoardHandler implements BridgeHandlerV2<Void> {
        final /* synthetic */ KeyboardPlugin this$0;

        public ShowKeyBoardHandler(KeyboardPlugin r1) {
            this.this$0 = r1;
        }

        public void handle(Void r1, CallBackFunction r2) {
            KeyBoardUtils.showKeyboard(this.this$0.getHost().getWeb().getWebView());
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, CallBackFunction r2) {
            handle((Void) r1, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public KeyboardPlugin() {
    }

    public void getBridgeHandlers(Map<String, BridgeHandlerV2<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super.getBridgeHandlers(r3);
        r3.put(JsBridgeConstants.BIZ_UTIL_SHOW_KEY_BOARD, new ShowKeyBoardHandler(this));
        r3.put(JsBridgeConstants.BIZ_UTIL_HIDE_KEY_BOARD, new HideKeyBoardHandler(this));
    }
}
