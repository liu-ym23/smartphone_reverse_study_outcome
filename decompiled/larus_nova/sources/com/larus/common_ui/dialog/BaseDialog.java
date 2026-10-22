package com.larus.common_ui.dialog;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.DialogFragment;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes27.dex */
@Deprecated(message = "delayed show or dismiss may case crash problem")
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u000b\b'\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u000eJ\b\u0010\u0012\u001a\u00020\u0013H&R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/larus/common_ui/dialog/BaseDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "handler", "Landroid/os/Handler;", "showTime", "", "delayedHide", "Ljava/lang/Runnable;", "delayedShow", "com/larus/common_ui/dialog/BaseDialog$delayedShow$1", "Lcom/larus/common_ui/dialog/BaseDialog$delayedShow$1;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", "hide", "tag", "", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseDialog extends DialogFragment {

    public static final class a {
    }

    static {
    }

    public BaseDialog() {
        new Handler(Looper.getMainLooper());
    }
}
