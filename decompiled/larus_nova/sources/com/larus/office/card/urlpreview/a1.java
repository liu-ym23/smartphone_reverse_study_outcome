package com.larus.office.card.urlpreview;

import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.Block;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f361823a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r f361824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f361825b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Block f361826c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ArtifactBlock f361827d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f361828e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f361824a, r101.f361824a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f361825b, r101.f361825b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f361826c, r101.f361826c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f361827d, r101.f361827d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f361828e, r101.f361828e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f361824a.hashCode() * 31) + this.f361825b.hashCode()) * 31) + this.f361826c.hashCode()) * 31) + this.f361827d.hashCode()) * 31;
            String r101 = this.f361828e;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Candidate(key=" + this.f361824a + ", persistenceKey=" + this.f361825b + ", block=" + this.f361826c + ", artifact=" + this.f361827d + ", url=" + this.f361828e + ')';
        }

        public a(r r100, String r101, Block r102, ArtifactBlock r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "persistenceKey");
            Intrinsics.checkNotNullParameter(r102, "block");
            Intrinsics.checkNotNullParameter(r103, "artifact");
            this.f361824a = r100;
            this.f361825b = r101;
            this.f361826c = r102;
            this.f361827d = r103;
            this.f361828e = r104;
        }
    }

    static {
    }
}
