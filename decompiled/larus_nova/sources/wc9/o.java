package wc9;

import com.larus.im.bean.conversation.ConversationArchiveFilter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f559255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f559256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f559257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConversationArchiveFilter f559258d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (this.f559255a == r101.f559255a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f559256b, r101.f559256b) == true) goto L15;
        return false;
    L15:
        if (this.f559257c == r101.f559257c) goto L18;
        return false;
    L18:
        if (this.f559258d == r101.f559258d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f559255a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        e r102 = this.f559256b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return ((((r101 + r103) * 31) + this.f559257c) * 31) + this.f559258d.hashCode();
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "LoadConversationsRequestNew(withBrief=" + this.f559255a + ", anchorConv=" + this.f559256b + ", pageSize=" + this.f559257c + ", archiveFilter=" + this.f559258d + ')';
    }

    public o(e r100, int r101, ConversationArchiveFilter r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        boolean r104 = true;
    L7:
        if ((r103 & 8) == 0) goto L9;
        r102 = ConversationArchiveFilter.ALL;
    L9:
        Intrinsics.checkNotNullParameter(r102, "archiveFilter");
        this.f559255a = r104;
        this.f559256b = r100;
        this.f559257c = r101;
        this.f559258d = r102;
        return;
    L5:
        r104 = false;
        goto L7
    }
}
