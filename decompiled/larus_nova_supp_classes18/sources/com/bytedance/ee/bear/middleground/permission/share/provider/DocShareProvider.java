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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class DocShareProvider extends BaseShareProvider {
    public final h k;
    public final mi5.a l;
    public com.bytedance.ee.bear.middleground.permission.share.provider.a m;
    public b n;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.share.newshare.c0
    public final ShareItemList b() {
        String r1 = null;
        final mm5.a r5 = ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).fa(this.k);
        FragmentActivity r0 = f().p0();
        boolean r3 = true;
        if (r0 == null) goto L11;
        Resources r2 = r0.getResources();
        if (r2 == null) goto L11;
        Configuration r4 = r2.getConfiguration();
        if (r4 == null) goto L11;
        if (r4.orientation != 2) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == true) goto L14;
    L16:
        final boolean r7 = false;
    L17:
        ShareParams r8 = this.f;
        if (r8 != null) goto L21;
    L28:
        boolean r9 = false;
    L29:
        if (r9 == false) goto L33;
        return c.b(this, new DocShareProvider$buildMoreItems$1(this));
    L33:
        if (this.f != null) goto L78;
    L39:
        boolean r10 = false;
    L40:
        if (r10 == true) goto L42;
        final Ref.BooleanRef r11 = new Ref.BooleanRef();
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable_pro_add_to_new_share_panel") == false) goto L60;
        ShareParams r12 = this.f;
        if (r12 == null) goto L50;
        Boolean r13 = r12.isPro();
        if (r13 == null) goto L50;
        boolean r14 = r13.booleanValue();
    L51:
        if (r14 == false) goto L60;
        ShareParams r15 = this.f;
        if (r15 != null) goto L55;
    L57:
        boolean r16 = false;
    L58:
        if (r16 == true) goto L60;
        boolean r17 = true;
    L61:
        r11.element = r17;
        if (AppInfoUtils.e().booleanValue() == false) goto L65;
        tt5.a.h("DocShareProvider", "buildMoreItems, isMempopeApp");
        return c.b(this, new DocShareProvider$buildMoreItems$3(r5, r7, this, r11));
    L65:
        final com.bytedance.ee.bear.share.notification.a r18 = ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).da();
        ShareParams r19 = this.f;
        if (r19 == null) goto L68;
        r1 = r19.getEditionId();
    L68:
        if (r1 != null) goto L70;
    L73:
        if (r3 == true) goto L77;
        return c.b(this, new DocShareProvider$buildMoreItems$4(r5, r7));
    L77:
        return c.b(this, new DocShareProvider$buildMoreItems$5(r5, r7, this, r11, r18));
    L70:
        if (r1.length() == 0) goto L73;
        r3 = false;
        goto L73
    L55:
        if (r15.getSource() != 3) goto L57;
        r16 = true;
    L50:
        r14 = false;
    L60:
        r17 = false;
        goto L61
    L42:
        return c.b(this, new DocShareProvider$buildMoreItems$2(r5, r7));
    L78:
        r10 = ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).getProvider().b(c());     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        tt5.a.e("DocShareProvider", "hideTopArea failed", th, false);
        goto L39
    L21:
        if (f.a().isEnable("apaas.miaoda.migrate_to_ccm") == false) goto L28;
        int r20 = r8.getType();
        int r21 = r8.getRealType();
        if (r21 <= 0) goto L26;
        r20 = r21;
    L26:
        if (g.a(r20) == false) goto L28;
        r9 = true;
        goto L29
    L14:
        if (ku5.c.k(f().p0()) == true) goto L16;
        r7 = true;
    L11:
        r6 = false;
        goto L12
    }

    @Override // com.bytedance.ee.bear.share.newshare.c0
    public final km5.a c() {
        ShareParams r1 = this.f;
        if (r1 == null) goto L5;
        int r3 = r1.getSource();
    L6:
        ShareParams r2 = this.f;
        if (r2 == null) goto L9;
        int r4 = r2.getRealType();
    L10:
        ShareParams r5 = this.f;
        if (r5 == null) goto L14;
        String r6 = r5.getRealToken();
        if (r6 == null) goto L14;
    L15:
        String r7 = r6;
        ShareParams r8 = this.f;
        if (r8 == null) goto L18;
        boolean r9 = r8.isWiki();
    L19:
        ShareParams r10 = this.f;
        if (r10 == null) goto L22;
        String r11 = r10.getMindnoteViewType();
    L23:
        ShareParams r12 = this.f;
        if (r12 == null) goto L26;
        ArrayList<Integer> r13 = r12.getDisabledShareTypes();
    L27:
        ShareParams r14 = this.f;
        if (r14 == null) goto L30;
        ArrayList<Integer> r15 = r14.getBadgeShareTypes();
    L31:
        ShareParams r16 = this.f;
        if (r16 == null) goto L34;
        boolean r17 = r16.isAtVC();
    L35:
        ShareParams r18 = this.f;
        if (r18 == null) goto L38;
        boolean r19 = r18.getAdminPerceiveControl();
    L39:
        ShareParams r20 = this.f;
        if (r20 == null) goto L42;
        boolean r22 = r20.getShowExportImage();
    L44:
        return new km5.a(r3, r4, r7, r9, false, r11, r13, r15, r17, r19, true, false, null, null, false, r22, null, 81920);
    L42:
        r22 = false;
        goto L44
    L38:
        r19 = false;
        goto L39
    L34:
        r17 = false;
        goto L35
    L30:
        r15 = null;
        goto L31
    L26:
        r13 = null;
        goto L27
    L22:
        r11 = null;
        goto L23
    L18:
        r9 = false;
    L14:
        r6 = "";
        goto L15
    L9:
        r4 = -1;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.bytedance.ee.bear.share.newshare.c0
    public final void d() {
        tt5.a.h("DocShareProvider", "create() called");
        boolean r1 = true;
        this.h = 1;
        Iterator r2 = ((ArrayList) this.i).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((Function0) r2.next()).invoke();
        goto L4
    L6:
        ShareParams r3 = this.f;
        if (r3 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L16;
        ShareParams r5 = this.f;
        if (r5 == null) goto L16;
        r5.setWiki(false);
    L16:
        k(this.l);
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).ia(this);
        mi5.a r6 = this.l;
        if (r6.d.c.length() <= 0) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L28;
        ShareDocInfo r8 = r6.d;
        if (r8.j == true) goto L28;
        if (r8.i == false) goto L28;
        if (r8.h == false) goto L28;
        boolean r9 = true;
    L29:
        if (r9 == true) goto L31;
        j();
    L31:
        ShareParams r10 = this.f;
        if (r10 == null) goto L43;
        String r11 = r10.getRealToken();
        if (r11 == null) goto L43;
        if (r11.length() <= 0) goto L38;
        boolean r12 = true;
    L39:
        if (r12 == true) goto L42;
        r11 = null;
    L42:
        if (r11 == null) goto L43;
    L47:
        if (this.m == null) goto L49;
        tt5.a.h("DocShareProvider", "initPermissionPush, secretPush already exists.");
    L63:
        if (r10 == null) goto L65;
        Integer r13 = Integer.valueOf(r10.getRealType());
    L66:
        tt5.a.h("DocShareProvider", "initSecretPush, token: " + du5.b.k(r11) + ", type: " + r13);
        if (this.n == null) goto L69;
        tt5.a.h("DocShareProvider", "initSecretPush, secretPush already exists.");
        return;
    L69:
        tt5.a.h("DocShareProvider", "(" + this + ") initSecretPush, token: " + du5.b.k(r11));
        if (r11 != null) goto L72;
    L75:
        if (r1 == true) goto L82;
        if (r13 == null) goto L83;
        b r0 = new b(this, r11);
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).d7(r11, r13.intValue(), r0);
        this.n = r0;
        return;
    L83:
        return;
    L82:
        return;
    L72:
        if (r11.length() == 0) goto L75;
        r1 = false;
        goto L75
    L65:
        r13 = null;
        goto L66
    L49:
        tt5.a.h("DocShareProvider", "(" + this + ") initPermissionPush, token: " + du5.b.k(r11));
        if (r11 != null) goto L52;
    L55:
        boolean r14 = true;
    L56:
        if (r14 == true) goto L63;
        com.bytedance.ee.bear.middleground.permission.share.provider.a r15 = new com.bytedance.ee.bear.middleground.permission.share.provider.a(this, r11);
        com.bytedance.ee.space.sync.b r16 = (com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6);
        ShareParams r17 = this.f;
        if (r17 == null) goto L61;
        int r18 = r17.getRealType();
    L62:
        r16.i4(r11, r18, r15);
        this.m = r15;
        goto L63
    L61:
        r18 = -1;
        goto L62
    L52:
        if (r11.length() == 0) goto L55;
        r14 = false;
        goto L56
    L38:
        r12 = false;
    L43:
        if (r10 == null) goto L45;
        r11 = r10.getToken();
        goto L47
    L45:
        r11 = null;
    L28:
        r9 = false;
        goto L29
    L19:
        r7 = false;
        goto L20
    L9:
        if (r3.getType() != 44) goto L11;
        r4 = true;
        goto L12
    }

    @Override // com.bytedance.ee.bear.share.newshare.c0
    public final void i() {
        tt5.a.h("DocShareProvider", "release() called");
        this.h = 2;
        Iterator r1 = ((ArrayList) this.j).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((Function0) r1.next()).invoke();
        goto L4
    L6:
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).ia(null);
        tt5.a.h("DocShareProvider", "(" + this + ") destroyPush, permissionChangePush: " + this.m + " secretChangePush:" + this.n);
        com.bytedance.ee.bear.middleground.permission.share.provider.a r0 = this.m;
        if (r0 == null) goto L9;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).Lc(r0);
    L9:
        this.m = null;
        b r2 = this.n;
        if (r2 == null) goto L12;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).Ye(r2);
    L12:
        this.n = null;
    }

    @Override // com.bytedance.ee.bear.share.newshare.c0
    public final void j() {
        tt5.a.h("DocShareProvider", "updatePermission: ");
        mi5.a r0 = this.l;
        r0.getClass();
        tt5.a.h("DocShareInfoBehavior", "requestDocInfo: ");
        j r1 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        Flowable<IDocUserPermission> r4 = r1.c(r0.c.getToken(), r0.c.getType());
        Flowable<IDocPublicPermission> r2 = r1.b(r0.c.getToken(), r0.c.getType());
        Disposable r3 = Flowable.zip(r4, ((a4) org.koin.java.a.c(a4.class, null, null, 6)).b(r0.c.getToken(), r0.c.getType()), new mi5.b(r0)).observeOn(d.d()).subscribe(new mi5.c(r0), new mi5.d(r0));
        Intrinsics.checkNotNullParameter(r3, "<this>");
        r0.b.add(r3);
        Disposable r5 = r2.subscribe(new e(r0), new mi5.f(r0));
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r0.b.add(r5);
    }

    @Override // com.bytedance.ee.bear.share.newshare.c0
    public final void g(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        ShareParams r4 = this.f;
        if (r4 != null) goto L5;
        return;
    L5:
        ShareItemList r0 = b();
        r0.c(this, r4);
        this.c = r0;
        tt5.a.h("ShareProvider", "invalidate.");
        d0 r5 = r0.a();
        this.d.setValue(r5);
    }

    public DocShareProvider(com.bytedance.ee.bear.document.share.a.a r2, mi5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "behavior");
        this.k = r2;
        this.l = r3;
    }
}
