package com.bytedance.ee.lark.infra.foundation.utils;

import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.service.OPMonitor;

/* JADX INFO: loaded from: classes19.dex */
public interface IMonitorCreator {
    <T extends OPMonitor> T createOPMonitor(String r100, OPMonitorCode r101);
}
