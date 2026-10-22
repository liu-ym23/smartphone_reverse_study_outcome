package com.larus.im.internal.network;

import com.larus.im.internal.protocol.bean.BreakStreamMsgUplinkBody;
import com.larus.im.internal.protocol.bean.DownlinkBody;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f349172a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f349173a = null;

        static {
            f349173a = new a();
        }

        public a() {
        }
    }

    static {
        f349172a = a.f349173a;
    }

    Object a(BreakStreamMsgUplinkBody r100, Continuation<? super e<DownlinkBody>> r101);
}
