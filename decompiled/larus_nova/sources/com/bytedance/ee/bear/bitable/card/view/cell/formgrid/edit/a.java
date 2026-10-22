package com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.larus.nova.R;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f207669a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit.a$a, reason: collision with other inner class name */
    public static final class DialogInterfaceOnClickListenerC2996a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter<Boolean> f207670a;

        public DialogInterfaceOnClickListenerC2996a(ObservableEmitter<Boolean> r100) {
            this.f207670a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f207670a.onNext(Boolean.TRUE);
        }
    }

    public static final class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter<Boolean> f207671a;

        public b(ObservableEmitter<Boolean> r100) {
            this.f207671a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f207671a.onNext(Boolean.FALSE);
        }
    }

    public a(Context r100) {
        this.f207669a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        BearUDDialogBuilder r101 = new BearUDDialogBuilder(this.f207669a);
        r101.i(this.f207669a.getString(R.string.Bitable_Form_Query_SaveData_Title));
        r101.f(this.f207669a.getString(R.string.Bitable_Form_TableQuestion_ReturnWillLoseAllData_Desc));
        r101.a(BearUDDialogBuilder.ActionBottomOrientation.HORIZONTAL);
        r101.b(R.id.ud_dialog_btn_primary, R.string.Bitable_Form_TableQuestion_Return_Button, R.color.function_danger_content_default, new DialogInterfaceOnClickListenerC2996a(r100));
        b r102 = new b(r100);
        r101.f240192a.addActionButton(R.id.ud_dialog_btn_secondary, R.string.Bitable_Common_Cancel_Button, r102);
        r101.f240192a.cancelable(true);
        r101.h();
    }
}
