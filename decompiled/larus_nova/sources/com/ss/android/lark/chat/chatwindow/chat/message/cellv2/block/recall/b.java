package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.recall;

import android.view.View;
import b3b.d;
import b3b.f;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v5b.a<?> f413223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f413224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y6b.a<v5b.a<?>> f413225c;

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        if ((this.f413223a instanceof BaseTextContentVO) == false) goto L6;
        this.f413224b.K6(this.f413225c);
        return;
    }

    public b(v5b.a r100, f r101, y6b.a r102) {
        this.f413223a = r100;
        this.f413224b = r101;
        this.f413225c = r102;
    }
}
