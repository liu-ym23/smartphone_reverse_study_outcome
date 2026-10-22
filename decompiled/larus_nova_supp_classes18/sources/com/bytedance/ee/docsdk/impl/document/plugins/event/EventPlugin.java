package com.bytedance.ee.docsdk.impl.document.plugins.event;

import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
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
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/event/EventPlugin;", "Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin;", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "Companion", "EventHandler", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EventPlugin extends AbsChameleonPlugin {
    private static final String BIZ_EVENT = "biz.notify.event";
    public static final Companion Companion = null;
    private static final String EVENT_DELETE = "NOTE_DELETED";
    private static final String EVENT_DOCX_UPGRADE = "DOCX_UPGRADE";
    private static final String EVENT_EDIT = "EDIT";
    private static final String EVENT_NOT_FOUND = "NOTE_NOT_FOUND";
    private static final String EVENT_NO_PERMISSION = "NO_PERMISSION";
    private static final String EVENT_VIEW = "VIEW";
    private static final String TAG = "EventPlugin";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/event/EventPlugin$Companion;", "", "()V", "BIZ_EVENT", "", "EVENT_DELETE", "EVENT_DOCX_UPGRADE", "EVENT_EDIT", "EVENT_NOT_FOUND", "EVENT_NO_PERMISSION", "EVENT_VIEW", "TAG", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/event/EventPlugin$EventHandler;", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "Lcom/bytedance/ee/docsdk/impl/document/plugins/event/EventModel;", "(Lcom/bytedance/ee/docsdk/impl/document/plugins/event/EventPlugin;)V", "handle", "", "model", "callback", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class EventHandler implements BridgeHandlerV2<EventModel> {
        final /* synthetic */ EventPlugin this$0;

        public EventHandler(EventPlugin r1) {
            this.this$0 = r1;
        }

        public void handle(EventModel r7, CallBackFunction r8) {
            StringBuilder r9 = new StringBuilder("EventHandler: ");
            String r0 = null;
            if (r7 == null) goto L5;
            String r1 = r7.getEvent();
        L6:
            r9.append(r1);
            Log.i(EventPlugin.TAG, r9.toString());
            if (r7 == null) goto L9;
            r0 = r7.getEvent();
        L9:
            if (r0 != null) goto L11;
            return;
        L11:
            switch(r0.hashCode()) {
                case -1911183619: goto L25;
                case -131073335: goto L21;
                case 1252789005: goto L17;
                case 2097412268: goto L14;
                default: goto L33;
            };
        L33:
            return;
        L14:
            if (r0.equals(EventPlugin.EVENT_DELETE) == false) goto L30;
        L23:
            IChameleonLoader.DefaultImpls.onLoadFailed$default(this.this$0.getHost().getLoader(), -55, null, null, 6, null);
            return;
        L30:
            return;
        L17:
            if (r0.equals(EventPlugin.EVENT_NO_PERMISSION) == false) goto L34;
            IChameleonLoader.DefaultImpls.onLoadFailed$default(this.this$0.getHost().getLoader(), 999, null, null, 6, null);
            return;
        L34:
            return;
        L21:
            if (r0.equals(EventPlugin.EVENT_NOT_FOUND) == true) goto L23;
            return;
        L25:
            if (r0.equals(EventPlugin.EVENT_DOCX_UPGRADE) == false) goto L36;
            IChameleonLoader.DefaultImpls.onLoadFailed$default(this.this$0.getHost().getLoader(), SegmentStyle.FONT_WEIGHT_BOLD, r7.getMessage(), null, 4, null);
            return;
        L36:
            return;
        L5:
            r1 = null;
            goto L6
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, CallBackFunction r2) {
            handle((EventModel) r1, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public EventPlugin() {
    }

    public void getBridgeHandlers(Map<String, BridgeHandlerV2<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super.getBridgeHandlers(r3);
        r3.put(BIZ_EVENT, new EventHandler(this));
    }
}
