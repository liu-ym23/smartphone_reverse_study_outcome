package com.bytedance.ee.bear.bitable.fieldedit.view.edit;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class o0<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f211507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f211508b;

    public static final class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter<Boolean> f211509a;

        public a(ObservableEmitter<Boolean> r100) {
            this.f211509a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f211509a.onNext(Boolean.TRUE);
        }
    }

    public static final class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter<Boolean> f211510a;

        public b(ObservableEmitter<Boolean> r100) {
            this.f211510a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f211510a.onNext(Boolean.FALSE);
        }
    }

    public o0(Context r100, String r101) {
        this.f211507a = r100;
        this.f211508b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        Context r101 = this.f211507a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDDialogBuilder r102 = new UDDialogBuilder(r101);
        r102.autoDismiss(true);
        r102.title(R.string.Bitable_Common_Notice_Title);
        String r103 = xo5.a.c(this.f211507a, R.string.Bitable_ModifyField_ModificationsCantUndo_Desc, "field", this.f211508b);
        Intrinsics.checkNotNullParameter(r103, "value");
        r102.message(r103);
        BearUDDialogBuilder.ActionBottomOrientation r104 = BearUDDialogBuilder.ActionBottomOrientation.HORIZONTAL;
        Intrinsics.checkNotNullParameter(r104, "value");
        if (r104 != BearUDDialogBuilder.ActionBottomOrientation.HORIZONTAL) goto L5;
        UDBaseDialogBuilder.ActionBottomOrientation r105 = UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL;
    L6:
        r102.actionButtonOrientation(r105);
        r102.addActionButton(R.id.ud_dialog_btn_primary, R.string.Bitable_Common_Confirm_Button, new a(r100));
        r102.addActionButton(R.id.ud_dialog_btn_secondary, R.string.Bitable_Common_Cancel_Button, new b(r100));
        r102.cancelable(false);
        UDDialog r106 = r102.build();
        if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L13;
        DialogLancet.handleBlockedDialogShow(r106);
        return;
    L13:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        DialogLancet.beforeDialogShow(r106);
        r106.show();
        DialogLancet.afterDialogShow(r106);
        return;
    L5:
        r105 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
        goto L6
    }
}
