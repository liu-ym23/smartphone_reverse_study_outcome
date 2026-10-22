package com.bytedance.ee.bear.templates.preview.single.common;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.templates.preview.data.CommonPreviewTemplateData;
import com.bytedance.ee.bear.templates.preview.data.Item;
import com.bytedance.ee.bear.widgets.t;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends t {
    public final /* synthetic */ CommonPreviewTemplateView c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.templates.preview.single.common.a$a, reason: collision with other inner class name */
    public static final class C0186a implements bn4.a.a {
        public final /* synthetic */ CommonPreviewTemplateView a;
        public final /* synthetic */ Item b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ boolean d;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.templates.preview.single.common.a$a$a, reason: collision with other inner class name */
        public static final class RunnableC0187a implements Runnable {
            public final /* synthetic */ CommonPreviewTemplateView a;
            public final /* synthetic */ Item b;
            public final /* synthetic */ boolean c;
            public final /* synthetic */ Context d;
            public final /* synthetic */ boolean e;

            public RunnableC0187a(CommonPreviewTemplateView r1, Item r2, boolean r3, Context r4, boolean r5) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }

            public final void a() {
                CommonTemplateViewModel r0 = this.a.h;
                if (r0 == null) goto L7;
                Item r1 = r0.getCurrTemplate();
                if (r1 == null) goto L7;
                String r2 = r1.getObjToken();
            L9:
                if (Intrinsics.areEqual(r2, this.b.getObjToken()) == true) goto L12;
                return;
            L12:
                if (this.c == false) goto L21;
                CommonPreviewTemplateView r3 = this.a;
                yn5.d r4 = new yn5.d(true, 1);
                CommonTemplateViewModel r5 = r3.h;
                if (r5 == null) goto L18;
                CommonPreviewTemplateData r6 = r5.getCommonPreviewTemplateData();
                if (r6 == null) goto L18;
                r6.setBitableSelectResult(r4);
            L18:
                CommonTemplateViewModel r7 = r3.h;
                if (r7 == null) goto L23;
                r7.loadTemplateDataFromNet();
                return;
            L23:
                return;
            L21:
                CommonPreviewTemplateView.a(this.a, this.d, this.e);
                return;
            L7:
                r2 = null;
                goto L9
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final void onResult(boolean r9) {
            CommonPreviewTemplateView r1 = this.a;
            TextView r6 = r1.g;
            if (r6 == null) goto L6;
            r6.post(new RunnableC0187a(r1, this.b, r9, this.c, this.d));
            return;
        }

        public C0186a(CommonPreviewTemplateView r1, Item r2, Context r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public a(CommonPreviewTemplateView r3) {
        this.c = r3;
        super(400);
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r9) {
        CommonTemplateViewModel r0 = this.c.h;
        if (r0 == null) goto L7;
        CommonPreviewTemplateData r1 = r0.getCommonPreviewTemplateData();
        if (r1 == null) goto L7;
        String r2 = r1.getModule();
    L8:
        CommonTemplateViewModel r3 = this.c.h;
        if (r3 == null) goto L13;
        CommonPreviewTemplateData r4 = r3.getCommonPreviewTemplateData();
        if (r4 == null) goto L13;
        String r5 = r4.getTemplateSource();
    L14:
        er5.b r6 = (er5.b) org.koin.java.a.c(er5.b.class, null, null, 6);
        if (r9 == null) goto L17;
        Context r10 = r9.getContext();
    L18:
        boolean r7 = false;
        if (Intrinsics.areEqual(r2, "lark_workspace_bitable_landing") == false) goto L21;
    L24:
        boolean r8 = true;
    L25:
        if (r10 == null) goto L41;
        if (r8 == false) goto L41;
        if (r6.j() == false) goto L41;
        boolean r11 = Intrinsics.areEqual(r5, "base_hp_create_form");
        CommonTemplateViewModel r12 = this.c.h;
        if (r12 == null) goto L32;
        Item r13 = r12.getCurrTemplate();
    L33:
        if (r11 == true) goto L40;
        if (r13 != null) goto L36;
    L38:
        if (r7 == false) goto L40;
        ((bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6)).o(r13.getObjToken(), new C0186a(this.c, r13, r10, r11));
        return;
    L36:
        if (r13.getObjType() != 8) goto L38;
        r7 = true;
    L40:
        CommonPreviewTemplateView.a(this.c, r10, r11);
        return;
    L32:
        r13 = null;
    L41:
        CommonTemplateViewModel r14 = this.c.h;
        if (r14 == null) goto L47;
        r14.loadTemplateDataFromNet();
        return;
    L47:
        return;
    L21:
        if (CollectionsKt.contains((List) CommonPreviewTemplateView.i.getValue(), r5) == true) goto L24;
        r8 = false;
        goto L25
    L17:
        r10 = null;
    L13:
        r5 = null;
    L7:
        r2 = null;
        goto L8
    }
}
