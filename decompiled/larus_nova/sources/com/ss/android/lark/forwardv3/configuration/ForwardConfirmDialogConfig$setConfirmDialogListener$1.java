package com.ss.android.lark.forwardv3.configuration;

import com.ss.android.lark.forwardv3.RemoteOnForwardConfirmDialogListener;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/forwardv3/configuration/ForwardConfirmDialogConfig$setConfirmDialogListener$1", "Lcom/ss/android/lark/forwardv3/RemoteOnForwardConfirmDialogListener$Stub;", "onConfirmButtonClick", "", "note", "", "richText", "onCancelButtonClick", "onDismissForward", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForwardConfirmDialogConfig$setConfirmDialogListener$1 extends RemoteOnForwardConfirmDialogListener.Stub {
    final /* synthetic */ oib.c $listener;

    @Override // com.ss.android.lark.forwardv3.RemoteOnForwardConfirmDialogListener
    public void onCancelButtonClick() {
        this.$listener.onCancelButtonClick();
    }

    @Override // com.ss.android.lark.forwardv3.RemoteOnForwardConfirmDialogListener
    public void onDismissForward() {
        this.$listener.onDismissForward();
    }

    public ForwardConfirmDialogConfig$setConfirmDialogListener$1(oib.c r100) {
        this.$listener = r100;
    }

    @Override // com.ss.android.lark.forwardv3.RemoteOnForwardConfirmDialogListener
    public void onConfirmButtonClick(String r100, String r101) {
        this.$listener.onConfirmButtonClick(r100, r101);
    }
}
