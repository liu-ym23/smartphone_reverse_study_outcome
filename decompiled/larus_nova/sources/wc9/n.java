package wc9;

import com.larus.im.bean.conversation.ConversationArchiveFilter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f559250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f559251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f559252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f559253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConversationArchiveFilter f559254e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f559250a == r101.f559250a) goto L12;
        return false;
    L12:
        if (this.f559251b == r101.f559251b) goto L15;
        return false;
    L15:
        if (this.f559252c == r101.f559252c) goto L18;
        return false;
    L18:
        if (this.f559253d == r101.f559253d) goto L21;
        return false;
    L21:
        if (this.f559254e == r101.f559254e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f559250a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f559251b == true) goto L11;
        r100 = 1237;
    L11:
        return ((((((r102 + r100) * 31) + this.f559252c) * 31) + this.f559253d) * 31) + this.f559254e.hashCode();
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "LoadConversationsRequest(withBrief=" + this.f559250a + ", enablePaging=" + this.f559251b + ", firstLimitSize=" + this.f559252c + ", pagingLimitSize=" + this.f559253d + ", archiveFilter=" + this.f559254e + ')';
    }

    public n() {
        ConversationArchiveFilter r100 = ConversationArchiveFilter.ALL;
        Intrinsics.checkNotNullParameter(r100, "archiveFilter");
        this.f559250a = true;
        this.f559251b = false;
        this.f559252c = 20;
        this.f559253d = 50;
        this.f559254e = r100;
    }
}
