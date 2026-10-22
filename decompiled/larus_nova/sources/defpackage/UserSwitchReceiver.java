package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.obric.sva.sdk.utils.KtUtils;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class UserSwitchReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SwitchReceiver f1229b = null;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"LUserSwitchReceiver$SwitchReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SwitchReceiver extends BroadcastReceiver {
        public SwitchReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "intent");
            String r102 = r101.getAction();
            if (r102 != null) goto L5;
            return;
        L5:
            int r103 = KtUtils.myUserId();
            if (Intrinsics.areEqual(r102, "android.intent.action.USER_FOREGROUND") == false) goto L9;
            LogUtils.d("UserSwitchReceiver", "UserSwitch userID [" + r103 + "] to FOREGROUND", new Object[0]);
            return;
        L9:
            if (Intrinsics.areEqual(r102, "android.intent.action.USER_BACKGROUND") == false) goto L13;
            LogUtils.d("UserSwitchReceiver", "UserSwitch userID [" + r103 + "] to BACKGROUND", new Object[0]);
            return;
        }
    }

    static {
        f1229b = new SwitchReceiver();
    }
}
