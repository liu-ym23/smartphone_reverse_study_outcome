package com.bytedance.badger.network;

import java.util.List;
import kotlin.Pair;
import z64.f;

/* JADX INFO: loaded from: classes3.dex */
public interface u {
    boolean checkUnfinishedTasks();

    void handleResponse(String r100, long r101, List<Pair<String, String>> r102, List<Pair<String, String>> r103);

    boolean invalidateRecord();

    void sendFollowUpRequest(f r100, long r101);
}
