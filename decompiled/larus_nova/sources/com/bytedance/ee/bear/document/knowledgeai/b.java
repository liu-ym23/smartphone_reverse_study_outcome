package com.bytedance.ee.bear.document.knowledgeai;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.util.ui.j;
import com.ss.android.lark.officesdk.api.service.capacity.IOfficeAppBaseInfo;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import w15.c;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements com.bytedance.ee.bear.document.knowledgeai.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DocsKnowledgeAIType f220149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f220150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Drawable f220151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f220152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Drawable f220153e;

    public static final class a extends Drawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f220154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Drawable f220155b;

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return this.f220155b.getOpacity();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getIntrinsicHeight() {
            return this.f220154a;
        }

        @Override // android.graphics.drawable.Drawable
        public final int getIntrinsicWidth() {
            return this.f220154a;
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas r100) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            this.f220155b.draw(r100);
        }

        @Override // android.graphics.drawable.Drawable
        public final void onBoundsChange(Rect r100) {
            Intrinsics.checkNotNullParameter(r100, "bounds");
            super.onBoundsChange(r100);
            this.f220155b.setBounds(r100);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int r100) {
            this.f220155b.setAlpha(r100);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter r100) {
            this.f220155b.setColorFilter(r100);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setTintList(ColorStateList r100) {
            super.setTintList(r100);
            this.f220155b.setTintList(r100);
        }

        public a(Context r100, Drawable r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "drawable");
            this.f220154a = r102;
            Drawable.ConstantState r103 = r101.getConstantState();
            if (r103 == null) goto L9;
            Drawable r104 = r103.newDrawable(r100.getResources());
            if (r104 == null) goto L9;
            Drawable r105 = r104.mutate();
            if (r105 == null) goto L9;
        L10:
            this.f220155b = r105;
            return;
        L9:
            r105 = r101.mutate();
            goto L10
        }
    }

    @Override // com.bytedance.ee.bear.document.knowledgeai.a
    public final void c() {
    }

    @Override // com.bytedance.ee.bear.document.knowledgeai.a
    public final void f(com.bytedance.ee.bear.document.knowledgeai.a.InterfaceC3137a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Inject
    public b() {
        this.f220149a = DocsKnowledgeAIType.FLOW_AI;
    }

    @Override // com.bytedance.ee.bear.document.knowledgeai.a
    public final DocsKnowledgeAIType d() {
        return this.f220149a;
    }

    @Override // com.bytedance.ee.bear.document.knowledgeai.a
    public final void e(final DocsKnowledgeAITypePlugin.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        j.c(new w15.b(r100));
    }

    @Override // com.bytedance.ee.bear.document.knowledgeai.a
    public final Drawable a(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r102 = DowngradeSettingUtil.a("downgradeDocsKnowledgeAIIconDrawableCache");
        if (r102 == false) goto L5;
        tt5.a.h("OfficeDocsKnowledgeAI", "icon drawable cache downgrade hit, key=downgradeDocsKnowledgeAIIconDrawableCache");
    L5:
        if (r102 == false) goto L7;
    L12:
        IOfficeAppBaseInfo r103 = (IOfficeAppBaseInfo) OfficeSDKManager.getHostGlobalService(IOfficeAppBaseInfo.class);
        Integer r104 = null;
        if (r103 != null) goto L15;
        return null;
    L15:
        Drawable r105 = r103.getDouBaoLinearIcon(r100);
        if (r105 != null) goto L18;
        return null;
    L18:
        Integer r106 = Integer.valueOf(r101);
        boolean r107 = false;
        if (r106.intValue() <= 0) goto L21;
        boolean r108 = true;
    L22:
        if (r108 == true) goto L25;
        r106 = null;
    L25:
        if (r106 != null) goto L35;
        r106 = Integer.valueOf(r105.getIntrinsicWidth());
        if (r106.intValue() <= 0) goto L30;
        boolean r109 = true;
    L31:
        if (r109 == true) goto L34;
        r106 = null;
    L34:
        if (r106 != null) goto L35;
        Integer r110 = Integer.valueOf(r105.getIntrinsicHeight());
        if (r110.intValue() <= 0) goto L39;
        r107 = true;
    L39:
        if (r107 == false) goto L41;
        r104 = r110;
    L41:
        if (r104 == null) goto L47;
        int r111 = r104.intValue();
    L43:
        a r112 = new a(r100, r105, r111);
        if (r102 == true) goto L46;
        this.f220152d = r101;
        this.f220153e = c.a(r112, r100);
    L46:
        return r112;
    L47:
        return r105;
    L30:
        r109 = false;
    L35:
        r111 = r106.intValue();
        goto L43
    L21:
        r108 = false;
        goto L22
    L7:
        if (this.f220152d != r101) goto L12;
        Drawable r113 = this.f220153e;
        if (r113 == null) goto L12;
        return c.a(r113, r100);
    }

    @Override // com.bytedance.ee.bear.document.knowledgeai.a
    public final Drawable b(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r102 = DowngradeSettingUtil.a("downgradeDocsKnowledgeAIIconDrawableCache");
        if (r102 == false) goto L5;
        tt5.a.h("OfficeDocsKnowledgeAI", "icon drawable cache downgrade hit, key=downgradeDocsKnowledgeAIIconDrawableCache");
    L5:
        if (r102 == false) goto L7;
    L12:
        IOfficeAppBaseInfo r103 = (IOfficeAppBaseInfo) OfficeSDKManager.getHostGlobalService(IOfficeAppBaseInfo.class);
        Integer r104 = null;
        if (r103 != null) goto L15;
        return null;
    L15:
        Drawable r105 = r103.getDouBaoIcon(r100);
        if (r105 != null) goto L18;
        return null;
    L18:
        Integer r106 = Integer.valueOf(r101);
        boolean r107 = false;
        if (r106.intValue() <= 0) goto L21;
        boolean r108 = true;
    L22:
        if (r108 == true) goto L25;
        r106 = null;
    L25:
        if (r106 != null) goto L35;
        r106 = Integer.valueOf(r105.getIntrinsicWidth());
        if (r106.intValue() <= 0) goto L30;
        boolean r109 = true;
    L31:
        if (r109 == true) goto L34;
        r106 = null;
    L34:
        if (r106 != null) goto L35;
        Integer r110 = Integer.valueOf(r105.getIntrinsicHeight());
        if (r110.intValue() <= 0) goto L39;
        r107 = true;
    L39:
        if (r107 == false) goto L41;
        r104 = r110;
    L41:
        if (r104 == null) goto L47;
        int r111 = r104.intValue();
    L43:
        a r112 = new a(r100, r105, r111);
        if (r102 == true) goto L46;
        this.f220150b = r101;
        this.f220151c = c.a(r112, r100);
    L46:
        return r112;
    L47:
        return r105;
    L30:
        r109 = false;
    L35:
        r111 = r106.intValue();
        goto L43
    L21:
        r108 = false;
        goto L22
    L7:
        if (this.f220150b != r101) goto L12;
        Drawable r113 = this.f220151c;
        if (r113 == null) goto L12;
        return c.a(r113, r100);
    }
}
