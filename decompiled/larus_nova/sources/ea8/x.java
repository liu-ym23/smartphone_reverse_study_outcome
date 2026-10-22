package ea8;

import com.larus.avlink.simulInterpret.page.model.TextType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextType f471661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f471662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f471663c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (this.f471661a == r101.f471661a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f471662b, r101.f471662b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f471663c, r101.f471663c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f471661a.hashCode() * 31) + this.f471662b.hashCode()) * 31) + this.f471663c.hashCode();
    }

    public final String toString() {
        return "TranslationResultSentence(type=" + this.f471661a + ", id=" + this.f471662b + ", content=" + this.f471663c + ')';
    }

    public final TextType getType() {
        return this.f471661a;
    }

    public x(TextType r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "content");
        this.f471661a = r100;
        this.f471662b = r101;
        this.f471663c = r102;
    }
}
