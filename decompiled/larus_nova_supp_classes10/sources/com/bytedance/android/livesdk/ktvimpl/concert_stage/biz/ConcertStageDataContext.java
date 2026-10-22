package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\r\u0010\u000eR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/concert_stage/biz/ConcertStageDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/j;", "Lgd2/f;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Ljs1/a;", "linkComponent$delegate", "getLinkComponent", "linkComponent", "<init>", "()V", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ConcertStageDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String KEY_CONCERT_STAGE_DATA = "key_concert_stage_data";
    private final com.bytedance.live.datacontext.p linkComponent$delegate;
    private final com.bytedance.live.datacontext.p service$delegate;

    public static final class a {
        public a() {
        }

        public final ConcertStageDataContext getContext() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(ConcertStageDataContext.KEY_CONCERT_STAGE_DATA);
            if ((r0 instanceof ConcertStageDataContext) == true) goto L6;
            r0 = null;
        L6:
            return (ConcertStageDataContext) r0;
        }

        public final gd2.f a() {
            ConcertStageDataContext r0 = getContext();
            if (r0 == null) goto L7;
            com.bytedance.live.datacontext.j<gd2.f> r1 = r0.getService();
            if (r1 == null) goto L7;
            return (gd2.f) r1.getValue();
        L7:
            return null;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ConcertStageDataContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ConcertStageDataContext.class, "linkComponent", "getLinkComponent()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    public final com.bytedance.live.datacontext.j<js1.a> getLinkComponent() {
        return (com.bytedance.live.datacontext.j) this.linkComponent$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.j<gd2.f> getService() {
        return (com.bytedance.live.datacontext.j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public ConcertStageDataContext() {
        this.service$delegate = ConstantKt.c(this);
        this.linkComponent$delegate = ConstantKt.c(this);
    }
}
