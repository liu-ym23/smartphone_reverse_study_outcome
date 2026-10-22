package com.bytedance.android.livesdk.ktvimpl.ktvroom.behavior;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvRoomViewWrapper {
    public final LifecycleOwner a;
    public final c b;
    public final a c;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.behavior.KtvRoomViewWrapper$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lub0/a;", "p1", "", "invoke", "(Lub0/a;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ub0.a, Unit> {
        public AnonymousClass1(a r8) {
            super(1, r8, a.class, "onLyricsParseResult", "onLyricsParseResult(Lcom/bytedance/android/live/ktv/common/music/lyric/model/LyricsChangeEvent;)V", 0);
        }

        public final void invoke(ub0.a r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ((a) ((CallableReference) this).receiver).r8(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((ub0.a) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.behavior.KtvRoomViewWrapper$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Long, Unit> {
        public AnonymousClass2(a r8) {
            super(1, r8, a.class, "onListenerProgress", "onListenerProgress(J)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r3) {
            invoke(((Number) r3).longValue());
            return Unit.INSTANCE;
        }

        public final void invoke(long r2) {
            ((a) ((CallableReference) this).receiver).c8(r2);
        }
    }

    public KtvRoomViewWrapper(LifecycleOwner r2, c r3, a r4) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "listenerHandler");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        if (r3 == null) goto L5;
        r3.observerOnLyricsChange(r2, new AnonymousClass1(r4));
    L5:
        if (r3 == null) goto L8;
        r3.observerOnProgress(r2, new AnonymousClass2(r4));
        return;
    }
}
