package com.larksuite.component.blockit.hashtag.list;

import android.view.View;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class i extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HashTagSwipeAdapter f283054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ oy7.e f283055b;

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f283054a.f283028c.a(this.f283055b);
    }

    public i(HashTagSwipeAdapter r100, int r101, oy7.e r102) {
        this.f283054a = r100;
        this.f283055b = r102;
    }
}
