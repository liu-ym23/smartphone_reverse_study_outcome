package com.ss.android.lark.sticker.core.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.PushCustomizedStickersRequest;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.t;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class c extends c0c.c implements e6c.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f440805e = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f440806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<e6c.b.a> f440807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f440808d;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.sdk.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f440809a;

        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f440810a;

            public a(c r100) {
                this.f440810a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                s r101 = (s) r100;
                Intrinsics.checkNotNull(r101);
                PushCustomizedStickersRequest r102 = (PushCustomizedStickersRequest) t.c(r101, CustomStickerPush$registerCustomStickerPushListener$1$1$1.INSTANCE);
                if (r102 == null) goto L19;
                c r103 = this.f440810a;
                int r104 = c.f440805e;
                r103.getClass();
                com.ss.android.lark.sticker.core.model.PushCustomizedStickersRequest r105 = new com.ss.android.lark.sticker.core.model.PushCustomizedStickersRequest(r102);     // Catch: IOException -> L14
                StringBuilder r106 = new StringBuilder("onPushStickers, size=");     // Catch: IOException -> L14
                List<Sticker> r107 = r105.f440832b;     // Catch: IOException -> L14
                Integer r108 = null;
                if (r107 == null) goto L8;
                Integer r109 = Integer.valueOf(r107.size());     // Catch: IOException -> L14
            L9:
                r106.append(r109);     // Catch: IOException -> L14
                r106.append(", operation=");     // Catch: IOException -> L14
                com.ss.android.lark.sticker.core.model.PushCustomizedStickersRequest.Operation r110 = r105.f440831a;     // Catch: IOException -> L14
                if (r110 == null) goto L12;
                r108 = Integer.valueOf(r110.getNumber());     // Catch: IOException -> L14
            L12:
                r106.append(r108);     // Catch: IOException -> L14
                Log.i("CustomStickerPush", r106.toString());     // Catch: IOException -> L14
                CoreThreadPool.getDefault().getUIExecutor().execute(new d(r103, r105));     // Catch: IOException -> L14
                return;
            L8:
                r109 = null;
            L14:
                e = move-exception;
                Log.e("CustomStickerPush", e.getMessage(), e);
                return;
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.sticker.core.impl.c$b$b, reason: collision with other inner class name */
        public static final class C5300b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5300b<T> f440811a = null;

            static {
                f440811a = new C5300b();
            }

            public C5300b() {
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Log.e("CustomStickerPush", "PUSH_CUSTOMIZED_STICKERS error", (Throwable) r100, true);
            }
        }

        public b(c r100) {
            this.f440809a = r100;
        }

        @Override // com.ss.android.lark.sdk.f.a
        public final void a() {
            Disposable r100 = this.f440809a.f440808d;
            if (r100 == null) goto L5;
            r100.dispose();
        L5:
            c r101 = this.f440809a;
            r101.f440808d = r101.f440806b.i(Command.PUSH_CUSTOMIZED_STICKERS, PushCustomizedStickersRequest.ADAPTER).subscribe(new a(this.f440809a), C5300b.f440811a);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.sticker.core.impl.c$c, reason: collision with other inner class name */
    public static final class C5301c implements com.ss.android.lark.sdk.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f440812a;

        public C5301c(c r100) {
            this.f440812a = r100;
        }

        @Override // com.ss.android.lark.sdk.f.a
        public final void a() {
            Disposable r100 = this.f440812a.f440808d;
            if (r100 == null) goto L5;
            r100.dispose();
        L5:
            this.f440812a.f440808d = null;
        }
    }

    static {
    }

    @Override // e6c.b
    public final void q7(e6c.b.a r100) {
        com.ss.android.lark.sdk.f.a(this.f440807c, r100, new b(this));
    }

    @Override // e6c.b
    public final void y1(e6c.b.a r100) {
        com.ss.android.lark.sdk.f.b(this.f440807c, r100, new C5301c(this));
    }

    @Inject
    public c(m r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "rustClient");
        super(r100);
        this.f440806b = r101;
        this.f440807c = new CopyOnWriteArrayList();
    }
}
