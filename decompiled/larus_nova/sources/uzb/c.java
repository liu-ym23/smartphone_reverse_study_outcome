package uzb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ss.android.lark.passport.base.core.log.PassportLog;

/* JADX INFO: loaded from: classes37.dex */
public final class c {
    public static Object a(JSONObject r100, Class r101) {
        if (r100 != null) goto L10;
        return null;
    L10:
        return JSON.parseObject(r100.toJSONString(), r101);
    L7:
        th = move-exception;
        PassportLog.c("JsonUtils", "parseObject failed, from JSON to Class:" + r101, th);
        return null;
    }
}
