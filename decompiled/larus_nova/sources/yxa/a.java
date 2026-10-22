package yxa;

import com.ss.android.lark.biz.im.api.extension.keyboard.config.EnterKeyBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnterKeyBehavior f569444a;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (this.f569444a == ((a) r100).f569444a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f569444a.hashCode();
    }

    public final String toString() {
        return "KeyboardConfig(enterKeyBehavior=" + this.f569444a + ')';
    }

    public a(EnterKeyBehavior r100) {
        Intrinsics.checkNotNullParameter(r100, "enterKeyBehavior");
        this.f569444a = r100;
    }

    public /* synthetic */ a(int r100) {
        this(EnterKeyBehavior.NEWLINE);
    }
}
