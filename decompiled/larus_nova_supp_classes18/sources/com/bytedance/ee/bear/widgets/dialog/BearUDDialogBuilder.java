package com.bytedance.ee.bear.widgets.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class BearUDDialogBuilder {
    public final UDDialogBuilder a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/widgets/dialog/BearUDDialogBuilder$ActionBottomOrientation;", "", "<init>", "(Ljava/lang/String;I)V", "HORIZONTAL", "VERTICAL", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ActionBottomOrientation extends Enum<ActionBottomOrientation> {
        public static final ActionBottomOrientation HORIZONTAL = null;
        public static final ActionBottomOrientation VERTICAL = null;
        public static final /* synthetic */ ActionBottomOrientation[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ActionBottomOrientation> getEntries() {
            return b;
        }

        static {
            ActionBottomOrientation r0 = new ActionBottomOrientation("HORIZONTAL", 0);
            HORIZONTAL = r0;
            ActionBottomOrientation r1 = new ActionBottomOrientation("VERTICAL", 1);
            VERTICAL = r1;
            ActionBottomOrientation[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static ActionBottomOrientation[] values() {
            return (ActionBottomOrientation[]) a.clone();
        }

        public static ActionBottomOrientation valueOf(String r1) {
            return (ActionBottomOrientation) r27.a.a(ActionBottomOrientation.class, r1);
        }

        public ActionBottomOrientation(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public int a;
        public int b;
        public CharSequence c;
        public int d;
        public int e;
        public DialogInterface.OnClickListener f;

        public a() {
        }
    }

    public final UDDialog e() {
        return this.a.build();
    }

    public final UDDialog h() {
        UDDialog r0 = e();
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r0);
    L7:
        return r0;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
        goto L7
    }

    public BearUDDialogBuilder(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        UDDialogBuilder r0 = new UDDialogBuilder(r2);
        this.a = r0;
        r0.autoDismiss(true);
    }

    public final void a(ActionBottomOrientation r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        if (r2 != ActionBottomOrientation.HORIZONTAL) goto L5;
        UDBaseDialogBuilder.ActionBottomOrientation r3 = UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL;
    L6:
        this.a.actionButtonOrientation(r3);
        return;
    L5:
        r3 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
        goto L6
    }

    public final void d(a r5) {
        Intrinsics.checkNotNullParameter(r5, "actionBuilder");
        this.a.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(r5.a).text(r5.b).text(r5.c).textSize(0).textColorRes(r5.d).textColor(0).bgColorRes(0).bgDrawableRes(r5.e).onClickListener(r5.f));
    }

    public final void f(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.a.message(r2);
    }

    public final void g(DialogInterface.OnCancelListener r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.a.onCancelListener(r2);
    }

    public final void i(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.a.title(r2);
    }

    public final void b(int r3, int r4, int r5, DialogInterface.OnClickListener r6) {
        this.a.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(r3).text(r4).textColorRes(r5).onClickListener(r6));
    }

    public final void c(int r3, String r4, int r5, DialogInterface.OnClickListener r6) {
        Intrinsics.checkNotNullParameter(r4, "text");
        this.a.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(r3).text(r4).textColorRes(r5).onClickListener(r6));
    }
}
