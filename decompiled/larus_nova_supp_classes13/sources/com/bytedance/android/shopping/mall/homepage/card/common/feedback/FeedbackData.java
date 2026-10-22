package com.bytedance.android.shopping.mall.homepage.card.common.feedback;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001:\u0003\u0014\u0015\u0016B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData;", "", "negFeedbackStyles", "Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackStyles;", "successMsg", "", "(Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackStyles;Ljava/lang/String;)V", "getNegFeedbackStyles", "()Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackStyles;", "getSuccessMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Item", "NegFeedbackElement", "NegFeedbackStyles", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedbackData {

    @SerializedName("neg_feedback_styles")
    private final NegFeedbackStyles negFeedbackStyles;

    @SerializedName("success_msg")
    private final String successMsg;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$Item;", "", "text", "", "icon", "type", "", "abbr", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getAbbr", "()Ljava/lang/String;", "getIcon", "getText", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$Item;", "equals", "", "other", "hashCode", "toString", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Item {

        @SerializedName("abbr")
        private final String abbr;

        @SerializedName("icon")
        private final String icon;

        @SerializedName("text")
        private final String text;

        @SerializedName("type")
        private final Integer type;

        public Item() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ Item copy$default(Item r0, String r1, String r2, Integer r3, String r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.text;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.icon;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.type;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.abbr;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final String component1() {
            return this.text;
        }

        public final String component2() {
            return this.icon;
        }

        public final Integer component3() {
            return this.type;
        }

        public final String component4() {
            return this.abbr;
        }

        public final Item copy(String r2, String r3, Integer r4, String r5) {
            return new Item(r2, r3, r4, r5);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof Item) == false) goto L14;
            Item r4 = (Item) r3;
            if (Intrinsics.areEqual(this.text, r4.text) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.icon, r4.icon) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.type, r4.type) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.abbr, r4.abbr) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            String r0 = this.text;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.icon;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.type;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.abbr;
            if (r10 == null) goto L18;
            r1 = r10.hashCode();
        L18:
            return r9 + r1;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "Item(text=" + this.text + ", icon=" + this.icon + ", type=" + this.type + ", abbr=" + this.abbr + ")";
        }

        public final String getAbbr() {
            return this.abbr;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final String getText() {
            return this.text;
        }

        public final Integer getType() {
            return this.type;
        }

        public Item(String r1, String r2, Integer r3, String r4) {
            this.text = r1;
            this.icon = r2;
            this.type = r3;
            this.abbr = r4;
        }

        public /* synthetic */ Item(String r2, String r3, Integer r4, String r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = null;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = null;
        L14:
            this(r2, r3, r4, r5);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ.\u0010\u000f\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackElement;", "", "items", "", "Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$Item;", "firstPageLimit", "", "(Ljava/util/List;Ljava/lang/Integer;)V", "getFirstPageLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getItems", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackElement;", "equals", "", "other", "hashCode", "toString", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class NegFeedbackElement {

        @SerializedName("first_page_limit")
        private final Integer firstPageLimit;

        @SerializedName("items")
        private final List<Item> items;

        /* JADX WARN: Multi-variable type inference failed */
        public NegFeedbackElement() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ NegFeedbackElement copy$default(NegFeedbackElement r0, List r1, Integer r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.items;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.firstPageLimit;
        L9:
            return r0.copy(r1, r2);
        }

        public final List<Item> component1() {
            return this.items;
        }

        public final Integer component2() {
            return this.firstPageLimit;
        }

        public final NegFeedbackElement copy(List<Item> r2, Integer r3) {
            return new NegFeedbackElement(r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof NegFeedbackElement) == false) goto L10;
            NegFeedbackElement r4 = (NegFeedbackElement) r3;
            if (Intrinsics.areEqual(this.items, r4.items) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.firstPageLimit, r4.firstPageLimit) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            List<Item> r0 = this.items;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.firstPageLimit;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "NegFeedbackElement(items=" + this.items + ", firstPageLimit=" + this.firstPageLimit + ")";
        }

        public final Integer getFirstPageLimit() {
            return this.firstPageLimit;
        }

        public final List<Item> getItems() {
            return this.items;
        }

        public NegFeedbackElement(List<Item> r1, Integer r2) {
            this.items = r1;
            this.firstPageLimit = r2;
        }

        public /* synthetic */ NegFeedbackElement(List r2, Integer r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackStyles;", "", "type1", "Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackElement;", "type2", "type4", "type7", "(Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackElement;Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackElement;Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackElement;Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackElement;)V", "getType1", "()Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackElement;", "getType2", "getType4", "getType7", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class NegFeedbackStyles {

        @SerializedName("1")
        private final NegFeedbackElement type1;

        @SerializedName("2")
        private final NegFeedbackElement type2;

        @SerializedName("4")
        private final NegFeedbackElement type4;

        @SerializedName("7")
        private final NegFeedbackElement type7;

        public NegFeedbackStyles() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ NegFeedbackStyles copy$default(NegFeedbackStyles r0, NegFeedbackElement r1, NegFeedbackElement r2, NegFeedbackElement r3, NegFeedbackElement r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.type1;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.type2;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.type4;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.type7;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final NegFeedbackElement component1() {
            return this.type1;
        }

        public final NegFeedbackElement component2() {
            return this.type2;
        }

        public final NegFeedbackElement component3() {
            return this.type4;
        }

        public final NegFeedbackElement component4() {
            return this.type7;
        }

        public final NegFeedbackStyles copy(NegFeedbackElement r2, NegFeedbackElement r3, NegFeedbackElement r4, NegFeedbackElement r5) {
            return new NegFeedbackStyles(r2, r3, r4, r5);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof NegFeedbackStyles) == false) goto L14;
            NegFeedbackStyles r4 = (NegFeedbackStyles) r3;
            if (Intrinsics.areEqual(this.type1, r4.type1) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.type2, r4.type2) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.type4, r4.type4) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.type7, r4.type7) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            NegFeedbackElement r0 = this.type1;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            NegFeedbackElement r4 = this.type2;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            NegFeedbackElement r7 = this.type4;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            NegFeedbackElement r10 = this.type7;
            if (r10 == null) goto L18;
            r1 = r10.hashCode();
        L18:
            return r9 + r1;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "NegFeedbackStyles(type1=" + this.type1 + ", type2=" + this.type2 + ", type4=" + this.type4 + ", type7=" + this.type7 + ")";
        }

        public final NegFeedbackElement getType1() {
            return this.type1;
        }

        public final NegFeedbackElement getType2() {
            return this.type2;
        }

        public final NegFeedbackElement getType4() {
            return this.type4;
        }

        public final NegFeedbackElement getType7() {
            return this.type7;
        }

        public NegFeedbackStyles(NegFeedbackElement r1, NegFeedbackElement r2, NegFeedbackElement r3, NegFeedbackElement r4) {
            this.type1 = r1;
            this.type2 = r2;
            this.type4 = r3;
            this.type7 = r4;
        }

        public /* synthetic */ NegFeedbackStyles(NegFeedbackElement r2, NegFeedbackElement r3, NegFeedbackElement r4, NegFeedbackElement r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = null;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = null;
        L14:
            this(r2, r3, r4, r5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeedbackData() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ FeedbackData copy$default(FeedbackData r0, NegFeedbackStyles r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.negFeedbackStyles;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.successMsg;
    L9:
        return r0.copy(r1, r2);
    }

    public final NegFeedbackStyles component1() {
        return this.negFeedbackStyles;
    }

    public final String component2() {
        return this.successMsg;
    }

    public final FeedbackData copy(NegFeedbackStyles r2, String r3) {
        return new FeedbackData(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof FeedbackData) == false) goto L10;
        FeedbackData r4 = (FeedbackData) r3;
        if (Intrinsics.areEqual(this.negFeedbackStyles, r4.negFeedbackStyles) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.successMsg, r4.successMsg) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        NegFeedbackStyles r0 = this.negFeedbackStyles;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.successMsg;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "FeedbackData(negFeedbackStyles=" + this.negFeedbackStyles + ", successMsg=" + this.successMsg + ")";
    }

    public final NegFeedbackStyles getNegFeedbackStyles() {
        return this.negFeedbackStyles;
    }

    public final String getSuccessMsg() {
        return this.successMsg;
    }

    public FeedbackData(NegFeedbackStyles r1, String r2) {
        this.negFeedbackStyles = r1;
        this.successMsg = r2;
    }

    public /* synthetic */ FeedbackData(NegFeedbackStyles r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
