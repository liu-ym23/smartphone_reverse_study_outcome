package com.bytedance.ee.bear.wikiv2.wikitreev2.create;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f241400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f241401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f241402c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f241403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f241404b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f241405c;

        public a(b r100, View.OnClickListener r101, View.OnClickListener r102) {
            this.f241403a = r100;
            this.f241404b = r101;
            this.f241405c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f241403a.f241402c == false) goto L5;
            this.f241404b.onClick(r100);
            return;
        L5:
            View.OnClickListener r101 = this.f241405c;
            if (r101 == null) goto L10;
            r101.onClick(r100);
            return;
        }
    }

    public b(LifecycleOwner r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "view");
        this.f241400a = r100;
        this.f241401b = r101;
        this.f241402c = true;
        com.bytedance.ee.bear.contract.j.a.f217090a.a().observe(r100, new com.bytedance.ee.bear.wikiv2.wikitreev2.create.a(this));
    }

    public final void a(View.OnClickListener r100, View.OnClickListener r101) {
        Intrinsics.checkNotNullParameter(r100, "clickListener");
        this.f241401b.setOnClickListener(new a(this, r100, r101));
    }
}
