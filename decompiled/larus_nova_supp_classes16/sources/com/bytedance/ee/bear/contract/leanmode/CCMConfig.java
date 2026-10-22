package com.bytedance.ee.bear.contract.leanmode;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class CCMConfig implements Parcelable {
    public static final Parcelable.Creator<CCMConfig> CREATOR = null;
    public final boolean a;
    public final long b;
    public SubConfig c;
    public SubConfig d;
    public SubConfig e;
    public final SubConfig f;
    public SubConfig g;
    public SubConfig h;
    public SubConfig i;

    public static class SubConfig implements Parcelable {
        public static final Parcelable.Creator<SubConfig> CREATOR = null;
        public boolean a;

        public class a implements Parcelable.Creator<SubConfig> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SubConfig createFromParcel(Parcel r2) {
                return new SubConfig(r2);
            }

            @Override // android.os.Parcelable.Creator
            public final SubConfig[] newArray(int r1) {
                return new SubConfig[r1];
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
            return "SubConfig{isEnable=" + this.a + '}';
        }

        public SubConfig() {
            this.a = true;
        }

        public SubConfig(Parcel r2) {
            boolean r0 = true;
            this.a = true;
            if (r2.readByte() != 0) goto L6;
            r0 = false;
        L6:
            this.a = r0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            r1.writeByte(this.a ? 1 : 0);
        }
    }

    public class a implements Parcelable.Creator<CCMConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CCMConfig createFromParcel(Parcel r2) {
            return new CCMConfig(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final CCMConfig[] newArray(int r1) {
            return new CCMConfig[r1];
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
        if (this.h != null) goto L6;
        this.h = new SubConfig();
    L6:
        return this.h;
    }

    public final SubConfig c() {
        if (this.i != null) goto L6;
        this.i = new SubConfig();
    L6:
        return this.i;
    }

    public final SubConfig d() {
        if (this.c != null) goto L6;
        this.c = new SubConfig();
    L6:
        return this.c;
    }

    public final String toString() {
        return "CCMConfig{isNeedClearData=" + this.a + ", cacheDataTimeInMills=" + this.b + ", folderConfig=" + this.c + ", starConfig=" + this.d + ", offlineConfig=" + this.e + ", pinConfig=" + this.f + ", wikiConfig=" + this.g + ", digitalLoadingConfig=" + this.h + ", fetchFullDataConfig=" + this.i + '}';
    }

    public CCMConfig() {
        this.a = false;
        this.b = 86400000;
        this.c = new SubConfig();
        this.d = new SubConfig();
        this.e = new SubConfig();
        this.f = new SubConfig();
        this.g = new SubConfig();
        this.h = new SubConfig();
        this.i = new SubConfig();
    }

    public CCMConfig(Parcel r4) {
        boolean r0 = false;
        this.a = false;
        this.b = 86400000;
        this.c = new SubConfig();
        this.d = new SubConfig();
        this.e = new SubConfig();
        this.f = new SubConfig();
        this.g = new SubConfig();
        this.h = new SubConfig();
        this.i = new SubConfig();
        if (r4.readByte() == 0) goto L5;
        r0 = true;
    L5:
        this.a = r0;
        this.b = r4.readLong();
        this.c = (SubConfig) r4.readParcelable(SubConfig.class.getClassLoader());
        this.d = (SubConfig) r4.readParcelable(SubConfig.class.getClassLoader());
        this.e = (SubConfig) r4.readParcelable(SubConfig.class.getClassLoader());
        this.f = (SubConfig) r4.readParcelable(SubConfig.class.getClassLoader());
        this.g = (SubConfig) r4.readParcelable(SubConfig.class.getClassLoader());
        this.h = (SubConfig) r4.readParcelable(SubConfig.class.getClassLoader());
        this.i = (SubConfig) r4.readParcelable(SubConfig.class.getClassLoader());
    }

    public static String a(String r1) {
        return r1.concat(".isOn");
    }

    public static SubConfig e(JSONObject r2, String r3) {
        SubConfig r0 = new SubConfig();
        r0.a = r2.optBoolean(r3);     // Catch: Exception -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        tt5.a.f("CCMConfig", e, false);
        goto L7
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        r3.writeByte(this.a ? 1 : 0);
        r3.writeLong(this.b);
        r3.writeParcelable(this.c, r4);
        r3.writeParcelable(this.d, r4);
        r3.writeParcelable(this.e, r4);
        r3.writeParcelable(this.f, r4);
        r3.writeParcelable(this.g, r4);
        r3.writeParcelable(this.h, r4);
        r3.writeParcelable(this.i, r4);
    }

    public CCMConfig(boolean r3, long r4, SubConfig r6, SubConfig r7, SubConfig r8, SubConfig r9, SubConfig r10, SubConfig r11, SubConfig r12) {
        this.a = false;
        this.b = 86400000;
        this.c = new SubConfig();
        this.d = new SubConfig();
        this.e = new SubConfig();
        this.f = new SubConfig();
        this.g = new SubConfig();
        this.h = new SubConfig();
        new SubConfig();
        this.a = r3;
        this.b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.i = r11;
        this.h = r12;
    }
}
