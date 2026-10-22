package com.bytedance.ee.bear.middleground.permission.share.provider;

import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.export.h;
import com.bytedance.ee.bear.share.newshare.ShareItemList;
import com.bytedance.ee.bear.share.newshare.d0;
import com.bytedance.ee.bear.share.newshare.extension.BaseShareProvider;
import com.bytedance.ee.bear.share.newshare.extension.c;
import com.bytedance.ee.util.info.AppInfoUtils;
import fo5.d;
import idb.f;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import jg5.j;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mi5.e;
import sbb.g;

/* JADX INFO: loaded from: classes18.dex */
public final class DocShareProvider extends BaseShareProvider {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h f234275k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final mi5.a f234276l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.permission.share.provider.a f234277m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f234278n;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.share.newshare.c0
    public final ShareItemList b() {
        String r100 = null;
        final mm5.a r101 = ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).fa(this.f234275k);
        FragmentActivity r102 = f().p0();
        boolean r103 = true;
        if (r102 == null) goto L11;
        Resources r104 = r102.getResources();
        if (r104 == null) goto L11;
        Configuration r105 = r104.getConfiguration();
        if (r105 == null) goto L11;
        if (r105.orientation != 2) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == true) goto L14;
    L16:
        final boolean r107 = false;
    L17:
        ShareParams r108 = this.f237201f;
        if (r108 != null) goto L21;
    L28:
        boolean r109 = false;
    L29:
        if (r109 == false) goto L33;
        return c.b(this, new DocShareProvider$buildMoreItems$1(this));
    L33:
        if (this.f237201f != null) goto L78;
    L39:
        boolean r110 = false;
    L40:
        if (r110 == true) goto L42;
        final Ref.BooleanRef r111 = new Ref.BooleanRef();
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.bitable_pro_add_to_new_share_panel") == false) goto L60;
        ShareParams r112 = this.f237201f;
        if (r112 == null) goto L50;
        Boolean r113 = r112.isPro();
        if (r113 == null) goto L50;
        boolean r114 = r113.booleanValue();
    L51:
        if (r114 == false) goto L60;
        ShareParams r115 = this.f237201f;
        if (r115 != null) goto L55;
    L57:
        boolean r116 = false;
    L58:
        if (r116 == true) goto L60;
        boolean r117 = true;
    L61:
        r111.element = r117;
        if (AppInfoUtils.e().booleanValue() == false) goto L65;
        tt5.a.h("DocShareProvider", "buildMoreItems, isMempopeApp");
        return c.b(this, new DocShareProvider$buildMoreItems$3(r101, r107, this, r111));
    L65:
        final com.bytedance.ee.bear.share.notification.a r118 = ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).da();
        ShareParams r119 = this.f237201f;
        if (r119 == null) goto L68;
        r100 = r119.getEditionId();
    L68:
        if (r100 != null) goto L70;
    L73:
        if (r103 == true) goto L77;
        return c.b(this, new DocShareProvider$buildMoreItems$4(r101, r107));
    L77:
        return c.b(this, new DocShareProvider$buildMoreItems$5(r101, r107, this, r111, r118));
    L70:
        if (r100.length() == 0) goto L73;
        r103 = false;
        goto L73
    L55:
        if (r115.getSource() != 3) goto L57;
        r116 = true;
    L50:
        r114 = false;
    L60:
        r117 = false;
        goto L61
    L42:
        return c.b(this, new DocShareProvider$buildMoreItems$2(r101, r107));
    L78:
        r110 = ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).getProvider().b(c());     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        tt5.a.e("DocShareProvider", "hideTopArea failed", th, false);
        goto L39
    L21:
        if (f.a().isEnable("apaas.miaoda.migrate_to_ccm") == false) goto L28;
        int r120 = r108.getType();
        int r121 = r108.getRealType();
        if (r121 <= 0) goto L26;
        r120 = r121;
    L26:
        if (g.a(r120) == false) goto L28;
        r109 = true;
        goto L29
    L14:
        if (ku5.c.k(f().p0()) == true) goto L16;
        r107 = true;
    L11:
        r106 = false;
        goto L12
    }

    @Override // com.bytedance.ee.bear.share.newshare.c0
    public final km5.a c() {
        ShareParams r100 = this.f237201f;
        if (r100 == null) goto L5;
        int r101 = r100.getSource();
    L6:
        ShareParams r102 = this.f237201f;
        if (r102 == null) goto L9;
        int r103 = r102.getRealType();
    L10:
        ShareParams r104 = this.f237201f;
        if (r104 == null) goto L14;
        String r105 = r104.getRealToken();
        if (r105 == null) goto L14;
    L15:
        String r106 = r105;
        ShareParams r107 = this.f237201f;
        if (r107 == null) goto L18;
        boolean r108 = r107.isWiki();
    L19:
        ShareParams r109 = this.f237201f;
        if (r109 == null) goto L22;
        String r110 = r109.getMindnoteViewType();
    L23:
        ShareParams r111 = this.f237201f;
        if (r111 == null) goto L26;
        ArrayList<Integer> r112 = r111.getDisabledShareTypes();
    L27:
        ShareParams r113 = this.f237201f;
        if (r113 == null) goto L30;
        ArrayList<Integer> r114 = r113.getBadgeShareTypes();
    L31:
        ShareParams r115 = this.f237201f;
        if (r115 == null) goto L34;
        boolean r116 = r115.isAtVC();
    L35:
        ShareParams r117 = this.f237201f;
        if (r117 == null) goto L38;
        boolean r118 = r117.getAdminPerceiveControl();
    L39:
        ShareParams r119 = this.f237201f;
        if (r119 == null) goto L42;
        boolean r210 = r119.getShowExportImage();
    L44:
        return new km5.a(r101, r103, r106, r108, false, r110, r112, r114, r116, r118, true, false, null, null, false, r210, null, 81920);
    L42:
        r210 = false;
        goto L44
    L38:
        r118 = false;
        goto L39
    L34:
        r116 = false;
        goto L35
    L30:
        r114 = null;
        goto L31
    L26:
        r112 = null;
        goto L27
    L22:
        r110 = null;
        goto L23
    L18:
        r108 = false;
    L14:
        r105 = "";
        goto L15
    L9:
        r103 = -1;
        goto L10
    L5:
        r101 = 0;
        goto L6
    }

    @Override // com.bytedance.ee.bear.share.newshare.c0
    public final void d() {
        tt5.a.h("DocShareProvider", "create() called");
        boolean r100 = true;
        this.f237218h = 1;
        Iterator r101 = ((ArrayList) this.f237219i).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((Function0) r101.next()).invoke();
        goto L4
    L6:
        ShareParams r102 = this.f237201f;
        if (r102 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == false) goto L16;
        ShareParams r104 = this.f237201f;
        if (r104 == null) goto L16;
        r104.setWiki(false);
    L16:
        k(this.f234276l);
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).ia(this);
        mi5.a r105 = this.f234276l;
        if (r105.f514072d.f234244c.length() <= 0) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == false) goto L28;
        ShareDocInfo r107 = r105.f514072d;
        if (r107.f234251j == true) goto L28;
        if (r107.f234250i == false) goto L28;
        if (r107.f234249h == false) goto L28;
        boolean r108 = true;
    L29:
        if (r108 == true) goto L31;
        j();
    L31:
        ShareParams r109 = this.f237201f;
        if (r109 == null) goto L43;
        String r110 = r109.getRealToken();
        if (r110 == null) goto L43;
        if (r110.length() <= 0) goto L38;
        boolean r111 = true;
    L39:
        if (r111 == true) goto L42;
        r110 = null;
    L42:
        if (r110 == null) goto L43;
    L47:
        if (this.f234277m == null) goto L49;
        tt5.a.h("DocShareProvider", "initPermissionPush, secretPush already exists.");
    L63:
        if (r109 == null) goto L65;
        Integer r112 = Integer.valueOf(r109.getRealType());
    L66:
        tt5.a.h("DocShareProvider", "initSecretPush, token: " + du5.b.k(r110) + ", type: " + r112);
        if (this.f234278n == null) goto L69;
        tt5.a.h("DocShareProvider", "initSecretPush, secretPush already exists.");
        return;
    L69:
        tt5.a.h("DocShareProvider", "(" + this + ") initSecretPush, token: " + du5.b.k(r110));
        if (r110 != null) goto L72;
    L75:
        if (r100 == true) goto L82;
        if (r112 == null) goto L83;
        b r113 = new b(this, r110);
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).d7(r110, r112.intValue(), r113);
        this.f234278n = r113;
        return;
    L83:
        return;
    L82:
        return;
    L72:
        if (r110.length() == 0) goto L75;
        r100 = false;
        goto L75
    L65:
        r112 = null;
        goto L66
    L49:
        tt5.a.h("DocShareProvider", "(" + this + ") initPermissionPush, token: " + du5.b.k(r110));
        if (r110 != null) goto L52;
    L55:
        boolean r114 = true;
    L56:
        if (r114 == true) goto L63;
        com.bytedance.ee.bear.middleground.permission.share.provider.a r115 = new com.bytedance.ee.bear.middleground.permission.share.provider.a(this, r110);
        com.bytedance.ee.space.sync.b r116 = (com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6);
        ShareParams r117 = this.f237201f;
        if (r117 == null) goto L61;
        int r118 = r117.getRealType();
    L62:
        r116.i4(r110, r118, r115);
        this.f234277m = r115;
        goto L63
    L61:
        r118 = -1;
        goto L62
    L52:
        if (r110.length() == 0) goto L55;
        r114 = false;
        goto L56
    L38:
        r111 = false;
    L43:
        if (r109 == null) goto L45;
        r110 = r109.getToken();
        goto L47
    L45:
        r110 = null;
    L28:
        r108 = false;
        goto L29
    L19:
        r106 = false;
        goto L20
    L9:
        if (r102.getType() != 44) goto L11;
        r103 = true;
        goto L12
    }

    @Override // com.bytedance.ee.bear.share.newshare.c0
    public final void i() {
        tt5.a.h("DocShareProvider", "release() called");
        this.f237218h = 2;
        Iterator r100 = ((ArrayList) this.f237220j).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Function0) r100.next()).invoke();
        goto L4
    L6:
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).ia(null);
        tt5.a.h("DocShareProvider", "(" + this + ") destroyPush, permissionChangePush: " + this.f234277m + " secretChangePush:" + this.f234278n);
        com.bytedance.ee.bear.middleground.permission.share.provider.a r101 = this.f234277m;
        if (r101 == null) goto L9;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).Lc(r101);
    L9:
        this.f234277m = null;
        b r102 = this.f234278n;
        if (r102 == null) goto L12;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).Ye(r102);
    L12:
        this.f234278n = null;
    }

    @Override // com.bytedance.ee.bear.share.newshare.c0
    public final void j() {
        tt5.a.h("DocShareProvider", "updatePermission: ");
        mi5.a r100 = this.f234276l;
        r100.getClass();
        tt5.a.h("DocShareInfoBehavior", "requestDocInfo: ");
        j r101 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        Flowable<IDocUserPermission> r102 = r101.c(r100.f514071c.getToken(), r100.f514071c.getType());
        Flowable<IDocPublicPermission> r103 = r101.b(r100.f514071c.getToken(), r100.f514071c.getType());
        Disposable r104 = Flowable.zip(r102, ((a4) org.koin.java.a.c(a4.class, null, null, 6)).b(r100.f514071c.getToken(), r100.f514071c.getType()), new mi5.b(r100)).observeOn(d.d()).subscribe(new mi5.c(r100), new mi5.d(r100));
        Intrinsics.checkNotNullParameter(r104, "<this>");
        r100.f237214b.add(r104);
        Disposable r105 = r103.subscribe(new e(r100), new mi5.f(r100));
        Intrinsics.checkNotNullParameter(r105, "<this>");
        r100.f237214b.add(r105);
    }

    @Override // com.bytedance.ee.bear.share.newshare.c0
    public final void g(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        ShareParams r101 = this.f237201f;
        if (r101 != null) goto L5;
        return;
    L5:
        ShareItemList r102 = b();
        r102.c(this, r101);
        this.f237198c = r102;
        tt5.a.h("ShareProvider", "invalidate.");
        d0 r103 = r102.a();
        this.f237199d.setValue(r103);
    }

    public DocShareProvider(com.bytedance.ee.bear.document.share.a.C3158a r100, mi5.a r101) {
        Intrinsics.checkNotNullParameter(r101, "behavior");
        this.f234275k = r100;
        this.f234276l = r101;
    }
}
