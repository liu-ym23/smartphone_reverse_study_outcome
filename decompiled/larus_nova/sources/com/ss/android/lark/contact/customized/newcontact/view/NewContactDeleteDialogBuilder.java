package com.ss.android.lark.contact.customized.newcontact.view;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class NewContactDeleteDialogBuilder extends UDBaseDialogBuilder<NewContactDeleteDialogBuilder> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f419346i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f419347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f419348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f419349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f419350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f419351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f419352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f419353g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f419354h;

    public static final class a {
    }

    static {
    }

    public final UDDialog a() {
        final UDDialog r100 = super.build();
        this.f419351e = new NewContactDeleteDialogBuilder$buildDialog$1(r100);
        return r100;
    }

    public NewContactDeleteDialogBuilder(final Context r100, final View r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "itemView");
        Intrinsics.checkNotNullParameter(r102, "deleteAction");
        super(r100);
        this.f419347a = r102;
        int r103 = UIHelper.dp2px(10.0f);
        this.f419348b = r103;
        this.f419349c = UIHelper.dp2px(30.0f);
        this.f419350d = UIHelper.dp2px(8.0f);
        Rect r104 = new Rect();
        LazyThreadSafetyMode r105 = LazyThreadSafetyMode.NONE;
        Lazy r106 = LazyKt.lazy(r105, new NewContactDeleteDialogBuilder$menuHeight$2(this));
        this.f419352f = r106;
        Lazy r107 = LazyKt.lazy(r105, new NewContactDeleteDialogBuilder$isMenuOnBottom$2(r100, this, r101));
        this.f419353g = r107;
        Lazy r108 = LazyKt.lazy(r105, new NewContactDeleteDialogBuilder$contentView$2(this, r101));
        this.f419354h = r108;
        r101.getGlobalVisibleRect(r104);
        gravity(48);
        int r109 = UIHelper.px2dp(UIUtils.calcViewScreenLocation(r101).top);
        Rect r110 = new Rect();
        r101.getWindowVisibleDisplayFrame(r110);
        int r111 = UIHelper.px2dp(r110.top);
        if (((Boolean) r107.getValue()).booleanValue() == true) goto L6;
        r109 = r109 - UIHelper.px2dp(((Number) r106.getValue()).intValue() + r103);
    L6:
        translationOnY(r109 - r111);
        contentLayout((View) r108.getValue());
        int r112 = r101.getMeasuredWidth();
        width(r112);
        maxWidth(new UDDimension.a(r112));
        backgroundColor(R.color.transparent);
    }
}
