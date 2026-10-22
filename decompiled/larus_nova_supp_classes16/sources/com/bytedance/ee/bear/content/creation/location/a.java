package com.bytedance.ee.bear.content.creation.location;

import android.text.TextUtils;
import ax4.f;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import fo5.d;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.content.creation.location.a$a, reason: collision with other inner class name */
    public static final class C0036a {
        public final boolean a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0036a) == true) goto L8;
            return false;
        L8:
            C0036a r6 = (C0036a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L7:
            return (r0 * 31) + this.b;
        L5:
            r0 = 1237;
            goto L7
        }

        public final String toString() {
            return "CreateBtnDisableInfo(isDisable=" + this.a + ", disableTipsRes=" + this.b + ')';
        }

        public C0036a() {
            this.a = false;
            this.b = 0;
        }
    }

    public static final class b {
        public final boolean a;
        public final boolean b;

        public b() {
            boolean r1 = false;
            this(r1, 3);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == true) goto L11;
            r1 = 1237;
        L11:
            return r2 + r1;
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "OfflineCreateInnerResult(isUseDefaultResult=" + this.a + ", defaultEnable=" + this.b + ')';
        }

        public /* synthetic */ b(boolean r3, int r4) {
            if ((r4 & 1) == 0) goto L5;
            boolean r0 = true;
        L7:
            if ((r4 & 2) == 0) goto L9;
            r3 = false;
        L9:
            this(r0, r3);
            return;
        L5:
            r0 = false;
            goto L7
        }

        public b(boolean r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ CreateSelectResult a;

        public c(CreateSelectResult r1) {
            this.a = r1;
        }

        public final Object apply(Object r4) {
            Intrinsics.checkNotNullParameter((String) r4, "it");
            int r5 = a.a;
            boolean r6 = a.k();
            tt5.a.h("CreateLocationSelector", "getCreateLocation: isDefault" + this.a.a + " isNetConnected:" + r6);
            CreateSelectResult r0 = this.a;
            if (r0.a == false) goto L5;
        L7:
            if (r6 == false) goto L18;
            tt5.a.h("CreateLocationSelector", "getCreateLocationInner() called");
            if (a.l() == false) goto L16;
            tt5.a.h("CreateLocationSelector", "getCommonSettings() called");
            if (a.l() == false) goto L19;
            CommonSettingsPuller r7 = new CommonSettingsPuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6));
            CommonSettingsPuller.Params r1 = new CommonSettingsPuller.Params("create_default_position");
            Intrinsics.checkNotNullParameter(r1, "params");
            NetService.f r2 = new NetService.f("/space/api/explorer/setting/get/");
            r2.c = 2;
            r2.b("key", r1.getKey());
            return r7.a.Vc(new f()).a(r2).subscribeOn(d.b()).observeOn(d.d()).map(kw4.a.a).onErrorResumeNext(kw4.b.a);
        L19:
            return Flowable.just(a.d());
        L16:
            return Flowable.just(a.d());
        L18:
            return Flowable.just(a.d());
        L5:
            if (TextUtils.isEmpty(r0.b) == true) goto L7;
            return Flowable.just(this.a);
        }
    }

    static {
    }

    public a() {
    }

    public static CreateSelectResult d() {
        tt5.a.h("CreateLocationSelector", "getCreateLocationInnerDefault() called");
        boolean r0 = ((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1().hasBenefit("common_create_to_my_doc_library");
        if (gw4.a.a() == false) goto L7;
        if (r0 == false) goto L7;
        return new CreateSelectResult("my_document_library", null, false, null, 0, 30);
    L7:
        return new CreateSelectResult("my_root_folder", null, false, null, 0, 30);
    }

    public static boolean k() {
        j r0 = j.a.a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getNetworkState().a() != true) goto L7;
        return true;
    }

    public static C0036a a() {
        if (gw4.a.a() == false) goto L6;
        return new C0036a();
    L6:
        return new C0036a();
    }

    public static String e() {
        long r0 = System.currentTimeMillis();
        String r2 = ((by4.d) new ce5.a().a(by4.d.class)).b("preference_my_library_info").getString("library_id", "");
        tt5.a.h("CreateLocationSelector", "getCachedLibraryId() isEmpty:" + TextUtils.isEmpty(r2) + " costTime:" + (System.currentTimeMillis() - r0));
        if (TextUtils.isEmpty(r2) == false) goto L5;
        r2 = "";
    L5:
        if (r2 != null) goto L8;
        return "";
    L8:
        return r2;
    }

    public static boolean f() {
        if (k() == true) goto L5;
        return false;
    L5:
        b r0 = j();
        if (r0.a == true) goto L8;
        return false;
    L8:
        return r0.b;
    }

    public static boolean g() {
        b r0 = j();
        if (r0.a == true) goto L5;
        return true;
    L5:
        return r0.b;
    }

    public static boolean h() {
        b r0 = j();
        if (r0.a == true) goto L5;
        return true;
    L5:
        return r0.b;
    }

    public static boolean i() {
        b r0 = j();
        if (r0.a == true) goto L5;
        return true;
    L5:
        return r0.b;
    }

    public static b j() {
        boolean r1 = true;
        char r2 = 1;
        char r3 = 1;
        char r4 = 1;
        if (k() == true) goto L5;
        CreateSelectResult r0 = d();
        String r5 = e();
        if (Intrinsics.areEqual(r0.b, "my_document_library") == false) goto L9;
    L19:
        boolean r6 = true;
    L20:
        if (r6 == false) goto L23;
        return new b(false, true);
    L23:
        return new b(r3 == true ? 1 : 0, r2 == true ? 1 : 0);
    L9:
        if (Intrinsics.areEqual(r0.b, "node") == true) goto L11;
    L18:
        r6 = false;
        goto L20
    L11:
        if ((!StringsKt.isBlank(r5)) != true) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == false) goto L18;
        if (Intrinsics.areEqual(r0.e, r5) == false) goto L18;
    L13:
        r7 = false;
        goto L14
    L5:
        return new b(r1, r4 == true ? 1 : 0);
    }

    public static boolean l() {
        boolean r0 = gw4.a.a();
        boolean r1 = ce5.b.a("ccm.workspace.create_default_position");
        boolean r2 = ce5.b.a("ccm.mobile.sync_web_default_craete_location");
        tt5.a.h("CreateLocationSelector", "isSyncWebDefaultCreateLocationEnable: isSidebarEnabled:" + r0 + " isCreatePositionEnabled:" + r1 + " isSyncCreateLocationEnabled:" + r2);
        if (r0 == false) goto L7;
        if (r1 == false) goto L7;
        if (r2 == false) goto L7;
        return true;
    L7:
        return false;
    }

    public static Flowable c(CreateSelectResult r2) {
        Intrinsics.checkNotNullParameter(r2, "customCreateSelectResult");
        return Flowable.just("").flatMap(new c(r2));
    }

    public static CreateSelectResult b(String r9, String r10, String r11, int r12) {
        tt5.a.h("CreateLocationSelector", "saveCreateLocation() called with: parentToken = " + r9 + ", createLocationType = " + r10 + ", spaceId = " + r11 + ", ownerType = " + r12);
        return new CreateSelectResult(r10, r9, false, r11, r12, 4);
    }
}
