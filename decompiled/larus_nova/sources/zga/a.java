package zga;

import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f572100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f572101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f572102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ObricInteractionType f572103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f572104e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f572100a, r101.f572100a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f572101b, r101.f572101b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f572102c, r101.f572102c) == true) goto L18;
        return false;
    L18:
        if (this.f572103d == r101.f572103d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f572104e, r101.f572104e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f572100a.hashCode() * 31;
        String r101 = this.f572101b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((((r100 + r102) * 31) + this.f572102c.hashCode()) * 31) + this.f572103d.hashCode()) * 31) + this.f572104e.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ActiveModeSnapshot(botId=" + this.f572100a + ", conversationId=" + this.f572101b + ", sessionId=" + this.f572102c + ", interactionType=" + this.f572103d + ", ext=" + this.f572104e + ')';
    }

    public a(String r100, String r101, String r102, ObricInteractionType r103, Map<String, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        Intrinsics.checkNotNullParameter(r103, "interactionType");
        Intrinsics.checkNotNullParameter(r104, "ext");
        this.f572100a = r100;
        this.f572101b = r101;
        this.f572102c = r102;
        this.f572103d = r103;
        this.f572104e = r104;
    }
}
