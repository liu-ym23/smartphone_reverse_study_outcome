package com.bytedance.kmp.klay.ui;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/kmp/klay/ui/KlayModuleNode;", "Landroidx/lifecycle/ViewModelStoreOwner;", "klay_release"}, k = 1, mv = {1, 7, 0})
public class KlayModuleNode implements ViewModelStoreOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f252187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewModelStore f252188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final KlayModuleNode f252189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.kmp.klay.event.a f252190d;

    public /* synthetic */ KlayModuleNode() {
        throw null;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        return this.f252188b;
    }

    public final KlayModuleNode a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (Intrinsics.areEqual(this.f252187a, r100) == true) goto L10;
        KlayModuleNode r101 = this.f252189c;
        if (r101 != null) goto L11;
        return null;
    L11:
        return r101.a(r100);
    L10:
        return this;
    }

    public KlayModuleNode(b r100, ViewModelStore r101, KlayModuleNode r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "vmStore");
        this.f252187a = r100;
        this.f252188b = r101;
        this.f252189c = r102;
        this.f252190d = new com.bytedance.kmp.klay.event.a();
        new LinkedHashMap();
    }
}
