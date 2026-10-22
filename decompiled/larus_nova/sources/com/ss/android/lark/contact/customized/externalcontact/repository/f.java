package com.ss.android.lark.contact.customized.externalcontact.repository;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.GetChatApplicationBadgeResponse;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements com.ss.android.lark.sdk.f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f419141a = null;

    public static final class a implements com.ss.android.lark.sdk.g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f419142a = null;

        static {
            f419142a = new a();
        }

        public a() {
        }

        @Override // com.ss.android.lark.sdk.g.b
        public final void a(byte[] r100) {
            Lazy r101 = OfficeExternalContactRepository.f419134a;
            Intrinsics.checkNotNull(r100);
            GetChatApplicationBadgeResponse r102 = GetChatApplicationBadgeResponse.ADAPTER.decode(r100);     // Catch: Exception -> L5
            CoreThreadPool.getDefault().getUIExecutor().execute(new g(r102));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Log.e(e.getMessage());
        }
    }

    static {
        f419141a = new f();
    }

    public f() {
    }

    @Override // com.ss.android.lark.sdk.f.a
    public final void a() {
        com.ss.android.lark.sdk.g.e.f439875a.b(Command.PUSH_CHAT_APPLICATION_BADGE, a.f419142a);
    }
}
