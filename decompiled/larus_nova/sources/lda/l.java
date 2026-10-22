package lda;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.Vote;
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
import com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class l implements e5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f508812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l5 f508813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ModuleKey f508814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashSet<f5> f508815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<b0> f508816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g5 f508817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public n f508818g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f508819h;

    @Override // com.obric.assistant.cocreationreview.e5
    public final void a() {
    }

    public final i5 g() {
        this.f508819h++;
        List<b0> r100 = this.f508816e;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        a5 r103 = ((b0) r102.next()).f508799l;
        if (r103 == null) goto L4;
        r101.add(r103);
        goto L4
    L8:
        LinkedHashMap r104 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r101, 10)), 16));
        Iterator r105 = r101.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        Object r106 = r105.next();
        r104.put(((a5) r106).f387183a, r106);
        goto L10
    L12:
        LinkedHashMap r107 = new LinkedHashMap();
        Iterator r108 = r104.entrySet().iterator();
    L14:
        if (r108.hasNext() == false) goto L18;
        Map.Entry r109 = (Map.Entry) r108.next();
        if (((a5) r109.getValue()).f387187e == false) goto L14;
        r107.put(r109.getKey(), r109.getValue());
        goto L14
    L18:
        Set r110 = r107.keySet();
        l5 r111 = this.f508813b;
        List<b0> r112 = this.f508816e;
        ArrayList r113 = new ArrayList();
        Iterator<T> r114 = r112.iterator();
    L20:
        if (r114.hasNext() == false) goto L24;
        Object r115 = r114.next();
        if (r110.contains(((b0) r115).f508788a) == true) goto L20;
        r113.add(r115);
        goto L20
    L24:
        List<b0> r116 = this.f508816e;
        ArrayList r117 = new ArrayList();
        Iterator<T> r118 = r116.iterator();
    L26:
        if (r118.hasNext() == false) goto L30;
        Object r119 = r118.next();
        if (r110.contains(((b0) r119).f508788a) == false) goto L26;
        r117.add(r119);
        goto L26
    L30:
        i5 r120 = new i5(r111, r113, r117, r104);
        int r121 = s3.f387719a;
        s3.a("provider.snapshot", "build module=" + this.f508814c.getRaw() + ", provider=" + l.class.getSimpleName() + ", version=" + this.f508819h + ", pending=" + r120.f387318b.size() + ", completed=" + r120.f387319c.size() + ", feedback=" + r120.f387320d.size());
        return r120;
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final l5 b() {
        return this.f508813b;
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final ModuleKey getBusinessId() {
        return this.f508814c;
    }

    public l(q r100) {
        Intrinsics.checkNotNullParameter(r100, "repository");
        this.f508812a = r100;
        l5 r101 = e.f508808a;
        this.f508813b = r101;
        this.f508814c = r101.f387358a;
        this.f508815d = new LinkedHashSet();
        this.f508816e = CollectionsKt.emptyList();
        int r102 = g5.f387291c;
        this.f508817f = g5.a.a("provider_init");
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.Object, lda.k] */
    @Override // com.obric.assistant.cocreationreview.e5
    public final void c(v0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        boolean r101 = this.f508815d.add(r100);
        int r102 = s3.f387719a;
        s3.b("provider.observe", "module=" + this.f508814c.getRaw() + ", provider=" + l.class.getSimpleName() + ", added=" + r101 + ", listeners=" + this.f508815d.size());
        if (this.f508818g != null) goto L17;
        q r103 = this.f508812a;
        ?? r104 = new k(this);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "listener");
        LinkedHashSet<Function1<u, Unit>> r105 = r103.f508826c;
        monitor-enter(r105);
        r103.f508826c.add((Function1<u, Unit>) r104);     // Catch: Throwable -> L22
        int r106 = r103.f508826c.size();     // Catch: Throwable -> L22
        monitor-exit(r105);
        r103.a();
        StringBuilder r107 = new StringBuilder("observe listeners=");
        r107.append(r106);
        r107.append(", hasOmniDb=");
        boolean r108 = false;
        if (r103.f508824a == null) goto L12;
        boolean r109 = true;
    L13:
        r107.append(r109);
        r107.append(", hasFeedbackDb=");
        if (r103.f508825b == null) goto L16;
        r108 = true;
    L16:
        r107.append(r108);
        s3.b("omni.repository.observe", r107.toString());
        this.f508818g = new n(r103, r104);
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
        if (this.f508819h <= 0) goto L28;
        i5 r110 = g();
        s3.b("provider.notify", "initial module=" + this.f508814c.getRaw() + ", pending=" + r110.f387318b.size() + ", completed=" + r110.f387319c.size());
        r100.a(r110);
        return;
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final void d(g5 r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f508817f = r100;
        q r101 = this.f508812a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "request");
        r101.f508829f = r100;
        h5 r102 = g5.a(r100);
        int r103 = s3.f387719a;
        s3.b("provider.observe", "updateRequest module=" + this.f508814c.getRaw() + ", provider=" + l.class.getSimpleName() + ", reason=" + r100.f387293b + ", earliest=" + r102.f387303a + ", latest=" + r102.f387304b + ", listeners=" + this.f508815d.size());
        StringBuilder r104 = new StringBuilder("observe_request_update:");
        r104.append(r100.f387293b);
        i(new u(r104.toString(), this.f508812a.c(r100)));
        h(g());
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final t5 e(s5 r310) {
        Intrinsics.checkNotNullParameter(r310, "request");
        int r100 = s3.f387719a;
        s3.b("submit.annotation", "receive module=" + this.f508814c.getRaw() + ", requestId=" + r310.f387720a + ", recordId=" + r310.f387721b + ", vote=" + r310.f387723d.getRaw() + ", reasonCount=" + r310.f387724e.size() + ", commentLength=" + r310.f387725f.length() + ", payloadHash=" + r310.f387726g.hashCode());
        if (r310.f387722c == this.f508814c) goto L6;
        s3.c("submit.annotation", "reject module=" + this.f508814c.getRaw() + ", requestBusiness=" + r310.f387722c.getRaw() + ", reason=business_mismatch");
        return new t5(false, "业务方不匹配");
    L6:
        Iterator<T> r101 = this.f508816e.iterator();
    L7:
        String r110 = null;
        if (r101.hasNext() == false) goto L12;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((b0) r102).f508788a, r310.f387721b) == false) goto L7;
    L13:
        b0 r103 = (b0) r102;
        if (r103 != null) goto L17;
        int r104 = s3.f387719a;
        s3.c("submit.annotation", "reject module=" + this.f508814c.getRaw() + ", recordId=" + r310.f387721b + ", reason=record_not_found");
        return new t5(false, "反馈数据不存在");
    L17:
        String r105 = r103.f508790c;
        if ((!StringsKt.isBlank(r105)) == false) goto L20;
        String r111 = r105;
    L22:
        if (r111 != null) goto L24;
        int r106 = s3.f387719a;
        s3.c("omni.feedback.report", "skip recordId=" + r103.f508788a + ", taskId=" + r103.f508790c + ", requestId=" + r310.f387720a + ", reason=task_id_blank");
        String r210 = ", recordId=";
        String r112 = "submit.annotation";
    L71:
        q r107 = this.f508812a;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r310, "request");
        String r108 = r310.f387721b;
        Vote r109 = r310.f387723d;
        Set<String> r113 = r310.f387724e;
        String r114 = r310.f387725f;
        long r211 = System.currentTimeMillis();
        int r115 = m9a.b.f512654a;
        a5 r116 = new a5(r108, r109, r113, r114, true, r211, m9a.b.a(r310.f387729j), 64);
        com.obric.assistant.cocreationreview.j r117 = r107.f508825b;
        if (r117 == null) goto L74;
        r117.b(r116);
    L75:
        int r118 = s3.f387719a;
        s3.b("omni.provider", "submitAnnotation saved recordId=" + r103.f508788a + ", taskId=" + r103.f508790c + ", requestId=" + r310.f387720a + ", feedbackRecordId=" + r116.f387183a + ", refresh=database_observer");
        StringBuilder r119 = new StringBuilder("accepted module=");
        r119.append(this.f508814c.getRaw());
        r119.append(r210);
        r119.append(r310.f387721b);
        s3.b(r112, r119.toString());
        return i0.a(this.f508813b);
    L74:
        int r120 = s3.f387719a;
        s3.c("omni.repository", "saveFeedback skipped, reason=context_unavailable, recordId=" + r116.f387183a);
        goto L75
    L24:
        List r121 = CollectionsKt.toList(r310.f387724e);
        String r122 = r310.f387725f;
        if ((!StringsKt.isBlank(r122)) == false) goto L27;
        r110 = r122;
    L27:
        if (r110 != null) goto L29;
        r110 = "";
    L29:
        String r123 = r110;
        List r124 = CollectionsKt.toMutableList(r310.f387724e);
        Vote r125 = r310.f387723d;
        int[] r126 = s.a.f508831a;
        int r127 = r126[r125.ordinal()];
        r112 = "submit.annotation";
        r210 = ", recordId=";
        if (r127 == 1) goto L35;
        if (r127 != 2) goto L34;
        String r128 = AppConstants.BUNDLE_DISLIKE;
    L36:
        r124.add("__omni_feedback_type=".concat(r128));
        r124.add("__omni_feedback_source=label_app");
        int r129 = m9a.b.f512654a;
        Integer r130 = r310.f387729j;
        List<String> r131 = m9a.b.b(r124);
        Integer r132 = m9a.b.a(r130);
        if (r132 == null) goto L40;
        List<String> r133 = CollectionsKt.plus(r131, "__omni_feedback_amount=" + r132.intValue());
        if (r133 == null) goto L40;
    L41:
        int r134 = s3.f387719a;
        StringBuilder r135 = new StringBuilder("start recordId=");
        r135.append(r103.f508788a);
        r135.append(", taskId=");
        r135.append(r103.f508790c);
        r135.append(", requestId=");
        r135.append(r310.f387720a);
        r135.append(", vote=");
        r135.append(r310.f387723d.getRaw());
        r135.append(", uploadType=");
        int r136 = r126[r310.f387723d.ordinal()];
        if (r136 != 1) goto L44;
        String r137 = IStrategyStateSupplier.KEY_INFO_LIKE;
    L49:
        r135.append(r137);
        r135.append(", tagCount=");
        r135.append(r121.size());
        r135.append(", uploadTagCount=");
        r135.append(r133.size());
        r135.append(", contentLength=");
        r135.append(r123.length());
        r135.append(", amount=");
        Integer r138 = m9a.b.a(r310.f387729j);
        if (r138 == null) goto L52;
        int r139 = r138.intValue();
    L53:
        r135.append(r139);
        s3.b("omni.feedback.report", r135.toString());
        IAgentAppIntentIDL r140 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r140 != null) goto L77;
        s3.c("omni.feedback.report", "skip recordId=" + r103.f508788a + ", taskId=" + r103.f508790c + ", requestId=" + r310.f387720a + ", reason=ipc_null");
        goto L71
    L77:
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L62
        String r142 = "omni.feedback.report";
        r140.drainOmniUploadImagesForFeedbackWithInfo(r111, r123, r133, null, true);     // Catch: Throwable -> L60
        Object r143 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L60
    L66:
        if (Result.m9456isSuccessimpl(r143) == false) goto L68;
        Unit r144 = (Unit) r143;
        int r145 = s3.f387719a;
        s3.b(r142, "dispatched recordId=" + r103.f508788a + ", taskId=" + r103.f508790c + ", requestId=" + r310.f387720a);
    L68:
        Throwable r146 = Result.m9452exceptionOrNullimpl(r143);
        if (r146 == null) goto L71;
        int r147 = s3.f387719a;
        s3.c(r142, "failed recordId=" + r103.f508788a + ", taskId=" + r103.f508790c + ", requestId=" + r310.f387720a + ", error=" + r146.getClass().getSimpleName() + ':' + r146.getMessage());
    L60:
        th = th;
    L64:
        Result.Companion r148 = Result.Companion;
        r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L62:
        th = th;
        r142 = "omni.feedback.report";
        goto L64
    L52:
        r139 = -1;
        goto L53
    L44:
        if (r136 != 2) goto L47;
        r137 = AppConstants.BUNDLE_DISLIKE;
        goto L49
    L47:
        throw new NoWhenBranchMatchedException();
    L40:
        r133 = r131;
        goto L41
    L34:
        throw new NoWhenBranchMatchedException();
    L35:
        r128 = IStrategyStateSupplier.KEY_INFO_LIKE;
        goto L36
    L20:
        r111 = null;
        goto L22
    L12:
        r102 = null;
        goto L13
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final void f(v0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f508815d.remove(r100);
        int r101 = s3.f387719a;
        s3.b("provider.observe", "remove module=" + this.f508814c.getRaw() + ", listeners=" + this.f508815d.size());
        if (this.f508815d.isEmpty() == false) goto L9;
        n r102 = this.f508818g;
        if (r102 == null) goto L7;
        r102.invoke();
    L7:
        this.f508818g = null;
        return;
    }

    public final void h(i5 r100) {
        List r101 = CollectionsKt.toList(this.f508815d);
        int r102 = s3.f387719a;
        s3.b("provider.notify", "module=" + this.f508814c.getRaw() + ", listeners=" + r101.size() + ", pending=" + r100.f387318b.size() + ", completed=" + r100.f387319c.size());
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((f5) r103.next()).a(r100);
        goto L4
    }

    public final void i(u r100) {
        int r101 = this.f508816e.size();
        this.f508816e = r100.f508836b;
        int r102 = s3.f387719a;
        StringBuilder r103 = new StringBuilder("refreshRecords reason=");
        r103.append(r100.f508835a);
        r103.append(", previousCount=");
        r103.append(r101);
        r103.append(", currentCount=");
        r103.append(this.f508816e.size());
        r103.append(", feedback=");
        List<b0> r104 = this.f508816e;
        int r105 = 0;
        if ((r104 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r106 = r104.iterator();
        int r107 = 0;
    L9:
        if (r106.hasNext() == false) goto L18;
        if (((b0) r106.next()).f508799l == null) goto L13;
        boolean r108 = true;
    L14:
        if (r108 == false) goto L9;
        r107 = r107 + 1;
        if (r107 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L13:
        r108 = false;
        goto L14
    L18:
        r105 = r107;
    L19:
        r103.append(r105);
        r103.append(", earliest=");
        r103.append(g5.a(this.f508817f).f387303a);
        s3.b("omni.provider", r103.toString());
        return;
    L5:
        if (r104.isEmpty() == false) goto L7;
        goto L7
    }
}
