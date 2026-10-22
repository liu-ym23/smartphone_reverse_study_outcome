package com.example.interopdemo.websocket;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/example/interopdemo/websocket/NativeConnectionState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "CONNECTING", "DISCONNECTING", "FAILED", ErrorCode.CLOSED, "CONNECTED", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum NativeConnectionState extends Enum<NativeConnectionState> {
    public static final NativeConnectionState CLOSED = null;
    public static final NativeConnectionState CONNECTED = null;
    public static final NativeConnectionState CONNECTING = null;
    public static final NativeConnectionState DISCONNECTING = null;
    public static final NativeConnectionState FAILED = null;
    public static final NativeConnectionState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NativeConnectionState[] f274036a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f274037b = null;

    public static EnumEntries<NativeConnectionState> getEntries() {
        return f274037b;
    }

    static {
        NativeConnectionState r100 = new NativeConnectionState("UNKNOWN", 0);
        UNKNOWN = r100;
        NativeConnectionState r101 = new NativeConnectionState("CONNECTING", 1);
        CONNECTING = r101;
        NativeConnectionState r102 = new NativeConnectionState("DISCONNECTING", 2);
        DISCONNECTING = r102;
        NativeConnectionState r103 = new NativeConnectionState("FAILED", 3);
        FAILED = r103;
        NativeConnectionState r104 = new NativeConnectionState(ErrorCode.CLOSED, 4);
        CLOSED = r104;
        NativeConnectionState r105 = new NativeConnectionState("CONNECTED", 5);
        CONNECTED = r105;
        NativeConnectionState[] r110 = {r100, r101, r102, r103, r104, r105};
        f274036a = r110;
        f274037b = EnumEntriesKt.enumEntries(r110);
    }

    public static NativeConnectionState[] values() {
        return (NativeConnectionState[]) f274036a.clone();
    }

    public static NativeConnectionState valueOf(String r100) {
        return (NativeConnectionState) a.a(NativeConnectionState.class, r100);
    }

    public NativeConnectionState(String r100, int r101) {
        super(r100, r101);
    }
}
