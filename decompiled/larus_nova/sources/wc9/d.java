package wc9;

import com.larus.im.bean.conversation.ParticipantModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f559195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ParticipantModel> f559196b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f559195a, r101.f559195a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f559196b, r101.f559196b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f559195a.hashCode() * 31) + this.f559196b.hashCode();
    }

    public final String toString() {
        return "ConvParticipantResp(conversationId=" + this.f559195a + ", participants=" + this.f559196b + ')';
    }

    public d(String r100, List<ParticipantModel> r101) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "participants");
        this.f559195a = r100;
        this.f559196b = r101;
    }
}
