package com.obric.aivoice.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.obric.aivoice.core.log.AIVoiceLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/aivoice/sdk/AIVoiceCallbackService;", "Landroid/app/Service;", "()V", "binder", "Lcom/obric/aivoice/sdk/AIVoiceCallbackBinder;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", LiveCommonConstants.REASON_ON_DEDTROY, "", "onStartCommand", "", "flags", "startId", "onUnbind", "", "Companion", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AIVoiceCallbackService extends Service {
    public static final Companion Companion = null;
    public static final String TAG = "AIVoiceCallbackService";
    private final AIVoiceCallbackBinder binder;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/aivoice/sdk/AIVoiceCallbackService$Companion;", "", "()V", "TAG", "", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        return 2;
    }

    @Override // android.app.Service
    public void onDestroy() {
        AIVoiceLog.INSTANCE.d(TAG, LiveCommonConstants.REASON_ON_DEDTROY);
        super.onDestroy();
    }

    public AIVoiceCallbackService() {
        this.binder = new AIVoiceCallbackBinder();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        AIVoiceLog.INSTANCE.d(TAG, "onBind");
        return this.binder;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent r100) {
        AIVoiceLog.INSTANCE.d(TAG, "onUnbind");
        return super.onUnbind(r100);
    }
}
