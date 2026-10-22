package com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.larus.nova.R;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f207672a;

    public static final class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter<Boolean> f207673a;

        public a(ObservableEmitter<Boolean> r100) {
            this.f207673a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f207673a.onNext(Boolean.TRUE);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit.b$b, reason: collision with other inner class name */
    public static final class DialogInterfaceOnClickListenerC2997b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter<Boolean> f207674a;

        public DialogInterfaceOnClickListenerC2997b(ObservableEmitter<Boolean> r100) {
            this.f207674a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f207674a.onNext(Boolean.FALSE);
        }
    }

    public b(Context r100) {
        this.f207672a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        BearUDDialogBuilder r101 = new BearUDDialogBuilder(this.f207672a);
        r101.i(this.f207672a.getString(R.string.Bitable_Form_TableQuestion_DeletedDataCannotBeUndone_Desc));
        r101.a(BearUDDialogBuilder.ActionBottomOrientation.HORIZONTAL);
        r101.b(R.id.ud_dialog_btn_primary, R.string.Bitable_Form_TableQuestion_DeleteTable_Option, R.color.function_danger_content_default, new a(r100));
        DialogInterfaceOnClickListenerC2997b r102 = new DialogInterfaceOnClickListenerC2997b(r100);
        r101.f240192a.addActionButton(R.id.ud_dialog_btn_secondary, R.string.Bitable_Common_Cancel_Button, r102);
        r101.f240192a.cancelable(true);
        r101.h();
    }
}
