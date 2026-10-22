package com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice;

import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/receivingnotice/Group;", "Ljava/io/Serializable;", "groupName", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "groupTips", "", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Ljava/util/List;)V", "getGroupName", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getGroupTips", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Group implements Serializable {

    @SerializedName("group_name")
    private final TextElement groupName;

    @SerializedName("group_tips")
    private final List<LongContentLabelComponent> groupTips;

    public Group() {
        TextElement r0 = null;
        this(r0, r0, 3, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Group copy$default(Group r0, TextElement r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.groupName;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.groupTips;
    L9:
        return r0.copy(r1, r2);
    }

    public final TextElement component1() {
        return this.groupName;
    }

    public final List<LongContentLabelComponent> component2() {
        return this.groupTips;
    }

    public final Group copy(TextElement r2, List<? extends LongContentLabelComponent> r3) {
        return new Group(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof Group) == false) goto L10;
        Group r4 = (Group) r3;
        if (Intrinsics.areEqual(this.groupName, r4.groupName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.groupTips, r4.groupTips) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        TextElement r0 = this.groupName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<LongContentLabelComponent> r4 = this.groupTips;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "Group(groupName=" + this.groupName + ", groupTips=" + this.groupTips + ")";
    }

    public final TextElement getGroupName() {
        return this.groupName;
    }

    public final List<LongContentLabelComponent> getGroupTips() {
        return this.groupTips;
    }

    public Group(TextElement r1, List<? extends LongContentLabelComponent> r2) {
        this.groupName = r1;
        this.groupTips = r2;
    }

    public /* synthetic */ Group(TextElement r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
