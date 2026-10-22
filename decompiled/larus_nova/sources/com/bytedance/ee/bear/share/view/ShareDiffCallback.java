package com.bytedance.ee.bear.share.view;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.share.newshare.d0;
import com.bytedance.ee.bear.share.newshare.e0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/share/view/ShareDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "olds", "Lcom/bytedance/ee/bear/share/newshare/ShareUIList;", "news", "<init>", "(Lcom/bytedance/ee/bear/share/newshare/ShareUIList;Lcom/bytedance/ee/bear/share/newshare/ShareUIList;)V", "getNews", "()Lcom/bytedance/ee/bear/share/newshare/ShareUIList;", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "", "Companion", "features-share-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareDiffCallback extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f237271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f237272b;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return this.f237272b.f237207b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        return this.f237271a.f237207b.size();
    }

    public ShareDiffCallback(d0 r100, d0 r101) {
        Intrinsics.checkNotNullParameter(r100, "olds");
        Intrinsics.checkNotNullParameter(r101, "news");
        this.f237271a = r100;
        this.f237272b = r101;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        e0 r102 = this.f237271a.a(r100);
        e0 r103 = this.f237272b.a(r101);
        if (Intrinsics.areEqual(r102.getClass(), r103.getClass()) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r102, r103) == false) goto L8;
    L9:
        return true;
    L8:
        if (r102.d(r103) == true) goto L9;
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        return Intrinsics.areEqual(this.f237271a.a(r100).f237211a, this.f237272b.a(r101).f237211a);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final Object getChangePayload(int r100, int r101) {
        return 0;
    }
}
