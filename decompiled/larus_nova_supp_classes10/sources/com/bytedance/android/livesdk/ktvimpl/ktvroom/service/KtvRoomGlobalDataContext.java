package com.bytedance.android.livesdk.ktvimpl.ktvroom.service;

import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.p;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/service/KtvRoomGlobalDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/service/a;", "ktvAdminService$delegate", "Lcom/bytedance/live/datacontext/p;", "getKtvAdminService", "()Lcom/bytedance/live/datacontext/j;", "ktvAdminService", "Lcom/bytedance/android/live/liveinteract/plantform/core/y;", "userInfoCenter$delegate", "getUserInfoCenter", "userInfoCenter", "Lcom/bytedance/ies/sdk/widgets/WidgetManager;", "subWidgetManager$delegate", "getSubWidgetManager", "subWidgetManager", "<init>", "()V", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomGlobalDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p ktvAdminService$delegate;
    private final p subWidgetManager$delegate;
    private final p userInfoCenter$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(KtvRoomGlobalDataContext.class, "ktvAdminService", "getKtvAdminService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvRoomGlobalDataContext.class, "userInfoCenter", "getUserInfoCenter()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvRoomGlobalDataContext.class, "subWidgetManager", "getSubWidgetManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    public final j<com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a> getKtvAdminService() {
        return (j) this.ktvAdminService$delegate.a(this, $$delegatedProperties[0]);
    }

    public final j<WidgetManager> getSubWidgetManager() {
        return (j) this.subWidgetManager$delegate.a(this, $$delegatedProperties[2]);
    }

    public final j<y> getUserInfoCenter() {
        return (j) this.userInfoCenter$delegate.a(this, $$delegatedProperties[1]);
    }

    public KtvRoomGlobalDataContext() {
        this.ktvAdminService$delegate = ConstantKt.b(this, KtvRoomGlobalDataContext$ktvAdminService$2.INSTANCE);
        this.userInfoCenter$delegate = ConstantKt.c(this);
        this.subWidgetManager$delegate = ConstantKt.c(this);
    }
}
