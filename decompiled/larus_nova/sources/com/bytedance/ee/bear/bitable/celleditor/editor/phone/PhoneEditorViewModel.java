package com.bytedance.ee.bear.bitable.celleditor.editor.phone;

import com.bytedance.ee.bear.bitable.celleditor.bean.EditorLocation;
import com.bytedance.ee.bear.bitable.celleditor.editor.b;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.telephoneability.TelephoneAbilityViewModel;
import hr4.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class PhoneEditorViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f209436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TelephoneAbilityViewModel f209437b;

    public PhoneEditorViewModel(a r100) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        this.f209436a = r100;
        this.f209437b = (TelephoneAbilityViewModel) q.b(r100.f486863e, TelephoneAbilityViewModel.class);
    }

    public final void a(final EditorLocation r100, final b r101) {
        final String r102 = Integer.toHexString(r100.hashCode());
        this.f209437b.getSearchContractResult().observe(this.f209436a.f486859a, new PhoneEditorViewModel$showContract$1(r102, this, r101, r100));
        this.f209437b.getSearchContractAction().postValue(new c45.a(r102));
    }
}
