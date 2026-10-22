package com.larus.bmhome.taskskill.ui;

import com.larus.flowskill.impl.databinding.LarusLayoutTaskSkillStateBinding;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f314585b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutTaskSkillStateBinding f314586a;

    public static final class a {
    }

    static {
    }

    public final void a() {
        this.f314586a.f343575a.setVisibility(8);
    }

    public final void c() {
        this.f314586a.f343577c.setImageResource(R.drawable.larus_ic_skill_light);
        this.f314586a.f343578d.setText(R.string.larus_LarkIM_Common_LoadFailed_EmptyState);
        this.f314586a.f343576b.setVisibility(0);
        this.f314586a.f343575a.setVisibility(0);
    }

    public q(LarusLayoutTaskSkillStateBinding r100, final Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        Intrinsics.checkNotNullParameter(r101, "onRetry");
        this.f314586a = r100;
        r100.f343576b.setOnClickListener(new p(r101));
    }

    public final void b(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f314586a.f343577c.setImageResource(r100);
        this.f314586a.f343578d.setText(r101);
        this.f314586a.f343576b.setVisibility(8);
        this.f314586a.f343575a.setVisibility(0);
    }
}
