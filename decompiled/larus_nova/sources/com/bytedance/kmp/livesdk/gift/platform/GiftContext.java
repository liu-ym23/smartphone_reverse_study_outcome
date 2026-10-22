package com.bytedance.kmp.livesdk.gift.platform;

import ad6.a;
import ad6.b;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.e;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/GiftContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/k;", "Lad6/b;", "sendTogetherSlotChangeEvent$delegate", "Lcom/bytedance/live/datacontext/p;", "getSendTogetherSlotChangeEvent", "()Lcom/bytedance/live/datacontext/k;", "sendTogetherSlotChangeEvent", "Lcom/bytedance/live/datacontext/n;", "Lad6/a;", "currentSendTogetherInfo$delegate", "getCurrentSendTogetherInfo", "()Lcom/bytedance/live/datacontext/n;", "currentSendTogetherInfo", "Lcom/bytedance/live/datacontext/m;", "", "bigGiftKeyCount$delegate", "getBigGiftKeyCount", "()Lcom/bytedance/live/datacontext/m;", "bigGiftKeyCount", "<init>", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p bigGiftKeyCount$delegate;
    private final p currentSendTogetherInfo$delegate;
    private final p sendTogetherSlotChangeEvent$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftContext.class, "sendTogetherSlotChangeEvent", "getSendTogetherSlotChangeEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "currentSendTogetherInfo", "getCurrentSendTogetherInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "bigGiftKeyCount", "getBigGiftKeyCount()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public final m<Long> getBigGiftKeyCount() {
        return (m) this.bigGiftKeyCount$delegate.a(this, $$delegatedProperties[2]);
    }

    public final n<a> getCurrentSendTogetherInfo() {
        return (n) this.currentSendTogetherInfo$delegate.a(this, $$delegatedProperties[1]);
    }

    public final k<b> getSendTogetherSlotChangeEvent() {
        return (k) this.sendTogetherSlotChangeEvent$delegate.a(this, $$delegatedProperties[0]);
    }

    public GiftContext() {
        this.sendTogetherSlotChangeEvent$delegate = e.b(this);
        this.currentSendTogetherInfo$delegate = q.c(this);
        this.bigGiftKeyCount$delegate = q.d(this, 0L);
    }
}
