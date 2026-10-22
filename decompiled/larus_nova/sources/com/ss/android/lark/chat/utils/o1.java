package com.ss.android.lark.chat.utils;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.log.Log;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes35.dex */
public final class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, Long> f416713a = null;

    static {
        f416713a = new ConcurrentHashMap();
    }

    public static Long a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return null;
    L12:
        return f416713a.get(Integer.valueOf(r100.hashCode()));
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static void c(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        f416713a.remove(Integer.valueOf(r100.hashCode()));
        Log.i("[URLPreview]CacheTime", "remove inline,card startTime,previewId: ".concat(r100));
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static void b(String r100, Long r101) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == true) goto L13;
        if (r101 == null) goto L14;
        f416713a.put(Integer.valueOf(r100.hashCode()), r101);
        return;
    L14:
        return;
    L13:
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r102 = false;
        goto L8
    }

    public static void d(String r100, Long r101) {
        int r102 = ChatCoreModule.a().getWschannelDependency().getCurNetWorkLevel().getValue();
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return;
    L11:
        if (r102 >= 4) goto L16;
        Log.i("[URLPreview]CacheTime", " key:" + r100 + ",saveFirstStartTime: " + r101 + ",netStatus:" + r102);
        b(r100, r101);
        return;
    L16:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
