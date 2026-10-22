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

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f216830a = 0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.content.creation.location.a$a, reason: collision with other inner class name */
    public static final class C3092a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f216831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f216832b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3092a) == true) goto L8;
            return false;
        L8:
            C3092a r101 = (C3092a) r100;
            if (this.f216831a == r101.f216831a) goto L12;
            return false;
        L12:
            if (this.f216832b == r101.f216832b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f216831a == false) goto L5;
            int r100 = 1231;
        L7:
            return (r100 * 31) + this.f216832b;
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "CreateBtnDisableInfo(isDisable=" + this.f216831a + ", disableTipsRes=" + this.f216832b + ')';
        }

        public C3092a() {
            this.f216831a = false;
            this.f216832b = 0;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f216833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f216834b;

        public b() {
            boolean r100 = false;
            this(r100, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f216833a == r101.f216833a) goto L12;
            return false;
        L12:
            if (this.f216834b == r101.f216834b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f216833a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f216834b == true) goto L11;
            r100 = 1237;
        L11:
            return r102 + r100;
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "OfflineCreateInnerResult(isUseDefaultResult=" + this.f216833a + ", defaultEnable=" + this.f216834b + ')';
        }

        public /* synthetic */ b(boolean r100, int r101) {
            if ((r101 & 1) == 0) goto L5;
            boolean r102 = true;
        L7:
            if ((r101 & 2) == 0) goto L9;
            r100 = false;
        L9:
            this(r102, r100);
            return;
        L5:
            r102 = false;
            goto L7
        }

        public b(boolean r100, boolean r101) {
            this.f216833a = r100;
            this.f216834b = r101;
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreateSelectResult f216835a;

        public c(CreateSelectResult r100) {
            this.f216835a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((String) r100, "it");
            int r101 = a.f216830a;
            boolean r102 = a.k();
            tt5.a.h("CreateLocationSelector", "getCreateLocation: isDefault" + this.f216835a.f216824a + " isNetConnected:" + r102);
            CreateSelectResult r103 = this.f216835a;
            if (r103.f216824a == false) goto L5;
        L7:
            if (r102 == false) goto L18;
            tt5.a.h("CreateLocationSelector", "getCreateLocationInner() called");
            if (a.l() == false) goto L16;
            tt5.a.h("CreateLocationSelector", "getCommonSettings() called");
            if (a.l() == false) goto L19;
            CommonSettingsPuller r104 = new CommonSettingsPuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6));
            CommonSettingsPuller.Params r105 = new CommonSettingsPuller.Params("create_default_position");
            Intrinsics.checkNotNullParameter(r105, "params");
            NetService.f r106 = new NetService.f("/space/api/explorer/setting/get/");
            r106.f216906c = 2;
            r106.b("key", r105.getKey());
            return r104.f216823a.Vc(new f()).a(r106).subscribeOn(d.b()).observeOn(d.d()).map(kw4.a.f506391a).onErrorResumeNext(kw4.b.f506392a);
        L19:
            return Flowable.just(a.d());
        L16:
            return Flowable.just(a.d());
        L18:
            return Flowable.just(a.d());
        L5:
            if (TextUtils.isEmpty(r103.f216825b) == true) goto L7;
            return Flowable.just(this.f216835a);
        }
    }

    static {
    }

    public a() {
    }

    public static CreateSelectResult d() {
        tt5.a.h("CreateLocationSelector", "getCreateLocationInnerDefault() called");
        boolean r100 = ((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1().hasBenefit("common_create_to_my_doc_library");
        if (gw4.a.a() == false) goto L7;
        if (r100 == false) goto L7;
        return new CreateSelectResult("my_document_library", null, false, null, 0, 30);
    L7:
        return new CreateSelectResult("my_root_folder", null, false, null, 0, 30);
    }

    public static boolean k() {
        j r100 = j.a.f217090a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getNetworkState().a() != true) goto L7;
        return true;
    }

    public static C3092a a() {
        if (gw4.a.a() == false) goto L6;
        return new C3092a();
    L6:
        return new C3092a();
    }

    public static String e() {
        long r100 = System.currentTimeMillis();
        String r101 = ((by4.d) new ce5.a().a(by4.d.class)).b("preference_my_library_info").getString("library_id", "");
        tt5.a.h("CreateLocationSelector", "getCachedLibraryId() isEmpty:" + TextUtils.isEmpty(r101) + " costTime:" + (System.currentTimeMillis() - r100));
        if (TextUtils.isEmpty(r101) == false) goto L5;
        r101 = "";
    L5:
        if (r101 != null) goto L8;
        return "";
    L8:
        return r101;
    }

    public static boolean f() {
        if (k() == true) goto L5;
        return false;
    L5:
        b r100 = j();
        if (r100.f216833a == true) goto L8;
        return false;
    L8:
        return r100.f216834b;
    }

    public static boolean g() {
        b r100 = j();
        if (r100.f216833a == true) goto L5;
        return true;
    L5:
        return r100.f216834b;
    }

    public static boolean h() {
        b r100 = j();
        if (r100.f216833a == true) goto L5;
        return true;
    L5:
        return r100.f216834b;
    }

    public static boolean i() {
        b r100 = j();
        if (r100.f216833a == true) goto L5;
        return true;
    L5:
        return r100.f216834b;
    }

    public static b j() {
        boolean r100 = true;
        char r101 = 1;
        char r102 = 1;
        char r103 = 1;
        if (k() == true) goto L5;
        CreateSelectResult r104 = d();
        String r105 = e();
        if (Intrinsics.areEqual(r104.f216825b, "my_document_library") == false) goto L9;
    L19:
        boolean r106 = true;
    L20:
        if (r106 == false) goto L23;
        return new b(false, true);
    L23:
        return new b(r102 == true ? 1 : 0, r101 == true ? 1 : 0);
    L9:
        if (Intrinsics.areEqual(r104.f216825b, "node") == true) goto L11;
    L18:
        r106 = false;
        goto L20
    L11:
        if ((!StringsKt.isBlank(r105)) != true) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == false) goto L18;
        if (Intrinsics.areEqual(r104.f216828e, r105) == false) goto L18;
    L13:
        r107 = false;
        goto L14
    L5:
        return new b(r100, r103 == true ? 1 : 0);
    }

    public static boolean l() {
        boolean r100 = gw4.a.a();
        boolean r101 = ce5.b.a("ccm.workspace.create_default_position");
        boolean r102 = ce5.b.a("ccm.mobile.sync_web_default_craete_location");
        tt5.a.h("CreateLocationSelector", "isSyncWebDefaultCreateLocationEnable: isSidebarEnabled:" + r100 + " isCreatePositionEnabled:" + r101 + " isSyncCreateLocationEnabled:" + r102);
        if (r100 == false) goto L7;
        if (r101 == false) goto L7;
        if (r102 == false) goto L7;
        return true;
    L7:
        return false;
    }

    public static Flowable c(CreateSelectResult r100) {
        Intrinsics.checkNotNullParameter(r100, "customCreateSelectResult");
        return Flowable.just("").flatMap(new c(r100));
    }

    public static CreateSelectResult b(String r100, String r110, String r111, int r112) {
        tt5.a.h("CreateLocationSelector", "saveCreateLocation() called with: parentToken = " + r100 + ", createLocationType = " + r110 + ", spaceId = " + r111 + ", ownerType = " + r112);
        return new CreateSelectResult(r110, r100, false, r111, r112, 4);
    }
}
