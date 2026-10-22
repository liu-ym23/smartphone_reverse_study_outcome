package com.bytedance.android.shopping.api.mall.preload.gecko;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R$\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/preload/gecko/ECMallGeckoPreloadConfig;", "Ljava/io/Serializable;", "()V", "eventExecuteEnable", "", "getEventExecuteEnable", "()Z", "exposureExecuteEnable", "getExposureExecuteEnable", "itemConfigMap", "", "", "Lcom/bytedance/android/shopping/api/mall/preload/gecko/ECMallGeckoPreloadConfig$ItemConfig;", "getItemConfigMap", "()Ljava/util/Map;", "ItemConfig", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallGeckoPreloadConfig implements Serializable {

    @SerializedName("event_execute_enable")
    private final boolean eventExecuteEnable;

    @SerializedName("exposure_execute_enable")
    private final boolean exposureExecuteEnable;

    @SerializedName("item_config_map")
    private final Map<String, ItemConfig> itemConfigMap;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b%\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\u0010HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\t\u0010/\u001a\u00020\rHÆ\u0003J\u0083\u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u00101\u001a\u00020\r2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\nHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001a\u0010\u000e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0013¨\u00065"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/preload/gecko/ECMallGeckoPreloadConfig$ItemConfig;", "", "channelName", "", "accessKeyOnline", "accessKeyDebug", "componentId", "tileComponentId", "tabId", "executeCountLimit", "", "executeGapDuration", "retryEnable", "", "executeCount", "lastExecuteTimestamp", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZIJ)V", "getAccessKeyDebug", "()Ljava/lang/String;", "getAccessKeyOnline", "getChannelName", "getComponentId", "getExecuteCount", "()I", "setExecuteCount", "(I)V", "getExecuteCountLimit", "getExecuteGapDuration", "getLastExecuteTimestamp", "()J", "setLastExecuteTimestamp", "(J)V", "getRetryEnable", "()Z", "getTabId", "getTileComponentId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ItemConfig {

        @SerializedName("access_key_debug")
        private final String accessKeyDebug;

        @SerializedName("access_key_online")
        private final String accessKeyOnline;

        @SerializedName("channel_name")
        private final String channelName;

        @SerializedName("component_id")
        private final String componentId;
        private transient int executeCount;

        @SerializedName("execute_count_limit")
        private final int executeCountLimit;

        @SerializedName("execute_gap_duration")
        private final int executeGapDuration;
        private transient long lastExecuteTimestamp;

        @SerializedName("retry_enable")
        private final boolean retryEnable;

        @SerializedName("tab_id")
        private final String tabId;

        @SerializedName("tile_component_id")
        private final String tileComponentId;

        public ItemConfig() {
            this(null, null, null, null, null, null, 0, 0, false, 0, 0, 2047, null);
        }

        public static /* synthetic */ ItemConfig copy$default(ItemConfig r14, String r15, String r16, String r17, String r18, String r19, String r20, int r21, int r22, boolean r23, int r24, long r25, int r27, Object r28) {
            if ((r27 & 1) == 0) goto L5;
            String r2 = r14.channelName;
        L7:
            if ((r27 & 2) == 0) goto L9;
            String r3 = r14.accessKeyOnline;
        L11:
            if ((r27 & 4) == 0) goto L13;
            String r4 = r14.accessKeyDebug;
        L15:
            if ((r27 & 8) == 0) goto L17;
            String r5 = r14.componentId;
        L19:
            if ((r27 & 16) == 0) goto L21;
            String r6 = r14.tileComponentId;
        L23:
            if ((r27 & 32) == 0) goto L25;
            String r7 = r14.tabId;
        L27:
            if ((r27 & 64) == 0) goto L29;
            int r8 = r14.executeCountLimit;
        L31:
            if ((r27 & 128) == 0) goto L33;
            int r9 = r14.executeGapDuration;
        L35:
            if ((r27 & 256) == 0) goto L37;
            boolean r10 = r14.retryEnable;
        L39:
            if ((r27 & 512) == 0) goto L41;
            int r11 = r14.executeCount;
        L43:
            if ((r27 & 1024) == 0) goto L45;
            long r12 = r14.lastExecuteTimestamp;
        L47:
            return r14.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
        L45:
            r12 = r25;
            goto L47
        L41:
            r11 = r24;
            goto L43
        L37:
            r10 = r23;
            goto L39
        L33:
            r9 = r22;
            goto L35
        L29:
            r8 = r21;
            goto L31
        L25:
            r7 = r20;
            goto L27
        L21:
            r6 = r19;
            goto L23
        L17:
            r5 = r18;
            goto L19
        L13:
            r4 = r17;
            goto L15
        L9:
            r3 = r16;
            goto L11
        L5:
            r2 = r15;
            goto L7
        }

        public final String component1() {
            return this.channelName;
        }

        public final int component10() {
            return this.executeCount;
        }

        public final long component11() {
            return this.lastExecuteTimestamp;
        }

        public final String component2() {
            return this.accessKeyOnline;
        }

        public final String component3() {
            return this.accessKeyDebug;
        }

        public final String component4() {
            return this.componentId;
        }

        public final String component5() {
            return this.tileComponentId;
        }

        public final String component6() {
            return this.tabId;
        }

        public final int component7() {
            return this.executeCountLimit;
        }

        public final int component8() {
            return this.executeGapDuration;
        }

        public final boolean component9() {
            return this.retryEnable;
        }

        public final ItemConfig copy(String r15, String r16, String r17, String r18, String r19, String r20, int r21, int r22, boolean r23, int r24, long r25) {
            return new ItemConfig(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L4;
            return true;
        L4:
            if ((r5 instanceof ItemConfig) == false) goto L28;
            ItemConfig r6 = (ItemConfig) r5;
            if (Intrinsics.areEqual(this.channelName, r6.channelName) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.accessKeyOnline, r6.accessKeyOnline) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.accessKeyDebug, r6.accessKeyDebug) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.componentId, r6.componentId) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.tileComponentId, r6.tileComponentId) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.tabId, r6.tabId) == true) goto L18;
            return false;
        L18:
            if (this.executeCountLimit == r6.executeCountLimit) goto L20;
            return false;
        L20:
            if (this.executeGapDuration == r6.executeGapDuration) goto L22;
            return false;
        L22:
            if (this.retryEnable == r6.retryEnable) goto L24;
            return false;
        L24:
            if (this.executeCount == r6.executeCount) goto L26;
            return false;
        L26:
            if (this.lastExecuteTimestamp == r6.lastExecuteTimestamp) goto L43;
            return false;
        L43:
            return true;
        L28:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v18, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9 */
        public int hashCode() {
            String r0 = this.channelName;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.accessKeyOnline;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.accessKeyDebug;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.componentId;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.tileComponentId;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.tabId;
            if (r16 == null) goto L25;
            r1 = r16.hashCode();
        L25:
            int r17 = (((((r15 + r1) * 31) + this.executeCountLimit) * 31) + this.executeGapDuration) * 31;
            boolean r18 = this.retryEnable;
            ?? r19 = r18;
            if (r18 == false) goto L28;
            r19 = 1;
        L28:
            int r20 = (((r17 + r19) * 31) + this.executeCount) * 31;
            long r21 = this.lastExecuteTimestamp;
            return r20 + ((int) (r21 ^ (r21 >>> 32)));
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
            return "ItemConfig(channelName=" + this.channelName + ", accessKeyOnline=" + this.accessKeyOnline + ", accessKeyDebug=" + this.accessKeyDebug + ", componentId=" + this.componentId + ", tileComponentId=" + this.tileComponentId + ", tabId=" + this.tabId + ", executeCountLimit=" + this.executeCountLimit + ", executeGapDuration=" + this.executeGapDuration + ", retryEnable=" + this.retryEnable + ", executeCount=" + this.executeCount + ", lastExecuteTimestamp=" + this.lastExecuteTimestamp + ")";
        }

        public final String getAccessKeyDebug() {
            return this.accessKeyDebug;
        }

        public final String getAccessKeyOnline() {
            return this.accessKeyOnline;
        }

        public final String getChannelName() {
            return this.channelName;
        }

        public final String getComponentId() {
            return this.componentId;
        }

        public final int getExecuteCount() {
            return this.executeCount;
        }

        public final int getExecuteCountLimit() {
            return this.executeCountLimit;
        }

        public final int getExecuteGapDuration() {
            return this.executeGapDuration;
        }

        public final long getLastExecuteTimestamp() {
            return this.lastExecuteTimestamp;
        }

        public final boolean getRetryEnable() {
            return this.retryEnable;
        }

        public final String getTabId() {
            return this.tabId;
        }

        public final String getTileComponentId() {
            return this.tileComponentId;
        }

        public final void setExecuteCount(int r1) {
            this.executeCount = r1;
        }

        public final void setLastExecuteTimestamp(long r1) {
            this.lastExecuteTimestamp = r1;
        }

        public ItemConfig(String r1, String r2, String r3, String r4, String r5, String r6, int r7, int r8, boolean r9, int r10, long r11) {
            this.channelName = r1;
            this.accessKeyOnline = r2;
            this.accessKeyDebug = r3;
            this.componentId = r4;
            this.tileComponentId = r5;
            this.tabId = r6;
            this.executeCountLimit = r7;
            this.executeGapDuration = r8;
            this.retryEnable = r9;
            this.executeCount = r10;
            this.lastExecuteTimestamp = r11;
        }

        public /* synthetic */ ItemConfig(String r14, String r15, String r16, String r17, String r18, String r19, int r20, int r21, boolean r22, int r23, long r24, int r26, DefaultConstructorMarker r27) {
            String r2 = null;
            if ((r26 & 1) == 0) goto L5;
            String r1 = null;
        L7:
            if ((r26 & 2) == 0) goto L9;
            String r3 = null;
        L11:
            if ((r26 & 4) == 0) goto L13;
            String r4 = null;
        L15:
            if ((r26 & 8) == 0) goto L17;
            String r5 = null;
        L19:
            if ((r26 & 16) == 0) goto L21;
            String r6 = null;
        L23:
            if ((r26 & 32) != 0) goto L26;
            r2 = r19;
        L26:
            int r8 = 0;
            if ((r26 & 64) == 0) goto L29;
            int r7 = 0;
        L31:
            if ((r26 & 128) == 0) goto L33;
            int r9 = 0;
        L35:
            if ((r26 & 256) == 0) goto L37;
            boolean r10 = false;
        L39:
            if ((r26 & 512) != 0) goto L43;
            r8 = r23;
        L43:
            if ((r26 & 1024) == 0) goto L45;
            long r11 = 0;
        L46:
            this(r1, r3, r4, r5, r6, r2, r7, r9, r10, r8, r11);
            return;
        L45:
            r11 = r24;
            goto L46
        L37:
            r10 = r22;
            goto L39
        L33:
            r9 = r21;
            goto L35
        L29:
            r7 = r20;
            goto L31
        L21:
            r6 = r18;
            goto L23
        L17:
            r5 = r17;
            goto L19
        L13:
            r4 = r16;
            goto L15
        L9:
            r3 = r15;
            goto L11
        L5:
            r1 = r14;
            goto L7
        }
    }

    public ECMallGeckoPreloadConfig() {
    }

    public final boolean getEventExecuteEnable() {
        return this.eventExecuteEnable;
    }

    public final boolean getExposureExecuteEnable() {
        return this.exposureExecuteEnable;
    }

    public final Map<String, ItemConfig> getItemConfigMap() {
        return this.itemConfigMap;
    }
}
