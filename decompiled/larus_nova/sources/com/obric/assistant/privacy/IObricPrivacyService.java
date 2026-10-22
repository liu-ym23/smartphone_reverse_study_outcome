package com.obric.assistant.privacy;

import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/privacy/IObricPrivacyService;", "", "getObricPrivacyIntent", "Landroid/content/Intent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getObricPrivacyDialog", "Landroidx/fragment/app/DialogFragment;", "agree", "Lcom/larus/common_ui/dialog/ConfirmClickListener;", "disagree", "Lcom/larus/common_ui/dialog/CancelClickListener;", "stopAssistantService", "", "notifyPrivacyAgree", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricPrivacyService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f391062a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f391063a = null;

        static {
            f391063a = new a();
        }

        public a() {
        }
    }

    static {
        f391062a = a.f391063a;
    }

    Intent a(Context r100);

    void c();
}
