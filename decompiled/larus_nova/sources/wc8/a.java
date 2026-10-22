package wc8;

import com.larus.im.bean.IMMetaInfo;
import com.larus.im.bean.message.RichMediaMeta;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f559184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IMMetaInfo.InsertTextReference f559185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RichMediaMeta f559186c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f559184a, r101.f559184a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f559185b, r101.f559185b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f559186c, r101.f559186c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f559184a.hashCode() * 31) + this.f559185b.hashCode()) * 31;
        RichMediaMeta r101 = this.f559186c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "InsertTextReferenceCache(realValue=" + this.f559184a + ", reference=" + this.f559185b + ", richMediaMeta=" + this.f559186c + ')';
    }

    public a(String r100, IMMetaInfo.InsertTextReference r101, RichMediaMeta r102) {
        Intrinsics.checkNotNullParameter(r100, "realValue");
        Intrinsics.checkNotNullParameter(r101, "reference");
        this.f559184a = r100;
        this.f559185b = r101;
        this.f559186c = r102;
    }
}
