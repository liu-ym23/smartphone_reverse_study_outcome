package com.bytedance.ee.bear.office.common.upload;

import android.content.Context;
import android.icu.text.MessageFormat;
import android.os.Build;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k0 {
    public static final k0 a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[OfficeUploadBannerState.values().length];
            r0[OfficeUploadBannerState.UPLOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            r0[OfficeUploadBannerState.WARNING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L39:
            r0[OfficeUploadBannerState.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[OfficeUploadBannerState.IDLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L10:
            a = r0;
            int[] r1 = new int[OfficeUploadStatus.values().length];
            r1[OfficeUploadStatus.UNSTARTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L35:
            r1[OfficeUploadStatus.UPLOADING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L25:
            r1[OfficeUploadStatus.FINISH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L33:
            r1[OfficeUploadStatus.FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L15:
            b = r1;
        }
    }

    static {
        a = new k0();
    }

    public k0() {
    }

    public static OfficeUploadBannerState a(List r3) {
        Intrinsics.checkNotNullParameter(r3, "items");
        if (r3.isEmpty() == true) goto L5;
        OfficeUploadBannerState r0 = OfficeUploadBannerState.SUCCESS;
        Iterator r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L19;
        OfficeUploadStatus r1 = ((u) r4.next()).d;
        if (r1 == OfficeUploadStatus.UPLOADING) goto L18;
        if (r1 == OfficeUploadStatus.UNSTARTED) goto L18;
        if (r1 != OfficeUploadStatus.FAILED) goto L8;
        r0 = OfficeUploadBannerState.WARNING;
    L18:
        return OfficeUploadBannerState.UPLOADING;
    L19:
        return r0;
    L5:
        return OfficeUploadBannerState.IDLE;
    }

    public static String c(long r3) {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(r3 / 1024.0f)}, 1));
    }

    public static String d(long r3) {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Float.valueOf((r3 / 1024.0f) / 1024.0f)}, 1));
    }

    public static String b(Context r17, List r18) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "items");
        int r2 = a.a[a(r18).ordinal()];
        int r4 = 0;
        if (r2 != 1) goto L5;
        List r3 = r18;
        if ((r3 instanceof Collection) == true) goto L71;
    L73:
        Iterator r5 = r3.iterator();
        int r6 = 0;
    L75:
        if (r5.hasNext() == false) goto L87;
        OfficeUploadStatus r7 = ((u) r5.next()).d;
        if (r7 != OfficeUploadStatus.FINISH) goto L79;
    L82:
        boolean r8 = true;
    L83:
        if (r8 == false) goto L75;
        r6 = r6 + 1;
        if (r6 >= 0) goto L75;
        CollectionsKt.throwCountOverflow();
        goto L75
    L79:
        if (r7 == OfficeUploadStatus.FAILED) goto L82;
        r8 = false;
        goto L83
    L87:
        r4 = r6;
    L89:
        return StringsKt.replace$default(StringsKt.replace$default(r17.getString(2131889458), "{{num}}", String.valueOf(r4), false, 4, null), "{{total}}", String.valueOf(r18.size()), false, 4, null);
    L71:
        if (r3.isEmpty() == false) goto L73;
    L5:
        if (r2 != 2) goto L7;
        List r0 = r18;
        boolean r9 = r0 instanceof Collection;
        if (r9 == true) goto L33;
    L35:
        Iterator r10 = r0.iterator();
        int r11 = 0;
    L37:
        if (r10.hasNext() == false) goto L46;
        if (((u) r10.next()).d != OfficeUploadStatus.FINISH) goto L41;
        boolean r12 = true;
    L42:
        if (r12 == false) goto L37;
        r11 = r11 + 1;
        if (r11 >= 0) goto L37;
        CollectionsKt.throwCountOverflow();
        goto L37
    L41:
        r12 = false;
    L46:
        if (r9 == true) goto L48;
    L50:
        Iterator r1 = r0.iterator();
        int r13 = 0;
    L52:
        if (r1.hasNext() == false) goto L61;
        if (((u) r1.next()).d != OfficeUploadStatus.FAILED) goto L56;
        boolean r14 = true;
    L57:
        if (r14 == false) goto L52;
        r13 = r13 + 1;
        if (r13 >= 0) goto L52;
        CollectionsKt.throwCountOverflow();
        goto L52
    L56:
        r14 = false;
    L61:
        String r15 = r17.getString(2131889417);
        if (Build.VERSION.SDK_INT < 24) goto L122;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L65
        return new MessageFormat(r15, Locale.getDefault()).format(MapsKt.mapOf(new Pair[]{TuplesKt.to("num1", Integer.valueOf(r11)), TuplesKt.to("num2", Integer.valueOf(r13))}));
    L65:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L122:
        return r17.getResources().getQuantityString(2131755038, r11, new Object[]{Integer.valueOf(r11)}) + ", " + r17.getResources().getQuantityString(2131755021, r13, new Object[]{Integer.valueOf(r13)});
    L48:
        if (r0.isEmpty() == false) goto L50;
        r13 = 0;
        goto L61
    L33:
        if (r0.isEmpty() == false) goto L35;
        r11 = 0;
        goto L46
    L7:
        if (r2 != 3) goto L9;
        List r20 = r18;
        if ((r20 instanceof Collection) == true) goto L16;
    L18:
        Iterator r21 = r20.iterator();
        int r22 = 0;
    L20:
        if (r21.hasNext() == false) goto L121;
        if (((u) r21.next()).d != OfficeUploadStatus.FINISH) goto L24;
        boolean r23 = true;
    L25:
        if (r23 == false) goto L20;
        r22 = r22 + 1;
        if (r22 >= 0) goto L20;
        CollectionsKt.throwCountOverflow();
        goto L20
    L24:
        r23 = false;
    L121:
        return r17.getResources().getQuantityString(2131755038, r22, new Object[]{Integer.valueOf(r22)});
    L16:
        if (r20.isEmpty() == false) goto L18;
        r22 = 0;
        goto L121
    L9:
        if (r2 != 4) goto L12;
        return "";
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public static String e(long r4, Long r6) {
        String r0 = d(r4);
        if (Intrinsics.areEqual(r0, "0.0") == false) goto L19;
        if (r6 != null) goto L6;
    L8:
        String r1 = c(r4);
        if (Intrinsics.areEqual(r1, "0.0") == false) goto L17;
        if (r6 == null) goto L15;
        if (Intrinsics.areEqual(c(r6.longValue()), "0.0") == false) goto L17;
    L15:
        return r4 + ".0B";
    L17:
        return r1 + "KB";
    L6:
        if (Intrinsics.areEqual(d(r6.longValue()), "0.0") == true) goto L8;
    L19:
        return r0 + "MB";
    }
}
