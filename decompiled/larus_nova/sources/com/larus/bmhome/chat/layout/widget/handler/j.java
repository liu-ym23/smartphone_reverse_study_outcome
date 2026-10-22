package com.larus.bmhome.chat.layout.widget.handler;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class j implements pw8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f305032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f305033b;

    @Override // pw8.a
    public final void a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        TextView r101 = new TextView(this.f305032a);
        f r102 = this.f305033b;
        FLogger.f375446a.d(r102.f305022b, "[biz_deep_search] mindMapData Empty Holder...");
        r101.setTextSize(20.0f);
        r101.setText("Empty Holder...");
    }

    public j(Context r100, f r101) {
        this.f305032a = r100;
        this.f305033b = r101;
    }

    @Override // pw8.a
    public final void b(int r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r101, "currentViewGroup");
    }
}
