package com.larus.bmhome.chat.component.playback;

import com.larus.bmhome.social.page.datasource.event.c;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes4.dex */
public final class MessagePlaybackHelper {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f301322n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c<xc8.b> f301323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutexImpl f301324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f301325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f301326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Message f301327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f301328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f301329g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Job> f301330h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f301331i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f301332j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CoroutineScope f301333k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function3<? super c<xc8.b>, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> f301334l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Function1<? super Continuation<? super Unit>, ? extends Object> f301335m;

    public static final class a {
    }

    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public b(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            String r102 = ExceptionsKt.stackTraceToString(r101);
            FLogger.f375446a.e("PlaybackHelper", "exception=" + r102);
        }
    }

    static {
    }

    public final boolean c() {
        int r100 = this.f301326d;
        c<xc8.b> r101 = this.f301323a;
        if (r101 == null) goto L7;
        List<xc8.b> r102 = r101.f314033a;
        if (r102 == null) goto L7;
        int r103 = r102.size();
    L9:
        if (r100 <= r103) goto L22;
        c<xc8.b> r104 = this.f301323a;
        if (r104 == null) goto L13;
        List<xc8.b> r105 = r104.f314033a;
    L14:
        List<xc8.b> r106 = r105;
        if (r106 != null) goto L17;
    L20:
        boolean r107 = true;
    L21:
        if (r107 == true) goto L22;
        return false;
    L17:
        if (r106.isEmpty() == true) goto L20;
        r107 = false;
        goto L21
    L13:
        r105 = null;
    L22:
        return true;
    L7:
        r103 = 0;
        goto L9
    }

    public MessagePlaybackHelper() {
        this.f301324b = kotlinx.coroutines.sync.b.a();
        this.f301326d = 1;
        this.f301328f = "";
        this.f301330h = new ArrayList();
        this.f301332j = "";
        b r100 = new b(CoroutineExceptionHandler.Key);
        this.f301333k = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new com.larus.bmhome.chat.component.playback.a())).plus(r100));
    }

    public static final c a(MessagePlaybackHelper r100) {
        c<xc8.b> r101 = r100.f301323a;
        if (r101 == null) goto L5;
        List<xc8.b> r102 = r101.f314033a;
    L6:
        List<xc8.b> r103 = r102;
        int r104 = 0;
        if (r103 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        if (r105 == true) goto L33;
        int r106 = r100.f301326d;
        c<xc8.b> r107 = r100.f301323a;
        if (r107 == null) goto L19;
        List<xc8.b> r108 = r107.f314033a;
        if (r108 == null) goto L19;
        r104 = r108.size();
    L19:
        if (r106 > r104) goto L35;
        c<xc8.b> r109 = r100.f301323a;
        if (r109 == null) goto L26;
        List<xc8.b> r110 = r109.f314033a;
        if (r110 == null) goto L26;
        List r111 = CollectionsKt.takeLast(r110, r100.f301326d);
    L27:
        c<xc8.b> r112 = r100.f301323a;
        if (r112 == null) goto L34;
        if (r111 != null) goto L32;
        return null;
    L32:
        return c.a(r112, r111, 0, null, null, 14);
    L34:
        return null;
    L26:
        r111 = null;
        goto L27
    L35:
        return null;
    L33:
        return null;
    L9:
        if (r103.isEmpty() == true) goto L12;
        r105 = false;
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    public final Object b(Continuation<? super Unit> r100) {
        if ((r100 instanceof MessagePlaybackHelper$cancelPlayback$1) == false) goto L7;
        MessagePlaybackHelper$cancelPlayback$1 r101 = (MessagePlaybackHelper$cancelPlayback$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L19;
        if (r105 != 2) goto L18;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L15
    L31:
        Unit r107 = (Unit) r103;     // Catch: Throwable -> L15
        r106.unlock(null);
        return Unit.INSTANCE;
    L15:
        th = th;
        kotlinx.coroutines.sync.a r108 = r106;
    L36:
        r108.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r108 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L40:
        CoroutineContext r109 = this.f301333k.getCoroutineContext();     // Catch: Throwable -> L35
        MessagePlaybackHelper$cancelPlayback$3$1 r110 = new MessagePlaybackHelper$cancelPlayback$3$1(this, null);     // Catch: Throwable -> L35
        r101.L$0 = r108;     // Catch: Throwable -> L35
        r101.label = 2;     // Catch: Throwable -> L35
        r103 = BuildersKt.withContext(r109, r110, r101);     // Catch: Throwable -> L35
        if (r103 != r104) goto L30;
        return r104;
    L30:
        r106 = r108;
    L35:
        th = th;
        goto L36
    L20:
        ResultKt.throwOnFailure(r103);
        Iterator r111 = ((ArrayList) this.f301330h).iterator();
    L22:
        if (r111.hasNext() == false) goto L24;
        Job.DefaultImpls.cancel$default((Job) r111.next(), null, 1, null);
        goto L22
    L24:
        ((ArrayList) this.f301330h).clear();
        r108 = this.f301324b;
        r101.L$0 = r108;
        r101.label = 1;
        if (r108.a(null, r101) != r104) goto L40;
        return r104;
    L7:
        r101 = new MessagePlaybackHelper$cancelPlayback$1(this, r100);
        goto L8
    }

    public final Object d(Continuation<? super Unit> r100) {
        if ((r100 instanceof MessagePlaybackHelper$showAllCase$1) == false) goto L7;
        MessagePlaybackHelper$showAllCase$1 r101 = (MessagePlaybackHelper$showAllCase$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L19;
        if (r105 != 2) goto L18;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L15
    L27:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r106.unlock(null);
        return Unit.INSTANCE;
    L15:
        th = th;
        kotlinx.coroutines.sync.a r108 = r106;
    L32:
        r108.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r108 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L36:
        MainCoroutineDispatcher r109 = Dispatchers.getMain();     // Catch: Throwable -> L31
        MessagePlaybackHelper$showAllCase$2$1 r110 = new MessagePlaybackHelper$showAllCase$2$1(this, null);     // Catch: Throwable -> L31
        r101.L$0 = r108;     // Catch: Throwable -> L31
        r101.label = 2;     // Catch: Throwable -> L31
        if (BuildersKt.withContext(r109, r110, r101) != r104) goto L26;
        return r104;
    L26:
        r106 = r108;
    L31:
        th = th;
        goto L32
    L20:
        ResultKt.throwOnFailure(r103);
        r108 = this.f301324b;
        r101.L$0 = r108;
        r101.label = 1;
        if (r108.a(null, r101) != r104) goto L36;
        return r104;
    L7:
        r101 = new MessagePlaybackHelper$showAllCase$1(this, r100);
        goto L8
    }

    public final Object e(Continuation r100) {
        if ((r100 instanceof MessagePlaybackHelper$submitMessageOneByOne$1) == false) goto L7;
        MessagePlaybackHelper$submitMessageOneByOne$1 r101 = (MessagePlaybackHelper$submitMessageOneByOne$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L19;
        if (r105 != 2) goto L18;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L15
    L27:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r106.unlock(null);
        return Unit.INSTANCE;
    L15:
        th = th;
        kotlinx.coroutines.sync.a r108 = r106;
    L32:
        r108.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r108 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L36:
        CoroutineContext r109 = this.f301333k.getCoroutineContext();     // Catch: Throwable -> L31
        MessagePlaybackHelper$submitMessageOneByOne$2$1 r110 = new MessagePlaybackHelper$submitMessageOneByOne$2$1(this, null);     // Catch: Throwable -> L31
        r101.L$0 = r108;     // Catch: Throwable -> L31
        r101.label = 2;     // Catch: Throwable -> L31
        if (BuildersKt.withContext(r109, r110, r101) != r104) goto L26;
        return r104;
    L26:
        r106 = r108;
    L31:
        th = th;
        goto L32
    L20:
        ResultKt.throwOnFailure(r103);
        r108 = this.f301324b;
        r101.L$0 = r108;
        r101.label = 1;
        if (r108.a(null, r101) != r104) goto L36;
        return r104;
    L7:
        r101 = new MessagePlaybackHelper$submitMessageOneByOne$1(this, r100);
        goto L8
    }
}
