package cq8;

import com.larus.bmhome.instruction.core.model.widget.TranslatorSelectorType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class w0 extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TranslatorSelectorType f464991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f464992d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w0) == true) goto L8;
        return false;
    L8:
        w0 r101 = (w0) r100;
        if (Intrinsics.areEqual(this.f464990b, r101.f464990b) == true) goto L12;
        return false;
    L12:
        if (this.f464991c == r101.f464991c) goto L15;
        return false;
    L15:
        if (this.f464992d == r101.f464992d) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f464990b.hashCode() * 31) + this.f464991c.hashCode()) * 31;
        long r101 = this.f464992d;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "TranslatorLanguageSelectAction(widgetId=" + this.f464990b + ", selectorType=" + this.f464991c + ", optionId=" + this.f464992d + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.f464990b;
    }

    public w0(String r100, TranslatorSelectorType r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "selectorType");
        super("TranslatorLanguageSelectAction");
        this.f464990b = r100;
        this.f464991c = r101;
        this.f464992d = r102;
    }
}
