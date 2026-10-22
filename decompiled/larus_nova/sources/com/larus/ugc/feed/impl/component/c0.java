package com.larus.ugc.feed.impl.component;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.larus.ugc.feed.impl.databinding.LarusCommunityCreationFeedComponentLayoutKmpBinding;
import com.larus.ugc.feed.impl.databinding.LarusCommunityCreationFeedComponentLayoutNoRefreshKmpBinding;

/* JADX INFO: loaded from: classes31.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusCommunityCreationFeedComponentLayoutKmpBinding f374690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LarusCommunityCreationFeedComponentLayoutNoRefreshKmpBinding f374691b;

    public c0() {
    }

    public final RecyclerView a() {
        LarusCommunityCreationFeedComponentLayoutKmpBinding r100 = this.f374690a;
        if (r100 == null) goto L6;
        RecyclerView r101 = r100.f374726b;
        if (r101 == null) goto L6;
        return r101;
    L6:
        LarusCommunityCreationFeedComponentLayoutNoRefreshKmpBinding r102 = this.f374691b;
        if (r102 != null) goto L12;
        return null;
    L12:
        return r102.f374729b;
    }

    public final SwipeRefreshLayout b() {
        LarusCommunityCreationFeedComponentLayoutKmpBinding r100 = this.f374690a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f374727c;
    }
}
