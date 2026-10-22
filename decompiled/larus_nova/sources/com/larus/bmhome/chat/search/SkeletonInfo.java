package com.larus.bmhome.chat.search;

import com.larus.im.bean.message.ItemData;
import com.larus.im.bean.message.ItemType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/search/SkeletonInfo;", "Lcom/larus/im/bean/message/ItemData;", "itemId", "", "<init>", "(Ljava/lang/String;)V", "getItemId", "()Ljava/lang/String;", "getId", "searchItemType", "Lcom/larus/im/bean/message/ItemType;", "getSearchItemType", "()Lcom/larus/im/bean/message/ItemType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SkeletonInfo extends ItemData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient ItemType f308602a;
    private final String itemId;

    /* JADX WARN: Multi-variable type inference failed */
    public SkeletonInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SkeletonInfo copy$default(SkeletonInfo r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.itemId;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.itemId;
    }

    public final SkeletonInfo copy(String r100) {
        return new SkeletonInfo(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SkeletonInfo) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.itemId, ((SkeletonInfo) r100).itemId) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r100 = this.itemId;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "SkeletonInfo(itemId=" + this.itemId + ')';
    }

    @Override // com.larus.im.bean.message.ItemData
    public String getId() {
        return this.itemId;
    }

    public final String getItemId() {
        return this.itemId;
    }

    @Override // com.larus.im.bean.message.ItemData
    public ItemType getSearchItemType() {
        return this.f308602a;
    }

    public SkeletonInfo(String r100) {
        this.itemId = r100;
        this.f308602a = ItemType.TYPE_CARD_SKELETON;
    }

    public /* synthetic */ SkeletonInfo(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
