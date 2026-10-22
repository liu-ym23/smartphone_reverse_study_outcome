package com.bytedance.ee.docsdk.impl.document.plugins.fail;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.lark.chameleon.api.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.CallBackFunction;
import com.ss.android.lark.chameleon.idependency.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/fail/FailEventPlugin;", "Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin;", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "Companion", "FailEventHandler", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FailEventPlugin extends AbsChameleonPlugin {
    public static final String BIZ_FAIL_EVENT = "biz.util.failEvent";
    public static final Companion Companion = null;
    public static final String TAG = "FailEventPlugin";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/fail/FailEventPlugin$Companion;", "", "()V", "BIZ_FAIL_EVENT", "", "TAG", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/fail/FailEventPlugin$FailEventHandler;", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "Lcom/bytedance/ee/docsdk/impl/document/plugins/fail/FailEventData;", "(Lcom/bytedance/ee/docsdk/impl/document/plugins/fail/FailEventPlugin;)V", "handle", "", WikiFolderPushPlugin.DATA, "callback", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class FailEventHandler implements BridgeHandlerV2<FailEventData> {
        final /* synthetic */ FailEventPlugin this$0;

        public FailEventHandler(FailEventPlugin r1) {
            this.this$0 = r1;
        }

        public void handle(FailEventData r7, CallBackFunction r8) {
            Log.i(FailEventPlugin.TAG, "FailEventHandler: " + r7);
            if (r7 == null) goto L6;
            IChameleonLoader.DefaultImpls.onLoadFailed$default(this.this$0.getHost().getLoader(), r7.getResult_code(), null, null, 6, null);
            return;
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, CallBackFunction r2) {
            handle((FailEventData) r1, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public FailEventPlugin() {
    }

    public void getBridgeHandlers(Map<String, BridgeHandlerV2<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super.getBridgeHandlers(r3);
        r3.put(BIZ_FAIL_EVENT, new FailEventHandler(this));
    }
}
