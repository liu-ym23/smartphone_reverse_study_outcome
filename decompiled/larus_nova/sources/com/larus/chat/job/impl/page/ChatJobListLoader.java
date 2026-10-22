package com.larus.chat.job.impl.page;

import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.larus.im.bean.job.AIJob;
import com.larus.im.bean.job.AIJobChainResult;
import com.larus.im.bean.job.AIJobListQuery;
import com.larus.im.bean.job.AIJobListResult;
import com.larus.im.bean.job.AIJobRecommendResult;
import com.larus.im.bean.job.AIJobRequestState;
import com.larus.im.bean.job.AIJobRequestStatus;
import com.larus.im.bean.job.AIJobRequestType;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.core.job.AIJobServiceImpl;
import com.larus.im.service.AIJobObserver;
import com.larus.im.service.IAIJobService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.GroupingKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class ChatJobListLoader implements AIJobObserver {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f325083t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IAIJobService f325084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<j, Unit> f325085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f325086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f325087d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AIJobRequestState f325088e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<AIJob> f325089f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f325090g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f325091h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f325092i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f325093j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Set<? extends AIJobRequestType> f325094k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f325095l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f325096m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f325097n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f325098o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f325099p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f325100q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Set<String> f325101r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f325102s;

    public static final class a {
        public a() {
        }

        public static final String a(List r110) {
            int r100 = ChatJobListLoader.f325083t;
            StringBuilder r101 = new StringBuilder();
            r101.append(CollectionsKt.joinToString$default(CollectionsKt.take(r110, 5), null, "[", "]", 0, null, new q(), 25, null));
            if (r110.size() <= 5) goto L5;
            String r111 = "...+" + (r110.size() - 5);
        L6:
            r101.append(r111);
            return r101.toString();
        L5:
            r111 = "";
            goto L6
        }

        public static final String b(List r100) {
            int r101 = ChatJobListLoader.f325083t;
            if (r100.isEmpty() == false) goto L6;
            return "empty";
        L6:
            return CollectionsKt.joinToString$default(CollectionsKt.sortedWith(GroupingKt.eachCount(new r(r100)).entrySet(), new s()), null, "[", "]", 0, null, new p(), 25, null);
        }

        public static final String c(AIJob r100) {
            int r101 = ChatJobListLoader.f325083t;
            return "id=" + e(r100.getJobId()) + ",type=" + r100.getJobType() + ",status=" + r100.getStatus() + ",contentLength=" + r100.getContent().length() + ",extLength=" + r100.getExt().length();
        }

        public static final String d(IIMError r100) {
            int r101 = ChatJobListLoader.f325083t;
            StringBuilder r102 = new StringBuilder("code=");
            r102.append(r100.getCode());
            r102.append(" tips=");
            r102.append(r100.getTips());
            r102.append(" exception=");
            Throwable r103 = r100.getException();
            if (r103 == null) goto L5;
            String r104 = r103.getClass().getSimpleName();
        L6:
            r102.append(r104);
            return r102.toString();
        L5:
            r104 = null;
            goto L6
        }

        public static String e(String r100) {
            String r101 = StringsKt.takeLast(r100, 6);
            if (StringsKt.isBlank(r101) == false) goto L6;
            return "blank";
        L6:
            return r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f325103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f325104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f325105c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f325106d;

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f325103a == r101.f325103a) goto L12;
            return false;
        L12:
            if (this.f325104b == r101.f325104b) goto L15;
            return false;
        L15:
            if (this.f325105c == r101.f325105c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f325106d, r101.f325106d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f325103a * 31) + this.f325104b) * 31;
            long r101 = this.f325105c;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            String r103 = this.f325106d;
            if (r103 != null) goto L5;
            int r104 = 0;
        L7:
            return r102 + r104;
        L5:
            r104 = r103.hashCode();
            goto L7
        }

        public final String toString() {
            return "LocalJobPageQuery(jobType=" + this.f325103a + ", status=" + this.f325104b + ", anchorCreateTime=" + this.f325105c + ", anchorJobId=" + this.f325106d + ')';
        }

        public /* synthetic */ b(int r100) {
            this(0, 0, 0, null);
        }

        public b(int r100, int r101, long r102, String r103) {
            this.f325103a = r100;
            this.f325104b = r101;
            this.f325105c = r102;
            this.f325106d = r103;
        }
    }

    public static abstract class c {

        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IIMError f325107a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f325107a, ((a) r100).f325107a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f325107a.hashCode();
            }

            public final String toString() {
                return "Failure(error=" + this.f325107a + ')';
            }

            public a(IIMError r100) {
                Intrinsics.checkNotNullParameter(r100, "error");
                this.f325107a = r100;
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final AIJobListResult f325108a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f325108a, ((b) r100).f325108a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f325108a.hashCode();
            }

            public final String toString() {
                return "Success(result=" + this.f325108a + ')';
            }

            public b(AIJobListResult r100) {
                Intrinsics.checkNotNullParameter(r100, "result");
                this.f325108a = r100;
            }
        }

        public c() {
        }
    }

    public final class d implements IIMCallback<AIJobChainResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<AIJobRequestType, Unit> f325109a;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return true;
        }

        public d(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "onComplete");
            this.f325109a = r100;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            FLogger r101 = FLogger.f375446a;
            StringBuilder r102 = new StringBuilder("pullJobChain failed ");
            int r103 = ChatJobListLoader.f325083t;
            r102.append(a.d(r100));
            r101.e("ChatJobListLoader", r102.toString());
            gz8.h.b(r100);
            this.f325109a.invoke(AIJobRequestType.JOB_CHAIN);
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(AIJobChainResult r100) {
            AIJobChainResult r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            FLogger r102 = FLogger.f375446a;
            StringBuilder r103 = new StringBuilder("pullJobChain success fetched=");
            r103.append(r101.getFetchedCount());
            r103.append(" changed=");
            int r104 = ChatJobListLoader.f325083t;
            r103.append(a.a(r101.getChangedJobIds()));
            r103.append(" cursorBlank=");
            r103.append(StringsKt.isBlank(r101.getCursor()));
            r102.i("ChatJobListLoader", r103.toString());
            this.f325109a.invoke(AIJobRequestType.JOB_CHAIN);
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f325110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f325111b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final IIMError f325112c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (this.f325110a == r101.f325110a) goto L12;
            return false;
        L12:
            if (this.f325111b == r101.f325111b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f325112c, r101.f325112c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.f325110a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = ((r100 * 31) + this.f325111b) * 31;
            IIMError r102 = this.f325112c;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "RemotePullOutcome(didChange=" + this.f325110a + ", successfulRequestCount=" + this.f325111b + ", firstError=" + this.f325112c + ')';
        }

        public e(boolean r100, int r101, IIMError r102) {
            this.f325110a = r100;
            this.f325111b = r101;
            this.f325112c = r102;
        }
    }

    public static final class f implements IIMCallback<AIJobListResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f325113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChatJobListLoader f325114b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f325115c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f325116d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f325117e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function1<c, Unit> f325118f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f325119g;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return true;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            if (this.f325113a == true) goto L5;
            ChatJobListLoader r101 = this.f325114b;
            r101.f325086c = true;
            r101.f325087d = true;
            r101.f325089f = CollectionsKt.emptyList();
            this.f325114b.f325102s = false;
        L6:
            FLogger r102 = FLogger.f375446a;
            StringBuilder r103 = new StringBuilder("loadLocalJobs failed ");
            int r104 = ChatJobListLoader.f325083t;
            r103.append(a.d(r100));
            r102.e("ChatJobListLoader", r103.toString());
            if (this.f325119g == false) goto L9;
            gz8.h.b(r100);
        L9:
            ChatJobListLoader r105 = this.f325114b;
            boolean r106 = this.f325117e;
            r105.f325090g = false;
            if (r106 == false) goto L12;
            r105.d();
        L12:
            Function1<c, Unit> r107 = this.f325118f;
            if (r107 == null) goto L15;
            r107.invoke(new c.a(r100));
        L15:
            ChatJobListLoader r108 = this.f325114b;
            if (r108.f325091h == false) goto L19;
            r108.f325091h = false;
            ChatJobListLoader.g(r108, AiBotPollingAuthResult.STATUS_PENDING, 14);
            return;
        L19:
            return;
        L5:
            ChatJobListLoader r109 = this.f325114b;
            r109.f325092i = false;
            r109.f325093j = null;
            goto L6
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(AIJobListResult r110) {
            AIJobListResult r111 = r110;
            Intrinsics.checkNotNullParameter(r111, "result");
            if (this.f325113a == false) goto L18;
            List<AIJob> r100 = this.f325114b.f325089f;
            List<AIJob> r101 = r111.getJobs();
            if (r101.isEmpty() == true) goto L19;
            LinkedHashSet r102 = new LinkedHashSet();
            Iterator<T> r103 = r100.iterator();
        L9:
            if (r103.hasNext() == false) goto L11;
            r102.add(((AIJob) r103.next()).getJobId());
            goto L9
        L11:
            List<AIJob> r104 = r100;
            ArrayList r105 = new ArrayList();
            Iterator<T> r106 = r101.iterator();
        L13:
            if (r106.hasNext() == false) goto L17;
            Object r107 = r106.next();
            if (r102.add(((AIJob) r107).getJobId()) == false) goto L13;
            r105.add(r107);
            goto L13
        L17:
            r100 = CollectionsKt.plus(r104, r105);
        L19:
            AIJob r108 = (AIJob) CollectionsKt.lastOrNull(r111.getJobs());
            ChatJobListLoader r109 = this.f325114b;
            String r112 = null;
            if (r111.getHasMore() == false) goto L23;
            if (r108 == null) goto L23;
            b r113 = this.f325116d;
            b r114 = new b(r113.f325103a, r113.f325104b, r108.getCreateTime(), r108.getJobId());
        L24:
            r109.f325093j = r114;
            ChatJobListLoader r115 = this.f325114b;
            if (r115.f325093j == null) goto L27;
            boolean r116 = true;
        L28:
            r115.f325092i = r116;
            FLogger r117 = FLogger.f375446a;
            StringBuilder r118 = new StringBuilder("loadLocalJobs page success reason=");
            r118.append(this.f325115c);
            r118.append(" pageCount=");
            r118.append(r111.getJobs().size());
            r118.append(" totalCount=");
            r118.append(r100.size());
            r118.append(" hasMore=");
            r118.append(r111.getHasMore());
            r118.append(" append=");
            r118.append(this.f325113a);
            r118.append(" jobType=");
            r118.append(this.f325116d.f325103a);
            r118.append(" status=");
            r118.append(this.f325116d.f325104b);
            r118.append(" anchorCreateTime=");
            r118.append(this.f325116d.f325105c);
            r118.append(" anchorJobId=");
            String r119 = this.f325116d.f325106d;
            if (r119 == null) goto L31;
            int r120 = ChatJobListLoader.f325083t;
            r112 = a.e(r119);
        L31:
            r118.append(r112);
            r118.append(" statuses=");
            int r121 = ChatJobListLoader.f325083t;
            r118.append(a.b(r111.getJobs()));
            r117.i("ChatJobListLoader", r118.toString());
            if (r111.getHasMore() == false) goto L35;
            if (r108 != null) goto L35;
            r117.e("ChatJobListLoader", "loadLocalJobs hasMore with empty page, reason=" + this.f325115c + " totalCount=" + r100.size());
        L35:
            ChatJobListLoader r122 = this.f325114b;
            r122.f325086c = true;
            r122.f325087d = false;
            r122.f325089f = r100;
            r117.i("ChatJobListLoader", "loadLocalJobs success reason=" + this.f325115c + " count=" + r100.size() + " statuses=" + a.b(r100));
            ChatJobListLoader r123 = this.f325114b;
            r123.f325096m = false;
            r123.f325090g = false;
            String r124 = this.f325115c;
            boolean r125 = this.f325113a;
            boolean r126 = r123.f325092i;
            if (r125 == false) goto L38;
        L41:
            boolean r127 = true;
        L42:
            if (r126 == false) goto L44;
            r123.f325102s = false;
        L69:
            if (this.f325117e == false) goto L71;
            this.f325114b.d();
        L71:
            Function1<c, Unit> r128 = this.f325118f;
            if (r128 == null) goto L74;
            r128.invoke(new c.b(r111));
        L74:
            ChatJobListLoader r129 = this.f325114b;
            if (r129.f325091h == false) goto L89;
            r129.f325091h = false;
            ChatJobListLoader.g(r129, AiBotPollingAuthResult.STATUS_PENDING, 14);
            return;
        L89:
            return;
        L44:
            r123.f325102s = false;
            r123.f325097n = true;
            if (r125 == true) goto L65;
            List<AIJob> r130 = r123.f325089f;
            if ((r130 instanceof Collection) == true) goto L49;
        L51:
            Iterator<T> r131 = r130.iterator();
        L53:
            if (r131.hasNext() == false) goto L62;
            AIJob r132 = (AIJob) r131.next();
            if (r132.getJobType() == 2) goto L57;
        L59:
            boolean r133 = false;
        L60:
            if (r133 == false) goto L53;
            boolean r134 = true;
        L63:
            if (r134 == false) goto L65;
            r123.f325099p = true;
            goto L69
        L57:
            if (r132.getStatus() != 1) goto L59;
            r133 = true;
        L62:
            r134 = false;
            goto L63
        L49:
            if (r130.isEmpty() == false) goto L51;
        L65:
            if (r127 == false) goto L69;
            r123.i(r124);
            goto L69
        L38:
            if (r123.f325102s == true) goto L41;
            r127 = false;
            goto L42
        L27:
            r116 = false;
        L23:
            r114 = null;
            goto L24
        L18:
            r100 = r111.getJobs();
            goto L19
        }

        /* JADX WARN: Multi-variable type inference failed */
        public f(boolean r100, ChatJobListLoader r101, String r102, b r103, boolean r104, Function1<? super c, Unit> r105, boolean r106) {
            this.f325113a = r100;
            this.f325114b = r101;
            this.f325115c = r102;
            this.f325116d = r103;
            this.f325117e = r104;
            this.f325118f = r105;
            this.f325119g = r106;
        }
    }

    public static final class g implements IIMCallback<AIJobRecommendResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f325120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChatJobListLoader f325121b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f325122c;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return true;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            if (this.f325120a == this.f325121b.f325100q) goto L6;
            FLogger.f375446a.i("ChatJobListLoader", "pullRecommendJobs failure ignored stale generation reason=" + this.f325122c);
            return;
        L6:
            FLogger r101 = FLogger.f375446a;
            StringBuilder r102 = new StringBuilder("pullRecommendJobs failed after local end reason=");
            r102.append(this.f325122c);
            r102.append(' ');
            int r103 = ChatJobListLoader.f325083t;
            r102.append(a.d(r100));
            r101.e("ChatJobListLoader", r102.toString());
            gz8.h.b(r100);
            ChatJobListLoader.a(this.f325121b, "recommendPullFailed:" + this.f325122c);
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(AIJobRecommendResult r110) {
            AIJobRecommendResult r111 = r110;
            Intrinsics.checkNotNullParameter(r111, "result");
            if (this.f325120a == this.f325121b.f325100q) goto L5;
            FLogger.f375446a.i("ChatJobListLoader", "pullRecommendJobs success ignored stale generation reason=" + this.f325122c);
            return;
        L5:
            FLogger r100 = FLogger.f375446a;
            StringBuilder r101 = new StringBuilder("pullRecommendJobs success after local end reason=");
            r101.append(this.f325122c);
            r101.append(" fetched=");
            r101.append(r111.getFetchedCount());
            r101.append(" changed=");
            int r102 = ChatJobListLoader.f325083t;
            r101.append(a.a(r111.getChangedJobIds()));
            r100.i("ChatJobListLoader", r101.toString());
            ChatJobListLoader r112 = this.f325121b;
            String r103 = "recommendAfterLocalEnd:" + this.f325122c;
            r112.f325084a.getLocalJobList(new AIJobListQuery(2, 0, 0, null, 100, 14, null), new t(this.f325120a, r112, r103));
        }

        public g(int r100, ChatJobListLoader r101, String r102) {
            this.f325120a = r100;
            this.f325121b = r101;
            this.f325122c = r102;
        }
    }

    public static final class h implements IIMCallback<AIJobChainResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f325123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f325124b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f325125c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<IIMError> f325126d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f325127e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ChatJobListLoader f325128f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Function1<e, Unit> f325129g;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return true;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r110) {
            Intrinsics.checkNotNullParameter(r110, "error");
            FLogger r100 = FLogger.f375446a;
            StringBuilder r101 = new StringBuilder("pullRemoteSnapshots pullJobChain failed reason=");
            r101.append(this.f325123a);
            r101.append(' ');
            int r102 = ChatJobListLoader.f325083t;
            r101.append(a.d(r110));
            r100.e("ChatJobListLoader", r101.toString());
            ChatJobListLoader.b(this.f325124b, this.f325125c, this.f325126d, this.f325127e, this.f325128f, this.f325123a, this.f325129g, false, r110);
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(AIJobChainResult r110) {
            AIJobChainResult r111 = r110;
            Intrinsics.checkNotNullParameter(r111, "result");
            FLogger r100 = FLogger.f375446a;
            StringBuilder r101 = new StringBuilder("pullRemoteSnapshots pullJobChain success reason=");
            r101.append(this.f325123a);
            r101.append(" fetched=");
            r101.append(r111.getFetchedCount());
            r101.append(" changed=");
            int r102 = ChatJobListLoader.f325083t;
            r101.append(a.a(r111.getChangedJobIds()));
            r100.i("ChatJobListLoader", r101.toString());
            Ref.BooleanRef r103 = this.f325124b;
            Ref.IntRef r104 = this.f325125c;
            Ref.ObjectRef<IIMError> r105 = this.f325126d;
            Ref.IntRef r106 = this.f325127e;
            ChatJobListLoader r107 = this.f325128f;
            String r108 = this.f325123a;
            Function1<e, Unit> r109 = this.f325129g;
            if (r111.getFetchedCount() <= 0) goto L5;
        L8:
            boolean r112 = true;
        L9:
            ChatJobListLoader.b(r103, r104, r105, r106, r107, r108, r109, r112, null);
            return;
        L5:
            if ((!r111.getChangedJobIds().isEmpty()) == true) goto L8;
            r112 = false;
            goto L9
        }

        /* JADX WARN: Multi-variable type inference failed */
        public h(String r100, Ref.BooleanRef r101, Ref.IntRef r102, Ref.ObjectRef<IIMError> r103, Ref.IntRef r104, ChatJobListLoader r105, Function1<? super e, Unit> r106) {
            this.f325123a = r100;
            this.f325124b = r101;
            this.f325125c = r102;
            this.f325126d = r103;
            this.f325127e = r104;
            this.f325128f = r105;
            this.f325129g = r106;
        }
    }

    static {
        new a();
    }

    public final j c() {
        List<AIJob> r100 = this.f325089f;
        int r101 = g0.f325370a;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if (g0.c((AIJob) r104) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        ArrayList r105 = new ArrayList();
        Iterator r106 = r102.iterator();
    L9:
        boolean r107 = false;
        if (r106.hasNext() == false) goto L18;
        Object r108 = r106.next();
        AIJob r109 = (AIJob) r108;
        if (r109.getStatus() != 1) goto L14;
    L15:
        r107 = true;
    L16:
        if (r107 == false) goto L9;
        r105.add(r108);
        goto L9
    L14:
        if (r109.getStatus() != (-1)) goto L16;
    L18:
        ArrayList r110 = new ArrayList();
        Iterator r111 = r102.iterator();
    L20:
        if (r111.hasNext() == false) goto L27;
        Object r112 = r111.next();
        if (((AIJob) r112).getStatus() != 2) goto L24;
        boolean r113 = true;
    L25:
        if (r113 == false) goto L20;
        r110.add(r112);
        goto L20
    L24:
        r113 = false;
        goto L25
    L27:
        ArrayList r114 = new ArrayList();
        Iterator r115 = r102.iterator();
    L29:
        if (r115.hasNext() == false) goto L37;
        Object r116 = r115.next();
        if (((AIJob) r116).getStatus() != 3) goto L33;
        boolean r117 = true;
    L34:
        if (r117 == false) goto L29;
        r114.add(r116);
        goto L29
    L33:
        r117 = false;
        goto L34
    L37:
        if ((!CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.sortedWith(r105, new u()), CollectionsKt.sortedWith(r110, new v())), CollectionsKt.sortedWith(r114, new w())).isEmpty()) == true) goto L67;
        List<AIJob> r118 = this.f325089f;
        if ((r118 instanceof Collection) == true) goto L41;
    L43:
        Iterator<T> r119 = r118.iterator();
    L45:
        if (r119.hasNext() == false) goto L63;
        AIJob r120 = (AIJob) r119.next();
        if (this.f325099p == true) goto L49;
    L53:
        boolean r121 = false;
    L54:
        if (r121 == true) goto L56;
    L60:
        boolean r122 = false;
    L61:
        if (r122 == false) goto L45;
        boolean r123 = true;
    L64:
        if (r123 == true) goto L67;
        boolean r124 = false;
    L69:
        if (this.f325088e.getStatus() != AIJobRequestStatus.LOADING) goto L71;
        boolean r125 = true;
    L72:
        boolean r126 = !this.f325094k.isEmpty();
        if (r126 == true) goto L81;
        if (r124 == true) goto L81;
        if (this.f325086c == false) goto L80;
        if (r125 == true) goto L80;
        if (this.f325095l == false) goto L81;
    L80:
        boolean r127 = true;
    L82:
        if (r126 == true) goto L92;
        if (r127 == true) goto L92;
        if (r124 == true) goto L92;
        if (this.f325095l == true) goto L92;
        if (this.f325087d == false) goto L90;
    L91:
        boolean r128 = true;
    L93:
        List<AIJob> r129 = this.f325089f;
        if (this.f325099p == true) goto L96;
    L100:
        boolean r130 = false;
    L102:
        return new j(r129, r127, r128, r126, r130);
    L96:
        if (this.f325090g == true) goto L100;
        if (this.f325092i == true) goto L100;
        r130 = true;
        goto L102
    L90:
        if (this.f325096m == true) goto L91;
    L92:
        r128 = false;
    L81:
        r127 = false;
        goto L82
    L71:
        r125 = false;
        goto L72
    L56:
        if (r120.getJobType() != 2) goto L60;
        if (r120.getStatus() != 1) goto L60;
        r122 = true;
        goto L61
    L49:
        if (this.f325090g == true) goto L53;
        if (this.f325092i == true) goto L53;
        r121 = true;
    L63:
        r123 = false;
        goto L64
    L41:
        if (r118.isEmpty() == false) goto L43;
    L67:
        r124 = true;
        goto L69
    }

    public final void d() {
        this.f325085b.invoke(c());
    }

    public final void e(AIJobRequestType r100) {
        if (this.f325094k.contains(r100) == true) goto L5;
        return;
    L5:
        this.f325094k = SetsKt.minus(this.f325094k, r100);
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("pull refresh request finished type=");
        r102.append(r100);
        r102.append(" remaining=");
        Set<? extends AIJobRequestType> r103 = this.f325094k;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        r104.add(((AIJobRequestType) r105.next()).name());
        goto L7
    L9:
        r102.append(r104);
        r101.i("ChatJobListLoader", r102.toString());
        d();
    }

    public final void i(String r100) {
        if (this.f325097n == true) goto L5;
    L9:
        boolean r101 = false;
    L11:
        if (r101 == true) goto L14;
        FLogger.f375446a.i("ChatJobListLoader", "pullRecommendJobs skipped reason=" + r100 + " localEndReachedAfterLoadMore=" + this.f325097n + " recommendPullInFlight=" + this.f325098o + " recommendLoadedAfterLocalEnd=" + this.f325099p);
        return;
    L14:
        FLogger.f375446a.i("ChatJobListLoader", "pullRecommendJobs request after local end reason=" + r100);
        this.f325098o = true;
        int r102 = this.f325100q + 1;
        this.f325100q = r102;
        this.f325084a.pullRecommendJobs(new g(r102, this, r100));
        return;
    L5:
        if (this.f325098o == true) goto L9;
        if (this.f325099p == true) goto L9;
        r101 = true;
        goto L11
    }

    public final void k(boolean r100) {
        FLogger r101 = FLogger.f375446a;
        r101.i("ChatJobListLoader", "refresh showPullRefreshing=" + r100);
        if (r100 == true) goto L6;
        r101.i("ChatJobListLoader", "loadInitialLocalFirst");
        this.f325094k = SetsKt.emptySet();
        this.f325089f = CollectionsKt.emptyList();
        this.f325086c = false;
        this.f325087d = false;
        this.f325095l = false;
        this.f325096m = false;
        this.f325088e = new AIJobRequestState(AIJobRequestType.JOB_CHAIN, AIJobRequestStatus.IDLE, 0, null, 12, null);
        this.f325085b.invoke(new j(CollectionsKt.emptyList(), true, false, false, false));
        f("initial", false, false, new m(this));
        return;
    L6:
        this.f325094k = SetsKt.setOf(AIJobRequestType.JOB_CHAIN);
        d();
        g(this, "pullRefresh", 14);
        this.f325084a.pullJobChain(100, new d(new ChatJobListLoader$refresh$1(this)));
    }

    @Override // com.larus.im.service.AIJobObserver
    public final void onJobsChanged(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "ids");
        FLogger.f375446a.i("ChatJobListLoader", "onJobsChanged ids=" + a.a(r100));
        if (this.f325098o == true) goto L5;
    L19:
        g(this, "jobsChanged", 14);
        return;
    L5:
        if (this.f325097n == false) goto L19;
        if (this.f325092i == true) goto L19;
        Set<String> r101 = this.f325101r;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L10:
        if (r103.hasNext() == false) goto L17;
        Object r104 = r103.next();
        if (((String) r104).length() <= 0) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == false) goto L10;
        r102.add(r104);
        goto L10
    L14:
        r105 = false;
        goto L15
    L17:
        this.f325101r = SetsKt.plus(r101, r102);
        FLogger.f375446a.i("ChatJobListLoader", "onJobsChanged deferred during recommend pull ids=" + a.a(r100));
    }

    @Override // com.larus.im.service.AIJobObserver
    public final void onRequestStateChanged(AIJobRequestState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (r100.getStatus() != AIJobRequestStatus.FAILURE) goto L6;
        FLogger.f375446a.e("ChatJobListLoader", "requestState failed type=" + r100.getRequestType() + " errorCode=" + r100.getErrorCode() + " errorMessage=" + r100.getErrorMessage());
    L6:
        if (r100.getRequestType() == AIJobRequestType.JOB_CHAIN) goto L8;
        return;
    L8:
        this.f325088e = r100;
        boolean r101 = this.f325094k.contains(r100.getRequestType());
        if (r100.getStatus() == AIJobRequestStatus.LOADING) goto L11;
        e(r100.getRequestType());
        return;
    L11:
        if (r101 == true) goto L15;
        d();
        return;
    }

    public ChatJobListLoader(AIJobServiceImpl r100, Function1 r110) {
        Intrinsics.checkNotNullParameter(r100, "aiJobService");
        Intrinsics.checkNotNullParameter(r110, "onSnapshotChanged");
        this.f325084a = r100;
        this.f325085b = r110;
        this.f325088e = new AIJobRequestState(AIJobRequestType.JOB_CHAIN, AIJobRequestStatus.IDLE, 0, null, 12, null);
        this.f325089f = CollectionsKt.emptyList();
        this.f325094k = SetsKt.emptySet();
        this.f325101r = SetsKt.emptySet();
    }

    public static final void a(ChatJobListLoader r100, String r101) {
        boolean r102 = false;
        r100.f325098o = false;
        Set<String> r103 = r100.f325101r;
        r100.f325101r = SetsKt.emptySet();
        Set r104 = SequencesKt.toSet(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(r100.f325089f), new k()), new l()));
        if ((!r103.isEmpty()) == true) goto L5;
    L26:
        if (r102 == false) goto L28;
        FLogger.f375446a.i("ChatJobListLoader", "refresh task jobs after recommend pull reason=" + r101 + " changedIds=" + a.a(CollectionsKt.toList(r103)));
        StringBuilder r105 = new StringBuilder("pendingTaskChangedAfterRecommendPull:");
        r105.append(r101);
        g(r100, r105.toString(), 14);
        return;
    L28:
        r100.d();
        return;
    L5:
        if (r100.f325095l == false) goto L7;
    L10:
        boolean r106 = true;
    L11:
        if (r106 == true) goto L25;
        Set<String> r107 = r103;
        if ((r107 instanceof Collection) == true) goto L15;
    L17:
        Iterator<T> r108 = r107.iterator();
    L19:
        if (r108.hasNext() == false) goto L23;
        if ((!r104.contains((String) r108.next())) == false) goto L19;
        boolean r109 = true;
    L24:
        if (r109 == false) goto L26;
    L23:
        r109 = false;
        goto L24
    L15:
        if (r107.isEmpty() == false) goto L17;
    L25:
        r102 = true;
        goto L26
    L7:
        if (r100.f325094k.contains(AIJobRequestType.JOB_CHAIN) == true) goto L10;
        r106 = false;
        goto L11
    }

    public final void j(String r110, Function1<? super e, Unit> r111) {
        FLogger.f375446a.i("ChatJobListLoader", "pullRemoteSnapshots reason=".concat(r110));
        this.f325095l = true;
        this.f325096m = false;
        d();
        Ref.IntRef r100 = new Ref.IntRef();
        r100.element = 1;
        Ref.BooleanRef r101 = new Ref.BooleanRef();
        Ref.IntRef r102 = new Ref.IntRef();
        Ref.ObjectRef r103 = new Ref.ObjectRef();
        this.f325084a.pullJobChain(100, new h(r110, r101, r102, r103, r100, this, r111));
    }

    public static /* synthetic */ void g(ChatJobListLoader r100, String r101, int r102) {
        boolean r103 = true;
        if ((r102 & 2) == 0) goto L5;
        boolean r104 = true;
    L7:
        if ((r102 & 4) != 0) goto L10;
        r103 = false;
    L10:
        r100.f(r101, r104, r103, null);
        return;
    L5:
        r104 = false;
        goto L7
    }

    public final void f(String r110, boolean r111, boolean r112, Function1<? super c, Unit> r113) {
        if (this.f325090g == false) goto L6;
        this.f325091h = true;
        return;
    L6:
        this.f325090g = true;
        int r100 = 0;
        if (this.f325097n == false) goto L9;
    L28:
        boolean r101 = true;
    L29:
        this.f325092i = false;
        this.f325093j = null;
        this.f325097n = false;
        this.f325098o = false;
        this.f325099p = false;
        this.f325101r = SetsKt.emptySet();
        this.f325100q++;
        this.f325102s = r101;
        h(r110, new b(r100), false, r111, r112, r113);
        return;
    L9:
        if (this.f325099p == true) goto L28;
        List<AIJob> r102 = this.f325089f;
        if ((r102 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r103 = r102.iterator();
    L17:
        if (r103.hasNext() == false) goto L24;
        if (((AIJob) r103.next()).getJobType() != 2) goto L21;
        boolean r104 = true;
    L22:
        if (r104 == false) goto L17;
        boolean r105 = true;
    L25:
        if (r105 == true) goto L28;
        r101 = false;
        goto L29
    L21:
        r104 = false;
    L24:
        r105 = false;
        goto L25
    L13:
        if (r102.isEmpty() == false) goto L15;
        goto L15
    }

    public final void h(String r110, b r111, boolean r210, boolean r211, boolean r212, Function1<? super c, Unit> r213) {
        this.f325084a.getLocalJobList(new AIJobListQuery(r111.f325103a, r111.f325104b, r111.f325105c, r111.f325106d, 20), new f(r210, this, r110, r111, r211, r213, r212));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(Ref.BooleanRef r100, Ref.IntRef r101, Ref.ObjectRef r102, Ref.IntRef r103, ChatJobListLoader r104, String r105, Function1 r106, boolean r110, IIMError r111) {
        if (r100.element == true) goto L7;
        if (r110 == true) goto L7;
        boolean r112 = false;
    L8:
        r100.element = r112;
        if (r111 != 0) goto L12;
        r101.element++;
    L14:
        int r107 = r103.element - 1;
        r103.element = r107;
        if (r107 != 0) goto L23;
        r104.f325095l = false;
        int r108 = r101.element;
        IIMError r109 = (IIMError) r102.element;
        e r113 = new e(r112, r108, r109);
        FLogger r114 = FLogger.f375446a;
        StringBuilder r115 = new StringBuilder("pullRemoteSnapshots finished reason=");
        r115.append(r105);
        r115.append(" didChange=");
        r115.append(r112);
        r115.append(" successfulRequestCount=");
        r115.append(r108);
        r115.append(" firstError=");
        if (r109 == null) goto L20;
        String r116 = a.d(r109);
    L21:
        r115.append(r116);
        r114.i("ChatJobListLoader", r115.toString());
        r106.invoke(r113);
        return;
    L20:
        r116 = null;
        goto L21
    L23:
        return;
    L12:
        if (r102.element != 0) goto L14;
        r102.element = r111;
    L7:
        r112 = true;
        goto L8
    }
}
