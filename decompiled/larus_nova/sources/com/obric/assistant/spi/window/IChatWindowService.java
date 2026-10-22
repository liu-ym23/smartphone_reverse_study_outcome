package com.obric.assistant.spi.window;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u0012\u001a\u00020\u0007H&¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/spi/window/IChatWindowService;", "", "isWindowContext", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "stashWindow", "", "popWindow", "isChatWindowShowing", "isChatWindowStashed", "isWindowHelperActivity", "activity", "Landroid/app/Activity;", PushClientConstants.TAG_CLASS_NAME, "", "getChatFragment", "Landroidx/fragment/app/Fragment;", "registerWindowMaterials", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IChatWindowService {
    Fragment a(Activity r100);

    void b();

    boolean c(Activity r100);

    boolean d(Context r100);

    boolean e();
}
