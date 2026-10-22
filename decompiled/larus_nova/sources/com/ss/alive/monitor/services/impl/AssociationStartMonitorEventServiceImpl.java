package com.ss.alive.monitor.services.impl;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.process.cross.CrossProcessHelper;
import com.bytedance.common.process.cross.IMethodObserver;
import com.bytedance.common.push.BaseJson;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.push.utils.f;
import com.ss.android.message.util.ToolUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import sqa.a;

/* JADX INFO: loaded from: classes5.dex */
public class AssociationStartMonitorEventServiceImpl extends BaseJson implements a, IMethodObserver {
    private final String ALOG_TAG;
    private final String ASSOCIATION_START_METHOD_NAME;
    private final String TAG;
    private boolean mEnableReport;
    private boolean mIsActive;
    private ProcessEnum mProcessEnum;

    @Override // com.bytedance.common.process.cross.IMethodObserver
    public String getMethodName() {
        return "onAssociationStartEvent";
    }

    @Override // sqa.a
    public void onUserActive() {
        this.mIsActive = true;
    }

    public AssociationStartMonitorEventServiceImpl(Context r100) {
        this.TAG = "AssociationStartMonitor";
        this.ALOG_TAG = "ALOG_ASSOCIATION_START_MONITOR";
        this.ASSOCIATION_START_METHOD_NAME = "onAssociationStartEvent";
        this.mEnableReport = false;
        ProcessEnum r101 = ToolUtils.getCurProcess(r100);
        this.mProcessEnum = r101;
        if (r101 != ProcessEnum.MAIN) goto L6;
        CrossProcessHelper.getInstance().registerMethodObserver(this);
        this.mIsActive = ToolUtils.isActiveUser(r100);
        return;
    }

    @Override // sqa.a
    public void enableReport(boolean r100) {
        this.mEnableReport = r100;
    }

    @Override // sqa.a
    public void onAssociationStartEvent(pqa.a r100) {
        monitorEvent("association_start_event", r100.b(), null, null);
    }

    @Override // com.bytedance.common.process.cross.IMethodObserver
    public String onMethodCall(ProcessEnum r100, List r101) {
    L21:
        th = move-exception;
        f.e("AssociationStartMonitor", "onMethodCall error : origin processName is " + r100);
        th.printStackTrace();
    L23:
        return null;
    L4:
        if (this.mProcessEnum != ProcessEnum.MAIN) goto L23;
        if (r101.size() != 4) goto L23;
        f.e("AssociationStartMonitor", "recv  rom the chain-start record of " + r100);     // Catch: Throwable -> L21
        String r102 = (String) ListProtector.get(r101, 1);     // Catch: Throwable -> L21
        String r103 = (String) ListProtector.get(r101, 2);     // Catch: Throwable -> L21
        String r104 = (String) ListProtector.get(r101, 3);     // Catch: Throwable -> L21
        String r105 = (String) ListProtector.get(r101, 0);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r102) == false) goto L10;
        JSONObject r106 = null;
    L12:
        if (TextUtils.isEmpty(r103) == false) goto L14;
        JSONObject r107 = null;
    L16:
        if (TextUtils.isEmpty(r104) == false) goto L18;
        JSONObject r108 = null;
    L19:
        monitorEventInternal(r105, r106, r107, r108);     // Catch: Throwable -> L21
        goto L23
    L18:
        r108 = new JSONObject(r104);     // Catch: Throwable -> L21
        goto L19
    L14:
        r107 = new JSONObject(r103);     // Catch: Throwable -> L21
        goto L16
    L10:
        r106 = new JSONObject(r102);     // Catch: Throwable -> L21
        goto L12
    }

    private void monitorEventInternal(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        if (this.mProcessEnum == ProcessEnum.MAIN) goto L5;
        return;
    L5:
        if (r101 != null) goto L7;
        r101 = new JSONObject();
    L7:
        add(r101, "sdk_version", "1.0");
        if (this.mIsActive == false) goto L10;
        long r104 = 1;
    L11:
        add(r101, "is_active", r104);
        f.b("AssociationStartMonitor", "[monitorEventInternal] serviceName is " + r100);
        PushServiceManager.get().getPushExternalService().monitorEvent(r100, r101, r102, r103);
        return;
    L10:
        r104 = 0;
        goto L11
    }

    public void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        if (this.mEnableReport == true) goto L5;
        return;
    L5:
        ProcessEnum r104 = this.mProcessEnum;
        ProcessEnum r105 = ProcessEnum.MAIN;
        if (r104 != r105) goto L8;
        monitorEventInternal(r100, r101, r102, r103);
        return;
    L8:
        ArrayList r106 = new ArrayList();
        r106.add(r100);
        String r107 = "";
        if (r101 != null) goto L11;
        String r108 = "";
    L12:
        r106.add(r108);
        if (r102 != null) goto L15;
        String r109 = "";
    L16:
        r106.add(r109);
        if (r103 == null) goto L20;
        r107 = r103.toString();
    L20:
        r106.add(r107);
        CrossProcessHelper.getInstance().callMethod(r105, "onAssociationStartEvent", r106, true);
        return;
    L15:
        r109 = r102.toString();
        goto L16
    L11:
        r108 = r101.toString();
        goto L12
    }

    @Override // sqa.a
    public void onHookResult(String r100, boolean r101, String r102, long r103) {
        JSONObject r104 = new JSONObject();
        add(r104, "hook_name", r100);
        add(r104, "result", r101);
        add(r104, "msg", r102);
        add(r104, "process", this.mProcessEnum.processSuffix);
        add(r104, Constants.Keys.KEY_CLIENT_TIME, ToolUtils.currentTimeMillis());
        JSONObject r105 = new JSONObject();
        add(r105, "duration", r103);
        monitorEvent("push_hook_result", r104, r105, null);
    }
}
