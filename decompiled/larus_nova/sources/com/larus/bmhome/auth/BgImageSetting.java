package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u0006J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0004\u0010\u000bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0007\u0010\u000b¨\u0006\""}, d2 = {"Lcom/larus/bmhome/auth/BgImageSetting;", "Landroid/os/Parcelable;", "botGenAddImageSetting", "", "isAiImageWorkflow", "bgImageOpenMode", "", "isImageGuide", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getBotGenAddImageSetting", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBgImageOpenMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/larus/bmhome/auth/BgImageSetting;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BgImageSetting implements Parcelable {
    public static final Parcelable.Creator<BgImageSetting> CREATOR = null;

    @SerializedName("bg_image_open_mode")
    private final Integer bgImageOpenMode;

    @SerializedName("bot_gen_add_image_setting")
    private final Boolean botGenAddImageSetting;

    @SerializedName("is_ai_image_workflow")
    private final Boolean isAiImageWorkflow;

    @SerializedName("is_image_guide")
    private final Boolean isImageGuide;

    public static final class a implements Parcelable.Creator<BgImageSetting> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BgImageSetting createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            boolean r101 = false;
            Boolean r102 = null;
            if (r100.readInt() != 0) goto L6;
            Boolean r103 = null;
        L11:
            if (r100.readInt() != 0) goto L14;
            Boolean r104 = null;
        L19:
            if (r100.readInt() != 0) goto L21;
            Integer r105 = null;
        L23:
            if (r100.readInt() == 0) goto L30;
            if (r100.readInt() == 0) goto L28;
            r101 = true;
        L28:
            r102 = Boolean.valueOf(r101);
        L30:
            return new BgImageSetting(r103, r104, r105, r102);
        L21:
            r105 = Integer.valueOf(r100.readInt());
            goto L23
        L14:
            if (r100.readInt() == 0) goto L16;
            boolean r106 = true;
        L17:
            r104 = Boolean.valueOf(r106);
            goto L19
        L16:
            r106 = false;
            goto L17
        L6:
            if (r100.readInt() == 0) goto L8;
            boolean r107 = true;
        L9:
            r103 = Boolean.valueOf(r107);
            goto L11
        L8:
            r107 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final BgImageSetting[] newArray(int r100) {
            return new BgImageSetting[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public BgImageSetting() {
        this(null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BgImageSetting) == true) goto L8;
        return false;
    L8:
        BgImageSetting r101 = (BgImageSetting) r100;
        if (Intrinsics.areEqual(this.botGenAddImageSetting, r101.botGenAddImageSetting) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isAiImageWorkflow, r101.isAiImageWorkflow) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bgImageOpenMode, r101.bgImageOpenMode) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isImageGuide, r101.isImageGuide) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.botGenAddImageSetting;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isAiImageWorkflow;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.bgImageOpenMode;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isImageGuide;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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

    public final String toString() {
        return "BgImageSetting(botGenAddImageSetting=" + this.botGenAddImageSetting + ", isAiImageWorkflow=" + this.isAiImageWorkflow + ", bgImageOpenMode=" + this.bgImageOpenMode + ", isImageGuide=" + this.isImageGuide + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Boolean r102 = this.botGenAddImageSetting;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Boolean r103 = this.isAiImageWorkflow;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        Integer r104 = this.bgImageOpenMode;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        Boolean r105 = this.isImageGuide;
        if (r105 != null) goto L17;
        r100.writeInt(0);
        return;
    L17:
        r100.writeInt(1);
        r100.writeInt(r105.booleanValue() ? 1 : 0);
        return;
    L13:
        r100.writeInt(1);
        r100.writeInt(r104.intValue());
        goto L14
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.booleanValue() ? 1 : 0);
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.booleanValue() ? 1 : 0);
        goto L6
    }

    public final Integer a() {
        return this.bgImageOpenMode;
    }

    public final Boolean b() {
        return this.botGenAddImageSetting;
    }

    public final Boolean c() {
        return this.isAiImageWorkflow;
    }

    public final Boolean d() {
        return this.isImageGuide;
    }

    public BgImageSetting(Boolean r100, Boolean r101, Integer r102, Boolean r103) {
        this.botGenAddImageSetting = r100;
        this.isAiImageWorkflow = r101;
        this.bgImageOpenMode = r102;
        this.isImageGuide = r103;
    }
}
