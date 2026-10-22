package com.ss.android.lark.chat.api.service;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chat/api/service/StorePrivateDescriptionScene;", "", "source", "Lcom/ss/android/lark/chat/api/service/PrivateDescriptionSource;", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Lcom/ss/android/lark/chat/api/service/Strategy;", "logTag", "", "dispatcherName", "<init>", "(Ljava/lang/String;ILcom/ss/android/lark/chat/api/service/PrivateDescriptionSource;Lcom/ss/android/lark/chat/api/service/Strategy;Ljava/lang/String;Ljava/lang/String;)V", "getSource", "()Lcom/ss/android/lark/chat/api/service/PrivateDescriptionSource;", "getStrategy", "()Lcom/ss/android/lark/chat/api/service/Strategy;", "getLogTag", "()Ljava/lang/String;", "getDispatcherName", "GROUP_MESSAGE", "REPLY_IN_THREAD", "MERGE_FORWARD", "SECRET_GROUP_MESSAGE", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StorePrivateDescriptionScene extends Enum<StorePrivateDescriptionScene> {
    public static final StorePrivateDescriptionScene GROUP_MESSAGE = null;
    public static final StorePrivateDescriptionScene MERGE_FORWARD = null;
    public static final StorePrivateDescriptionScene REPLY_IN_THREAD = null;
    public static final StorePrivateDescriptionScene SECRET_GROUP_MESSAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StorePrivateDescriptionScene[] f411527a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f411528b = null;
    private final String dispatcherName;
    private final String logTag;
    private final PrivateDescriptionSource source;
    private final Strategy strategy;

    public static EnumEntries<StorePrivateDescriptionScene> getEntries() {
        return f411528b;
    }

    static {
        PrivateDescriptionSource r110 = PrivateDescriptionSource.CHAT_MESSAGE;
        Strategy r111 = Strategy.TRY_LOCAL;
        StorePrivateDescriptionScene r100 = new StorePrivateDescriptionScene("GROUP_MESSAGE", 0, r110, r111, "GroupMsgPrivateDesHandler", "chat-group-private-description");
        GROUP_MESSAGE = r100;
        StorePrivateDescriptionScene r101 = new StorePrivateDescriptionScene("REPLY_IN_THREAD", 1, r110, r111, "ReplyThreadPrivateDesHandler", "reply-thread-private-description");
        REPLY_IN_THREAD = r101;
        StorePrivateDescriptionScene r102 = new StorePrivateDescriptionScene("MERGE_FORWARD", 2, r110, r111, "MergeForwardPrivateDesHandler", "merge-forward-private-description");
        MERGE_FORWARD = r102;
        StorePrivateDescriptionScene r103 = new StorePrivateDescriptionScene("SECRET_GROUP_MESSAGE", 3, r110, r111, "SecretGroupPrivateDesHandler", "secret-group-private-description");
        SECRET_GROUP_MESSAGE = r103;
        StorePrivateDescriptionScene[] r104 = {r100, r101, r102, r103};
        f411527a = r104;
        f411528b = EnumEntriesKt.enumEntries(r104);
    }

    public static StorePrivateDescriptionScene[] values() {
        return (StorePrivateDescriptionScene[]) f411527a.clone();
    }

    public final String getDispatcherName() {
        return this.dispatcherName;
    }

    public final String getLogTag() {
        return this.logTag;
    }

    public final PrivateDescriptionSource getSource() {
        return this.source;
    }

    public final Strategy getStrategy() {
        return this.strategy;
    }

    public static StorePrivateDescriptionScene valueOf(String r100) {
        return (StorePrivateDescriptionScene) a.a(StorePrivateDescriptionScene.class, r100);
    }

    public StorePrivateDescriptionScene(String r100, int r101, PrivateDescriptionSource r102, Strategy r103, String r104, String r105) {
        super(r100, r101);
        this.source = r102;
        this.strategy = r103;
        this.logTag = r104;
        this.dispatcherName = r105;
    }
}
