package com.ss.android.medialib.util;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes38.dex */
public final class VEPlatformUtils {

    public static final enum VEPlatform extends Enum<VEPlatform> implements Parcelable {
        public static final Parcelable.Creator<VEPlatform> CREATOR = null;
        public static final VEPlatform PLATFORM_EXYNOS = null;
        public static final VEPlatform PLATFORM_HISI = null;
        public static final VEPlatform PLATFORM_MTK = null;
        public static final VEPlatform PLATFORM_QCOM = null;
        public static final VEPlatform PLATFORM_UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VEPlatform[] f449118a = null;

        public class a implements Parcelable.Creator<VEPlatform> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final VEPlatform createFromParcel(Parcel r100) {
                return VEPlatform.values()[r100.readInt()];
            }

            @Override // android.os.Parcelable.Creator
            public final VEPlatform[] newArray(int r100) {
                return new VEPlatform[r100];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            VEPlatform r100 = new VEPlatform("PLATFORM_UNKNOWN", 0);
            PLATFORM_UNKNOWN = r100;
            VEPlatform r101 = new VEPlatform("PLATFORM_QCOM", 1);
            PLATFORM_QCOM = r101;
            VEPlatform r102 = new VEPlatform("PLATFORM_MTK", 2);
            PLATFORM_MTK = r102;
            VEPlatform r103 = new VEPlatform("PLATFORM_HISI", 3);
            PLATFORM_HISI = r103;
            VEPlatform r104 = new VEPlatform("PLATFORM_EXYNOS", 4);
            PLATFORM_EXYNOS = r104;
            f449118a = new VEPlatform[]{r100, r101, r102, r103, r104};
            CREATOR = new a();
        }

        public static VEPlatform[] values() {
            return (VEPlatform[]) f449118a.clone();
        }

        public static VEPlatform valueOf(String r100) {
            return (VEPlatform) r27.a.a(VEPlatform.class, r100);
        }

        public VEPlatform(String r100, int r101) {
            super(r100, r101);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(ordinal());
        }
    }

    public static VEPlatform a() {
        VEPlatform r100 = VEPlatform.PLATFORM_UNKNOWN;
        String r101 = Build.HARDWARE;
        if (r101.matches("qcom") == false) goto L6;
        return VEPlatform.PLATFORM_QCOM;
    L6:
        if (r101.matches("mt[0-9]*") == false) goto L9;
        return VEPlatform.PLATFORM_MTK;
    L9:
        if (r101.matches("kirin[0-9]*") == true) goto L11;
        return r100;
    L11:
        return VEPlatform.PLATFORM_HISI;
    }
}
