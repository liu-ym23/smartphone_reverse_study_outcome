package com.bytedance.awemeopen.apps.photo.presenter;

import android.widget.LinearLayout;
import com.bytedance.awemeopen.apps.framework.feed.follow.util.DuxTextView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k extends f04.a<Unit> {
    public final a14.a d;
    public final LinearLayout e;
    public final DuxTextView f;
    public final DuxTextView g;

    @Override // f04.a
    public final void k() {
    }

    public k(a14.a r2) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        super(r2.b);
        this.d = r2;
        this.e = (LinearLayout) i(2131378642);
        this.f = (DuxTextView) i(2131390345);
        this.g = (DuxTextView) i(2131374284);
    }

    @Override // f04.a
    public final void j(Unit r2) {
        Intrinsics.checkNotNullParameter(r2, "unit");
        this.e.setOnClickListener(new i(this));
        this.d.c.observeCommentCount(new j(this));
    }
}
