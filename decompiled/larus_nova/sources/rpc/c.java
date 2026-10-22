package rpc;

import com.lark.kmp.pb.basic.v1.Command;
import com.lark.kmp.pb.basic.v1.Packet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Command f538906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Packet f538907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f538908c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.lark.kmp.server.pb.improto.Command f538909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.lark.kmp.server.pb.improto.Packet f538910b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f538909a == r101.f538909a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f538910b, r101.f538910b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f538909a.hashCode() * 31) + this.f538910b.hashCode();
        }

        public final String toString() {
            return "ServerPushData(serverCommand=" + this.f538909a + ", packet=" + this.f538910b + ')';
        }

        public a(com.lark.kmp.server.pb.improto.Command r100, com.lark.kmp.server.pb.improto.Packet r101) {
            Intrinsics.checkNotNullParameter(r100, "serverCommand");
            Intrinsics.checkNotNullParameter(r101, "packet");
            this.f538909a = r100;
            this.f538910b = r101;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f538906a == r101.f538906a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f538907b, r101.f538907b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f538908c, r101.f538908c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f538906a.hashCode() * 31) + this.f538907b.hashCode()) * 31;
        a r101 = this.f538908c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "PushData(command=" + this.f538906a + ", packet=" + this.f538907b + ", serverPush=" + this.f538908c + ')';
    }

    public c(Command r100, Packet r101, a r102) {
        Intrinsics.checkNotNullParameter(r100, "command");
        Intrinsics.checkNotNullParameter(r101, "packet");
        this.f538906a = r100;
        this.f538907b = r101;
        this.f538908c = r102;
    }
}
