package com.larus.avlink.impl;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f293381a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f293382b = null;

    static {
        Lazy r100 = LazyKt.lazy(new n());
        f293381a = r100;
        ArrayList r101 = new ArrayList();
        f293382b = r101;
        com.larus.avlink.platform.b r102 = (com.larus.avlink.platform.b) r100.getValue();
        r102.getClass();
        Intrinsics.checkNotNullParameter("key_vuiid_taskid", "key");
        Intrinsics.checkNotNullParameter("", "defaultValue");
        Intrinsics.checkNotNullParameter("dora_wake_history", "repoName");
        LinkedHashMap r103 = (LinkedHashMap) r102.f293550a;
        Object r104 = r103.get("dora_wake_history");
        if (r104 != null) goto L5;
        r104 = Keva.getRepo("dora_wake_history", 0);
        r103.put("dora_wake_history", r104);
    L5:
        List r105 = StringsKt.split$default(((Keva) r104).getString("key_vuiid_taskid", ""), new char[]{'\n'}, false, 0, 6, null);
        ArrayList r106 = new ArrayList();
        Iterator r107 = r105.iterator();
    L7:
        if (r107.hasNext() == false) goto L14;
        Object r108 = r107.next();
        if (((String) r108).length() <= 0) goto L11;
        boolean r109 = true;
    L12:
        if (r109 == false) goto L7;
        r106.add(r108);
        goto L7
    L11:
        r109 = false;
        goto L12
    L14:
        r101.addAll(r106);
    }

    public static void a(int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, DBDefinition.TASK_ID);
        if (r111.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        List<String> r101 = f293382b;
        StringBuilder r102 = new StringBuilder();
        Intrinsics.checkNotNullParameter("yyyy-MM-dd HH:mm:ss.SSS", "pattern");
        r102.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US).format(new Date(System.currentTimeMillis())));
        r102.append(" vuiId:");
        r102.append(r110);
        r102.append(" taskId:");
        r102.append(r111);
        ListProtector.add(r101, 0, r102.toString());
        ArrayList r112 = (ArrayList) r101;
        if (r112.size() <= 10) goto L11;
        ListProtector.remove(r101, r112.size() - 1);
    L11:
        com.larus.avlink.platform.b r113 = (com.larus.avlink.platform.b) f293381a.getValue();
        String r114 = CollectionsKt.joinToString$default(r101, "\n", null, null, 0, null, null, 62, null);
        r113.getClass();
        Intrinsics.checkNotNullParameter("key_vuiid_taskid", "key");
        Intrinsics.checkNotNullParameter(r114, "value");
        Intrinsics.checkNotNullParameter("dora_wake_history", "repoName");
        LinkedHashMap r115 = (LinkedHashMap) r113.f293550a;
        Object r103 = r115.get("dora_wake_history");
        if (r103 != null) goto L14;
        r103 = Keva.getRepo("dora_wake_history", 0);
        r115.put("dora_wake_history", r103);
    L14:
        ((Keva) r103).storeString("key_vuiid_taskid", r114);
        return;
    L5:
        r100 = false;
        goto L6
    }
}
