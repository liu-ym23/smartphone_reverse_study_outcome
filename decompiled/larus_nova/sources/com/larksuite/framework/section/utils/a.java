package com.larksuite.framework.section.utils;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: com.larksuite.framework.section.utils.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC3927a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.larksuite.framework.section.c f285701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.todo.impl.features.detail.viewmodel.a f285702b;

        public ViewOnClickListenerC3927a(com.larksuite.framework.section.c r100, com.ss.android.lark.todo.impl.features.detail.viewmodel.a r101) {
            this.f285701a = r100;
            this.f285702b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f285701a.a(this.f285702b);
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.todo.impl.features.detail.viewmodel.a[] f285703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.larksuite.framework.section.c f285704b;

        public b(com.ss.android.lark.todo.impl.features.detail.viewmodel.a[] r100, com.larksuite.framework.section.c r101) {
            this.f285703a = r100;
            this.f285704b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.ss.android.lark.todo.impl.features.detail.viewmodel.a[] r101 = this.f285703a;
            com.larksuite.framework.section.c r102 = this.f285704b;
            int r103 = r101.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L5;
            r102.a(r101[r104]);
            r104 = r104 + 1;
            goto L3
        }
    }

    public static final class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2<View, MotionEvent, Unit>[] f285705a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function2<? super View, ? super MotionEvent, Unit>[] r100) {
            this.f285705a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            if (r101.getAction() != 0) goto L7;
            Function2<View, MotionEvent, Unit>[] r102 = this.f285705a;
            int r103 = r102.length;
            int r104 = 0;
        L5:
            if (r104 >= r103) goto L7;
            Function2<View, MotionEvent, Unit> r105 = r102[r104];
            Intrinsics.checkNotNull(r100);
            Intrinsics.checkNotNull(r101);
            r105.invoke(r100, r101);
            r104 = r104 + 1;
        L7:
            return false;
        }
    }

    public static final void c(View r100, Function2<? super View, ? super MotionEvent, Unit>... r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "blocks");
        r100.setOnTouchListener(new c(r101));
    }

    public static final void d(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == false) goto L5;
        r100.setVisibility(0);
        return;
    L5:
        r100.setVisibility(8);
    }

    public static final void e(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == false) goto L5;
        r100.setVisibility(0);
        return;
    L5:
        r100.setVisibility(4);
    }

    public static final void a(View r100, com.larksuite.framework.section.c r101, com.ss.android.lark.todo.impl.features.detail.viewmodel.a r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "dispatcher");
        Intrinsics.checkNotNullParameter(r102, "action");
        r100.setOnClickListener(new ViewOnClickListenerC3927a(r101, r102));
    }

    public static final void b(View r100, com.larksuite.framework.section.c r101, com.ss.android.lark.todo.impl.features.detail.viewmodel.a... r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "dispatcher");
        Intrinsics.checkNotNullParameter(r102, SlcCommonAction.KEY_ACTIONS);
        r100.setOnClickListener(new b(r102, r101));
    }
}
