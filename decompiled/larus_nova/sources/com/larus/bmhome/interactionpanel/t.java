package com.larus.bmhome.interactionpanel;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class t {

    public static final class a extends t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f312417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f312418b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Block> f312419c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f312420d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f312421e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f312417a, r101.f312417a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f312418b, r101.f312418b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f312419c, r101.f312419c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f312420d, r101.f312420d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f312421e, r101.f312421e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f312417a.hashCode() * 31) + this.f312418b.hashCode()) * 31) + this.f312419c.hashCode()) * 31) + this.f312420d.hashCode()) * 31) + this.f312421e.hashCode();
        }

        public final String toString() {
            return "CmdBlockForMainHost(conversationId=" + this.f312417a + ", threadId=" + this.f312418b + ", blocks=" + this.f312419c + ", messageId=" + this.f312420d + ", organizerMessageId=" + this.f312421e + ')';
        }

        public a(String r100, String r101, List<Block> r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            Intrinsics.checkNotNullParameter(r101, "threadId");
            Intrinsics.checkNotNullParameter(r102, "blocks");
            Intrinsics.checkNotNullParameter(r103, "messageId");
            Intrinsics.checkNotNullParameter(r104, "organizerMessageId");
            this.f312417a = r100;
            this.f312418b = r101;
            this.f312419c = r102;
            this.f312420d = r103;
            this.f312421e = r104;
        }
    }

    public static final class b extends t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Message f312422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Block> f312423b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f312422a, r101.f312422a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f312423b, r101.f312423b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f312422a.hashCode() * 31) + this.f312423b.hashCode();
        }

        public final String toString() {
            return "MessageBlock(message=" + this.f312422a + ", blocks=" + this.f312423b + ')';
        }

        public b(Message r100, List<Block> r101) {
            Intrinsics.checkNotNullParameter(r100, "message");
            Intrinsics.checkNotNullParameter(r101, "blocks");
            this.f312422a = r100;
            this.f312423b = r101;
        }
    }

    public t() {
    }
}
