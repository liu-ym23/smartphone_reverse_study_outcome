package com.obric.assistant.provider;

import android.database.MatrixCursor;
import com.obric.assistant.settings.AILabSettingItem;
import com.obric.assistant.settings.IAILabService;
import com.obric.assistant.settings.ObricPersonalContextSettingApiDelegate;
import com.obric.assistant.settings.ToggleName;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.provider.ObricPersonalContextSettingProvider$addAllDataSourceToggles$1$1$1", f = "ObricPersonalContextSettingProvider.kt", i = {0}, l = {159, 168}, m = "invokeSuspend", n = {"aiLabService"}, s = {"L$0"})
final class ObricPersonalContextSettingProvider$addAllDataSourceToggles$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObricPersonalContextSettingApiDelegate $it;
    final /* synthetic */ boolean $oldMemorySwitch;
    final /* synthetic */ MatrixCursor $this_apply;
    Object L$0;
    int label;

    public ObricPersonalContextSettingProvider$addAllDataSourceToggles$1$1$1(MatrixCursor r100, ObricPersonalContextSettingApiDelegate r101, boolean r102, Continuation<? super ObricPersonalContextSettingProvider$addAllDataSourceToggles$1$1$1> r103) {
        this.$this_apply = r100;
        this.$it = r101;
        this.$oldMemorySwitch = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricPersonalContextSettingProvider$addAllDataSourceToggles$1$1$1(this.$this_apply, this.$it, this.$oldMemorySwitch, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ObricPersonalContextSettingProvider$addAllDataSourceToggles$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L10;
        if (r101 == 1) goto L9;
        if (r101 != 2) goto L8;
        ResultKt.throwOnFailure(r110);
    L27:
        if (((Boolean) r110).booleanValue() != true) goto L29;
        boolean r111 = true;
    L30:
        if (r111 == false) goto L32;
        MatrixCursor r112 = this.$this_apply;
        ToggleName r102 = ToggleName.HEARING_MEMORY;
        r112.addRow(new String[]{r102.getToggleName(), String.valueOf(this.$it.j(r102, this.$oldMemorySwitch))});
    L34:
        return Unit.INSTANCE;
    L32:
        this.$this_apply.addRow(new String[]{ToggleName.HEARING_MEMORY.getToggleName(), "false"});
    L29:
        r111 = false;
        goto L30
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        IAILabService r103 = (IAILabService) this.L$0;
        ResultKt.throwOnFailure(r110);
    L16:
        if (((Boolean) r110).booleanValue() != true) goto L18;
        boolean r113 = true;
    L19:
        if (r113 == false) goto L21;
        MatrixCursor r114 = this.$this_apply;
        ToggleName r104 = ToggleName.SCREEN_MEMORY;
        r114.addRow(new String[]{r104.getToggleName(), String.valueOf(this.$it.j(r104, this.$oldMemorySwitch))});
        MatrixCursor r115 = this.$this_apply;
        ToggleName r105 = ToggleName.AI_DIARY;
        r115.addRow(new String[]{r105.getToggleName(), String.valueOf(this.$it.j(r105, true))});
    L22:
        if (r103 == null) goto L29;
        AILabSettingItem r116 = AILabSettingItem.VoiceMemory;
        this.L$0 = null;
        this.label = 2;
        r110 = r103.b(r116, this);
        if (r110 != r100) goto L27;
        return r100;
    L21:
        this.$this_apply.addRow(new String[]{ToggleName.SCREEN_MEMORY.getToggleName(), "false"});
        this.$this_apply.addRow(new String[]{ToggleName.AI_DIARY.getToggleName(), "false"});
    L18:
        r113 = false;
        goto L19
    L10:
        ResultKt.throwOnFailure(r110);
        r103 = (IAILabService) ServiceManager.get().getService(IAILabService.class);
        MatrixCursor r117 = this.$this_apply;
        ToggleName r106 = ToggleName.GLOBAL_MEMORY;
        r117.addRow(new String[]{r106.getToggleName(), String.valueOf(this.$it.j(r106, false))});
        if (r103 == null) goto L18;
        AILabSettingItem r118 = AILabSettingItem.ScreenMemory;
        this.L$0 = r103;
        this.label = 1;
        r110 = r103.b(r118, this);
        if (r110 != r100) goto L16;
        return r100;
    }
}
