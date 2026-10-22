package com.bytedance.ee.bear.more.view3.ui;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.component.universe_design.udswitch.UDSwitchWithLoading;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends com.bytedance.ee.bear.more.view3.ui.a {
    public final boolean n;
    public final boolean o;

    public static final class a implements UDSwitchWithLoading.b {
        public a() {
        }

        public final void a() {
        }
    }

    public static final class b implements UDSwitchWithLoading.b {
        public final /* synthetic */ UDSwitchWithLoading a;
        public final /* synthetic */ g b;
        public final /* synthetic */ View c;

        public final void a() {
            this.a.toggle();
            g r0 = this.b;
            com.bytedance.ee.bear.more.view3.ui.a.h(this.c, r0.h, r0.i, r0.j, null);
        }

        public b(UDSwitchWithLoading r1, g r2, View r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final int e() {
        return i(2131563682, 2131563683);
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final void a(View r5) {
        Intrinsics.checkNotNullParameter(r5, "itemView");
        super.a(r5);
        AppCompatImageView r0 = (AppCompatImageView) r5.findViewById(2131374718);
        TextView r1 = (TextView) r5.findViewById(2131388772);
        UDSwitchWithLoading r2 = r5.findViewById(2131387831);
        r2.setOnLoadingStatusChangeListener(new a());
        g(r0, r1, null);
        boolean r3 = r2.isChecked();
        boolean r4 = this.n;
        if (r3 == r4) goto L6;
        r2.setChecked(r4);
    L6:
        if (this.o == false) goto L8;
        r2.performClick();
    L9:
        r2.setEnabled(this.h);
        r2.setOnLoadingStatusChangeListener(new b(r2, this, r5));
        return;
    L8:
        r2.d(this.n);
        goto L9
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final boolean f(k r3) {
        Intrinsics.checkNotNullParameter(r3, "obj");
        if ((r3 instanceof g) == false) goto L21;
        g r4 = (g) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == false) goto L21;
        if (Intrinsics.areEqual(this.e, r4.e) == false) goto L21;
        if (this.f != r4.f) goto L21;
        if (this.g != r4.g) goto L21;
        if (this.n != r4.n) goto L21;
        if (this.h != r4.h) goto L21;
        if (Intrinsics.areEqual(this.i, r4.i) == false) goto L21;
        if (Intrinsics.areEqual(this.c, r4.c) == false) goto L21;
        return true;
    L21:
        return false;
    }

    public g(String r10, String r11, int r12, int r13, boolean r14, boolean r15, boolean r16, String r17, com.bytedance.ee.bear.more.view3.d.c r18) {
        Intrinsics.checkNotNullParameter(r10, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r11, "title");
        Intrinsics.checkNotNullParameter(r17, "disableReason");
        super(r10, r11, r12, r13, r16, r17, r18);
        this.n = r14;
        this.o = r15;
    }
}
