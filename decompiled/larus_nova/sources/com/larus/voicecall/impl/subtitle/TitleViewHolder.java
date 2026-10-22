package com.larus.voicecall.impl.subtitle;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.voicecall.impl.databinding.LarusItemRecyclerSubtitleTitleBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/larus/voicecall/impl/subtitle/TitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/voicecall/impl/subtitle/TextViewHolder;", "binding", "Lcom/larus/voicecall/impl/databinding/LarusItemRecyclerSubtitleTitleBinding;", "<init>", "(Lcom/larus/voicecall/impl/databinding/LarusItemRecyclerSubtitleTitleBinding;)V", "getBinding", "()Lcom/larus/voicecall/impl/databinding/LarusItemRecyclerSubtitleTitleBinding;", "bindText", "", "data", "Lcom/larus/voicecall/impl/subtitle/DisplaySubtitleData;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TitleViewHolder extends RecyclerView.ViewHolder implements v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusItemRecyclerSubtitleTitleBinding f378840a;

    public TitleViewHolder(LarusItemRecyclerSubtitleTitleBinding r100) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        super(r100.f378245a);
        this.f378840a = r100;
    }

    @Override // com.larus.voicecall.impl.subtitle.v1
    public final void K3(c r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f378840a.f378246b.setText(r100.f378854a);
    }
}
