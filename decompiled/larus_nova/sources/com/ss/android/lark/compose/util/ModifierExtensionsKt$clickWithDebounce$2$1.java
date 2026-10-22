package com.ss.android.lark.compose.util;

import androidx.compose.runtime.MutableState;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.time.TimeMark;
import kotlin.time.TimeSource;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ModifierExtensionsKt$clickWithDebounce$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $debounceMillis;
    final /* synthetic */ MutableState<TimeMark> $lastClickTime$delegate;
    final /* synthetic */ Function0<Unit> $onClick;

    public ModifierExtensionsKt$clickWithDebounce$2$1(long r100, Function0<Unit> r101, MutableState<TimeMark> r102) {
        this.$debounceMillis = r100;
        this.$onClick = r101;
        this.$lastClickTime$delegate = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        TimeMark r100 = this.$lastClickTime$delegate.getValue();
        if (r100 == null) goto L5;
        Duration r101 = Duration.m10791boximpl(r100.mo10783elapsedNowUwyO8pc());
    L6:
        long r102 = this.$debounceMillis;
        if (r101 == null) goto L12;
        long r103 = r101.m10848unboximpl();
        Duration.Companion r104 = Duration.Companion;
        if (Duration.m10792compareToLRDsOJo(r103, DurationKt.toDuration(r102, DurationUnit.MILLISECONDS)) > 0) goto L12;
        boolean r105 = false;
    L13:
        if (r105 == false) goto L16;
        this.$lastClickTime$delegate.setValue(TimeSource.Monotonic.ValueTimeMark.m10933boximpl(TimeSource.Monotonic.INSTANCE.m10932markNowz9LOYto()));
        this.$onClick.invoke();
        return;
    L16:
        return;
    L12:
        r105 = true;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
