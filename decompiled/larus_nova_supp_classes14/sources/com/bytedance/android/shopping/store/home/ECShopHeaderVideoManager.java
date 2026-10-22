package com.bytedance.android.shopping.store.home;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.store.common.datachannel.ECSShopSourceMethod;
import com.bytedance.android.ec.store.common.datachannel.ECShopStoreType;
import com.bytedance.android.shopping.api.video.AVScene;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopHeaderVideoManager {
    public String a;
    public String b;
    public final List<String> c;
    public final List<String> d;
    public final s83.f e;
    public final jm.a<Boolean> f;
    public boolean g;
    public final jm.a<Boolean> h;

    public final boolean c() {
        Boolean r0 = (Boolean) this.f.getValue();
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.booleanValue();
    }

    public final void d() {
        String r0 = this.a;
        if (r0 == null) goto L11;
        s83.f r1 = this.e;
        if (r1 == null) goto L8;
        r1.h(r0);
    L8:
        if (c() == true) goto L12;
        this.f.setValue(Boolean.TRUE);
        return;
    L12:
        return;
    }

    public final void e() {
        if (com.bytedance.android.shopping.extensions.k.c(this.a) == false) goto L11;
        s83.f r0 = this.e;
        if (r0 == null) goto L12;
        String r1 = this.a;
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        r0.n(r1);
        return;
    L12:
        return;
    }

    public final void h() {
        String r1 = "";
        if (Intrinsics.areEqual((Boolean) this.h.getValue(), Boolean.TRUE) == false) goto L22;
        if (this.g == true) goto L22;
        boolean r0 = ECServiceManager.a;
        s83.f r2 = ((s83.g) ECServiceManager.c(s83.g.class)).p();
        if (r2 == null) goto L16;
        String r3 = this.a;
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        String r4 = this.b;
        if (r4 == null) goto L15;
        r1 = r4;
    L15:
        r2.b(r3, r1);
    L16:
        this.g = true;
        this.h.setValue(Boolean.FALSE);
        if (c() == false) goto L19;
        d();
        return;
    L19:
        i();
        return;
    L22:
        if (com.bytedance.android.shopping.extensions.k.c(this.a) == false) goto L36;
        s83.f r5 = this.e;
        if (r5 == null) goto L31;
        String r6 = this.a;
        if (r6 == null) goto L29;
        r1 = r6;
    L29:
        r5.e(r1);
    L31:
        if (c() == false) goto L33;
        d();
        return;
    L33:
        i();
        return;
    }

    public final void i() {
        String r0 = this.a;
        if (r0 == null) goto L11;
        s83.f r1 = this.e;
        if (r1 == null) goto L8;
        r1.h(r0);
    L8:
        if (c() == false) goto L12;
        this.f.setValue(Boolean.FALSE);
        return;
    L12:
        return;
    }

    public ECShopHeaderVideoManager() {
        this.c = new ArrayList();
        this.d = new ArrayList();
        boolean r0 = ECServiceManager.a;
        s83.g r1 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r1 == null) goto L5;
        s83.f r2 = r1.p();
    L6:
        this.e = r2;
        jm.a<Boolean> r3 = new jm.a(7);
        r3.setValue(Boolean.TRUE);
        Unit r4 = Unit.INSTANCE;
        this.f = r3;
        this.h = new jm.a(7);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void b(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "videoList");
        this.a = (String) CollectionsKt.first(r2);
        this.b = (String) CollectionsKt.first(r2);
        ((ArrayList) this.d).addAll(r2);
        ((ArrayList) this.c).addAll(r2);
    }

    public final void g(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "videoSceneWrapper");
        String r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        s83.f r1 = this.e;
        String r2 = "";
        if (r1 == null) goto L10;
        if (r0 != null) goto L9;
        r0 = "";
    L9:
        r1.g(r0);
    L10:
        s83.f r3 = this.e;
        if (r3 == null) goto L18;
        String r5 = this.a;
        if (r5 == null) goto L16;
        r2 = r5;
    L16:
        r3.p(r2, r4);
        return;
    }

    public final void a(Context r16, ViewGroup r17, Fragment r18) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r17, "videoSceneWrapper");
        if (this.a != null) goto L5;
        return;
    L5:
        Activity r3 = l0.b(r16);
        this.g = false;
        s83.f r1 = this.e;
        if (r1 == null) goto L11;
        String r4 = this.a;
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        r1.n(r4);
    L11:
        hm.b r2 = hm.b.c;
        List<String> r5 = this.d;
        String r6 = this.a;
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        r2.c(r3, r5, r6, r17, new com.bytedance.android.ec.store.common.starter.f(ECShopStoreType.STORE, ECSShopSourceMethod.STORE_SHOP_HEAD_INFO), BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, "a1.b6269.c51085.d627622", PageFinder.via(r18), null, 4, null), new ECShopHeaderVideoManager$enterVideoDetailPage$1(this));
    }

    public final void f(final Context r11, final ViewGroup r12, final SimpleDraweeView r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "videoSceneWrapper");
        Intrinsics.checkNotNullParameter(r13, "videoCover");
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        r0.element = false;
        String r1 = this.b;
        if (r1 != null) goto L5;
        return;
    L5:
        if (this.a == null) goto L25;
        s83.f r2 = this.e;
        if (r2 == null) goto L10;
        r2.getDuration(r1);
    L10:
        s83.f r7 = this.e;
        if (r7 == null) goto L21;
        String r3 = this.b;
        if (r3 != null) goto L15;
        String r8 = "";
    L16:
        String r4 = this.a;
        if (r4 != null) goto L19;
        String r9 = "";
    L20:
        new ECShopHeaderVideoManager$playVideo$$inlined$also$lambda$1(this, r0, r11, r12, r13);
        AVScene r14 = AVScene.CONTENT_DEFAULT;
        r7.a(r11, r8, r9, r12);
        Boolean r15 = Boolean.FALSE;
    L22:
        r0.element = com.bytedance.android.shopping.extensions.k.i(r15);
        return;
    L19:
        r9 = r4;
        goto L20
    L15:
        r8 = r3;
        goto L16
    L21:
        r15 = null;
        goto L22
    }
}
