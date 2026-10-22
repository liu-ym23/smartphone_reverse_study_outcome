package com.ss.ugc.live.sdk.platform.imbroadcast;

import com.alipay.sdk.m.p.e;
import com.bytedance.common.utility.collection.WeakContainer;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.ugc.live.sdk.message.data.LimitedSizeHashMap;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import omc.a;

/* JADX INFO: loaded from: classes36.dex */
public final class IMBroadcast {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, WeakContainer<a>> f458527a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/ugc/live/sdk/platform/imbroadcast/IMBroadcast$DecodeFailedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", e.f25671s, "", RemoteMessageConst.MSGID, "(Ljava/lang/String;Ljava/lang/String;)V", "platform_release"}, k = 1, mv = {1, 4, 0})
    public static final class DecodeFailedException extends Exception {
        public DecodeFailedException(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, e.f25671s);
            Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.MSGID);
            super("DecodeFailedException: [" + r100 + '_' + r101 + ']');
        }
    }

    public IMBroadcast() {
        new LimitedSizeHashMap(1024);
        this.f458527a = new HashMap();
    }

    public final void a(String r100, a r101) {
        if (r100 == null) goto L8;
        WeakContainer<a> r102 = this.f458527a.get(r100);
        if (r102 == null) goto L6;
        r102.add(r101);
        return;
    L6:
        WeakContainer<a> r103 = new WeakContainer();
        r103.add(r101);
        this.f458527a.put(r100, r103);
        return;
    }
}
