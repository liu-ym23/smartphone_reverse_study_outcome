package com.ss.android.lark.chat.api.service.impl.secret;

import a2b.i;
import com.bytedance.lark.pb.im.v1.PushSecretChatDataCorruptResponse;
import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class SecretChatDataCorruptPush implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f411642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f411643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Long, Integer> f411644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<i.a> f411645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f411646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<Throwable, Unit> f411647f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<PushSecretChatDataCorruptResponse, Unit> f411648g;

    public static final class a {
    }

    static {
    }

    @Override // a2b.i
    public final void dispose() {
        ((ConcurrentHashMap) this.f411644c).clear();
        this.f411646e.set(false);
    }

    @Override // a2b.i
    public final void u1(i.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((CopyOnWriteArrayList) this.f411645d).remove(r100);
    }

    @Override // a2b.i
    public final void yc(i.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (((CopyOnWriteArrayList) this.f411645d).contains(r100) == true) goto L10;
        ((CopyOnWriteArrayList) this.f411645d).add(r100);
        Map<Long, Integer> r101 = this.f411644c;
        r100.getClass();
        if (((ConcurrentHashMap) r101).containsKey(0L) == false) goto L11;
        Integer r102 = (Integer) ((ConcurrentHashMap) this.f411644c).get(0L);
        if (r102 == null) goto L12;
        r102.intValue();
        r100.a();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Inject
    public SecretChatDataCorruptPush(String r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "currentUserId");
        Intrinsics.checkNotNullParameter(r101, "userClient");
        this.f411642a = r100;
        this.f411643b = r101;
        this.f411644c = new ConcurrentHashMap();
        this.f411645d = new CopyOnWriteArrayList();
        this.f411646e = new AtomicBoolean(false);
        this.f411647f = SecretChatDataCorruptPush$onError$1.INSTANCE;
        this.f411648g = new SecretChatDataCorruptPush$onReceive$1(this);
    }
}
