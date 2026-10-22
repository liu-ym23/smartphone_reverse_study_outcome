package wc9;

import com.larus.im.bean.conversation.ParticipantModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f559243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ParticipantModel> f559244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f559245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f559246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f559247e;

    public k() {
        this(0, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f559243a == r101.f559243a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f559244b, r101.f559244b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f559245c, r101.f559245c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f559246d, r101.f559246d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f559247e, r101.f559247e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f559243a * 31;
        List<ParticipantModel> r101 = this.f559244b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Boolean r105 = this.f559245c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f559246d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f559247e;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
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

    public final String toString() {
        return "ConversationParticipantListResponse(type=" + this.f559243a + ", participants=" + this.f559244b + ", hasMore=" + this.f559245c + ", nextOffset=" + this.f559246d + ", totalParticipant=" + this.f559247e + ')';
    }

    public final int getType() {
        return this.f559243a;
    }

    public k(int r100, List r101, int r102) {
        Integer r103 = 0;
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r102 & 8) == 0) goto L11;
        Integer r104 = r103;
    L13:
        if ((r102 & 16) != 0) goto L16;
        r103 = null;
    L16:
        this.f559243a = r100;
        this.f559244b = r101;
        this.f559245c = null;
        this.f559246d = r104;
        this.f559247e = r103;
        return;
    L11:
        r104 = null;
        goto L13
    }
}
