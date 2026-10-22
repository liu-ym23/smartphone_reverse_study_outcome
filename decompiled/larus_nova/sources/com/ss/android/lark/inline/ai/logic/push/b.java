package com.ss.android.lark.inline.ai.logic.push;

import androidx.collection.LruCache;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.pb.space.doc.v1.InlineAITaskStatus;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.inline.ai.logic.InlineAIViewModel;
import e0c.k;
import e0c.l;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends com.ss.android.lark.inline.ai.logic.push.a.AbstractC5057a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InlineAIViewModel f427333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LruCache<String, Map<String, Object>> f427334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LruCache<String, obb.b> f427335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LruCache<String, Object> f427336e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LruCache<String, Integer> f427337f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C5058b f427338g;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.logic.push.b$b, reason: collision with other inner class name */
    public static final class C5058b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, List<IGetDataCallback<obb.b>>> f427339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LruCache<String, obb.b> f427340b;

        public C5058b() {
            this.f427339a = new LinkedHashMap();
            this.f427340b = new LruCache(20);
        }

        public final synchronized void a(String r100, obb.b r101) {
            monitor-enter(this);
            List r102 = (List) ((LinkedHashMap) this.f427339a).get(r100);     // Catch: Throwable -> L14
            if (r102 == null) goto L9;
            Iterator r103 = r102.iterator();     // Catch: Throwable -> L14
        L7:
            if (r103.hasNext() == false) goto L9;
            ((IGetDataCallback) r103.next()).onSuccess(r101);     // Catch: Throwable -> L14
        L9:
            List r104 = (List) ((LinkedHashMap) this.f427339a).get(r100);     // Catch: Throwable -> L14
            if (r104 == null) goto L12;
            r104.clear();     // Catch: Throwable -> L14
        L12:
            monitor-exit(this);
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    public b(InlineAIViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "inlineAIViewModel");
        this.f427333b = r100;
        this.f427334c = new LruCache(20);
        this.f427335d = new LruCache(20);
        this.f427336e = new LruCache(20);
        this.f427337f = new LruCache(20);
        this.f427338g = new C5058b();
    }

    public static final obb.b c(b r100, String r101) {
        monitor-enter(r100);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (r100.f427336e.get(r101) == null) goto L7;
        monitor-exit(r100);
        return null;
    L7:
        obb.b r102 = r100.f427335d.get(r101);     // Catch: Throwable -> L18
        if (r102 == null) goto L11;
        monitor-exit(r100);
    L22:
        return r102;
    L11:
        sbb.c.f541290a.getClass();     // Catch: Throwable -> L18
        r102 = sbb.c.e(r101);     // Catch: Throwable -> L18
        if (r102 == null) goto L14;
        r100.f427335d.put(r101, r102);     // Catch: Throwable -> L18
    L15:
        monitor-exit(r100);
        goto L22
    L14:
        r100.f427336e.put(r101, new Object());     // Catch: Throwable -> L18
        goto L15
    }

    @Override // slb.d.a
    public final void a(InlineAITaskStatus r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "data");
        if (CollectionsKt.listOf(new String[]{"processing", "success"}).contains(r110.task_status) == false) goto L5;
        String r100 = r110.unique_task_id;
        int r101 = (int) r110.seq_id.longValue();
        String r102 = r110.content;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.f427333b), Dispatchers.getIO(), null, new UrlRecognizeFilter$extractDocsUrl$1(r102, r100, r101, this, null), 2, null);
    L5:
        b(r110, false);
    }

    public static final Object d(b r100, obb.b r101, Continuation r102) {
        r100.getClass();
        final j r103 = new j(IntrinsicsKt.intercepted(r102), 1);
        r103.C();
        C5058b r104 = r100.f427338g;
        IGetDataCallback<obb.b> r105 = new UrlRecognizeFilter$requestDocsMeta$2$1(r103);
        monitor-enter(r104);
        Intrinsics.checkNotNullParameter(r101, "docsMetaInfo");     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r105, "callback");     // Catch: Throwable -> L22
        String r106 = r101.getType() + '_' + r101.f522638b;     // Catch: Throwable -> L22
        obb.b r107 = r104.f427340b.get(r106);     // Catch: Throwable -> L22
        if (r107 == null) goto L10;
        r104.a(r106, r107);     // Catch: Throwable -> L22
        monitor-exit(r104);
    L18:
        Object r108 = r103.B();
        if (r108 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L21:
        return r108;
    L10:
        if (r104.f427339a.containsKey(r106) == false) goto L16;
        List r109 = (List) ((LinkedHashMap) r104.f427339a).get(r106);     // Catch: Throwable -> L22
        if (r109 == null) goto L14;
        r109.add(r105);     // Catch: Throwable -> L22
    L14:
        monitor-exit(r104);
        goto L18
    L16:
        r104.f427339a.put(r106, CollectionsKt.mutableListOf(new IGetDataCallback[]{r105}));     // Catch: Throwable -> L22
        qbb.c r110 = new qbb.c(null);     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r110, "userScopeView");     // Catch: Throwable -> L22
        l r111 = r110.provideComponent();     // Catch: Throwable -> L22
        r110.e9();     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(qbb.a.class, "userScopeApi");     // Catch: Throwable -> L22
        ((qbb.a) k.b(r111, qbb.a.class)).a(r101).subscribe(new c(r104, r106), new d(r104, r106));     // Catch: Throwable -> L22
        monitor-exit(r104);
    L22:
        th = move-exception;
        throw th;
    }
}
