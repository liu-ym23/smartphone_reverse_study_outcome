package y6b;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.entity.chatter.AvatarMedal;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterCustomStatus;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.chat.entity.chatter.TagInfo;
import com.ss.android.lark.chat.entity.chatter.UserPrivateDescription;
import com.ss.android.lark.chat.entity.chatter.WorkStatus;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements y28.b<b> {
    public boolean A;
    public ChatterCustomStatus B;
    public List<ChatterCustomStatus> C;
    public String D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f566452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f566453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f566454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f566455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f566456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f566457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f566458g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f566459h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f566460i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Chatter.ChatterType f566461j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f566462k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public WorkStatus f566463l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f566464m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f566465n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ChatterDescription f566466o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public UserPrivateDescription f566467p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f566468q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f566469r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f566470s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f566471t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f566472u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f566473v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f566474w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f566475x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public List<TagInfo> f566476y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public AvatarMedal f566477z;

    public final int hashCode() {
        String r100 = this.f566452a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public b(String r100) {
        this.f566452a = r100;
    }

    public final boolean a(b r100) {
        if (r100 == null) goto L8;
        if (this != r100) goto L6;
    L7:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
    L65:
        return false;
    L11:
        if (TextUtils.equals(this.f566453b, r100.f566453b) == false) goto L65;
        if (TextUtils.equals(this.f566454c, r100.f566454c) == false) goto L65;
        if (TextUtils.equals(this.f566455d, r100.f566455d) == false) goto L65;
        if (TextUtils.equals(this.f566456e, r100.f566456e) == false) goto L65;
        if (TextUtils.equals(this.f566457f, r100.f566457f) == false) goto L65;
        if (TextUtils.equals(this.f566458g, r100.f566458g) == false) goto L65;
        if (TextUtils.equals(this.f566459h, r100.f566459h) == false) goto L65;
        if (TextUtils.equals(this.f566460i, r100.f566460i) == false) goto L65;
        if (TextUtils.equals(this.f566470s, r100.f566470s) == false) goto L65;
        if (this.f566471t != r100.f566471t) goto L65;
        if (TextUtils.equals(this.f566456e, r100.f566456e) == false) goto L65;
        if (TextUtils.equals(this.f566462k, r100.f566462k) == false) goto L65;
        if (this.f566465n != r100.f566465n) goto L65;
        if (Objects.equals(this.f566467p, r100.f566467p) == false) goto L65;
        if (Objects.equals(Boolean.valueOf(this.f566468q), Boolean.valueOf(r100.f566468q)) == false) goto L65;
        if (Objects.equals(this.f566463l, r100.f566463l) == false) goto L65;
        if (Objects.equals(this.f566477z, r100.f566477z) == false) goto L65;
        if (Objects.equals(Boolean.valueOf(this.A), Boolean.valueOf(r100.A)) == false) goto L65;
        List<TagInfo> r102 = r100.f566476y;
        List<TagInfo> r103 = this.f566476y;
        if (r103.size() != r102.size()) goto L54;
        int r104 = 0;
    L51:
        if (r104 >= r103.size()) goto L56;
        if (((TagInfo) ListProtector.get(r103, r104)).equals(ListProtector.get(r102, r104)) == false) goto L54;
        r104 = r104 + 1;
        goto L51
    L56:
        boolean r105 = true;
    L57:
        if (r105 == false) goto L65;
        if (Objects.equals(this.B, r100.B) == false) goto L65;
        if (Objects.equals(this.f566472u, r100.f566472u) == false) goto L65;
        if (Objects.equals(this.D, r100.D) == false) goto L65;
        return true;
    L54:
        r105 = false;
        goto L57
    L6:
        if (TextUtils.equals(this.f566452a, r100.f566452a) == true) goto L7;
    L8:
        r101 = false;
        goto L9
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (b.class == r100.getClass()) goto L10;
        return false;
    L10:
        return a((b) r100);
    }

    @Override // y28.b
    public final /* bridge */ /* synthetic */ boolean isContentSame(y28.b r100) {
        return a((b) r100);
    }

    @Override // y28.b
    public final boolean isItemSame(y28.b r100) {
        b r101 = (b) r100;
        if (r101 == null) goto L8;
        if (this != r101) goto L6;
    L7:
        return true;
    L6:
        if (TextUtils.equals(this.f566452a, r101.f566452a) == true) goto L7;
    L8:
        return false;
    }
}
