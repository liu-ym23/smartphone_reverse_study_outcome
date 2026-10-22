package s1b;

import android.content.DialogInterface;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$ConfirmDialogAction;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$ConfirmDialogCloseReason;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$ConfirmDialogShowOptions;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Ipc$ConfirmDialogClosedDetails;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Ipc$EventType;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f540199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IWidget$Internal$ConfirmDialogShowOptions f540200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IChameleonHandlerContext f540201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ IWidget$Internal$ConfirmDialogAction f540202d;

    public b(a r100, IWidget$Internal$ConfirmDialogShowOptions r101, IChameleonHandlerContext r102, IWidget$Internal$ConfirmDialogAction r103) {
        this.f540199a = r100;
        this.f540200b = r101;
        this.f540201c = r102;
        this.f540202d = r103;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f540199a.f540188a.remove(this.f540200b.getId());
        IChameleonHandlerContext r102 = this.f540201c;
        String r103 = IWidget$Ipc$EventType.CONFIRM_DIALOG_CLOSED.getValue();
        String r104 = this.f540200b.getId();
        String r105 = this.f540202d.getKey();
        r102.sendEvent(r103, new IWidget$Ipc$ConfirmDialogClosedDetails(r104, IWidget$Internal$ConfirmDialogCloseReason.Action, r105));
    }
}
