package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001:\u0006,-./01Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jk\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00062"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle;", "", "pageStyle", "Lcom/bytedance/android/shopping/api/mall/model/SkinConfigPage;", "subTabStyle", "", "", "searchStyle", "Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$SearchStyle;", "toolListStyle", "Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$ToolListStyle;", "secKillChannelStyle", "Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$SecKillChannelStyle;", "dailyFloorChannelStyle", "Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$DailyFloorChannelStyle;", "cycleActivityStyle", "(Lcom/bytedance/android/shopping/api/mall/model/SkinConfigPage;Ljava/util/Map;Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$SearchStyle;Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$ToolListStyle;Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$SecKillChannelStyle;Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$DailyFloorChannelStyle;Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$DailyFloorChannelStyle;)V", "getCycleActivityStyle", "()Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$DailyFloorChannelStyle;", "getDailyFloorChannelStyle", "getPageStyle", "()Lcom/bytedance/android/shopping/api/mall/model/SkinConfigPage;", "getSearchStyle", "()Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$SearchStyle;", "getSecKillChannelStyle", "()Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$SecKillChannelStyle;", "getSubTabStyle", "()Ljava/util/Map;", "getToolListStyle", "()Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$ToolListStyle;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "BadgeStyle", "CycleActivityStyle", "DailyFloorChannelStyle", "SearchStyle", "SecKillChannelStyle", "ToolListStyle", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkinConfigStyle {

    @SerializedName("cycle_activity_style")
    private final DailyFloorChannelStyle cycleActivityStyle;

    @SerializedName("daily_floor_channel_style")
    private final DailyFloorChannelStyle dailyFloorChannelStyle;

    @SerializedName("page_style")
    private final SkinConfigPage pageStyle;

    @SerializedName("search_style")
    private final SearchStyle searchStyle;

    @SerializedName("sec_kill_channel_style")
    private final SecKillChannelStyle secKillChannelStyle;

    @SerializedName("sub_tab_style")
    private final Map<String, Object> subTabStyle;

    @SerializedName("tool_list_style")
    private final ToolListStyle toolListStyle;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$BadgeStyle;", "", "borderColor", "", "textColor", "bgColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBgColor", "()Ljava/lang/String;", "getBorderColor", "getTextColor", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class BadgeStyle {

        @SerializedName("bg_color")
        private final String bgColor;

        @SerializedName("border_color")
        private final String borderColor;

        @SerializedName("text_color")
        private final String textColor;

        public BadgeStyle() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ BadgeStyle copy$default(BadgeStyle r0, String r1, String r2, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.borderColor;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.textColor;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.bgColor;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final String component1() {
            return this.borderColor;
        }

        public final String component2() {
            return this.textColor;
        }

        public final String component3() {
            return this.bgColor;
        }

        public final BadgeStyle copy(String r2, String r3, String r4) {
            return new BadgeStyle(r2, r3, r4);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof BadgeStyle) == false) goto L12;
            BadgeStyle r4 = (BadgeStyle) r3;
            if (Intrinsics.areEqual(this.borderColor, r4.borderColor) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.textColor, r4.textColor) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.bgColor, r4.bgColor) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r0 = this.borderColor;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.textColor;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.bgColor;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            return r6 + r1;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "BadgeStyle(borderColor=" + this.borderColor + ", textColor=" + this.textColor + ", bgColor=" + this.bgColor + ")";
        }

        public final String getBgColor() {
            return this.bgColor;
        }

        public final String getBorderColor() {
            return this.borderColor;
        }

        public final String getTextColor() {
            return this.textColor;
        }

        public BadgeStyle(String r1, String r2, String r3) {
            this.borderColor = r1;
            this.textColor = r2;
            this.bgColor = r3;
        }

        public /* synthetic */ BadgeStyle(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = null;
        L11:
            this(r2, r3, r4);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$CycleActivityStyle;", "", "bgUrl", "", "(Ljava/lang/String;)V", "getBgUrl", "()Ljava/lang/String;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CycleActivityStyle {

        @SerializedName("bg_url")
        private final String bgUrl;

        public CycleActivityStyle() {
            String r0 = null;
            this(r0, 1, r0);
        }

        public final String getBgUrl() {
            return this.bgUrl;
        }

        public CycleActivityStyle(String r1) {
            this.bgUrl = r1;
        }

        public /* synthetic */ CycleActivityStyle(String r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$DailyFloorChannelStyle;", "", "bgUrl", "", "(Ljava/lang/String;)V", "getBgUrl", "()Ljava/lang/String;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DailyFloorChannelStyle {

        @SerializedName("bg_url")
        private final String bgUrl;

        public DailyFloorChannelStyle() {
            String r0 = null;
            this(r0, 1, r0);
        }

        public final String getBgUrl() {
            return this.bgUrl;
        }

        public DailyFloorChannelStyle(String r1) {
            this.bgUrl = r1;
        }

        public /* synthetic */ DailyFloorChannelStyle(String r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$SearchStyle;", "", "badgeStyle", "Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$BadgeStyle;", "(Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$BadgeStyle;)V", "getBadgeStyle", "()Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$BadgeStyle;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SearchStyle {

        @SerializedName("badge_style")
        private final BadgeStyle badgeStyle;

        public SearchStyle() {
            BadgeStyle r0 = null;
            this(r0, 1, r0);
        }

        public static /* synthetic */ SearchStyle copy$default(SearchStyle r0, BadgeStyle r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.badgeStyle;
        L6:
            return r0.copy(r1);
        }

        public final BadgeStyle component1() {
            return this.badgeStyle;
        }

        public final SearchStyle copy(BadgeStyle r2) {
            return new SearchStyle(r2);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof SearchStyle) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.badgeStyle, ((SearchStyle) r2).badgeStyle) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            BadgeStyle r0 = this.badgeStyle;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "SearchStyle(badgeStyle=" + this.badgeStyle + ")";
        }

        public final BadgeStyle getBadgeStyle() {
            return this.badgeStyle;
        }

        public SearchStyle(BadgeStyle r1) {
            this.badgeStyle = r1;
        }

        public /* synthetic */ SearchStyle(BadgeStyle r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$SecKillChannelStyle;", "", "bgUrl", "", "(Ljava/lang/String;)V", "getBgUrl", "()Ljava/lang/String;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SecKillChannelStyle {

        @SerializedName("bg_url")
        private final String bgUrl;

        public SecKillChannelStyle() {
            String r0 = null;
            this(r0, 1, r0);
        }

        public final String getBgUrl() {
            return this.bgUrl;
        }

        public SecKillChannelStyle(String r1) {
            this.bgUrl = r1;
        }

        public /* synthetic */ SecKillChannelStyle(String r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle$ToolListStyle;", "", "bg_color", "", "(Ljava/lang/String;)V", "getBg_color", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolListStyle {

        @SerializedName("bg_color")
        private final String bg_color;

        public ToolListStyle() {
            String r0 = null;
            this(r0, 1, r0);
        }

        public static /* synthetic */ ToolListStyle copy$default(ToolListStyle r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.bg_color;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.bg_color;
        }

        public final ToolListStyle copy(String r2) {
            return new ToolListStyle(r2);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof ToolListStyle) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.bg_color, ((ToolListStyle) r2).bg_color) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            String r0 = this.bg_color;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "ToolListStyle(bg_color=" + this.bg_color + ")";
        }

        public final String getBg_color() {
            return this.bg_color;
        }

        public ToolListStyle(String r1) {
            this.bg_color = r1;
        }

        public /* synthetic */ ToolListStyle(String r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    public SkinConfigStyle() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkinConfigStyle copy$default(SkinConfigStyle r5, SkinConfigPage r6, Map r7, SearchStyle r8, ToolListStyle r9, SecKillChannelStyle r10, DailyFloorChannelStyle r11, DailyFloorChannelStyle r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.pageStyle;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.subTabStyle;
    L8:
        Map r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.searchStyle;
    L11:
        SearchStyle r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.toolListStyle;
    L14:
        ToolListStyle r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.secKillChannelStyle;
    L17:
        SecKillChannelStyle r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.dailyFloorChannelStyle;
    L20:
        DailyFloorChannelStyle r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.cycleActivityStyle;
    L23:
        SkinConfigPage r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final SkinConfigPage component1() {
        return this.pageStyle;
    }

    public final Map<String, Object> component2() {
        return this.subTabStyle;
    }

    public final SearchStyle component3() {
        return this.searchStyle;
    }

    public final ToolListStyle component4() {
        return this.toolListStyle;
    }

    public final SecKillChannelStyle component5() {
        return this.secKillChannelStyle;
    }

    public final DailyFloorChannelStyle component6() {
        return this.dailyFloorChannelStyle;
    }

    public final DailyFloorChannelStyle component7() {
        return this.cycleActivityStyle;
    }

    public final SkinConfigStyle copy(SkinConfigPage r10, Map<String, ? extends Object> r11, SearchStyle r12, ToolListStyle r13, SecKillChannelStyle r14, DailyFloorChannelStyle r15, DailyFloorChannelStyle r16) {
        return new SkinConfigStyle(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SkinConfigStyle) == false) goto L20;
        SkinConfigStyle r4 = (SkinConfigStyle) r3;
        if (Intrinsics.areEqual(this.pageStyle, r4.pageStyle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.subTabStyle, r4.subTabStyle) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.searchStyle, r4.searchStyle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.toolListStyle, r4.toolListStyle) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.secKillChannelStyle, r4.secKillChannelStyle) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.dailyFloorChannelStyle, r4.dailyFloorChannelStyle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cycleActivityStyle, r4.cycleActivityStyle) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        SkinConfigPage r0 = this.pageStyle;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, Object> r4 = this.subTabStyle;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        SearchStyle r7 = this.searchStyle;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        ToolListStyle r10 = this.toolListStyle;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        SecKillChannelStyle r13 = this.secKillChannelStyle;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        DailyFloorChannelStyle r16 = this.dailyFloorChannelStyle;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        DailyFloorChannelStyle r19 = this.cycleActivityStyle;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
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
        return "SkinConfigStyle(pageStyle=" + this.pageStyle + ", subTabStyle=" + this.subTabStyle + ", searchStyle=" + this.searchStyle + ", toolListStyle=" + this.toolListStyle + ", secKillChannelStyle=" + this.secKillChannelStyle + ", dailyFloorChannelStyle=" + this.dailyFloorChannelStyle + ", cycleActivityStyle=" + this.cycleActivityStyle + ")";
    }

    public final DailyFloorChannelStyle getCycleActivityStyle() {
        return this.cycleActivityStyle;
    }

    public final DailyFloorChannelStyle getDailyFloorChannelStyle() {
        return this.dailyFloorChannelStyle;
    }

    public final SkinConfigPage getPageStyle() {
        return this.pageStyle;
    }

    public final SearchStyle getSearchStyle() {
        return this.searchStyle;
    }

    public final SecKillChannelStyle getSecKillChannelStyle() {
        return this.secKillChannelStyle;
    }

    public final Map<String, Object> getSubTabStyle() {
        return this.subTabStyle;
    }

    public final ToolListStyle getToolListStyle() {
        return this.toolListStyle;
    }

    public SkinConfigStyle(SkinConfigPage r1, Map<String, ? extends Object> r2, SearchStyle r3, ToolListStyle r4, SecKillChannelStyle r5, DailyFloorChannelStyle r6, DailyFloorChannelStyle r7) {
        this.pageStyle = r1;
        this.subTabStyle = r2;
        this.searchStyle = r3;
        this.toolListStyle = r4;
        this.secKillChannelStyle = r5;
        this.dailyFloorChannelStyle = r6;
        this.cycleActivityStyle = r7;
    }

    public /* synthetic */ SkinConfigStyle(SkinConfigPage r7, Map r8, SearchStyle r9, ToolListStyle r10, SecKillChannelStyle r11, DailyFloorChannelStyle r12, DailyFloorChannelStyle r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        SkinConfigPage r16 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        Map r1 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        SearchStyle r2 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        ToolListStyle r3 = null;
    L19:
        if ((r14 & 16) == 0) goto L21;
        SecKillChannelStyle r4 = null;
    L23:
        if ((r14 & 32) == 0) goto L25;
        DailyFloorChannelStyle r5 = null;
    L27:
        if ((r14 & 64) == 0) goto L29;
        DailyFloorChannelStyle r17 = null;
    L30:
        this(r16, r1, r2, r3, r4, r5, r17);
        return;
    L29:
        r17 = r13;
        goto L30
    L25:
        r5 = r12;
        goto L27
    L21:
        r4 = r11;
        goto L23
    L17:
        r3 = r10;
        goto L19
    L13:
        r2 = r9;
        goto L15
    L9:
        r1 = r8;
        goto L11
    L5:
        r16 = r7;
        goto L7
    }
}
