package x76;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends CharacterStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f562824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f562825b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f562824a, r101.f562824a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f562825b, r101.f562825b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f562824a.hashCode() * 31) + this.f562825b.hashCode();
    }

    public final String toString() {
        return "LynxMentionSpan(name=" + this.f562824a + ", symbol=" + this.f562825b + ')';
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
    }

    public b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "symbol");
        this.f562824a = r100;
        this.f562825b = r101;
    }
}
