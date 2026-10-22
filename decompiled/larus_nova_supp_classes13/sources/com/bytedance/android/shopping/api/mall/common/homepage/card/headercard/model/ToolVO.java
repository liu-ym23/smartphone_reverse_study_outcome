package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u00010B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000eHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008f\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000eHÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011¨\u00061"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO;", "", "title", "", "name", "darkIcon", "link", "badge", "corner", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO$Corner;", "moduleId", "componentId", "resourceId", "cornerExtra", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO$Corner;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getBadge", "()Ljava/lang/String;", "getComponentId", "getCorner", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO$Corner;", "setCorner", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO$Corner;)V", "getCornerExtra", "()Ljava/util/Map;", "getDarkIcon", "getLink", "getModuleId", "getName", "getResourceId", "getTitle", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "Corner", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolVO {

    @SerializedName("badge")
    private final String badge;

    @SerializedName("component_id")
    private final String componentId;

    @SerializedName("corner")
    private Corner corner;

    @SerializedName("corner_extra")
    private final Map<String, String> cornerExtra;

    @SerializedName("dark_icon")
    private final String darkIcon;

    @SerializedName("link")
    private final String link;

    @SerializedName("module_id")
    private final String moduleId;

    @SerializedName("name")
    private final String name;

    @SerializedName("resource_id")
    private final String resourceId;

    @SerializedName("title")
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO$Corner;", "", "type", "", "text", "skipUrl", "skipCartId", "freq", "canShow", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getCanShow", "()Z", "setCanShow", "(Z)V", "getFreq", "()Ljava/lang/String;", "setFreq", "(Ljava/lang/String;)V", "getSkipCartId", "getSkipUrl", "getText", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Corner {
        private boolean canShow;

        @SerializedName("freq")
        private String freq;

        @SerializedName("skip_cart_id")
        private final String skipCartId;

        @SerializedName("skip_url")
        private final String skipUrl;

        @SerializedName("text")
        private final String text;

        @SerializedName("type")
        private final String type;

        public Corner() {
            this(null, null, null, null, null, false, 63, null);
        }

        public static /* synthetic */ Corner copy$default(Corner r4, String r5, String r6, String r7, String r8, String r9, boolean r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = r4.type;
        L6:
            if ((r11 & 2) == 0) goto L8;
            r6 = r4.text;
        L8:
            String r13 = r6;
            if ((r11 & 4) == 0) goto L11;
            r7 = r4.skipUrl;
        L11:
            String r0 = r7;
            if ((r11 & 8) == 0) goto L14;
            r8 = r4.skipCartId;
        L14:
            String r1 = r8;
            if ((r11 & 16) == 0) goto L17;
            r9 = r4.freq;
        L17:
            String r2 = r9;
            if ((r11 & 32) == 0) goto L20;
            r10 = r4.canShow;
        L20:
            String r14 = r5;
            return r4.copy(r14, r13, r0, r1, r2, r10);
        }

        public final String component1() {
            return this.type;
        }

        public final String component2() {
            return this.text;
        }

        public final String component3() {
            return this.skipUrl;
        }

        public final String component4() {
            return this.skipCartId;
        }

        public final String component5() {
            return this.freq;
        }

        public final boolean component6() {
            return this.canShow;
        }

        public final Corner copy(String r9, String r10, String r11, String r12, String r13, boolean r14) {
            return new Corner(r9, r10, r11, r12, r13, r14);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof Corner) == false) goto L18;
            Corner r4 = (Corner) r3;
            if (Intrinsics.areEqual(this.type, r4.type) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.text, r4.text) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.skipUrl, r4.skipUrl) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.skipCartId, r4.skipCartId) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.freq, r4.freq) == true) goto L16;
            return false;
        L16:
            if (this.canShow == r4.canShow) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            String r0 = this.type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.text;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.skipUrl;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.skipCartId;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.freq;
            if (r13 == null) goto L21;
            r1 = r13.hashCode();
        L21:
            int r14 = (r12 + r1) * 31;
            boolean r15 = this.canShow;
            ?? r16 = r15;
            if (r15 == false) goto L25;
            r16 = 1;
        L25:
            return r14 + r16;
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
            return "Corner(type=" + this.type + ", text=" + this.text + ", skipUrl=" + this.skipUrl + ", skipCartId=" + this.skipCartId + ", freq=" + this.freq + ", canShow=" + this.canShow + ")";
        }

        public final boolean getCanShow() {
            return this.canShow;
        }

        public final String getFreq() {
            return this.freq;
        }

        public final String getSkipCartId() {
            return this.skipCartId;
        }

        public final String getSkipUrl() {
            return this.skipUrl;
        }

        public final String getText() {
            return this.text;
        }

        public final String getType() {
            return this.type;
        }

        public final void setCanShow(boolean r1) {
            this.canShow = r1;
        }

        public final void setFreq(String r1) {
            this.freq = r1;
        }

        public Corner(String r1, String r2, String r3, String r4, String r5, boolean r6) {
            this.type = r1;
            this.text = r2;
            this.skipUrl = r3;
            this.skipCartId = r4;
            this.freq = r5;
            this.canShow = r6;
        }

        public /* synthetic */ Corner(String r5, String r6, String r7, String r8, String r9, boolean r10, int r11, DefaultConstructorMarker r12) {
            String r0 = null;
            if ((r11 & 1) == 0) goto L5;
            String r13 = null;
        L7:
            if ((r11 & 2) == 0) goto L9;
            String r1 = null;
        L11:
            if ((r11 & 4) == 0) goto L13;
            String r2 = null;
        L15:
            if ((r11 & 8) == 0) goto L17;
            String r3 = null;
        L19:
            if ((r11 & 16) != 0) goto L23;
            r0 = r9;
        L23:
            if ((r11 & 32) == 0) goto L25;
            boolean r14 = true;
        L26:
            this(r13, r1, r2, r3, r0, r14);
            return;
        L25:
            r14 = r10;
            goto L26
        L17:
            r3 = r8;
            goto L19
        L13:
            r2 = r7;
            goto L15
        L9:
            r1 = r6;
            goto L11
        L5:
            r13 = r5;
            goto L7
        }
    }

    public ToolVO() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ToolVO copy$default(ToolVO r11, String r12, String r13, String r14, String r15, String r16, Corner r17, String r18, String r19, String r20, Map r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r2 = r11.title;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = r11.name;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = r11.darkIcon;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = r11.link;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = r11.badge;
    L23:
        if ((r22 & 32) == 0) goto L25;
        Corner r7 = r11.corner;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r8 = r11.moduleId;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = r11.componentId;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r10 = r11.resourceId;
    L39:
        if ((r22 & 512) == 0) goto L41;
        Map r1 = r11.cornerExtra;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final String component1() {
        return this.title;
    }

    public final Map<String, String> component10() {
        return this.cornerExtra;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.darkIcon;
    }

    public final String component4() {
        return this.link;
    }

    public final String component5() {
        return this.badge;
    }

    public final Corner component6() {
        return this.corner;
    }

    public final String component7() {
        return this.moduleId;
    }

    public final String component8() {
        return this.componentId;
    }

    public final String component9() {
        return this.resourceId;
    }

    public final ToolVO copy(String r13, String r14, String r15, String r16, String r17, Corner r18, String r19, String r20, String r21, Map<String, String> r22) {
        return new ToolVO(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ToolVO) == false) goto L26;
        ToolVO r4 = (ToolVO) r3;
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.darkIcon, r4.darkIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.link, r4.link) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.badge, r4.badge) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.corner, r4.corner) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.moduleId, r4.moduleId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.componentId, r4.componentId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.resourceId, r4.resourceId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.cornerExtra, r4.cornerExtra) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        String r0 = this.title;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.name;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.darkIcon;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.link;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.badge;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Corner r16 = this.corner;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.moduleId;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.componentId;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.resourceId;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        Map<String, String> r28 = this.cornerExtra;
        if (r28 == null) goto L42;
        r1 = r28.hashCode();
    L42:
        return r27 + r1;
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
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
        return "ToolVO(title=" + this.title + ", name=" + this.name + ", darkIcon=" + this.darkIcon + ", link=" + this.link + ", badge=" + this.badge + ", corner=" + this.corner + ", moduleId=" + this.moduleId + ", componentId=" + this.componentId + ", resourceId=" + this.resourceId + ", cornerExtra=" + this.cornerExtra + ")";
    }

    public final String getBadge() {
        return this.badge;
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public final Corner getCorner() {
        return this.corner;
    }

    public final Map<String, String> getCornerExtra() {
        return this.cornerExtra;
    }

    public final String getDarkIcon() {
        return this.darkIcon;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getModuleId() {
        return this.moduleId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setCorner(Corner r1) {
        this.corner = r1;
    }

    public ToolVO(String r1, String r2, String r3, String r4, String r5, Corner r6, String r7, String r8, String r9, Map<String, String> r10) {
        this.title = r1;
        this.name = r2;
        this.darkIcon = r3;
        this.link = r4;
        this.badge = r5;
        this.corner = r6;
        this.moduleId = r7;
        this.componentId = r8;
        this.resourceId = r9;
        this.cornerExtra = r10;
    }

    public /* synthetic */ ToolVO(String r12, String r13, String r14, String r15, String r16, Corner r17, String r18, String r19, String r20, Map r21, int r22, DefaultConstructorMarker r23) {
        Map r2 = null;
        if ((r22 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r22 & 32) == 0) goto L25;
        Corner r7 = null;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r22 & 512) != 0) goto L42;
        r2 = r21;
    L42:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r2);
        return;
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }
}
