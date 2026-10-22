package com.bytedance.ee.bear.templates.banner;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.create.g0;
import com.bytedance.ee.bear.list.create.l;
import com.bytedance.ee.bear.list.create.m;
import com.bytedance.ee.bear.list.create.q0;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.TemplateUtils;
import com.bytedance.ee.bear.templates.topic.TopicFragment;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import fo5.d;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends t {
    public final /* synthetic */ TemplateBannerAdapter c;
    public final /* synthetic */ TemplateBannerAdapter.ImageHolder d;
    public final /* synthetic */ BannerData e;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.templates.banner.a$a, reason: collision with other inner class name */
    public static final class C0182a<T> implements Consumer {
        public final /* synthetic */ TemplateBannerAdapter.ImageHolder a;

        public C0182a(TemplateBannerAdapter.ImageHolder r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            DocumentCreateInfo r5 = (DocumentCreateInfo) r7;
            Intrinsics.checkNotNullParameter(r5, "documentCreateInfo");
            tt5.a.h("ImageAdapter", "create template success");
            Context r1 = this.a.a.getContext();
            TemplateReportV2 r0 = TemplateReportV2.a;
            q0.e(new com.bytedance.ee.bear.list.create.b(r1, "template_create", "", r5.d, r5));
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ BannerData a;
        public final /* synthetic */ TemplateBannerAdapter.ImageHolder b;

        public b(BannerData r1, TemplateBannerAdapter.ImageHolder r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            Intrinsics.checkNotNullParameter(r7, "throwable");
            tt5.a.d("ImageAdapter", "create template failed, throwable = " + r7);
            q0.c(new com.bytedance.ee.bear.list.create.b(this.b.a.getContext(), new m("", "module", "template_create", false), e.c(this.a.getObjType())), r7);
        }
    }

    public static final class c implements TemplateUtils.a {
        public final /* synthetic */ Context a;

        public c(Context r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.templates.TemplateUtils.a
        public final void onResult(String r5) {
            Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_URL);
            Context r0 = this.a;
            if ((r0 instanceof Activity) == true) goto L5;
        L9:
            RouteBean r1 = new RouteBean();
            r1.c = 1;
            ((h) org.koin.java.a.c(h.class, null, null, 6)).m9(r5, r1);
            return;
        L5:
            if (((Activity) r0).isFinishing() == false) goto L7;
            return;
        L7:
            if (((Activity) this.a).isDestroyed() == false) goto L9;
        }
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r13) {
        if (this.c.c.getNetworkState().a() != true) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == true) goto L9;
        Toast.showFailureText(this.d.a.getContext(), 2131887789);
        return;
    L9:
        this.c.z2(false, this.e);
        int r15 = this.e.getType();
        if (r15 != 1) goto L12;
        g0 r16 = new g0();
        String r1 = this.e.getObjToken();
        String r2 = this.e.getTitle();
        int r3 = this.e.getObjType();
        CreateSelectResult.CREATOR.getClass();
        Flowable r17 = r16.b(new l(r1, r2, r3, false, "", true, "templatecenter_banner", null, CreateSelectResult.a.b(), "")).timeout(15, TimeUnit.SECONDS).observeOn(d.d());
        TemplateBannerAdapter.ImageHolder r4 = this.d;
        r17.subscribe(new C0182a(r4), new b(this.e, r4));
        return;
    L12:
        if (r15 != 2) goto L14;
        FragmentActivity r18 = this.d.a.getContext();
        if ((r18 instanceof FragmentActivity) == false) goto L20;
        FragmentActivity r19 = r18;
    L21:
        if (r19 == null) goto L43;
        FragmentManager r110 = r19.getSupportFragmentManager();
        if (r110 == null) goto L44;
        FragmentTransaction r111 = r110.beginTransaction();
        if (r111 == null) goto L45;
        FragmentTransaction r112 = r111.setCustomAnimations(2130772290, 2130772289, 2130772288, 2130772293);
        if (r112 == null) goto L46;
        int r0 = TopicFragment.i;
        Context r5 = this.d.a.getContext();
        String r6 = this.e.getTopicId();
        if (r6 != null) goto L31;
        r6 = "";
    L31:
        TopicFragment r7 = TopicFragment.a.a(r5, r6, -1, false);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r112, r7, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131367728) == true) goto L35;
        r112 = r112.add(2131367728, r7);
    L35:
        if (r112 == null) goto L47;
        FragmentTransaction r113 = r112.addToBackStack(null);
        if (r113 == null) goto L48;
        r113.commitAllowingStateLoss();
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L43:
        return;
    L20:
        r19 = null;
        goto L21
    L14:
        if (r15 == 5) goto L16;
        tt5.a.h("ImageAdapter", "not sensitivity ~ jump_link_url : " + this.e.getJump_link_url());
        this.c.d.u5(this.e.getJump_link_url());
        return;
    L16:
        TemplateUtils.f(TemplateUtils.a, this.e.getObjType(), this.e.getObjToken(), this.e.getCollection_id(), "templatecenter_banner", null, new c(this.d.a.getContext()), 16);
        return;
    L5:
        r14 = false;
        goto L6
    }

    public a(TemplateBannerAdapter r1, TemplateBannerAdapter.ImageHolder r2, BannerData r3, int r4) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
    }
}
