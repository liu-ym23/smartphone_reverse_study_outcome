package com.huawei.hms.adapter.sysobs;

import android.content.Intent;

/* JADX INFO: loaded from: classes23.dex */
public interface SystemObserver {
    boolean onNoticeResult(int r100);

    boolean onSolutionResult(Intent r100, String r101);

    boolean onUpdateResult(int r100);
}
