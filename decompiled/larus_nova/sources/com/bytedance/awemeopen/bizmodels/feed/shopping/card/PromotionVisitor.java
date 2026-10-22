package com.bytedance.awemeopen.bizmodels.feed.shopping.card;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J%\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003R*\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/PromotionVisitor;", "Ljava/io/Serializable;", "", "Lt14/a;", "component1", "", "component2", "avatars", "count", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/List;", "getAvatars", "()Ljava/util/List;", "setAvatars", "(Ljava/util/List;)V", "J", "getCount", "()J", "setCount", "(J)V", "<init>", "(Ljava/util/List;J)V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class PromotionVisitor implements Serializable {

    @SerializedName("avatar")
    private List<? extends t14.a> avatars;

    @SerializedName("count")
    private long count;

    public PromotionVisitor() {
        this(null, 0, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromotionVisitor copy$default(PromotionVisitor r100, List r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.avatars;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.count;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<t14.a> component1() {
        return this.avatars;
    }

    public final long component2() {
        return this.count;
    }

    public final PromotionVisitor copy(List<? extends t14.a> r100, long r101) {
        return new PromotionVisitor(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PromotionVisitor) == true) goto L8;
        return false;
    L8:
        PromotionVisitor r101 = (PromotionVisitor) r100;
        if (Intrinsics.areEqual(this.avatars, r101.avatars) == true) goto L12;
        return false;
    L12:
        if (this.count == r101.count) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<? extends t14.a> r100 = this.avatars;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        long r102 = this.count;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PromotionVisitor(avatars=" + this.avatars + ", count=" + this.count + ')';
    }

    public final List<t14.a> getAvatars() {
        return this.avatars;
    }

    public final long getCount() {
        return this.count;
    }

    public final void setAvatars(List<? extends t14.a> r100) {
        this.avatars = r100;
    }

    public final void setCount(long r100) {
        this.count = r100;
    }

    public PromotionVisitor(List<? extends t14.a> r100, long r101) {
        this.avatars = r100;
        this.count = r101;
    }

    public /* synthetic */ PromotionVisitor(List r100, long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
