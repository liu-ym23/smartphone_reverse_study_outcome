package com.ss.android.lark.reaction.widget.detailwindow.pager;

import android.content.Context;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f439260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReactionListAdapter.a f439261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f439262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IRequestCreator f439263d;

    public c(Context r100, ReactionListAdapter.a r101) {
        this.f439260a = r100;
        this.f439261b = r101;
        this.f439262c = v2c.a.a(r100, 48.0f);
        this.f439263d = ImageLoader.with(r100);
    }
}
