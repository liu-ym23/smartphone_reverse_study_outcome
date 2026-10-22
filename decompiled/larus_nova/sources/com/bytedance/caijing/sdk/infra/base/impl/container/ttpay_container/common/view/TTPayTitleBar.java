package com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.view;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.caijing.sdk.infra.base.api.plugin.PluginService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import ia.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m16.b;
import t36.d;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0011B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u0019\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¨\u0006\u0012"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/impl/container/ttpay_container/common/view/TTPayTitleBar;", "Landroid/widget/FrameLayout;", "Lcom/android/ttcjpaysdk/base/ktextension/ICJTag;", "Lcom/bytedance/caijing/sdk/infra/base/impl/container/ttpay_container/common/base/a;", "", "getLayoutId", "Landroid/net/Uri;", "schema", "", "setFullPageStyle", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cj-host-service-impl-container_release"}, k = 1, mv = {1, 6, 0})
public final class TTPayTitleBar extends FrameLayout implements ICJTag, com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RelativeLayout f202529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f202530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f202531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f202532d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f202533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Uri f202534b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f202535c;

        public a(boolean r100, Uri r101, b r102) {
            this.f202533a = r100;
            this.f202534b = r101;
            this.f202535c = r102;
        }
    }

    private final int getLayoutId() {
        return R.layout.cj_pay_annie_titlebar_layout;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final String CJTag() {
        return "TTPayTitleBar";
    }

    public final void a() {
        View r100 = LayoutInflater.from(getContext()).inflate(getLayoutId(), this, true);
        TextView r101 = null;
        if (r100 == null) goto L5;
        RelativeLayout r102 = (RelativeLayout) r100.findViewById(R.id.cj_pay_annie_titlebar_layout);
    L6:
        this.f202529a = r102;
        if (r100 == null) goto L9;
        ImageView r103 = (ImageView) r100.findViewById(R.id.cj_pay_back_view);
    L10:
        this.f202530b = r103;
        if (r100 == null) goto L13;
        r101 = (TextView) r100.findViewById(R.id.cj_pay_title_view);
    L13:
        this.f202531c = r101;
        return;
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public TTPayTitleBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        a();
    }

    private final void setFullPageStyle(Uri r100) {
        ImageView r101 = this.f202530b;
        if (r101 == null) goto L5;
        r101.setImageDrawable(getContext().getDrawable(R.drawable.cj_pay_icon_titlebar_left_arrow));
    L5:
        if (r100 == null) goto L21;
        String r102 = UriProtector.getQueryParameter(r100, AppConstants.TRANS_STATUS_BAR);
        if (r102 != null) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual("1", r102) == true) goto L12;
        r102 = null;
    L12:
        if (r102 == null) goto L23;
        ve4.a.f554342a.getClass();
        PluginService r103 = (PluginService) ve4.a.a(PluginService.class);
        if (r103 == null) goto L16;
        int r104 = r103.getStatusBarHeight(getContext());
    L17:
        RelativeLayout r105 = this.f202529a;
        if (r105 == null) goto L24;
        CJPayViewExtensionsKt.setTopMargin(r105, r104);
        return;
    L24:
        return;
    L16:
        r104 = 0;
        goto L17
    L23:
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a
    public final String Sn(d r100) {
        return com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.c(r100, "cj_biz");
    }

    public final void b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "initModel");
        this.f202532d = r100;
        if (r100.f202533a == false) goto L7;
        ImageView r101 = this.f202530b;
        if (r101 == null) goto L8;
        r101.setImageDrawable(getContext().getDrawable(R.drawable.cj_pay_icon_x_close));
    L8:
        TextView r102 = this.f202531c;
        if (r102 == null) goto L11;
        r102.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        r102.getPaint().setStrokeWidth(0.5f);
    L11:
        a r103 = this.f202532d;
        String r104 = null;
        if (r103 == null) goto L14;
        b r105 = r103.f202535c;
    L15:
        d r106 = com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.e(r105, null);
        if (r106 == null) goto L32;
        String r107 = com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.d(r106, "title");
        if (r107 != null) goto L20;
        r107 = com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.c(r106, "title");
    L20:
        if (r107 == null) goto L32;
        if (r107.length() <= 0) goto L24;
        boolean r108 = true;
    L25:
        if (r108 == false) goto L27;
        r104 = r107;
    L27:
        if (r104 == null) goto L32;
        TextView r109 = this.f202531c;
        if (r109 == null) goto L32;
        r109.setText(r104);
        goto L32
    L24:
        r108 = false;
    L32:
        ImageView r110 = this.f202530b;
        if (r110 == null) goto L36;
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r110, new TTPayTitleBar$initAction$1(this));
        return;
    L36:
        return;
    L14:
        r105 = null;
        goto L15
    L7:
        setFullPageStyle(r100.f202534b);
        goto L8
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    public TTPayTitleBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        a();
    }

    @Override // com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a
    public final d U6(b r100, c r101) {
        return com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.e(r100, r101);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }
}
