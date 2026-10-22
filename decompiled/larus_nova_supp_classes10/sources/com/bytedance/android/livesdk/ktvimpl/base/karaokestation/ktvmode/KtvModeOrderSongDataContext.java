package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode;

import com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b;
import com.bytedance.android.live.ktv.common.search.viewmodel.a;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.p;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/KtvModeOrderSongDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/ktv/common/karaokestation/viewmodel/b;", "commonOrderSongViewModel$delegate", "Lcom/bytedance/live/datacontext/p;", "getCommonOrderSongViewModel", "()Lcom/bytedance/live/datacontext/j;", "commonOrderSongViewModel", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/d;", "businessOrderSongViewModel$delegate", "getBusinessOrderSongViewModel", "businessOrderSongViewModel", "Lcom/bytedance/android/live/ktv/common/search/viewmodel/a;", "commonSearchViewModel$delegate", "getCommonSearchViewModel", "commonSearchViewModel", "Lcom/bytedance/android/livesdk/ktvimpl/base/skin/viewmodel/a;", "ktvDressViewModel$delegate", "getKtvDressViewModel", "ktvDressViewModel", "<init>", "()V", "Companion", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvModeOrderSongDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final Companion Companion = null;
    private final p businessOrderSongViewModel$delegate;
    private final p commonOrderSongViewModel$delegate;
    private final p commonSearchViewModel$delegate;
    private final p ktvDressViewModel$delegate;

    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        public static KtvModeOrderSongDataContext d() {
            DataContext r0 = d.d(KtvModeOrderSongDataContext$Companion$getDataContext$1.INSTANCE);
            if ((r0 instanceof KtvModeOrderSongDataContext) == true) goto L6;
            r0 = null;
        L6:
            return (KtvModeOrderSongDataContext) r0;
        }

        @JvmStatic
        public static com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d a() {
            KtvModeOrderSongDataContext r0 = d();
            if (r0 == null) goto L7;
            j<com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d> r1 = r0.m102getBusinessOrderSongViewModel();
            if (r1 == null) goto L7;
            return (com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d) r1.getValue();
        L7:
            return null;
        }

        @JvmStatic
        public static b b() {
            KtvModeOrderSongDataContext r0 = d();
            if (r0 == null) goto L7;
            j<b> r1 = r0.m103getCommonOrderSongViewModel();
            if (r1 == null) goto L7;
            return (b) r1.getValue();
        L7:
            return null;
        }

        @JvmStatic
        public static a c() {
            KtvModeOrderSongDataContext r0 = d();
            if (r0 == null) goto L7;
            j<a> r1 = r0.m104getCommonSearchViewModel();
            if (r1 == null) goto L7;
            return (a) r1.getValue();
        L7:
            return null;
        }

        @JvmStatic
        public static com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a e() {
            KtvModeOrderSongDataContext r0 = d();
            if (r0 == null) goto L7;
            j<com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a> r1 = r0.m105getKtvDressViewModel();
            if (r1 == null) goto L7;
            return (com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a) r1.getValue();
        L7:
            return null;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(KtvModeOrderSongDataContext.class, "commonOrderSongViewModel", "getCommonOrderSongViewModel()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvModeOrderSongDataContext.class, "businessOrderSongViewModel", "getBusinessOrderSongViewModel()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvModeOrderSongDataContext.class, "commonSearchViewModel", "getCommonSearchViewModel()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvModeOrderSongDataContext.class, "ktvDressViewModel", "getKtvDressViewModel()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new Companion();
    }

    @JvmStatic
    public static final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d getBusinessOrderSongViewModel() {
        Companion.getClass();
        return Companion.a();
    }

    @JvmStatic
    public static final b getCommonOrderSongViewModel() {
        Companion.getClass();
        return Companion.b();
    }

    @JvmStatic
    public static final a getCommonSearchViewModel() {
        Companion.getClass();
        return Companion.c();
    }

    @JvmStatic
    public static final KtvModeOrderSongDataContext getDataContext() {
        Companion.getClass();
        return Companion.d();
    }

    @JvmStatic
    public static final com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a getKtvDressViewModel() {
        Companion.getClass();
        return Companion.e();
    }

    /* JADX INFO: renamed from: getBusinessOrderSongViewModel, reason: collision with other method in class */
    public final j<com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d> m102getBusinessOrderSongViewModel() {
        return (j) this.businessOrderSongViewModel$delegate.a(this, $$delegatedProperties[1]);
    }

    /* JADX INFO: renamed from: getCommonOrderSongViewModel, reason: collision with other method in class */
    public final j<b> m103getCommonOrderSongViewModel() {
        return (j) this.commonOrderSongViewModel$delegate.a(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: renamed from: getCommonSearchViewModel, reason: collision with other method in class */
    public final j<a> m104getCommonSearchViewModel() {
        return (j) this.commonSearchViewModel$delegate.a(this, $$delegatedProperties[2]);
    }

    /* JADX INFO: renamed from: getKtvDressViewModel, reason: collision with other method in class */
    public final j<com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a> m105getKtvDressViewModel() {
        return (j) this.ktvDressViewModel$delegate.a(this, $$delegatedProperties[3]);
    }

    public KtvModeOrderSongDataContext() {
        this.commonOrderSongViewModel$delegate = ConstantKt.c(this);
        this.businessOrderSongViewModel$delegate = ConstantKt.c(this);
        this.commonSearchViewModel$delegate = ConstantKt.c(this);
        this.ktvDressViewModel$delegate = ConstantKt.c(this);
    }
}
