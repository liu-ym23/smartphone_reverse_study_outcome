package com.relax.relaxreact;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class RenderKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s<q> f405428a = null;

    static {
        f405428a = e.a(RenderKt$Entry$1.INSTANCE);
    }

    public static final Map<String, Object> b(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ArrayList r101 = (ArrayList) com.bytedance.rts.kmp.foundation.h.c(TypeIntrinsics.asMutableMap(r100), "data", 1);
        Intrinsics.checkNotNull(r101);
        Object r102 = ListProtector.get(r101, 0);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>{ com.relax.relaxreact.RendererCoreKt.UnspecifiedJsonPayload }");
        return TypeIntrinsics.asMutableMap(r102);
    }

    public static final void a(Map<String, Object> r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "mergedPageData");
        Intrinsics.checkNotNullParameter(r101, "pageData");
        int r102 = com.bytedance.rts.kmp.foundation.g.f267611a;
        Intrinsics.checkNotNullParameter(r101, "json");
        ArrayList r103 = new ArrayList(r101.keySet());
        int r104 = 0;
    L3:
        IntCompanionObject r105 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        int r106 = r103.size();
        Intrinsics.checkNotNullParameter(r105, "<this>");
        if (r104 >= r106) goto L6;
        String r107 = (String) ListProtector.get(r103, r104);
        int r108 = com.bytedance.rts.kmp.foundation.g.f267611a;
        com.bytedance.rts.kmp.foundation.g.a.b(r100, r107, com.bytedance.rts.kmp.foundation.g.a.a(r101, r107));
        r104 = r104 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, com.relax.relaxreact.x0] */
    public static final void c(final s<Unit> r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "App");
        mpa.l r102 = new mpa.l(r101);
        final Unit r103 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "App");
        Intrinsics.checkNotNullParameter(r102, "renderer");
        int r110 = RenderFnRenderer.f405416l;
        Intrinsics.checkNotNullParameter(r102, "renderer");
        RenderFnRenderer r111 = new RenderFnRenderer(r102);
        r111.f405427k = true;
        Intrinsics.checkNotNullParameter(r100, "App");
        Intrinsics.checkNotNullParameter(r111, "adapter");
        k0 r104 = k0.f405535i;
        Intrinsics.checkNotNullParameter(r111, "renderer");
        l0 r105 = r111.f405421e;
        T r106 = 0;
        if ((r105 instanceof k0) == false) goto L5;
        k0 r107 = (k0) r105;
    L6:
        if (r107 != null) goto L9;
        r107 = new k0(r111);
    L9:
        final Ref.ObjectRef r108 = new Ref.ObjectRef();
        ?? r109 = new x0(r111);
        r108.element = r109;
        r107.f405540e = r109;
        final Ref.ObjectRef r112 = new Ref.ObjectRef();
        m0 r113 = r107.f405537b;
        if (r113 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("GlobalEventEmitter");
        r113 = null;
    L13:
        EventEmitter r114 = r113.f405549a;
        if (r114 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("eventEmitter");
    L17:
        r112.element = r106;
        final Ref.BooleanRef r115 = new Ref.BooleanRef();
        EventEmitter r116 = (EventEmitter) r112.element;
        int r117 = EventEmitter.f405400g;
        r116.g("__RenderPage", new RenderKt$renderWithAdapterInternal$1(r115, r100, r103, r112, r108));
        return;
    L16:
        r106 = r114;
        goto L17
    L5:
        r107 = null;
        goto L6
    }
}
