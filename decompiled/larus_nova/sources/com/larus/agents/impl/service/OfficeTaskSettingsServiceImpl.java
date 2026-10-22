package com.larus.agents.impl.service;

import android.content.Context;
import android.content.Intent;
import com.larus.agents.api.IOfficeTaskSettingsService;
import com.larus.agents.api.OfficeTaskPreferenceSaveResult;
import com.larus.agents.impl.settings.DefaultOfficeTaskPreferenceRepository;
import com.larus.agents.impl.settings.b;
import com.larus.agents.impl.ui.OfficeTaskSettingsActivity;
import com.larus.bmhome.bot.CommonSettingFragment;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/agents/impl/service/OfficeTaskSettingsServiceImpl;", "Lcom/larus/agents/api/IOfficeTaskSettingsService;", "<init>", "()V", "repository", "Lcom/larus/agents/impl/settings/OfficeTaskPreferenceRepository;", "showSettingsPage", "", "hostFragment", "Landroidx/fragment/app/Fragment;", "getPreferenceInstruction", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePreferenceInstruction", "Lcom/larus/agents/api/OfficeTaskPreferenceSaveResult;", "instruction", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeTaskSettingsServiceImpl implements IOfficeTaskSettingsService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DefaultOfficeTaskPreferenceRepository f286706a;

    public OfficeTaskSettingsServiceImpl() {
        this.f286706a = new DefaultOfficeTaskPreferenceRepository(0);
    }

    @Override // com.larus.agents.api.IOfficeTaskSettingsService
    public final void b(CommonSettingFragment r100) {
        Intrinsics.checkNotNullParameter(r100, "hostFragment");
        Context r101 = r100.getContext();
        if (r101 != null) goto L5;
        return;
    L5:
        r100.startActivity(new Intent(r101, OfficeTaskSettingsActivity.class));
    }

    @Override // com.larus.agents.api.IOfficeTaskSettingsService
    public final Object c(Continuation<? super String> r100) {
        if ((r100 instanceof OfficeTaskSettingsServiceImpl$getPreferenceInstruction$1) == false) goto L7;
        OfficeTaskSettingsServiceImpl$getPreferenceInstruction$1 r101 = (OfficeTaskSettingsServiceImpl$getPreferenceInstruction$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L18:
        return ((b) r103).f286712a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        DefaultOfficeTaskPreferenceRepository r106 = this.f286706a;
        r101.label = 1;
        r103 = r106.a(r101);
        if (r103 != r104) goto L18;
        return r104;
    L7:
        r101 = new OfficeTaskSettingsServiceImpl$getPreferenceInstruction$1(this, r100);
        goto L8
    }

    @Override // com.larus.agents.api.IOfficeTaskSettingsService
    public final Object a(String r100, Continuation<? super OfficeTaskPreferenceSaveResult> r101) {
        return this.f286706a.b(r100, r101);
    }
}
