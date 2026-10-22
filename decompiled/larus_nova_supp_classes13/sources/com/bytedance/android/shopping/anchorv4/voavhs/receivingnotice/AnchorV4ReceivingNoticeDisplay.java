package com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice;

import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/receivingnotice/AnchorV4ReceivingNoticeDisplay;", "Ljava/io/Serializable;", "title", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "tabs", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/receivingnotice/AnchorV4Tab;", "(Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Ljava/util/List;)V", "getTabs", "()Ljava/util/List;", "getTitle", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ReceivingNoticeDisplay implements Serializable {

    @SerializedName("tabs")
    private final List<AnchorV4Tab> tabs;

    @SerializedName("title")
    private final LongContentLabelComponent title;

    public AnchorV4ReceivingNoticeDisplay() {
        LongContentLabelComponent r0 = null;
        this(r0, r0, 3, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4ReceivingNoticeDisplay copy$default(AnchorV4ReceivingNoticeDisplay r0, LongContentLabelComponent r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.title;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.tabs;
    L9:
        return r0.copy(r1, r2);
    }

    public final LongContentLabelComponent component1() {
        return this.title;
    }

    public final List<AnchorV4Tab> component2() {
        return this.tabs;
    }

    public final AnchorV4ReceivingNoticeDisplay copy(LongContentLabelComponent r2, List<AnchorV4Tab> r3) {
        return new AnchorV4ReceivingNoticeDisplay(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnchorV4ReceivingNoticeDisplay) == false) goto L10;
        AnchorV4ReceivingNoticeDisplay r4 = (AnchorV4ReceivingNoticeDisplay) r3;
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.tabs, r4.tabs) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        LongContentLabelComponent r0 = this.title;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<AnchorV4Tab> r4 = this.tabs;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4ReceivingNoticeDisplay(title=" + this.title + ", tabs=" + this.tabs + ")";
    }

    public final List<AnchorV4Tab> getTabs() {
        return this.tabs;
    }

    public final LongContentLabelComponent getTitle() {
        return this.title;
    }

    public AnchorV4ReceivingNoticeDisplay(LongContentLabelComponent r1, List<AnchorV4Tab> r2) {
        this.title = r1;
        this.tabs = r2;
    }

    public /* synthetic */ AnchorV4ReceivingNoticeDisplay(LongContentLabelComponent r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
