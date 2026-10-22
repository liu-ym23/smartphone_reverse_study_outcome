package com.bytedance.android.shopping.commentv3.uitree.list.rvkit;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.commentv3.view.CommentSliceView;
import com.bytedance.android.shopping.commentv3.view.FilterCardSliceView;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final ConcurrentHashMap<String, Integer> a = null;
    public static int b;
    public static int c;

    static {
        a = new ConcurrentHashMap();
        b = 4;
        c = 1;
    }

    public static CommentSliceView a(int r4, ViewGroup r5) {
        if (r4 == 1001) goto L5;
        CommentSliceView r6 = new CommentSliceView(r5.getContext(), null, 6, 0);
    L6:
        r6.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return r6;
    L5:
        r6 = new FilterCardSliceView(r5.getContext(), null, 6, 0);
        goto L6
    }
}
