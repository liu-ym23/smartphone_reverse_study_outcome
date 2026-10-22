package com.bytedance.ee.android.file.picker.lib.v2.util;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.FileEntry;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.ss.android.lark.log.Log;
import f06.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes15.dex */
public final class FilterKt {
    public static ParcelFileDescriptor a(ContentResolver r210, Uri r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, "r"};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r104 = r111.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r111[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r111;
        d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r210, r101, "android.os.ParcelFileDescriptor", r110);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r210, r211, "r");
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r111 = r114;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static final Object b(Context r100, List<FileEntry> r101, String r102, Continuation<? super List<FileEntry>> r110) {
        if ((r110 instanceof FilterKt$filterNotOpenable$1) == false) goto L7;
        FilterKt$filterNotOpenable$1 r103 = (FilterKt$filterNotOpenable$1) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r111 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        long r107 = r103.J$0;
        int r108 = r103.I$0;
        String r109 = (String) r103.L$0;
        ResultKt.throwOnFailure(r111);
        int r112 = r108;
        r102 = r109;
        Object r113 = r111;
    L18:
        List r114 = (List) r113;
        Log.i(r102, "result count:" + r112 + ", du:" + (SystemClock.uptimeMillis() - r107));
        return r114;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        r112 = r101.size();
        Log.i(r102, "list count:" + r112);
        long r115 = SystemClock.uptimeMillis();
        r103.L$0 = r102;
        r103.I$0 = r112;
        r103.J$0 = r115;
        r103.label = 1;
        Object r116 = CoroutineScopeKt.coroutineScope(new FilterKt$filter$2(r101, r100, null), r103);
        if (r116 != r105) goto L17;
        return r105;
    L17:
        r113 = r116;
        r107 = r115;
    L7:
        r103 = new FilterKt$filterNotOpenable$1(r110);
        goto L8
    }
}
