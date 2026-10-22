package mtb;

import com.bytedance.lark.pb.contact.v2.ContactProfile;
import com.bytedance.lark.pb.contact.v2.UserRelation;
import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d extends b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f515661l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f515662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f515663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f515664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f515665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f515666e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f515667f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f515668g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f515669h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f515670i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f515671j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final n f515672k;

    public static final class a {
        public static d a(ContactProfile r210) {
            Intrinsics.checkNotNullParameter(r210, "contactProfile");
            long r100 = r210.feishu_user_id.longValue();
            long r101 = r210.db_user_id.longValue();
            String r102 = r210.name;
            String r103 = r210.alias;
            String r104 = r210.display_name;
            String r110 = r210.display_name_pinyin;
            String r111 = r210.avatar_key;
            String r112 = r210.doubao_key;
            boolean r113 = r210.is_b_user.booleanValue();
            boolean r114 = r210.is_contact_deleted.booleanValue();
            UserRelation r105 = r210.relation;
            if (r105 == null) goto L5;
            int r106 = n.f515695f;
            Intrinsics.checkNotNullParameter(r105, "relation");
            n r115 = new n(r105.is_friend.booleanValue(), r105.request_user_apply.booleanValue(), r105.request_user_apply_id.longValue(), r105.request_user_apply_reason, r105.target_user_apply.booleanValue());
        L7:
            return new d(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115);
        L5:
            r115 = null;
            goto L7
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f515662a == r101.f515662a) goto L12;
        return false;
    L12:
        if (this.f515663b == r101.f515663b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f515664c, r101.f515664c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f515665d, r101.f515665d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f515666e, r101.f515666e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f515667f, r101.f515667f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f515668g, r101.f515668g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f515669h, r101.f515669h) == true) goto L33;
        return false;
    L33:
        if (this.f515670i == r101.f515670i) goto L36;
        return false;
    L36:
        if (this.f515671j == r101.f515671j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f515672k, r101.f515672k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f515662a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f515663b;
        int r103 = (((((((((((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f515664c.hashCode()) * 31) + this.f515665d.hashCode()) * 31) + this.f515666e.hashCode()) * 31) + this.f515667f.hashCode()) * 31) + this.f515668g.hashCode()) * 31) + this.f515669h.hashCode()) * 31;
        int r104 = 1231;
        if (this.f515670i == false) goto L5;
        int r105 = 1231;
    L6:
        int r106 = (r103 + r105) * 31;
        if (this.f515671j == true) goto L10;
        r104 = 1237;
    L10:
        int r107 = (r106 + r104) * 31;
        n r108 = this.f515672k;
        if (r108 != null) goto L13;
        int r109 = 0;
    L15:
        return r107 + r109;
    L13:
        r109 = r108.hashCode();
        goto L15
    L5:
        r105 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfficeContactItemModel(feishuUserId=" + this.f515662a + ", dbUserId=" + this.f515663b + ", name=" + this.f515664c + ", alias=" + this.f515665d + ", displayName=" + this.f515666e + ", displayNamePinyin=" + this.f515667f + ", avatarKey=" + this.f515668g + ", doubaoKey=" + this.f515669h + ", isBusinessUser=" + this.f515670i + ", isDeleted=" + this.f515671j + ", relation=" + this.f515672k + ')';
    }

    public d(long r100, long r101, String r102, String r103, String r104, String r105, String r110, String r111, boolean r112, boolean r113, n r114) {
        Intrinsics.checkNotNullParameter(r102, "name");
        Intrinsics.checkNotNullParameter(r103, "alias");
        Intrinsics.checkNotNullParameter(r104, CommonConstant.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(r105, "displayNamePinyin");
        Intrinsics.checkNotNullParameter(r110, "avatarKey");
        Intrinsics.checkNotNullParameter(r111, "doubaoKey");
        this.f515662a = r100;
        this.f515663b = r101;
        this.f515664c = r102;
        this.f515665d = r103;
        this.f515666e = r104;
        this.f515667f = r105;
        this.f515668g = r110;
        this.f515669h = r111;
        this.f515670i = r112;
        this.f515671j = r113;
        this.f515672k = r114;
    }
}
