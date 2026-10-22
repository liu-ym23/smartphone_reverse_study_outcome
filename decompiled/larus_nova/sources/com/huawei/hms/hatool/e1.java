package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class e1 {
    public static String a(String r100, String r101, String r102, String r103) {
        if (TextUtils.isEmpty(r101) == false) goto L7;
        v.f("hmsSdk", "checkStrParameter() Parameter verification failure! Parameter:" + r100);
        return r103;
    L7:
        if (a(r100, r101, r102) == false) goto L9;
        return r101;
    L9:
        return r103;
    }

    public static boolean a(String r100) {
        return !a(com.heytap.mcssdk.constant.b.f276361k, r100, 256);
    }

    public static boolean a(String r100, String r101, int r102) {
        if (TextUtils.isEmpty(r101) == false) goto L8;
        StringBuilder r103 = new StringBuilder("checkString() Parameter is empty : ");
    L5:
        r103.append(r100);
        v.f("hmsSdk", r103.toString());
        return false;
    L8:
        if (r101.length() <= r102) goto L10;
        r103 = new StringBuilder("checkString() Failure of parameter length check! Parameter:");
        goto L5
    L10:
        return true;
    }

    public static boolean a(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == false) goto L8;
        StringBuilder r103 = new StringBuilder("checkString() Parameter is null! Parameter:");
    L5:
        r103.append(r100);
        v.f("hmsSdk", r103.toString());
        return false;
    L8:
        if (PatternProtector.compile(r102).matcher(r101).matches() == false) goto L11;
        return true;
    L11:
        r103 = new StringBuilder("checkString() Parameter verification failure! Parameter:");
        goto L5
    }

    public static boolean a(Map<String, String> r100) {
        if (r100 != null) goto L5;
    L23:
        String r101 = "onEvent() mapValue has not data.so,The data will be empty";
    L14:
        v.f("hmsSdk", r101);
        return false;
    L5:
        if (r100.size() == 0) goto L23;
        if (r100.size() != 1) goto L17;
        if (r100.get("constants") == null) goto L12;
    L13:
        r101 = "checkMap() the key can't be constants or _constants";
        goto L14
    L12:
        if (r100.get("_constants") != null) goto L13;
    L17:
        if (r100.size() <= 2048) goto L19;
    L22:
        r101 = "checkMap Map data is too big! size: " + r100.size() + " length: " + r100.toString().length();
        goto L14
    L19:
        if (r100.toString().length() > 204800) goto L22;
        return true;
    }
}
