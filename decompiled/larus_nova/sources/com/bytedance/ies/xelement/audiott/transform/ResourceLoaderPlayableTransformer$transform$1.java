package com.bytedance.ies.xelement.audiott.transform;

import com.bytedance.ies.xelement.api.XResourceType;
import com.bytedance.ies.xelement.audiott.bean.XAudioSrc;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lf76/c;", "loadInfo", "", AbsMethodDelegate.TAG_INVOKE, "(Lf76/c;)V", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class ResourceLoaderPlayableTransformer$transform$1 extends Lambda implements Function1<f76.c, Unit> {
    final /* synthetic */ Function1<g76.a, Unit> $callback;
    final /* synthetic */ XAudioSrc $origin;
    final /* synthetic */ c this$0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f249768a = null;

        static {
            int[] r100 = new int[XResourceType.values().length];
            r100[XResourceType.ASSET.ordinal()] = 1;
            r100[XResourceType.DISK.ordinal()] = 2;
            f249768a = r100;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ResourceLoaderPlayableTransformer$transform$1(c r100, XAudioSrc r101, Function1<? super g76.a, Unit> r102) {
        this.$origin = r101;
        this.$callback = r102;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(f76.c r110) {
        Intrinsics.checkNotNullParameter(r110, "loadInfo");
        XResourceType r100 = r110.f475771c;
        if (r100 != null) goto L5;
        int r101 = -1;
    L7:
        if (r101 == 1) goto L19;
        if (r101 != 2) goto L28;
        String r102 = r110.f475770b;
        if (new PolarisFileWrapper(r102).exists() == false) goto L17;
        Function1<g76.a, Unit> r111 = this.$callback;
        if (r111 == null) goto L27;
        r111.invoke(new g76.a(this.$origin.getPlayUrl(), r102, null, null, this.$origin.getPlayModel(), 12));
        return;
    L27:
        return;
    L17:
        throw null;
    L28:
        return;
    L19:
        if (r110.f475770b != null) goto L25;
        int r112 = c.f249771b;
        throw null;
    L25:
        int r113 = c.f249771b;     // Catch: Throwable -> L24
        throw null;     // Catch: Throwable -> L24
    L29:
        throw null;
    L24:
        throw null;
    L5:
        r101 = a.f249768a[r100.ordinal()];
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(f76.c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
