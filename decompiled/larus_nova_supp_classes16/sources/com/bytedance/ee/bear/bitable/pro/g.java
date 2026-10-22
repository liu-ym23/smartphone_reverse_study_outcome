package com.bytedance.ee.bear.bitable.pro;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.bitable.pro.accessconfig.DefaultAccessConfig;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements BitableProViewModel.d {
    public final /* synthetic */ BitableProFragment a;

    public static final class a implements BitableProViewModel.a {
        public final /* synthetic */ BitableProFragment a;
        public final /* synthetic */ DefaultConfig b;

        @Override // com.bytedance.ee.bear.bitable.pro.BitableProViewModel.a
        public final void success() {
            UDLoadingDrawable r0 = this.a.K;
            if (r0 == null) goto L5;
            r0.stop();
        L5:
            this.a.ba0().setVisibility(8);
            this.a.da0().setVisibility(0);
            BitableProFragment.Y90(this.a, 2131887971, 2131256306);
            BitableProViewModel r1 = this.a.D;
            BitableProViewModel r3 = null;
            if (r1 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r1 = null;
        L8:
            r1.setSelectRoleName(null);
            BitableProViewModel r2 = this.a.D;
            if (r2 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r2 = null;
        L11:
            DefaultAccessConfig r4 = (DefaultAccessConfig) r2.getDefaultAccessConfig().getValue();
            if (r4 == null) goto L18;
            DefaultConfig r5 = r4.getDefaultConfig();
            if (r5 == null) goto L18;
            Role r6 = r5.getBindRole();
            if (r6 == null) goto L18;
            r6.setIsDefaultRole(false);
        L18:
            Role r7 = this.b.getBindRole();
            if (r7 == null) goto L21;
            r7.setIsDefaultRole(true);
        L21:
            if (r4 == null) goto L23;
            r4.setDefaultConfig(this.b);
        L23:
            BitableProViewModel r8 = this.a.D;
            if (r8 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L27:
            r3.updateCurrentDefaultConfig(r4);
            return;
        L26:
            r3 = r8;
            goto L27
        }

        @Override // com.bytedance.ee.bear.bitable.pro.BitableProViewModel.a
        public final void a(int r3) {
            UDLoadingDrawable r4 = this.a.K;
            if (r4 == null) goto L5;
            r4.stop();
        L5:
            this.a.ba0().setVisibility(8);
            this.a.da0().setVisibility(0);
            BitableProFragment.Y90(this.a, 2131886373, 2131255144);
            BitableProViewModel r5 = this.a.D;
            if (r5 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r5 = null;
        L8:
            r5.fetchProData();
        }

        public a(BitableProFragment r1, DefaultConfig r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public g(BitableProFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.bitable.pro.BitableProViewModel.d
    public final void a(DefaultConfig r8) {
        Intrinsics.checkNotNullParameter(r8, "strategy");
        int r0 = d.a;
        if (r8.getAccessStrategy() != 1) goto L5;
        boolean r1 = true;
    L6:
        Boolean r2 = Boolean.valueOf(r1);
        JSONObject r3 = new JSONObject();
        if (r2 == null) goto L9;
        r3.put("is_visit_allow", r2.toString());
    L9:
        r3.put("click", "role_distribution_by_default");
        d.b("ccm_bitable_premium_permission_setting_click", r3);
        this.a.ba0().setVisibility(0);
        BitableProFragment r4 = this.a;
        BitableProViewModel r5 = null;
        if (r4.K != null) goto L16;
        Context r6 = r4.getContext();
        if (r6 == null) goto L14;
        UDLoadingDrawable r7 = new UDLoadingDrawable(r6);
        r7.setColorSchemeColors(new int[]{UDColorUtils.getColor(r6, 2131106616)});
        r7.setStrokeWidth(h18.d.a(r6, 1.5f));
        r7.setCenterRadius(h18.d.a(r6, 4.5f));
    L15:
        r4.K = r7;
        goto L16
    L14:
        r7 = null;
    L16:
        View r9 = r4.q;
        if (r9 != null) goto L23;
        View r10 = r4.getView();
        if (r10 == null) goto L21;
        r9 = r10.findViewById(2131379040);
    L22:
        r4.q = (AppCompatImageView) r9;
        goto L23
    L21:
        r9 = null;
    L23:
        ((AppCompatImageView) r9).setImageDrawable(r4.K);
        UDLoadingDrawable r11 = r4.K;
        if (r11 == null) goto L26;
        r11.start();
    L26:
        this.a.da0().setVisibility(8);
        BitableProViewModel r12 = this.a.D;
        if (r12 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L30:
        r5.updateDefaultConfig(r8, new a(this.a, r8));
        return;
    L29:
        r5 = r12;
        goto L30
    L5:
        r1 = false;
        goto L6
    }
}
