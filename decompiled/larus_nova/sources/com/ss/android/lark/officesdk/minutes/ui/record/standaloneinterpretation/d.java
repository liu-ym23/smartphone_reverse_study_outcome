package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import android.widget.CompoundButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes37.dex */
public final class d implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f436752a;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function1<? super Boolean, Unit> r100) {
        this.f436752a = r100;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        this.f436752a.invoke(Boolean.valueOf(r101));
    }
}
