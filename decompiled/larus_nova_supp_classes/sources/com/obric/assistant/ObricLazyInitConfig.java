package com.obric.assistant;

import android.util.EventsUtils;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/ObricLazyInitConfig;", XmlPullParser.NO_NAMESPACE, "enableIvyKitLazyInit", XmlPullParser.NO_NAMESPACE, "enableAppletLazyInit", "enableTTVideoEngineLazyInit", "enableLocalLifeLazyInit", "enableECommerceLazyInit", "<init>", "(ZZZZZ)V", "getEnableIvyKitLazyInit", "()Z", "getEnableAppletLazyInit", "getEnableTTVideoEngineLazyInit", "getEnableLocalLifeLazyInit", "getEnableECommerceLazyInit", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", XmlPullParser.NO_NAMESPACE, "toString", XmlPullParser.NO_NAMESPACE, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ObricLazyInitConfig {

    @SerializedName("enable_applet_lazy_init")
    private final boolean enableAppletLazyInit;

    @SerializedName("enable_ecommerce_lazy_init")
    private final boolean enableECommerceLazyInit;

    @SerializedName("enable_ivykit_lazy_init")
    private final boolean enableIvyKitLazyInit;

    @SerializedName("enable_local_life_lazy_init")
    private final boolean enableLocalLifeLazyInit;

    @SerializedName("enable_tt_video_engine_lazy_init")
    private final boolean enableTTVideoEngineLazyInit;

    public ObricLazyInitConfig() {
        this(false, false, false, false, false, 31, null);
    }

    public static /* synthetic */ ObricLazyInitConfig copy$default(ObricLazyInitConfig r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.enableIvyKitLazyInit;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.enableAppletLazyInit;
    L8:
        boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.enableTTVideoEngineLazyInit;
    L11:
        boolean r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.enableLocalLifeLazyInit;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.enableECommerceLazyInit;
    L17:
        boolean r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final boolean component1() {
        return this.enableIvyKitLazyInit;
    }

    public final boolean component2() {
        return this.enableAppletLazyInit;
    }

    public final boolean component3() {
        return this.enableTTVideoEngineLazyInit;
    }

    public final boolean component4() {
        return this.enableLocalLifeLazyInit;
    }

    public final boolean component5() {
        return this.enableECommerceLazyInit;
    }

    public final ObricLazyInitConfig copy(boolean r8, boolean r9, boolean r10, boolean r11, boolean r12) {
        return new ObricLazyInitConfig(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricLazyInitConfig) == true) goto L8;
        return false;
    L8:
        ObricLazyInitConfig r6 = (ObricLazyInitConfig) r5;
        if (this.enableIvyKitLazyInit == r6.enableIvyKitLazyInit) goto L12;
        return false;
    L12:
        if (this.enableAppletLazyInit == r6.enableAppletLazyInit) goto L15;
        return false;
    L15:
        if (this.enableTTVideoEngineLazyInit == r6.enableTTVideoEngineLazyInit) goto L18;
        return false;
    L18:
        if (this.enableLocalLifeLazyInit == r6.enableLocalLifeLazyInit) goto L21;
        return false;
    L21:
        if (this.enableECommerceLazyInit == r6.enableECommerceLazyInit) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.enableIvyKitLazyInit == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.enableAppletLazyInit == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.enableTTVideoEngineLazyInit == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.enableLocalLifeLazyInit == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.enableECommerceLazyInit == true) goto L23;
        r1 = 1237;
    L23:
        return r8 + r1;
    L17:
        r7 = 1237;
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "ObricLazyInitConfig(enableIvyKitLazyInit=" + this.enableIvyKitLazyInit + ", enableAppletLazyInit=" + this.enableAppletLazyInit + ", enableTTVideoEngineLazyInit=" + this.enableTTVideoEngineLazyInit + ", enableLocalLifeLazyInit=" + this.enableLocalLifeLazyInit + ", enableECommerceLazyInit=" + this.enableECommerceLazyInit + ')';
    }

    public final boolean getEnableAppletLazyInit() {
        return this.enableAppletLazyInit;
    }

    public final boolean getEnableECommerceLazyInit() {
        return this.enableECommerceLazyInit;
    }

    public final boolean getEnableIvyKitLazyInit() {
        return this.enableIvyKitLazyInit;
    }

    public final boolean getEnableLocalLifeLazyInit() {
        return this.enableLocalLifeLazyInit;
    }

    public final boolean getEnableTTVideoEngineLazyInit() {
        return this.enableTTVideoEngineLazyInit;
    }

    public ObricLazyInitConfig(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5) {
        this.enableIvyKitLazyInit = r1;
        this.enableAppletLazyInit = r2;
        this.enableTTVideoEngineLazyInit = r3;
        this.enableLocalLifeLazyInit = r4;
        this.enableECommerceLazyInit = r5;
    }

    public /* synthetic */ ObricLazyInitConfig(boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        boolean r12 = false;
    L7:
        if ((r10 & 2) == 0) goto L9;
        boolean r1 = false;
    L11:
        if ((r10 & 4) == 0) goto L13;
        boolean r2 = false;
    L15:
        if ((r10 & 8) == 0) goto L17;
        boolean r3 = false;
    L19:
        if ((r10 & 16) == 0) goto L21;
        boolean r13 = false;
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
