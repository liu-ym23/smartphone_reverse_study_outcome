package com.bytedance.lark.sdk.refactor;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Packet;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Command f254277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Packet f254278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f254279c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ss.android.lark.pb.improto.Command f254280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.ss.android.lark.pb.improto.Packet f254281b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f254280a, r101.f254280a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f254281b, r101.f254281b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f254280a.hashCode() * 31) + this.f254281b.hashCode();
        }

        public final String toString() {
            return "ServerPushData(serverCommand=" + this.f254280a + ", packet=" + this.f254281b + ')';
        }

        public a(com.ss.android.lark.pb.improto.Command r100, com.ss.android.lark.pb.improto.Packet r101) {
            Intrinsics.checkNotNullParameter(r100, "serverCommand");
            Intrinsics.checkNotNullParameter(r101, "packet");
            this.f254280a = r100;
            this.f254281b = r101;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f254277a, r101.f254277a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f254278b, r101.f254278b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f254279c, r101.f254279c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f254277a.hashCode() * 31) + this.f254278b.hashCode()) * 31;
        a r101 = this.f254279c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "PushData(command=" + this.f254277a + ", packet=" + this.f254278b + ", serverPush=" + this.f254279c + ')';
    }

    public final byte[] a() {
        ByteString r100 = this.f254278b.payload;
        if (r100 != null) goto L6;
        r100 = ByteString.EMPTY;
    L6:
        return r100.toByteArray();
    }

    public q(Command r100, Packet r101, a r102) {
        Intrinsics.checkNotNullParameter(r100, "command");
        Intrinsics.checkNotNullParameter(r101, "packet");
        this.f254277a = r100;
        this.f254278b = r101;
        this.f254279c = r102;
    }
}
