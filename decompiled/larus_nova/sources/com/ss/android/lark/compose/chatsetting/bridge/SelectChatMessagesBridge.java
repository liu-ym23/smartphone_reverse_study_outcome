package com.ss.android.lark.compose.chatsetting.bridge;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0004\n\u000b\f\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/compose/chatsetting/bridge/SelectChatMessagesBridge;", "Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Companion", "SelectChatMessagesBridgeHandler", "SelectChatMessagesRequest", "SelectChatMessagesResponse", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectChatMessagesBridge extends AbsChameleonPlugin {
    public static final int $stable = 0;
    private static final String BIZ_SELECT_MESSAGES = null;
    public static final a Companion = null;
    public static final String TAG = "SelectChatMessagesBridge";

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/compose/chatsetting/bridge/SelectChatMessagesBridge$SelectChatMessagesRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "chatId", "", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getChatId", "()Ljava/lang/String;", "getTitle", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SelectChatMessagesRequest implements NonProguard {
        public static final int $stable = 0;

        @SerializedName("chatId")
        private final String chatId;

        @SerializedName("title")
        private final String title;

        public static /* synthetic */ SelectChatMessagesRequest copy$default(SelectChatMessagesRequest r100, String r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.chatId;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.title;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.chatId;
        }

        public final String component2() {
            return this.title;
        }

        public final SelectChatMessagesRequest copy(String r100, String r101) {
            return new SelectChatMessagesRequest(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof SelectChatMessagesRequest) == true) goto L8;
            return false;
        L8:
            SelectChatMessagesRequest r101 = (SelectChatMessagesRequest) r100;
            if (Intrinsics.areEqual(this.chatId, r101.chatId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.title, r101.title) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r100 = this.chatId;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.title;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "SelectChatMessagesRequest(chatId=" + this.chatId + ", title=" + this.title + ')';
        }

        public final String getChatId() {
            return this.chatId;
        }

        public final String getTitle() {
            return this.title;
        }

        public SelectChatMessagesRequest(String r100, String r101) {
            this.chatId = r100;
            this.title = r101;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/compose/chatsetting/bridge/SelectChatMessagesBridge$SelectChatMessagesResponse;", "Lcom/bytedance/ee/util/io/NonProguard;", "cancel", "", "messageIds", "", "", "<init>", "(ZLjava/util/List;)V", "getCancel", "()Z", "getMessageIds", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SelectChatMessagesResponse implements NonProguard {
        public static final int $stable = 8;

        @SerializedName("cancel")
        private final boolean cancel;

        @SerializedName("msgIds")
        private final List<String> messageIds;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SelectChatMessagesResponse copy$default(SelectChatMessagesResponse r100, boolean r101, List r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.cancel;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.messageIds;
        L9:
            return r100.copy(r101, r102);
        }

        public final boolean component1() {
            return this.cancel;
        }

        public final List<String> component2() {
            return this.messageIds;
        }

        public final SelectChatMessagesResponse copy(boolean r100, List<String> r101) {
            Intrinsics.checkNotNullParameter(r101, "messageIds");
            return new SelectChatMessagesResponse(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof SelectChatMessagesResponse) == true) goto L8;
            return false;
        L8:
            SelectChatMessagesResponse r101 = (SelectChatMessagesResponse) r100;
            if (this.cancel == r101.cancel) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.messageIds, r101.messageIds) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            if (this.cancel == false) goto L5;
            int r100 = 1231;
        L7:
            return (r100 * 31) + this.messageIds.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public String toString() {
            return "SelectChatMessagesResponse(cancel=" + this.cancel + ", messageIds=" + this.messageIds + ')';
        }

        public final boolean getCancel() {
            return this.cancel;
        }

        public final List<String> getMessageIds() {
            return this.messageIds;
        }

        public SelectChatMessagesResponse(boolean r100, List<String> r101) {
            Intrinsics.checkNotNullParameter(r101, "messageIds");
            this.cancel = r100;
            this.messageIds = r101;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b extends AbsChameleonHandler<SelectChatMessagesRequest> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbsChameleonPlugin.WebviewHandlerContext f417357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f417358b;

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.f417358b;
        }

        public b(AbsChameleonPlugin.WebviewHandlerContext r100) {
            Intrinsics.checkNotNullParameter(r100, "handlerContext");
            this.f417357a = r100;
            SelectChatMessagesBridge.Companion.getClass();
            this.f417358b = SelectChatMessagesBridge.access$getBIZ_SELECT_MESSAGES$cp();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [com.ss.android.lark.compose.chatsetting.bridge.SelectChatMessagesBridge$SelectChatMessagesBridgeHandler$handle$messageSelectCallback$1] */
        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(SelectChatMessagesRequest r100, final Callback r101) {
            SelectChatMessagesRequest r102 = r100;
            Intrinsics.checkNotNullParameter(r102, "data");
            Intrinsics.checkNotNullParameter(r101, "callback");
            String r103 = r102.getChatId();
            if (r103 != null) goto L5;
        L8:
            boolean r104 = true;
        L9:
            if (r104 == false) goto L11;
            Log.e(SelectChatMessagesBridge.TAG, "data or chatId is null, " + r102);
            r101.success(new SelectChatMessagesResponse(true, CollectionsKt.emptyList()));
            return;
        L11:
            ?? r105 = new SelectChatMessagesBridge$SelectChatMessagesBridgeHandler$handle$messageSelectCallback$1(r101);
            String r106 = r102.getChatId();
            String r107 = r102.getTitle();
            if (r107 != null) goto L14;
            r107 = "";
        L14:
            Map r108 = MapsKt.mapOf(TuplesKt.to("title", r107));
            Context r109 = this.f417357a.getCmlContext();
            if ((r109 instanceof Activity) == false) goto L19;
            ((IIMApi) ApiUtils.getApi(IIMApi.class)).chatApi().f((Activity) r109, r106, r108, r105);
            return;
        L19:
            return;
        L5:
            if (r103.length() == 0) goto L8;
            r104 = false;
            goto L9
        }
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    static {
        Companion = new a();
        $stable = 8;
        BIZ_SELECT_MESSAGES = LKAPIModules.Biz.Chat.SelectMessages.getValue();
    }

    public SelectChatMessagesBridge() {
    }

    public static final /* synthetic */ String access$getBIZ_SELECT_MESSAGES$cp() {
        return BIZ_SELECT_MESSAGES;
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        super.getBridgeHandlers(r100);
        r100.put(BIZ_SELECT_MESSAGES, new b(getWebviewHandlerContext()));
    }
}
