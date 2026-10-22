package com.larus.im.internal.jni.dependency;

import com.byted.cast.common.bean.State;
import com.bytedance.common.wschannel.WsConstants;
import com.flow.kmp.common.util.k;
import com.larus.im.internal.delegate.o0;
import gd9.n;
import gd9.v;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0001\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0002$%B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0082 J!\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0082 J\u0006\u0010\u0018\u001a\u00020\u000fJ\u0006\u0010\u0019\u001a\u00020\u000fJ\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000eH\u0016J\u0006\u0010\u001f\u001a\u00020\u000fJ\u0006\u0010 \u001a\u00020\u000fJ\u0006\u0010!\u001a\u00020\u0012J\u0016\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/im/internal/jni/dependency/OmniWebSocketCallByNative;", "Lcom/larus/im/depend/INetworkDepend$PayloadReceiver;", "Lcom/larus/im/depend/INetworkDepend$WsStatusListener;", "nativePtr", "", "<init>", "(J)V", "value", "Lcom/larus/im/internal/jni/dependency/OmniWebSocketCallByNative$ConnectionStatus;", "status", "setStatus", "(Lcom/larus/im/internal/jni/dependency/OmniWebSocketCallByNative$ConnectionStatus;)V", "extraBytesListener", "Lkotlin/Function1;", "", "", "notifyConnectionStatusChanged", "old", "", "new", "onReceiveMessage", "cmdType", "message", "", "initialize", "release", "onStatusChanged", "oldStatus", "newStatus", "onReceive", WsConstants.KEY_PAYLOAD, "connect", "disconnect", "connectionStatus", "send", "header", "Companion", "ConnectionStatus", "omnisdk-foundation_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniWebSocketCallByNative implements v.a, v.b {
    private static final Companion Companion = null;
    public static final int DISPATCH_COMMAND_SERVICE_ID = 33555736;
    public static final int DISPATCH_COMMAND_TYPE = 1;
    public static final int IM_COMMAND_TYPE = 0;
    public static final String TAG = "OmniWebSocketCallByNative";
    private final Function1<byte[], Unit> extraBytesListener;
    private final long nativePtr;
    private volatile ConnectionStatus status;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/dependency/OmniWebSocketCallByNative$Companion;", "", "<init>", "()V", "TAG", "", "DISPATCH_COMMAND_SERVICE_ID", "", "IM_COMMAND_TYPE", "DISPATCH_COMMAND_TYPE", "omnisdk-foundation_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/im/internal/jni/dependency/OmniWebSocketCallByNative$ConnectionStatus;", "", "status", "", "<init>", "(Ljava/lang/String;II)V", "getStatus", "()I", "UNKNOWN", "CONNECTING", "CONNECTED", State.DISCONNECTED, "omnisdk-foundation_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ConnectionStatus extends Enum<ConnectionStatus> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ ConnectionStatus[] $VALUES = null;
        public static final ConnectionStatus CONNECTED = null;
        public static final ConnectionStatus CONNECTING = null;
        public static final ConnectionStatus DISCONNECTED = null;
        public static final ConnectionStatus UNKNOWN = null;
        private final int status;

        private static final /* synthetic */ ConnectionStatus[] $values() {
            return new ConnectionStatus[]{UNKNOWN, CONNECTING, CONNECTED, DISCONNECTED};
        }

        public static EnumEntries<ConnectionStatus> getEntries() {
            return $ENTRIES;
        }

        static {
            UNKNOWN = new ConnectionStatus("UNKNOWN", 0, 0);
            CONNECTING = new ConnectionStatus("CONNECTING", 1, 1);
            CONNECTED = new ConnectionStatus("CONNECTED", 2, 2);
            DISCONNECTED = new ConnectionStatus(State.DISCONNECTED, 3, 3);
            ConnectionStatus[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static ConnectionStatus[] values() {
            return (ConnectionStatus[]) $VALUES.clone();
        }

        public final int getStatus() {
            return this.status;
        }

        public static ConnectionStatus valueOf(String r100) {
            return (ConnectionStatus) r27.a.a(ConnectionStatus.class, r100);
        }

        private ConnectionStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.status = r102;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ Unit a(OmniWebSocketCallByNative r100, byte[] r101) {
        return extraBytesListener$lambda$0(r100, r101);
    }

    private final native void notifyConnectionStatusChanged(long r100, int r101, int r102);

    private final native void onReceiveMessage(long r100, int r101, String r102);

    public final void connect() {
        o0.f348249a.connect();
    }

    public final int connectionStatus() {
        return this.status.getStatus();
    }

    public final void disconnect() {
        o0.f348249a.disconnect();
    }

    public final void initialize() {
        com.larus.im.internal.delegate.a.f348188b.i(TAG, "initialize");
        o0 r100 = o0.f348249a;
        r100.g(this);
        r100.i(this);
        n r101 = r100.b();
        if (r101 == null) goto L6;
        r101.a();
        r101.e(this.extraBytesListener);
        return;
    }

    public final void release() {
        com.larus.im.internal.delegate.a.f348188b.i(TAG, "release");
        o0 r100 = o0.f348249a;
        r100.c(this);
        r100.k(this);
        n r101 = r100.b();
        if (r101 == null) goto L6;
        r101.b();
        r101.d(this.extraBytesListener);
        return;
    }

    public OmniWebSocketCallByNative(long r100) {
        this.nativePtr = r100;
        this.status = ConnectionStatus.UNKNOWN;
        this.extraBytesListener = new g(this);
    }

    private final void setStatus(ConnectionStatus r100) {
        if (this.status != r100) goto L5;
        return;
    L5:
        if (r100 == ConnectionStatus.UNKNOWN) goto L9;
        notifyConnectionStatusChanged(this.nativePtr, this.status.getStatus(), r100.getStatus());
        this.status = r100;
        return;
    }

    @Override // gd9.v.a
    public void onReceive(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        com.larus.im.internal.delegate.a.f348188b.i(TAG, "onReceive im cmd, bytesSize=" + r100.length);
        long r101 = this.nativePtr;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        onReceiveMessage(r101, 0, StringsKt.decodeToString(r100));
    }

    private static final Unit extraBytesListener$lambda$0(OmniWebSocketCallByNative r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        com.larus.im.internal.delegate.a.f348188b.i(TAG, "onReceive dispatch command, bytesSize=" + r101.length);
        long r102 = r100.nativePtr;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        r100.onReceiveMessage(r102, 1, StringsKt.decodeToString(r101));
        return Unit.INSTANCE;
    }

    @Override // gd9.v.b
    public void onStatusChanged(int r100, int r101) {
        if (r101 != 0) goto L4;
        setStatus(ConnectionStatus.DISCONNECTED);
        return;
    L4:
        if (r101 != 1) goto L6;
        setStatus(ConnectionStatus.CONNECTED);
        return;
    L6:
        if (r101 != 2) goto L14;
        setStatus(ConnectionStatus.CONNECTING);
        return;
    }

    public final void send(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "header");
        o0 r102 = o0.f348249a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r102.a(StringsKt.encodeToByteArray(r100), k.d(r101));
    }
}
