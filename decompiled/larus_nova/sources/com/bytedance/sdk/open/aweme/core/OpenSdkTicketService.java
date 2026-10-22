package com.bytedance.sdk.open.aweme.core;

import android.content.Context;
import android.util.Pair;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public interface OpenSdkTicketService extends IOpenService {
    void enableDefaultTicketGuard();

    String getClientTicket(String r100);

    List<Pair<String, String>> getHeaderForCTK(String r100, String r101);

    OpenResult<List<Pair<String, String>>> getHeaderForCTKWithRefresh(String r100, String r101);

    void initTicketGuard(Context r100);

    void removeClientTicket(String r100);
}
