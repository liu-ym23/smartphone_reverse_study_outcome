package com.larus.im.bean.message;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Transient;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/larus/im/bean/message/ItemData;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "<init>", "()V", "getId", "", "searchItemType", "Lcom/larus/im/bean/message/ItemType;", "getSearchItemType", "()Lcom/larus/im/bean/message/ItemType;", "itemShowType", "Lcom/larus/im/bean/message/ItemShowType;", "getItemShowType", "()Lcom/larus/im/bean/message/ItemShowType;", "setItemShowType", "(Lcom/larus/im/bean/message/ItemShowType;)V", "searchId", "getSearchId$annotations", "getSearchId", "()Ljava/lang/String;", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ItemData implements Serializable {
    private ItemShowType itemShowType;
    private final transient String searchId;

    @Transient
    public static /* synthetic */ void getSearchId$annotations() {
    }

    public abstract String getId();

    public abstract ItemType getSearchItemType();

    public ItemData() {
        this.itemShowType = ItemShowType.ITEM_SHOW_TYPE_NONE;
    }

    public final ItemShowType getItemShowType() {
        return this.itemShowType;
    }

    public String getSearchId() {
        return this.searchId;
    }

    public final void setItemShowType(ItemShowType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.itemShowType = r100;
    }
}
