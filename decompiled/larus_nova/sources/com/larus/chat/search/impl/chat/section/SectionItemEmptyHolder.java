package com.larus.chat.search.impl.chat.section;

import com.larus.chat.search.api.model.SectionItemData;
import com.larus.chat.search.impl.databinding.LarusItemSearchSectionEmptyBinding;
import com.larus.common_ui.view.ViewBindingHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lz8.b;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u000fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/chat/search/impl/chat/section/SectionItemEmptyHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "Lcom/larus/chat/search/impl/chat/section/ISectionItemViewHolder;", "viewBing", "Lcom/larus/chat/search/impl/databinding/LarusItemSearchSectionEmptyBinding;", "<init>", "(Lcom/larus/chat/search/impl/databinding/LarusItemSearchSectionEmptyBinding;)V", "bindData", "", "data", "Lcom/larus/chat/search/api/model/SectionItemData;", "listener", "Lcom/larus/chat/search/impl/chat/section/ISectionItemListener;", "getRootView", "Landroid/view/View;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SectionItemEmptyHolder extends ViewBindingHolder implements b {

    public static final class a {
    }

    static {
    }

    @Override // lz8.b
    public final void C1(SectionItemData r100, lz8.a r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "listener");
    }

    public SectionItemEmptyHolder(LarusItemSearchSectionEmptyBinding r100) {
        Intrinsics.checkNotNullParameter(r100, "viewBing");
        super(r100);
    }
}
