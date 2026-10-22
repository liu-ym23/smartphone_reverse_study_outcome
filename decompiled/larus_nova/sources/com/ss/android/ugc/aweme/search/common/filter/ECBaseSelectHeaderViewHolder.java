package com.ss.android.ugc.aweme.search.common.filter;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.ss.android.ugc.aweme.discover.commodity.stickyheaders.StickyHeader;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/filter/ECBaseSelectHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/ugc/aweme/discover/commodity/stickyheaders/StickyHeader;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECBaseSelectHeaderViewHolder<T extends RecyclerView.ViewHolder> extends RecyclerView.ViewHolder implements StickyHeader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f451593b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f451594a;

    public abstract T T3();

    public View U3() {
        return null;
    }

    public View V3() {
        return null;
    }

    @Override // com.ss.android.ugc.aweme.discover.commodity.stickyheaders.StickyHeader
    public void V0(final RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f451594a = true;
        new WeakReference(r100);
        this.itemView.addOnAttachStateChangeListener(new ECBaseSelectHeaderViewHolder$createAsStickyHeader$1(this, r100));
    }
}
