package e8c;

import com.bytedance.lark.pb.basic.v1.Chatter;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f471417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f471418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f471419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Chatter> f471420d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f471417a, r101.f471417a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f471418b, r101.f471418b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f471419c, r101.f471419c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f471420d, r101.f471420d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.f471417a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.f471418b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.f471419c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Chatter> r110 = this.f471420d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MentionData(wanted_mention_ids=" + this.f471417a + ", in_chat_chatter_ids=" + this.f471418b + ", out_chat_chatter_ids=" + this.f471419c + ", chatters=" + this.f471420d + ')';
    }

    public a(List<String> r100, List<String> r101, List<String> r102, Map<String, Chatter> r103) {
        this.f471417a = r100;
        this.f471418b = r101;
        this.f471419c = r102;
        this.f471420d = r103;
    }
}
