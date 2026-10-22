package com.example.kmp.shared.sha;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/example/kmp/shared/sha/WsBridgeConnectionState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "CONNECTING", "DISCONNECTING", "FAILED", ErrorCode.CLOSED, "CONNECTED", "kmpNativeBridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum WsBridgeConnectionState extends Enum<WsBridgeConnectionState> {
    public static final WsBridgeConnectionState CLOSED = null;
    public static final WsBridgeConnectionState CONNECTED = null;
    public static final WsBridgeConnectionState CONNECTING = null;
    public static final WsBridgeConnectionState DISCONNECTING = null;
    public static final WsBridgeConnectionState FAILED = null;
    public static final WsBridgeConnectionState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WsBridgeConnectionState[] f274038a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f274039b = null;

    public static EnumEntries<WsBridgeConnectionState> getEntries() {
        return f274039b;
    }

    static {
        WsBridgeConnectionState r100 = new WsBridgeConnectionState("UNKNOWN", 0);
        UNKNOWN = r100;
        WsBridgeConnectionState r101 = new WsBridgeConnectionState("CONNECTING", 1);
        CONNECTING = r101;
        WsBridgeConnectionState r102 = new WsBridgeConnectionState("DISCONNECTING", 2);
        DISCONNECTING = r102;
        WsBridgeConnectionState r103 = new WsBridgeConnectionState("FAILED", 3);
        FAILED = r103;
        WsBridgeConnectionState r104 = new WsBridgeConnectionState(ErrorCode.CLOSED, 4);
        CLOSED = r104;
        WsBridgeConnectionState r105 = new WsBridgeConnectionState("CONNECTED", 5);
        CONNECTED = r105;
        WsBridgeConnectionState[] r110 = {r100, r101, r102, r103, r104, r105};
        f274038a = r110;
        f274039b = EnumEntriesKt.enumEntries(r110);
    }

    public static WsBridgeConnectionState[] values() {
        return (WsBridgeConnectionState[]) f274038a.clone();
    }

    public static WsBridgeConnectionState valueOf(String r100) {
        return (WsBridgeConnectionState) a.a(WsBridgeConnectionState.class, r100);
    }

    public WsBridgeConnectionState(String r100, int r101) {
        super(r100, r101);
    }
}
