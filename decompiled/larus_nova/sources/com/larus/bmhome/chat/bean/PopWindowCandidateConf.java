package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u00103\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010)J\u0086\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u00105J\u0006\u00106\u001a\u00020\u0005J\u0013\u00107\u001a\u00020\u00142\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\u0005HÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001J\u0016\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0005R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)¨\u0006A"}, d2 = {"Lcom/larus/bmhome/chat/bean/PopWindowCandidateConf;", "Landroid/os/Parcelable;", "name", "", "popWindowType", "", "text", "Lcom/larus/bmhome/chat/bean/PopWindowText;", "mediaList", "", "Lcom/larus/bmhome/chat/bean/PopWindowMedia;", "buttonList", "Lcom/larus/bmhome/chat/bean/PopWindowButton;", "backgroundColor", "Lcom/larus/bmhome/chat/bean/PopWindowColor;", "frequencyConf", "Lcom/larus/bmhome/chat/bean/PopWindowFrequencyConf;", "priority", "", "showMute", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/bmhome/chat/bean/PopWindowText;Ljava/util/List;Ljava/util/List;Lcom/larus/bmhome/chat/bean/PopWindowColor;Lcom/larus/bmhome/chat/bean/PopWindowFrequencyConf;Ljava/lang/Long;Ljava/lang/Boolean;)V", "getName", "()Ljava/lang/String;", "getPopWindowType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getText", "()Lcom/larus/bmhome/chat/bean/PopWindowText;", "getMediaList", "()Ljava/util/List;", "getButtonList", "getBackgroundColor", "()Lcom/larus/bmhome/chat/bean/PopWindowColor;", "getFrequencyConf", "()Lcom/larus/bmhome/chat/bean/PopWindowFrequencyConf;", "getPriority", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getShowMute", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/bmhome/chat/bean/PopWindowText;Ljava/util/List;Ljava/util/List;Lcom/larus/bmhome/chat/bean/PopWindowColor;Lcom/larus/bmhome/chat/bean/PopWindowFrequencyConf;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/bean/PopWindowCandidateConf;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopWindowCandidateConf implements Parcelable {
    public static final Parcelable.Creator<PopWindowCandidateConf> CREATOR = null;

    @SerializedName("background_color")
    private final PopWindowColor backgroundColor;

    @SerializedName("button_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<PopWindowButton> buttonList;

    @SerializedName("frequency_conf")
    private final PopWindowFrequencyConf frequencyConf;

    @SerializedName("media_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<PopWindowMedia> mediaList;

    @SerializedName("name")
    private final String name;

    @SerializedName("pop_window_type")
    private final Integer popWindowType;

    @SerializedName("priority")
    private final Long priority;

    @SerializedName("show_trumpet")
    private final Boolean showMute;

    @SerializedName("text")
    private final PopWindowText text;

    public static final class a implements Parcelable.Creator<PopWindowCandidateConf> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowCandidateConf createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            if (r110.readInt() != 0) goto L5;
            Integer r101 = null;
        L7:
            if (r110.readInt() != 0) goto L9;
            PopWindowText r102 = null;
        L10:
            PopWindowText r103 = r102;
            boolean r104 = false;
            if (r110.readInt() != 0) goto L13;
            ArrayList r105 = null;
        L17:
            if (r110.readInt() != 0) goto L19;
            ArrayList r106 = null;
        L23:
            if (r110.readInt() != 0) goto L25;
            PopWindowColor r107 = null;
        L26:
            PopWindowColor r108 = r107;
            if (r110.readInt() != 0) goto L29;
            PopWindowFrequencyConf r109 = null;
        L30:
            PopWindowFrequencyConf r111 = r109;
            if (r110.readInt() != 0) goto L33;
            Long r112 = null;
        L35:
            if (r110.readInt() != 0) goto L38;
            Boolean r113 = null;
        L42:
            return new PopWindowCandidateConf(r100, r101, r103, r105, r106, r108, r111, r112, r113);
        L38:
            if (r110.readInt() == 0) goto L40;
            r104 = true;
        L40:
            r113 = Boolean.valueOf(r104);
            goto L42
        L33:
            r112 = Long.valueOf(r110.readLong());
            goto L35
        L29:
            r109 = PopWindowFrequencyConf.CREATOR.createFromParcel(r110);
            goto L30
        L25:
            r107 = PopWindowColor.CREATOR.createFromParcel(r110);
            goto L26
        L19:
            int r114 = r110.readInt();
            r106 = new ArrayList(r114);
            int r115 = 0;
        L20:
            if (r115 == r114) goto L23;
            r106.add(PopWindowButton.CREATOR.createFromParcel(r110));
            r115 = r115 + 1;
            goto L20
        L13:
            int r116 = r110.readInt();
            r105 = new ArrayList(r116);
            int r117 = 0;
        L14:
            if (r117 == r116) goto L17;
            r105.add(PopWindowMedia.CREATOR.createFromParcel(r110));
            r117 = r117 + 1;
            goto L14
        L9:
            r102 = PopWindowText.CREATOR.createFromParcel(r110);
            goto L10
        L5:
            r101 = Integer.valueOf(r110.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowCandidateConf[] newArray(int r100) {
            return new PopWindowCandidateConf[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PopWindowCandidateConf() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PopWindowCandidateConf copy$default(PopWindowCandidateConf r110, String r111, Integer r112, PopWindowText r113, List r114, List r115, PopWindowColor r116, PopWindowFrequencyConf r117, Long r118, Boolean r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.name;
    L7:
        if ((r210 & 2) == 0) goto L9;
        Integer r101 = r110.popWindowType;
    L11:
        if ((r210 & 4) == 0) goto L13;
        PopWindowText r102 = r110.text;
    L15:
        if ((r210 & 8) == 0) goto L17;
        List r103 = r110.mediaList;
    L19:
        if ((r210 & 16) == 0) goto L21;
        List r104 = r110.buttonList;
    L23:
        if ((r210 & 32) == 0) goto L25;
        PopWindowColor r105 = r110.backgroundColor;
    L27:
        if ((r210 & 64) == 0) goto L29;
        PopWindowFrequencyConf r106 = r110.frequencyConf;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Long r107 = r110.priority;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Boolean r108 = r110.showMute;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.name;
    }

    public final Integer component2() {
        return this.popWindowType;
    }

    public final PopWindowText component3() {
        return this.text;
    }

    public final List<PopWindowMedia> component4() {
        return this.mediaList;
    }

    public final List<PopWindowButton> component5() {
        return this.buttonList;
    }

    public final PopWindowColor component6() {
        return this.backgroundColor;
    }

    public final PopWindowFrequencyConf component7() {
        return this.frequencyConf;
    }

    public final Long component8() {
        return this.priority;
    }

    public final Boolean component9() {
        return this.showMute;
    }

    public final PopWindowCandidateConf copy(String r110, Integer r111, PopWindowText r112, List<PopWindowMedia> r113, List<PopWindowButton> r114, PopWindowColor r115, PopWindowFrequencyConf r116, Long r117, Boolean r210) {
        return new PopWindowCandidateConf(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PopWindowCandidateConf) == true) goto L8;
        return false;
    L8:
        PopWindowCandidateConf r101 = (PopWindowCandidateConf) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.popWindowType, r101.popWindowType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mediaList, r101.mediaList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.buttonList, r101.buttonList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.frequencyConf, r101.frequencyConf) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.priority, r101.priority) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.showMute, r101.showMute) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.popWindowType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        PopWindowText r107 = this.text;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<PopWindowMedia> r110 = this.mediaList;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<PopWindowButton> r113 = this.buttonList;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        PopWindowColor r116 = this.backgroundColor;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        PopWindowFrequencyConf r119 = this.frequencyConf;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.priority;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.showMute;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PopWindowCandidateConf(name=" + this.name + ", popWindowType=" + this.popWindowType + ", text=" + this.text + ", mediaList=" + this.mediaList + ", buttonList=" + this.buttonList + ", backgroundColor=" + this.backgroundColor + ", frequencyConf=" + this.frequencyConf + ", priority=" + this.priority + ", showMute=" + this.showMute + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.name);
        Integer r102 = this.popWindowType;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        PopWindowText r103 = this.text;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        List<PopWindowMedia> r104 = this.mediaList;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L17:
        List<PopWindowButton> r105 = this.buttonList;
        if (r105 != null) goto L20;
        r100.writeInt(0);
    L24:
        PopWindowColor r106 = this.backgroundColor;
        if (r106 != null) goto L27;
        r100.writeInt(0);
    L28:
        PopWindowFrequencyConf r107 = this.frequencyConf;
        if (r107 != null) goto L31;
        r100.writeInt(0);
    L32:
        Long r108 = this.priority;
        if (r108 != null) goto L35;
        r100.writeInt(0);
    L36:
        Boolean r109 = this.showMute;
        if (r109 != null) goto L39;
        r100.writeInt(0);
        return;
    L39:
        r100.writeInt(1);
        r100.writeInt(r109.booleanValue() ? 1 : 0);
        return;
    L35:
        r100.writeInt(1);
        r100.writeLong(r108.longValue());
        goto L36
    L31:
        r100.writeInt(1);
        r107.writeToParcel(r100, r101);
        goto L32
    L27:
        r100.writeInt(1);
        r106.writeToParcel(r100, r101);
        goto L28
    L20:
        r100.writeInt(1);
        r100.writeInt(r105.size());
        Iterator<PopWindowButton> r110 = r105.iterator();
    L22:
        if (r110.hasNext() == false) goto L24;
        r110.next().writeToParcel(r100, r101);
        goto L22
    L13:
        r100.writeInt(1);
        r100.writeInt(r104.size());
        Iterator<PopWindowMedia> r111 = r104.iterator();
    L15:
        if (r111.hasNext() == false) goto L17;
        r111.next().writeToParcel(r100, r101);
        goto L15
    L9:
        r100.writeInt(1);
        r103.writeToParcel(r100, r101);
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
        goto L6
    }

    public final PopWindowColor getBackgroundColor() {
        return this.backgroundColor;
    }

    public final List<PopWindowButton> getButtonList() {
        return this.buttonList;
    }

    public final PopWindowFrequencyConf getFrequencyConf() {
        return this.frequencyConf;
    }

    public final List<PopWindowMedia> getMediaList() {
        return this.mediaList;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getPopWindowType() {
        return this.popWindowType;
    }

    public final Long getPriority() {
        return this.priority;
    }

    public final Boolean getShowMute() {
        return this.showMute;
    }

    public final PopWindowText getText() {
        return this.text;
    }

    public PopWindowCandidateConf(String r100, Integer r101, PopWindowText r102, List<PopWindowMedia> r103, List<PopWindowButton> r104, PopWindowColor r105, PopWindowFrequencyConf r106, Long r107, Boolean r108) {
        this.name = r100;
        this.popWindowType = r101;
        this.text = r102;
        this.mediaList = r103;
        this.buttonList = r104;
        this.backgroundColor = r105;
        this.frequencyConf = r106;
        this.priority = r107;
        this.showMute = r108;
    }

    public /* synthetic */ PopWindowCandidateConf(String r110, Integer r111, PopWindowText r112, List r113, List r114, PopWindowColor r115, PopWindowFrequencyConf r116, Long r117, Boolean r118, int r210, DefaultConstructorMarker r211) {
        Boolean r100 = null;
        if ((r210 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        Integer r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        PopWindowText r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        List r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        List r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        PopWindowColor r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        PopWindowFrequencyConf r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Long r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
