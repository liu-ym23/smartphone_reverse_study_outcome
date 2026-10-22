package com.bytedance.live.livelink.kmp.impl.extend.spatialaudio;

import com.bytedance.live.livelink.kmp.impl.extend.c;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class SpatialAudioManager$removeAllRemotePosition$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $roomID;
    final /* synthetic */ SpatialAudioManager this$0;

    public SpatialAudioManager$removeAllRemotePosition$1(SpatialAudioManager r100, String r101) {
        this.this$0 = r100;
        this.$roomID = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        c.k(this.this$0, this.$roomID);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
