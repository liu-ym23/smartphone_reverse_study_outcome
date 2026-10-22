package com.bytedance.android.shopping.mall.feed.help;

import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h {
    public static final void a(HomePageDTO r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "$this$insertTitleSection");
        Intrinsics.checkNotNullParameter(r10, "title");
        if (r10.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return;
    L8:
        HomePageBffDTO r2 = r9.getBff();
        Object r4 = null;
        if (r2 == null) goto L13;
        ECHybridListDTO r3 = r2.getFeed();
        if (r3 == null) goto L13;
        List r5 = r3.getSections();
    L14:
        if (r5 == null) goto L31;
        Iterator r6 = r5.iterator();
    L17:
        if (r6.hasNext() == false) goto L21;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(((ECHybridListSectionDTO) r7).getSectionId(), "title") == false) goto L17;
        r4 = r7;
    L21:
        if (r4 != null) goto L32;
        HomePageBffDTO r11 = r9.getBff();
        if (r11 == null) goto L33;
        ECHybridListDTO r12 = r11.getFeed();
        if (r12 == null) goto L34;
        ECHybridListSectionDTO r8 = new ECHybridListSectionDTO();
        r8.setLayoutColumn(1);
        r8.setSectionId("title");
        ECHybridListItemDTO r13 = new ECHybridListItemDTO();
        r13.setItemType(Integer.valueOf(ECHybridListItemType.HYBRID_LIST_TITLE.getType()));
        JSONObject r14 = new JSONObject();
        r14.put("title", r10);
        Unit r15 = Unit.INSTANCE;
        r13.setItemData(r14.toString());
        r8.setItems(CollectionsKt.arrayListOf(new ECHybridListItemDTO[]{r13}));
        List r16 = CollectionsKt.mutableListOf(new ECHybridListSectionDTO[]{r8});
        r16.addAll(1, r5);
        r12.setSections(r16);
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L13:
        r5 = null;
        goto L14
    L5:
        r1 = false;
        goto L6
    }
}
