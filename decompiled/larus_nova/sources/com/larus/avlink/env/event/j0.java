package com.larus.avlink.env.event;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f292283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f292284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f292285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f292286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f292287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PopupWindow f292288f;

    public j0(Context r100, View r101, d0 r102, e0 r103, f0 r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "anchor");
        Intrinsics.checkNotNullParameter(r102, "onEditClick");
        Intrinsics.checkNotNullParameter(r103, "onDeleteClick");
        this.f292283a = r100;
        this.f292284b = r101;
        this.f292285c = r102;
        this.f292286d = r103;
        this.f292287e = r104;
    }
}
