package com.ss.android.lark.contact.customized.mygroup.view;

import androidx.lifecycle.Observer;
import com.ss.android.lark.contact.customized.databinding.ContactDbFragmentOfficeMyJoinGroupBinding;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeMyJoinGroupFragment f419313a;

    public c(OfficeMyJoinGroupFragment r100) {
        this.f419313a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Unit r101 = (Unit) r100;
        ContactDbFragmentOfficeMyJoinGroupBinding r102 = this.f419313a.f419304e;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r102 = null;
    L5:
        r102.f419020d.refreshComplete();
    }
}
