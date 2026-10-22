package com.bytedance.ee.bear.middleground.permission.secret.detail;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f234065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f234066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<j> f234067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<a> f234068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<b> f234069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f234070f;

    public final Context getContext() {
        return this.f234065a;
    }

    public d(Context r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "mRootView");
        this.f234065a = r100;
        this.f234066b = r101;
        this.f234067c = new ArrayList();
        this.f234068d = new ArrayList();
        this.f234069e = new ArrayList();
        this.f234070f = 3;
    }
}
