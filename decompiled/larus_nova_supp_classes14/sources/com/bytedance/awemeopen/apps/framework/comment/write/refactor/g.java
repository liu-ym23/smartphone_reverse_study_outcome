package com.bytedance.awemeopen.apps.framework.comment.write.refactor;

import android.content.Context;
import com.bytedance.awemeopen.apps.framework.comment.api.statistics.CommentMobParameters;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g extends wy3.a {
    public boolean g;
    public boolean h;
    public fz3.a i;
    public String j;
    public CommentMobParameters k;
    public String l;
    public final int m;
    public int n;
    public bz3.b o;
    public com.bytedance.awemeopen.apps.framework.comment.write.h p;
    public com.bytedance.awemeopen.apps.framework.comment.write.j q;
    public com.bytedance.awemeopen.apps.framework.comment.write.i r;

    public g(Context r2, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r3) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "pageOwner");
        super(r2, r3);
        this.l = "";
        int r4 = com.bytedance.awemeopen.apps.framework.comment.write.utils.b.a;
        this.m = 100;
    }
}
