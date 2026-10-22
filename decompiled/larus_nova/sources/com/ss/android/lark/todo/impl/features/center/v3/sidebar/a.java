package com.ss.android.lark.todo.impl.features.center.v3.sidebar;

import android.view.View;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: com.ss.android.lark.todo.impl.features.center.v3.sidebar.a$a, reason: collision with other inner class name */
    public static final class C5321a extends OnSingleClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<View, Unit> f441690a;

        /* JADX WARN: Multi-variable type inference failed */
        public C5321a(Function1<? super View, Unit> r100) {
            this.f441690a = r100;
        }

        @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
        public final void onSingleClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f441690a.invoke(r100);
        }
    }

    public static final void a(View r100, Function1<? super View, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onClick);
        r100.setOnClickListener(new C5321a(r101));
    }
}
