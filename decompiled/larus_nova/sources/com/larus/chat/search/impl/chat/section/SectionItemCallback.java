package com.larus.chat.search.impl.chat.section;

import androidx.recyclerview.widget.DiffUtil;
import com.larus.chat.search.api.model.SectionItemData;
import com.larus.chat.search.api.model.SectionViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/chat/search/impl/chat/section/SectionItemCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/larus/chat/search/api/model/SectionItemData;", "<init>", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SectionItemCallback extends DiffUtil.ItemCallback<SectionItemData> {
    public SectionItemCallback() {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(SectionItemData r100, SectionItemData r101) {
        SectionItemData r102 = r100;
        SectionItemData r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        if (r102.getCreateTime() == r103.getCreateTime()) goto L5;
    L23:
        return false;
    L5:
        if (Intrinsics.areEqual(r102.getSectionId(), r103.getSectionId()) == false) goto L23;
        if (Intrinsics.areEqual(r102.getConversationId(), r103.getConversationId()) == false) goto L23;
        if (Intrinsics.areEqual(r102.getSectionName(), r103.getSectionName()) == false) goto L23;
        if (r102.getViewType() != r103.getViewType()) goto L23;
        if (r102.getLocalIndex() != r103.getLocalIndex()) goto L23;
        if (Intrinsics.areEqual(r102.getMessageId(), r103.getMessageId()) == false) goto L23;
        if (r102.isSectionName() != r103.isSectionName()) goto L23;
        if (Intrinsics.areEqual(r102.getUrl(), r103.getUrl()) == false) goto L23;
        if (r102.getUnreadCount() != r103.getUnreadCount()) goto L23;
        return true;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(SectionItemData r100, SectionItemData r101) {
        SectionItemData r102 = r100;
        SectionItemData r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        if (r102.getViewType() == r103.getViewType()) goto L6;
        return false;
    L6:
        if (r102.getViewType() == SectionViewType.TIME) goto L63;
        String r104 = r102.getConversationId();
        if (r104 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == true) goto L25;
        String r106 = r103.getConversationId();
        if (r106 != null) goto L19;
    L22:
        boolean r107 = true;
    L23:
        if (r107 == true) goto L25;
        return Intrinsics.areEqual(r102.getConversationId(), r103.getConversationId());
    L19:
        if (r106.length() == 0) goto L22;
        r107 = false;
    L25:
        String r108 = r102.getMessageId();
        if (r108 != null) goto L28;
    L31:
        boolean r109 = true;
    L32:
        if (r109 == true) goto L42;
        String r110 = r103.getMessageId();
        if (r110 != null) goto L36;
    L39:
        boolean r111 = true;
    L40:
        if (r111 == true) goto L42;
        return Intrinsics.areEqual(r102.getMessageId(), r103.getMessageId());
    L36:
        if (r110.length() == 0) goto L39;
        r111 = false;
    L42:
        String r112 = r102.getSectionId();
        if (r112 != null) goto L45;
    L48:
        boolean r113 = true;
    L49:
        if (r113 == true) goto L60;
        String r114 = r103.getSectionId();
        if (r114 != null) goto L53;
    L56:
        boolean r115 = true;
    L57:
        if (r115 == true) goto L60;
        return Intrinsics.areEqual(r102.getSectionId(), r103.getSectionId());
    L53:
        if (r114.length() == 0) goto L56;
        r115 = false;
    L60:
        if (r102.getCreateTime() != r103.getCreateTime()) goto L67;
        return true;
    L67:
        return false;
    L45:
        if (r112.length() == 0) goto L48;
        r113 = false;
        goto L49
    L28:
        if (r108.length() == 0) goto L31;
        r109 = false;
        goto L32
    L11:
        if (r104.length() == 0) goto L14;
        r105 = false;
        goto L15
    L63:
        return Intrinsics.areEqual(r102.getSectionId(), r103.getSectionId());
    }
}
