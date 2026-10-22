package com.ss.android.lark.profile_office.userprofile;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.contact.v2.GetDoubaoProfileRequest;
import com.bytedance.lark.pb.contact.v2.GetDoubaoProfileResponse;
import com.bytedance.lark.pb.contact.v2.I18nVal;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeProfileState {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Set<GetDoubaoProfileResponse.CTAType> f438885p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Lazy<GetDoubaoProfileResponse.CTAInfo> f438886q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q1c.b<GetDoubaoProfileResponse> f438887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f438888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f438889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f438890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<l> f438891e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final v1c.a f438892f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f438893g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f438894h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f438895i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f438896j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.ss.android.lark.compose.foundation.widget.a f438897k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RecogniseSpansResult f438898l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f438899m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f438900n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f438901o;

    public static final class a {
    }

    public OfficeProfileState() {
        boolean r100 = false;
        this(r100, r100, 8191);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeProfileState) == true) goto L8;
        return false;
    L8:
        OfficeProfileState r101 = (OfficeProfileState) r100;
        if (Intrinsics.areEqual(this.f438887a, r101.f438887a) == true) goto L12;
        return false;
    L12:
        if (this.f438888b == r101.f438888b) goto L15;
        return false;
    L15:
        if (this.f438889c == r101.f438889c) goto L18;
        return false;
    L18:
        if (this.f438890d == r101.f438890d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f438891e, r101.f438891e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f438892f, r101.f438892f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f438893g, r101.f438893g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f438894h, r101.f438894h) == true) goto L33;
        return false;
    L33:
        if (this.f438895i == r101.f438895i) goto L36;
        return false;
    L36:
        if (this.f438896j == r101.f438896j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f438897k, r101.f438897k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f438898l, r101.f438898l) == true) goto L45;
        return false;
    L45:
        if (this.f438899m == r101.f438899m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        q1c.b<GetDoubaoProfileResponse> r100 = this.f438887a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        int r104 = 1231;
        if (this.f438888b == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f438889c == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f438890d == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (((((((((r108 + r109) * 31) + this.f438891e.hashCode()) * 31) + this.f438892f.hashCode()) * 31) + this.f438893g.hashCode()) * 31) + this.f438894h.hashCode()) * 31;
        if (this.f438895i == false) goto L21;
        int r111 = 1231;
    L22:
        int r112 = (r110 + r111) * 31;
        if (this.f438896j == false) goto L25;
        int r113 = 1231;
    L26:
        int r114 = (((r112 + r113) * 31) + this.f438897k.hashCode()) * 31;
        RecogniseSpansResult r115 = this.f438898l;
        if (r115 == null) goto L30;
        r101 = r115.hashCode();
    L30:
        int r116 = (r114 + r101) * 31;
        if (this.f438899m == true) goto L35;
        r104 = 1237;
    L35:
        return r116 + r104;
    L25:
        r113 = 1237;
        goto L26
    L21:
        r111 = 1237;
        goto L22
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficeProfileState(response=" + this.f438887a + ", isServerResponse=" + this.f438888b + ", isIMEnabled=" + this.f438889c + ", isLoginBUser=" + this.f438890d + ", visibleItems=" + this.f438891e + ", doubaoData=" + this.f438892f + ", doubaoHomepageImages=" + this.f438893g + ", departmentList=" + this.f438894h + ", isAcceptingFriend=" + this.f438895i + ", isDepartmentExpanded=" + this.f438896j + ", blockSwitchState=" + this.f438897k + ", descriptionSpanResult=" + this.f438898l + ", isOnLeave=" + this.f438899m + ')';
    }

    static {
        f438885p = SetsKt.setOf(GetDoubaoProfileResponse.CTAType.CHAT);
        f438886q = LazyKt.lazy(OfficeProfileState$Companion$MOCK_CTA$2.INSTANCE);
    }

    public final String b() {
        q1c.b<GetDoubaoProfileResponse> r100 = this.f438887a;
        if (r100 == null) goto L9;
        GetDoubaoProfileResponse r101 = r100.a();
        if (r101 == null) goto L9;
        GetDoubaoProfileResponse.UserInfo r102 = r101.user_info;
        if (r102 == null) goto L9;
        String r103 = r102.alias;
    L10:
        if (r103 != null) goto L13;
        return "";
    L13:
        return r103;
    L9:
        r103 = null;
        goto L10
    }

    public final String c() {
        q1c.b<GetDoubaoProfileResponse> r100 = this.f438887a;
        if (r100 == null) goto L11;
        GetDoubaoProfileResponse r101 = r100.a();
        if (r101 == null) goto L11;
        GetDoubaoProfileResponse.UserInfo r102 = r101.user_info;
        if (r102 == null) goto L11;
        GetDoubaoProfileResponse.CityInfo r103 = r102.city_info;
        if (r103 == null) goto L11;
        I18nVal r104 = r103.city;
    L13:
        return w1c.a.a(r104);
    L11:
        r104 = null;
        goto L13
    }

    public final GetDoubaoProfileResponse.ContactStatus d() {
        q1c.b<GetDoubaoProfileResponse> r100 = this.f438887a;
        if (r100 == null) goto L9;
        GetDoubaoProfileResponse r101 = r100.a();
        if (r101 == null) goto L9;
        GetDoubaoProfileResponse.UserInfo r102 = r101.user_info;
        if (r102 == null) goto L9;
        return r102.contact_status;
    L9:
        return null;
    }

    public final List<GetDoubaoProfileResponse.CTAInfo> e() {
        q1c.b<GetDoubaoProfileResponse> r100 = this.f438887a;
        List<GetDoubaoProfileResponse.CTAInfo> r101 = null;
        if (r100 == null) goto L5;
        GetDoubaoProfileResponse r102 = r100.a();
    L6:
        if (r102 == null) goto L8;
        r101 = r102.cta_info_list;
    L8:
        if (r101 != null) goto L10;
        r101 = CollectionsKt.emptyList();
    L10:
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r101.iterator();
    L12:
        if (r104.hasNext() == false) goto L17;
        Object r105 = r104.next();
        if (f438885p.contains(((GetDoubaoProfileResponse.CTAInfo) r105).cta_type) == false) goto L12;
        r103.add(r105);
        goto L12
    L17:
        if (r103.isEmpty() == false) goto L23;
        if (r102 == null) goto L23;
        if (this.f438888b == true) goto L23;
        return CollectionsKt.listOf(f438886q.getValue());
    L23:
        return r103;
    L5:
        r102 = null;
        goto L6
    }

    public final Long f() {
        q1c.b<GetDoubaoProfileResponse> r100 = this.f438887a;
        if (r100 == null) goto L11;
        GetDoubaoProfileResponse r101 = r100.a();
        if (r101 == null) goto L11;
        GetDoubaoProfileResponse.UserInfo r102 = r101.user_info;
        if (r102 == null) goto L11;
        Chatter.Description r103 = r102.description;
        if (r103 == null) goto L11;
        return r103.description_id;
    L11:
        return null;
    }

    public final String g() {
        q1c.b<GetDoubaoProfileResponse> r100 = this.f438887a;
        if (r100 == null) goto L11;
        GetDoubaoProfileResponse r101 = r100.a();
        if (r101 == null) goto L11;
        GetDoubaoProfileResponse.UserInfo r102 = r101.user_info;
        if (r102 == null) goto L11;
        Chatter.Description r103 = r102.description;
        if (r103 == null) goto L11;
        String r104 = r103.text;
    L12:
        if (r104 != null) goto L15;
        return "";
    L15:
        return r104;
    L11:
        r104 = null;
        goto L12
    }

    public final String h() {
        q1c.b<GetDoubaoProfileResponse> r100 = this.f438887a;
        if (r100 == null) goto L11;
        GetDoubaoProfileResponse r101 = r100.a();
        if (r101 == null) goto L11;
        GetDoubaoProfileResponse.UserInfo r102 = r101.user_info;
        if (r102 == null) goto L11;
        GetDoubaoProfileResponse.LeaderInfo r103 = r102.leader_info;
        if (r103 == null) goto L11;
        I18nVal r104 = r103.user_name;
    L13:
        return w1c.a.a(r104);
    L11:
        r104 = null;
        goto L13
    }

    public final String i() {
        q1c.b<GetDoubaoProfileResponse> r100 = this.f438887a;
        if (r100 == null) goto L11;
        GetDoubaoProfileResponse r101 = r100.a();
        if (r101 == null) goto L11;
        GetDoubaoProfileResponse.UserInfo r102 = r101.user_info;
        if (r102 == null) goto L11;
        GetDoubaoProfileResponse.LeaderInfo r103 = r102.leader_info;
        if (r103 == null) goto L11;
        String r104 = r103.user_id;
    L12:
        if (r104 != null) goto L15;
        return "";
    L15:
        return r104;
    L11:
        r104 = null;
        goto L12
    }

    public final String j() {
        q1c.b<GetDoubaoProfileResponse> r100 = this.f438887a;
        if (r100 == null) goto L11;
        GetDoubaoProfileResponse r101 = r100.a();
        if (r101 == null) goto L11;
        GetDoubaoProfileResponse.UserInfo r102 = r101.user_info;
        if (r102 == null) goto L11;
        GetDoubaoProfileResponse.TenantInfo r103 = r102.tenant_info;
        if (r103 == null) goto L11;
        I18nVal r104 = r103.tenant_name;
    L13:
        return w1c.a.a(r104);
    L11:
        r104 = null;
        goto L13
    }

    public final String k() {
        q1c.b<GetDoubaoProfileResponse> r100 = this.f438887a;
        if (r100 == null) goto L9;
        GetDoubaoProfileResponse r101 = r100.a();
        if (r101 == null) goto L9;
        GetDoubaoProfileResponse.UserInfo r102 = r101.user_info;
        if (r102 == null) goto L9;
        String r103 = r102.avatar_key;
    L10:
        if (r103 != null) goto L13;
        return "";
    L13:
        return r103;
    L9:
        r103 = null;
        goto L10
    }

    public final String l() {
        q1c.b<GetDoubaoProfileResponse> r100 = this.f438887a;
        if (r100 == null) goto L9;
        GetDoubaoProfileResponse r101 = r100.a();
        if (r101 == null) goto L9;
        GetDoubaoProfileResponse.UserInfo r102 = r101.user_info;
        if (r102 == null) goto L9;
        String r103 = r102.user_id;
    L10:
        if (r103 != null) goto L13;
        return "";
    L13:
        return r103;
    L9:
        r103 = null;
        goto L10
    }

    public final String m() {
        q1c.b<GetDoubaoProfileResponse> r100 = this.f438887a;
        if (r100 == null) goto L9;
        GetDoubaoProfileResponse r101 = r100.a();
        if (r101 == null) goto L9;
        GetDoubaoProfileResponse.UserInfo r102 = r101.user_info;
        if (r102 == null) goto L9;
        String r103 = r102.user_name;
    L10:
        if (r103 != null) goto L13;
        return "";
    L13:
        return r103;
    L9:
        r103 = null;
        goto L10
    }

    public final boolean n() {
        q1c.b<GetDoubaoProfileResponse> r100 = this.f438887a;
        GetDoubaoProfileResponse.BlockStatus r101 = null;
        if (r100 == null) goto L5;
        GetDoubaoProfileResponse r102 = r100.a();
    L6:
        if (r102 == null) goto L11;
        GetDoubaoProfileResponse.UserInfo r103 = r102.user_info;
        if (r103 == null) goto L11;
        r101 = r103.block_status;
    L11:
        if (r101 != GetDoubaoProfileResponse.BlockStatus.BLOCK_FORWARD) goto L13;
    L16:
        return true;
    L13:
        if (r101 == GetDoubaoProfileResponse.BlockStatus.BLOCK_DUAL) goto L16;
        return false;
    L5:
        r102 = null;
        goto L6
    }

    public final boolean o() {
        q1c.b<GetDoubaoProfileResponse> r100 = this.f438887a;
        if (r100 == null) goto L7;
        GetDoubaoProfileResponse r101 = r100.a();
        if (r101 == null) goto L7;
        GetDoubaoProfileRequest.DoubaoProfileEdition r102 = r101.edition;
    L9:
        if (r102 != GetDoubaoProfileRequest.DoubaoProfileEdition.EDITION_ENTERPRISE) goto L11;
        return true;
    L11:
        return false;
    L7:
        r102 = null;
        goto L9
    }

    public final boolean p() {
        q1c.b<GetDoubaoProfileResponse> r100 = this.f438887a;
        if (r100 == null) goto L9;
        GetDoubaoProfileResponse r101 = r100.a();
        if (r101 == null) goto L9;
        GetDoubaoProfileResponse.UserInfo r102 = r101.user_info;
        if (r102 == null) goto L9;
        return Intrinsics.areEqual(r102.is_frozen, Boolean.TRUE);
    L9:
        return false;
    }

    public final boolean r() {
        q1c.b<GetDoubaoProfileResponse> r100 = this.f438887a;
        if (r100 == null) goto L7;
        GetDoubaoProfileResponse r101 = r100.a();
        if (r101 == null) goto L7;
        GetDoubaoProfileRequest.DoubaoProfileEdition r102 = r101.edition;
    L9:
        if (r102 != GetDoubaoProfileRequest.DoubaoProfileEdition.EDITION_PERSONAL) goto L11;
        return true;
    L11:
        return false;
    L7:
        r102 = null;
        goto L9
    }

    public final boolean s() {
        q1c.b<GetDoubaoProfileResponse> r100 = this.f438887a;
        if (r100 == null) goto L9;
        GetDoubaoProfileResponse r101 = r100.a();
        if (r101 == null) goto L9;
        GetDoubaoProfileResponse.UserInfo r102 = r101.user_info;
        if (r102 == null) goto L9;
        return Intrinsics.areEqual(r102.is_resigned, Boolean.TRUE);
    L9:
        return false;
    }

    public final boolean t() {
        q1c.b<GetDoubaoProfileResponse> r100 = this.f438887a;
        if (r100 == null) goto L9;
        GetDoubaoProfileResponse r101 = r100.a();
        if (r101 == null) goto L9;
        GetDoubaoProfileResponse.UserInfo r102 = r101.user_info;
        if (r102 == null) goto L9;
        String r103 = r102.tenant_id;
    L10:
        if (r103 != null) goto L13;
        r103 = "";
    L13:
        if (r103.length() <= 0) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == true) goto L18;
    L20:
        return false;
    L18:
        if (Intrinsics.areEqual(r103, (String) this.f438901o.getValue()) == false) goto L20;
        return true;
    L15:
        r104 = false;
    L9:
        r103 = null;
        goto L10
    }

    public final boolean u() {
        q1c.b<GetDoubaoProfileResponse> r100 = this.f438887a;
        if (r100 == null) goto L9;
        GetDoubaoProfileResponse r101 = r100.a();
        if (r101 == null) goto L9;
        GetDoubaoProfileResponse.UserInfo r102 = r101.user_info;
        if (r102 == null) goto L9;
        String r103 = r102.user_id;
    L11:
        return Intrinsics.areEqual(r103, (String) this.f438900n.getValue());
    L9:
        r103 = null;
        goto L11
    }

    public final boolean q(l r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return this.f438891e.contains(r100);
    }

    public /* synthetic */ OfficeProfileState(boolean r110, boolean r111, int r112) {
        int r100 = 0;
        if ((r112 & 4) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r112 & 8) == 0) goto L9;
        boolean r102 = false;
    L11:
        if ((r112 & 16) == 0) goto L13;
        Set r103 = SetsKt.emptySet();
    L15:
        if ((r112 & 32) == 0) goto L17;
        v1c.a r104 = new v1c.a(r100);
    L19:
        if ((r112 & 64) == 0) goto L21;
        List r105 = CollectionsKt.emptyList();
    L23:
        if ((r112 & 128) == 0) goto L25;
        List r113 = CollectionsKt.emptyList();
    L27:
        if ((r112 & 1024) == 0) goto L29;
        com.ss.android.lark.compose.foundation.widget.a r114 = new com.ss.android.lark.compose.foundation.widget.a(false, false);
    L30:
        this(null, false, r101, r102, r103, r104, r105, r113, false, false, r114, null, false);
        return;
    L29:
        r114 = null;
        goto L30
    L25:
        r113 = null;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeProfileState(q1c.b<GetDoubaoProfileResponse> r100, boolean r101, boolean r102, boolean r103, Set<? extends l> r104, v1c.a r105, List<String> r106, List<String> r107, boolean r110, boolean r111, com.ss.android.lark.compose.foundation.widget.a r112, RecogniseSpansResult r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r104, "visibleItems");
        Intrinsics.checkNotNullParameter(r105, "doubaoData");
        Intrinsics.checkNotNullParameter(r106, "doubaoHomepageImages");
        Intrinsics.checkNotNullParameter(r107, "departmentList");
        Intrinsics.checkNotNullParameter(r112, "blockSwitchState");
        this.f438887a = r100;
        this.f438888b = r101;
        this.f438889c = r102;
        this.f438890d = r103;
        this.f438891e = r104;
        this.f438892f = r105;
        this.f438893g = r106;
        this.f438894h = r107;
        this.f438895i = r110;
        this.f438896j = r111;
        this.f438897k = r112;
        this.f438898l = r113;
        this.f438899m = r114;
        this.f438900n = LazyKt.lazy(OfficeProfileState$loginUserId$2.INSTANCE);
        this.f438901o = LazyKt.lazy(OfficeProfileState$loginTenantId$2.INSTANCE);
    }

    public static OfficeProfileState a(OfficeProfileState r110, q1c.b r111, boolean r112, Set r210, v1c.a r211, List r212, List r213, boolean r214, boolean r215, com.ss.android.lark.compose.foundation.widget.a r216, RecogniseSpansResult r217, boolean r218, int r219) {
        if ((r219 & 1) == 0) goto L5;
        q1c.b r100 = r110.f438887a;
    L7:
        if ((r219 & 2) == 0) goto L9;
        boolean r101 = r110.f438888b;
    L11:
        if ((r219 & 4) == 0) goto L13;
        boolean r102 = r110.f438889c;
    L15:
        if ((r219 & 8) == 0) goto L17;
        boolean r103 = r110.f438890d;
    L19:
        if ((r219 & 16) == 0) goto L21;
        Set r104 = r110.f438891e;
    L23:
        if ((r219 & 32) == 0) goto L25;
        v1c.a r105 = r110.f438892f;
    L27:
        if ((r219 & 64) == 0) goto L29;
        List r113 = r110.f438893g;
    L31:
        if ((r219 & 128) == 0) goto L33;
        List r114 = r110.f438894h;
    L35:
        if ((r219 & 256) == 0) goto L37;
        boolean r115 = r110.f438895i;
    L39:
        if ((r219 & 512) == 0) goto L41;
        boolean r116 = r110.f438896j;
    L43:
        if ((r219 & 1024) == 0) goto L45;
        com.ss.android.lark.compose.foundation.widget.a r117 = r110.f438897k;
    L47:
        if ((r219 & 2048) == 0) goto L49;
        RecogniseSpansResult r118 = r110.f438898l;
    L51:
        if ((r219 & 4096) == 0) goto L53;
        boolean r119 = r110.f438899m;
    L54:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r104, "visibleItems");
        Intrinsics.checkNotNullParameter(r105, "doubaoData");
        Intrinsics.checkNotNullParameter(r113, "doubaoHomepageImages");
        Intrinsics.checkNotNullParameter(r114, "departmentList");
        Intrinsics.checkNotNullParameter(r117, "blockSwitchState");
        return new OfficeProfileState(r100, r101, r102, r103, r104, r105, r113, r114, r115, r116, r117, r118, r119);
    L53:
        r119 = r218;
        goto L54
    L49:
        r118 = r217;
        goto L51
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r114 = r213;
        goto L35
    L29:
        r113 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = false;
        goto L19
    L13:
        r102 = false;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
