package w9;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public interface c extends com.bytedance.android.annie.service.a {
    boolean handleHttpSchema(Context r100, Uri r101, View r102, Map<String, String> r103);

    boolean j0(Context r100, Uri r101, View r102, JSONObject r103);

    void v1(Context r100, String r101, View r102, Map<String, String> r103);
}
