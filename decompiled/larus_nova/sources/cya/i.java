package cya;

import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.keyboard.base.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class i {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f465980h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f465981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f465982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f465983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f465984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f465985e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f465986f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PartialReplyInfo f465987g;

    public static final class a implements n.a<i> {
        public static i a() {
            return new i("", "", "", false, null, 112);
        }

        public a() {
        }
    }

    static {
        f465980h = new a();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f465981a, r101.f465981a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465982b, r101.f465982b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465983c, r101.f465983c) == true) goto L18;
        return false;
    L18:
        if (this.f465984d == r101.f465984d) goto L21;
        return false;
    L21:
        if (this.f465985e == r101.f465985e) goto L24;
        return false;
    L24:
        if (this.f465986f == r101.f465986f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f465987g, r101.f465987g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f465981a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f465982b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        CharSequence r107 = this.f465983c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        int r110 = 1231;
        if (this.f465984d == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.f465985e == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        if (this.f465986f == true) goto L26;
        r110 = 1237;
    L26:
        int r115 = (r114 + r110) * 31;
        PartialReplyInfo r116 = this.f465987g;
        if (r116 == null) goto L31;
        r101 = r116.hashCode();
    L31:
        return r115 + r101;
    L21:
        r113 = 1237;
        goto L22
    L17:
        r111 = 1237;
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
        return "ReplyInfo(parentId=" + this.f465981a + ", rootId=" + this.f465982b + ", digest=" + this.f465983c + ", messageReplyDraftIsEmpty=" + this.f465984d + ", isKeepOriginDraft=" + this.f465985e + ", showReplyUI=" + this.f465986f + ", partialReplyInfo=" + this.f465987g + ')';
    }

    public /* synthetic */ i(String r100, String r110, CharSequence r111, boolean r112, PartialReplyInfo r113, int r114) {
        if ((r114 & 32) == 0) goto L5;
        boolean r101 = true;
    L7:
        if ((r114 & 64) == 0) goto L9;
        r113 = null;
    L9:
        this(r100, r110, r111, r112, false, r101, r113);
        return;
    L5:
        r101 = false;
        goto L7
    }

    public i(String r100, String r101, CharSequence r102, boolean r103, boolean r104, boolean r105, PartialReplyInfo r106) {
        this.f465981a = r100;
        this.f465982b = r101;
        this.f465983c = r102;
        this.f465984d = r103;
        this.f465985e = r104;
        this.f465986f = r105;
        this.f465987g = r106;
    }
}
