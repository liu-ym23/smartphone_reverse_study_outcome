package com.bytedance.android.shopping.commentfeed.view;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.widget.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends d {
    public final /* synthetic */ CommentDetailFragment g;

    public b(CommentDetailFragment r2) {
        this.g = r2;
        super(null, null, 3);
    }

    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        FragmentActivity r3 = this.g.getActivity();
        if (r3 == null) goto L6;
        r3.finish();
        return;
    }
}
