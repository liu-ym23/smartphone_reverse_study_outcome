package com.ss.android.lark.integrator.im.impl;

import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements ceb.a {
    @Override // ceb.a
    public final void c() {
    }

    @Override // ceb.a
    public final FeedFolder a() {
        return FeedFolderCompat.INSTANCE.getMESSAGE();
    }

    @Override // ceb.a
    public final MutableLiveData b() {
        return new MutableLiveData();
    }

    public g() {
    }
}
