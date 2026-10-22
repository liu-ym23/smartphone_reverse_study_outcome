package com.bytedance.ee.bear.wikiv2.wikitreev2.create;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final LifecycleOwner a;
    public final View b;
    public boolean c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ b a;
        public final /* synthetic */ View.OnClickListener b;
        public final /* synthetic */ View.OnClickListener c;

        public a(b r1, View.OnClickListener r2, View.OnClickListener r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (this.a.c == false) goto L5;
            this.b.onClick(r2);
            return;
        L5:
            View.OnClickListener r0 = this.c;
            if (r0 == null) goto L10;
            r0.onClick(r2);
            return;
        }
    }

    public b(LifecycleOwner r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "view");
        this.a = r2;
        this.b = r3;
        this.c = true;
        com.bytedance.ee.bear.contract.j.a.a.a().observe(r2, new com.bytedance.ee.bear.wikiv2.wikitreev2.create.a(this));
    }

    public final void a(View.OnClickListener r3, View.OnClickListener r4) {
        Intrinsics.checkNotNullParameter(r3, "clickListener");
        this.b.setOnClickListener(new a(this, r3, r4));
    }
}
