package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.contact.v1.PushChannelNickname;
import com.larksuite.framework.thread.CoreThreadPool;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class ImSdkChatterPushImplV2 implements m6b.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f416360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f416361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f416362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f416363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f416364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f416365f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f416366g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f416367h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<com.ss.android.lark.biz.im.api.h0> f416368i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<com.ss.android.lark.biz.im.api.i0> f416369j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<w> f416370k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<com.ss.android.lark.biz.im.api.l0> f416371l;

    public static final class a {
    }

    public static final class b implements Function1<PushChannelNickname, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImSdkChatterPushImplV2 f416372a;

        public b(ImSdkChatterPushImplV2 r100) {
            this.f416372a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PushChannelNickname r100) {
            PushChannelNickname r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "pushChannelNickname");
            Channel r102 = com.ss.android.lark.parser.internal.g.a(r101.channel);     // Catch: Throwable -> L5
            CoreThreadPool.getDefault().getUIExecutor().execute(new u0(r101, this.f416372a, r102));     // Catch: Throwable -> L5
        L8:
            return Unit.INSTANCE;
        L5:
            th = move-exception;
            Log.e("ImSdkChatterPushImplV2", th, true);
            goto L8
        }
    }

    public static final class c implements Function1<Entity, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImSdkChatterPushImplV2 f416373a;

        public c(ImSdkChatterPushImplV2 r100) {
            this.f416373a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Entity r100) {
            Entity r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "entity");
            com.ss.android.lark.chat.entity.chatter.a r102 = com.ss.android.lark.parser.internal.j.b(r101, null);     // Catch: Throwable -> L13
            LinkedHashMap r103 = new LinkedHashMap();     // Catch: Throwable -> L13
            r103.putAll(new HashMap(r102.f415194a));     // Catch: Throwable -> L13
            r103.putAll(r102.a());     // Catch: Throwable -> L13
            List r104 = CollectionsKt.toList(r103.values());     // Catch: Throwable -> L13
            if (r104.isEmpty() == true) goto L16;
            CoreThreadPool.getDefault().getUIExecutor().execute(new v0(this.f416373a, r104));     // Catch: Throwable -> L13
            ImSdkChatterPushImplV2 r105 = this.f416373a;     // Catch: Throwable -> L13
            Iterator r106 = r104.iterator();     // Catch: Throwable -> L13
        L8:
            if (r106.hasNext() == false) goto L16;
            Chatter r107 = (Chatter) r106.next();     // Catch: Throwable -> L13
            CoreThreadPool.getDefault().getUIExecutor().execute(new w0(r105, r107));     // Catch: Throwable -> L13
            Log.i("ImSdkChatterPushImplV2", "onPushChatter " + r107.getId() + ", is mine chatter: " + Intrinsics.areEqual(r107.getId(), r105.f416360a));     // Catch: Throwable -> L13
            if (Intrinsics.areEqual(r107.getId(), r105.f416360a) == false) goto L8;
            CoreThreadPool.getDefault().getUIExecutor().execute(new x0(r105, r107));     // Catch: Throwable -> L13
        L16:
            return Unit.INSTANCE;
        L13:
            th = move-exception;
            Log.e("ImSdkChatterPushImplV2", th, true);
            goto L16
        }
    }

    public static final class d implements Function1<Throwable, Unit> {
        public d() {
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable r100) {
            Throwable r101 = r100;
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            Log.e("ImSdkChatterPushImplV2", r101);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // m6b.t
    public final void A5(com.ss.android.lark.biz.im.api.l0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.f416371l).remove(r100);
    }

    @Override // m6b.t
    public final void J1(com.ss.android.lark.biz.im.api.h0 r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.f416368i).contains(r100) == true) goto L8;
        ((CopyOnWriteArrayList) this.f416368i).add(r100);
        Disposable r101 = (Disposable) this.f416364e.getValue();
        Log.i("ImSdkChatterPushImplV2", "add listener to chatterDisposable");
        return;
    }

    @Override // m6b.t
    public final void h5(w r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.f416370k).remove(r100);
    }

    @Override // m6b.t
    public final void la(com.ss.android.lark.biz.im.api.i0 r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.f416369j).contains(r100) == true) goto L8;
        ((CopyOnWriteArrayList) this.f416369j).add(r100);
        Disposable r101 = (Disposable) this.f416364e.getValue();
        Log.i("ImSdkChatterPushImplV2", "add listener to chatterDisposable");
        return;
    }

    @Override // m6b.t
    public final void r8(com.ss.android.lark.biz.im.api.l0 r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.f416371l).contains(r100) == true) goto L8;
        ((CopyOnWriteArrayList) this.f416371l).add(r100);
        Disposable r101 = (Disposable) this.f416364e.getValue();
        Log.i("ImSdkChatterPushImplV2", "add listener to channelNicknameDisposable");
        return;
    }

    @Override // m6b.t
    public final void te(com.ss.android.lark.biz.im.api.h0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.f416368i).remove(r100);
    }

    @Override // m6b.t
    public final void w8(com.ss.android.lark.biz.im.api.i0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.f416369j).remove(r100);
    }

    @Override // m6b.t
    public final void x5(w r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.f416370k).contains(r100) == true) goto L8;
        ((CopyOnWriteArrayList) this.f416370k).add(r100);
        Disposable r101 = (Disposable) this.f416366g.getValue();
        Log.i("ImSdkChatterPushImplV2", "add listener to channelNicknameDisposable");
        return;
    }

    @Inject
    public ImSdkChatterPushImplV2(String r100, com.bytedance.lark.rustclient.api.l r101) {
        Intrinsics.checkNotNullParameter(r100, "currentUserId");
        Intrinsics.checkNotNullParameter(r101, "userRustClient");
        this.f416360a = r100;
        this.f416361b = r101;
        Log.i("ImSdkChatterPushImplV2", "current user id is " + r100);
        this.f416362c = new CompositeDisposable();
        this.f416363d = new d();
        LazyThreadSafetyMode r102 = LazyThreadSafetyMode.SYNCHRONIZED;
        this.f416364e = LazyKt.lazy(r102, new ImSdkChatterPushImplV2$chatterDisposable$2(this));
        this.f416365f = new c(this);
        this.f416366g = LazyKt.lazy(r102, new ImSdkChatterPushImplV2$channelNicknameDisposable$2(this));
        this.f416367h = new b(this);
        this.f416368i = new CopyOnWriteArrayList();
        this.f416369j = new CopyOnWriteArrayList();
        this.f416370k = new CopyOnWriteArrayList();
        this.f416371l = new CopyOnWriteArrayList();
    }
}
