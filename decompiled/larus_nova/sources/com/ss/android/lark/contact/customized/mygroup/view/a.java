package com.ss.android.lark.contact.customized.mygroup.view;

import android.view.View;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeMyGroupAdapter f419309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Chat f419310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f419311c;

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Function2<? super Chat, ? super Integer, Unit> r101 = this.f419309a.f419296b;
        if (r101 == null) goto L6;
        r101.invoke(this.f419310b, Integer.valueOf(this.f419311c));
        return;
    }

    public a(OfficeMyGroupAdapter r100, Chat r101, int r102) {
        this.f419309a = r100;
        this.f419310b = r101;
        this.f419311c = r102;
    }
}
