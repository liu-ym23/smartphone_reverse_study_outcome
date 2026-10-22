package com.larus.doc.sdk.impl.plugins.preference;

import com.bytedance.keva.Keva;
import com.google.gson.JsonObject;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.api.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.CallBackFunction;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0003\r\u000e\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\nH\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/doc/sdk/impl/plugins/preference/PreferencePlugin;", "Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin;", "<init>", "()V", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "Companion", "SetPreferenceHandler", "GetPreferenceHandler", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreferencePlugin extends AbsChameleonPlugin {
    private static final String BIZ_GET_PREFERENCE = "biz.util.getPreference";
    private static final String BIZ_SET_PREFERENCE = "biz.util.setPreference";
    public static final Companion Companion = null;
    private static final String DOC_KEVA_NAME = "doc_keva";
    private static final String TAG = "PreferencePlugin";
    private final Keva keva;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/larus/doc/sdk/impl/plugins/preference/PreferencePlugin$Companion;", "", "<init>", "()V", "TAG", "", "DOC_KEVA_NAME", "BIZ_SET_PREFERENCE", "BIZ_GET_PREFERENCE", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/doc/sdk/impl/plugins/preference/PreferencePlugin$GetPreferenceHandler;", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "Lcom/larus/doc/sdk/impl/plugins/preference/JsPreference;", "<init>", "(Lcom/larus/doc/sdk/impl/plugins/preference/PreferencePlugin;)V", "handle", "", "data", "callback", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class GetPreferenceHandler implements BridgeHandlerV2<JsPreference> {
        final /* synthetic */ PreferencePlugin this$0;

        public GetPreferenceHandler(PreferencePlugin r100) {
            this.this$0 = r100;
        }

        public void handle(JsPreference r100, CallBackFunction r101) {
            if (r100 == null) goto L4;
            String r102 = r100.getKey();
        L5:
            if (r102 != null) goto L7;
            return;
        L7:
            FLogger.f375446a.i(PreferencePlugin.TAG, "getPreference, key=" + r100.getKey() + ", value=" + PreferencePlugin.access$getKeva$p(this.this$0).getString(r100.getKey(), "") + '}');
            String r103 = PreferencePlugin.access$getKeva$p(this.this$0).getString(r100.getKey(), "");
            JsonObject r104 = new JsonObject();
            r104.addProperty("value", r103);
            if (r101 == null) goto L11;
            r101.onCallBack(r104);
            return;
        L11:
            return;
        L4:
            r102 = null;
            goto L5
        }

        @Override // com.ss.android.lark.chameleon.bridge.JSHandler
        public /* bridge */ /* synthetic */ void handle(Object r100, CallBackFunction r101) {
            handle((JsPreference) r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/doc/sdk/impl/plugins/preference/PreferencePlugin$SetPreferenceHandler;", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "Lcom/larus/doc/sdk/impl/plugins/preference/JsPreference;", "<init>", "(Lcom/larus/doc/sdk/impl/plugins/preference/PreferencePlugin;)V", "handle", "", "data", "callback", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SetPreferenceHandler implements BridgeHandlerV2<JsPreference> {
        final /* synthetic */ PreferencePlugin this$0;

        public SetPreferenceHandler(PreferencePlugin r100) {
            this.this$0 = r100;
        }

        public void handle(JsPreference r100, CallBackFunction r101) {
            if (r100 == null) goto L4;
            String r102 = r100.getKey();
        L5:
            if (r102 != null) goto L7;
            return;
        L7:
            if (r100.getValue() == null) goto L12;
            FLogger.f375446a.i(PreferencePlugin.TAG, "setPreference, key=" + r100.getKey() + ", value=" + r100.getValue() + '}');
            PreferencePlugin.access$getKeva$p(this.this$0).storeString(r100.getKey(), r100.getValue());
            return;
        L12:
            return;
        L4:
            r102 = null;
            goto L5
        }

        @Override // com.ss.android.lark.chameleon.bridge.JSHandler
        public /* bridge */ /* synthetic */ void handle(Object r100, CallBackFunction r101) {
            handle((JsPreference) r100, r101);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PreferencePlugin() {
        this.keva = Keva.getRepo(DOC_KEVA_NAME, 0);
    }

    public static final /* synthetic */ Keva access$getKeva$p(PreferencePlugin r100) {
        return r100.keva;
    }

    @Override // com.ss.android.lark.chameleon.api.AbsChameleonPlugin, com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.BridgeInteractivePlugin
    public void getBridgeHandlers(Map<String, BridgeHandlerV2<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        super.getBridgeHandlers(r100);
        r100.put(BIZ_SET_PREFERENCE, new SetPreferenceHandler(this));
        r100.put(BIZ_GET_PREFERENCE, new GetPreferenceHandler(this));
    }
}
