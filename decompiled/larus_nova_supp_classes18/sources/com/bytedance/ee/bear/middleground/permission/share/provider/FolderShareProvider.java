package com.bytedance.ee.bear.middleground.permission.share.provider;

import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.newshare.ShareItemList;
import com.bytedance.ee.bear.share.newshare.extension.BaseShareProvider;
import com.bytedance.ee.bear.share.newshare.extension.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class FolderShareProvider extends BaseShareProvider {
    public final ni5.a k;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.share.newshare.c0
    public final void d() {
        this.h = 1;
        Iterator r0 = ((ArrayList) this.i).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Function0) r0.next()).invoke();
        goto L4
    L6:
        k(this.k);
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).ia(this);
    }

    @Override // com.bytedance.ee.bear.share.newshare.c0
    public final void i() {
        this.h = 2;
        Iterator r0 = ((ArrayList) this.j).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Function0) r0.next()).invoke();
        goto L4
    L6:
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).ia(null);
    }

    @Override // com.bytedance.ee.bear.share.newshare.c0
    public final ShareItemList b() {
        final mm5.a r0 = ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).fa(null);
        boolean r4 = false;
        if (this.f != null) goto L14;
    L9:
        if (r4 == false) goto L13;
        return c.b(this, new FolderShareProvider$buildMoreItems$1(r0));
    L13:
        return c.b(this, new FolderShareProvider$buildMoreItems$2(r0));
    L14:
        r4 = ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).getProvider().b(c());     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        tt5.a.e("FolderShareProvider", "hideTopArea failed", th, false);
        goto L9
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
    L43:
        km5.a r110 = new km5.a(r3, r4, r7, r9, false, r11, r13, r15, r17, r19, true, false, null, null, false, r22, null, 81920);
        r110.r = this.k.b();
        return r110;
    L42:
        r22 = false;
        goto L43
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
    public final void j() {
        this.k.d();
    }

    @Override // com.bytedance.ee.bear.share.newshare.c0
    public final void h() {
        super.h();
        this.k.d();
    }

    public FolderShareProvider(ni5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "behavior");
        this.k = r2;
    }
}
