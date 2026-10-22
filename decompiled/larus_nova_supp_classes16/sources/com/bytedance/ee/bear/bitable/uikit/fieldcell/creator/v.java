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
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class v extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<StageModel> {
    public View e;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[StageType.values().length];
            r0[StageType.EndDone.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[StageType.EndCancel.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[StageType.Default.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r8, Outline r9) {
            Intrinsics.checkNotNullParameter(r8, "view");
            Intrinsics.checkNotNullParameter(r9, "outline");
            r9.setRoundRect(0, 0, r8.getWidth(), r8.getHeight(), y9c.d.a(4));
        }
    }

    public void h(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.STAGE.getValue();
    }

    public v(iv4.b r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void g(List<StageModel> r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        View r2 = this.e;
        if (r2 == null) goto L15;
        i(r2, (StageModel) ListProtector.get(r3, 0));
        return;
    L15:
        return;
    L5:
        if (r3.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View b(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        View r4 = c(r2, r3);
        this.e = r4;
        h(r4);
        return r4;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public View c(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        int r0 = ht4.b.a;
        getType();
        View r5 = LayoutInflater.from(r3).inflate(2131558895, r4, false);
        r5.setOutlineProvider(new b());
        r5.setClipToOutline(true);
        TextView r6 = (TextView) r5.findViewById(2131390975);
        iv4.b r1 = this.a;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r6);
        r1.a(r6);
    L5:
        return r5;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public /* bridge */ /* synthetic */ void f(View r1, h0 r2) {
        i(r1, (StageModel) r2);
    }

    public void i(View r5, StageModel r6) {
        Intrinsics.checkNotNullParameter(r5, "kitView");
        Intrinsics.checkNotNullParameter(r6, "model");
        TextView r0 = (TextView) r5.findViewById(2131390975);
        AppCompatImageView r1 = r5.findViewById(2131374753);
        RingView r2 = r5.findViewById(2131374791);
        r5.setBackgroundColor(ColorUtils.h(r6.getCapsuleColor()));
        if (r0 == null) goto L5;
        r0.setText(r6.getText());
    L5:
        String r7 = r6.getTextColor();
        if (r7 == null) goto L9;
        if (r0 == null) goto L9;
        r0.setTextColor(ColorUtils.h(r7));
    L9:
        StageType.a r8 = StageType.Companion;
        String r9 = r6.getType();
        r8.getClass();
        StageType r10 = StageType.a.a(r9);
        int r11 = a.a[r10.ordinal()];
        if (r11 != 1) goto L12;
        if (r1 == null) goto L29;
        r1.setVisibility(0);
    L29:
        if (r2 == null) goto L36;
        r2.setVisibility(8);
        return;
    L36:
        return;
    L12:
        if (r11 != 2) goto L14;
        if (r1 == null) goto L23;
        r1.setVisibility(8);
    L23:
        if (r2 == null) goto L25;
        r2.setVisibility(0);
    L25:
        if (r2 == null) goto L34;
        r2.setVisibility(0);
        r2.a(ContextCompat.getColor(r2.getContext(), 2131108785), ContextCompat.getColor(r2.getContext(), 2131108778));
        return;
    L34:
        return;
    L14:
        if (r11 != 3) goto L20;
        if (r1 == null) goto L17;
        r1.setVisibility(8);
    L17:
        if (r2 == null) goto L32;
        r2.setVisibility(0);
        r2.a(ContextCompat.getColor(r2.getContext(), 2131108751), ContextCompat.getColor(r2.getContext(), 2131108749));
        return;
    L32:
        return;
    L20:
        throw new NoWhenBranchMatchedException();
    }
}
