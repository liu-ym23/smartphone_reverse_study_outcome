package nx3;

import android.content.Context;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public interface e {
    boolean isEnable();

    void loginEtWithScheme(String r100, Context r101);

    void putEvent(String r100, JSONArray r101);

    void setEnable(boolean r100, Context r101);

    void setEventVerifyInterval(long r100);

    void setEventVerifyUrl(String r100);

    void setSpecialKeys(List<String> r100);
}
