package com.bytedance.ee.bear.document.offline.sync.sync;

import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public class SyncStatusModel implements Serializable {
    public static final int SYNC_STATUS_FAIL = 1;
    public static final int SYNC_STATUS_LOADING = 3;
    public static final int SYNC_STATUS_SUCCESS = 0;
    public static final int SYNC_STATUS_WAITING = 2;
    public int code;
    public String objToken;
    public int status;
    public String wikiToken;

    public SyncStatusModel() {
    }
}
