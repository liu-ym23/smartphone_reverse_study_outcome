package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b&\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\rHÆ\u0003Jc\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\rHÆ\u0001J\u0006\u00101\u001a\u00020\nJ\u0013\u00102\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u00020\nHÖ\u0001J\t\u00106\u001a\u00020\u0006HÖ\u0001J\u0016\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R&\u0010\f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006<"}, d2 = {"Lcom/larus/bmhome/auth/TrendsAbConfig;", "Landroid/os/Parcelable;", "onlyMainBot", "", "inputBoxPanelExchange", "fallbackText", "", "sugEnable", "trendsEnable", "triggerTime", "", "sugTriggerTime", "locationList", "", "<init>", "(ZZLjava/lang/String;ZZIILjava/util/List;)V", "getOnlyMainBot", "()Z", "setOnlyMainBot", "(Z)V", "getInputBoxPanelExchange", "setInputBoxPanelExchange", "getFallbackText", "()Ljava/lang/String;", "setFallbackText", "(Ljava/lang/String;)V", "getSugEnable", "setSugEnable", "getTrendsEnable", "setTrendsEnable", "getTriggerTime", "()I", "setTriggerTime", "(I)V", "getSugTriggerTime", "setSugTriggerTime", "getLocationList", "()Ljava/util/List;", "setLocationList", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TrendsAbConfig implements Parcelable {
    public static final Parcelable.Creator<TrendsAbConfig> CREATOR = null;

    @SerializedName("fallback_text")
    private String fallbackText;

    @SerializedName("input_box_panel_exchange")
    private boolean inputBoxPanelExchange;

    @SerializedName("location_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<Integer> locationList;

    @SerializedName("coco_only")
    private boolean onlyMainBot;

    @SerializedName("sug_enable")
    private boolean sugEnable;

    @SerializedName("sug_trigger_time")
    private int sugTriggerTime;

    @SerializedName("trends_enable")
    private boolean trendsEnable;

    @SerializedName("trigger_time")
    private int triggerTime;

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a implements Parcelable.Creator<TrendsAbConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TrendsAbConfig createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            int r100 = 0;
            if (r110.readInt() == 0) goto L5;
            boolean r101 = true;
        L7:
            if (r110.readInt() == 0) goto L9;
            boolean r102 = true;
        L10:
            String r103 = r110.readString();
            if (r110.readInt() == 0) goto L13;
            boolean r104 = true;
        L15:
            if (r110.readInt() == 0) goto L17;
            boolean r105 = true;
        L18:
            int r106 = r110.readInt();
            int r111 = r110.readInt();
            if (r110.readInt() != 0) goto L21;
            ArrayList r112 = null;
        L26:
            return new TrendsAbConfig(r101, r102, r103, r104, r105, r106, r111, r112);
        L21:
            int r107 = r110.readInt();
            ArrayList r108 = new ArrayList(r107);
        L22:
            if (r100 == r107) goto L24;
            r108.add(Integer.valueOf(r110.readInt()));
            r100 = r100 + 1;
            goto L22
        L24:
            r112 = r108;
            goto L26
        L17:
            r105 = false;
            goto L18
        L13:
            r104 = false;
            goto L15
        L9:
            r102 = false;
            goto L10
        L5:
            r101 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final TrendsAbConfig[] newArray(int r100) {
            return new TrendsAbConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public TrendsAbConfig() {
        this(true, false, "", false, true, 0, 0, CollectionsKt.emptyList());
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TrendsAbConfig) == true) goto L8;
        return false;
    L8:
        TrendsAbConfig r101 = (TrendsAbConfig) r100;
        if (this.onlyMainBot == r101.onlyMainBot) goto L12;
        return false;
    L12:
        if (this.inputBoxPanelExchange == r101.inputBoxPanelExchange) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fallbackText, r101.fallbackText) == true) goto L18;
        return false;
    L18:
        if (this.sugEnable == r101.sugEnable) goto L21;
        return false;
    L21:
        if (this.trendsEnable == r101.trendsEnable) goto L24;
        return false;
    L24:
        if (this.triggerTime == r101.triggerTime) goto L27;
        return false;
    L27:
        if (this.sugTriggerTime == r101.sugTriggerTime) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.locationList, r101.locationList) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.onlyMainBot == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.inputBoxPanelExchange == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        String r105 = this.fallbackText;
        int r106 = 0;
        if (r105 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r104 + r107) * 31;
        if (this.sugEnable == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        if (this.trendsEnable == true) goto L22;
        r100 = 1237;
    L22:
        int r111 = (((((r110 + r100) * 31) + this.triggerTime) * 31) + this.sugTriggerTime) * 31;
        List<Integer> r112 = this.locationList;
        if (r112 == null) goto L27;
        r106 = r112.hashCode();
    L27:
        return r111 + r106;
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = r105.hashCode();
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "TrendsAbConfig(onlyMainBot=" + this.onlyMainBot + ", inputBoxPanelExchange=" + this.inputBoxPanelExchange + ", fallbackText=" + this.fallbackText + ", sugEnable=" + this.sugEnable + ", trendsEnable=" + this.trendsEnable + ", triggerTime=" + this.triggerTime + ", sugTriggerTime=" + this.sugTriggerTime + ", locationList=" + this.locationList + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.onlyMainBot ? 1 : 0);
        r100.writeInt(this.inputBoxPanelExchange ? 1 : 0);
        r100.writeString(this.fallbackText);
        r100.writeInt(this.sugEnable ? 1 : 0);
        r100.writeInt(this.trendsEnable ? 1 : 0);
        r100.writeInt(this.triggerTime);
        r100.writeInt(this.sugTriggerTime);
        List<Integer> r102 = this.locationList;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<Integer> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        r100.writeInt(r103.next().intValue());
        goto L7
    }

    public TrendsAbConfig(boolean r100, boolean r101, String r102, boolean r103, boolean r104, int r105, int r106, List<Integer> r107) {
        this.onlyMainBot = r100;
        this.inputBoxPanelExchange = r101;
        this.fallbackText = r102;
        this.sugEnable = r103;
        this.trendsEnable = r104;
        this.triggerTime = r105;
        this.sugTriggerTime = r106;
        this.locationList = r107;
    }
}
