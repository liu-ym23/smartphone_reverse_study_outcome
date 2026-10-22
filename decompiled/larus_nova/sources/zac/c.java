package zac;

import com.ss.android.lark.widget.richtext.RichText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RichText f571117b;

    public c() {
        this(null);
    }

    public final int hashCode() {
        String r100 = this.f571116a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        RichText r104 = this.f571117b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "VoiceContent(str=" + this.f571116a + ", richText=" + this.f571117b + ')';
    }

    public c(String r100) {
        this.f571116a = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof c) == false) goto L9;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f571116a, r101.f571116a) == false) goto L9;
        if (Intrinsics.areEqual(this.f571117b, r101.f571117b) == false) goto L9;
        return true;
    L9:
        return false;
    }
}
