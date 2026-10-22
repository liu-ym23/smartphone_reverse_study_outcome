package com.huawei.hms.support.feature.result;

import android.text.TextUtils;
import com.huawei.hms.common.api.CommonStatusCodes;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AbstractAuthResultCode extends CommonStatusCodes {
    public static final int RESULT_CODE_CANCELLED = 2012;
    public static final int RESULT_CODE_EXECUTING = 2013;
    public static final int RESULT_CODE_FAILED = 2014;
    public static final int SIGN_IN_JSONEXCEPTION = 2015;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Integer, String> f277750a = null;

    static {
        HashMap r100 = new HashMap();
        f277750a = r100;
        r100.put(2012, "Auth canceled by subscriber");
        r100.put(2013, "Auth executing");
        r100.put(2014, "An unrecoverable auth failure occurred");
    }

    public AbstractAuthResultCode() {
    }

    public static String getResultDescription(int r100) {
        String r101 = f277750a.get(Integer.valueOf(r100));
        if (TextUtils.isEmpty(r101) == true) goto L5;
        return r101;
    L5:
        return "unknown status code: " + r100;
    }
}
