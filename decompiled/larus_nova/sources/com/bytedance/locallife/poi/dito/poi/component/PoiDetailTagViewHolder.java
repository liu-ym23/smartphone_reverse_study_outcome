package com.bytedance.locallife.poi.dito.poi.component;

import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.bytedance.dux.text.DuxTextView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/poi/dito/poi/component/PoiDetailTagViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiDetailTagViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DuxTextView f262453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LottieAnimationView f262454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f262455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f262456d;

    public static final class a<T> implements LottieListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiDetailTagViewHolder f262457a;

        public a(PoiDetailTagViewHolder r100) {
            this.f262457a = r100;
        }

        @Override // com.airbnb.lottie.LottieListener
        public final void onResult(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f262457a.f262454b.setVisibility(8);
        }
    }

    public PoiDetailTagViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f262453a = (DuxTextView) r100.findViewById(R.id.poi_detail_tag_text);
        this.f262454b = (LottieAnimationView) r100.findViewById(R.id.poi_detail_tag_lottie);
        this.f262455c = ContextCompat.getColor(r100.getContext(), R.color.POITextPrimary);
        this.f262456d = ContextCompat.getColor(r100.getContext(), R.color.POITextTertiary);
    }

    public final void T3(String r100) {
        this.f262454b.setVisibility(0);     // Catch: Exception -> L4
        this.f262454b.setAnimationFromUrl(r100);     // Catch: Exception -> L4
        this.f262454b.setFailureListener(new a(this));     // Catch: Exception -> L4
        this.f262454b.playAnimation();     // Catch: Exception -> L4
        this.f262454b.setRepeatMode(1);     // Catch: Exception -> L4
        this.f262454b.setRepeatCount(-1);     // Catch: Exception -> L4
        return;
    L4:
        this.f262454b.setVisibility(8);
    }
}
