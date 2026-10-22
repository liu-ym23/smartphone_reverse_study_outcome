package vj8;

import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f555428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f555429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f555430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Message f555431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f555432e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f555433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f555434g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f555435h;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f555428a, r101.f555428a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f555429b, r101.f555429b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f555430c, r101.f555430c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f555431d, r101.f555431d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f555432e, r101.f555432e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f555433f, r101.f555433f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f555434g, r101.f555434g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f555435h, r101.f555435h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f555428a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f555429b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f555430c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Message r110 = this.f555431d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f555432e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f555433f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f555434g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Map<String, String> r122 = this.f555435h;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "CommonButtonVMData(displayText=" + this.f555428a + ", iconUrlLight=" + this.f555429b + ", iconUrlDark=" + this.f555430c + ", message=" + this.f555431d + ", conversationId=" + this.f555432e + ", command=" + this.f555433f + ", messageText=" + this.f555434g + ", extra=" + this.f555435h + ')';
    }

    public /* synthetic */ a(int r110) {
        this(null, null, null, null, null, null, null, null);
    }

    public a(String r100, String r101, String r102, Message r103, String r104, String r105, String r106, Map<String, String> r107) {
        this.f555428a = r100;
        this.f555429b = r101;
        this.f555430c = r102;
        this.f555431d = r103;
        this.f555432e = r104;
        this.f555433f = r105;
        this.f555434g = r106;
        this.f555435h = r107;
    }
}
