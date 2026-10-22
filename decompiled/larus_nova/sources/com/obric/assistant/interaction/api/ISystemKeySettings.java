package com.obric.assistant.interaction.api;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/interaction/api/ISystemKeySettings;", "", "getSingleClickAction", "", "getDoubleClickAction", "getPressStartTimeout", "", "isAiKeyEnabledWhenScreenOff", "", "isAiKeyFingerPrintEnrolling", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISystemKeySettings {
    public static final Companion Companion = null;
    public static final int DOUBLE_CLICK_FUNCTION_AUDIO = 0;
    public static final int DOUBLE_CLICK_FUNCTION_DOUBAO_CAMERA = 3;
    public static final int DOUBLE_CLICK_FUNCTION_DO_NOTHING = 4;
    public static final int DOUBLE_CLICK_FUNCTION_SCREEN_SHARE = 2;
    public static final int DOUBLE_CLICK_FUNCTION_VIDEO = 1;
    public static final int SINGLE_CLICK_DO_NOTHING = 2;
    public static final int SINGLE_CLICK_OPEN_CHAT_WINDOW = 0;
    public static final int SINGLE_CLICK_OPEN_FULLSCREEN_ACTIVITY = 1;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/interaction/api/ISystemKeySettings$Companion;", "", "<init>", "()V", "DOUBLE_CLICK_FUNCTION_AUDIO", "", "DOUBLE_CLICK_FUNCTION_VIDEO", "DOUBLE_CLICK_FUNCTION_SCREEN_SHARE", "DOUBLE_CLICK_FUNCTION_DOUBAO_CAMERA", "DOUBLE_CLICK_FUNCTION_DO_NOTHING", "SUPPORTED_DOUBLE_CLICK_FUNCTIONS", "", "getSUPPORTED_DOUBLE_CLICK_FUNCTIONS", "()Ljava/util/Set;", "SINGLE_CLICK_OPEN_CHAT_WINDOW", "SINGLE_CLICK_OPEN_FULLSCREEN_ACTIVITY", "SINGLE_CLICK_DO_NOTHING", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int DOUBLE_CLICK_FUNCTION_AUDIO = 0;
        public static final int DOUBLE_CLICK_FUNCTION_DOUBAO_CAMERA = 3;
        public static final int DOUBLE_CLICK_FUNCTION_DO_NOTHING = 4;
        public static final int DOUBLE_CLICK_FUNCTION_SCREEN_SHARE = 2;
        public static final int DOUBLE_CLICK_FUNCTION_VIDEO = 1;
        public static final int SINGLE_CLICK_DO_NOTHING = 2;
        public static final int SINGLE_CLICK_OPEN_CHAT_WINDOW = 0;
        public static final int SINGLE_CLICK_OPEN_FULLSCREEN_ACTIVITY = 1;
        private static final Set<Integer> SUPPORTED_DOUBLE_CLICK_FUNCTIONS = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            SUPPORTED_DOUBLE_CLICK_FUNCTIONS = SetsKt.setOf(new Integer[]{0, 1, 2, 3, 4});
        }

        public final Set<Integer> getSUPPORTED_DOUBLE_CLICK_FUNCTIONS() {
            return SUPPORTED_DOUBLE_CLICK_FUNCTIONS;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    int getDoubleClickAction();

    long getPressStartTimeout();

    int getSingleClickAction();

    boolean isAiKeyEnabledWhenScreenOff();

    boolean isAiKeyFingerPrintEnrolling();
}
