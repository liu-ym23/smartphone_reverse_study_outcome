package com.bytedance.ttnet.cronet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes22.dex */
public class CronetDropReasonAccess extends Observable {
    public static final String DROP_REASON_LIST = "drop_reason_list";
    public static final String USER_BLOCKED_STATE = "user_blocked_state";
    private static volatile CronetDropReasonAccess sInstance;
    private CopyOnWriteArrayList<Integer> mDropReasonList;
    private volatile boolean mUserBlockedState;

    public static CronetDropReasonAccess inst() {
        if (sInstance != null) goto L15;
        monitor-enter(CronetDropReasonAccess.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new CronetDropReasonAccess();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CronetDropReasonAccess.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public CronetDropReasonAccess() {
        this.mDropReasonList = new CopyOnWriteArrayList();
    }

    public List<Integer> dropReasonList() {
        return this.mDropReasonList;
    }

    public boolean userBlockedState() {
        return this.mUserBlockedState;
    }

    private void notifyDropReasonChangedObservers(Map<String, Object> r100) {
        setChanged();
        notifyObservers(r100);
    }

    public void onDropReasonChanged(boolean r100, List<Integer> r101) {
        this.mUserBlockedState = r100;
        this.mDropReasonList.clear();
        this.mDropReasonList.addAll(r101);
        HashMap r102 = new HashMap();
        r102.put(USER_BLOCKED_STATE, Boolean.valueOf(this.mUserBlockedState));
        r102.put(DROP_REASON_LIST, this.mDropReasonList);
        notifyDropReasonChangedObservers(r102);
    }
}
