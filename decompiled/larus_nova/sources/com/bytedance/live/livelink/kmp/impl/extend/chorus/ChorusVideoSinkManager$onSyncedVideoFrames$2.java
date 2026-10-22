package com.bytedance.live.livelink.kmp.impl.extend.chorus;

import com.bytedance.live.livelink.kmp.impl.base.thread.CustomWorkThreadImpl;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class ChorusVideoSinkManager$onSyncedVideoFrames$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String[] $uids;
    final /* synthetic */ fg2.a[] $videoFrames;
    final /* synthetic */ ChorusVideoSinkManager this$0;

    public ChorusVideoSinkManager$onSyncedVideoFrames$2(ChorusVideoSinkManager r100, String[] r101, fg2.a[] r102) {
        this.this$0 = r100;
        this.$uids = r101;
        this.$videoFrames = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String[] r100 = this.$uids;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L23;
        final String r104 = r100[r102];
        int r105 = r103 + 1;
        final fg2.a r106 = (fg2.a) ArraysKt.getOrNull(this.$videoFrames, r103);
        if (r106 == null) goto L22;
        if (((ArrayList) this.this$0.f255559a).contains(r104) == false) goto L19;
        ChorusVideoSinkManager r107 = this.this$0;
        LinkedHashMap r108 = (LinkedHashMap) r107.f255560b;
        Object r109 = r108.get(r104);
        if (r109 != null) goto L16;
        String r110 = "ConsumerVideoDispatcher_" + r104;
        Intrinsics.checkNotNullParameter(r107, "$this$newThread");
        Intrinsics.checkNotNullParameter(r110, "name");
        oi6.d r111 = r107.c().f255514c;
        if (r111 == null) goto L14;
        CustomWorkThreadImpl r112 = r111.e(r110);
    L15:
        r109 = r112;
        r108.put(r104, r109);
        goto L16
    L14:
        r112 = null;
    L16:
        oi6.b r113 = (oi6.b) r109;
        if (r113 == null) goto L19;
        boolean r114 = oi6.a.a(r113, new ChorusVideoSinkManager$onSyncedVideoFrames$2$$special$$inlined$forEachIndexed$lambda$1(r104, r106, this), "ChorusVideoSinkManager onSyncVideoFrames");
    L20:
        if (r114 == true) goto L22;
        r106.releaseRef();
    L19:
        r114 = false;
    L22:
        r102 = r102 + 1;
        r103 = r105;
        goto L3
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
