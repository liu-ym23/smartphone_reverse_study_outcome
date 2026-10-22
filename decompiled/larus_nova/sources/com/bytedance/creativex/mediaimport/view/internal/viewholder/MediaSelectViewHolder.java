package com.bytedance.creativex.mediaimport.view.internal.viewholder;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaViewHolder;
import com.bytedance.creativex.mediaimport.view.internal.base.s0;
import com.larus.nova.R;
import ki4.r;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ti4.w;
import zi4.b;
import zi4.c;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#BÉ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012K\u0010\u0006\u001aG\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u0007\u0012K\u0010\u0010\u001aG\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u0007\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J \u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u001bH\u0014J\u0016\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0014R\u0014\u0010\u0016\u001a\u00020\u0013X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R)\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d¨\u0006$"}, d2 = {"Lcom/bytedance/creativex/mediaimport/view/internal/viewholder/MediaSelectViewHolder;", "Lcom/bytedance/creativex/mediaimport/view/internal/base/BaseMediaViewHolder;", "Lcom/bytedance/creativex/mediaimport/repository/api/IMaterialItem;", "itemView", "Landroid/view/View;", "selectorView", "clickListener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "data", "", "position", "Lcom/bytedance/creativex/mediaimport/view/internal/MaterialSelectedState;", "state", "", "selectorClickListener", "viewHolderConfigureBuilder", "Lkotlin/Function1;", "Lcom/bytedance/creativex/mediaimport/view/internal/viewholder/MediaSelectViewHolder$ViewConfigure;", "<init>", "(Landroid/view/View;Landroid/view/View;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;)V", "viewConfigure", "getViewConfigure", "()Lcom/bytedance/creativex/mediaimport/view/internal/viewholder/MediaSelectViewHolder$ViewConfigure;", "holderBindHandler", "Lcom/bytedance/creativex/mediaimport/view/internal/IMediaViewHolderBindController;", "Lcom/bytedance/creativex/mediaimport/view/internal/base/BaseMediaViewHolder$State;", "getHolderBindHandler", "()Lcom/bytedance/creativex/mediaimport/view/internal/IMediaViewHolderBindController;", "holderBindHandler$delegate", "Lkotlin/Lazy;", "bindDataAndState", "mediaData", "provideBindHandler", "ViewConfigure", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class MediaSelectViewHolder extends BaseMediaViewHolder<r> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f204102h = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f204103f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f204104g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f204105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bitmap.Config f204106b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f204107c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f204108d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImageView.ScaleType f204109e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f204110f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Function2<? super Integer, ? super Integer, Pair<Integer, Integer>> f204111g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f204112h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f204113i;

        public a() {
            this(null);
        }

        public a(Object r100) {
            Bitmap.Config r101 = Bitmap.Config.RGB_565;
            ImageView.ScaleType r102 = ImageView.ScaleType.CENTER_CROP;
            zi4.a r103 = b.f572243a;
            Intrinsics.checkNotNullParameter(r101, "bitmapConfig");
            Intrinsics.checkNotNullParameter(r102, "scaleType");
            Intrinsics.checkNotNullParameter(r103, "resizer");
            this.f204105a = true;
            this.f204106b = r101;
            this.f204107c = R.drawable.larus_tools_media_import_bg_thumbnail_place_holder;
            this.f204108d = 10;
            this.f204109e = r102;
            this.f204110f = false;
            this.f204111g = r103;
            this.f204112h = false;
            this.f204113i = true;
        }
    }

    @Override // com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaViewHolder
    public final void T3(Object r100, int r101, BaseMediaViewHolder.a.C2957a r102) {
        r r103 = (r) r100;
        Intrinsics.checkNotNullParameter(r103, "mediaData");
        Intrinsics.checkNotNullParameter(r102, "state");
        ViewCompat.setAccessibilityDelegate(this.itemView, new MediaSelectViewHolder$bindDataAndState$1());
        w r104 = (w) this.f204104g.getValue();
        if (r104 == null) goto L6;
        r104.c(r103, r101, r102);
        return;
    }

    public MediaSelectViewHolder(View r100, View r101, Function3 r102, s0 r103, Function1 r104) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "selectorView");
        Intrinsics.checkNotNullParameter(r102, "clickListener");
        Intrinsics.checkNotNullParameter(r103, "selectorClickListener");
        super(r100, r101, r102, r103);
        a r105 = new a(null);
        this.f204103f = r105;
        if (r104 == null) goto L5;
        r104.invoke(r105);
    L5:
        this.f204104g = LazyKt.lazy(new c(this));
    }
}
