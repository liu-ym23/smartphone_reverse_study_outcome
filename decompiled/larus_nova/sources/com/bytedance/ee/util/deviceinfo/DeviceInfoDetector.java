package com.bytedance.ee.util.deviceinfo;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.concurrent.atomic.AtomicBoolean;
import ku5.b;
import ku5.c;
import tt5.a;

/* JADX INFO: loaded from: classes19.dex */
public final class DeviceInfoDetector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DeviceInfo f243124a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f243125b = null;

    public static class DeviceInfo implements Parcelable {
        public static final Parcelable.Creator<DeviceInfo> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f243126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f243127b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f243128c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f243129d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f243130e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f243131f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f243132g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f243133h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f243134i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f243135j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f243136k;

        public class a implements Parcelable.Creator<DeviceInfo> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final DeviceInfo createFromParcel(Parcel r100) {
                return new DeviceInfo(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final DeviceInfo[] newArray(int r100) {
                return new DeviceInfo[r100];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public DeviceInfo() {
        }

        public DeviceInfo(Parcel r100) {
            this.f243126a = r100.readString();
            this.f243127b = r100.readString();
            this.f243128c = r100.readString();
            this.f243129d = r100.readString();
            this.f243130e = r100.readString();
            this.f243131f = r100.readString();
            this.f243132g = r100.readString();
            this.f243133h = r100.readString();
            this.f243134i = r100.readString();
            this.f243135j = r100.readString();
            this.f243136k = r100.readString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeString(this.f243126a);
            r100.writeString(this.f243127b);
            r100.writeString(this.f243128c);
            r100.writeString(this.f243129d);
            r100.writeString(this.f243130e);
            r100.writeString(this.f243131f);
            r100.writeString(this.f243132g);
            r100.writeString(this.f243133h);
            r100.writeString(this.f243134i);
            r100.writeString(this.f243135j);
            r100.writeString(this.f243136k);
        }
    }

    public DeviceInfoDetector() {
    }

    static {
        f243124a = new DeviceInfo();
        f243125b = new AtomicBoolean(false);
    }

    public static void a(Context r110) {
        long r100 = System.currentTimeMillis();     // Catch: Exception -> L23
        DeviceInfo r101 = f243124a;     // Catch: Exception -> L23
        r101.f243126a = Build.MODEL;     // Catch: Exception -> L23
        r101.f243127b = c.m();     // Catch: Exception -> L23
        r101.f243128c = c.e();     // Catch: Exception -> L23
        int r102 = new PolarisFileWrapper("/sys/devices/system/cpu/").listFiles(new b()).length;     // Catch: Exception -> L6
    L8:
        r101.f243129d = String.valueOf(r102);     // Catch: Exception -> L23
        DeviceInfo r103 = f243124a;     // Catch: Exception -> L23
        r103.f243130e = String.valueOf(c.h());     // Catch: Exception -> L23
        StatFs r104 = new StatFs(Environment.getDataDirectory().getAbsolutePath());     // Catch: Exception -> L23
        r103.f243131f = String.valueOf((r104.getBlockCountLong() * r104.getBlockSizeLong()) / 1048576);     // Catch: Exception -> L23
        String r105 = Environment.getExternalStorageDirectory().getAbsolutePath();     // Catch: Exception -> L11
    L34:
        StatFs r106 = new StatFs(r105);     // Catch: Exception -> L14
        long r111 = (r106.getBlockCountLong() * r106.getBlockSizeLong()) / 1048576;     // Catch: Exception -> L14
    L15:
        r103.f243132g = String.valueOf(r111);     // Catch: Exception -> L23
        DeviceInfo r107 = f243124a;     // Catch: Exception -> L23
        r107.f243133h = String.valueOf(Build.VERSION.SDK_INT);     // Catch: Exception -> L23
        StringBuilder r108 = new StringBuilder();     // Catch: Exception -> L23
        String[] r109 = Build.SUPPORTED_ABIS;     // Catch: Exception -> L23
        if (r109 == null) goto L26;
        int r112 = 0;
    L19:
        if (r112 >= r109.length) goto L26;
        r108.append(r109[r112]);     // Catch: Exception -> L23
        if (r112 == (r109.length - 1)) goto L25;
        r108.append(",");     // Catch: Exception -> L23
    L25:
        r112 = r112 + 1;     // Catch: Exception -> L23
    L26:
        r107.f243134i = r108.toString();     // Catch: Exception -> L23
        DeviceInfo r113 = f243124a;     // Catch: Exception -> L23
        String r114 = c.c((TelephonyManager) r110.getSystemService("phone"));     // Catch: Exception -> L29
    L30:
        r113.f243135j = r114;     // Catch: Exception -> L23
        f243124a.f243136k = Build.BRAND;     // Catch: Exception -> L23
        a.h("DeviceInfoDetector", "init device info cost time:" + (System.currentTimeMillis() - r100));     // Catch: Exception -> L23
        return;
    L29:
        a.k("DeviceInfoUtils", "No permission");     // Catch: Exception -> L23
        r114 = "";
    L14:
        r111 = -1;
    L11:
        r105 = "/sdcard";
        goto L34
    L6:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L23
        r102 = 1;
    L23:
        e = move-exception;
        a.f("DeviceInfoDetector", e, false);
    }
}
