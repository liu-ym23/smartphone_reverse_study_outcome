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
import com.larus.nova.R;
import com.ss.android.lark.search.dto.UserGroupScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f0 implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f236365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SingleFileExceedQuotaFragment f236366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f236367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SingleFileQuotaConfig f236368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f236369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f236370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f236371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RecyclerView f236372h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AtUserSupportTextView f236373i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Button f236374j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SingleFileExceedQuotaSuiteAdapter f236375k;

    public class a extends com.bytedance.ee.bear.widgets.t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f0 f236376c;

        public a(f0 r100) {
            this.f236376c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            this.f236376c.f236366b.fa0();
            y.b((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), null, Boolean.FALSE, "暂无", "contact_service");
        }
    }

    public class b extends com.bytedance.ee.bear.widgets.t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f236377c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f236378d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f236379e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ f0 f236380f;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            SingleFileExceedQuotaFragment r101 = this.f236380f.f236366b;
            r101.f236329o = false;
            s45.h r102 = s45.g.f540568a;
            String r103 = s45.g.a.b("360034114413", "497171699982", null);
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(r103);
            SingleFileExceedQuotaFragment.da0(r101);
            y.b((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.f236377c, Boolean.valueOf(this.f236378d), this.f236379e, "lark_certification");
        }

        public b(f0 r100, String r101, boolean r102, String r103) {
            this.f236380f = r100;
            this.f236377c = r101;
            this.f236378d = r102;
            this.f236379e = r103;
        }
    }

    public class c extends com.bytedance.ee.bear.widgets.t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f236381c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f236382d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f236383e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ f0 f236384f;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            SingleFileExceedQuotaFragment r101 = this.f236384f.f236366b;
            r101.f236329o = false;
            SingleFileExceedQuotaFragment.da0(r101);
            y.b((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.f236381c, Boolean.valueOf(this.f236382d), this.f236383e, "already_know");
        }

        public c(f0 r100, String r101, boolean r102, String r103) {
            this.f236384f = r100;
            this.f236381c = r101;
            this.f236382d = r102;
            this.f236383e = r103;
        }
    }

    public class d extends com.bytedance.ee.bear.widgets.t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f236385c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f236386d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f236387e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ f0 f236388f;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            SingleFileExceedQuotaFragment r101 = this.f236388f.f236366b;
            r101.f236329o = false;
            SingleFileExceedQuotaFragment.da0(r101);
            y.b((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.f236385c, Boolean.valueOf(this.f236386d), this.f236387e, "already_know");
        }

        public d(f0 r100, String r101, boolean r102, String r103) {
            this.f236388f = r100;
            this.f236385c = r101;
            this.f236386d = r102;
            this.f236387e = r103;
        }
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        this.f236369e = this.f236365a.findViewById(R.id.root_container);
        this.f236370f = (ImageView) this.f236365a.findViewById(R.id.placeHolder);
        this.f236371g = (TextView) this.f236365a.findViewById(R.id.mainTitle);
        this.f236372h = (RecyclerView) this.f236365a.findViewById(R.id.gridRecycler);
        this.f236373i = (AtUserSupportTextView) this.f236365a.findViewById(R.id.subTitle);
        this.f236374j = (Button) this.f236365a.findViewById(R.id.done);
        this.f236372h.setLayoutManager(new LinearLayoutManager(this.f236367c, 0, false));
        SingleFileExceedQuotaSuiteAdapter r100 = new SingleFileExceedQuotaSuiteAdapter();
        this.f236375k = r100;
        this.f236372h.setAdapter(r100);
        this.f236372h.addItemDecoration(new SingleFileExceedQuotaItemDecoration());
    }

    public final int k() {
        SingleFileQuotaConfig r100 = this.f236368d;
        if (r100 != null) goto L6;
        return R.drawable.ccm_ccm_empty_positive_storage_limit;
    L6:
        return r100.getPlaceHolderId();
    }

    @Override // com.bytedance.ee.bear.quoto.x
    public final void w0() {
        this.f236370f.setImageResource(k());
        this.f236369e.setVisibility(0);
        this.f236371g.setText(i0.a(this.f236367c, this.f236368d));
        this.f236372h.setVisibility(8);
        AtUserSupportTextView r100 = this.f236373i;
        Context r101 = this.f236367c;
        SingleFileQuotaConfig r102 = this.f236368d;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r102 != null) goto L5;
        int r103 = ((Number) ListProtector.get(i0.f236408d, 0)).intValue();
    L15:
        r100.setText(r101.getString(r103));
        this.f236374j.setText(o(R.string.CreationMobile_Docs_StorageFull_ContactSupport_btn));
        this.f236374j.setOnClickListener(new a(this));
        y.c((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), null, Boolean.FALSE, "暂无");
        return;
    L5:
        int r104 = i0.a.C3385a.f236409a[r102.ordinal()];
        if (r104 != 1) goto L8;
        r103 = ((Number) ListProtector.get(i0.f236408d, 0)).intValue();
        goto L15
    L8:
        if (r104 != 2) goto L10;
        r103 = ((Number) ListProtector.get(i0.f236408d, 1)).intValue();
        goto L15
    L10:
        if (r104 == 3) goto L12;
        r103 = ((Number) ListProtector.get(i0.f236408d, 0)).intValue();
        goto L15
    L12:
        r103 = ((Number) ListProtector.get(i0.f236408d, 2)).intValue();
        goto L15
    }

    public final List<j0> h(Map<String, Long> r100) {
        ArrayList r101 = new ArrayList();
        String r102 = p(r100, "4");
        if (r102 == null) goto L5;
        r101.add(new j0("4", r102, o(R.string.CreationMobile_version_standard)));
    L5:
        String r103 = p(r100, "5");
        if (r103 == null) goto L8;
        r101.add(new j0("5", r103, o(R.string.CreationMobile_version_business)));
    L8:
        String r104 = p(r100, "6");
        if (r104 == null) goto L11;
        r101.add(new j0("6", r104, o(R.string.CreationMobile_version_enterprise)));
    L11:
        return r101;
    }

    public final String o(int r100) {
        return this.f236367c.getString(r100);
    }

    @Override // com.larksuite.framework.mvp.IView
    public final /* bridge */ /* synthetic */ void setViewDelegate(IView.IViewDelegate r100) {
        x.a r101 = (x.a) r100;
    }

    public static String p(Map r100, String r101) {
        Long r102 = (Long) r100.get(r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return wu5.a.a(Double.valueOf(r102.longValue()), "B", new DecimalFormat("#"));
    }

    @Override // com.bytedance.ee.bear.quoto.x
    public final void K0(Map r100, String r101, boolean r102) {
        this.f236370f.setImageResource(k());
        this.f236369e.setVisibility(0);
        this.f236371g.setText(i0.a(this.f236367c, this.f236368d));
        List<String> r103 = k0.f236413a;
        if (TextUtils.equals(r101, "4") == false) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L11;
        this.f236372h.setVisibility(8);
    L12:
        Long r105 = (Long) r100.get(r101);
        if (r105 == null) goto L15;
        Double r106 = Double.valueOf(r105.longValue());
    L16:
        String r107 = wu5.a.a(r106, "B", new DecimalFormat("#"));
        HashMap r108 = new HashMap();
        r108.put("version", k0.a(this.f236367c, r101));
        r108.put("max_statement", i0.b(this.f236367c, this.f236368d, r107));
        this.f236373i.setText(xo5.a.d(this.f236367c, R.string.CreationMobile_Drive_Upload_Max_content1, r108));
        this.f236374j.setText(o(R.string.CreationMobile_Docs_StorageFull_ContactSupport_btn));
        this.f236374j.setOnClickListener(new g0(this, r101, r102, r107));
        y.c((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r101, Boolean.valueOf(r102), r107);
        return;
    L15:
        r106 = null;
        goto L16
    L11:
        this.f236372h.setVisibility(0);
        SingleFileExceedQuotaSuiteAdapter r109 = this.f236375k;
        r109.f236334a = h(r100);
        r109.notifyDataSetChanged();
        goto L12
    L5:
        if (TextUtils.equals(r101, "5") == true) goto L8;
        r104 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.quoto.x
    public final void a2(String r100, boolean r101, Long r102) {
        this.f236370f.setImageResource(k());
        this.f236369e.setVisibility(0);
        this.f236371g.setText(i0.a(this.f236367c, this.f236368d));
        this.f236372h.setVisibility(8);
        String r103 = wu5.a.a(Double.valueOf(r102.longValue()), "B", new DecimalFormat("#"));
        AtUserSupportTextView r104 = this.f236373i;
        Context r105 = this.f236367c;
        SingleFileQuotaConfig r106 = this.f236368d;
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r106 != null) goto L5;
        int r107 = ((Number) ListProtector.get(i0.f236407c, 0)).intValue();
    L15:
        r104.setText(xo5.a.c(r105, r107, DownloadSettingKeys.MaxDiskSizeLimit.MAX_SIZE, r103));
        this.f236374j.setText(o(R.string.Doc_Facade_GotIt));
        this.f236374j.setOnClickListener(new h0(this, r100, r101, r103));
        y.c((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r100, Boolean.valueOf(r101), r103);
        return;
    L5:
        int r108 = i0.a.C3385a.f236409a[r106.ordinal()];
        if (r108 != 1) goto L8;
        r107 = ((Number) ListProtector.get(i0.f236407c, 0)).intValue();
        goto L15
    L8:
        if (r108 != 2) goto L10;
        r107 = ((Number) ListProtector.get(i0.f236407c, 1)).intValue();
        goto L15
    L10:
        if (r108 == 3) goto L12;
        r107 = ((Number) ListProtector.get(i0.f236407c, 0)).intValue();
        goto L15
    L12:
        r107 = ((Number) ListProtector.get(i0.f236407c, 2)).intValue();
        goto L15
    }

    @Override // com.bytedance.ee.bear.quoto.x
    public final void r4(Map<String, Long> r100, String r101, boolean r110) {
        this.f236370f.setImageResource(k());
        this.f236369e.setVisibility(0);
        this.f236371g.setText(i0.a(this.f236367c, this.f236368d));
        this.f236372h.setVisibility(8);
        Long r102 = r100.get("3");
        Double r103 = null;
        if (r102 == null) goto L5;
        Double r104 = Double.valueOf(r102.longValue());
    L6:
        String r105 = wu5.a.a(r104, "0B", new DecimalFormat("#"));
        Long r106 = r100.get("4");
        if (r106 == null) goto L9;
        r103 = Double.valueOf(r106.longValue());
    L9:
        String r107 = wu5.a.a(r103, "0B", new DecimalFormat("#"));
        HashMap r108 = new HashMap();
        r108.put("max_statement", i0.b(this.f236367c, this.f236368d, r105));
        r108.put(DownloadSettingKeys.MaxDiskSizeLimit.MAX_SIZE, r107);
        StringBuilder r109 = new StringBuilder(xo5.a.d(this.f236367c, R.string.CreationMobile_Drive_Upload_MaxSizeLessThan1GB_Unverified, r108));
        int r111 = r109.indexOf("<a>");
        int r112 = r109.indexOf("</a>");
        if (r111 < 0) goto L25;
        if (r112 < 0) goto L26;
        if (r111 > r112) goto L27;
        r109.replace(r111, r111 + 3, "");
        int r113 = r112 - 3;
        r109.replace(r113, r113 + 4, "");
        AtUserSupportTextView r114 = this.f236373i;
        String r115 = r109.toString();
        b r116 = new b(this, r101, r110, r107);
        r114.getClass();
        if (TextUtils.isEmpty(r115) == false) goto L17;
        tt5.a.h("AtUserSupportTextView", "setClickableText()...text is empty");
    L23:
        this.f236374j.setText(o(R.string.Doc_Facade_GotIt));
        this.f236374j.setOnClickListener(new c(this, r101, r110, r107));
        y.c((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r101, Boolean.valueOf(r110), r107);
        return;
    L17:
        if (r111 < 0) goto L22;
        if (r113 < 0) goto L22;
        if (r111 > r113) goto L22;
        SpannableStringBuilder r117 = new SpannableStringBuilder(r115);
        r117.setSpan(new ov4.a(r114, r116), r111, r113, 34);
        r114.setText(r117);
        r114.setMovementMethod(LinkMovementMethod.getInstance());
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
        r104 = null;
        goto L6
    }

    public f0(View r100, SingleFileExceedQuotaFragment r101, Context r102, SingleFileQuotaConfig r103) {
        this.f236365a = r100;
        this.f236366b = r101;
        this.f236367c = r102;
        this.f236368d = r103;
    }

    @Override // com.bytedance.ee.bear.quoto.x
    public final void Q0(Map<String, Long> r110, final String r111, final boolean r112, List<BusinessInfoRequester$BusinessAdminInfo> r113) {
        this.f236370f.setImageResource(k());
        this.f236369e.setVisibility(0);
        this.f236371g.setText(i0.a(this.f236367c, this.f236368d));
        List<String> r100 = k0.f236413a;
        if (TextUtils.equals(r111, "4") == false) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        this.f236372h.setVisibility(8);
    L12:
        Long r114 = r110.get(r111);
        if (r114 == null) goto L15;
        Double r115 = Double.valueOf(r114.longValue());
    L16:
        final String r116 = wu5.a.a(r115, "B", new DecimalFormat("#"));
        HashMap r102 = new HashMap();
        r102.put("version", k0.a(this.f236367c, r111));
        r102.put("max_statement", i0.b(this.f236367c, this.f236368d, r116));
        r102.put(UserGroupScene.DEFAULT_NAME_SPACE, "default_name");
        StringBuilder r103 = new StringBuilder(xo5.a.d(this.f236367c, R.string.CreationMobile_Drive_Upload_Max_content2, r102));
        ArrayList r104 = new ArrayList();
        int r105 = r103.indexOf("default_name");
        if (r113.size() != 1) goto L20;
        r103.replace(r105, r105 + 12, "@" + ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r113, 0)).name);
        r104.add(new ov4.b(this.f236367c, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r113, 0)).uid, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r113, 0)).name, new e0(this, r111, r112, r116)));
    L23:
        this.f236373i.y(r103.toString(), r104);
        this.f236374j.setText(o(R.string.Doc_Facade_GotIt));
        this.f236374j.setOnClickListener(new d(this, r111, r112, r116));
        y.c((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r111, Boolean.valueOf(r112), r116);
        return;
    L20:
        if (r113.size() != 2) goto L22;
        r103.replace(r105, r105 + 12, "@" + ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r113, 0)).name + "、@" + ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r113, 1)).name);
        ov4.b r106 = new ov4.b(this.f236367c, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r113, 0)).uid, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r113, 0)).name, new e0(this, r111, r112, r116));
        ov4.b r107 = new ov4.b(this.f236367c, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r113, 1)).uid, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r113, 1)).name, new e0(this, r111, r112, r116));
        r104.add(r106);
        r104.add(r107);
        goto L23
    L22:
        r103.replace(r105, r105 + 12, "@" + ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r113, 0)).name + "、@" + ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r113, 1)).name + "、@" + ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r113, 2)).name);
        ov4.b r108 = new ov4.b(this.f236367c, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r113, 0)).uid, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r113, 0)).name, new e0(this, r111, r112, r116));
        ov4.b r109 = new ov4.b(this.f236367c, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r113, 1)).uid, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r113, 1)).name, new e0(this, r111, r112, r116));
        ov4.b r117 = new ov4.b(this.f236367c, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r113, 2)).uid, ((BusinessInfoRequester$BusinessAdminInfo) ListProtector.get(r113, 2)).name, new e0(this, r111, r112, r116));
        r104.add(r108);
        r104.add(r109);
        r104.add(r117);
        goto L23
    L15:
        r115 = null;
        goto L16
    L11:
        this.f236372h.setVisibility(0);
        SingleFileExceedQuotaSuiteAdapter r118 = this.f236375k;
        r118.f236334a = h(r110);
        r118.notifyDataSetChanged();
        goto L12
    L5:
        if (TextUtils.equals(r111, "5") == true) goto L8;
        r101 = false;
        goto L9
    }
}
