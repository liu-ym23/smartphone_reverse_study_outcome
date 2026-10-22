package com.ss.android.lark.chameleonv2.lkapi.transport;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\u0012\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J2\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Ipc$TransportPushDetail;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ee/util/io/NonProguard;", "command", "", "content", "packet", "Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Ipc$RustSdkPacketDetail;", "<init>", "(ILjava/lang/Object;Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Ipc$RustSdkPacketDetail;)V", "getCommand", "()I", "getContent", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getPacket", "()Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Ipc$RustSdkPacketDetail;", "component1", "component2", "component3", "copy", "(ILjava/lang/Object;Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Ipc$RustSdkPacketDetail;)Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Ipc$TransportPushDetail;", "equals", "", "other", "", "hashCode", "toString", "", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ITransport$Ipc$TransportPushDetail<T> implements NonProguard {
    private final int command;
    private final T content;
    private final ITransport$Ipc$RustSdkPacketDetail packet;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ITransport$Ipc$TransportPushDetail copy$default(ITransport$Ipc$TransportPushDetail r100, int r101, Object r102, ITransport$Ipc$RustSdkPacketDetail r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.command;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.content;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.packet;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.command;
    }

    public final T component2() {
        return this.content;
    }

    public final ITransport$Ipc$RustSdkPacketDetail component3() {
        return this.packet;
    }

    public final ITransport$Ipc$TransportPushDetail<T> copy(int r100, T r101, ITransport$Ipc$RustSdkPacketDetail r102) {
        Intrinsics.checkNotNullParameter(r102, "packet");
        return new ITransport$Ipc$TransportPushDetail(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ITransport$Ipc$TransportPushDetail) == true) goto L8;
        return false;
    L8:
        ITransport$Ipc$TransportPushDetail r101 = (ITransport$Ipc$TransportPushDetail) r100;
        if (this.command == r101.command) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.packet, r101.packet) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.command * 31;
        T r101 = this.content;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.packet.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "TransportPushDetail(command=" + this.command + ", content=" + this.content + ", packet=" + this.packet + ')';
    }

    public final int getCommand() {
        return this.command;
    }

    public final T getContent() {
        return this.content;
    }

    public final ITransport$Ipc$RustSdkPacketDetail getPacket() {
        return this.packet;
    }

    public ITransport$Ipc$TransportPushDetail(int r100, T r101, ITransport$Ipc$RustSdkPacketDetail r102) {
        Intrinsics.checkNotNullParameter(r102, "packet");
        this.command = r100;
        this.content = r101;
        this.packet = r102;
    }
}
