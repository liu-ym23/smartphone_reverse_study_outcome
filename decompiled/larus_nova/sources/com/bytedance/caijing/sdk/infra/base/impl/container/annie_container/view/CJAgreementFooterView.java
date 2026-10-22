package com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.view;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import ia.c;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m16.b;
import t36.d;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001aB\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016B\u0019\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0015\u0010\u0019J\b\u0010\u0005\u001a\u00020\u0004H\u0002R)\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000e8B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/impl/container/annie_container/view/CJAgreementFooterView;", "Landroid/widget/FrameLayout;", "Lye4/a;", "Lcom/android/ttcjpaysdk/base/ktextension/ICJTag;", "", "getLayoutId", "", "", "", "b", "Lkotlin/Lazy;", "getCommonEventParams", "()Ljava/util/Map;", "commonEventParams", "Landroid/net/Uri;", "schema", "Landroid/net/Uri;", "getSchema", "()Landroid/net/Uri;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cj-host-service-impl-container_release"}, k = 1, mv = {1, 6, 0})
public final class CJAgreementFooterView extends FrameLayout implements ye4.a, ICJTag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f202449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f202450b;

    public static final class a {
    }

    static {
    }

    private final int getLayoutId() {
        return R.layout.cj_pay_bank_footer_layout;
    }

    private final Uri getSchema() {
        d r100 = ye4.a.C8332a.c(null, null);
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getOriginUrl();
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final String CJTag() {
        return "CJAgreementFooterView";
    }

    private final Map<String, Object> getCommonEventParams() {
        return (Map) this.f202450b.getValue();
    }

    public final void b() {
        FrameLayout.inflate(getContext(), getLayoutId(), this);
        this.f202449a = (FrameLayout) findViewById(R.id.agreement_root_view);
        TextView r100 = (TextView) findViewById(R.id.agreement_link_view);
    }

    public CJAgreementFooterView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f202450b = LazyKt.lazy(new CJAgreementFooterView$commonEventParams$2(this));
        b();
    }

    public static final /* synthetic */ Uri a(CJAgreementFooterView r100) {
        return r100.getSchema();
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

    public CJAgreementFooterView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f202450b = LazyKt.lazy(new CJAgreementFooterView$commonEventParams$2(this));
        b();
    }

    @Override // ye4.a
    public final d U6(b r100, c r101) {
        return ye4.a.C8332a.c(r100, r101);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public final void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }

    @Override // ye4.a
    public final String hj(b r100, c r101) {
        return ye4.a.C8332a.a(this, r100, r101);
    }
}
