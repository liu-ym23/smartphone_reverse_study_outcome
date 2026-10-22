package s1b;

import android.content.DialogInterface;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$ConfirmDialogCloseReason;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$ConfirmDialogShowOptions;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Ipc$ConfirmDialogClosedDetails;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Ipc$EventType;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f540203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IWidget$Internal$ConfirmDialogShowOptions f540204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IChameleonHandlerContext f540205c;

    public c(a r100, IWidget$Internal$ConfirmDialogShowOptions r101, IChameleonHandlerContext r102) {
        this.f540203a = r100;
        this.f540204b = r101;
        this.f540205c = r102;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        this.f540203a.f540188a.remove(this.f540204b.getId());
        this.f540205c.sendEvent(IWidget$Ipc$EventType.CONFIRM_DIALOG_CLOSED.getValue(), new IWidget$Ipc$ConfirmDialogClosedDetails(this.f540204b.getId(), IWidget$Internal$ConfirmDialogCloseReason.Cancel, ""));
    }
}
