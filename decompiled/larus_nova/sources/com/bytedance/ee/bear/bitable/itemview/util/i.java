package com.bytedance.ee.bear.bitable.itemview.util;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.bitable.itemview.recordpages.ItemViewRecordPagesData;
import com.bytedance.ee.bear.bitable.itemview.stack.ItemViewStackContainer;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToLocalMenuV2;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.larus.trace.CopyContentTypeString;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class i {
    public static final void a(AppCompatImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.getParent();
        if ((r101 instanceof View) == false) goto L5;
        View r102 = (View) r101;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        r102.post(new e(r102, r100));
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static final com.bytedance.ee.bear.bitable.itemview.b c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Context r101 = r100.getContext();
        if ((r101 instanceof com.bytedance.ee.bear.bitable.itemview.a) == false) goto L5;
        com.bytedance.ee.bear.bitable.itemview.a r102 = (com.bytedance.ee.bear.bitable.itemview.a) r101;
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.f213768a.get();
    L5:
        r102 = null;
        goto L6
    }

    public static final boolean e(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Context r101 = r100.getContext();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Resources r102 = r101.getResources();
        if (r102 == null) goto L9;
        Configuration r103 = r102.getConfiguration();
        if (r103 == null) goto L9;
        if (r103.orientation != 2) goto L9;
        return true;
    L9:
        return false;
    }

    public static final int d(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L16;
        int r103 = ColorUtils.h(r101);
        if (Color.alpha(r103) >= 255) goto L15;
        return 0;
    L15:
        return r103;
    L16:
        return com.bytedance.ee.util.ui.n.h(r100, R.color.bg_body);
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static final void h(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        int r102 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.url_get_query_fix_enable") == false) goto L6;
        com.bytedance.ee.bear.bitable.utils.h.b(r101, sbb.e.f541298i.getType(), r100);
        return;
    L6:
        t45.c r103 = (t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class);
        com.bytedance.ee.bear.route.h r104 = (com.bytedance.ee.bear.route.h) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class);
        String r105 = Uri.decode(r101);
        if (r103.v6(r105) == false) goto L9;
        RouteBean r106 = new RouteBean();
        Bundle r107 = new Bundle();
        r107.putBoolean("force_load_same", true);
        r106.f236649n = r107;
        r105 = ow4.a.a(r103.v8(r105), com.bytedance.ee.bear.bitable.utils.b.a(sbb.e.f541298i.getType()));
    L10:
        ((com.bytedance.ee.bear.lark.dependency.i) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.i.class, null, null, 6)).a();
        Uri r108 = UriProtector.parse(r105);
        String r109 = r108.getQuery();
        String r110 = Uri.encode(r109, "=&");
        if (TextUtils.equals(r109, r110) == true) goto L14;
        r105 = r108.buildUpon().clearQuery().encodedQuery(r110).build().toString();
    L14:
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.itemview.fix.linkurl.param.encode") == false) goto L21;
        if (r106 != null) goto L17;
        r106 = new RouteBean();
    L17:
        Bundle r111 = r106.f236649n;
        if (r111 != null) goto L20;
        r111 = new Bundle();
    L20:
        r111.putBoolean("encodeValue", false);
        r106.f236649n = r111;
    L21:
        r104.m9(r105, r106);
        return;
    L9:
        r106 = null;
        goto L10
    }

    public static final void i(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewParent r102 = r100.getParent();
        if ((r102 instanceof ViewGroup) == false) goto L5;
        ViewGroup r103 = (ViewGroup) r102;
    L6:
        if (r103 == null) goto L14;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L15;
        if (r101 == false) goto L11;
        int r105 = -1;
    L12:
        r104.width = r105;
        return;
    L11:
        r105 = -2;
        goto L12
    L15:
        return;
    L14:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static final void j(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L9;
        if (r101 == false) goto L6;
        int r103 = -1;
    L7:
        r102.width = r103;
        return;
    L6:
        r103 = -2;
        goto L7
    }

    public static final Context k(com.bytedance.ee.bear.bitable.itemview.b r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100 == null) goto L5;
        FragmentActivity r102 = r100.p0();
    L6:
        if (r102 != null) goto L8;
        return r101;
    L8:
        if (r102.isFinishing() == false) goto L10;
    L13:
        l.a("wrapper activity error", null, Boolean.TRUE, null, 10);
        return r101;
    L10:
        if (r102.isDestroyed() == true) goto L13;
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public static final AnimatorSet b(boolean r100, com.bytedance.ee.bear.bitable.itemview.recordpages.u r101, Runnable r102) {
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "onAnimEnd");
        AnimatorSet r103 = new AnimatorSet();
        r103.setDuration(300);
        Resources r104 = Resources.getSystem();
        float r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).widthPixels;
        float[] r106 = new float[2];
        if (r100 == false) goto L5;
        float r107 = r105;
    L6:
        r106[0] = r107;
        if (r100 == false) goto L9;
        float r108 = 0.0f;
    L10:
        r106[1] = r108;
        ObjectAnimator r109 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_X, r106);
        if (r100 == true) goto L14;
        r105 = 0.0f;
    L14:
        r101.setTranslationX(r105);
        r103.play(r109);
        r103.addListener(new f(r102));
        if (r100 == false) goto L17;
        com.bytedance.ee.util.ui.j.c(new g(r103));
    L18:
        return r103;
    L17:
        r103.start();
        goto L18
    L9:
        r108 = r105;
        goto L10
    L5:
        r107 = 0.0f;
        goto L6
    }

    public static final void f(String r100, String r101, String r102) {
        if (r100 != null) goto L5;
        l.a("openBase.navigate base fail baseId is null", null, Boolean.TRUE, null, 10);
        return;
    L5:
        HashMap r103 = new HashMap();
        if (r101 == null) goto L8;
        r103.put(CopyContentTypeString.TABLE, r101);
    L8:
        if (r102 == null) goto L10;
        r103.put("record", r102);
    L10:
        String r104 = ((t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class)).Le(sbb.e.f541298i.getType(), r100, MapsKt.toMap(r103));
        com.bytedance.ee.bear.route.h r105 = (com.bytedance.ee.bear.route.h) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class);
        RouteBean r106 = new RouteBean();
        Bundle r107 = new Bundle();
        int r108 = com.bytedance.ee.bear.bitable.c.f207079a;
        r107.putBoolean("force_load_same", true);
        r106.f236649n = r107;
        Unit r109 = Unit.INSTANCE;
        r105.m9(r104, r106);
    }

    public static final void g(Context r110, com.bytedance.ee.bear.bitable.itemview.b r111, String r112, String r210, List<? extends AttachmentEntity> r211, int r212, boolean r213) {
        List<? extends AttachmentEntity> r100 = r211;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "list");
        if (r111 == null) goto L7;
        DocViewModel r101 = r111.H0();
        if (r101 == null) goto L7;
        DocsOpenSource r102 = r101.getOpenSource();
    L8:
        int r103 = 0;
        if (r102 != DocsOpenSource.f216966vc) goto L11;
        boolean r104 = true;
    L12:
        if (r111 == null) goto L14;
        String r105 = r111.getDocEncryptId();
    L15:
        if (r111 == null) goto L19;
        ItemViewStackContainer r106 = r111.H60();
        if (r106 == null) goto L19;
        com.bytedance.ee.bear.bitable.itemview.recordpages.u r107 = r106.getTopStackContainer();
    L20:
        if (r107 == null) goto L24;
        ItemViewRecordPagesData r108 = r107.getMData();
        if (r108 == null) goto L24;
        String r113 = r108.getTableId();
    L25:
        ArrayList<? extends BaseOpenEntity> r109 = new ArrayList();
        ArrayList<SpaceThirdPartyOpenEntity> r114 = new ArrayList();
        String r115 = String.valueOf(System.currentTimeMillis());
        int r116 = r100.size();
        SpaceThirdPartyOpenEntity r117 = null;
    L26:
        if (r103 >= r116) goto L37;
        AttachmentEntity r118 = (AttachmentEntity) ListProtector.get(r100, r103);
        if (r118 != null) goto L30;
        int r119 = r116;
    L36:
        r103 = r103 + 1;
        r100 = r211;
        r116 = r119;
        goto L26
    L30:
        ArrayList<BaseMoreMenuAction> r120 = new ArrayList();
        r120.add(new SaveToLocalMenuV2());
        r119 = r116;
        SpaceThirdPartyOpenEntity r121 = new SpaceThirdPartyOpenEntity("26", r118.getAttachmentToken(), r118.getName());
        r121.setApiExtra(r118.getExtra());
        r121.setMountPoint(r118.getMountPointType());
        r121.setMountNodeToken(r118.getMountNodeToken());
        r121.setPreviewFrom("bitable_attach");
        r121.setFromModule(r113);
        r121.setBusinessId("bitable_attach");
        r121.setUniqueId(r118.getAttachmentToken());
        r121.setMoreMenuActions(r120);
        r121.setEncryptId(r105);
        r121.setOriginToken(r115);
        r121.setIndex(r103);
        r121.setTintWhiteBgInDarkMode(r213);
        if (r103 != r212) goto L33;
        r117 = r121;
    L33:
        r109.add(r121);
        if (r104 == false) goto L36;
        r114.add(r121);
        goto L36
    L37:
        Intrinsics.checkNotNullParameter(r109, "localEntityList");
        Intrinsics.checkNotNullParameter(r114, "followEntityList");
        if (r104 == true) goto L40;
    L52:
        ((com.bytedance.ee.bear.i) org.koin.java.a.c(com.bytedance.ee.bear.i.class, null, null, 6)).h(r110, r109, r212);
        return;
    L40:
        if ((!r114.isEmpty()) == false) goto L52;
        if ((r117 instanceof SpaceThirdPartyOpenEntity) == false) goto L52;
        ItemViewStackContainer r122 = r111.H60();
        if (r122 == null) goto L46;
        com.bytedance.ee.bear.bitable.itemview.recordpages.u r123 = r122.getTopStackContainer();
    L48:
        if (r123 == null) goto L50;
        String r124 = r123.getStackIdentify();
    L51:
        r111.bF(new a(r124, r113, r112, r210, r117.getOriginToken()), r117, r114, r212);
        return;
    L50:
        r124 = null;
        goto L51
    L46:
        r123 = null;
    L24:
        r113 = null;
    L19:
        r107 = null;
        goto L20
    L14:
        r105 = null;
        goto L15
    L11:
        r104 = false;
    L7:
        r102 = null;
        goto L8
    }
}
