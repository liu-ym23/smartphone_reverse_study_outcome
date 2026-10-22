package com.bytedance.ee.bear.bitable.timezone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.bitable.TimeZoneItemV2;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.l;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ss.android.lark.utils.StatusBarUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sa5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZoneFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/IFullScreenPage;", "<init>", "()V", "mCcmLynxCardView", "Lcom/bytedance/ee/bear/lynx/api/CCMLynxCardView;", "backPressDispatcher", "Lcom/bytedance/ee/bear/facade/common/BackPressDispatcher;", "getViewModel", "Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZoneViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onBackPressed", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableTimeZoneFragment extends BaseFragment implements l {
    public CCMLynxCardView e;
    public sa5.b f;

    public static final class a {
    }

    public static final class b implements CCMLynxCardView.b {
        public final /* synthetic */ BitableTimeZoneFragment a;

        public final void onShow() {
        }

        public final void H() {
            BitableTimeZoneFragment r0 = this.a;
            r0.getClass();
            BitableTimeZonePlugin.b r1 = ((BitableTimeZoneViewModel) q.a(r0, BitableTimeZoneViewModel.class)).getPluginDelegate();
            if (r1 == null) goto L6;
            r1.d();
            return;
        }

        public b(BitableTimeZoneFragment r1) {
            this.a = r1;
        }

        public final void a(Map<String, String> r5) {
            String r0 = null;
            if (r5 == null) goto L5;
            String r1 = r5.get("type");
        L6:
            if (r5 == null) goto L8;
            r0 = r5.get("params");
        L8:
            if (r0 == null) goto L15;
            BitableTimeZoneFragment r6 = this.a;
            TimeZonePanelParams r2 = (TimeZonePanelParams) GsonProtectorUtils.fromJson(new Gson(), r0, TimeZonePanelParams.class);
            if (Intrinsics.areEqual("show", r1) == false) goto L16;
            r6.getClass();
            BitableTimeZonePlugin.b r7 = ((BitableTimeZoneViewModel) q.a(r6, BitableTimeZoneViewModel.class)).getPluginDelegate();
            if (r7 == null) goto L17;
            r7.e(r2.panelContentPageUrl, r2.data);
            return;
        L17:
            return;
        L16:
            return;
        L15:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        BitableTimeZonePlugin.b r0 = ((BitableTimeZoneViewModel) q.a(this, BitableTimeZoneViewModel.class)).getPluginDelegate();
        if (r0 == null) goto L7;
        r0.d();
        return true;
    L7:
        return true;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        sa5.b r0 = this.f;
        if (r0 == null) goto L6;
        r0.d(this);
        return;
    }

    public BitableTimeZoneFragment() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        CCMLynxCardView r5 = (CCMLynxCardView) org.koin.java.a.c(CCMLynxCardView.class, null, new AnonymousClass1(this), 2);
        r5.f(new b(this));
        this.e = r5;
        HashMap r6 = new HashMap();
        BitableTimeZonePlugin.b r0 = ((BitableTimeZoneViewModel) q.a(this, BitableTimeZoneViewModel.class)).getPluginDelegate();
        if (r0 == null) goto L6;
        r0.reportEvent("ccm_bitable_time_zone_setting_view", r6);
        return;
    }

    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        View r8 = r5.inflate(2131559171, r6, false);
        Bundle r9 = getArguments();
        HashMap r10 = new HashMap();
        if (r9 == null) goto L5;
        Object r2 = r9.get(TimeZoneItemV2.TIME_ZONE);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.String");
        r10.put(TimeZoneItemV2.TIME_ZONE, (String) r2);
        Object r11 = r9.get(TimeZoneItemV2.TIME_ZONE_ABBR);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.String");
        r10.put(TimeZoneItemV2.TIME_ZONE_ABBR, (String) r11);
    L5:
        CCMLynxCardView r12 = this.e;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mCcmLynxCardView");
        r12 = null;
    L8:
        CCMLynxCardView.a.a(r12, (ViewGroup) r8.findViewById(2131381866), 3, r10, new ViewGroup.LayoutParams(-1, -1));
        sa5.b r13 = (sa5.b) m.a.a(getActivity(), sa5.b.class);
        this.f = r13;
        if (r13 == null) goto L11;
        r13.e(this);
    L11:
        r8.setPadding(0, StatusBarUtil.getStatusBarHeight(getContext()), 0, 0);
        r8.setBackground(AppCompatResources.getDrawable(requireContext(), 2131100558));
        return r8;
    }
}
