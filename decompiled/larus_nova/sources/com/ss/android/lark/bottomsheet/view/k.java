package com.ss.android.lark.bottomsheet.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.ui.CommonTitleBarConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class k implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f410764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f410765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f410766c;

    public static final class a {
    }

    public static final class b implements Function2<Context, View, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f410767a;

        public b(float r100) {
            this.f410767a = r100;
        }

        public final void a(Context r100, View r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "targetTitleView");
            ViewGroup.LayoutParams r102 = r101.getLayoutParams();
            if (r102 == null) goto L7;
            ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
            float r104 = this.f410767a;
            float r105 = CommonTitleBarConstants.TITLE_BAR_HEIGHT_FULL_SCREEN;
            float r106 = CommonTitleBarConstants.TITLE_BAR_HEIGHT_BOTTOM_SHEET;
            r103.height = ((int) (r104 * UIUtils.dp2px(r100, r105 - r106))) + UIUtils.dp2px(r100, r106);
            r101.setLayoutParams(r103);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }

        @Override // kotlin.jvm.functions.Function2
        public final /* bridge */ /* synthetic */ Unit invoke(Context r100, View r101) {
            a(r100, r101);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.bottomsheet.view.j
    public final void c() {
        d(0.0f);
    }

    @Override // com.ss.android.lark.bottomsheet.view.j
    public final void b() {
        d(1.0f);
    }

    public final Context getContext() {
        return this.f410764a;
    }

    public k(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f410764a = r100;
    }

    @Override // com.ss.android.lark.bottomsheet.view.j
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "targetTitleView");
        if (Intrinsics.areEqual(r100, this.f410765b) == false) goto L5;
        return;
    L5:
        this.f410765b = r100;
        b r101 = this.f410766c;
        if (r101 == null) goto L11;
        if (r101 == null) goto L9;
        r101.a(this.f410764a, r100);
    L9:
        this.f410766c = null;
        return;
    }

    @Override // com.ss.android.lark.bottomsheet.view.j
    public final void d(float r100) {
        View r101 = this.f410765b;
        if (r101 != null) goto L6;
        Log.e("TitleBarHeightOperator", "target title is null");
        this.f410766c = new b(r100);
        return;
    L6:
        if (r101 == null) goto L12;
        Context r102 = this.f410764a;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "targetTitleView");
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        if (r103 == null) goto L11;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
        float r105 = CommonTitleBarConstants.TITLE_BAR_HEIGHT_FULL_SCREEN;
        float r106 = CommonTitleBarConstants.TITLE_BAR_HEIGHT_BOTTOM_SHEET;
        r104.height = ((int) (r100 * UIUtils.dp2px(r102, r105 - r106))) + UIUtils.dp2px(r102, r106);
        r101.setLayoutParams(r104);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
