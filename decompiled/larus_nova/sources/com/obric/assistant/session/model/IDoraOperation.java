package com.obric.assistant.session.model;

import com.obric.assistant.session.endpoint.DoraSessionEndpoint;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/session/model/IDoraOperation;", "", "isDoraProxyWakeup", "", "isAutoMicDoraWakeup", "isDoraPressing", "getVuiId", "", "()Ljava/lang/Integer;", "setAutoMicDoraWakeup", "", "enable", "action", "Lcom/obric/assistant/session/singleton/DoraWakeupDetector$DoraActionListener;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDoraOperation {
    DoraSessionEndpoint action();

    boolean b();

    boolean c();

    void e();

    Integer g();
}
