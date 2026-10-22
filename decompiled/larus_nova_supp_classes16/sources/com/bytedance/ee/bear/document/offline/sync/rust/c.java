package com.bytedance.ee.bear.document.offline.sync.rust;

import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.document.offline.sync.CommonRNPreloadStrategy;
import com.bytedance.ee.bear.document.offline.sync.DocxPreloadStrategyV2;
import com.bytedance.ee.bear.document.offline.sync.l0;
import com.bytedance.ee.bear.document.offline.sync.preloadexecutor.subblock.SubBlockType;
import com.bytedance.ee.bear.document.offline.sync.preloadtask.PreloadSubblock;
import com.bytedance.ee.bear.document.offline.sync.q;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.space.doc.v1.CCMPreloadCompleteNotify;
import com.bytedance.lark.pb.space.doc.v1.CCMPreloadSubBlockData;
import com.bytedance.lark.pb.space.doc.v1.CCMRustSetDataRequest;
import com.ss.android.lark.sdk.g;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public static final c a = null;
    public static volatile boolean b;

    public static final class a implements g.b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void a(byte[] r6) {
            c r0 = c.a;
            Intrinsics.checkNotNull(r6);
            r0.getClass();
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
            AccountService$Account r3 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();     // Catch: Throwable -> L11
            if (r3 != null) goto L6;
        L9:
            tt5.a.d("DocsRustPreloadPushReceiver", "[rust_preload] invalid account");     // Catch: Throwable -> L11
            return;
        L6:
            if (r3.hasLogin() == false) goto L9;
            CCMRustSetDataRequest r7 = (CCMRustSetDataRequest) CCMRustSetDataRequest.ADAPTER.decode(r6);     // Catch: Throwable -> L11
            tt5.a.h("DocsRustPreloadPushReceiver", "[rust_preload] receive set-data key=" + du5.b.g(r7.key) + ", token=" + du5.b.g(r7.obj_token));     // Catch: Throwable -> L11
            int r1 = com.bytedance.ee.bear.document.offline.sync.rust.a.a;     // Catch: Throwable -> L11
            Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L11
            Object r8 = Result.constructor-impl(com.bytedance.ee.bear.document.offline.sync.rust.a.a(r3, r7));     // Catch: Throwable -> L11
        L13:
            Throwable r9 = Result.exceptionOrNull-impl(r8);
            if (r9 == null) goto L18;
            tt5.a.e("DocsRustPreloadPushReceiver", "handleSetDataPush error", r9, false);
            return;
        L18:
            return;
        L11:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L13
        }
    }

    public static final class b implements g.b {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void a(byte[] r4) {
            c r0 = c.a;
            Intrinsics.checkNotNull(r4);
            r0.getClass();
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
            CCMPreloadCompleteNotify r5 = (CCMPreloadCompleteNotify) CCMPreloadCompleteNotify.ADAPTER.decode(r4);     // Catch: Throwable -> L5
            tt5.a.h("DocsRustPreloadPushReceiver", "[rust_preload] receive complete type=" + r5.complete_type + ", token=" + du5.b.g(r5.docx_token) + ", code=" + r5.code);     // Catch: Throwable -> L5
            c.b(r5.complete_type, r5.docx_token, r5.code.intValue());     // Catch: Throwable -> L5
            Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L7:
            Throwable r7 = Result.exceptionOrNull-impl(r6);
            if (r7 == null) goto L13;
            tt5.a.e("DocsRustPreloadPushReceiver", "handleCompletePush error", r7, false);
            return;
        L13:
            return;
        L5:
            th = move-exception;
            Result.Companion r1 = Result.Companion;
            r6 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.offline.sync.rust.c$c, reason: collision with other inner class name */
    public static final class C0087c implements g.b {
        public static final C0087c a = null;

        static {
            a = new C0087c();
        }

        public C0087c() {
        }

        public final void a(byte[] r5) {
            c r0 = c.a;
            Intrinsics.checkNotNull(r5);
            r0.getClass();
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
            CCMPreloadSubBlockData r6 = (CCMPreloadSubBlockData) CCMPreloadSubBlockData.ADAPTER.decode(r5);     // Catch: Throwable -> L11
            tt5.a.h("DocsRustPreloadPushReceiver", "[rust_preload] receive subblock token=" + du5.b.g(r6.docx_token) + ", resCount=" + r6.res_list.size() + ", embedCount=" + r6.embed_doc_list.size());     // Catch: Throwable -> L11
            q r1 = l0.a(e.o.b);     // Catch: Throwable -> L11
            Unit r3 = null;
            if ((r1 instanceof DocxPreloadStrategyV2) == false) goto L6;
            DocxPreloadStrategyV2 r4 = (DocxPreloadStrategyV2) r1;     // Catch: Throwable -> L11
        L7:
            if (r4 == null) goto L9;
            int r7 = com.bytedance.ee.bear.document.offline.sync.rust.b.a;     // Catch: Throwable -> L11
            Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L11
            PreloadSubblock r8 = com.bytedance.ee.bear.document.offline.sync.rust.b.a(r6);     // Catch: Throwable -> L11
            Intrinsics.checkNotNullParameter(r8, "data");     // Catch: Throwable -> L11
            r4.C(r8, null);     // Catch: Throwable -> L11
            r3 = Unit.INSTANCE;     // Catch: Throwable -> L11
        L9:
            Object r9 = Result.constructor-impl(r3);     // Catch: Throwable -> L11
        L13:
            Throwable r10 = Result.exceptionOrNull-impl(r9);
            if (r10 == null) goto L19;
            tt5.a.e("DocsRustPreloadPushReceiver", "handleSubBlockPush error", r10, false);
            return;
        L19:
            return;
        L6:
            r4 = null;
        L11:
            th = move-exception;
            Result.Companion r11 = Result.Companion;
            r9 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L13
        }
    }

    static {
        a = new c();
    }

    public c() {
    }

    @JvmStatic
    public static final void a() {
        if (b == false) goto L5;
        return;
    L5:
        c r0 = a;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (b == false) goto L11;
        monitor-exit(r0);
        return;
    L11:
        g r1 = g.e.a;     // Catch: Throwable -> L14
        r1.b(Command.CCM_RUST_SET_DATA, a.a);     // Catch: Throwable -> L14
        r1.b(Command.CCM_PUSH_PRELOAD_COMPLETE, b.a);     // Catch: Throwable -> L14
        r1.b(Command.CCM_PUSH_PRELOAD_SUBBLOCK, C0087c.a);     // Catch: Throwable -> L14
        tt5.a.h("DocsRustPreloadPushReceiver", "[rust_preload] register push");     // Catch: Throwable -> L14
        b = true;     // Catch: Throwable -> L14
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r0);
    }

    public static void b(String r4, String r5, int r6) {
        int r0 = com.bytedance.ee.bear.document.offline.sync.rust.b.a;
        if (Intrinsics.areEqual(r4, SubBlockType.ALL_DATA_COMPLETE.getSubBlockType()) == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r4, "SHEETS_DATA_COMPLETE") == false) goto L14;
        List r2 = CollectionsKt.listOf(Integer.valueOf(e.h.b));
    L15:
        Iterator r3 = r2.iterator();
    L17:
        if (r3.hasNext() == false) goto L24;
        int r7 = ((Number) r3.next()).intValue();
        a.getClass();
        q r8 = l0.a(r7);
        if ((r8 instanceof CommonRNPreloadStrategy) == false) goto L21;
        CommonRNPreloadStrategy r9 = (CommonRNPreloadStrategy) r8;
    L22:
        if (r9 == null) goto L17;
        r9.w(r4, r5, r6);
        goto L17
    L21:
        r9 = null;
        goto L22
    L24:
        return;
    L14:
        r2 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(e.o.b), Integer.valueOf(e.m.b)});
        goto L15
    L5:
        if (Intrinsics.areEqual(r4, "SHEETS_DATA_COMPLETE") == true) goto L8;
        r1 = false;
        goto L9
    }
}
