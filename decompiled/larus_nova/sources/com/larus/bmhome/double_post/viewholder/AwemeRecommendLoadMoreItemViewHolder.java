package com.larus.bmhome.double_post.viewholder;

import android.view.ViewGroup;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.bmhome.video.Content;
import com.larus.common_res.common_ui.databinding.LarusItemAwemeLoadMoreBinding;
import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.utils.e1;
import ip8.b;
import ip8.f;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import lp8.g;
import lp8.h;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/double_post/viewholder/AwemeRecommendLoadMoreItemViewHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "Lcom/larus/bmhome/double_post/viewholder/IAwemeRecommendViewHolder;", "viewBinding", "Lcom/larus/common_res/common_ui/databinding/LarusItemAwemeLoadMoreBinding;", "spaceHeight", "", "<init>", "(Lcom/larus/common_res/common_ui/databinding/LarusItemAwemeLoadMoreBinding;I)V", "status", "bindData", "", "data", "Lcom/larus/bmhome/video/Content;", "position", "dependency", "Lcom/larus/bmhome/double_post/adapter/IAwemeRecommendAdapterDependency;", "updateStatus", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AwemeRecommendLoadMoreItemViewHolder extends ViewBindingHolder implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f311647b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusItemAwemeLoadMoreBinding f311648a;

    public AwemeRecommendLoadMoreItemViewHolder(LarusItemAwemeLoadMoreBinding r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "viewBinding");
        super(r100);
        this.f311648a = r100;
        ViewGroup.LayoutParams r102 = r100.f326716a.getLayoutParams();
        if ((r102 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L5;
        StaggeredGridLayoutManager.LayoutParams r103 = (StaggeredGridLayoutManager.LayoutParams) r102;
    L6:
        if (r103 == null) goto L8;
        r103.setFullSpan(true);
        r100.f326716a.setLayoutParams(r103);
    L8:
        ViewGroup.LayoutParams r104 = r100.f326719d.getLayoutParams();
        if (r104 == null) goto L12;
        r104.height = r101;
        return;
    L12:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // lp8.h
    public final void n2(Content r100, f r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        Map<String, String> r103 = r100.getClientExt();     // Catch: Throwable -> L10
        if (r103 == null) goto L7;
        String r104 = r103.get("load_more_status");     // Catch: Throwable -> L10
        if (r104 == null) goto L7;
        Integer r105 = Integer.valueOf(CastIntegerProtector.parseInt(r104));     // Catch: Throwable -> L10
    L8:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L10
    L13:
        if (Result.m9455isFailureimpl(r106) == false) goto L15;
        r106 = 2;
    L15:
        Integer r107 = (Integer) r106;
        if (r107 == null) goto L18;
        int r108 = r107.intValue();
    L20:
        if (r108 == 1) goto L27;
        if (r108 != 2) goto L23;
        this.f311648a.f326718c.setVisibility(8);
        this.f311648a.f326717b.setVisibility(8);
    L28:
        final b r109 = (b) r101;
        e1.d(this.f311648a.f326717b, new g(r109));
        return;
    L23:
        if (r108 != 3) goto L28;
        this.f311648a.f326718c.setVisibility(0);
        this.f311648a.f326717b.setVisibility(8);
        goto L28
    L27:
        this.f311648a.f326718c.setVisibility(8);
        this.f311648a.f326717b.setVisibility(0);
        goto L28
    L18:
        r108 = 2;
    L7:
        r105 = null;
    L10:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }
}
