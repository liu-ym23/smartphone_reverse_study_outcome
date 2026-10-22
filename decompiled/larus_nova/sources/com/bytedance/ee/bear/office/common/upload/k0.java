package com.bytedance.ee.bear.office.common.upload;

import android.content.Context;
import android.icu.text.MessageFormat;
import android.os.Build;
import androidx.camera.core.processing.util.GLUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k0 f235400a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f235401a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f235402b = null;

        static {
            int[] r100 = new int[OfficeUploadBannerState.values().length];
            r100[OfficeUploadBannerState.UPLOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            r100[OfficeUploadBannerState.WARNING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L39:
            r100[OfficeUploadBannerState.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[OfficeUploadBannerState.IDLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L10:
            f235401a = r100;
            int[] r101 = new int[OfficeUploadStatus.values().length];
            r101[OfficeUploadStatus.UNSTARTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L35:
            r101[OfficeUploadStatus.UPLOADING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L25:
            r101[OfficeUploadStatus.FINISH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L33:
            r101[OfficeUploadStatus.FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L15:
            f235402b = r101;
        }
    }

    static {
        f235400a = new k0();
    }

    public k0() {
    }

    public static OfficeUploadBannerState a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        if (r100.isEmpty() == true) goto L5;
        OfficeUploadBannerState r101 = OfficeUploadBannerState.SUCCESS;
        Iterator r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L19;
        OfficeUploadStatus r103 = ((u) r102.next()).f235429d;
        if (r103 == OfficeUploadStatus.UPLOADING) goto L18;
        if (r103 == OfficeUploadStatus.UNSTARTED) goto L18;
        if (r103 != OfficeUploadStatus.FAILED) goto L8;
        r101 = OfficeUploadBannerState.WARNING;
    L18:
        return OfficeUploadBannerState.UPLOADING;
    L19:
        return r101;
    L5:
        return OfficeUploadBannerState.IDLE;
    }

    public static String c(long r100) {
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(r100 / 1024.0f)}, 1));
    }

    public static String d(long r100) {
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Float.valueOf((r100 / 1024.0f) / 1024.0f)}, 1));
    }

    public static String b(Context r110, List r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "items");
        int r100 = a.f235401a[a(r111).ordinal()];
        int r101 = 0;
        if (r100 != 1) goto L5;
        List r102 = r111;
        if ((r102 instanceof Collection) == true) goto L71;
    L73:
        Iterator r103 = r102.iterator();
        int r104 = 0;
    L75:
        if (r103.hasNext() == false) goto L87;
        OfficeUploadStatus r105 = ((u) r103.next()).f235429d;
        if (r105 != OfficeUploadStatus.FINISH) goto L79;
    L82:
        boolean r106 = true;
    L83:
        if (r106 == false) goto L75;
        r104 = r104 + 1;
        if (r104 >= 0) goto L75;
        CollectionsKt.throwCountOverflow();
        goto L75
    L79:
        if (r105 == OfficeUploadStatus.FAILED) goto L82;
        r106 = false;
        goto L83
    L87:
        r101 = r104;
    L89:
        return StringsKt.replace$default(StringsKt.replace$default(r110.getString(R.string.LarkCCM_Doubao_Drive_UploadingProgress_Toast), "{{num}}", String.valueOf(r101), false, 4, null), "{{total}}", String.valueOf(r111.size()), false, 4, null);
    L71:
        if (r102.isEmpty() == false) goto L73;
    L5:
        if (r100 != 2) goto L7;
        List r107 = r111;
        boolean r108 = r107 instanceof Collection;
        if (r108 == true) goto L33;
    L35:
        Iterator r109 = r107.iterator();
        int r112 = 0;
    L37:
        if (r109.hasNext() == false) goto L46;
        if (((u) r109.next()).f235429d != OfficeUploadStatus.FINISH) goto L41;
        boolean r113 = true;
    L42:
        if (r113 == false) goto L37;
        r112 = r112 + 1;
        if (r112 >= 0) goto L37;
        CollectionsKt.throwCountOverflow();
        goto L37
    L41:
        r113 = false;
    L46:
        if (r108 == true) goto L48;
    L50:
        Iterator r114 = r107.iterator();
        int r115 = 0;
    L52:
        if (r114.hasNext() == false) goto L61;
        if (((u) r114.next()).f235429d != OfficeUploadStatus.FAILED) goto L56;
        boolean r116 = true;
    L57:
        if (r116 == false) goto L52;
        r115 = r115 + 1;
        if (r115 >= 0) goto L52;
        CollectionsKt.throwCountOverflow();
        goto L52
    L56:
        r116 = false;
    L61:
        String r117 = r110.getString(R.string.LarkCCM_Doubao_Drive_BatchUploadResult_Toast);
        if (Build.VERSION.SDK_INT < 24) goto L122;
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L65
        return new MessageFormat(r117, Locale.getDefault()).format(MapsKt.mapOf(new Pair[]{TuplesKt.to("num1", Integer.valueOf(r112)), TuplesKt.to("num2", Integer.valueOf(r115))}));
    L65:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L122:
        return r110.getResources().getQuantityString(R.plurals.LarkCCM_Doubao_Drive_UploadedCount_Toast, r112, new Object[]{Integer.valueOf(r112)}) + ", " + r110.getResources().getQuantityString(R.plurals.Doc_List_UploadedFail, r115, new Object[]{Integer.valueOf(r115)});
    L48:
        if (r107.isEmpty() == false) goto L50;
        r115 = 0;
        goto L61
    L33:
        if (r107.isEmpty() == false) goto L35;
        r112 = 0;
        goto L46
    L7:
        if (r100 != 3) goto L9;
        List r120 = r111;
        if ((r120 instanceof Collection) == true) goto L16;
    L18:
        Iterator r121 = r120.iterator();
        int r122 = 0;
    L20:
        if (r121.hasNext() == false) goto L121;
        if (((u) r121.next()).f235429d != OfficeUploadStatus.FINISH) goto L24;
        boolean r123 = true;
    L25:
        if (r123 == false) goto L20;
        r122 = r122 + 1;
        if (r122 >= 0) goto L20;
        CollectionsKt.throwCountOverflow();
        goto L20
    L24:
        r123 = false;
    L121:
        return r110.getResources().getQuantityString(R.plurals.LarkCCM_Doubao_Drive_UploadedCount_Toast, r122, new Object[]{Integer.valueOf(r122)});
    L16:
        if (r120.isEmpty() == false) goto L18;
        r122 = 0;
        goto L121
    L9:
        if (r100 != 4) goto L12;
        return "";
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public static String e(long r100, Long r101) {
        String r102 = d(r100);
        if (Intrinsics.areEqual(r102, GLUtils.VERSION_UNKNOWN) == false) goto L19;
        if (r101 != null) goto L6;
    L8:
        String r103 = c(r100);
        if (Intrinsics.areEqual(r103, GLUtils.VERSION_UNKNOWN) == false) goto L17;
        if (r101 == null) goto L15;
        if (Intrinsics.areEqual(c(r101.longValue()), GLUtils.VERSION_UNKNOWN) == false) goto L17;
    L15:
        return r100 + ".0B";
    L17:
        return r103 + "KB";
    L6:
        if (Intrinsics.areEqual(d(r101.longValue()), GLUtils.VERSION_UNKNOWN) == true) goto L8;
    L19:
        return r102 + "MB";
    }
}
