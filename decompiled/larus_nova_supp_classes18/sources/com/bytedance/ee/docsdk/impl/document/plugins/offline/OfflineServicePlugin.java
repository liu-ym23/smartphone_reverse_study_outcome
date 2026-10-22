package com.bytedance.ee.docsdk.impl.document.plugins.offline;

import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.JsBridgeConstants;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.docsdk.impl.utils.OfflineUtils;
import com.ss.android.lark.chameleon.api.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.CallBackFunction;
import com.ss.android.lark.chameleon.idependency.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0003\t\n\u000bB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/offline/OfflineServicePlugin;", "Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin;", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "Companion", "GetDataHandler", "SetDataHandler", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OfflineServicePlugin extends AbsChameleonPlugin {
    public static final Companion Companion = null;
    private static final String TAG = "OfflineServicePlugin";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/offline/OfflineServicePlugin$Companion;", "", "()V", "TAG", "", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/offline/OfflineServicePlugin$GetDataHandler;", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "Lcom/bytedance/ee/docsdk/impl/document/plugins/offline/OfflineTransferModel;", "()V", "handle", "", "model", "callback", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GetDataHandler implements BridgeHandlerV2<OfflineTransferModel> {
        public GetDataHandler() {
        }

        public void handle(OfflineTransferModel r9, CallBackFunction r10) {
            Log.i(OfflineServicePlugin.TAG, "GetDataHandler: " + r9);
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new OfflineServicePlugin$GetDataHandler$handle$1(r9, r10, null), 2, null);
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, CallBackFunction r2) {
            handle((OfflineTransferModel) r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001c\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/offline/OfflineServicePlugin$SetDataHandler;", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "Lcom/bytedance/ee/docsdk/impl/document/plugins/offline/OfflineTransferModel;", "()V", "addDataToStorage", "", WikiFolderPushPlugin.DATA, "Lcom/bytedance/ee/docsdk/impl/document/plugins/offline/storage/ResourceData;", "callback", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "model", "start", "", "handle", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SetDataHandler implements BridgeHandlerV2<OfflineTransferModel> {
        public SetDataHandler() {
        }

        public void handle(OfflineTransferModel r9, CallBackFunction r10) {
            Log.i(OfflineServicePlugin.TAG, "SetDataHandler： " + r9);
            long r6 = System.currentTimeMillis();
            if (r9 == null) goto L12;
            ResourceData r3 = r9.parseResourceData();
            if (r3 == null) goto L12;
            if (TextUtils.isEmpty(r3.getObj_token()) == true) goto L12;
            if (TextUtils.isEmpty(r3.getReskey()) == true) goto L12;
            addDataToStorage(r3, r10, r9, r6);
            return;
        L12:
            OfflineUtils.INSTANCE.onJsFailCallback("data is null", "", r10);
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, CallBackFunction r2) {
            handle((OfflineTransferModel) r1, r2);
        }

        private final synchronized void addDataToStorage(ResourceData r10, CallBackFunction r11, OfflineTransferModel r12, long r13) {
            monitor-enter(this);
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new OfflineServicePlugin$SetDataHandler$addDataToStorage$1(r10, r13, r11, null), 2, null);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OfflineServicePlugin() {
    }

    public void getBridgeHandlers(Map<String, BridgeHandlerV2<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put(JsBridgeConstants.BIZ_UTIL_GET_DATA, new GetDataHandler());
        r3.put(JsBridgeConstants.BIZ_UTIL_SET_DATA, new SetDataHandler());
    }
}
