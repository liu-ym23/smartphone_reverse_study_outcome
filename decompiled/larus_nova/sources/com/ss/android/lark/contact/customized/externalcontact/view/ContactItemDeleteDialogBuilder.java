package com.ss.android.lark.contact.customized.externalcontact.view;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
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
public final class ContactItemDeleteDialogBuilder extends UDBaseDialogBuilder<ContactItemDeleteDialogBuilder> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f419147j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f419148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f419149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f419150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f419151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f419152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f419153f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f419154g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f419155h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f419156i;

    public static final class a implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactItemDeleteDialogBuilder f419157a;

        public a(ContactItemDeleteDialogBuilder r100) {
            this.f419157a = r100;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            Function0<Unit> r101 = this.f419157a.f419149b;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    public final UDDialog a() {
        final UDDialog r100 = super.build();
        this.f419153f = new ContactItemDeleteDialogBuilder$buildDialog$1(r100);
        return r100;
    }

    public ContactItemDeleteDialogBuilder(final Context r100, final View r101, Function0<Unit> r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "itemView");
        Intrinsics.checkNotNullParameter(r102, "deleteAction");
        super(r100);
        this.f419148a = r102;
        this.f419149b = r103;
        int r104 = UIHelper.dp2px(10.0f);
        this.f419150c = r104;
        this.f419151d = UIHelper.dp2px(30.0f);
        this.f419152e = UIHelper.dp2px(8.0f);
        Rect r105 = new Rect();
        LazyThreadSafetyMode r106 = LazyThreadSafetyMode.NONE;
        Lazy r107 = LazyKt.lazy(r106, new ContactItemDeleteDialogBuilder$menuHeight$2(this));
        this.f419154g = r107;
        Lazy r108 = LazyKt.lazy(r106, new ContactItemDeleteDialogBuilder$isMenuOnBottom$2(r100, this, r101));
        this.f419155h = r108;
        Lazy r109 = LazyKt.lazy(r106, new ContactItemDeleteDialogBuilder$contentView$2(this, r101));
        this.f419156i = r109;
        r101.getGlobalVisibleRect(r105);
        gravity(48);
        int r110 = UIHelper.px2dp(UIUtils.calcViewScreenLocation(r101).top);
        Rect r111 = new Rect();
        r101.getWindowVisibleDisplayFrame(r111);
        int r112 = UIHelper.px2dp(r111.top);
        if (((Boolean) r108.getValue()).booleanValue() == true) goto L6;
        r110 = r110 - UIHelper.px2dp(((Number) r107.getValue()).intValue() + r104);
    L6:
        translationOnY(r110 - r112);
        contentLayout((View) r109.getValue());
        int r113 = r101.getMeasuredWidth();
        width(r113);
        maxWidth(new UDDimension.a(r113));
        backgroundColor(R.color.transparent);
        onDismissListener(new a(this));
    }
}
