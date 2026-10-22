package com.larus.xbridge.impl.choosemedia.utils;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016Ra\u0010\u0004\u001aI\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/xbridge/impl/choosemedia/utils/AssistResultFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "onActivityResult", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "", "getOnActivityResult", "()Lkotlin/jvm/functions/Function3;", "setOnActivityResult", "(Lkotlin/jvm/functions/Function3;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssistResultFragment extends Fragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function3<? super Integer, ? super Integer, ? super Intent, Unit> f379897d;

    public AssistResultFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        Function3<? super Integer, ? super Integer, ? super Intent, Unit> r103 = this.f379897d;
        if (r103 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("onActivityResult");
        r103 = null;
    L6:
        r103.invoke(Integer.valueOf(r100), Integer.valueOf(r101), r102);
    }
}
