package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0015B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/action/Impression;", "", "componentId", "", "impressionList", "", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/action/Impression$ImpressionItem;", "(Ljava/lang/String;Ljava/util/List;)V", "getComponentId", "()Ljava/lang/String;", "getImpressionList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ImpressionItem", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Impression {

    @SerializedName("component_id")
    private final String componentId;

    @SerializedName("impression_list")
    private final List<ImpressionItem> impressionList;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/action/Impression$ImpressionItem;", "", "id", "", "type", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/String;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/action/Impression$ImpressionItem;", "equals", "", "other", "hashCode", "toString", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ImpressionItem {

        @SerializedName("id")
        private final String id;

        @SerializedName("type")
        private final Integer type;

        /* JADX WARN: Multi-variable type inference failed */
        public ImpressionItem() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ImpressionItem copy$default(ImpressionItem r0, String r1, Integer r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.id;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.type;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.id;
        }

        public final Integer component2() {
            return this.type;
        }

        public final ImpressionItem copy(String r2, Integer r3) {
            return new ImpressionItem(r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof ImpressionItem) == false) goto L10;
            ImpressionItem r4 = (ImpressionItem) r3;
            if (Intrinsics.areEqual(this.id, r4.id) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.type, r4.type) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r0 = this.id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.type;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "ImpressionItem(id=" + this.id + ", type=" + this.type + ")";
        }

        public final String getId() {
            return this.id;
        }

        public final Integer getType() {
            return this.type;
        }

        public ImpressionItem(String r1, Integer r2) {
            this.id = r1;
            this.type = r2;
        }

        public /* synthetic */ ImpressionItem(String r2, Integer r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Impression() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Impression copy$default(Impression r0, String r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.componentId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.impressionList;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.componentId;
    }

    public final List<ImpressionItem> component2() {
        return this.impressionList;
    }

    public final Impression copy(String r2, List<ImpressionItem> r3) {
        return new Impression(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof Impression) == false) goto L10;
        Impression r4 = (Impression) r3;
        if (Intrinsics.areEqual(this.componentId, r4.componentId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.impressionList, r4.impressionList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.componentId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<ImpressionItem> r4 = this.impressionList;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "Impression(componentId=" + this.componentId + ", impressionList=" + this.impressionList + ")";
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public final List<ImpressionItem> getImpressionList() {
        return this.impressionList;
    }

    public Impression(String r1, List<ImpressionItem> r2) {
        this.componentId = r1;
        this.impressionList = r2;
    }

    public /* synthetic */ Impression(String r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
