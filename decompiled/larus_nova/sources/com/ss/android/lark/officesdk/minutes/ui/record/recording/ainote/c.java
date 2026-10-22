package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.widget.CompoundButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f436079a;

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function1<? super Boolean, Unit> r100) {
        this.f436079a = r100;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        this.f436079a.invoke(Boolean.valueOf(r101));
    }
}
