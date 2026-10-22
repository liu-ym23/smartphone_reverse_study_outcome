package com.bytedance.awemeopen.apps.framework.report;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.awemeopen.apps.framework.base.view.AutoRTLImageView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtStatusView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosDefaultNetErrorView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/report/AosWebReportFragment;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosBaseFragment;", "Lcom/bytedance/awemeopen/apps/framework/report/WebReportFragmentViewModel;", "<init>", "()V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosWebReportFragment extends AosBaseFragment<WebReportFragmentViewModel> {
    public static final /* synthetic */ int o = 0;
    public AutoRTLImageView g;
    public DmtTextView h;
    public FrameLayout i;
    public DmtStatusView j;
    public f34.a k;
    public View l;
    public final com.bytedance.awemeopen.apps.framework.report.a m;
    public final Map<Integer, View> n;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void S90() {
        ((LinkedHashMap) this.n).clear();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final int X90() {
        return 2131558711;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void ba0(Bundle r1) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final Class<WebReportFragmentViewModel> da0() {
        return WebReportFragmentViewModel.class;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.awemeopen.apps.framework.report.a] */
    public AosWebReportFragment() {
        this.n = new LinkedHashMap();
        this.m = new com.bytedance.awemeopen.apps.framework.report.a(this);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final Boolean onBackPressed() {
        f34.a r0 = this.k;
        if (r0 == null) goto L9;
        if (r0.onBackPressed() == false) goto L9;
        return Boolean.TRUE;
    L9:
        return Boolean.FALSE;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Y90() {
        W90().getUrlLoadStatus().observe(this, this.m);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Z90() {
        W90().getUrlLoadStatus().removeObserver(this.m);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void initView() {
        this.g = (AutoRTLImageView) findViewById(2131363770);
        this.h = (DmtTextView) findViewById(2131388772);
        this.i = (FrameLayout) findViewById(2131393139);
        this.j = (DmtStatusView) findViewById(2131387318);
        this.l = findViewById(2131388817);
        AppCompatImageView r0 = this.g;
        if (r0 == null) goto L5;
        r0.setOnClickListener(new b(this));
    L5:
        AppCompatTextView r1 = this.h;
        if (r1 == null) goto L9;
        r1.setText("举报");
    L9:
        final DmtStatusView r2 = this.j;
        if (r2 == null) goto L12;
        DmtStatusView.a r3 = DmtStatusView.a.a(getContext());
        AosDefaultNetErrorView r4 = U90(r2);
        r4.findViewById(2131384465).setOnClickListener(new c(r2, this));
        r4.c();
        r3.d(r4);
        r2.setBuilder(r3);
        r2.c();
        r2.e();
    L12:
        Bundle r5 = getArguments();
        if (r5 == null) goto L16;
        String r6 = r5.getString("authorOpenId");
        if (r6 == null) goto L16;
    L17:
        Bundle r7 = getArguments();
        if (r7 == null) goto L20;
        int r8 = r7.getInt("reportType", 0);
    L21:
        Bundle r9 = getArguments();
        if (r9 == null) goto L27;
        String r10 = r9.getString("objectId");
        if (r10 == null) goto L27;
        String r11 = r10;
    L28:
        Bundle r12 = getArguments();
        if (r12 == null) goto L34;
        String r13 = r12.getString("enterFrom");
        if (r13 == null) goto L34;
        String r14 = r13;
    L35:
        Bundle r15 = getArguments();
        if (r15 == null) goto L41;
        String r16 = r15.getString("hostEnterFrom");
        if (r16 == null) goto L41;
        String r17 = r16;
    L42:
        Bundle r18 = getArguments();
        if (r18 == null) goto L45;
        int r19 = r18.getInt("awemeType", 0);
    L46:
        d14.a r20 = b14.a.a;
        f34.b r21 = b14.a.a(f34.b.class);
        FragmentActivity r110 = requireActivity();
        if (r8 != 101) goto L49;
        int r111 = 285;
    L50:
        d r112 = new d(this, r8, r14, r17, r6, r11, r19);
        com.bytedance.awemeopen.appserviceimpl.report.a r22 = r21.i0(r110, r111, r11, r6, r14, r112);
        this.k = r22;
        if (r22 == null) goto L58;
        View r23 = r22.a;
        if (r23 == null) goto L59;
        FrameLayout r24 = this.i;
        if (r24 == null) goto L60;
        r24.addView(r23, new ViewGroup.LayoutParams(-1, -1));
        return;
    L60:
        return;
    L59:
        return;
    L58:
        return;
    L49:
        r111 = r8;
        goto L50
    L45:
        r19 = 0;
    L41:
        r17 = "";
    L34:
        r14 = "";
    L27:
        r11 = "";
        goto L28
    L20:
        r8 = 0;
    L16:
        r6 = "";
        goto L17
    }
}
