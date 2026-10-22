package com.obric.assistant.cocreationreview.modules.searchqa;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.obric.assistant.cocreationreview.CocreationLabelingServerClient;
import com.obric.assistant.cocreationreview.CocreationUserFeedbackAttachment;
import com.obric.assistant.cocreationreview.CocreationUserFeedbackRequest;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.e5;
import com.obric.assistant.cocreationreview.f5;
import com.obric.assistant.cocreationreview.g5;
import com.obric.assistant.cocreationreview.h5;
import com.obric.assistant.cocreationreview.i0;
import com.obric.assistant.cocreationreview.i5;
import com.obric.assistant.cocreationreview.j0;
import com.obric.assistant.cocreationreview.l5;
import com.obric.assistant.cocreationreview.s3;
import com.obric.assistant.cocreationreview.s5;
import com.obric.assistant.cocreationreview.t5;
import com.obric.assistant.cocreationreview.v0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes32.dex */
public final class m implements e5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f387555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l5 f387556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ModuleKey f387557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CocreationLabelingServerClient f387558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<c0> f387559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashSet<f5> f387560f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashMap<String, a5> f387561g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n f387562h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f387563i;

    @Override // com.obric.assistant.cocreationreview.e5
    public final void a() {
    }

    public final i5 g() {
        this.f387563i++;
        List<c0> r100 = this.f387559e;
        LinkedHashSet r101 = new LinkedHashSet();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(((c0) r102.next()).f387534a);
        goto L4
    L6:
        LinkedHashMap<String, a5> r103 = this.f387561g;
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator<Map.Entry<String, a5>> r105 = r103.entrySet().iterator();
    L8:
        if (r105.hasNext() == false) goto L12;
        Map.Entry<String, a5> r106 = r105.next();
        if (r101.contains(r106.getKey()) == false) goto L8;
        r104.put(r106.getKey(), r106.getValue());
        goto L8
    L12:
        Map r107 = MapsKt.toMap(r104);
        LinkedHashMap r108 = new LinkedHashMap();
        Iterator r109 = r107.entrySet().iterator();
    L14:
        if (r109.hasNext() == false) goto L18;
        Map.Entry r110 = (Map.Entry) r109.next();
        if (((a5) r110.getValue()).f387187e == false) goto L14;
        r108.put(r110.getKey(), r110.getValue());
        goto L14
    L18:
        Set r111 = r108.keySet();
        l5 r112 = this.f387556b;
        List<c0> r113 = this.f387559e;
        ArrayList r114 = new ArrayList();
        Iterator<T> r115 = r113.iterator();
    L20:
        if (r115.hasNext() == false) goto L24;
        Object r116 = r115.next();
        if (r111.contains(((c0) r116).f387534a) == true) goto L20;
        r114.add(r116);
        goto L20
    L24:
        List<c0> r117 = this.f387559e;
        ArrayList r118 = new ArrayList();
        Iterator<T> r119 = r117.iterator();
    L26:
        if (r119.hasNext() == false) goto L30;
        Object r120 = r119.next();
        if (r111.contains(((c0) r120).f387534a) == false) goto L26;
        r118.add(r120);
        goto L26
    L30:
        i5 r121 = new i5(r112, r114, r118, r107);
        int r122 = s3.f387719a;
        s3.a("provider.snapshot", "build module=" + this.f387557c.getRaw() + ", provider=" + m.class.getSimpleName() + ", version=" + this.f387563i + ", pending=" + r121.f387318b.size() + ", completed=" + r121.f387319c.size() + ", feedback=" + r121.f387320d.size());
        return r121;
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final l5 b() {
        return this.f387556b;
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final ModuleKey getBusinessId() {
        return this.f387557c;
    }

    public m(q r100) {
        Intrinsics.checkNotNullParameter(r100, "repository");
        this.f387555a = r100;
        l5 r101 = h.f387551a;
        this.f387556b = r101;
        this.f387557c = r101.f387358a;
        this.f387558d = new CocreationLabelingServerClient();
        this.f387559e = CollectionsKt.emptyList();
        this.f387560f = new LinkedHashSet();
        this.f387561g = new LinkedHashMap();
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [com.obric.assistant.cocreationreview.modules.searchqa.l, java.lang.Object] */
    @Override // com.obric.assistant.cocreationreview.e5
    public final void c(v0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        boolean r101 = this.f387560f.add(r100);
        int r102 = s3.f387719a;
        s3.b("provider.observe", "module=" + this.f387557c.getRaw() + ", provider=" + m.class.getSimpleName() + ", added=" + r101 + ", listeners=" + this.f387560f.size());
        if (this.f387562h != null) goto L17;
        q r103 = this.f387555a;
        ?? r104 = new l(this);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "listener");
        LinkedHashSet<Function1<List<c0>, Unit>> r105 = r103.f387570c;
        monitor-enter(r105);
        r103.f387570c.add((Function1<List<c0>, Unit>) r104);     // Catch: Throwable -> L22
        int r106 = r103.f387570c.size();     // Catch: Throwable -> L22
        monitor-exit(r105);
        r103.a();
        StringBuilder r107 = new StringBuilder("observe listeners=");
        r107.append(r106);
        r107.append(", hasSearchQaDb=");
        boolean r108 = false;
        if (r103.f387568a == null) goto L12;
        boolean r109 = true;
    L13:
        r107.append(r109);
        r107.append(", hasFeedbackDb=");
        if (r103.f387569b == null) goto L16;
        r108 = true;
    L16:
        r107.append(r108);
        s3.b("search_qa.repository.observe", r107.toString());
        this.f387562h = new n(r103, r104);
        goto L17
    L12:
        r109 = false;
    L22:
        th = move-exception;
        throw th;
    L17:
        if (r101 == true) goto L19;
        return;
    L19:
        if (this.f387563i <= 0) goto L28;
        i5 r110 = g();
        s3.b("provider.notify", "initial module=" + this.f387557c.getRaw() + ", pending=" + r110.f387318b.size() + ", completed=" + r110.f387319c.size());
        r100.a(r110);
        return;
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final void d(g5 r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        q r101 = this.f387555a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "request");
        r101.f387573f = r100;
        i(this.f387555a.c(r100));
        h5 r102 = g5.a(r100);
        int r103 = s3.f387719a;
        s3.b("provider.observe", "updateRequest module=" + this.f387557c.getRaw() + ", provider=" + m.class.getSimpleName() + ", reason=" + r100.f387293b + ", earliest=" + r102.f387303a + ", latest=" + r102.f387304b + ", records=" + this.f387559e.size() + ", listeners=" + this.f387560f.size());
        h(g());
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final t5 e(s5 r210) {
        Intrinsics.checkNotNullParameter(r210, "request");
        int r100 = s3.f387719a;
        s3.b("submit.annotation", "receive module=" + this.f387557c.getRaw() + ", requestId=" + r210.f387720a + ", recordId=" + r210.f387721b + ", vote=" + r210.f387723d.getRaw() + ", reasonCount=" + r210.f387724e.size() + ", commentLength=" + r210.f387725f.length() + ", attachmentCount=" + r210.f387727h.size() + ", payloadHash=" + r210.f387726g.hashCode());
        if (r210.f387722c == this.f387557c) goto L6;
        s3.c("submit.annotation", "reject module=" + this.f387557c.getRaw() + ", requestBusiness=" + r210.f387722c.getRaw() + ", reason=business_mismatch");
        return new t5(false, "业务方不匹配");
    L6:
        Iterator<T> r101 = this.f387559e.iterator();
    L8:
        if (r101.hasNext() == false) goto L12;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((c0) r102).f387534a, r210.f387721b) == false) goto L8;
    L13:
        c0 r103 = (c0) r102;
        if (r103 != null) goto L17;
        int r104 = s3.f387719a;
        s3.c("submit.annotation", "reject module=" + this.f387557c.getRaw() + ", recordId=" + r210.f387721b + ", reason=record_not_found");
        return new t5(false, "反馈数据不存在");
    L17:
        String r110 = UUID.randomUUID().toString();
        List r111 = CollectionsKt.toList(r210.f387724e);
        int r105 = w.f387597a[r210.f387723d.ordinal()];
        if (r105 == 1) goto L24;
        int r106 = 2;
        if (r105 != 2) goto L23;
    L25:
        Integer r112 = Integer.valueOf(r106);
        String r107 = r210.f387725f;
        String r108 = r103.f387544k;
        List<CocreationUserFeedbackAttachment> r113 = r210.f387727h;
        Gson r114 = j0.f387325a;
        Intrinsics.checkNotNullParameter(r113, "<this>");
        if ((!r113.isEmpty()) == true) goto L29;
        r113 = null;
    L29:
        if (r113 == null) goto L31;
        String r211 = GsonProtectorUtils.toJson(j0.f387325a, r113);
    L32:
        CocreationUserFeedbackRequest r109 = new CocreationUserFeedbackRequest(r110, "label_app", 3, r111, r112, r107, r108, r211, null, 256, null);
        int r115 = s3.f387719a;
        StringBuilder r116 = new StringBuilder("start recordId=");
        r116.append(r103.f387534a);
        r116.append(", requestId=");
        r116.append(r210.f387720a);
        r116.append(", module=");
        r116.append(r109.getModule());
        r116.append(", feedbackType=");
        r116.append(r109.getFeedbackType());
        r116.append(", tagCount=");
        List<String> r117 = r109.getTags();
        if (r117 != null) goto L35;
        r117 = CollectionsKt.emptyList();
    L35:
        r116.append(r117.size());
        r116.append(", contentLength=");
        String r118 = r109.getContent();
        if (r118 != null) goto L38;
        r118 = "";
    L38:
        r116.append(r118.length());
        r116.append(", attachmentCount=");
        r116.append(r210.f387727h.size());
        r116.append(", uniqId=");
        r116.append(r109.getUniqId());
        r116.append(", logId=");
        r116.append(r109.getLogId());
        s3.b("search_qa.feedback.submit", r116.toString());
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L41
        Object r120 = Result.m9449constructorimpl((dm9.a) BuildersKt.runBlocking$default(null, new SearchQaLabelingProvider$submitUserFeedback$1$1(this, r109, null), 1, null));     // Catch: Throwable -> L41
    L44:
        if (Result.m9456isSuccessimpl(r120) == false) goto L46;
        int r121 = s3.f387719a;
        s3.b("search_qa.feedback.submit", "result recordId=" + r103.f387534a + ", requestId=" + r210.f387720a + ", response=" + ((dm9.a) r120));
    L46:
        Throwable r122 = Result.m9452exceptionOrNullimpl(r120);
        if (r122 == null) goto L49;
        int r123 = s3.f387719a;
        s3.c("search_qa.feedback.submit", "failed recordId=" + r103.f387534a + ", requestId=" + r210.f387720a + ", error=" + r122.getClass().getSimpleName() + ':' + r122.getMessage());
    L49:
        q r124 = this.f387555a;
        r124.getClass();
        Intrinsics.checkNotNullParameter(r210, "request");
        a5 r125 = i0.c(r210);
        com.obric.assistant.cocreationreview.j r126 = r124.f387569b;
        if (r126 == null) goto L52;
        r126.b(r125);
    L53:
        this.f387561g.put(r210.f387721b, r125);
        int r127 = s3.f387719a;
        s3.b("search_qa.provider", "submitAnnotation saved recordId=" + r103.f387534a + ", requestId=" + r210.f387720a + ", feedbackRecordId=" + r125.f387183a);
        h(g());
        return i0.a(this.f387556b);
    L52:
        int r128 = s3.f387719a;
        s3.c("search_qa.repository", "saveFeedback skipped, reason=context_unavailable, recordId=" + r125.f387183a);
    L41:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L44
    L31:
        r211 = null;
        goto L32
    L23:
        throw new NoWhenBranchMatchedException();
    L24:
        r106 = 1;
        goto L25
    L12:
        r102 = null;
        goto L13
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final void f(v0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f387560f.remove(r100);
        int r101 = s3.f387719a;
        s3.b("provider.observe", "remove module=" + this.f387557c.getRaw() + ", listeners=" + this.f387560f.size());
        if (this.f387560f.isEmpty() == false) goto L9;
        n r102 = this.f387562h;
        if (r102 == null) goto L7;
        r102.invoke();
    L7:
        this.f387562h = null;
        return;
    }

    public final void h(i5 r100) {
        List r101 = CollectionsKt.toList(this.f387560f);
        int r102 = s3.f387719a;
        s3.b("provider.notify", "module=" + this.f387557c.getRaw() + ", listeners=" + r101.size() + ", pending=" + r100.f387318b.size() + ", completed=" + r100.f387319c.size());
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((f5) r103.next()).a(r100);
        goto L4
    }

    public final void i(List<c0> r100) {
        this.f387559e = r100;
        this.f387561g.clear();
        List<c0> r101 = this.f387559e;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        a5 r104 = ((c0) r103.next()).f387545l;
        if (r104 == null) goto L4;
        r102.add(r104);
        goto L4
    L8:
        Iterator r105 = r102.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        a5 r106 = (a5) r105.next();
        this.f387561g.put(r106.f387183a, r106);
        goto L10
    }
}
