package sea;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f541630a = null;

    static {
        f541630a = new b();
    }

    public b() {
    }

    public static Bundle a(DMTaskInfo r100) {
        String r101 = null;
        if (r100 == null) goto L7;
        IMMessage r102 = r100.getMessage();
        if (r102 == null) goto L7;
        Message r103 = com.obric.assistant.special_input.util.i.a(r102);
    L8:
        if (r103 == null) goto L10;
        r101 = r103.getMessageId();
    L10:
        if (r103 == null) goto L14;
        boolean r104 = true;
        if (com.obric.assistant.utils.k.c(r103) != true) goto L14;
    L16:
        return c(r101, r104);
    L14:
        r104 = false;
    L7:
        r103 = null;
        goto L8
    }

    public static Bundle b(ObricState r100) {
        Intrinsics.checkNotNullParameter(r100, "obricState");
        String r101 = r100.getSourceMessageId();
        if (r100.getScene() != ObricInteractionScene.COMPLEX_TASK_SCENE) goto L5;
        boolean r102 = true;
    L7:
        return c(r101, r102);
    L5:
        r102 = false;
        goto L7
    }

    public static Bundle d(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        Bundle r101 = r100.getBundleExtra("lockScreenAuthReportParams");
        Context r102 = BadParcelableCrashOptimizer.getContext();
        if (r101 == null) goto L6;
        if (r102 == null) goto L6;
        r101.setClassLoader(r102.getClassLoader());
    L6:
        return r101;
    }

    public static Bundle c(String r100, boolean r101) {
        if (r100 != null) goto L5;
    L12:
        FLogger.f375446a.i("LockScreenAuthReportParams", "build reportParams=null, messageId=" + r100 + ", isOmni=" + r101);
        return null;
    L5:
        if ((!StringsKt.isBlank(r100)) == false) goto L7;
        String r102 = r100;
    L8:
        if (r102 == null) goto L12;
        Bundle r103 = new Bundle();
        r103.putString(MusicAppletPage.KEY_MESSAGE_ID, r102);
        r103.putInt("is_omni", r101 ? 1 : 0);
        FLogger.f375446a.i("LockScreenAuthReportParams", "build reportParams=".concat(com.obric.assistant.common.utils.e.b(r103)));
        return r103;
    L7:
        r102 = null;
        goto L8
    }

    public static void e(Intent r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        if (r101 == null) goto L6;
        r100.putExtra("lockScreenAuthReportParams", r101);
        return;
    }

    public static void f(Intent r100, ObricState r101) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        Intrinsics.checkNotNullParameter(r101, "obricState");
        if (r101.getScene() != ObricInteractionScene.COMPLEX_TASK_SCENE) goto L6;
        e(r100, b(r101));
        return;
    }
}
