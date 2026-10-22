package com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit;

import android.graphics.drawable.StateListDrawable;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c {
    public static final void a(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setBackground(AppCompatResources.getDrawable(r100.getContext(), R.drawable.bitable_form_submit_bg_disabled));
        r100.setTextColor(ContextCompat.getColor(r100.getContext(), R.color.primary_on_primary_fill));
    }

    public static final void b(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        StateListDrawable r101 = new StateListDrawable();
        r101.addState(new int[]{android.R.attr.state_pressed}, AppCompatResources.getDrawable(r100.getContext(), R.drawable.bitable_form_submit_bg_press));
        r101.addState(new int[0], AppCompatResources.getDrawable(r100.getContext(), R.drawable.bitable_form_submit_bg_enabled));
        r100.setBackground(r101);
        r100.setTextColor(ContextCompat.getColor(r100.getContext(), R.color.primary_on_primary_fill));
    }
}
