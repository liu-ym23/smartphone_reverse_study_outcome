package com.obric.assistant.special_input;

import com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.special_input.util.AssistantInteractionListenerIDLWrapper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J@\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fH&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH&J+\u0010\u0012\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0006H&J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u00172\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH&J(\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!2\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010#H&¨\u0006$"}, d2 = {"Lcom/obric/assistant/special_input/ISpecialInputTask;", "", "init", "", "openAssistantInputPanel", "stateInfo", "Lcom/obric/aiagent/assistant/idl/bean/StateInfo;", "force", "", "isAppInnerCall", "isAutoOpen", "completeCallback", "Lkotlin/Function0;", "closeAssistantInputPanel", "packageName", "", "closeAssistantInputPanelWithTaskQueryMessageId", "taskQueryMessageId", "notifyAssistantState", "enter", "(Ljava/lang/String;Ljava/lang/Boolean;Lcom/obric/aiagent/assistant/idl/bean/StateInfo;)V", "setAssistantInteractionListener", "listener", "Lcom/obric/aiagent/assistant/idl/IAssistantInteractionListenerIDL;", "fetchAndConsumeShortLivedOnceTaskInfo", "setShortLivedOnceTaskInfo", "getWaitingInputTaskInfo", "getAssistantInteractionListener", "requestToShowInputPanelWithMeta", "meta", "Lcom/obric/assistant/special_input/SpecialInputMeta;", "requestToShowComplexTaskPanel", "panelType", "Lcom/obric/assistant/special_input/ObricComplexTaskPanelType;", "ext", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISpecialInputTask {

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(ISpecialInputTask r100, StateInfo r101, boolean r102, boolean r103, boolean r110, Function0 r111, int r112) {
            if ((r112 & 4) == 0) goto L5;
            boolean r104 = false;
        L7:
            if ((r112 & 8) == 0) goto L9;
            boolean r105 = true;
        L11:
            if ((r112 & 16) == 0) goto L13;
            r111 = null;
        L13:
            r100.e(r101, r102, r104, r105, r111);
            return;
        L9:
            r105 = r110;
            goto L11
        L5:
            r104 = r103;
            goto L7
        }
    }

    StateInfo a();

    void b(String r100, Boolean r101, StateInfo r102);

    void c(String r100);

    void closeAssistantInputPanel(String r100);

    void d(ObricComplexTaskPanelType r100, Map<String, String> r101);

    void e(StateInfo r100, boolean r101, boolean r102, boolean r103, Function0<Unit> r104);

    void f(w0 r100);

    StateInfo g();

    AssistantInteractionListenerIDLWrapper h(String r100);

    void init();

    void setAssistantInteractionListener(String r100, IAssistantInteractionListenerIDL r101);
}
