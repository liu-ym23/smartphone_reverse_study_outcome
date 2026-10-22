package com.bytedance.ee.bear.widgets.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class BearUDDialogBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UDDialogBuilder f240192a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/widgets/dialog/BearUDDialogBuilder$ActionBottomOrientation;", "", "<init>", "(Ljava/lang/String;I)V", "HORIZONTAL", "VERTICAL", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ActionBottomOrientation extends Enum<ActionBottomOrientation> {
        public static final ActionBottomOrientation HORIZONTAL = null;
        public static final ActionBottomOrientation VERTICAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ActionBottomOrientation[] f240193a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f240194b = null;

        public static EnumEntries<ActionBottomOrientation> getEntries() {
            return f240194b;
        }

        static {
            ActionBottomOrientation r100 = new ActionBottomOrientation("HORIZONTAL", 0);
            HORIZONTAL = r100;
            ActionBottomOrientation r101 = new ActionBottomOrientation("VERTICAL", 1);
            VERTICAL = r101;
            ActionBottomOrientation[] r102 = {r100, r101};
            f240193a = r102;
            f240194b = EnumEntriesKt.enumEntries(r102);
        }

        public static ActionBottomOrientation[] values() {
            return (ActionBottomOrientation[]) f240193a.clone();
        }

        public static ActionBottomOrientation valueOf(String r100) {
            return (ActionBottomOrientation) r27.a.a(ActionBottomOrientation.class, r100);
        }

        public ActionBottomOrientation(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f240195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f240196b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f240197c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f240198d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f240199e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public DialogInterface.OnClickListener f240200f;

        public a() {
        }
    }

    public final UDDialog e() {
        return this.f240192a.build();
    }

    public final UDDialog h() {
        UDDialog r100 = e();
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r100);
    L7:
        return r100;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
        goto L7
    }

    public BearUDDialogBuilder(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDDialogBuilder r101 = new UDDialogBuilder(r100);
        this.f240192a = r101;
        r101.autoDismiss(true);
    }

    public final void a(ActionBottomOrientation r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (r100 != ActionBottomOrientation.HORIZONTAL) goto L5;
        UDBaseDialogBuilder.ActionBottomOrientation r101 = UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL;
    L6:
        this.f240192a.actionButtonOrientation(r101);
        return;
    L5:
        r101 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
        goto L6
    }

    public final void d(a r100) {
        Intrinsics.checkNotNullParameter(r100, "actionBuilder");
        this.f240192a.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(r100.f240195a).text(r100.f240196b).text(r100.f240197c).textSize(0).textColorRes(r100.f240198d).textColor(0).bgColorRes(0).bgDrawableRes(r100.f240199e).onClickListener(r100.f240200f));
    }

    public final void f(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f240192a.message(r100);
    }

    public final void g(DialogInterface.OnCancelListener r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f240192a.onCancelListener(r100);
    }

    public final void i(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f240192a.title(r100);
    }

    public final void b(int r100, int r101, int r102, DialogInterface.OnClickListener r103) {
        this.f240192a.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(r100).text(r101).textColorRes(r102).onClickListener(r103));
    }

    public final void c(int r100, String r101, int r102, DialogInterface.OnClickListener r103) {
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f240192a.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(r100).text(r101).textColorRes(r102).onClickListener(r103));
    }
}
