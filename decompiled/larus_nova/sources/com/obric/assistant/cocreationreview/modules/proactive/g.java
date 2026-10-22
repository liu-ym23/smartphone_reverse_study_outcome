package com.obric.assistant.cocreationreview.modules.proactive;

import android.content.Context;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.e5;
import com.obric.assistant.cocreationreview.f5;
import com.obric.assistant.cocreationreview.g5;
import com.obric.assistant.cocreationreview.h5;
import com.obric.assistant.cocreationreview.i0;
import com.obric.assistant.cocreationreview.i5;
import com.obric.assistant.cocreationreview.l5;
import com.obric.assistant.cocreationreview.s3;
import com.obric.assistant.cocreationreview.s5;
import com.obric.assistant.cocreationreview.t5;
import com.obric.assistant.cocreationreview.v0;
import com.obric.memorydata.sdk.proactive.ProactiveLabelingFeedbackConfigDto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes32.dex */
public final class g implements e5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProactiveAgentRepository f387473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<q> f387474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashSet<f5> f387475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g5 f387476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f387477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w f387478f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public v f387479g;

    @Override // com.obric.assistant.cocreationreview.e5
    public final void a() {
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final l5 b() {
        return d.f387468a.b();
    }

    public final i5 h() {
        this.f387477e++;
        List<q> r100 = this.f387474b;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        q r103 = (q) r102.next();
        a5 r104 = r103.f387511u;
        if (r104 == null) goto L8;
        Pair r105 = TuplesKt.to(r103.f387491a, r104);
    L9:
        if (r105 == null) goto L4;
        r101.add(r105);
        goto L4
    L8:
        r105 = null;
        goto L9
    L11:
        Map r106 = MapsKt.toMap(r101);
        LinkedHashMap r107 = new LinkedHashMap();
        Iterator r108 = r106.entrySet().iterator();
    L13:
        if (r108.hasNext() == false) goto L17;
        Map.Entry r109 = (Map.Entry) r108.next();
        if (((a5) r109.getValue()).f387187e == false) goto L13;
        r107.put(r109.getKey(), r109.getValue());
        goto L13
    L17:
        Set r110 = r107.keySet();
        l5 r111 = b();
        List<q> r112 = this.f387474b;
        ArrayList r113 = new ArrayList();
        Iterator<T> r114 = r112.iterator();
    L19:
        if (r114.hasNext() == false) goto L23;
        Object r115 = r114.next();
        if (r110.contains(((q) r115).f387491a) == true) goto L19;
        r113.add(r115);
        goto L19
    L23:
        List<q> r116 = this.f387474b;
        ArrayList r117 = new ArrayList();
        Iterator<T> r118 = r116.iterator();
    L25:
        if (r118.hasNext() == false) goto L29;
        Object r119 = r118.next();
        if (r110.contains(((q) r119).f387491a) == false) goto L25;
        r117.add(r119);
        goto L25
    L29:
        i5 r120 = new i5(r111, r113, r117, r106);
        int r121 = s3.f387719a;
        s3.a("provider.snapshot", "build module=" + getBusinessId().getRaw() + ", provider=" + g.class.getSimpleName() + ", version=" + this.f387477e + ", pending=" + r120.f387318b.size() + ", completed=" + r120.f387319c.size() + ", feedback=" + r120.f387320d.size());
        return r120;
    }

    public final int i() {
        LinkedHashSet<f5> r100 = this.f387475c;
        monitor-enter(r100);
        int r101 = this.f387475c.size();     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final ModuleKey getBusinessId() {
        return b().f387358a;
    }

    public g(ProactiveAgentRepository r100) {
        Intrinsics.checkNotNullParameter(r100, "repository");
        this.f387473a = r100;
        this.f387474b = CollectionsKt.emptyList();
        this.f387475c = new LinkedHashSet();
        int r101 = g5.f387291c;
        this.f387476d = g5.a.a("provider_init");
        this.f387478f = new w();
        int r102 = v.f387521d;
        this.f387479g = v.a.a();
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final void c(v0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        LinkedHashSet<f5> r101 = this.f387475c;
        monitor-enter(r101);
        boolean r102 = this.f387475c.add(r100);     // Catch: Throwable -> L12
        monitor-exit(r101);
        int r103 = s3.f387719a;
        s3.b("provider.observe", "module=" + getBusinessId().getRaw() + ", provider=" + g.class.getSimpleName() + ", added=" + r102 + ", listeners=" + i());
        if (r102 == true) goto L9;
        return;
    L9:
        if (this.f387477e <= 0) goto L18;
        i5 r104 = h();
        s3.b("provider.notify", "initial module=" + getBusinessId().getRaw() + ", pending=" + r104.f387318b.size() + ", completed=" + r104.f387319c.size());
        r100.a(r104);
        return;
    L18:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.obric.assistant.cocreationreview.modules.proactive.f, java.lang.Object] */
    @Override // com.obric.assistant.cocreationreview.e5
    public final void d(final g5 r110) {
        Intrinsics.checkNotNullParameter(r110, "request");
        this.f387476d = r110;
        w r100 = this.f387478f;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "request");
        final x r101 = new x(r100.f387525a.incrementAndGet(), r110);
        h5 r102 = g5.a(r110);
        boolean r103 = false;
        if (i() <= 0) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == true) goto L10;
        j("update_without_listener");
        int r105 = s3.f387719a;
        s3.b("provider.observe", "skipLoadWithoutListener module=" + getBusinessId().getRaw() + ", reason=" + r110.f387293b + ", sequence=" + r101.f387526a);
        return;
    L10:
        int r106 = s3.f387719a;
        s3.b("provider.observe", "updateRequest module=" + getBusinessId().getRaw() + ", provider=" + g.class.getSimpleName() + ", reason=" + r110.f387293b + ", earliest=" + r102.f387303a + ", latest=" + r102.f387304b + ", sequence=" + r101.f387526a + ", listeners=" + i());
        if (this.f387479g.f387524c.get() == false) goto L13;
        int r107 = v.f387521d;
        this.f387479g = v.a.a();
    L13:
        final v r108 = this.f387479g;
        final ?? r109 = new f(this, r101, r110);
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, "task");
        if (r108.f387524c.get() == false) goto L27;
    L24:
        if (r103 == true) goto L29;
        int r111 = s3.f387719a;
        s3.c("provider.observe", "loadSubmitRejected module=" + getBusinessId().getRaw() + ", reason=" + r110.f387293b + ", sequence=" + r101.f387526a);
        return;
    L29:
        return;
    L27:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L18
        r108.f387522a.invoke(new r(r108, r109));     // Catch: Throwable -> L18
        Object r113 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L18
    L20:
        Boolean r114 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r113) == false) goto L23;
        r113 = r114;
    L23:
        r103 = ((Boolean) r113).booleanValue();
    L18:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L5:
        r104 = false;
        goto L7
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final t5 e(s5 r110) {
        Intrinsics.checkNotNullParameter(r110, "request");
        int r100 = s3.f387719a;
        s3.b("submit.annotation", "receive module=" + getBusinessId().getRaw() + ", requestId=" + r110.f387720a + ", recordId=" + r110.f387721b + ", vote=" + r110.f387723d.getRaw() + ", reasonCount=" + r110.f387724e.size() + ", commentLength=" + r110.f387725f.length() + ", payloadHash=" + r110.f387726g.hashCode());
        if (r110.f387722c == getBusinessId()) goto L6;
        s3.c("submit.annotation", "reject module=" + getBusinessId().getRaw() + ", requestBusiness=" + r110.f387722c.getRaw() + ", reason=business_mismatch");
        return new t5(false, "业务方不匹配");
    L6:
        Iterator<T> r101 = this.f387474b.iterator();
    L8:
        if (r101.hasNext() == false) goto L12;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((q) r102).f387491a, r110.f387721b) == false) goto L8;
    L13:
        q r103 = (q) r102;
        if (r103 != null) goto L17;
        int r104 = s3.f387719a;
        s3.c("submit.annotation", "reject module=" + getBusinessId().getRaw() + ", recordId=" + r110.f387721b + ", reason=record_not_found");
        return new t5(false, "反馈数据不存在");
    L17:
        g5 r105 = this.f387476d;
        w r106 = this.f387478f;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r105, "request");
        x r111 = new x(r106.f387525a.incrementAndGet(), r105);
        int r107 = s3.f387719a;
        s3.b("submit.annotation", "invalidateObserveLoad module=" + getBusinessId().getRaw() + ", recordId=" + r110.f387721b + ", sequence=" + r111.f387526a);
        ProactiveAgentRepository r108 = this.f387473a;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r103, "record");
        Intrinsics.checkNotNullParameter(r110, "request");
        Context r109 = r108.f387463a;
        if (r109 != null) goto L20;
        boolean r112 = false;
    L21:
        if (r112 == true) goto L24;
        s3.c("submit.annotation", "reject module=" + getBusinessId().getRaw() + ", recordId=" + r110.f387721b + ", reason=remote_submit_failed");
        return new t5(false, "反馈写入失败，请稍后重试");
    L24:
        n r113 = this.f387473a.d(r105);
        s3.b("submit.annotation", "accepted module=" + getBusinessId().getRaw() + ", recordId=" + r110.f387721b);
        if (this.f387478f.a(r111, this.f387476d) == false) goto L27;
        g(r105, r113, "submit_refresh");
    L29:
        return i0.a(b());
    L27:
        s3.b("submit.annotation", "skipStaleRefresh module=" + getBusinessId().getRaw() + ", recordId=" + r110.f387721b + ", sequence=" + r111.f387526a + ", submitReason=" + r105.f387293b + ", activeReason=" + this.f387476d.f387293b);
        goto L29
    L20:
        r112 = ((Boolean) BuildersKt.runBlocking$default(null, new ProactiveAgentRepository$submitAnnotation$submitted$1(r109, r103, r110, null), 1, null)).booleanValue();
        s3.b("proactive_agent.repository", "submitAnnotation recordId=" + r103.f387491a + ", recommendId=" + r103.f387493c + ", inspirationId=" + r103.f387494d + ", vote=" + r110.f387723d.getRaw() + ", submitted=" + r112);
        goto L21
    L12:
        r102 = null;
        goto L13
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final void f(v0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        LinkedHashSet<f5> r101 = this.f387475c;
        monitor-enter(r101);
        this.f387475c.remove(r100);     // Catch: Throwable -> L10
        int r102 = this.f387475c.size();     // Catch: Throwable -> L10
        monitor-exit(r101);
        if (r102 != 0) goto L8;
        j("remove_last_observer");
    L8:
        int r103 = s3.f387719a;
        s3.b("provider.observe", "remove module=" + getBusinessId().getRaw() + ", listeners=" + r102);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void j(String r100) {
        long r101 = this.f387478f.f387525a.incrementAndGet();
        v r102 = this.f387479g;
        if (r102.f387524c.compareAndSet(false, true) == false) goto L5;
        r102.f387523b.invoke();
    L5:
        int r103 = s3.f387719a;
        s3.b("provider.observe", "releaseLoader module=" + getBusinessId().getRaw() + ", reason=" + r100 + ", sequence=" + r101);
    }

    public final void g(g5 r100, n r101, String r102) {
        if (i() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L9;
        int r104 = s3.f387719a;
        s3.b("provider.observe", "skipApplyWithoutListener module=" + getBusinessId().getRaw() + ", source=" + r102 + ", reason=" + r100.f387293b);
        return;
    L9:
        ProactiveLabelingFeedbackConfigDto r105 = r101.f387489b;
        l5 r106 = e.f387469a;
        i.f387482a.update(r105);
        this.f387474b = r101.f387488a;
        h5 r107 = g5.a(r100);
        int r108 = s3.f387719a;
        s3.b("provider.observe", "applySnapshot module=" + getBusinessId().getRaw() + ", source=" + r102 + ", reason=" + r100.f387293b + ", earliest=" + r107.f387303a + ", latest=" + r107.f387304b + ", records=" + this.f387474b.size() + ", listeners=" + i());
        i5 r109 = h();
        LinkedHashSet<f5> r110 = this.f387475c;
        monitor-enter(r110);
        List r111 = CollectionsKt.toList(this.f387475c);     // Catch: Throwable -> L18
        monitor-exit(r110);
        s3.b("provider.notify", "module=" + getBusinessId().getRaw() + ", listeners=" + r111.size() + ", pending=" + r109.f387318b.size() + ", completed=" + r109.f387319c.size());
        Iterator r112 = r111.iterator();
    L15:
        if (r112.hasNext() == false) goto L17;
        ((f5) r112.next()).a(r109);
        goto L15
    L17:
        return;
    L18:
        th = move-exception;
        throw th;
    L5:
        r103 = false;
        goto L6
    }
}
