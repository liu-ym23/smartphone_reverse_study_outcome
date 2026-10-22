package kc8;

import android.view.View;
import com.larus.im.bean.message.Message;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<View, Message, Boolean> f502522a;

    public l() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f502522a, ((l) r100).f502522a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Function2<View, Message, Boolean> r100 = this.f502522a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "CodeBlockConfig(codeSelectionHandler=" + this.f502522a + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(Function2<? super View, ? super Message, Boolean> r100) {
        this.f502522a = r100;
    }
}
