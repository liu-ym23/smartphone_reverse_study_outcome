package com.bytedance.ee.bear.office.h5jsb.handler.audio;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.jsapi.common.AudioRecordHelper;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import na8.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements gk5.b {
    public final com.bytedance.ee.bear.office.h5jsb.handler.audio.a a;

    public static final class a {
    }

    static {
    }

    public b(com.bytedance.ee.bear.office.h5jsb.handler.audio.a r2) {
        Intrinsics.checkNotNullParameter(r2, "frameRecordedHandler");
        this.a = r2;
    }

    @Override // gk5.b
    public final void b(gk5.a r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        com.bytedance.ee.bear.office.h5jsb.handler.audio.a r0 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "callback");
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r0.a != r4) goto L8;
        r0.a = null;     // Catch: Throwable -> L12
        r0.b("callback unregistered");     // Catch: Throwable -> L12
        boolean r5 = true;
    L9:
        monitor-exit(r0);
        tt5.a.h("AudioFrameRecordedHandler", "callback unregistered, removed=" + r5);
        return;
    L8:
        r5 = false;
        goto L9
    }

    @Override // gk5.c
    public final void a(final FragmentActivity r4, JSONObject r5, p r6) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, WikiFolderPushPlugin.DATA);
        Intrinsics.checkNotNullParameter(r6, "callback");
    L23:
        th = move-exception;
        String r7 = th.getMessage();
        if (r7 != null) goto L27;
        r7 = "invalid preferredDataCallbackInterval";
    L27:
        nk5.b.d(r6, r7);
        return;
    L4:
        if (r5.has("preferredDataCallbackInterval") == true) goto L6;
    L8:
        double r1 = 0.1d;
    L9:
        final AudioRecordHelper.AudioStartRecordRequest r0 = new AudioRecordHelper.AudioStartRecordRequest(Double.valueOf(r1));     // Catch: Throwable -> L23
        com.bytedance.ee.bear.office.h5jsb.handler.audio.a r8 = this.a;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r6, "callback");
        monitor-enter(r8);
        r8.a = r6;     // Catch: Throwable -> L20
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r8);
        r8.b.set(false);
        tt5.a.h("AudioFrameRecordedHandler", "callback registered");
        r6.onSuccess(new JSONObject());
        AudioRecordHelper.a.e();
        AudioRecordHelper.c(r4, new AudioStartRecordHandler$handle$1(this, r0, r4));     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        tt5.a.e("AudioStartRecordHandler", "checkAudioPermission failed", th, false);
        AudioRecordHelper r9 = AudioRecordHelper.a;
        r9.d();
        this.a.a(AudioRecordHelper.b(r9, AudioRecordHelper.AudioRecordState.FAILED, null, AudioRecordHelper.AudioErrorType.NO_PERMISSION, 2));
        return;
    L20:
        th = move-exception;
        throw th;
    L6:
        if (r5.isNull("preferredDataCallbackInterval") == true) goto L8;
        r1 = JSONObjectProtectorUtils.getDouble(r5, "preferredDataCallbackInterval");     // Catch: Throwable -> L23
        goto L9
    }
}
