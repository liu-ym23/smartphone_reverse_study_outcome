package com.bytedance.ee.bear.quoto;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f236405a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Integer> f236406b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<Integer> f236407c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<Integer> f236408d = null;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.quoto.i0$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C3385a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f236409a = null;

            static {
                int[] r100 = new int[SingleFileQuotaConfig.values().length];
                r100[SingleFileQuotaConfig.UPLOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[SingleFileQuotaConfig.DUPLICATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[SingleFileQuotaConfig.SAVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f236409a = r100;
            }
        }
    }

    static {
        f236405a = CollectionsKt.listOf(new Integer[]{Integer.valueOf(R.string.CreationMobile_Drive_Upload_No_MaxSizeReached_var), Integer.valueOf(R.string.CreationMobile_Drive_Duplicate_No_MaxSizeReached_var), Integer.valueOf(R.string.CreationMobile_Drive_Save_No_MaxSizeReached_var)});
        f236406b = CollectionsKt.listOf(new Integer[]{Integer.valueOf(R.string.CreationMobile_Drive_Lark_Upload_Max_var), Integer.valueOf(R.string.CreationMobile_Drive_Lark_Duplicate_Max_var), Integer.valueOf(R.string.CreationMobile_Drive_Lark_Save_Max_var)});
        f236407c = CollectionsKt.listOf(new Integer[]{Integer.valueOf(R.string.CreationMobile_Drive_Lark_Upload_Max_content3), Integer.valueOf(R.string.CreationMobile_Drive_Lark_Duplicate_Max_content3), Integer.valueOf(R.string.CreationMobile_Drive_Lark_Save_Max_content3)});
        f236408d = CollectionsKt.listOf(new Integer[]{Integer.valueOf(R.string.CreationMobile_Drive_Upload_NotSupported), Integer.valueOf(R.string.CreationMobile_Drive_Duplicate_NotSupported), Integer.valueOf(R.string.CreationMobile_Drive_Save_NotSupported)});
    }

    @JvmStatic
    public static final String a(Context r100, SingleFileQuotaConfig r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != null) goto L5;
        int r102 = ((Number) ListProtector.get(f236405a, 0)).intValue();
    L16:
        return xo5.a.c(r100, R.string.CreationMobile_Drive_Upload_No_MaxSizeReached, "operation_failed", r100.getString(r102));
    L5:
        int r103 = a.C3385a.f236409a[r101.ordinal()];
        if (r103 != 1) goto L8;
        r102 = ((Number) ListProtector.get(f236405a, 0)).intValue();
        goto L16
    L8:
        if (r103 != 2) goto L10;
        r102 = ((Number) ListProtector.get(f236405a, 1)).intValue();
        goto L16
    L10:
        if (r103 == 3) goto L12;
        r102 = ((Number) ListProtector.get(f236405a, 0)).intValue();
        goto L16
    L12:
        r102 = ((Number) ListProtector.get(f236405a, 2)).intValue();
        goto L16
    }

    @JvmStatic
    public static final String b(Context r100, SingleFileQuotaConfig r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != null) goto L5;
        int r103 = ((Number) ListProtector.get(f236406b, 0)).intValue();
    L16:
        return xo5.a.c(r100, r103, DownloadSettingKeys.MaxDiskSizeLimit.MAX_SIZE, r102);
    L5:
        int r104 = a.C3385a.f236409a[r101.ordinal()];
        if (r104 != 1) goto L8;
        r103 = ((Number) ListProtector.get(f236406b, 0)).intValue();
        goto L16
    L8:
        if (r104 != 2) goto L10;
        r103 = ((Number) ListProtector.get(f236406b, 1)).intValue();
        goto L16
    L10:
        if (r104 == 3) goto L12;
        r103 = ((Number) ListProtector.get(f236406b, 0)).intValue();
        goto L16
    L12:
        r103 = ((Number) ListProtector.get(f236406b, 2)).intValue();
        goto L16
    }
}
