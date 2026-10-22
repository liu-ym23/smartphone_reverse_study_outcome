package com.bytedance.ee.bear.middleground.unbundle.cache;

import aj5.e;
import aj5.f;
import android.text.TextUtils;
import by4.b;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class BenefitCacheManager {
    public final b a;
    public final String b;
    public final ConcurrentHashMap<String, BenefitStore> c;
    public BenefitStore d;
    public final f e;
    public final List<Job> f;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.unbundle.cache.BenefitCacheManager$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.middleground.unbundle.cache.BenefitCacheManager$1", f = "BenefitCacheManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Job> $job;
        int label;
        final /* synthetic */ BenefitCacheManager this$0;

        public AnonymousClass1(BenefitCacheManager r1, Ref.ObjectRef<Job> r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$job = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$job, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L21;
            ResultKt.throwOnFailure(r10);
            f r11 = this.this$0.e;
            r11.getClass();
            List<aj5.a> r12 = ((e) r11.a()).a();     // Catch: Exception -> L7
            tt5.a.h("Benefit_DataManager", "getBenefitDatas... size: " + ((ArrayList) r12).size());     // Catch: Exception -> L7
        L9:
            BenefitCacheManager r1 = this.this$0;
            Iterator r13 = r12.iterator();
        L11:
            if (r13.hasNext() == false) goto L13;
            aj5.a r3 = (aj5.a) r13.next();
            r1.c.put(r3.a, BenefitStore.b.b(BenefitStore.Companion, r3.b, r3.c, "cache"));
            goto L11
        L13:
            f r14 = this.this$0.e;
            r14.getClass();
            tt5.a.h("Benefit_DataManager", "shrinkSize... result: " + ((e) r14.a()).b());     // Catch: Exception -> L16
        L18:
            ((ArrayList) this.this$0.f).remove(this.$job.element);
            return Unit.INSTANCE;
        L16:
            e = move-exception;
            tt5.a.e("Benefit_DataManager", "shrinkSize...", e, false);
        L7:
            e = move-exception;
            tt5.a.e("Benefit_DataManager", "getBenefitDatas...", e, false);
            r12 = new ArrayList();
            goto L9
        L21:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @AppConfig(key = "unbundle_base_benefit")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ee/bear/middleground/unbundle/cache/BenefitCacheManager$BitableBenefitSettings;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BitableBenefitSettings implements NonProguard {
        public BitableBenefitSettings() {
        }
    }

    @AppConfig(key = "unbundle_doc_benefit")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ee/bear/middleground/unbundle/cache/BenefitCacheManager$DocBenefitSettings;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DocBenefitSettings implements NonProguard {
        public DocBenefitSettings() {
        }
    }

    @AppConfig(key = "unbundle_wiki_benefit")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ee/bear/middleground/unbundle/cache/BenefitCacheManager$WikiBenefitSettings;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WikiBenefitSettings implements NonProguard {
        public WikiBenefitSettings() {
        }
    }

    public static final class a {
    }

    static {
    }

    public final synchronized void b(BenefitStore r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "benefitStore");     // Catch: Throwable -> L14
        StringBuilder r2 = new StringBuilder("userBenefitStore is null ? ");     // Catch: Throwable -> L14
        if (this.d != null) goto L7;
        boolean r0 = true;
    L8:
        r2.append(r0);     // Catch: Throwable -> L14
        tt5.a.h("Benefit_BenefitCacheManager", r2.toString());     // Catch: Throwable -> L14
        if (this.d != null) goto L11;
        this.d = r4;     // Catch: Throwable -> L14
    L11:
        this.a.b("benefit").putString("user_benefit", r4.getSourceBenefit());     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L7:
        r0 = false;
    L14:
        th = move-exception;
        throw th;
    }

    public final void a(BenefitStore r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "benefitStore");
        Intrinsics.checkNotNullParameter(r13, "cacheKey");
        this.c.put(r13, r12);
        if (r12.getOwnerId().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L10:
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        Job r14 = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new BenefitCacheManager$updateResBenefitCache$1(this, r13, r12, r1, null), 2, null);
        r1.element = r14;
        ((ArrayList) this.f).add(r14);
        return;
    L8:
        if (TextUtils.equals(r13, r12.getOwnerId()) == true) goto L10;
        this.c.put(r12.getOwnerId(), r12);
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public BenefitCacheManager(b r9, com.bytedance.ee.util.db.a r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "kvStorage");
        Intrinsics.checkNotNullParameter(r10, "dbController");
        Intrinsics.checkNotNullParameter(r11, "currUserId");
        this.a = r9;
        this.b = r11;
        boolean r0 = c.a.a.g("ccm.doc.enable_unbundle");
        this.c = new ConcurrentHashMap();
        this.e = new f(LarkContext.getApplication(), r10);
        ArrayList r12 = new ArrayList();
        this.f = r12;
        if (r0 == false) goto L9;
        String r13 = r9.b("benefit").getString("user_benefit", null);
        if (r13 == null) goto L7;
        tt5.a.h("Benefit_BenefitCacheManager", "has userBenefitStore cache");
        BenefitStore.Companion.getClass();
        this.d = BenefitStore.b.a(r11, r13, "cache", true);
    L7:
        Ref.ObjectRef r14 = new Ref.ObjectRef();
        Job r15 = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AnonymousClass1(this, r14, null), 2, null);
        r14.element = r15;
        r12.add(r15);
        return;
    }
}
