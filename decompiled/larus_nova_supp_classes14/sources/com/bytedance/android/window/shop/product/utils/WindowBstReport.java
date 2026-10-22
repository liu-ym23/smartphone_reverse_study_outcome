package com.bytedance.android.window.shop.product.utils;

import android.util.AndroidRuntimeException;
import android.view.View;
import com.bytedance.android.bst.api.d;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.bst.api.f;
import com.bytedance.android.bst.api.g;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.product.presenter.group.ECWindowProductCardGroupPresenterBase;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowBstReport {
    public static final /* synthetic */ int a = 0;

    public static abstract class a implements g {
        public final Map<String, Object> a;

        public abstract void b(String r1, Map<String, ? extends Object> r2);

        public a(Map<String, ? extends Object> r2) {
            Intrinsics.checkNotNullParameter(r2, "extra");
            this.a = r2;
        }

        public final void a(String r3, Map<Object, ? extends Object> r4) {
            Intrinsics.checkNotNullParameter(r3, "eventName");
            Intrinsics.checkNotNullParameter(r4, "params");
            Map<String, Object> r0 = this.a;
            int r1 = WindowBstReport.a;
            b(r3, MapsKt.plus(MapsKt.plus(r0, WindowBstReport.a(r4)), MapsKt.mapOf(TuplesKt.to("use_bst_v2", Boolean.TRUE))));
        }
    }

    public static final class b implements g {
        public final /* synthetic */ String a;
        public final /* synthetic */ WindowV2ProductItemVO b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ ECWindowViewModel d;
        public final /* synthetic */ BaseWindowTabViewModel e;
        public final /* synthetic */ WindowLayoutType f;
        public final /* synthetic */ Map g;

        public final void a(String r8, Map<Object, ? extends Object> r9) {
            Intrinsics.checkNotNullParameter(r8, "eventName");
            Intrinsics.checkNotNullParameter(r9, "params");
            if (this.c == false) goto L5;
            r8 = this.a;
        L5:
            ECWindowViewModel r6 = this.d;
            ECWindowProductCardGroupPresenterBase.a r0 = ECWindowProductCardGroupPresenterBase.w;
            BaseWindowTabViewModel r2 = this.e;
            WindowV2ProductItemVO r3 = this.b;
            WindowLayoutType r4 = this.f;
            String r5 = null;
            if ((r2 instanceof BaseWindowTabViewModel) == true) goto L8;
            BaseWindowTabViewModel r1 = null;
        L9:
            if (r1 == null) goto L11;
            r5 = r1.getLastCategoryId();
        L11:
            if (r5 != null) goto L13;
            r5 = "";
        L13:
            Map r7 = MapsKt.plus(ECWindowProductCardGroupPresenterBase.a.b(r0, r6, r2, r3, r4, r5), this.g);
            int r10 = WindowBstReport.a;
            r6.doAnyEventAction(r8, MapsKt.plus(r7, WindowBstReport.a(r9)), new Pair[]{TuplesKt.to("bst_group_type", "product"), TuplesKt.to("bst_tag", "bst_tag"), TuplesKt.to("use_bst_v2", Boolean.TRUE)});
            return;
        L8:
            r1 = r2;
            goto L9
        }

        public b(String r1, WindowV2ProductItemVO r2, boolean r3, ECWindowViewModel r4, BaseWindowTabViewModel r5, WindowLayoutType r6, Map r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    public WindowBstReport() {
    }

    static {
    }

    public static Map a(Map r4) {
        Intrinsics.checkNotNullParameter(r4, "input");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r5 = ((LinkedHashMap) r4).entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        Map.Entry r1 = (Map.Entry) r5.next();
        Object r2 = r1.getKey();
        Object r3 = r1.getValue();
        if ((r2 instanceof String) == false) goto L4;
        r0.put(r2, r3);
        goto L4
    L9:
        return r0;
    }

    public static void d(View r2, String r3, WindowV2ProductItemVO r4, com.bytedance.android.window.shop.product.utils.b r5) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "btm");
        Intrinsics.checkNotNullParameter(r4, "item");
        Intrinsics.checkNotNullParameter(r5, "reporter");
        String r0 = r4.b;
        if (r0 != null) goto L6;
        r0 = r4.a;
    L6:
        if (r3.length() != 0) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L11:
        d r7 = new d(r2);
        r7.a = r3;
        r7.b = "click_product";
        r7.c = r0;
        r7.d = "shopping";
        r7.e = -1;
        r7.f = r5;
        f.b.getClass();
        f.c(r7);
        return;
    L8:
        r6 = false;
        goto L9
    }

    public static void e(View r2, String r3, WindowV2ProductItemVO r4, c r5) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "btm");
        Intrinsics.checkNotNullParameter(r4, "item");
        Intrinsics.checkNotNullParameter(r5, "reporter");
        String r0 = r4.b;
        if (r0 != null) goto L6;
        r0 = r4.a;
    L6:
        if (r3.length() != 0) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L11:
        d r7 = new d(r2);
        r7.a = r3;
        r7.b = "show_product";
        r7.c = r0;
        r7.d = "shopping";
        r7.e = -1;
        r7.f = r5;
        f.b.getClass();
        f.a(r7);
        return;
    L8:
        r6 = false;
        goto L9
    }

    public static void c(View r1, String r2, BtmItemBuilder r3, WindowV2ProductItemVO r4, a r5) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r2, "btm");
        Intrinsics.checkNotNullParameter(r3, "btmItemBuilder");
        Intrinsics.checkNotNullParameter(r4, "item");
        Intrinsics.checkNotNullParameter(r5, "reporter");
        String r0 = r4.b;
        if (r0 != null) goto L6;
        r0 = r4.a;
    L6:
        if (r2.length() != 0) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == false) goto L12;
        if (r3 != null) goto L12;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L12:
        d r7 = new d(r1);
        r7.a = r2;
        r7.b = "click_product";
        r7.c = r0;
        r7.d = "shopping";
        r7.e = -1;
        r7.f = r5;
        f.b.getClass();
        f.c(r7);
        return;
    L8:
        r6 = false;
        goto L9
    }

    public static /* synthetic */ void g(View r9, String r10, WindowV2ProductItemVO r11, WindowLayoutType r12, Map r13, ECWindowViewModel r14, BaseWindowTabViewModel r15) {
        f(r9, r10, r11, r12, r13, r14, r15, "click_product", false);
    }

    public static /* synthetic */ void i(View r9, String r10, WindowV2ProductItemVO r11, WindowLayoutType r12, Map r13, ECWindowViewModel r14, BaseWindowTabViewModel r15) {
        h(r9, r10, r11, r12, r13, r14, r15, "show_product", false);
    }

    public static void f(View r11, String r12, WindowV2ProductItemVO r13, WindowLayoutType r14, Map r15, ECWindowViewModel r16, BaseWindowTabViewModel r17, String r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r12, "btm");
        Intrinsics.checkNotNullParameter(r13, "item");
        Intrinsics.checkNotNullParameter(r15, "eventParams");
        Intrinsics.checkNotNullParameter(r16, "viewModel");
        Intrinsics.checkNotNullParameter(r17, "tabViewModel");
        Intrinsics.checkNotNullParameter(r18, "eventName");
        b(r11, r18, r12, r13, r14, r15, r16, r17, r19, new WindowBstReport$reportWindowClickByBstV2$1(f.b));
    }

    public static void h(View r11, String r12, WindowV2ProductItemVO r13, WindowLayoutType r14, Map r15, ECWindowViewModel r16, BaseWindowTabViewModel r17, String r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r12, "btm");
        Intrinsics.checkNotNullParameter(r13, "item");
        Intrinsics.checkNotNullParameter(r15, "eventParams");
        Intrinsics.checkNotNullParameter(r16, "viewModel");
        Intrinsics.checkNotNullParameter(r17, "tabViewModel");
        Intrinsics.checkNotNullParameter(r18, "eventName");
        b(r11, r18, r12, r13, r14, r15, r16, r17, r19, new WindowBstReport$reportWindowShowByBstV2$1(f.b));
    }

    public static void b(View r11, String r12, String r13, WindowV2ProductItemVO r14, WindowLayoutType r15, Map r16, ECWindowViewModel r17, BaseWindowTabViewModel r18, boolean r19, Function1 r20) {
        String r0 = r14.b;
        if (r0 != null) goto L5;
        r0 = r14.a;
    L5:
        String r9 = r0;
        b r10 = new b(r12, r14, r19, r17, r18, r15, r16);
        if (r13.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L11:
        d r2 = new d(r11);
        r2.a = r13;
        if (r12 == null) goto L16;
        r2.b = r12;
        r2.c = r9;
        r2.d = "shopping";
        r2.e = -1;
        r2.f = r10;
        r20.invoke(r2);
        return;
    L16:
        throw new AndroidRuntimeException("event is empty");
    L8:
        r1 = false;
        goto L9
    }
}
