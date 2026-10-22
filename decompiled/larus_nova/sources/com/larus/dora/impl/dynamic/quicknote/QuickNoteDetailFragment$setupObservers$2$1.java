package com.larus.dora.impl.dynamic.quicknote;

import com.larus.dora.impl.databinding.LarusDoraPageQuickNoteDetailBinding;
import com.larus.dora.impl.device.settings.gesture.GestureSettingsRepository;
import com.larus.dora.impl.device.settings.gesture.c0;
import com.larus.dora.impl.dynamic.quicknote.views.QuickNoteItemTextSelectorSubTitle;
import com.larus.dora.impl.model.GestureSettingsKey;
import com.larus.dora.impl.network.z;
import com.larus.nova.R;
import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class QuickNoteDetailFragment$setupObservers$2$1<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ QuickNoteDetailFragment f335236a;

    public QuickNoteDetailFragment$setupObservers$2$1(QuickNoteDetailFragment r100) {
        this.f335236a = r100;
    }

    public final Object a(c0 r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof QuickNoteDetailFragment$setupObservers$2$1$emit$1) == false) goto L7;
        QuickNoteDetailFragment$setupObservers$2$1$emit$1 r100 = (QuickNoteDetailFragment$setupObservers$2$1$emit$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        LarusDoraPageQuickNoteDetailBinding r113 = (LarusDoraPageQuickNoteDetailBinding) r100.L$3;
        QuickNoteDetailFragment r104 = (QuickNoteDetailFragment) r100.L$2;
        LarusDoraPageQuickNoteDetailBinding r105 = (LarusDoraPageQuickNoteDetailBinding) r100.L$1;
        c0 r106 = (c0) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L22:
        z r114 = (z) r112;
        String r107 = null;
        if (r114 == null) goto L25;
        String r108 = r114.b();
    L27:
        if (r108 != null) goto L29;
    L32:
        boolean r109 = true;
    L34:
        if (r109 == false) goto L36;
        QuickNoteItemTextSelectorSubTitle r115 = r113.f333226c;
        StringCompanionObject r116 = StringCompanionObject.INSTANCE;
        String r117 = r104.getString(R.string.larus_dora_current_gesture_cn);
        GestureSettingsRepository r118 = GestureSettingsRepository.f334402a;
        Byte r119 = ((c0.c) r106).f334431a.get(GestureSettingsKey.MEDIA_LEFT_DOUBLE_CLICK);
        r118.getClass();
        r115.setSubTitle(String.format(r117, Arrays.copyOf(new Object[]{GestureSettingsRepository.i(r119)}, 1)));
    L36:
        if (r114 == null) goto L38;
        r107 = r114.d();
    L38:
        if (r107 != null) goto L40;
    L43:
        boolean r120 = true;
    L44:
        if (r120 == false) goto L54;
        QuickNoteItemTextSelectorSubTitle r121 = r113.f333227d;
        StringCompanionObject r122 = StringCompanionObject.INSTANCE;
        String r123 = r104.getString(R.string.larus_dora_current_gesture_cn);
        GestureSettingsRepository r124 = GestureSettingsRepository.f334402a;
        Byte r125 = ((c0.c) r106).f334431a.get(GestureSettingsKey.MEDIA_RIGHT_DOUBLE_CLICK);
        r124.getClass();
        r121.setSubTitle(String.format(r123, Arrays.copyOf(new Object[]{GestureSettingsRepository.i(r125)}, 1)));
    L54:
        return Unit.INSTANCE;
    L40:
        if (r107.length() == 0) goto L43;
        r120 = false;
        goto L44
    L29:
        if (r108.length() == 0) goto L32;
        r109 = false;
        goto L34
    L25:
        r108 = null;
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        if ((r110 instanceof c0.c) == false) goto L47;
        QuickNoteDetailFragment r126 = this.f335236a;
        LarusDoraPageQuickNoteDetailBinding r127 = r126.f335232f;
        if (r127 == null) goto L54;
        QuickNoteRepo r128 = QuickNoteRepo.f335241a;
        r100.L$0 = r110;
        r100.L$1 = r127;
        r100.L$2 = r126;
        r100.L$3 = r127;
        r100.label = 1;
        Object r129 = r128.c(r100);
        if (r129 != r102) goto L21;
        return r102;
    L21:
        r104 = r126;
        r112 = r129;
        r106 = r110;
        r113 = r127;
        goto L22
    L47:
        if (Intrinsics.areEqual(r110, c0.b.f334430a) == true) goto L54;
        if (Intrinsics.areEqual(r110, c0.a.f334429a) == true) goto L54;
        throw new NoWhenBranchMatchedException();
    L7:
        r100 = new QuickNoteDetailFragment$setupObservers$2$1$emit$1(this, r111);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
        return a((c0) r100, r101);
    }
}
