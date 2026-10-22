package com.larus.im.internal.jni.model;

import com.larus.im.internal.jni.bean.OMNIAVFrameExt;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import juc.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wt7.a;
import wt7.c;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0004"}, d2 = {"toOMNIAVFrameExt", "Lcom/larus/im/internal/jni/bean/OMNIAVFrameExt;", "", "toJsonString", "omnisdk-av_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class OmniAVFrameKtxKt {
    public static final String toJsonString(OMNIAVFrameExt r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        c r101 = a.f561230a;
        d<OMNIAVFrameExt> r102 = OMNIAVFrameExt.Companion.serializer();
        r101.getClass();
        String r103 = c.b(r100, r102);
        if (r103 != null) goto L6;
        return "";
    L6:
        return r103;
    }

    public static final OMNIAVFrameExt toOMNIAVFrameExt(String r210) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        c r100 = a.f561230a;
        d<OMNIAVFrameExt> r101 = OMNIAVFrameExt.Companion.serializer();
        r100.getClass();
        OMNIAVFrameExt r102 = (OMNIAVFrameExt) c.a(r210, r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        return new OMNIAVFrameExt(null, null, false, false, false, 0, 0, null, null, 0, 0, 0, UnixStat.PERM_MASK, null);
    }
}
