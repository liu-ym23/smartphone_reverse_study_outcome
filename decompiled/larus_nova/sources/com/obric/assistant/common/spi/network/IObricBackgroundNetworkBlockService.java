package com.obric.assistant.common.spi.network;

import hm9.h;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0003H&J\u000f\u0010\t\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/obric/assistant/common/spi/network/IObricBackgroundNetworkBlockService;", "", "shouldBlockNonDoraUserForObric", "", "()Ljava/lang/Boolean;", "triggerBackgroundNetworkRestrictIfNeeded", "", "initNetworkRestrict", "getAssistantState", "isMainProcessBackground", "registerMainProcessBackgroundListener", "listener", "Lcom/obric/assistant/common/spi/network/MainProcessBackgroundListener;", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricBackgroundNetworkBlockService {
    Boolean a();

    void b(h r100);

    void c();

    boolean d();

    Boolean e();

    void f();
}
