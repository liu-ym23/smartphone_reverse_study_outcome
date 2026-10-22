package com.larus.home.api.privacy;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.DialogFragment;
import com.larus.common_ui.dialog.p0;
import com.larus.common_ui.dialog.u;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0012\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000bH&¨\u0006\r"}, d2 = {"Lcom/larus/home/api/privacy/ICustomPrivacyService;", "", "getCustomPrivacyDialog", "Landroidx/fragment/app/DialogFragment;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "agree", "Lcom/larus/common_ui/dialog/ConfirmClickListener;", "disagree", "Lcom/larus/common_ui/dialog/CancelClickListener;", "getCustomPrivacyActivityClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICustomPrivacyService {
    Class<? extends Activity> b();

    DialogFragment d(Context r100, p0 r101, u r102);
}
