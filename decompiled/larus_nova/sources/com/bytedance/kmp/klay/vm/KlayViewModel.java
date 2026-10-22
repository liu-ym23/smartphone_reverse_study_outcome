package com.bytedance.kmp.klay.vm;

import androidx.lifecycle.ViewModel;
import com.bytedance.kmp.klay.ui.KlayModuleNode;
import com.bytedance.kmp.klay.ui.b;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0017J\b\u0010\u0005\u001a\u00020\u0002H\u0015R.\u0010\t\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/kmp/klay/vm/KlayViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onRepoClear", "onCreated", "onCleared", "", "Lkotlin/reflect/KClass;", "Ldb6/a;", "repositories", "Ljava/util/Map;", "getRepositories$klay_release", "()Ljava/util/Map;", "Lcom/bytedance/kmp/klay/ui/KlayModuleNode;", "moduleNode", "Lcom/bytedance/kmp/klay/ui/KlayModuleNode;", "getModuleNode$klay_release", "()Lcom/bytedance/kmp/klay/ui/KlayModuleNode;", "setModuleNode$klay_release", "(Lcom/bytedance/kmp/klay/ui/KlayModuleNode;)V", "<init>", "()V", "klay_release"}, k = 1, mv = {1, 7, 0})
public class KlayViewModel extends ViewModel {
    public static final int $stable = 8;
    private KlayModuleNode moduleNode;
    private final Map<KClass<?>, db6.a<?>> repositories;

    private final void onRepoClear() {
        Iterator<Map.Entry<KClass<?>, db6.a<?>>> r100 = this.repositories.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().getValue().getClass();
        goto L4
    L6:
        this.repositories.clear();
    }

    public void onCreated() {
        eb6.a.a(eb6.a.f471798a, "KlayViewModel:#" + Reflection.getOrCreateKotlinClass(getClass()).getQualifiedName() + " onCreated");
        Map<b, Map<KClass<? extends KlayViewModel>, KlayViewModel>> r100 = fb6.a.f476264a;
        Intrinsics.checkNotNullParameter(this, "klayViewModel");
    }

    public KlayViewModel() {
        this.repositories = new LinkedHashMap();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        eb6.a.a(eb6.a.f471798a, "KlayViewModel:#" + Reflection.getOrCreateKotlinClass(getClass()).getQualifiedName() + " onCleared");
        onRepoClear();
        Map<b, Map<KClass<? extends KlayViewModel>, KlayViewModel>> r100 = fb6.a.f476264a;
        Intrinsics.checkNotNullParameter(this, "klayViewModel");
    }

    public final KlayModuleNode getModuleNode$klay_release() {
        return this.moduleNode;
    }

    public final Map<KClass<?>, db6.a<?>> getRepositories$klay_release() {
        return this.repositories;
    }

    public final void setModuleNode$klay_release(KlayModuleNode r100) {
        this.moduleNode = r100;
    }
}
