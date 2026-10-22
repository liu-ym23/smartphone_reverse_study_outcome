package kb8;

import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.Reference;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f502224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f502225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f502226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Reference> f502227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o f502228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f502229f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f502230g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DeepThinkFoldStatus f502231h;

    public a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f502224a, r101.f502224a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502225b, r101.f502225b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f502226c, r101.f502226c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f502227d, r101.f502227d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f502228e, r101.f502228e) == true) goto L24;
        return false;
    L24:
        if (this.f502229f == r101.f502229f) goto L27;
        return false;
    L27:
        if (this.f502230g == r101.f502230g) goto L30;
        return false;
    L30:
        if (this.f502231h == r101.f502231h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f502224a.hashCode() * 31) + this.f502225b.hashCode()) * 31;
        List<String> r101 = this.f502226c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.f502227d.hashCode()) * 31) + this.f502228e.hashCode()) * 31;
        int r104 = 1231;
        if (this.f502229f == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f502230g == true) goto L15;
        r104 = 1237;
    L15:
        return ((r106 + r104) * 31) + this.f502231h.hashCode();
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "QueryKeywordReferencesVMData(message=" + this.f502224a + ", messageId=" + this.f502225b + ", queries=" + this.f502226c + ", referenceList=" + this.f502227d + ", referenceData=" + this.f502228e + ", isDeepThinkingStreaming=" + this.f502229f + ", needNotifyLastItemChanged=" + this.f502230g + ", foldStatus=" + this.f502231h + ')';
    }

    public a(Message r100, String r101, List r102, List r103, o r104, boolean r105, int r106) {
        if ((r106 & 32) == 0) goto L6;
        r105 = false;
    L6:
        if ((r106 & 128) == 0) goto L8;
        DeepThinkFoldStatus r107 = DeepThinkFoldStatus.CompleteExpand;
    L9:
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r103, "referenceList");
        Intrinsics.checkNotNullParameter(r104, "referenceData");
        Intrinsics.checkNotNullParameter(r107, "foldStatus");
        this.f502224a = r100;
        this.f502225b = r101;
        this.f502226c = r102;
        this.f502227d = r103;
        this.f502228e = r104;
        this.f502229f = r105;
        this.f502230g = false;
        this.f502231h = r107;
        return;
    L8:
        r107 = null;
        goto L9
    }
}
