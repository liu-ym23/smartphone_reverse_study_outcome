package com.bytedance.ee.bear.contract.leanmode;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public class CCMConfig implements Parcelable {
    public static final Parcelable.Creator<CCMConfig> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f217109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f217110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SubConfig f217111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SubConfig f217112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SubConfig f217113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SubConfig f217114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SubConfig f217115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SubConfig f217116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SubConfig f217117i;

    public static class SubConfig implements Parcelable {
        public static final Parcelable.Creator<SubConfig> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f217118a;

        public class a implements Parcelable.Creator<SubConfig> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SubConfig createFromParcel(Parcel r100) {
                return new SubConfig(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final SubConfig[] newArray(int r100) {
                return new SubConfig[r100];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public final String toString() {
            return "SubConfig{isEnable=" + this.f217118a + '}';
        }

        public SubConfig() {
            this.f217118a = true;
        }

        public SubConfig(Parcel r100) {
            boolean r101 = true;
            this.f217118a = true;
            if (r100.readByte() != 0) goto L6;
            r101 = false;
        L6:
            this.f217118a = r101;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeByte(this.f217118a ? 1 : 0);
        }
    }

    public class a implements Parcelable.Creator<CCMConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CCMConfig createFromParcel(Parcel r100) {
            return new CCMConfig(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final CCMConfig[] newArray(int r100) {
            return new CCMConfig[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final SubConfig b() {
        if (this.f217116h != null) goto L6;
        this.f217116h = new SubConfig();
    L6:
        return this.f217116h;
    }

    public final SubConfig c() {
        if (this.f217117i != null) goto L6;
        this.f217117i = new SubConfig();
    L6:
        return this.f217117i;
    }

    public final SubConfig d() {
        if (this.f217111c != null) goto L6;
        this.f217111c = new SubConfig();
    L6:
        return this.f217111c;
    }

    public final String toString() {
        return "CCMConfig{isNeedClearData=" + this.f217109a + ", cacheDataTimeInMills=" + this.f217110b + ", folderConfig=" + this.f217111c + ", starConfig=" + this.f217112d + ", offlineConfig=" + this.f217113e + ", pinConfig=" + this.f217114f + ", wikiConfig=" + this.f217115g + ", digitalLoadingConfig=" + this.f217116h + ", fetchFullDataConfig=" + this.f217117i + '}';
    }

    public CCMConfig() {
        this.f217109a = false;
        this.f217110b = 86400000;
        this.f217111c = new SubConfig();
        this.f217112d = new SubConfig();
        this.f217113e = new SubConfig();
        this.f217114f = new SubConfig();
        this.f217115g = new SubConfig();
        this.f217116h = new SubConfig();
        this.f217117i = new SubConfig();
    }

    public CCMConfig(Parcel r100) {
        boolean r101 = false;
        this.f217109a = false;
        this.f217110b = 86400000;
        this.f217111c = new SubConfig();
        this.f217112d = new SubConfig();
        this.f217113e = new SubConfig();
        this.f217114f = new SubConfig();
        this.f217115g = new SubConfig();
        this.f217116h = new SubConfig();
        this.f217117i = new SubConfig();
        if (r100.readByte() == 0) goto L5;
        r101 = true;
    L5:
        this.f217109a = r101;
        this.f217110b = r100.readLong();
        this.f217111c = (SubConfig) r100.readParcelable(SubConfig.class.getClassLoader());
        this.f217112d = (SubConfig) r100.readParcelable(SubConfig.class.getClassLoader());
        this.f217113e = (SubConfig) r100.readParcelable(SubConfig.class.getClassLoader());
        this.f217114f = (SubConfig) r100.readParcelable(SubConfig.class.getClassLoader());
        this.f217115g = (SubConfig) r100.readParcelable(SubConfig.class.getClassLoader());
        this.f217116h = (SubConfig) r100.readParcelable(SubConfig.class.getClassLoader());
        this.f217117i = (SubConfig) r100.readParcelable(SubConfig.class.getClassLoader());
    }

    public static String a(String r100) {
        return r100.concat(".isOn");
    }

    public static SubConfig e(JSONObject r100, String r101) {
        SubConfig r102 = new SubConfig();
        r102.f217118a = r100.optBoolean(r101);     // Catch: Exception -> L5
    L7:
        return r102;
    L5:
        e = move-exception;
        tt5.a.f("CCMConfig", e, false);
        goto L7
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeByte(this.f217109a ? 1 : 0);
        r100.writeLong(this.f217110b);
        r100.writeParcelable(this.f217111c, r101);
        r100.writeParcelable(this.f217112d, r101);
        r100.writeParcelable(this.f217113e, r101);
        r100.writeParcelable(this.f217114f, r101);
        r100.writeParcelable(this.f217115g, r101);
        r100.writeParcelable(this.f217116h, r101);
        r100.writeParcelable(this.f217117i, r101);
    }

    public CCMConfig(boolean r100, long r101, SubConfig r102, SubConfig r103, SubConfig r104, SubConfig r105, SubConfig r110, SubConfig r111, SubConfig r112) {
        this.f217109a = false;
        this.f217110b = 86400000;
        this.f217111c = new SubConfig();
        this.f217112d = new SubConfig();
        this.f217113e = new SubConfig();
        this.f217114f = new SubConfig();
        this.f217115g = new SubConfig();
        this.f217116h = new SubConfig();
        new SubConfig();
        this.f217109a = r100;
        this.f217110b = r101;
        this.f217111c = r102;
        this.f217112d = r103;
        this.f217113e = r104;
        this.f217114f = r105;
        this.f217115g = r110;
        this.f217117i = r111;
        this.f217116h = r112;
    }
}
