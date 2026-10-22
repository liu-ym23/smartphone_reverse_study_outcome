package com.ss.android.lark.chameleon.bridge;

import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.JsonUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0002J6\u0010\b\u001a\u00020\t2&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\f2\u0006\u0010\r\u001a\u00020\u0004J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/chameleon/bridge/BridgeInfoPrinter;", "", "()V", "TAG", "", "getLength", "", "param", "printInfo", "", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "result", "printLengthInfo", "extraMessage", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BridgeInfoPrinter {
    private final String TAG;

    public BridgeInfoPrinter() {
        this.TAG = "BridgeInfoPrinter";
    }

    private final int getLength(Object r100) {
        if (r100 != null) goto L4;
        return 0;
    L4:
        if ((r100 instanceof String) == false) goto L8;
        return ((String) r100).length();
    L8:
        if ((r100 instanceof JSONObject) == false) goto L12;
        return ((JSONObject) r100).toString().length();
    L12:
        if ((r100 instanceof JsonObject) == false) goto L16;
        return JsonUtils.INSTANCE.toJsonString(r100).length();
    L16:
        return r100.toString().length();
    }

    private final void printLengthInfo(Object r100, String r101) {
        if ((r100 instanceof HashMap) == false) goto L9;
        Iterator r102 = ((HashMap) r100).keySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L14;
        Object r103 = r102.next();
        Object r104 = ((Map) r100).get(r103);
        Log.i(this.TAG, r101 + "key: " + r103 + "--value length: " + getLength(r104));
        goto L6
    L14:
        return;
    L9:
        if ((r100 instanceof String) == false) goto L13;
        Log.i(this.TAG, r101 + ((String) r100).length());
        return;
    }

    public final void printInfo(HashMap<String, Object> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "result");
    L9:
        th = move-exception;
        Log.e(this.TAG, th.toString());
        return;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return;
    L6:
        if (r101.length() <= 2097152) goto L15;
        printLengthInfo(r100, "param before serialize ");     // Catch: Throwable -> L9
        printLengthInfo(r101, "param after serialize ");     // Catch: Throwable -> L9
        return;
    }
}
