package com.larus.uaigc.helper;

import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.platform.model.upload.UploadDataType;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f373020a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f373021a = null;

        static {
            int[] r100 = new int[ProcessFileResultCode.values().length];
            r100[ProcessFileResultCode.PREPARE_COMPRESSED_SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[ProcessFileResultCode.PREPARE_GIF_PROCESS_SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[ProcessFileResultCode.PREPARE_ORIGINAL_RES_CLONE_SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[ProcessFileResultCode.PREPARE_CLONE_SUCCESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[ProcessFileResultCode.SUCCESS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f373021a = r100;
        }
    }

    static {
    }

    public static Map a(ProcessFileResultCode r100) {
        Pair[] r101 = new Pair[3];
        r101[0] = TuplesKt.to("data_type", UploadDataType.IMAGE.getType());
        r101[1] = TuplesKt.to("transform", DownloadHelper.IDENTITY);
        if (r100 == null) goto L5;
        String r102 = r100.getValue();
    L6:
        r101[2] = TuplesKt.to("result_code", r102);
        LinkedHashMap r103 = MapsKt.linkedMapOf(r101);
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator r105 = r103.entrySet().iterator();
    L8:
        if (r105.hasNext() == false) goto L15;
        Map.Entry r106 = (Map.Entry) r105.next();
        if (((String) r106.getValue()) == null) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == false) goto L8;
        r104.put(r106.getKey(), r106.getValue());
        goto L8
    L12:
        r107 = false;
        goto L13
    L15:
        return r104;
    L5:
        r102 = null;
        goto L6
    }

    public static boolean b(String r100) {
        Object r101 = null;
        if (r100 == null) goto L19;
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L19;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        Object r103 = Result.m9449constructorimpl(UriProtector.parse(r100).getScheme());     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r103) == true) goto L17;
        r101 = r103;
    L17:
        r101 = (String) r101;
    L11:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L19:
        if (Intrinsics.areEqual(r101, "content") == false) goto L21;
        return true;
    L21:
        if (Intrinsics.areEqual(r101, "file") == true) goto L28;
        return false;
    L28:
        return true;
    }
}
