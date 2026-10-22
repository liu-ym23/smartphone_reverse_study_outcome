package com.larus.contextwindow.impl.ui;

import androidx.lifecycle.LifecycleCoroutineScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes27.dex */
public final class MembershipQuotaRefreshPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f330461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Long> f330462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Continuation<? super Unit>, Object> f330463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f330464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f330465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f330466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Job f330467g;

    /* JADX INFO: renamed from: com.larus.contextwindow.impl.ui.MembershipQuotaRefreshPolicy$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Long> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return invoke();
        }
    }

    public final void a() {
        this.f330464d = false;
        Job r100 = this.f330467g;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f330467g = null;
    }

    public final void b() {
        Job r100 = this.f330467g;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f330467g = null;
        if (this.f330464d == true) goto L8;
        return;
    L8:
        Long r101 = this.f330465e;
        if (r101 == null) goto L18;
        long r102 = r101.longValue();
        Long r103 = this.f330466f;
        if (r103 != null) goto L14;
    L16:
        long r104 = RangesKt.coerceAtLeast(r102 - this.f330462b.invoke().longValue(), 0);
        this.f330467g = BuildersKt.launch$default(this.f330461a, null, null, new MembershipQuotaRefreshPolicy$scheduleDeadline$1(r104, this, r102, null), 3, null);
        return;
    L14:
        if (r103.longValue() != r102) goto L16;
        return;
    }

    public MembershipQuotaRefreshPolicy(LifecycleCoroutineScope r100, Function1 r101) {
        AnonymousClass1 r102 = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r102, "nowMillis");
        Intrinsics.checkNotNullParameter(r101, "refresh");
        this.f330461a = r100;
        this.f330462b = r102;
        this.f330463c = r101;
    }
}
