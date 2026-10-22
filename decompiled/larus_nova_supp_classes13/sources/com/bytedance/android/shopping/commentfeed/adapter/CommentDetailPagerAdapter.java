package com.bytedance.android.shopping.commentfeed.adapter;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.bytedance.android.ec.model.response.PromotionProductCommentDTO;
import com.bytedance.android.shopping.commentfeed.view.CommentItemFragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/adapter/CommentDetailPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentDetailPagerAdapter extends FragmentPagerAdapter {
    public final List<PromotionProductCommentDTO> a;
    public final List<CommentItemFragment> b;
    public final FragmentManager c;

    public final int getCount() {
        return ((ArrayList) this.a).size();
    }

    public CommentDetailPagerAdapter(FragmentManager r2) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        super(r2);
        this.c = r2;
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public final Fragment getItem(int r2) {
        return (Fragment) ListProtector.get(this.b, r2);
    }

    public final Object instantiateItem(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Object r4 = super.instantiateItem(r2, r3);
        if (r4 == null) goto L7;
        Fragment r5 = (Fragment) r4;
        this.c.beginTransaction().show(r5).commitAllowingStateLoss();
        return r5;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.Fragment");
    }

    public final void destroyItem(ViewGroup r2, int r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r4, "object");
        Fragment r5 = (Fragment) ListProtector.get(this.b, r3);
        this.c.beginTransaction().hide(r5).commit();
    }
}
