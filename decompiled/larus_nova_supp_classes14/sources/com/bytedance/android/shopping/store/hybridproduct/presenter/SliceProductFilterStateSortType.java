package com.bytedance.android.shopping.store.hybridproduct.presenter;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0006\u0010\u000e\"\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0014R\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/presenter/SliceProductFilterStateSortType;", "Ljava/io/Serializable;", "id", "", "name", "", "isCurrent", "", "canReverse", "sortOrder", "", "showBadge", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getCanReverse", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "setCurrent", "(Ljava/lang/Boolean;)V", "getName", "()Ljava/lang/String;", "getShowBadge", "setShowBadge", "getSortOrder", "()Ljava/lang/Integer;", "setSortOrder", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SliceProductFilterStateSortType implements Serializable {

    @SerializedName("can_reverse")
    private final Boolean canReverse;

    @SerializedName("id")
    private final Long id;

    @SerializedName("is_current")
    private Boolean isCurrent;

    @SerializedName("name")
    private final String name;

    @SerializedName("show_badge")
    private Boolean showBadge;

    @SerializedName("sort_order")
    private Integer sortOrder;

    public final Boolean getCanReverse() {
        return this.canReverse;
    }

    public final Long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getShowBadge() {
        return this.showBadge;
    }

    public final Integer getSortOrder() {
        return this.sortOrder;
    }

    public final Boolean isCurrent() {
        return this.isCurrent;
    }

    public final void setCurrent(Boolean r1) {
        this.isCurrent = r1;
    }

    public final void setShowBadge(Boolean r1) {
        this.showBadge = r1;
    }

    public final void setSortOrder(Integer r1) {
        this.sortOrder = r1;
    }

    public SliceProductFilterStateSortType(Long r1, String r2, Boolean r3, Boolean r4, Integer r5, Boolean r6) {
        this.id = r1;
        this.name = r2;
        this.isCurrent = r3;
        this.canReverse = r4;
        this.sortOrder = r5;
        this.showBadge = r6;
    }
}
