package com.obric.assistant.session.model;

import android.os.Bundle;
import com.obric.assistant.session.endpoint.u0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\ba\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eJ\u001e\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J:\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH&J8\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00032\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u000eH&J\b\u0010\u0015\u001a\u00020\u0003H&J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u000eH&J\b\u0010\u001a\u001a\u00020\u0018H&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H&J\b\u0010\u001d\u001a\u00020\u000eH&¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/session/model/IAssistActivateOperation;", "", "prepareActivation", "", "args", "Landroid/os/Bundle;", "backtrackDurationMs", "", "showListeningUI", "extra", "isAudioWeakUp", "tryInterruptConversation", "onHapticAndSoundFeedback", "Lkotlin/Function0;", "", "activate", "activation", "Lcom/obric/assistant/session/model/Activation;", "handleIntercomConditionFail", "onTouchSpeakStop", "onTouchSpeakFailed", "checkIntercomConditionPass", "updateIntercomConditionStatus", "status", "", "handleConditionUnPass", "getIntercomConditionStatus", "isShowOnLauncherOrKeyguard", "isShowOnLauncher", "resetOnLauncherOrKeyguard", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAssistActivateOperation {

    public static final class a {
        public static /* synthetic */ boolean a(IAssistActivateOperation r100, bga.a r101, Bundle r102, u0 r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r102 = null;
        L6:
            if ((r104 & 4) == 0) goto L8;
            boolean r105 = true;
        L10:
            if ((r104 & 8) == 0) goto L13;
            r103 = null;
        L13:
            return r100.g(r101, r102, r105, r103);
        L8:
            r105 = false;
            goto L10
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean b(IAssistActivateOperation r100, Bundle r101, boolean r102, Function0 r103, int r104) {
            if ((r104 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r104 & 4) == 0) goto L9;
            r102 = false;
        L9:
            if ((r104 & 8) == 0) goto L12;
            r103 = null;
        L12:
            return r100.c(r101, false, r102, r103);
        }
    }

    void a();

    void b(int r100);

    boolean c(Bundle r100, boolean r101, boolean r102, Function0<Unit> r103);

    boolean e(Bundle r100, long r101);

    boolean g(bga.a r100, Bundle r101, boolean r102, Function0<Unit> r103);

    void i();

    boolean j();

    boolean k();

    boolean l();

    int m();

    boolean o();

    void q();
}
