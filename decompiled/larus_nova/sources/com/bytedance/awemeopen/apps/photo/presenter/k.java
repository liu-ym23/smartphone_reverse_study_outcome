package com.bytedance.awemeopen.apps.photo.presenter;

import android.widget.LinearLayout;
import com.bytedance.awemeopen.apps.framework.feed.follow.util.DuxTextView;
import com.bytedance.crash.dumper.Scraps;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class k extends f04.a<Unit> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a14.a f197983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f197984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DuxTextView f197985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DuxTextView f197986g;

    @Override // f04.a
    public final void k() {
    }

    public k(a14.a r100) {
        Intrinsics.checkNotNullParameter(r100, "pgParameters");
        super(r100.f1367b);
        this.f197983d = r100;
        this.f197984e = (LinearLayout) i(R.id.ll_comment);
        this.f197985f = (DuxTextView) i(R.id.tv_comment_count);
        this.f197986g = (DuxTextView) i(R.id.header_comment_count);
    }

    @Override // f04.a
    public final void j(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, Scraps.INNER_UNIT);
        this.f197984e.setOnClickListener(new i(this));
        this.f197983d.f1368c.observeCommentCount(new j(this));
    }
}
