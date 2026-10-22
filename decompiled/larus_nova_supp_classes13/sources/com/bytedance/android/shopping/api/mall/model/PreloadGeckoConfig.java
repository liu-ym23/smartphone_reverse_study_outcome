package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/PreloadGeckoConfig;", "", "channelName", "", "accessKeyDebug", "accessKeyOnline", "clearTimeInterval", "", "componentId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getAccessKeyDebug", "()Ljava/lang/String;", "getAccessKeyOnline", "getChannelName", "getClearTimeInterval", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getComponentId", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/model/PreloadGeckoConfig;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreloadGeckoConfig {

    @SerializedName("access_key_debug")
    private final String accessKeyDebug;

    @SerializedName("access_key_online")
    private final String accessKeyOnline;

    @SerializedName("channel_name")
    private final String channelName;

    @SerializedName("clear_time_interval")
    private final Integer clearTimeInterval;

    @SerializedName("component_id")
    private final String componentId;

    public PreloadGeckoConfig() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ PreloadGeckoConfig copy$default(PreloadGeckoConfig r3, String r4, String r5, String r6, Integer r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.channelName;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.accessKeyDebug;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.accessKeyOnline;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.clearTimeInterval;
    L14:
        Integer r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.componentId;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.channelName;
    }

    public final String component2() {
        return this.accessKeyDebug;
    }

    public final String component3() {
        return this.accessKeyOnline;
    }

    public final Integer component4() {
        return this.clearTimeInterval;
    }

    public final String component5() {
        return this.componentId;
    }

    public final PreloadGeckoConfig copy(String r8, String r9, String r10, Integer r11, String r12) {
        return new PreloadGeckoConfig(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof PreloadGeckoConfig) == false) goto L16;
        PreloadGeckoConfig r4 = (PreloadGeckoConfig) r3;
        if (Intrinsics.areEqual(this.channelName, r4.channelName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.accessKeyDebug, r4.accessKeyDebug) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.accessKeyOnline, r4.accessKeyOnline) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.clearTimeInterval, r4.clearTimeInterval) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.componentId, r4.componentId) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r0 = this.channelName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.accessKeyDebug;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.accessKeyOnline;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.clearTimeInterval;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.componentId;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
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
        return "PreloadGeckoConfig(channelName=" + this.channelName + ", accessKeyDebug=" + this.accessKeyDebug + ", accessKeyOnline=" + this.accessKeyOnline + ", clearTimeInterval=" + this.clearTimeInterval + ", componentId=" + this.componentId + ")";
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

    public final Integer getClearTimeInterval() {
        return this.clearTimeInterval;
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public PreloadGeckoConfig(String r1, String r2, String r3, Integer r4, String r5) {
        this.channelName = r1;
        this.accessKeyDebug = r2;
        this.accessKeyOnline = r3;
        this.clearTimeInterval = r4;
        this.componentId = r5;
    }

    public /* synthetic */ PreloadGeckoConfig(String r5, String r6, String r7, Integer r8, String r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        Integer r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        String r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
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
        r12 = r5;
        goto L7
    }
}
