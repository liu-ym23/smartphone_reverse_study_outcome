package com.larus.ui.arch.component.external.api.receiver;

import androidx.exifinterface.media.ExifInterface;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import m1a.b;
import m1a.e;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J+\u0010\u001a\u001a\u00020\u001b\"\b\b\u0000\u0010\u001c*\u00020\u001d2\u0006\u0010\u001e\u001a\u0002H\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001c0 ¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020#H\u0016R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0006j\b\u0012\u0004\u0012\u00020\u0001`\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0006j\b\u0012\u0004\u0012\u00020\r`\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR*\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0006j\b\u0012\u0004\u0012\u00020\u0011`\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bRB\u0010\u0014\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00150\u0006j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015`\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u000b¨\u0006$"}, d2 = {"Lcom/larus/ui/arch/component/external/api/receiver/Container;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/api/receiver/ComponentReceiver;", "<init>", "()V", "integratedFeatures", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getIntegratedFeatures$component_release", "()Ljava/util/ArrayList;", "setIntegratedFeatures$component_release", "(Ljava/util/ArrayList;)V", "integratedCard", "Lcom/larus/ui/arch/component/external/api/feature/ComponentCard;", "getIntegratedCard$component_release", "setIntegratedCard$component_release", "integratedWidget", "Lcom/larus/ui/arch/component/external/api/feature/ComponentWidget;", "getIntegratedWidget$component_release", "setIntegratedWidget$component_release", "attachedComponentTypeList", "Lkotlin/Function1;", "Lcom/larus/ui/arch/component/external/core/ComponentBuilder;", "Lcom/larus/ui/arch/component/external/api/Component;", "getAttachedComponentTypeList$component_release", "setAttachedComponentTypeList$component_release", "replaceInitialData", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/larus/ui/arch/context/external/VData;", "data", "clazz", "Lkotlin/reflect/KClass;", "(Lcom/larus/ui/arch/context/external/VData;Lkotlin/reflect/KClass;)Z", "onAttach", "", "component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class Container extends ComponentFeature {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<ComponentFeature> f375142h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList<b> f375143i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<e> f375144j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList<Function1<p1a.b, Component>> f375145k;

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
    }

    public Container() {
        this.f375142h = new ArrayList();
        this.f375143i = new ArrayList();
        this.f375144j = new ArrayList();
        this.f375145k = new ArrayList();
    }
}
