package com.bytedance.ee.bear.bitable.homepage;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class i0 implements com.ss.android.lark.maintab.export.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f212735a;

    @Override // com.ss.android.lark.maintab.export.d
    public final void a() {
    }

    @Override // com.ss.android.lark.maintab.export.d
    public final void b() {
    }

    @Override // com.ss.android.lark.maintab.export.d
    public final void c() {
    }

    @Override // com.ss.android.lark.maintab.export.d
    public final void x() {
    }

    @Override // com.ss.android.lark.maintab.export.d
    public final int getTitleBarHeight() {
        return (int) this.f212735a.getResources().getDimension(R.dimen.list_home_title_bar_height_min);
    }

    public final Context getContext() {
        return this.f212735a;
    }

    public i0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f212735a = r100;
    }
}
