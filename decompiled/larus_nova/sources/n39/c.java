package n39;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes27.dex */
public interface c extends com.larus.office.base.service.a<c> {

    public static final class a {
        public static /* synthetic */ void a(c r100, String r101, boolean r102, boolean r103, int r104) {
            if ((r104 & 4) == 0) goto L5;
            r103 = false;
        L5:
            r100.setChatInputVisible(r101, r102, r103, false);
        }
    }

    boolean consumeToAiEdit();

    Object getAppIconUrl(Continuation<? super String> r100);

    int getChatInputHeight();

    void getLatestMessageId(Function1<? super String, Unit> r100);

    i1<Boolean> getVoiceInputStatus();

    boolean isChatInputVisible();

    boolean isEnableVoiceInput();

    void notifyInitChatInput(ViewGroup r100, FragmentManager r101);

    void onDocDeleted();

    void onDocNeedUpdate();

    void onDocStateChanged(boolean r100);

    void onLoadFinishEventReported();

    void requestChatInputFocus();

    void selectCurrentSentenceOrParagraph();

    void setChatInputVisibility(boolean r100);

    void setChatInputVisible(String r100, boolean r101, boolean r102, boolean r103);

    void setEnableVoiceInput(boolean r100, String r101);

    void setToAiEdit();
}
