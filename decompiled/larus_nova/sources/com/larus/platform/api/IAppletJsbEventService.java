package com.larus.platform.api;

import com.google.gson.JsonObject;
import com.obric.sva.sdk.sami.SamiBreathSidAuthEngine;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
public interface IAppletJsbEventService {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/platform/api/IAppletJsbEventService$TriggeredEvent;", "", "scene", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "MESSAGE_INTERRUPT", "ENTER_AWENME_VIDEO", "LEAVE_AWENME_VIDEO", "TTS_START", "TTS_END", "AUTH_RESULT", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TriggeredEvent extends Enum<TriggeredEvent> {
        public static final TriggeredEvent AUTH_RESULT = null;
        public static final TriggeredEvent ENTER_AWENME_VIDEO = null;
        public static final TriggeredEvent LEAVE_AWENME_VIDEO = null;
        public static final TriggeredEvent MESSAGE_INTERRUPT = null;
        public static final TriggeredEvent TTS_END = null;
        public static final TriggeredEvent TTS_START = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TriggeredEvent[] f364777a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f364778b = null;
        private final String scene;

        public static EnumEntries<TriggeredEvent> getEntries() {
            return f364778b;
        }

        static {
            TriggeredEvent r100 = new TriggeredEvent("MESSAGE_INTERRUPT", 0, "message_interrupt");
            MESSAGE_INTERRUPT = r100;
            TriggeredEvent r101 = new TriggeredEvent("ENTER_AWENME_VIDEO", 1, "enter_aweme_video");
            ENTER_AWENME_VIDEO = r101;
            TriggeredEvent r102 = new TriggeredEvent("LEAVE_AWENME_VIDEO", 2, "leave_aweme_video");
            LEAVE_AWENME_VIDEO = r102;
            TriggeredEvent r103 = new TriggeredEvent("TTS_START", 3, "tts_start");
            TTS_START = r103;
            TriggeredEvent r104 = new TriggeredEvent("TTS_END", 4, "tts_end");
            TTS_END = r104;
            TriggeredEvent r105 = new TriggeredEvent("AUTH_RESULT", 5, SamiBreathSidAuthEngine.KEY_AUTH_RESULT);
            AUTH_RESULT = r105;
            TriggeredEvent[] r110 = {r100, r101, r102, r103, r104, r105};
            f364777a = r110;
            f364778b = EnumEntriesKt.enumEntries(r110);
        }

        public static TriggeredEvent[] values() {
            return (TriggeredEvent[]) f364777a.clone();
        }

        public final String getScene() {
            return this.scene;
        }

        public static TriggeredEvent valueOf(String r100) {
            return (TriggeredEvent) r27.a.a(TriggeredEvent.class, r100);
        }

        public TriggeredEvent(String r100, int r101, String r102) {
            super(r100, r101);
            this.scene = r102;
        }
    }

    void a(TriggeredEvent r100, JsonObject r101);
}
