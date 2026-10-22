package gtb;

import android.os.Bundle;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public interface a extends IOfficeSDKProtocol {
    void flush();

    void onEventV3(String r100, Bundle r101);

    void onEventV3(String r100, JSONObject r101);

    void onMiscEvent(String r100, JSONObject r101);
}
