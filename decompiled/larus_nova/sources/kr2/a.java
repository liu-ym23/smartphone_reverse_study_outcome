package kr2;

import com.bytedance.android.livesdk.revenue.log.e;
import com.bytedance.android.livesdk.revenue.log.f;
import com.bytedance.android.livesdk.revenue.log.g;
import com.bytedance.android.livesdk.revenue.log.h;
import com.bytedance.android.livesdk.revenue.log.i;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public interface a extends dy0.a {
    JSONObject Ga(DataCenter r100);

    g K7();

    b Lb();

    f Q8();

    String T1();

    void Xj(String r100, Map r101, List r102);

    void appendCastSDKLogCommonParams(Map<String, String> r100);

    h be();

    i ud();

    e v();
}
