package com.ss.android.lark.chameleonv2.lkapi.transport;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003JP\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\t\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006%"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$CallServerApiRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "command", "", "params", "", "pb", "Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Protobuf;", "contextId", "isPacketBuffer", "", "userId", "<init>", "(ILjava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Protobuf;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getCommand", "()I", "getParams", "()Ljava/lang/String;", "getPb", "()Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Protobuf;", "getContextId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Protobuf;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$CallServerApiRequest;", "equals", "other", "", "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ITransport$Internal$CallServerApiRequest implements NonProguard {
    private final int command;
    private final String contextId;
    private final Boolean isPacketBuffer;
    private final String params;

    /* JADX INFO: renamed from: pb, reason: collision with root package name */
    private final ITransport$Internal$Protobuf f411450pb;
    private final String userId;

    public static /* synthetic */ ITransport$Internal$CallServerApiRequest copy$default(ITransport$Internal$CallServerApiRequest r100, int r101, String r102, ITransport$Internal$Protobuf r103, String r104, Boolean r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.command;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.params;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.f411450pb;
    L11:
        ITransport$Internal$Protobuf r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.contextId;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.isPacketBuffer;
    L17:
        Boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.userId;
    L20:
        int r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final int component1() {
        return this.command;
    }

    public final String component2() {
        return this.params;
    }

    public final ITransport$Internal$Protobuf component3() {
        return this.f411450pb;
    }

    public final String component4() {
        return this.contextId;
    }

    public final Boolean component5() {
        return this.isPacketBuffer;
    }

    public final String component6() {
        return this.userId;
    }

    public final ITransport$Internal$CallServerApiRequest copy(int r100, String r110, ITransport$Internal$Protobuf r111, String r112, Boolean r113, String r114) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "pb");
        return new ITransport$Internal$CallServerApiRequest(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ITransport$Internal$CallServerApiRequest) == true) goto L8;
        return false;
    L8:
        ITransport$Internal$CallServerApiRequest r101 = (ITransport$Internal$CallServerApiRequest) r100;
        if (this.command == r101.command) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f411450pb, r101.f411450pb) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.contextId, r101.contextId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isPacketBuffer, r101.isPacketBuffer) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.command * 31) + this.params.hashCode()) * 31) + this.f411450pb.hashCode()) * 31;
        String r101 = this.contextId;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Boolean r105 = this.isPacketBuffer;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.userId;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "CallServerApiRequest(command=" + this.command + ", params=" + this.params + ", pb=" + this.f411450pb + ", contextId=" + this.contextId + ", isPacketBuffer=" + this.isPacketBuffer + ", userId=" + this.userId + ')';
    }

    public final int getCommand() {
        return this.command;
    }

    public final String getContextId() {
        return this.contextId;
    }

    public final String getParams() {
        return this.params;
    }

    public final ITransport$Internal$Protobuf getPb() {
        return this.f411450pb;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final Boolean isPacketBuffer() {
        return this.isPacketBuffer;
    }

    public ITransport$Internal$CallServerApiRequest(int r100, String r101, ITransport$Internal$Protobuf r102, String r103, Boolean r104, String r105) {
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "pb");
        this.command = r100;
        this.params = r101;
        this.f411450pb = r102;
        this.contextId = r103;
        this.isPacketBuffer = r104;
        this.userId = r105;
    }
}
