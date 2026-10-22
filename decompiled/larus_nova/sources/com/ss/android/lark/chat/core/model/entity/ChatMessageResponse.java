package com.ss.android.lark.chat.core.model.entity;

import android.util.Pair;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public class ChatMessageResponse implements Serializable {
    public Chat chat;
    public long clientDataCost;
    public final List<Integer> invisiblePositions;
    public List<Pair<Integer, Integer>> mFoldIntervals;
    public final List<MessageInfo> messageInfoList;
    public Map<String, Boolean> messagesSyncPipeFinished;
    public List<Integer> missingPositions;
    public List<Long> netCosts;
    public long sdkCost;
    public int showExpiredPeriod;

    public ChatMessageResponse() {
        List r100 = Collections.EMPTY_LIST;
        this(r100, r100);
    }

    public ChatMessageResponse(List<MessageInfo> r100, List<Integer> r101) {
        this.sdkCost = 0;
        this.clientDataCost = 0;
        this.showExpiredPeriod = 0;
        this.missingPositions = new ArrayList();
        this.messagesSyncPipeFinished = new HashMap();
        this.mFoldIntervals = new LinkedList();
        this.messageInfoList = r100;
        this.invisiblePositions = r101;
    }
}
