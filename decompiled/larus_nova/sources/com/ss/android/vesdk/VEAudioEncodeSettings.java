package com.ss.android.vesdk;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class VEAudioEncodeSettings implements Parcelable {
    public static final Parcelable.Creator<VEAudioEncodeSettings> CREATOR = null;
    static final VEAudioEncodeSettings DEFAULT = null;
    private int mBps;
    private int mChannelCount;
    private ENCODE_STANDARD mCodec;
    private boolean mHwEnc;
    private int mSampleRate;

    public static final class Builder {
        private String externalSettingsJsonStr;
        private int mBps;
        private int mChannelCount;
        private ENCODE_STANDARD mCodec;
        private boolean mHwEnc;
        private int mSampleRate;
        private ENCODE_SCENE mScene;

        private void parseExternalSetting() {
            JSONObject r100 = new JSONObject(this.externalSettingsJsonStr);     // Catch: JSONException -> L14
            if (this.mScene.equals(ENCODE_SCENE.COMPILE) == false) goto L6;
            JSONObject r101 = JSONObjectProtectorUtils.getJSONObject(r100, "compile");     // Catch: JSONException -> L14
        L12:
            parseJsonSettings(r101);     // Catch: JSONException -> L14
            return;
        L6:
            if (this.mScene.equals(ENCODE_SCENE.RECORD) == false) goto L9;
            r101 = JSONObjectProtectorUtils.getJSONObject(r100, "record");     // Catch: JSONException -> L14
            goto L12
        L9:
            if (this.mScene.equals(ENCODE_SCENE.COMPILE_WATERMARK) == false) goto L11;
            r101 = JSONObjectProtectorUtils.getJSONObject(r100, "watermark_compile");     // Catch: JSONException -> L14
            goto L12
        L11:
            r101 = null;
        L14:
            e = move-exception;
            e.printStackTrace();
        }

        public VEAudioEncodeSettings Build() {
            if (this.externalSettingsJsonStr == null) goto L6;
            parseExternalSetting();
        L6:
            return new VEAudioEncodeSettings(this, null);
        }

        public Builder() {
            this.mCodec = ENCODE_STANDARD.ENCODE_STANDARD_WAV;
            this.externalSettingsJsonStr = null;
            this.mScene = ENCODE_SCENE.COMPILE;
            this.mSampleRate = 44100;
            this.mBps = 131072;
            this.mChannelCount = 2;
            this.mHwEnc = false;
        }

        public Builder(VEAudioEncodeSettings r100) {
            this.mCodec = ENCODE_STANDARD.ENCODE_STANDARD_WAV;
            this.externalSettingsJsonStr = null;
            this.mScene = ENCODE_SCENE.COMPILE;
            this.mSampleRate = 44100;
            this.mBps = 131072;
            this.mChannelCount = 2;
            this.mHwEnc = false;
            this.mCodec = VEAudioEncodeSettings.access$500(r100);
            this.mSampleRate = VEAudioEncodeSettings.access$600(r100);
            this.mBps = VEAudioEncodeSettings.access$700(r100);
            this.mChannelCount = VEAudioEncodeSettings.access$800(r100);
            this.mHwEnc = VEAudioEncodeSettings.access$900(r100);
        }

        public static /* synthetic */ ENCODE_STANDARD access$000(Builder r100) {
            return r100.mCodec;
        }

        public static /* synthetic */ int access$100(Builder r100) {
            return r100.mSampleRate;
        }

        public static /* synthetic */ int access$200(Builder r100) {
            return r100.mBps;
        }

        public static /* synthetic */ int access$300(Builder r100) {
            return r100.mChannelCount;
        }

        public static /* synthetic */ boolean access$400(Builder r100) {
            return r100.mHwEnc;
        }

        private ENCODE_STANDARD getCodecFromName(String r100) {
            ENCODE_STANDARD r101 = ENCODE_STANDARD.ENCODE_STANDARD_AAC;
            if (r100 != null) goto L6;
            return r101;
        L6:
            if ("AAC".equals(r100.toUpperCase()) == false) goto L9;
            return r101;
        L9:
            if ("PCM".equals(r100.toUpperCase()) == false) goto L12;
            return ENCODE_STANDARD.ENCODE_STANDARD_PCM;
        L12:
            if ("WAV".equals(r100.toUpperCase()) == true) goto L14;
            return r101;
        L14:
            return ENCODE_STANDARD.ENCODE_STANDARD_WAV;
        }

        private void parseJsonSettings(JSONObject r100) {
            this.mCodec = getCodecFromName(JSONObjectProtectorUtils.getString(r100, "mCodec"));     // Catch: JSONException -> L4
            this.mSampleRate = JSONObjectProtectorUtils.getInt(r100, "mSampleRate");     // Catch: JSONException -> L4
            this.mBps = JSONObjectProtectorUtils.getInt(r100, "mBps");     // Catch: JSONException -> L4
            this.mChannelCount = JSONObjectProtectorUtils.getInt(r100, "mChannelCount");     // Catch: JSONException -> L4
            this.mHwEnc = JSONObjectProtectorUtils.getBoolean(r100, "mHwEnc");     // Catch: JSONException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        public Builder setBps(int r100) {
            this.mBps = r100;
            return this;
        }

        public Builder setChannelCount(int r100) {
            this.mChannelCount = r100;
            return this;
        }

        public Builder setCodec(ENCODE_STANDARD r100) {
            this.mCodec = r100;
            return this;
        }

        public Builder setHwEnc(boolean r100) {
            this.mHwEnc = r100;
            return this;
        }

        public Builder setSampleRate(int r100) {
            this.mSampleRate = r100;
            return this;
        }

        public Builder setExternalSettings(String r100, ENCODE_SCENE r101) {
            this.externalSettingsJsonStr = r100;
            this.mScene = r101;
            return this;
        }
    }

    public static final enum ENCODE_SCENE extends Enum<ENCODE_SCENE> {
        public static final ENCODE_SCENE COMPILE = null;
        public static final ENCODE_SCENE COMPILE_WATERMARK = null;
        public static final ENCODE_SCENE RECORD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ENCODE_SCENE[] f455511a = null;

        static {
            ENCODE_SCENE r100 = new ENCODE_SCENE("RECORD", 0);
            RECORD = r100;
            ENCODE_SCENE r101 = new ENCODE_SCENE("COMPILE", 1);
            COMPILE = r101;
            ENCODE_SCENE r102 = new ENCODE_SCENE("COMPILE_WATERMARK", 2);
            COMPILE_WATERMARK = r102;
            f455511a = new ENCODE_SCENE[]{r100, r101, r102};
        }

        public static ENCODE_SCENE[] values() {
            return (ENCODE_SCENE[]) f455511a.clone();
        }

        public static ENCODE_SCENE valueOf(String r100) {
            return (ENCODE_SCENE) r27.a.a(ENCODE_SCENE.class, r100);
        }

        public ENCODE_SCENE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum ENCODE_STANDARD extends Enum<ENCODE_STANDARD> implements Parcelable {
        private static final /* synthetic */ ENCODE_STANDARD[] $VALUES = null;
        public static final Parcelable.Creator<ENCODE_STANDARD> CREATOR = null;
        public static final ENCODE_STANDARD ENCODE_STANDARD_AAC = null;
        public static final ENCODE_STANDARD ENCODE_STANDARD_PCM = null;
        public static final ENCODE_STANDARD ENCODE_STANDARD_WAV = null;

        public class a implements Parcelable.Creator<ENCODE_STANDARD> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final ENCODE_STANDARD createFromParcel(Parcel r100) {
                return ENCODE_STANDARD.values()[r100.readInt()];
            }

            @Override // android.os.Parcelable.Creator
            public final ENCODE_STANDARD[] newArray(int r100) {
                return new ENCODE_STANDARD[r100];
            }
        }

        private static /* synthetic */ ENCODE_STANDARD[] $values() {
            return new ENCODE_STANDARD[]{ENCODE_STANDARD_WAV, ENCODE_STANDARD_PCM, ENCODE_STANDARD_AAC};
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            ENCODE_STANDARD_WAV = new ENCODE_STANDARD("ENCODE_STANDARD_WAV", 0);
            ENCODE_STANDARD_PCM = new ENCODE_STANDARD("ENCODE_STANDARD_PCM", 1);
            ENCODE_STANDARD_AAC = new ENCODE_STANDARD("ENCODE_STANDARD_AAC", 2);
            $VALUES = $values();
            CREATOR = new a();
        }

        public static ENCODE_STANDARD[] values() {
            return (ENCODE_STANDARD[]) $VALUES.clone();
        }

        public static ENCODE_STANDARD valueOf(String r100) {
            return (ENCODE_STANDARD) r27.a.a(ENCODE_STANDARD.class, r100);
        }

        private ENCODE_STANDARD(String r100, int r101) {
            super(r100, r101);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(ordinal());
        }
    }

    public class a implements Parcelable.Creator<VEAudioEncodeSettings> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEAudioEncodeSettings createFromParcel(Parcel r100) {
            return new VEAudioEncodeSettings(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEAudioEncodeSettings[] newArray(int r100) {
            return new VEAudioEncodeSettings[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        DEFAULT = new VEAudioEncodeSettings();
        CREATOR = new a();
    }

    public String toString() {
        return "{\"mCodec\":" + this.mCodec + ",\"mSampleRate\":" + this.mSampleRate + ",\"mBps\":" + this.mBps + ",\"mChannelCount\":" + this.mChannelCount + ",\"mHwEnc\":" + this.mHwEnc + '}';
    }

    public VEAudioEncodeSettings() {
        this.mSampleRate = 44100;
        this.mBps = 128000;
        this.mChannelCount = 2;
        this.mHwEnc = false;
    }

    public int getBps() {
        return this.mBps;
    }

    public int getChannelCount() {
        return this.mChannelCount;
    }

    public ENCODE_STANDARD getCodec() {
        return this.mCodec;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public boolean isHwEnc() {
        return this.mHwEnc;
    }

    public VEAudioEncodeSettings(Parcel r100) {
        this.mSampleRate = 44100;
        this.mBps = 131072;
        this.mChannelCount = 2;
        boolean r101 = false;
        this.mHwEnc = false;
        this.mCodec = (ENCODE_STANDARD) r100.readParcelable(ENCODE_STANDARD.class.getClassLoader());
        this.mSampleRate = r100.readInt();
        this.mBps = r100.readInt();
        this.mChannelCount = r100.readInt();
        if (r100.readByte() == 0) goto L5;
        r101 = true;
    L5:
        this.mHwEnc = r101;
    }

    public static /* synthetic */ ENCODE_STANDARD access$500(VEAudioEncodeSettings r100) {
        return r100.mCodec;
    }

    public static /* synthetic */ int access$600(VEAudioEncodeSettings r100) {
        return r100.mSampleRate;
    }

    public static /* synthetic */ int access$700(VEAudioEncodeSettings r100) {
        return r100.mBps;
    }

    public static /* synthetic */ int access$800(VEAudioEncodeSettings r100) {
        return r100.mChannelCount;
    }

    public static /* synthetic */ boolean access$900(VEAudioEncodeSettings r100) {
        return r100.mHwEnc;
    }

    public void setBps(int r100) {
        this.mBps = r100;
    }

    public void setChannelCount(int r100) {
        this.mChannelCount = r100;
    }

    public void setCodec(ENCODE_STANDARD r100) {
        this.mCodec = r100;
    }

    public void setHwEnc(boolean r100) {
        this.mHwEnc = r100;
    }

    public void setSampleRate(int r100) {
        this.mSampleRate = r100;
    }

    private VEAudioEncodeSettings(Builder r100) {
        this.mSampleRate = 44100;
        this.mBps = 131072;
        this.mChannelCount = 2;
        this.mHwEnc = false;
        this.mCodec = Builder.access$000(r100);
        this.mSampleRate = Builder.access$100(r100);
        this.mBps = Builder.access$200(r100);
        this.mChannelCount = Builder.access$300(r100);
        this.mHwEnc = Builder.access$400(r100);
    }

    public /* synthetic */ VEAudioEncodeSettings(Builder r100, a r101) {
        this(r100);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.mCodec, r101);
        r100.writeInt(this.mSampleRate);
        r100.writeInt(this.mBps);
        r100.writeInt(this.mChannelCount);
        r100.writeByte(this.mHwEnc ? 1 : 0);
    }
}
