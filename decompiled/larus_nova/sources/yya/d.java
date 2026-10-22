package yya;

import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MessageActionType f569507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f569508b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f569507a == r101.f569507a) goto L12;
        return false;
    L12:
        if (this.f569508b == r101.f569508b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f569507a.hashCode() * 31) + this.f569508b;
    }

    public final String toString() {
        return "ExtraMessageActionContent(type=" + this.f569507a + ", label=" + this.f569508b + ')';
    }

    public final MessageActionType getType() {
        return this.f569507a;
    }

    public d(MessageActionType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f569507a = r100;
        this.f569508b = 0;
    }
}
