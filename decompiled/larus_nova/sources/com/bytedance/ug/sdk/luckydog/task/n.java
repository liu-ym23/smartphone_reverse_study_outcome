package com.bytedance.ug.sdk.luckydog.task;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.ug.sdk.luckydog.api.model.SchemaAckType;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f271932a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f271933b;

    /* JADX INFO: loaded from: classes22.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f271934a = null;

        static {
            int[] r100 = new int[SchemaAckType.values().length];
            f271934a = r100;
            r100[SchemaAckType.ACK_TIME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f271934a[SchemaAckType.ACK_COUNT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        f271932a = new Handler(Looper.getMainLooper());
        f271933b = false;
    }

    public static Set<String> b() {
        CopyOnWriteArraySet r100 = new CopyOnWriteArraySet();
        JSONArray r101 = new JSONArray(il7.m.b("luckydog_task_union.prefs").e("key_cross_tokens", ""));     // Catch: Throwable -> L12
        if (r101.length() <= 0) goto L14;
        int r102 = 0;
    L7:
        if (r102 >= r101.length()) goto L14;
        String r103 = JSONArrayProtectorUtils.getString(r101, r102);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r103) == true) goto L11;
        r100.add(r103);     // Catch: Throwable -> L12
    L11:
        r102 = r102 + 1;
    L14:
        return r100;
    L12:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("TimerTaskHelper", th.getMessage());
        goto L14
    }

    public static JSONArray a(Set<String> r100) {
        JSONArray r101 = new JSONArray();
        if (r100 == null) goto L8;
        Iterator<String> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r101.put(r102.next());
    L8:
        return r101;
    }

    public static void c(Set<String> r100) {
        f271933b = true;
        if (r100 != null) goto L5;
        r100 = new HashSet();
    L5:
        String r101 = a(r100).toString();
        il7.m.b("luckydog_task_union.prefs").k("key_cross_tokens", r101);
    }
}
