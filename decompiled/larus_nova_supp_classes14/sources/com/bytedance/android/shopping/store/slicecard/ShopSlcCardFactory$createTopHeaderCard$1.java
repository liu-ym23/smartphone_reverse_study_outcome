package com.bytedance.android.shopping.store.slicecard;

import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplate;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/shopping/store/slicecard/dto/SliceTemplate;", "invoke"}, k = 3, mv = {1, 4, 3})
final class ShopSlcCardFactory$createTopHeaderCard$1 extends Lambda implements Function0<SliceTemplate> {
    final /* synthetic */ String $remoteTemplateName;

    public ShopSlcCardFactory$createTopHeaderCard$1(String r1) {
        this.$remoteTemplateName = r1;
        super(0);
    }

    public final SliceTemplate invoke() {
        com.bytedance.android.ec.store.setting.j r0 = ShopSlcTemplateManager.a;
        String r1 = this.$remoteTemplateName;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        Object r3 = null;
        if (r2 == true) goto L26;
        ShopSliceItemConfig r4 = ShopSlcTemplateManager.i.get(SliceItemType.SHOP_PROFILE_CONCISE.getType());
        if (r4 == null) goto L25;
        Iterator<T> r5 = r4.getTemplates().iterator();
    L16:
        if (r5.hasNext() == false) goto L21;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((SliceTemplate) r6).getName(), r1) == false) goto L16;
        r3 = r6;
    L21:
        return (SliceTemplate) r3;
    L25:
        return null;
    L26:
        return null;
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m410invoke() {
        return invoke();
    }
}
