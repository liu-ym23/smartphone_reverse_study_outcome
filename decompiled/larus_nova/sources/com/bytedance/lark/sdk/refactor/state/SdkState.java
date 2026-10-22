package com.bytedance.lark.sdk.refactor.state;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/lark/sdk/refactor/state/SdkState;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, ErrorCode.INIT, "ONLINE", "OFFLINE", "rust-jvm_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SdkState extends Enum<SdkState> {
    public static final SdkState INIT = null;
    public static final SdkState NONE = null;
    public static final SdkState OFFLINE = null;
    public static final SdkState ONLINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SdkState[] f254304a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f254305b = null;

    public static EnumEntries<SdkState> getEntries() {
        return f254305b;
    }

    static {
        SdkState r100 = new SdkState(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        SdkState r101 = new SdkState(ErrorCode.INIT, 1);
        INIT = r101;
        SdkState r102 = new SdkState("ONLINE", 2);
        ONLINE = r102;
        SdkState r103 = new SdkState("OFFLINE", 3);
        OFFLINE = r103;
        SdkState[] r104 = {r100, r101, r102, r103};
        f254304a = r104;
        f254305b = EnumEntriesKt.enumEntries(r104);
    }

    public static SdkState[] values() {
        return (SdkState[]) f254304a.clone();
    }

    public static SdkState valueOf(String r100) {
        return (SdkState) r27.a.a(SdkState.class, r100);
    }

    public SdkState(String r100, int r101) {
        super(r100, r101);
    }
}
