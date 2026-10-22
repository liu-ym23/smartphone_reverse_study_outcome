package com.bytedance.ee.bear.more.view3;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.more.protocol3.i;
import com.bytedance.ee.bear.more.protocol3.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/more/view3/MoreDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "olds", "Lcom/bytedance/ee/bear/more/protocol3/MoreUIList;", "news", "<init>", "(Lcom/bytedance/ee/bear/more/protocol3/MoreUIList;Lcom/bytedance/ee/bear/more/protocol3/MoreUIList;)V", "getOlds", "()Lcom/bytedance/ee/bear/more/protocol3/MoreUIList;", "getNews", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "", "Companion", "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoreDiffCallback extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f235012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f235013b;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return this.f235013b.f234895a.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        return this.f235012a.f234895a.size();
    }

    public MoreDiffCallback(i r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "olds");
        Intrinsics.checkNotNullParameter(r101, "news");
        this.f235012a = r100;
        this.f235013b = r101;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        k r102 = this.f235012a.a(r100);
        k r103 = this.f235013b.a(r101);
        if (Intrinsics.areEqual(r102.getClass(), r103.getClass()) == true) goto L5;
        return false;
    L5:
        if (r102 != r103) goto L7;
    L8:
        return true;
    L7:
        if (r102.f(r103) == true) goto L8;
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        return Intrinsics.areEqual(this.f235012a.a(r100).f234901a, this.f235013b.a(r101).f234901a);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final Object getChangePayload(int r100, int r101) {
        return 0;
    }
}
