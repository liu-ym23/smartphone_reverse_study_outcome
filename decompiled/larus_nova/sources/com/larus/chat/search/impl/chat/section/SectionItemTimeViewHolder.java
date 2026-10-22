package com.larus.chat.search.impl.chat.section;

import com.larus.chat.search.api.model.SectionItemData;
import com.larus.chat.search.api.model.SectionViewType;
import com.larus.chat.search.impl.databinding.LarusItemSearchSectionTimeBinding;
import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.utils.o0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lz8.b;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u000fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/chat/search/impl/chat/section/SectionItemTimeViewHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "Lcom/larus/chat/search/impl/chat/section/ISectionItemViewHolder;", "viewBing", "Lcom/larus/chat/search/impl/databinding/LarusItemSearchSectionTimeBinding;", "<init>", "(Lcom/larus/chat/search/impl/databinding/LarusItemSearchSectionTimeBinding;)V", "bindData", "", "data", "Lcom/larus/chat/search/api/model/SectionItemData;", "listener", "Lcom/larus/chat/search/impl/chat/section/ISectionItemListener;", "getRootView", "Landroid/view/View;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SectionItemTimeViewHolder extends ViewBindingHolder implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f325543b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusItemSearchSectionTimeBinding f325544a;

    public static final class a {
    }

    static {
    }

    public SectionItemTimeViewHolder(LarusItemSearchSectionTimeBinding r100) {
        Intrinsics.checkNotNullParameter(r100, "viewBing");
        super(r100);
        this.f325544a = r100;
    }

    @Override // lz8.b
    public final void C1(SectionItemData r100, lz8.a r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "listener");
        if (r100.getViewType() == SectionViewType.TIME) goto L5;
        return;
    L5:
        String r102 = r100.getSectionName();
        if (o0.d(r102) == false) goto L9;
        this.f325544a.f325583b.setText(r102);
        return;
    }
}
