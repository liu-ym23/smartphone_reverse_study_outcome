package com.bytedance.news.common.settings.bytesync;

import android.text.TextUtils;
import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.news.common.settings.api.model.SettingsByteSyncModel;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public class SettingsByteSyncManager {
    private static final String TAG = "SettingsByteSyncManager";
    private static String callerName;
    private static volatile int receiveCount;
    private static List<SettingsByteSyncListener> syncListeners;
    private static String taskData;
    private static String taskDataTmp;
    private static int taskId;
    private static String taskIdTmp;
    private static int taskType;
    private static long timeStamp;

    public interface SettingsByteSyncListener {
        void onSettingsSyncRequest(SettingsByteSyncModel r100);

        void onUpdateSettingKey(SettingsByteSyncModel r100);
    }

    public static class a implements Runnable {
        public a() {
        }

        public static void a() {
            SettingsByteSyncModel r100 = new SettingsByteSyncModel();
            r100.callerName = SettingsByteSyncManager.access$000();
            r100.taskData = SettingsByteSyncManager.access$100();
            r100.taskId = SettingsByteSyncManager.access$200();
            r100.taskType = SettingsByteSyncManager.access$300();
            r100.timeStamp = SettingsByteSyncManager.access$400() * 1000;
            SettingsByteSyncManager.access$102(SettingsByteSyncManager.access$202(""));
            if (TextUtils.isEmpty(SettingsByteSyncManager.access$000()) == false) goto L8;
            if (SettingsManager.isMatchTimeToByteSync(r100) == false) goto L15;
            SettingsManager.setSettingsByteSyncModel(r100);
            SettingsManager.updateSettings(true);
        L15:
            SettingsByteSyncManager.access$602(0);
            return;
        L8:
            if (SettingsByteSyncManager.access$500() == null) goto L15;
            Iterator r101 = SettingsByteSyncManager.access$500().iterator();
        L11:
            if (r101.hasNext() == false) goto L15;
            SettingsByteSyncListener r102 = (SettingsByteSyncListener) r101.next();
            if (r102 == null) goto L11;
            r102.onSettingsSyncRequest(r100);
            goto L11
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public SettingsByteSyncManager() {
    }

    static {
        syncListeners = new ArrayList();
    }

    public static /* synthetic */ String access$000() {
        return callerName;
    }

    public static /* synthetic */ String access$100() {
        return taskDataTmp;
    }

    public static /* synthetic */ String access$200() {
        return taskIdTmp;
    }

    public static /* synthetic */ int access$300() {
        return taskType;
    }

    public static /* synthetic */ long access$400() {
        return timeStamp;
    }

    public static /* synthetic */ List access$500() {
        return syncListeners;
    }

    public static /* synthetic */ String access$102(String r100) {
        taskDataTmp = r100;
        return r100;
    }

    public static /* synthetic */ String access$202(String r100) {
        taskIdTmp = r100;
        return r100;
    }

    public static /* synthetic */ int access$602(int r100) {
        receiveCount = r100;
        return r100;
    }

    public static void onReceiveConnectEvent(String r100) {
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L43
        taskType = r101.optInt(AiProactiveTaskViewModel.PARAM_TASK_TYPE);     // Catch: JSONException -> L43
        taskId = r101.optInt("task_id");     // Catch: JSONException -> L43
        callerName = r101.optString(Constant.KEY_CALL_NAME);     // Catch: JSONException -> L43
        taskData = r101.optString("task_data");     // Catch: JSONException -> L43
        timeStamp = r101.optLong("time_stamp");     // Catch: JSONException -> L43
        int r102 = taskType;     // Catch: JSONException -> L43
        if (r102 != 2) goto L25;
        if (TextUtils.isEmpty(r101.optString("task_data")) == false) goto L46;
        return;
    L46:
        JSONObject r103 = new JSONObject(taskData);     // Catch: JSONException -> L22
        SettingsByteSyncModel r104 = new SettingsByteSyncModel();     // Catch: JSONException -> L22
        r104.callerName = callerName;     // Catch: JSONException -> L22
        r104.taskData = taskData;     // Catch: JSONException -> L22
        r104.taskId = String.valueOf(taskId);     // Catch: JSONException -> L22
        r104.taskType = taskType;     // Catch: JSONException -> L22
        r104.timeStamp = timeStamp * 1000;     // Catch: JSONException -> L22
        if (TextUtils.isEmpty(callerName) == true) goto L11;
        List<SettingsByteSyncListener> r105 = syncListeners;     // Catch: JSONException -> L22
        if (r105 == null) goto L55;
        Iterator<SettingsByteSyncListener> r106 = r105.iterator();     // Catch: JSONException -> L22
    L17:
        if (r106.hasNext() == false) goto L61;
        SettingsByteSyncListener r107 = r106.next();     // Catch: JSONException -> L22
        if (r107 == null) goto L17;
        r107.onUpdateSettingKey(r104);     // Catch: JSONException -> L22
        goto L17
    L61:
        return;
    L55:
        return;
    L11:
        if (SettingsManager.isMatchTimeToByteSync(r104) == false) goto L53;
        SettingsManager.updateSettingKey(r103);     // Catch: JSONException -> L22
        return;
    L53:
        return;
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L43
        return;
    L25:
        if (r102 == 1) goto L27;
        return;
    L27:
        if (receiveCount != 0) goto L37;
        receiveCount = 1;     // Catch: JSONException -> L43
        if (TextUtils.isEmpty(taskData) == true) goto L31;
        taskDataTmp = taskData;     // Catch: JSONException -> L43
    L31:
        int r108 = taskId;     // Catch: JSONException -> L43
        if (r108 == 0) goto L34;
        taskIdTmp = String.valueOf(r108);     // Catch: JSONException -> L43
    L34:
        SettingsManager.MAIN_HANDLER.postDelayed(new a(), 5000);     // Catch: JSONException -> L43
        return;
    L37:
        if (TextUtils.isEmpty(taskData) == true) goto L40;
        taskDataTmp += "," + taskData;     // Catch: JSONException -> L43
    L40:
        if (taskId == 0) goto L59;
        taskIdTmp += "," + taskId;     // Catch: JSONException -> L43
        return;
    L59:
        return;
    L43:
        e = move-exception;
        e.printStackTrace();
    }

    public static void registerByteSyncListener(SettingsByteSyncListener r100) {
        syncListeners.add(r100);
    }

    public void unregisterByteSyncListener(SettingsByteSyncListener r100) {
        syncListeners.remove(r100);
    }
}
