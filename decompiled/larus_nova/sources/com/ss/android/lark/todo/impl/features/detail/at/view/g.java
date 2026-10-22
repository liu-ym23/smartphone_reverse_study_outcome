package com.ss.android.lark.todo.impl.features.detail.at.view;

import android.animation.ValueAnimator;
import androidx.lifecycle.Observer;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoAtView f442820a;

    public g(TodoAtView r100) {
        this.f442820a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        final List r101 = (List) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if (CollectionUtils.isEmpty(r101) == false) goto L5;
        this.f442820a.setVisibility(8);
        return;
    L5:
        final TodoAtView r102 = this.f442820a;
        Function0<Unit> r103 = new TodoAtView$initView$3$1(r102, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "callback");
        Log.i("TodoAtView", "show");
        if (r102.f442796k == false) goto L21;
        r102.f442789d.a(true);
        r102.f442797l = true;
        if (r102.getVisibility() != 0) goto L11;
        r103.invoke();
        return;
    L11:
        ValueAnimator r104 = r102.f442792g;
        if (r104 != null) goto L14;
        return;
    L14:
        if (r104.isRunning() == true) goto L22;
        r104.addListener(new i(r103, r104));
        r104.start();
        return;
    L22:
        return;
    }
}
