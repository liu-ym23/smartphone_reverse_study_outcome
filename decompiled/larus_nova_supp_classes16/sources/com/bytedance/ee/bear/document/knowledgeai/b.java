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
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import w15.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements com.bytedance.ee.bear.document.knowledgeai.a {
    public final DocsKnowledgeAIType a;
    public volatile int b;
    public volatile Drawable c;
    public volatile int d;
    public volatile Drawable e;

    public static final class a extends Drawable {
        public final int a;
        public final Drawable b;

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return this.b.getOpacity();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getIntrinsicHeight() {
            return this.a;
        }

        @Override // android.graphics.drawable.Drawable
        public final int getIntrinsicWidth() {
            return this.a;
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas r2) {
            Intrinsics.checkNotNullParameter(r2, "canvas");
            this.b.draw(r2);
        }

        @Override // android.graphics.drawable.Drawable
        public final void onBoundsChange(Rect r2) {
            Intrinsics.checkNotNullParameter(r2, "bounds");
            super.onBoundsChange(r2);
            this.b.setBounds(r2);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int r2) {
            this.b.setAlpha(r2);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter r2) {
            this.b.setColorFilter(r2);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setTintList(ColorStateList r2) {
            super.setTintList(r2);
            this.b.setTintList(r2);
        }

        public a(Context r2, Drawable r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "drawable");
            this.a = r4;
            Drawable.ConstantState r5 = r3.getConstantState();
            if (r5 == null) goto L9;
            Drawable r6 = r5.newDrawable(r2.getResources());
            if (r6 == null) goto L9;
            Drawable r7 = r6.mutate();
            if (r7 == null) goto L9;
        L10:
            this.b = r7;
            return;
        L9:
            r7 = r3.mutate();
            goto L10
        }
    }

    @Override // com.bytedance.ee.bear.document.knowledgeai.a
    public final void c() {
    }

    @Override // com.bytedance.ee.bear.document.knowledgeai.a
    public final void f(com.bytedance.ee.bear.document.knowledgeai.a.InterfaceC0081a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    @Inject
    public b() {
        this.a = DocsKnowledgeAIType.FLOW_AI;
    }

    @Override // com.bytedance.ee.bear.document.knowledgeai.a
    public final DocsKnowledgeAIType d() {
        return this.a;
    }

    @Override // com.bytedance.ee.bear.document.knowledgeai.a
    public final void e(final DocsKnowledgeAITypePlugin.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        j.c(new w15.b(r2));
    }

    @Override // com.bytedance.ee.bear.document.knowledgeai.a
    public final Drawable a(Context r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        boolean r0 = DowngradeSettingUtil.a("downgradeDocsKnowledgeAIIconDrawableCache");
        if (r0 == false) goto L5;
        tt5.a.h("OfficeDocsKnowledgeAI", "icon drawable cache downgrade hit, key=downgradeDocsKnowledgeAIIconDrawableCache");
    L5:
        if (r0 == false) goto L7;
    L12:
        IOfficeAppBaseInfo r1 = OfficeSDKManager.getHostGlobalService(IOfficeAppBaseInfo.class);
        Integer r2 = null;
        if (r1 != null) goto L15;
        return null;
    L15:
        Drawable r3 = r1.getDouBaoLinearIcon(r8);
        if (r3 != null) goto L18;
        return null;
    L18:
        Integer r4 = Integer.valueOf(r9);
        boolean r5 = false;
        if (r4.intValue() <= 0) goto L21;
        boolean r6 = true;
    L22:
        if (r6 == true) goto L25;
        r4 = null;
    L25:
        if (r4 != null) goto L35;
        r4 = Integer.valueOf(r3.getIntrinsicWidth());
        if (r4.intValue() <= 0) goto L30;
        boolean r7 = true;
    L31:
        if (r7 == true) goto L34;
        r4 = null;
    L34:
        if (r4 != null) goto L35;
        Integer r10 = Integer.valueOf(r3.getIntrinsicHeight());
        if (r10.intValue() <= 0) goto L39;
        r5 = true;
    L39:
        if (r5 == false) goto L41;
        r2 = r10;
    L41:
        if (r2 == null) goto L47;
        int r11 = r2.intValue();
    L43:
        a r12 = new a(r8, r3, r11);
        if (r0 == true) goto L46;
        this.d = r9;
        this.e = c.a(r12, r8);
    L46:
        return r12;
    L47:
        return r3;
    L30:
        r7 = false;
    L35:
        r11 = r4.intValue();
        goto L43
    L21:
        r6 = false;
        goto L22
    L7:
        if (this.d != r9) goto L12;
        Drawable r13 = this.e;
        if (r13 == null) goto L12;
        return c.a(r13, r8);
    }

    @Override // com.bytedance.ee.bear.document.knowledgeai.a
    public final Drawable b(Context r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        boolean r0 = DowngradeSettingUtil.a("downgradeDocsKnowledgeAIIconDrawableCache");
        if (r0 == false) goto L5;
        tt5.a.h("OfficeDocsKnowledgeAI", "icon drawable cache downgrade hit, key=downgradeDocsKnowledgeAIIconDrawableCache");
    L5:
        if (r0 == false) goto L7;
    L12:
        IOfficeAppBaseInfo r1 = OfficeSDKManager.getHostGlobalService(IOfficeAppBaseInfo.class);
        Integer r2 = null;
        if (r1 != null) goto L15;
        return null;
    L15:
        Drawable r3 = r1.getDouBaoIcon(r8);
        if (r3 != null) goto L18;
        return null;
    L18:
        Integer r4 = Integer.valueOf(r9);
        boolean r5 = false;
        if (r4.intValue() <= 0) goto L21;
        boolean r6 = true;
    L22:
        if (r6 == true) goto L25;
        r4 = null;
    L25:
        if (r4 != null) goto L35;
        r4 = Integer.valueOf(r3.getIntrinsicWidth());
        if (r4.intValue() <= 0) goto L30;
        boolean r7 = true;
    L31:
        if (r7 == true) goto L34;
        r4 = null;
    L34:
        if (r4 != null) goto L35;
        Integer r10 = Integer.valueOf(r3.getIntrinsicHeight());
        if (r10.intValue() <= 0) goto L39;
        r5 = true;
    L39:
        if (r5 == false) goto L41;
        r2 = r10;
    L41:
        if (r2 == null) goto L47;
        int r11 = r2.intValue();
    L43:
        a r12 = new a(r8, r3, r11);
        if (r0 == true) goto L46;
        this.b = r9;
        this.c = c.a(r12, r8);
    L46:
        return r12;
    L47:
        return r3;
    L30:
        r7 = false;
    L35:
        r11 = r4.intValue();
        goto L43
    L21:
        r6 = false;
        goto L22
    L7:
        if (this.b != r9) goto L12;
        Drawable r13 = this.c;
        if (r13 == null) goto L12;
        return c.a(r13, r8);
    }
}
