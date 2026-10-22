package xm7;

import com.bytedance.ug.sdk.luckydog.task.newTimer.LuckyNewTimerManager;
import com.bytedance.ug.sdk.luckyhost.api.api.countTimer.LuckyCounterTaskSourceType;
import com.bytedance.ug.sdk.luckyhost.api.api.countTimer.LuckyCounterTaskStatus;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface g {
    void a(String r100);

    void b(String r100, LuckyCounterTaskStatus r101);

    void c(String r100, JSONObject r101, LuckyCounterTaskSourceType r102, LuckyNewTimerManager.a r103);
}
