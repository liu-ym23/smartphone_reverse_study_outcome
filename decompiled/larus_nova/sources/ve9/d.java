package ve9;

import com.huawei.hms.api.FailedBinderCallBack;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f554433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f554434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f554435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f554436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f554437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f554438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f554439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f554440h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f554441i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f554442j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, String> f554443k;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f554433a, r101.f554433a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f554434b, r101.f554434b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f554435c, r101.f554435c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f554436d, r101.f554436d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f554437e, r101.f554437e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f554438f, r101.f554438f) == true) goto L27;
        return false;
    L27:
        if (this.f554439g == r101.f554439g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f554440h, r101.f554440h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f554441i, r101.f554441i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f554442j, r101.f554442j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f554443k, r101.f554443k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f554433a.hashCode() * 31) + this.f554434b.hashCode()) * 31) + this.f554435c.hashCode()) * 31) + this.f554436d.hashCode()) * 31) + this.f554437e.hashCode()) * 31) + this.f554438f.hashCode()) * 31;
        if (this.f554439g == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((((((r100 + r101) * 31) + this.f554440h.hashCode()) * 31) + this.f554441i.hashCode()) * 31) + this.f554442j.hashCode()) * 31) + this.f554443k.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ChatConfig(conversationId=" + this.f554433a + ", uid=" + this.f554434b + ", callId=" + this.f554435c + ", localCallId=" + this.f554436d + ", botId=" + this.f554437e + ", wakeWord=" + this.f554438f + ", isConfFetched=" + this.f554439g + ", lastSectionId=" + this.f554440h + ", lastMessageIndex=" + this.f554441i + ", projectId=" + this.f554442j + ", extra=" + this.f554443k + ')';
    }

    public /* synthetic */ d(int r110) {
        this("", "", "", "", "", "", false, "", "", "", MapsKt.emptyMap());
    }

    public d(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, String r107, String r110, String r111, Map<String, String> r112) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "uid");
        Intrinsics.checkNotNullParameter(r102, FailedBinderCallBack.CALLER_ID);
        Intrinsics.checkNotNullParameter(r103, "localCallId");
        Intrinsics.checkNotNullParameter(r104, "botId");
        Intrinsics.checkNotNullParameter(r105, "wakeWord");
        Intrinsics.checkNotNullParameter(r107, "lastSectionId");
        Intrinsics.checkNotNullParameter(r110, "lastMessageIndex");
        Intrinsics.checkNotNullParameter(r111, "projectId");
        Intrinsics.checkNotNullParameter(r112, "extra");
        this.f554433a = r100;
        this.f554434b = r101;
        this.f554435c = r102;
        this.f554436d = r103;
        this.f554437e = r104;
        this.f554438f = r105;
        this.f554439g = r106;
        this.f554440h = r107;
        this.f554441i = r110;
        this.f554442j = r111;
        this.f554443k = r112;
    }
}
