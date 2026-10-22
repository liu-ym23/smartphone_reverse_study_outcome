package kn8;

import com.larus.bmhome.chat.markdown.reference.SearchReferenceData;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f504279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f504280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f504281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SearchReferenceData f504282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f504283e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f504279a, r101.f504279a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f504280b, r101.f504280b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f504281c, r101.f504281c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f504282d, r101.f504282d) == true) goto L21;
        return false;
    L21:
        if (this.f504283e == r101.f504283e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Message r100 = this.f504279a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f504280b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f504281c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        SearchReferenceData r110 = this.f504282d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        int r111 = (r109 + r101) * 31;
        if (this.f504283e == false) goto L21;
        int r112 = 1231;
    L23:
        return r111 + r112;
    L21:
        r112 = 1237;
        goto L23
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SearchCotZoomInVMData(message=" + this.f504279a + ", chatType=" + this.f504280b + ", cardPosition=" + this.f504281c + ", searchReferenceData=" + this.f504282d + ", isDeepThinking=" + this.f504283e + ')';
    }

    public d(Message r100, SearchReferenceData r101) {
        this.f504279a = r100;
        this.f504280b = null;
        this.f504281c = null;
        this.f504282d = r101;
        this.f504283e = true;
    }
}
