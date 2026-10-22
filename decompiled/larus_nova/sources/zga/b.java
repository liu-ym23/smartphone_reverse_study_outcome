package zga;

import com.obric.assistant.state.api.multitask.ForegroundInteractionPhase;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f572105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f572106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ObricInteractionType f572107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f572108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ForegroundInteractionPhase f572109e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f572105a, r101.f572105a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f572106b, r101.f572106b) == true) goto L15;
        return false;
    L15:
        if (this.f572107c == r101.f572107c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f572108d, r101.f572108d) == true) goto L21;
        return false;
    L21:
        if (this.f572109e == r101.f572109e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f572105a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f572106b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f572107c.hashCode()) * 31;
        String r107 = this.f572108d;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return ((r106 + r101) * 31) + this.f572109e.hashCode();
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "InteractionProjection(botId=" + this.f572105a + ", conversationId=" + this.f572106b + ", currentInteractionType=" + this.f572107c + ", currentModeSessionId=" + this.f572108d + ", foregroundPhase=" + this.f572109e + ')';
    }

    public final boolean b() {
        ForegroundInteractionPhase r100 = this.f572109e;
        if (r100 != ForegroundInteractionPhase.Activate) goto L5;
    L10:
        return true;
    L5:
        if (r100 == ForegroundInteractionPhase.Connecting) goto L10;
        if (r100 == ForegroundInteractionPhase.Listen) goto L10;
        return false;
    }

    public static b a(b r100, ForegroundInteractionPhase r101) {
        String r102 = r100.f572105a;
        String r103 = r100.f572106b;
        ObricInteractionType r104 = r100.f572107c;
        String r105 = r100.f572108d;
        Intrinsics.checkNotNullParameter(r104, "currentInteractionType");
        Intrinsics.checkNotNullParameter(r101, "foregroundPhase");
        return new b(r102, r103, r104, r105, r101);
    }

    public b(String r100, String r101, ObricInteractionType r102, String r103, ForegroundInteractionPhase r104) {
        Intrinsics.checkNotNullParameter(r102, "currentInteractionType");
        Intrinsics.checkNotNullParameter(r104, "foregroundPhase");
        this.f572105a = r100;
        this.f572106b = r101;
        this.f572107c = r102;
        this.f572108d = r103;
        this.f572109e = r104;
    }
}
