package com.larus.community.impl.component;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.larus.community.impl.databinding.LarusCommunityCreationFeedComponentLayoutBinding;
import com.larus.community.impl.databinding.LarusCommunityCreationFeedComponentLayoutNoRefreshBinding;

/* JADX INFO: loaded from: classes27.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusCommunityCreationFeedComponentLayoutBinding f328957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LarusCommunityCreationFeedComponentLayoutNoRefreshBinding f328958b;

    public h0() {
    }

    public final RecyclerView a() {
        LarusCommunityCreationFeedComponentLayoutBinding r100 = this.f328957a;
        if (r100 == null) goto L6;
        RecyclerView r101 = r100.f329079b;
        if (r101 == null) goto L6;
        return r101;
    L6:
        LarusCommunityCreationFeedComponentLayoutNoRefreshBinding r102 = this.f328958b;
        if (r102 != null) goto L12;
        return null;
    L12:
        return r102.f329082b;
    }

    public final SwipeRefreshLayout b() {
        LarusCommunityCreationFeedComponentLayoutBinding r100 = this.f328957a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f329080c;
    }
}
