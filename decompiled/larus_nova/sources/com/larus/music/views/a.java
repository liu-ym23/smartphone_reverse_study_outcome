package com.larus.music.views;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sl9.e;
import sl9.f;
import sl9.g;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f359602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super DialogFragment, Unit> f359603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super DialogFragment, Unit> f359604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super DialogFragment, Unit> f359605d;

    public final CommonApplicationDialog a() {
        int r100 = CommonApplicationDialog.f359597h;
        Bundle r101 = this.f359602a;
        Intrinsics.checkNotNullParameter(r101, "args");
        final CommonApplicationDialog r102 = new CommonApplicationDialog();
        r102.setArguments(r101);
        r102.f359598d = new e(this, r102);
        r102.f359600f = new f(this, r102);
        r102.f359599e = new g(this, r102);
        return r102;
    }

    public a() {
        this.f359602a = new Bundle();
    }
}
