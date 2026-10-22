package com.larus.video.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.nova.R;
import com.larus.platform.api.IVideoController;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.video.impl.widget.VideoView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l2a.e;
import l2a.q;
import l2a.r;
import l2a.t;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B?\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005H\u0016J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005H\u0016J\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J&\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020&2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0002H\u0016J\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0002H\u0016J\u0018\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020&H\u0016J\b\u0010/\u001a\u00020&H\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0015j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u0001`\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00060"}, d2 = {"Lcom/larus/video/impl/VideoDetailAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/video/impl/TikTokVideoViewHolder;", "recyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView;", "mCommonVideoModel", "Lcom/larus/flow/video/bean/CommonVideoModel;", "itemListener", "Lcom/larus/video/impl/ITikTokItemListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "videoController", "Lcom/larus/platform/api/IVideoController;", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/larus/flow/video/bean/CommonVideoModel;Lcom/larus/video/impl/ITikTokItemListener;Landroid/content/Context;Lcom/larus/platform/api/IVideoController;)V", "getItemListener", "()Lcom/larus/video/impl/ITikTokItemListener;", "getContext", "()Landroid/content/Context;", "mItems", "Ljava/util/ArrayList;", "Lcom/larus/platform/uimodel/MediaEntity;", "Lkotlin/collections/ArrayList;", "afterClickCallBack", "Lcom/larus/video/impl/widget/VideoView$AfterClickCallBack;", "getAfterClickCallBack", "()Lcom/larus/video/impl/widget/VideoView$AfterClickCallBack;", "setAfterClickCallBack", "(Lcom/larus/video/impl/widget/VideoView$AfterClickCallBack;)V", "onAttachedToRecyclerView", "", "recyclerView", "onDetachedFromRecyclerView", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "payloads", "", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "getItemCount", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoDetailAdapter extends RecyclerView.Adapter<TikTokVideoViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<RecyclerView> f375679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CommonVideoModel f375680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f375681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f375682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IVideoController f375683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<MediaEntity> f375684f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public VideoView.a f375685g;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        ArrayList<MediaEntity> r100 = this.f375684f;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L13;
        ArrayList<MediaEntity> r102 = this.f375684f;
        Intrinsics.checkNotNull(r102);
        return r102.size();
    L13:
        return 0;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public final Context getContext() {
        return this.f375682d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onDetachedFromRecyclerView(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        TikTokVideoViewHolder r101 = (TikTokVideoViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewAttachedToWindow(r101);
        r101.getClass();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        TikTokVideoViewHolder r101 = (TikTokVideoViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewDetachedFromWindow(r101);
        r101.getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [l2a.q] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        TikTokVideoViewHolder r102 = (TikTokVideoViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        ArrayList<MediaEntity> r103 = this.f375684f;
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L13;
        ArrayList<MediaEntity> r105 = this.f375684f;
        Intrinsics.checkNotNull(r105);
        r102.V3((MediaEntity) ListProtector.get(r105, r101), r101, this.f375681c, new q(this));
        return;
    L13:
        return;
    L5:
        if (r103.isEmpty() == true) goto L8;
        r104 = false;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_tiktok_detail_item, null, false);
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        VideoView r103 = (VideoView) r102.findViewById(R.id.video_view);
        if (r103 == null) goto L5;
        r103.setAfterClickCallBack(new t(this));
    L5:
        if (r103 == null) goto L7;
        r103.setDataChange(new r(this));
    L7:
        Intrinsics.checkNotNull(r102);
        return new TikTokVideoViewHolder(r102, this.f375680b, this.f375683e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        TikTokVideoViewHolder r103 = (TikTokVideoViewHolder) r100;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if (r102.isEmpty() == false) goto L5;
        super.onBindViewHolder(r103, r101, r102);
        return;
    L5:
        Object r104 = ListProtector.get(r102, 0);
        if ((r104 instanceof MediaEntity) == false) goto L8;
        MediaEntity r105 = (MediaEntity) r104;
    L9:
        if (r105 == null) goto L13;
        r103.f375982c = r105;
        return;
    L13:
        return;
    L8:
        r105 = null;
        goto L9
    }

    public VideoDetailAdapter(WeakReference<RecyclerView> r100, CommonVideoModel r101, e r102, Context r103, IVideoController r104) {
        Intrinsics.checkNotNullParameter(r100, "recyclerViewRef");
        this.f375679a = r100;
        this.f375680b = r101;
        this.f375681c = r102;
        this.f375682d = r103;
        this.f375683e = r104;
        this.f375684f = new ArrayList();
        if (r101 == null) goto L5;
        ArrayList<MediaEntity> r105 = r101.getItems();
    L6:
        this.f375684f = r105;
        return;
    L5:
        r105 = null;
        goto L6
    }
}
