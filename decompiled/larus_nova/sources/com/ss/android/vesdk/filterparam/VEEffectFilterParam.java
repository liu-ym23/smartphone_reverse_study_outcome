package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes40.dex */
public class VEEffectFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VEEffectFilterParam> CREATOR = null;
    public long commandID;
    public String[] composerTags;
    public float[] composerValues;
    public EffectFilterType effectFilterType;
    public String effectPath;
    public boolean isSyncLoadResource;
    public long longRequestId;
    public long longStickerId;
    public boolean multicamMode;
    public boolean needReload;
    public int reqId;
    public String stickerExtraKey;
    public int stickerId;
    public String stickerTag;
    public int timeout;
    public boolean useLongId;

    public static final enum EffectFilterType extends Enum<EffectFilterType> {
        private static final /* synthetic */ EffectFilterType[] $VALUES = null;
        public static final EffectFilterType AUDIO_SPEED = null;
        public static final EffectFilterType DEFAULT = null;
        public static final EffectFilterType MIMO = null;
        public static final EffectFilterType MUSIC = null;

        private static /* synthetic */ EffectFilterType[] $values() {
            return new EffectFilterType[]{DEFAULT, MUSIC, AUDIO_SPEED, MIMO};
        }

        static {
            DEFAULT = new EffectFilterType("DEFAULT", 0);
            MUSIC = new EffectFilterType("MUSIC", 1);
            AUDIO_SPEED = new EffectFilterType("AUDIO_SPEED", 2);
            MIMO = new EffectFilterType("MIMO", 3);
            $VALUES = $values();
        }

        public static EffectFilterType[] values() {
            return (EffectFilterType[]) $VALUES.clone();
        }

        public static EffectFilterType valueOf(String r100) {
            return (EffectFilterType) r27.a.a(EffectFilterType.class, r100);
        }

        private EffectFilterType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements Parcelable.Creator<VEEffectFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEEffectFilterParam createFromParcel(Parcel r100) {
            return new VEEffectFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEEffectFilterParam[] newArray(int r100) {
            return new VEEffectFilterParam[r100];
        }
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam
    public String toString() {
        return "VEEffectFilterParam{effectPath='" + this.effectPath + "', stickerId=" + this.stickerId + ", longStickerId=" + this.longStickerId + ", reqId=" + this.reqId + ", longReqId=" + this.longRequestId + ", useLongId=" + this.useLongId + ", timeout=" + this.timeout + ", needReload=" + this.needReload + ", stickerTag='" + this.stickerTag + "', isSyncLoadResource=" + this.isSyncLoadResource + ", composerTags=" + Arrays.toString(this.composerTags) + ", composerValues=" + Arrays.toString(this.composerValues) + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + "', effectFilterType=" + this.effectFilterType.ordinal() + ", multicamMode=" + this.multicamMode + ", stickerExtraKey=" + this.stickerExtraKey + ", commandId=" + this.commandID + '}';
    }

    public VEEffectFilterParam() {
        this.effectFilterType = EffectFilterType.DEFAULT;
        this.filterName = "filter effect";
        this.filterType = 8;
        this.filterDurationType = 0;
        this.effectPath = "";
        this.stickerId = 0;
        this.longStickerId = 0;
        this.reqId = 0;
        this.longRequestId = 0;
        this.useLongId = false;
        this.needReload = false;
        this.stickerTag = "";
        this.isSyncLoadResource = false;
        this.composerTags = null;
        this.composerValues = null;
        this.multicamMode = false;
        this.stickerExtraKey = "";
        this.commandID = 0;
    }

    public VEEffectFilterParam(Parcel r100) {
        super(r100);
        this.effectFilterType = EffectFilterType.DEFAULT;
        this.effectPath = r100.readString();
        this.stickerId = r100.readInt();
        this.longStickerId = r100.readLong();
        this.reqId = r100.readInt();
        this.longRequestId = r100.readLong();
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.useLongId = r102;
        this.timeout = r100.readInt();
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.needReload = r103;
        this.stickerTag = r100.readString();
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.isSyncLoadResource = r104;
        this.composerTags = r100.createStringArray();
        this.composerValues = r100.createFloatArray();
        this.effectFilterType = EffectFilterType.values()[r100.readInt()];
        if (r100.readByte() != 0) goto L18;
        r101 = false;
    L18:
        this.multicamMode = r101;
        this.stickerExtraKey = r100.readString();
        this.commandID = r100.readLong();
        return;
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.effectPath);
        r100.writeInt(this.stickerId);
        r100.writeLong(this.longStickerId);
        r100.writeInt(this.reqId);
        r100.writeLong(this.longRequestId);
        r100.writeByte(this.useLongId ? 1 : 0);
        r100.writeInt(this.timeout);
        r100.writeByte(this.needReload ? 1 : 0);
        r100.writeString(this.stickerTag);
        r100.writeByte(this.isSyncLoadResource ? 1 : 0);
        r100.writeStringArray(this.composerTags);
        r100.writeFloatArray(this.composerValues);
        r100.writeInt(this.effectFilterType.ordinal());
        r100.writeByte(this.multicamMode ? 1 : 0);
        r100.writeString(this.stickerExtraKey);
        r100.writeLong(this.commandID);
    }
}
