package com.ss.android.lark.lynxkit.host;

import androidx.fragment.app.DialogFragment;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0014\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/lynxkit/host/ILarkLynxDialogHolder;", "Lcom/ss/android/lark/lynxkit/host/ILarkLynxHostHolder;", "getDialog", "Landroidx/fragment/app/DialogFragment;", "isLoad", "", "show", "tag", "", "dismiss", "", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILarkLynxDialogHolder extends ILarkLynxHostHolder {
    void dismiss();

    DialogFragment getDialog(boolean r100);

    boolean show(String r100);
}
