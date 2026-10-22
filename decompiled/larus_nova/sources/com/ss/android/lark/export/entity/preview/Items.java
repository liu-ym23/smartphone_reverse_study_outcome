package com.ss.android.lark.export.entity.preview;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/Items;", "Ljava/io/Serializable;", "items", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/export/entity/preview/Item;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getItems", "()Ljava/util/ArrayList;", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Items implements Serializable {
    private final ArrayList<Item> items;

    public final ArrayList<Item> getItems() {
        return this.items;
    }

    public Items(ArrayList<Item> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.items = r100;
    }
}
