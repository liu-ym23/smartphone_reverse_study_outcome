package com.ss.android.lark.chameleonv2.lkapi.transport;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$SubscribePushInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "command", "", "pb", "", "<init>", "(ILjava/lang/String;)V", "getCommand", "()I", "getPb", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ITransport$Internal$SubscribePushInfo implements NonProguard {
    private final int command;

    /* JADX INFO: renamed from: pb, reason: collision with root package name */
    private final String f411451pb;

    public static /* synthetic */ ITransport$Internal$SubscribePushInfo copy$default(ITransport$Internal$SubscribePushInfo r100, int r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.command;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.f411451pb;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.command;
    }

    public final String component2() {
        return this.f411451pb;
    }

    public final ITransport$Internal$SubscribePushInfo copy(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "pb");
        return new ITransport$Internal$SubscribePushInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ITransport$Internal$SubscribePushInfo) == true) goto L8;
        return false;
    L8:
        ITransport$Internal$SubscribePushInfo r101 = (ITransport$Internal$SubscribePushInfo) r100;
        if (this.command == r101.command) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f411451pb, r101.f411451pb) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.command * 31) + this.f411451pb.hashCode();
    }

    public String toString() {
        return "SubscribePushInfo(command=" + this.command + ", pb=" + this.f411451pb + ')';
    }

    public final int getCommand() {
        return this.command;
    }

    public final String getPb() {
        return this.f411451pb;
    }

    public ITransport$Internal$SubscribePushInfo(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "pb");
        this.command = r100;
        this.f411451pb = r101;
    }
}
