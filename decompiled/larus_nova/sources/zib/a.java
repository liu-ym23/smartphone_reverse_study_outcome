package zib;

import com.ss.android.lark.chat.entity.message.Message;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f572302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f572303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f572304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f572305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Message> f572306e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f572302a, r101.f572302a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f572303b, r101.f572303b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f572304c, r101.f572304c) == true) goto L18;
        return false;
    L18:
        if (this.f572305d == r101.f572305d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f572306e, r101.f572306e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f572302a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f572303b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f572304c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return ((((r106 + r101) * 31) + this.f572305d) * 31) + this.f572306e.hashCode();
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "EventParamsV3(userId=" + this.f572302a + ", chatId=" + this.f572303b + ", threadId=" + this.f572304c + ", chatType=" + this.f572305d + ", messages=" + this.f572306e + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, String r101, String r102, int r103, Map<String, ? extends Message> r104) {
        Intrinsics.checkNotNullParameter(r104, "messages");
        this.f572302a = r100;
        this.f572303b = r101;
        this.f572304c = r102;
        this.f572305d = r103;
        this.f572306e = r104;
    }
}
