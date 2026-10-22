package com.larus.ui.arch.component.external.api;

import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import p1a.a;
import p1a.e;
import p1a.j;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0016RL\u0010\u0004\u001a4\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\b0\u0005j\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\b`\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rRL\u0010\u000e\u001a4\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\b0\u0005j\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\b`\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rRL\u0010\u0012\u001a4\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\b0\u0005j\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\b`\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR*\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0005j\b\u0012\u0004\u0012\u00020\u0017`\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/larus/ui/arch/component/external/api/Component;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "<init>", "()V", "toBuildCards", "Ljava/util/ArrayList;", "Lkotlin/Function1;", "Lcom/larus/ui/arch/component/external/core/CardFeatureBuilder;", "Lkotlin/ExtensionFunctionType;", "Lkotlin/collections/ArrayList;", "getToBuildCards$component_release", "()Ljava/util/ArrayList;", "setToBuildCards$component_release", "(Ljava/util/ArrayList;)V", "toBuildWidgets", "Lcom/larus/ui/arch/component/external/core/WidgetFeatureBuilder;", "getToBuildWidgets$component_release", "setToBuildWidgets$component_release", "toBuildFeature", "Lcom/larus/ui/arch/component/external/core/CustomFeatureBuilder;", "getToBuildFeature$component_release", "setToBuildFeature$component_release", "toAttachContainers", "Lcom/larus/ui/arch/modulizer/di/ContainerFilter;", "getToAttachContainers$component_release", "setToAttachContainers$component_release", "onAttach", "", "component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class Component extends ComponentFeature {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<Function1<a, ComponentFeature>> f375135h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList<Function1<j, ComponentFeature>> f375136i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList<Function1<e, ComponentFeature>> f375137j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList<ContainerFilter> f375138k;

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public void y2() {
    }

    public Component() {
        this.f375135h = new ArrayList();
        this.f375136i = new ArrayList();
        this.f375137j = new ArrayList();
        this.f375138k = new ArrayList();
    }
}
