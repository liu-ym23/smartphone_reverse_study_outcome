package com.ss.android.lark.todo.impl.features.center.v3.tablayout;

import android.text.TextUtils;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f441756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f441757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f441758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f441759d;

    public static final class a {
    }

    static {
    }

    public c() {
        this.f441756a = UIHelper.dp2px(20.0f);
        this.f441757b = UIHelper.dp2px(2.0f);
    }

    public final FeedTabTextView a(FeedTabLayout r100, int r101) {
        FeedTabTextView r102 = new FeedTabTextView(r100.getContext(), null);
        r102.setId(r101);
        r102.setLayoutParams(new FeedTabLayout.LayoutParams());
        r102.setGravity(17);
        r102.setEllipsize(TextUtils.TruncateAt.END);
        int r103 = this.f441756a;
        r102.setPadding(r103, 0, r103, 0);
        r102.setSingleLine(true);
        return r102;
    }
}
