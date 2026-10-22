package com.obric.aivoice.sdk;

import android.os.Bundle;
import com.obric.aivoice.AIVoiceListener;
import com.obric.aivoice.core.AIVoiceManagerInner;
import com.obric.aivoice.core.data.IdlKeys;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001c\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\r\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/aivoice/sdk/AIVoiceCallbackBinder;", "Lcom/obric/aivoice/AIVoiceListener$Stub;", "()V", "getVersion", "", "onAsrResponse", DBDefinition.TASK_ID, "", "resp", "onResult", "", "response", "Landroid/os/Bundle;", "onTtsResponse", "data", "", "Companion", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AIVoiceCallbackBinder extends AIVoiceListener.Stub {
    public static final Companion Companion = null;
    public static final String TAG = "AIVoiceCallbackBinder";
    private static final int VERSION = 1;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/aivoice/sdk/AIVoiceCallbackBinder$Companion;", "", "()V", "TAG", "", "VERSION", "", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    @Override // com.obric.aivoice.AIVoiceListener
    public int getVersion() {
        return 1;
    }

    public AIVoiceCallbackBinder() {
    }

    @Override // com.obric.aivoice.AIVoiceListener
    public void onResult(Bundle r100) {
        Integer r101 = null;
        if (r100 == null) goto L5;
        Boolean r102 = Boolean.valueOf(r100.getBoolean(IdlKeys.Args_OfflineServerStatus));
    L6:
        if (r100 == null) goto L8;
        r101 = Integer.valueOf(r100.getInt(IdlKeys.Args_OfflineWorkMode));
    L8:
        if (r102 == null) goto L12;
        if (r101 == null) goto L13;
        AIVoiceManagerInner.INSTANCE.onOfflineStatusChanged(r102.booleanValue(), r101.intValue());
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.obric.aivoice.AIVoiceListener
    public int onAsrResponse(String r100, String r101) {
        boolean r102 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L17;
        if (r101 != null) goto L12;
    L15:
        if (r102 == true) goto L17;
        AIVoiceTask.INSTANCE.onAsrResult(r100, r101);
        goto L17
    L12:
        if (r101.length() == 0) goto L15;
        r102 = false;
    L17:
        return 0;
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    @Override // com.obric.aivoice.AIVoiceListener
    public int onTtsResponse(String r100, byte[] r101, String r102) {
        boolean r103 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L24;
        if (r101 == null) goto L24;
        if (r101.length != 0) goto L14;
        boolean r105 = true;
    L16:
        if ((!r105) == false) goto L24;
        if (r102 != null) goto L19;
    L22:
        if (r103 == true) goto L24;
        AIVoiceTask.INSTANCE.onTtsResult(r100, r101, r102);
        goto L24
    L19:
        if (r102.length() == 0) goto L22;
        r103 = false;
        goto L22
    L14:
        r105 = false;
    L24:
        return 0;
    L5:
        if (r100.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}
