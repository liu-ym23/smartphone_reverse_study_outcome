package com.larus.ui.arch.component.external.api.feature;

import android.content.Context;
import com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal;
import com.larus.ui.arch.component.internal.control.ComponentStateController;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import m1a.a;
import t1a.c;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0010R4\u0010\u0004\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u0005j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006`\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0005j\b\u0012\u0004\u0012\u00020\f`\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/delegate/BaseComponentFeatureInternal;", "<init>", "()V", "abilityList", "Ljava/util/ArrayList;", "Lkotlin/reflect/KClass;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentAbility;", "Lkotlin/collections/ArrayList;", "getAbilityList$component_release", "()Ljava/util/ArrayList;", "dataList", "Lcom/larus/ui/arch/context/external/VData;", "getDataList$component_release", "handleFeatures", "", "handleFeatures$component_release", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ComponentFeature extends BaseComponentFeatureInternal {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<KClass<? extends a>> f375139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<c> f375140g;

    public final Context getContext() {
        ComponentStateController r100 = this.f375151e;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("stateController");
        r100 = null;
    L6:
        Object r101 = r100.getContext();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.content.Context");
        return (Context) r101;
    }

    public ComponentFeature() {
        this.f375139f = new ArrayList();
        this.f375140g = new ArrayList();
    }
}
