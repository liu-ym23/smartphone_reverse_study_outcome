package com.larus.bmhome.bot;

import android.widget.CompoundButton;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class b6 implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f296518a;

    public /* synthetic */ b6(Function1 r100) {
        this.f296518a = r100;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        Function1 r102 = this.f296518a;
        int r103 = ServiceBotSettingFragment.f296490i;
        r102.invoke(Boolean.valueOf(r101));
    }
}
