package xm7;

import com.bytedance.ug.sdk.luckyhost.api.api.countTimer.LuckyCounterPendantHideFrom;
import com.bytedance.ug.sdk.luckyhost.api.api.countTimer.LuckyCounterTaskSourceType;
import com.bytedance.ug.sdk.luckyhost.api.api.countTimer.LuckyCounterTaskStatus;
import com.bytedance.ug.sdk.luckyhost.api.api.countTimer.LuckyCounterTimerStatus;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface b {
    void a(String r100, ym7.n r101);

    void c(float r100);

    void d();

    void e(LuckyCounterTimerStatus r100);

    void f(String r100, ym7.n r101, LuckyCounterPendantHideFrom r102);

    void g(LuckyCounterTaskStatus r100);

    void h(k r100, LuckyCounterTaskSourceType r101, JSONObject r102, ym7.i r103, ym7.a r104);
}
