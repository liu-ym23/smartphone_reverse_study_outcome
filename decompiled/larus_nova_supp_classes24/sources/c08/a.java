package c08;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.larksuite.component.ui.list.iconitem.IconItemView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements b08.b<IconItemView, b> {
    public a() {
    }

    @Override // b08.b
    public final void unbind(View r3) {
        IconItemView r4 = (IconItemView) r3;
        Intrinsics.checkNotNullParameter(r4, "view");
        ImageView r0 = r4.b;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        TextView r1 = r4.c;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        TextView r5 = r4.e;
        if (r5 == null) goto L12;
        r5.setVisibility(8);
        return;
    }

    @Override // b08.b
    public final void bind(View r6, b r7) {
        IconItemView r8 = (IconItemView) r6;
        b r9 = r7;
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "model");
        ImageView r0 = r8.b;
        r0.setVisibility(8);
        TextView r2 = r8.c;
        r2.setVisibility(8);
        TextView r3 = r8.e;
        r3.setVisibility(8);
        Drawable r1 = r9.a;
        if (r1 == null) goto L5;
        r0.setImageDrawable(r1);
        r0.setVisibility(0);
    L5:
        String r4 = r9.b;
        if (r4 == null) goto L8;
        r2.setText(r4);
        r2.setVisibility(0);
    L8:
        String r5 = r9.c;
        if (r5 == null) goto L11;
        r3.setText(r5);
        r3.setVisibility(0);
    L11:
        Integer r10 = r9.d;
        if (r10 == null) goto L15;
        int r11 = r10.intValue();
        ViewGroup.LayoutParams r12 = r8.f.getLayoutParams();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        r13.setMarginStart(r11);
        r8.f.setLayoutParams(r13);
        r8.requestLayout();
        return;
    }
}
