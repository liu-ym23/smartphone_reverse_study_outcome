package com.bytedance.ies.xelement.defaultimpl.player.impl;

import com.bytedance.ies.xelement.api.XResourceType;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.f;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import f76.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import l76.d;
import o76.k;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lf76/c;", "loadInfo", "", AbsMethodDelegate.TAG_INVOKE, "(Lf76/c;)V", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class ResourceLoaderPlayableTransformer$transformAsync$1 extends Lambda implements Function1<c, Unit> {
    final /* synthetic */ Function1<k, Unit> $callback;
    final /* synthetic */ f $origin;
    final /* synthetic */ b this$0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f249985a = null;

        static {
            int[] r100 = new int[XResourceType.values().length];
            r100[XResourceType.ASSET.ordinal()] = 1;
            r100[XResourceType.DISK.ordinal()] = 2;
            f249985a = r100;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ResourceLoaderPlayableTransformer$transformAsync$1(b r100, f r101, Function1<? super k, Unit> r102) {
        this.$origin = r101;
        this.$callback = r102;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(c r100) {
        Intrinsics.checkNotNullParameter(r100, "loadInfo");
        XResourceType r101 = r100.f475771c;
        if (r101 != null) goto L5;
        int r102 = -1;
    L7:
        if (r102 == 1) goto L20;
        if (r102 != 2) goto L30;
        String r103 = r100.f475770b;
        if (new PolarisFileWrapper(r103).exists() == false) goto L17;
        Function1<k, Unit> r104 = this.$callback;
        if (r104 == null) goto L29;
        r104.invoke(new k(this.$origin.getPlayUrl(), r103, null, 28));
        return;
    L29:
        return;
    L17:
        d r105 = d.f507797a;
        throw null;
    L30:
        return;
    L20:
        if (r100.f475770b != null) goto L27;
        int r106 = b.f249986a;
        throw null;
    L27:
        int r107 = b.f249986a;     // Catch: Throwable -> L25
        throw null;     // Catch: Throwable -> L25
    L25:
        d r108 = d.f507797a;
        throw null;
    L5:
        r102 = a.f249985a[r101.ordinal()];
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
