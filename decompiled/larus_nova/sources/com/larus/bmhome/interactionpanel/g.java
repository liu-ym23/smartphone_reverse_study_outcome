package com.larus.bmhome.interactionpanel;

import com.larus.im.bean.message.Message;
import com.larus.im.internal.protocol.bean.GeneralInteractionAskNotifyDownlinkBody;
import java.util.List;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes4.dex */
public interface g {
    StateFlowImpl a();

    void b(o r100, String r101, InteractionPanelSubmitResult r102);

    void c(String r100, List<Message> r101, String r102);

    void d(o r100, String r101, String r102);

    void e(o r100, String r101);

    void f(String r100, String r101);

    boolean g(o r100, String r101);

    i1<v> h(n r100);

    void i(String r100, String r101, List<Message> r102, String r103);

    void j(String r100, List r101);

    void k(String r100, String r101, List<Message> r102, String r103, w r104);

    void l(GeneralInteractionAskNotifyDownlinkBody r100);

    void m(String r100, String r101, List<o> r102, String r103);
}
