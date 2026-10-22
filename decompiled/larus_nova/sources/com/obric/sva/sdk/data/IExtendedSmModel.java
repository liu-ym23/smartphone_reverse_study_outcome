package com.obric.sva.sdk.data;

import android.content.Intent;
import com.obric.sva.framework.wrapper.SoundTriggerWrapper;
import com.obric.sva.sdk.session.SessionType;
import r27.a;

/* JADX INFO: loaded from: classes6.dex */
public interface IExtendedSmModel extends ISmModel {

    public static final enum SessionStatus extends Enum<SessionStatus> {
        private static final /* synthetic */ SessionStatus[] $VALUES = null;
        public static final SessionStatus LOADED = null;
        public static final SessionStatus STARTED = null;
        public static final SessionStatus STOPPED = null;
        public static final SessionStatus UNLOADED = null;

        static {
            SessionStatus r100 = new SessionStatus("UNLOADED", 0);
            UNLOADED = r100;
            SessionStatus r101 = new SessionStatus("LOADED", 1);
            LOADED = r101;
            SessionStatus r102 = new SessionStatus("STARTED", 2);
            STARTED = r102;
            SessionStatus r103 = new SessionStatus("STOPPED", 3);
            STOPPED = r103;
            $VALUES = new SessionStatus[]{r100, r101, r102, r103};
        }

        public static SessionStatus[] values() {
            return (SessionStatus[]) $VALUES.clone();
        }

        public static SessionStatus valueOf(String r100) {
            return (SessionStatus) a.a(SessionStatus.class, r100);
        }

        private SessionStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper[] getKeyphraseRecognitionExtra();

    SoundTriggerWrapper.RecognitionConfigWrapper getRecognitionConfig();

    int getSessionId();

    SessionStatus getSessionStatus();

    SessionType getSessionType();

    Intent getSoundModelActionIntent();

    String getSoundModelActionName();

    int getSoundModelHandle();

    void setKeyphraseRecognitionExtra(SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper[] r100);

    void setRecognitionConfig(SoundTriggerWrapper.RecognitionConfigWrapper r100);

    void setSessionId(int r100);

    void setSessionStatus(SessionStatus r100);

    void setSoundModelActionIntent(Intent r100);

    void setSoundModelActionName(String r100);

    void setSoundModelHandle(int r100);
}
