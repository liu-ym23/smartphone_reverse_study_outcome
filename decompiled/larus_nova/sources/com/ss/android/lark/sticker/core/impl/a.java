package com.ss.android.lark.sticker.core.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.PushStickersResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.t;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.sticker.core.model.Sticker;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class a extends c0c.c implements e6c.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f440795e = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f440796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<e6c.a.InterfaceC5749a> f440797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f440798d;

    /* JADX INFO: renamed from: com.ss.android.lark.sticker.core.impl.a$a, reason: collision with other inner class name */
    public static final class C5297a {
    }

    public static final class b implements com.ss.android.lark.sdk.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f440799a;

        /* JADX INFO: renamed from: com.ss.android.lark.sticker.core.impl.a$b$a, reason: collision with other inner class name */
        public static final class C5298a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f440800a;

            public C5298a(a r100) {
                this.f440800a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                s r101 = (s) r100;
                Intrinsics.checkNotNull(r101);
                PushStickersResponse r102 = (PushStickersResponse) t.c(r101, AddStickerPush$registerAddStickerPushListener$1$1$1.INSTANCE);
                if (r102 == null) goto L17;
                a r103 = this.f440800a;
                int r104 = a.f440795e;
                r103.getClass();
                ArrayList r105 = new ArrayList(r102.keys);     // Catch: Exception -> L11
                long r106 = System.nanoTime();     // Catch: Exception -> L11
                ArrayList r107 = new ArrayList();     // Catch: Exception -> L11
                int r108 = 0;
            L7:
                if (r108 >= r105.size()) goto L9;
                String r109 = (String) ListProtector.get(r105, r108);     // Catch: Exception -> L11
                Sticker r110 = new Sticker();     // Catch: Exception -> L11
                r110.setKey(r109);     // Catch: Exception -> L11
                r110.setPosition(r108);     // Catch: Exception -> L11
                r110.setUpdateTime(r106);     // Catch: Exception -> L11
                r107.add(r110);     // Catch: Exception -> L11
                r108 = r108 + 1;     // Catch: Exception -> L11
                goto L7
            L9:
                Intrinsics.checkNotNull(r107);     // Catch: Exception -> L11
                CoreThreadPool.getDefault().getUIExecutor().execute(new com.ss.android.lark.sticker.core.impl.b(r103, r107));     // Catch: Exception -> L11
                return;
            L11:
                e = move-exception;
                Log.e("StickerPushUserScope", "onPushStickers error", e);
                return;
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.sticker.core.impl.a$b$b, reason: collision with other inner class name */
        public static final class C5299b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5299b<T> f440801a = null;

            static {
                f440801a = new C5299b();
            }

            public C5299b() {
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Log.e("StickerPushUserScope", "PUSH_STICKERS error", (Throwable) r100, true);
            }
        }

        public b(a r100) {
            this.f440799a = r100;
        }

        @Override // com.ss.android.lark.sdk.f.a
        public final void a() {
            Disposable r100 = this.f440799a.f440798d;
            if (r100 == null) goto L5;
            r100.dispose();
        L5:
            a r101 = this.f440799a;
            r101.f440798d = r101.f440796b.i(Command.PUSH_STICKERS, PushStickersResponse.ADAPTER).subscribe(new C5298a(this.f440799a), C5299b.f440801a);
        }
    }

    public static final class c implements com.ss.android.lark.sdk.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f440802a;

        public c(a r100) {
            this.f440802a = r100;
        }

        @Override // com.ss.android.lark.sdk.f.a
        public final void a() {
            Disposable r100 = this.f440802a.f440798d;
            if (r100 == null) goto L5;
            r100.dispose();
        L5:
            this.f440802a.f440798d = null;
        }
    }

    static {
    }

    @Override // e6c.a
    public final void I4(e6c.a.InterfaceC5749a r100) {
        com.ss.android.lark.sdk.f.b(this.f440797c, r100, new c(this));
    }

    @Override // e6c.a
    public final void X0(e6c.a.InterfaceC5749a r100) {
        com.ss.android.lark.sdk.f.a(this.f440797c, r100, new b(this));
    }

    @Inject
    public a(m r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "rustClient");
        super(r100);
        this.f440796b = r101;
        this.f440797c = new CopyOnWriteArrayList();
    }
}
