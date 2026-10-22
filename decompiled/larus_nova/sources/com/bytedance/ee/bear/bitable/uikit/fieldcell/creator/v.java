package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.graphics.Outline;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.bitable.card.model.stmodel.field.StageType;
import com.bytedance.ee.bear.bitable.common.model.field.NativeCell;
import com.bytedance.ee.bear.bitable.common.widgets.common.RingView;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.StageModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public class v extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<StageModel> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f216194e;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f216195a = null;

        static {
            int[] r100 = new int[StageType.values().length];
            r100[StageType.EndDone.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[StageType.EndCancel.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[StageType.Default.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f216195a = r100;
        }
    }

    public static final class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "outline");
            r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), y9c.d.a(4));
        }
    }

    public void h(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.STAGE.getValue();
    }

    public v(iv4.b r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void g(List<StageModel> r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        View r102 = this.f216194e;
        if (r102 == null) goto L15;
        i(r102, (StageModel) ListProtector.get(r100, 0));
        return;
    L15:
        return;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View b(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r102 = c(r100, r101);
        this.f216194e = r102;
        h(r102);
        return r102;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public View c(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = ht4.b.f487130a;
        getType();
        View r103 = LayoutInflater.from(r100).inflate(R.layout.bitable_card_view_stage_cell_layout, r101, false);
        r103.setOutlineProvider(new b());
        r103.setClipToOutline(true);
        TextView r104 = (TextView) r103.findViewById(R.id.tv_name);
        iv4.b r105 = this.f216158a;
        if (r105 == null) goto L5;
        Intrinsics.checkNotNull(r104);
        r105.a(r104);
    L5:
        return r103;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public /* bridge */ /* synthetic */ void f(View r100, h0 r101) {
        i(r100, (StageModel) r101);
    }

    public void i(View r100, StageModel r101) {
        Intrinsics.checkNotNullParameter(r100, "kitView");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        TextView r102 = (TextView) r100.findViewById(R.id.tv_name);
        AppCompatImageView r103 = (AppCompatImageView) r100.findViewById(R.id.icon_done);
        RingView r104 = (RingView) r100.findViewById(R.id.icon_ring);
        r100.setBackgroundColor(ColorUtils.h(r101.getCapsuleColor()));
        if (r102 == null) goto L5;
        r102.setText(r101.getText());
    L5:
        String r105 = r101.getTextColor();
        if (r105 == null) goto L9;
        if (r102 == null) goto L9;
        r102.setTextColor(ColorUtils.h(r105));
    L9:
        StageType.a r106 = StageType.Companion;
        String r107 = r101.getType();
        r106.getClass();
        StageType r108 = StageType.a.a(r107);
        int r109 = a.f216195a[r108.ordinal()];
        if (r109 != 1) goto L12;
        if (r103 == null) goto L29;
        r103.setVisibility(0);
    L29:
        if (r104 == null) goto L36;
        r104.setVisibility(8);
        return;
    L36:
        return;
    L12:
        if (r109 != 2) goto L14;
        if (r103 == null) goto L23;
        r103.setVisibility(8);
    L23:
        if (r104 == null) goto L25;
        r104.setVisibility(0);
    L25:
        if (r104 == null) goto L34;
        r104.setVisibility(0);
        r104.a(ContextCompat.getColor(r104.getContext(), R.color.ud_R500), ContextCompat.getColor(r104.getContext(), R.color.ud_R300));
        return;
    L34:
        return;
    L14:
        if (r109 != 3) goto L20;
        if (r103 == null) goto L17;
        r103.setVisibility(8);
    L17:
        if (r104 == null) goto L32;
        r104.setVisibility(0);
        r104.a(ContextCompat.getColor(r104.getContext(), R.color.ud_O350), ContextCompat.getColor(r104.getContext(), R.color.ud_O200));
        return;
    L32:
        return;
    L20:
        throw new NoWhenBranchMatchedException();
    }
}
