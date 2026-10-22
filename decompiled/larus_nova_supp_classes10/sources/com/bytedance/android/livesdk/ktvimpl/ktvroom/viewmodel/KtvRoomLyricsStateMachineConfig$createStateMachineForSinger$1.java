package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$a;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$b;", "", "invoke", "(Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class KtvRoomLyricsStateMachineConfig$createStateMachineForSinger$1 extends Lambda implements Function1<StateMachine.GraphBuilder<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>, Unit> {
    final /* synthetic */ KtvRoomLyricsStateMachineConfig.d $initState;
    final /* synthetic */ Function1 $listener;
    final /* synthetic */ Function1 $onEnterListener;

    public KtvRoomLyricsStateMachineConfig$createStateMachineForSinger$1(KtvRoomLyricsStateMachineConfig.d r1, Function1 r2, Function1 r3) {
        this.$initState = r1;
        this.$onEnterListener = r2;
        this.$listener = r3;
        super(1);
    }

    public final void invoke(StateMachine.GraphBuilder<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        r3.a(this.$initState);
        AnonymousClass1 r0 = AnonymousClass1.INSTANCE;
        int r1 = StateMachine.Matcher.c;
        r3.c(StateMachine.Matcher.a.a(KtvRoomLyricsStateMachineConfig.d.a.class), r0);
        AnonymousClass2 r2 = AnonymousClass2.INSTANCE;
        r3.c(StateMachine.Matcher.a.a(KtvRoomLyricsStateMachineConfig.d.b.class), r2);
        Function1<StateMachine.GraphBuilder<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>.StateDefinitionBuilder<KtvRoomLyricsStateMachineConfig.d.e>, Unit> r4 = new AnonymousClass3(this);
        r3.c(StateMachine.Matcher.a.a(KtvRoomLyricsStateMachineConfig.d.e.class), r4);
        Function1<StateMachine.GraphBuilder<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>.StateDefinitionBuilder<KtvRoomLyricsStateMachineConfig.d.f>, Unit> r5 = new AnonymousClass4(this);
        r3.c(StateMachine.Matcher.a.a(KtvRoomLyricsStateMachineConfig.d.f.class), r5);
        AnonymousClass5 r6 = AnonymousClass5.INSTANCE;
        r3.c(StateMachine.Matcher.a.a(KtvRoomLyricsStateMachineConfig.d.C0041d.class), r6);
        r3.b(this.$listener);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((StateMachine.GraphBuilder) r1);
        return Unit.INSTANCE;
    }
}
