package com.bytedance.ee.bear.more.view3.ui;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.component.universe_design.switch.UDSwitch;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j extends com.bytedance.ee.bear.more.view3.ui.a {
    public final boolean n;
    public final String o;
    public final boolean p;

    public static final class a {
    }

    public static final class b implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ j a;
        public final /* synthetic */ View b;

        public b(j r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r4, boolean r5) {
            j r6 = this.a;
            com.bytedance.ee.bear.more.view3.ui.a.h(this.b, r6.h, r6.i, r6.j, null);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final int e() {
        return i(2131563688, 2131563689);
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final void a(View r14) {
        Intrinsics.checkNotNullParameter(r14, "itemView");
        super.a(r14);
        AppCompatImageView r0 = (AppCompatImageView) r14.findViewById(2131374718);
        TextView r1 = (TextView) r14.findViewById(2131388772);
        UDSwitch r2 = r14.findViewById(2131387831);
        String r3 = null;
        r2.setOnCheckedChangeListener(null);
        g(r0, r1, null);
        TextView r4 = (TextView) r14.findViewById(2131373298);
        if (r4 == null) goto L28;
        r4.setText(this.o);
        Object r5 = r4.getTag(2025031300);
        if (r5 != null) goto L8;
    L17:
        TextPaint r6 = r4.getPaint();
        CharSequence r7 = r4.getText();
        if (r7 == null) goto L20;
        r3 = r7.toString();
    L20:
        LinearGradient r8 = new LinearGradient(r6.measureText(r3), 0.0f, 0.0f, r4.getTextSize(), r4.getContext().getResources().getColor(2131108768), r4.getContext().getResources().getColor(2131108678), Shader.TileMode.CLAMP);
        r6.setShader(r8);
        r4.setTag(2025031300, r8);
        Unit r9 = Unit.INSTANCE;
    L22:
        if (this.h == true) goto L24;
    L26:
        int r10 = 8;
    L27:
        r4.setVisibility(r10);
        goto L28
    L24:
        if (this.n == false) goto L26;
        r10 = 0;
        goto L27
    L8:
        if ((r5 instanceof Shader) == true) goto L11;
        r5 = null;
    L11:
        if (r5 == null) goto L17;
        if ((r5 instanceof Shader) == false) goto L15;
        Shader r11 = (Shader) r5;
    L16:
        if (r11 != null) goto L22;
    L15:
        r11 = null;
    L28:
        r2.setEnabled(this.h);
        r2.setChecked(this.p);
        r2.setOnCheckedChangeListener(new b(this, r14));
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final boolean f(k r3) {
        Intrinsics.checkNotNullParameter(r3, "obj");
        if ((r3 instanceof j) == false) goto L23;
        j r4 = (j) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == false) goto L23;
        if (Intrinsics.areEqual(this.e, r4.e) == false) goto L23;
        if (this.f != r4.f) goto L23;
        if (this.g != r4.g) goto L23;
        if (this.n != r4.n) goto L23;
        if (this.p != r4.p) goto L23;
        if (this.h != r4.h) goto L23;
        if (Intrinsics.areEqual(this.i, r4.i) == false) goto L23;
        if (Intrinsics.areEqual(this.c, r4.c) == false) goto L23;
        return true;
    L23:
        return false;
    }

    public j(String r11, String r12, int r13, int r14, boolean r15, String r16, boolean r17, boolean r18, String r19, View.OnClickListener r20) {
        Intrinsics.checkNotNullParameter(r11, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r12, "title");
        Intrinsics.checkNotNullParameter(r16, "freeTrialTipText");
        Intrinsics.checkNotNullParameter(r19, "disableReason");
        super(r11, r12, r13, r14, r18, r19, r20);
        this.n = r15;
        this.o = r16;
        this.p = r17;
    }
}
