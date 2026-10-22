package com.ss.android.lark.chameleonv2.lkapi.transport;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jt\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0015\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\f\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u0006."}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$CallRustApiRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "command", "", "params", "", "pb", "Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Protobuf;", "collectTrace", "", "contextId", "extendParams", "isPacketBuffer", "spanId", "userId", "<init>", "(ILjava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Protobuf;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getCommand", "()I", "getParams", "()Ljava/lang/String;", "getPb", "()Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Protobuf;", "getCollectTrace", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getContextId", "getExtendParams", "getSpanId", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Protobuf;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$CallRustApiRequest;", "equals", "other", "", "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ITransport$Internal$CallRustApiRequest implements NonProguard {
    private final Boolean collectTrace;
    private final int command;
    private final String contextId;
    private final String extendParams;
    private final Boolean isPacketBuffer;
    private final String params;

    /* JADX INFO: renamed from: pb, reason: collision with root package name */
    private final ITransport$Internal$Protobuf f411449pb;
    private final String spanId;
    private final String userId;

    public static /* synthetic */ ITransport$Internal$CallRustApiRequest copy$default(ITransport$Internal$CallRustApiRequest r110, int r111, String r112, ITransport$Internal$Protobuf r113, Boolean r114, String r115, String r116, Boolean r117, String r118, String r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        int r100 = r110.command;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.params;
    L11:
        if ((r210 & 4) == 0) goto L13;
        ITransport$Internal$Protobuf r102 = r110.f411449pb;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Boolean r103 = r110.collectTrace;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.contextId;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.extendParams;
    L27:
        if ((r210 & 64) == 0) goto L29;
        Boolean r106 = r110.isPacketBuffer;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r107 = r110.spanId;
    L35:
        if ((r210 & 256) == 0) goto L37;
        String r108 = r110.userId;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.command;
    }

    public final String component2() {
        return this.params;
    }

    public final ITransport$Internal$Protobuf component3() {
        return this.f411449pb;
    }

    public final Boolean component4() {
        return this.collectTrace;
    }

    public final String component5() {
        return this.contextId;
    }

    public final String component6() {
        return this.extendParams;
    }

    public final Boolean component7() {
        return this.isPacketBuffer;
    }

    public final String component8() {
        return this.spanId;
    }

    public final String component9() {
        return this.userId;
    }

    public final ITransport$Internal$CallRustApiRequest copy(int r110, String r111, ITransport$Internal$Protobuf r112, Boolean r113, String r114, String r115, Boolean r116, String r117, String r210) {
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r112, "pb");
        return new ITransport$Internal$CallRustApiRequest(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ITransport$Internal$CallRustApiRequest) == true) goto L8;
        return false;
    L8:
        ITransport$Internal$CallRustApiRequest r101 = (ITransport$Internal$CallRustApiRequest) r100;
        if (this.command == r101.command) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f411449pb, r101.f411449pb) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.collectTrace, r101.collectTrace) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.contextId, r101.contextId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.extendParams, r101.extendParams) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.isPacketBuffer, r101.isPacketBuffer) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.spanId, r101.spanId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.command * 31) + this.params.hashCode()) * 31) + this.f411449pb.hashCode()) * 31;
        Boolean r101 = this.collectTrace;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.contextId;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.extendParams;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Boolean r111 = this.isPacketBuffer;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.spanId;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.userId;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "CallRustApiRequest(command=" + this.command + ", params=" + this.params + ", pb=" + this.f411449pb + ", collectTrace=" + this.collectTrace + ", contextId=" + this.contextId + ", extendParams=" + this.extendParams + ", isPacketBuffer=" + this.isPacketBuffer + ", spanId=" + this.spanId + ", userId=" + this.userId + ')';
    }

    public final Boolean getCollectTrace() {
        return this.collectTrace;
    }

    public final int getCommand() {
        return this.command;
    }

    public final String getContextId() {
        return this.contextId;
    }

    public final String getExtendParams() {
        return this.extendParams;
    }

    public final String getParams() {
        return this.params;
    }

    public final ITransport$Internal$Protobuf getPb() {
        return this.f411449pb;
    }

    public final String getSpanId() {
        return this.spanId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final Boolean isPacketBuffer() {
        return this.isPacketBuffer;
    }

    public ITransport$Internal$CallRustApiRequest(int r100, String r101, ITransport$Internal$Protobuf r102, Boolean r103, String r104, String r105, Boolean r106, String r107, String r110) {
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "pb");
        this.command = r100;
        this.params = r101;
        this.f411449pb = r102;
        this.collectTrace = r103;
        this.contextId = r104;
        this.extendParams = r105;
        this.isPacketBuffer = r106;
        this.spanId = r107;
        this.userId = r110;
    }
}
