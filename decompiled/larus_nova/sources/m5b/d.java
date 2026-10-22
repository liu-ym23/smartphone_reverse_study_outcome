package m5b;

import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f512218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f512219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RichText f512220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PartialReplyInfo f512221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f512222e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f512218a, r101.f512218a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f512219b, r101.f512219b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f512220c, r101.f512220c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f512221d, r101.f512221d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f512222e, r101.f512222e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f512218a.hashCode() * 31) + this.f512219b.hashCode()) * 31) + this.f512220c.hashCode()) * 31;
        PartialReplyInfo r101 = this.f512221d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        e r105 = this.f512222e;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FinalSendInfo(title=" + this.f512218a + ", content=" + this.f512219b + ", richText=" + this.f512220c + ", partialReplyInfo=" + this.f512221d + ", sendInfoExtraParam=" + this.f512222e + ')';
    }

    public d(String r100, String r101, RichText r102, PartialReplyInfo r103, e r104) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "richText");
        this.f512218a = r100;
        this.f512219b = r101;
        this.f512220c = r102;
        this.f512221d = r103;
        this.f512222e = r104;
    }
}
