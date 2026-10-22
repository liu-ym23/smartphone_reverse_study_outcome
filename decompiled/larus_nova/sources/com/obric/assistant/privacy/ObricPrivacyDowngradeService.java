package com.obric.assistant.privacy;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.DialogFragment;
import com.larus.common_ui.dialog.p0;
import com.larus.common_ui.dialog.u;
import com.larus.home.api.privacy.ICustomPrivacyService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/privacy/ObricPrivacyDowngradeService;", "Lcom/larus/home/api/privacy/ICustomPrivacyService;", "<init>", "()V", "getCustomPrivacyDialog", "Landroidx/fragment/app/DialogFragment;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "agree", "Lcom/larus/common_ui/dialog/ConfirmClickListener;", "disagree", "Lcom/larus/common_ui/dialog/CancelClickListener;", "getCustomPrivacyActivityClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPrivacyDowngradeService implements ICustomPrivacyService {
    public ObricPrivacyDowngradeService() {
    }

    @Override // com.larus.home.api.privacy.ICustomPrivacyService
    public final Class<? extends Activity> b() {
        return null;
    }

    @Override // com.larus.home.api.privacy.ICustomPrivacyService
    public final DialogFragment d(Context r100, p0 r101, u r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "agree");
        Intrinsics.checkNotNullParameter(r102, "disagree");
        return null;
    }
}
