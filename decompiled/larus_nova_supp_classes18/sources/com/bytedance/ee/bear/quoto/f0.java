package com.bytedance.ee.bear.quoto;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.at.AtUserSupportTextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.mvp.IView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f0 implements x {
    public final View a;
    public final SingleFileExceedQuotaFragment b;
    public final Context c;
    public final SingleFileQuotaConfig d;
    public View e;
    public ImageView f;
    public TextView g;
    public RecyclerView h;
    public AtUserSupportTextView i;
    public Button j;
    public SingleFileExceedQuotaSuiteAdapter k;

    public class a extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ f0 c;

        public a(f0 r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r5) {
            this.c.b.fa0();
            y.b((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), null, Boolean.FALSE, "暂无", "contact_service");
        }
    }

    public class b extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ String e;
        public final /* synthetic */ f0 f;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r5) {
            SingleFileExceedQuotaFragment r6 = this.f.b;
            r6.o = false;
            s45.h r0 = s45.g.a;
            String r1 = s45.g.a.b("360034114413", "497171699982", null);
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(r1);
            SingleFileExceedQuotaFragment.da0(r6);
            y.b((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.c, Boolean.valueOf(this.d), this.e, "lark_certification");
        }

        public b(f0 r1, String r2, boolean r3, String r4) {
            this.f = r1;
            this.c = r2;
            this.d = r3;
            this.e = r4;
        }
    }

    public class c extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ String e;
        public final /* synthetic */ f0 f;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r5) {
            SingleFileExceedQuotaFragment r6 = this.f.b;
            r6.o = false;
            SingleFileExceedQuotaFragment.da0(r6);
            y.b((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.c, Boolean.valueOf(this.d), this.e, "already_know");
        }

        public c(f0 r1, String r2, boolean r3, String r4) {
            this.f = r1;
            this.c = r2;
            this.d = r3;
            this.e = r4;
        }
    }

    public class d extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ String e;
        public final /* synthetic */ f0 f;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r5) {
            SingleFileExceedQuotaFragment r6 = this.f.b;
            r6.o = false;
            SingleFileExceedQuotaFragment.da0(r6);
            y.b((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.c, Boolean.valueOf(this.d), this.e, "already_know");
        }

        public d(f0 r1, String r2, boolean r3, String r4) {
            this.f = r1;
            this.c = r2;
            this.d = r3;
            this.e = r4;
        }
    }

    public final void destroy() {
    }

    public final void create() {
        this.e = this.a.findViewById(2131384822);
        this.f = (ImageView) this.a.findViewById(2131382374);
        this.g = (TextView) this.a.findViewById(2131379424);
        this.h = this.a.findViewById(2131373898);
        this.i = this.a.findViewById(2131387517);
        this.j = (Button) this.a.findViewById(2131369396);
        this.h.setLayoutManager(new LinearLayoutManager(this.c, 0, false));
        SingleFileExceedQuotaSuiteAdapter r0 = new SingleFileExceedQuotaSuiteAdapter();
        this.k = r0;
        this.h.setAdapter(r0);
        this.h.addItemDecoration(new SingleFileExceedQuotaItemDecoration());
    }

    public final int k() {
        SingleFileQuotaConfig r0 = this.d;
        if (r0 != null) goto L6;
        return 2131232538;
    L6:
        return r0.getPlaceHolderId();
    }

    @Override // com.bytedance.ee.bear.quoto.x
    public final void w0() {
        this.f.setImageResource(k());
        this.e.setVisibility(0);
        this.g.setText(i0.a(this.c, this.d));
        this.h.setVisibility(8);
        AtUserSupportTextView r0 = this.i;
        Context r2 = this.c;
        SingleFileQuotaConfig r3 = this.d;
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r3 != null) goto L5;
        int r1 = ((Number) ListProtector.get(i0.d, 0)).intValue();
    L15:
        r0.setText(r2.getString(r1));
        this.j.setText(o(2131887220));
        this.j.setOnClickListener(new a(this));
        y.c((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), null, Boolean.FALSE, "暂无");
        return;
    L5:
        int r4 = i0.a.C0138a.a[r3.ordinal()];
        if (r4 != 1) goto L8;
        r1 = ((Number) ListProtector.get(i0.d, 0)).intValue();
        goto L15
    L8:
        if (r4 != 2) goto L10;
        r1 = ((Number) ListProtector.get(i0.d, 1)).intValue();
        goto L15
    L10:
        if (r4 == 3) goto L12;
        r1 = ((Number) ListProtector.get(i0.d, 0)).intValue();
        goto L15
    L12:
        r1 = ((Number) ListProtector.get(i0.d, 2)).intValue();
        goto L15
    }

    public final List<j0> h(Map<String, Long> r6) {
        ArrayList r0 = new ArrayList();
        String r2 = p(r6, "4");
        if (r2 == null) goto L5;
        r0.add(new j0("4", r2, o(2131887565)));
    L5:
        String r3 = p(r6, "5");
        if (r3 == null) goto L8;
        r0.add(new j0("5", r3, o(2131887563)));
    L8:
        String r7 = p(r6, "6");
        if (r7 == null) goto L11;
        r0.add(new j0("6", r7, o(2131887564)));
    L11:
        return r0;
    }

    public final String o(int r2) {
        return this.c.getString(r2);
    }

    public final /* bridge */ /* synthetic */ void setViewDelegate(IView.IViewDelegate r1) {
        x.a r2 = (x.a) r1;
    }

    public static String p(Map r1, String r2) {
        Long r3 = (Long) r1.get(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return wu5.a.a(Double.valueOf(r3.longValue()), "B", new DecimalFormat("#"));
    }

    @Override // com.bytedance.ee.bear.quoto.x
    public final void K0(Map r5, String r6, boolean r7) {
        this.f.setImageResource(k());
        this.e.setVisibility(0);
        this.g.setText(i0.a(this.c, this.d));
        List<String> r0 = k0.a;
        if (TextUtils.equals(r6, "4") == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        this.h.setVisibility(8);
    L12:
        Long r8 = (Long) r5.get(r6);
        if (r8 == null) goto L15;
        Double r9 = Double.valueOf(r8.longValue());
    L16:
        String r10 = wu5.a.a(r9, "B", new DecimalFormat("#"));
        HashMap r2 = new HashMap();
        r2.put("version", k0.a(this.c, r6));
        r2.put("max_statement", i0.b(this.c, this.d, r10));
        this.i.setText(xo5.a.d(this.c, 2131887240, r2));
        this.j.setText(o(2131887220));
        this.j.setOnClickListener(new g0(this, r6, r7, r10));
        y.c((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r6, Boolean.valueOf(r7), r10);
        return;
    L15:
        r9 = null;
        goto L16
    L11:
        this.h.setVisibility(0);
        SingleFileExceedQuotaSuiteAdapter r3 = this.k;
        r3.a = h(r5);
        r3.notifyDataSetChanged();
        goto L12
    L5:
        if (TextUtils.equals(r6, "5") == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.quoto.x
    public final void a2(String r7, boolean r8, Long r9) {
        this.f.setImageResource(k());
        this.e.setVisibility(0);
        this.g.setText(i0.a(this.c, this.d));
        this.h.setVisibility(8);
        String r10 = wu5.a.a(Double.valueOf(r9.longValue()), "B", new DecimalFormat("#"));
        AtUserSupportTextView r0 = this.i;
        Context r2 = this.c;
        SingleFileQuotaConfig r3 = this.d;
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r3 != null) goto L5;
        int r1 = ((Number) ListProtector.get(i0.c, 0)).intValue();
    L15:
        r0.setText(xo5.a.c(r2, r1, "max_size", r10));
        this.j.setText(o(2131887759));
        this.j.setOnClickListener(new h0(this, r7, r8, r10));
        y.c((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r7, Boolean.valueOf(r8), r10);
        return;
    L5:
        int r4 = i0.a.C0138a.a[r3.ordinal()];
        if (r4 != 1) goto L8;
        r1 = ((Number) ListProtector.get(i0.c, 0)).intValue();
        goto L15
    L8:
        if (r4 != 2) goto L10;
        r1 = ((Number) ListProtector.get(i0.c, 1)).intValue();
        goto L15
    L10:
        if (r4 == 3) goto L12;
        r1 = ((Number) ListProtector.get(i0.c, 0)).intValue();
        goto L15
    L12:
        r1 = ((Number) ListProtector.get(i0.c, 2)).intValue();
        goto L15
    }

    @Override // com.bytedance.ee.bear.quoto.x
    public final void r4(Map<String, Long> r8, String r9, boolean r10) {
        this.f.setImageResource(k());
        this.e.setVisibility(0);
        this.g.setText(i0.a(this.c, this.d));
        this.h.setVisibility(8);
        Long r0 = r8.get("3");
        Double r1 = null;
        if (r0 == null) goto L5;
        Double r2 = Double.valueOf(r0.longValue());
    L6:
        String r3 = wu5.a.a(r2, "0B", new DecimalFormat("#"));
        Long r11 = r8.get("4");
        if (r11 == null) goto L9;
        r1 = Double.valueOf(r11.longValue());
    L9:
        String r12 = wu5.a.a(r1, "0B", new DecimalFormat("#"));
        HashMap r4 = new HashMap();
        r4.put("max_statement", i0.b(this.c, this.d, r3));
        r4.put("max_size", r12);
        StringBuilder r5 = new StringBuilder(xo5.a.d(this.c, 2131887239, r4));
        int r6 = r5.indexOf("<a>");
        int r7 = r5.indexOf("</a>");
        if (r6 < 0) goto L25;
        if (r7 < 0) goto L26;
        if (r6 > r7) goto L27;
        r5.replace(r6, r6 + 3, "");
        int r13 = r7 - 3;
        r5.replace(r13, r13 + 4, "");
        AtUserSupportTextView r14 = this.i;
        String r15 = r5.toString();
        b r16 = new b(this, r9, r10, r12);
        r14.getClass();
        if (TextUtils.isEmpty(r15) == false) goto L17;
        tt5.a.h("AtUserSupportTextView", "setClickableText()...text is empty");
    L23:
        this.j.setText(o(2131887759));
        this.j.setOnClickListener(new c(this, r9, r10, r12));
        y.c((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r9, Boolean.valueOf(r10), r12);
        return;
    L17:
        if (r6 < 0) goto L22;
        if (r13 < 0) goto L22;
        if (r6 > r13) goto L22;
        SpannableStringBuilder r17 = new SpannableStringBuilder(r15);
        r17.setSpan(new ov4.a(r14, r16), r6, r13, 34);
        r14.setText(r17);
        r14.setMovementMethod(LinkMovementMethod.getInstance());
    L22:
        tt5.a.h("AtUserSupportTextView", "setClickableText()...begin or end is error");
        goto L23
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public f0(View r1, SingleFileExceedQuotaFragment r2, Context r3, SingleFileQuotaConfig r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // com.bytedance.ee.bear.quoto.x
    public final void Q0(Map<String, Long> r11, final String r12, final boolean r13, List<BusinessInfoRequester$BusinessAdminInfo> r14) {
        this.f.setImageResource(k());
        this.e.setVisibility(0);
        this.g.setText(i0.a(this.c, this.d));
        List<String> r0 = k0.a;
        if (TextUtils.equals(r12, "4") == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        this.h.setVisibility(8);
    L12:
        Long r15 = r11.get(r12);
        if (r15 == null) goto L15;
        Double r16 = Double.valueOf(r15.longValue());
    L16:
        final String r17 = wu5.a.a(r16, "B", new DecimalFormat("#"));
        HashMap r2 = new HashMap();
        r2.put("version", k0.a(this.c, r12));
        r2.put("max_statement", i0.b(this.c, this.d, r17));
        r2.put("admin", "default_name");
        StringBuilder r3 = new StringBuilder(xo5.a.d(this.c, 2131887241, r2));
        ArrayList r4 = new ArrayList();
        int r5 = r3.indexOf("default_name");
        if (r14.size() != 1) goto L20;
        r3.replace(r5, r5 + 12, "@" + ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r14, 0)).name);
        r4.add(new ov4.b(this.c, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r14, 0)).uid, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r14, 0)).name, new e0(this, r12, r13, r17)));
    L23:
        this.i.y(r3.toString(), r4);
        this.j.setText(o(2131887759));
        this.j.setOnClickListener(new d(this, r12, r13, r17));
        y.c((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r12, Boolean.valueOf(r13), r17);
        return;
    L20:
        if (r14.size() != 2) goto L22;
        r3.replace(r5, r5 + 12, "@" + ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r14, 0)).name + "、@" + ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r14, 1)).name);
        ov4.b r6 = new ov4.b(this.c, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r14, 0)).uid, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r14, 0)).name, new e0(this, r12, r13, r17));
        ov4.b r7 = new ov4.b(this.c, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r14, 1)).uid, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r14, 1)).name, new e0(this, r12, r13, r17));
        r4.add(r6);
        r4.add(r7);
        goto L23
    L22:
        r3.replace(r5, r5 + 12, "@" + ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r14, 0)).name + "、@" + ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r14, 1)).name + "、@" + ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r14, 2)).name);
        ov4.b r8 = new ov4.b(this.c, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r14, 0)).uid, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r14, 0)).name, new e0(this, r12, r13, r17));
        ov4.b r9 = new ov4.b(this.c, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r14, 1)).uid, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r14, 1)).name, new e0(this, r12, r13, r17));
        ov4.b r10 = new ov4.b(this.c, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r14, 2)).uid, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r14, 2)).name, new e0(this, r12, r13, r17));
        r4.add(r8);
        r4.add(r9);
        r4.add(r10);
        goto L23
    L15:
        r16 = null;
        goto L16
    L11:
        this.h.setVisibility(0);
        SingleFileExceedQuotaSuiteAdapter r18 = this.k;
        r18.a = h(r11);
        r18.notifyDataSetChanged();
        goto L12
    L5:
        if (TextUtils.equals(r12, "5") == true) goto L8;
        r1 = false;
        goto L9
    }
}
