package com.bytedance.sync.v2.protocal;

import android.content.Context;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import hg7.e;
import kotlin.jvm.internal.Intrinsics;
import xf7.t;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f270533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f270534b;

    @Override // hg7.e
    public final BsyncProtocol B(byte[] r100) {
        if (r100 != null) goto L10;
        return null;
    L10:
        return BsyncProtocol.ADAPTER.decode(r100);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // hg7.e
    public final byte[] L(BsyncProtocol r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return BsyncProtocol.ADAPTER.encode(r100);
    }

    public a(int r100, int r101) {
        this.f270533a = r100;
        this.f270534b = r101;
    }

    @Override // hg7.e
    public final WsChannelMsg P(Context r100, BsyncProtocol r101) {
        byte[] r102 = BsyncProtocol.ADAPTER.encode(r101);
        if (r100 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        if (cg7.b.c(r100).b().a() == false) goto L20;
        byte[] r103 = NetworkClient.compressWithgzip(r102);
        if (r103 == null) goto L20;
        if (r103.length != 0) goto L12;
        boolean r104 = true;
    L14:
        if ((!r104) == false) goto L20;
        int r105 = r102.length;
        int r106 = r103.length;
        Integer r107 = com.bytedance.sync.v2.utils.a.a(r101);
        if (r107 == null) goto L18;
        int r108 = r107.intValue();
    L19:
        t.c(r105, r106, r108);
        String r109 = DownloadHelper.GZIP;
        r102 = r103;
    L22:
        return WsChannelMsg.Builder.create(this.f270533a).setPayload(r102).setMethod(2).setService(this.f270534b).setPayloadEncoding(r109).setPayloadType(r109).build();
    L18:
        r108 = -1;
        goto L19
    L12:
        r104 = false;
    L20:
        r109 = "pb";
        goto L22
    }
}
