package com.larus.ui.arch.context.internal;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import defpackage.s0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t1a.b;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/larus/ui/arch/context/internal/VContextStore;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "getOrInit", "parent", "Companion", "component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VContextStore extends ViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    private b vContext;

    public static final class a {
        public a() {
        }

        public static VContextStore a(ViewModelStoreOwner r100) {
            Intrinsics.checkNotNullParameter(r100, "owner");
            ViewModelStore r101 = r100.getViewModelStore();
            ViewModel r102 = r101.get("VContextStore");
            if ((r102 instanceof VContextStore) == false) goto L5;
            VContextStore r103 = (VContextStore) r102;
        L6:
            if (r103 != null) goto L9;
            VContextStore r104 = new VContextStore();
            r101.put("VContextStore", r104);
            return r104;
        L9:
            return r103;
        L5:
            r103 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public VContextStore() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [t1a.b] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, t1a.b] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, s0] */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.StringBuilder] */
    public final b getOrInit(b r100) {
        ?? r101 = this.vContext;
        if (r101 != 0) goto L18;
        r101 = new s0();
        if (x1a.a.f562151b == true) goto L7;
        int r102 = y1a.a.f565679a;
        y1a.a.a("ComponentArch", "get VContext from " + this + ", parentContext " + r100 + ", newInstance " + r101);
    L7:
        if (r100 == null) goto L18;
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (Intrinsics.areEqual(r101.f539991d, r100) == true) goto L18;
        s0 r103 = (s0) r100;
        r101.f539991d = r103;
    L12:
        if (r103 == null) goto L18;
        if ((!Intrinsics.areEqual(r103, r101)) == false) goto L17;
        r103 = r103.f539991d;
        goto L12
    L17:
        throw new IllegalStateException(("encounter circular scope attachment " + r101).toString());
    L18:
        this.vContext = r101;
        if (x1a.a.f562151b == true) goto L21;
        int r104 = y1a.a.f565679a;
        y1a.a.a("ComponentArch", "get VContext from " + this + ", parentContext " + r100 + " return " + r101);
    L21:
        return r101;
    }

    public static /* synthetic */ b getOrInit$default(VContextStore r100, b r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return r100.getOrInit(r101);
    }
}
