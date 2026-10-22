package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm;

import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/vm/KtvChallengeDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/a;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Lcom/bytedance/live/datacontext/m;", "", "challengeYellowStatus$delegate", "getChallengeYellowStatus", "()Lcom/bytedance/live/datacontext/m;", "challengeYellowStatus", "<init>", "()V", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvChallengeDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p challengeYellowStatus$delegate;
    private final p service$delegate;

    public static final class a {
        public a() {
        }

        public final KtvChallengeDataContext getContext() {
            DataContext r0 = d.d(KtvChallengeDataContext.class);
            if ((r0 instanceof KtvChallengeDataContext) == true) goto L6;
            r0 = null;
        L6:
            return (KtvChallengeDataContext) r0;
        }

        public final com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a a() {
            KtvChallengeDataContext r0 = getContext();
            if (r0 == null) goto L7;
            j<com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a> r1 = r0.getService();
            if (r1 == null) goto L7;
            return (com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a) r1.getValue();
        L7:
            return null;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(KtvChallengeDataContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvChallengeDataContext.class, "challengeYellowStatus", "getChallengeYellowStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    public final m<Object> getChallengeYellowStatus() {
        return (m) this.challengeYellowStatus$delegate.a(this, $$delegatedProperties[1]);
    }

    public final j<com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a> getService() {
        return (j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public KtvChallengeDataContext() {
        this.service$delegate = ConstantKt.c(this);
        this.challengeYellowStatus$delegate = q.d(this, new Object());
    }
}
