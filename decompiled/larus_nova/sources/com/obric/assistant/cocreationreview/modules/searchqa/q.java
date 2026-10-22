package com.obric.assistant.cocreationreview.modules.searchqa;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.g5;
import com.obric.assistant.cocreationreview.h5;
import com.obric.assistant.cocreationreview.s3;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f387568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.obric.assistant.cocreationreview.j f387569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashSet<Function1<List<c0>, Unit>> f387570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Function0<Unit>> f387571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f387572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g5 f387573f;

    public final synchronized void d() {
        monitor-enter(this);
        Iterator r100 = ((ArrayList) this.f387571d).iterator();     // Catch: Throwable -> L10
    L5:
        if (r100.hasNext() == false) goto L7;
        ((Function0) r100.next()).invoke();     // Catch: Throwable -> L10
        goto L5
    L7:
        ((ArrayList) this.f387571d).clear();     // Catch: Throwable -> L10
        this.f387572e = false;     // Catch: Throwable -> L10
        s3.b("search_qa.repository.observe", "stopStoreObservers");     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void a() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.f387572e == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (this.f387568a == null) goto L12;
        Function1 r100 = new o(this);     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r100, "listener");     // Catch: Throwable -> L17
        ((ArrayList) this.f387571d).add(j.f387552b.b(r100));     // Catch: Throwable -> L17
    L12:
        if (this.f387569b == null) goto L14;
        Function1 r101 = new p(this);     // Catch: Throwable -> L17
        com.obric.assistant.cocreationreview.g r102 = com.obric.assistant.cocreationreview.j.f387323b;     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r101, "listener");     // Catch: Throwable -> L17
        ((ArrayList) this.f387571d).add(com.obric.assistant.cocreationreview.j.f387323b.b(r101));     // Catch: Throwable -> L17
    L14:
        this.f387572e = true;     // Catch: Throwable -> L17
        int r103 = s3.f387719a;     // Catch: Throwable -> L17
        s3.b("search_qa.repository.observe", "startStoreObservers subscriptions=" + ((ArrayList) this.f387571d).size());     // Catch: Throwable -> L17
        monitor-exit(this);
    }

    public q(Context r100) {
        com.obric.assistant.cocreationreview.j r101 = null;
        if (r100 == null) goto L7;
        Context r102 = r100.getApplicationContext();
        if (r102 == null) goto L7;
        j r103 = new j(r102);
    L8:
        this.f387568a = r103;
        if (r100 == null) goto L13;
        Context r104 = r100.getApplicationContext();
        if (r104 == null) goto L13;
        r101 = new com.obric.assistant.cocreationreview.j(r104);
    L13:
        this.f387569b = r101;
        this.f387570c = new LinkedHashSet();
        this.f387571d = new ArrayList();
        int r105 = g5.f387291c;
        this.f387573f = g5.a.a("repository_init");
        return;
    L7:
        r103 = null;
        goto L8
    }

    public final void b(String r100) {
        LinkedHashSet<Function1<List<c0>, Unit>> r101 = this.f387570c;
        monitor-enter(r101);
        List r102 = CollectionsKt.toList(this.f387570c);     // Catch: Throwable -> L28
        monitor-exit(r101);
        List<c0> r103 = c(this.f387573f);
        int r104 = s3.f387719a;
        StringBuilder r105 = new StringBuilder("changed reason=");
        r105.append(r100);
        r105.append(", listeners=");
        r105.append(r102.size());
        r105.append(", records=");
        r105.append(r103.size());
        r105.append(", feedback=");
        List<c0> r106 = r103;
        int r107 = 0;
        if ((r106 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r108 = r106.iterator();
        int r109 = 0;
    L13:
        if (r108.hasNext() == false) goto L22;
        if (((c0) r108.next()).f387545l == null) goto L17;
        boolean r110 = true;
    L18:
        if (r110 == false) goto L13;
        r109 = r109 + 1;
        if (r109 >= 0) goto L13;
        CollectionsKt.throwCountOverflow();
        goto L13
    L17:
        r110 = false;
        goto L18
    L22:
        r107 = r109;
    L23:
        r105.append(r107);
        s3.b("search_qa.repository.observe", r105.toString());
        Iterator r111 = r102.iterator();
    L25:
        if (r111.hasNext() == false) goto L27;
        ((Function1) r111.next()).invoke(r103);
        goto L25
    L27:
        return;
    L9:
        if (r106.isEmpty() == false) goto L11;
    L28:
        th = move-exception;
        throw th;
    }

    public final List<c0> c(g5 r210) {
        Intrinsics.checkNotNullParameter(r210, "request");
        j r100 = this.f387568a;
        Map<String, a5> r101 = null;
        if (r100 == null) goto L24;
        Intrinsics.checkNotNullParameter(r210, "request");
        SQLiteDatabase r102 = r100.f387553a.getWritableDatabase();
        ArrayList r103 = new ArrayList();
        h5 r110 = g5.a(r210);
        Cursor r104 = r102.query("search_qa_data", null, "created_at >= ? AND created_at <= ?", new String[]{String.valueOf(r110.f387303a), String.valueOf(r110.f387304b)}, null, null, "created_at DESC, record_id ASC");
        Cursor r105 = r104;     // Catch: Throwable -> L18
    L8:
        if (r105.moveToNext() == false) goto L16;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L11
        r103.add(k.b(r105));     // Catch: Throwable -> L11
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L18
        if (r108 == null) goto L8;
        int r109 = s3.f387719a;     // Catch: Throwable -> L18
        s3.c("search_qa.database", "skip invalid row error=" + r108.getMessage());     // Catch: Throwable -> L18
        goto L8
    L11:
        th = move-exception;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L18
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L18
        goto L13
    L16:
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r104, null);
        int r113 = s3.f387719a;
        s3.b("search_qa.database", "query count=" + r103.size() + ", earliest=" + r110.f387303a + ", latest=" + r110.f387304b + ", reason=" + r210.f387293b);
        List<c0> r114 = r103;
    L25:
        if (r114 != null) goto L28;
        r114 = CollectionsKt.emptyList();
    L28:
        if (r114.isEmpty() == true) goto L58;
        com.obric.assistant.cocreationreview.j r115 = this.f387569b;
        if (r115 == null) goto L37;
        List<c0> r116 = r114;
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator r118 = r116.iterator();
    L34:
        if (r118.hasNext() == false) goto L36;
        r117.add(((c0) r118.next()).f387534a);
        goto L34
    L36:
        r101 = r115.a(CollectionsKt.toSet(r117), CollectionsKt.emptyList());
    L37:
        if (r101 != null) goto L39;
        r101 = MapsKt.emptyMap();
    L39:
        List<c0> r119 = r114;
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));
        Iterator r121 = r119.iterator();
    L41:
        if (r121.hasNext() == false) goto L44;
        c0 r122 = (c0) r121.next();
        a5 r123 = r101.get(r122.f387534a);
        String r124 = r122.f387534a;
        ModuleKey r125 = r122.f387535b;
        long r126 = r122.f387536c;
        String r127 = r122.f387537d;
        String r128 = r122.f387538e;
        String r129 = r122.f387539f;
        String r130 = r122.f387540g;
        String r131 = r122.f387541h;
        String r132 = r122.f387542i;
        List<s> r133 = r122.f387543j;
        String r134 = r122.f387544k;
        String r135 = r122.f387546m;
        Intrinsics.checkNotNullParameter(r124, "id");
        Intrinsics.checkNotNullParameter(r125, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r127, "answeredAt");
        Intrinsics.checkNotNullParameter(r128, "searchDomain");
        Intrinsics.checkNotNullParameter(r130, "userQuestion");
        Intrinsics.checkNotNullParameter(r131, "answerSummary");
        Intrinsics.checkNotNullParameter(r132, "answerText");
        Intrinsics.checkNotNullParameter(r133, "localReferences");
        Intrinsics.checkNotNullParameter(r135, WsConstants.KEY_PAYLOAD);
        r120.add(new c0(r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r123, r135));
        r121 = r121;
        goto L41
    L44:
        return r120;
    L58:
        return r114;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);
        throw th;
    L24:
        r114 = null;
        goto L25
    }
}
