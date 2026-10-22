package com.ss.android.lark.feed.shared.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;
import com.ss.android.lark.feed.shared.page.FeedRecyclerView;

/* JADX INFO: loaded from: classes35.dex */
public final class FragmentRefactorFeedListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f421175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FeedRecyclerView f421176b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f421175a;
    }

    public FragmentRefactorFeedListBinding(ConstraintLayout r100, FeedRecyclerView r101) {
        this.f421175a = r100;
        this.f421176b = r101;
    }

    public static FragmentRefactorFeedListBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.fragment_refactor_feed_list, r101, false);
        FeedRecyclerView r103 = (FeedRecyclerView) ViewBindings.findChildViewById(r102, R.id.rv_inbox);
        if (r103 == null) goto L7;
        return new FragmentRefactorFeedListBinding((ConstraintLayout) r102, r103);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(R.id.rv_inbox)));
    }
}
