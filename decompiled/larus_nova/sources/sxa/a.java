package sxa;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Chat f543850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChatChatter f543851b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f543850a, r101.f543850a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f543851b, r101.f543851b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f543850a.hashCode() * 31;
        ChatChatter r101 = this.f543851b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "TitleBinderContext(chat=" + this.f543850a + ", chatter=" + this.f543851b + ')';
    }

    public a(Chat r100, ChatChatter r101) {
        Intrinsics.checkNotNullParameter(r100, "chat");
        this.f543850a = r100;
        this.f543851b = r101;
    }
}
