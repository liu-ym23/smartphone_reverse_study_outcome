package com.larus.avlink.aiproactive;

import android.widget.CompoundButton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class t implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AiProactiveTaskAdapter.TaskViewHolder f291606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t88.n f291607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f291608c;

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "buttonView");
        if (this.f291606a.f291524a.vu(this.f291607b, r101) == true) goto L6;
        r100.setOnCheckedChangeListener(null);
        r100.setChecked(this.f291608c);
        r100.setOnCheckedChangeListener(this);
        return;
    }

    public t(AiProactiveTaskAdapter.TaskViewHolder r100, t88.n r101, boolean r102) {
        this.f291606a = r100;
        this.f291607b = r101;
        this.f291608c = r102;
    }
}
