package p6c;

import com.ss.android.lark.chat.entity.chat.ChatTab;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f527970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ChatTab> f527971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f527972c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f527970a == r101.f527970a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f527971b, r101.f527971b) == true) goto L15;
        return false;
    L15:
        if (this.f527972c == r101.f527972c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f527970a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f527971b.hashCode()) * 31;
        long r102 = this.f527972c;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "ChatTabsListResult(chatId=" + this.f527970a + ", tabs=" + this.f527971b + ", version=" + this.f527972c + ')';
    }

    public c(long r100, List<ChatTab> r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "tabs");
        this.f527970a = r100;
        this.f527971b = r101;
        this.f527972c = r102;
    }
}
