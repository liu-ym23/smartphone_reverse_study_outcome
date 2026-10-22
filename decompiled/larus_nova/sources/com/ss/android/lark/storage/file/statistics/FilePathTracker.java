package com.ss.android.lark.storage.file.statistics;

import android.content.Context;
import android.os.Environment;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import o6c.e;

/* JADX INFO: loaded from: classes38.dex */
public final class FilePathTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile e f441019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f441020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f441021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f441022d;

    public FilePathTracker() {
        this.f441020b = 10;
        this.f441021c = new ConcurrentHashMap();
        FilePathTracker$pathFilter$1 r100 = FilePathTracker$pathFilter$1.INSTANCE;
        this.f441022d = LazyKt.lazy(FilePathTracker$scope$2.INSTANCE);
    }

    public final String a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "originDir");
        e r102 = this.f441019a;
        if (r102 != null) goto L19;
        e.a r103 = new e.a();
        r103.a(r100.getFilesDir().getAbsolutePath(), "/internalFiles");
        r103.a(r100.getCacheDir().getAbsolutePath(), "/internalCache");
        String r104 = r100.getCacheDir().getParent();
        if (r104 == null) goto L7;
        r103.a(r104, "/internalRoot");
    L7:
        File r105 = r100.getExternalFilesDir(null);
        if (r105 == null) goto L10;
        r103.a(r105.getAbsolutePath(), "/externalFiles");
    L10:
        File r106 = r100.getExternalCacheDir();
        if (r106 == null) goto L38;
        r103.a(r106.getAbsolutePath(), "/externalCache");
        String r107 = r106.getParent();
        if (r107 == null) goto L38;
        r103.a(r107, "/externalRoot");
    L38:
        String r108 = Environment.getExternalStorageDirectory().getAbsolutePath();     // Catch: Exception -> L17
        Intrinsics.checkNotNull(r108);     // Catch: Exception -> L17
    L18:
        r103.a(r108, "/externalPublic");
        Intrinsics.checkNotNullParameter("/[0-9]{15,20}", "from");
        Intrinsics.checkNotNullParameter("/user", RemoteMessageConst.TO);
        r103.f522237b.put(new Regex("/[0-9]{15,20}"), "/user");
        r102 = new e(r103.f522236a, r103.f522237b);
    L17:
        r108 = "/storage/emulated/0";
    L19:
        this.f441019a = r102;
        e r109 = this.f441019a;
        Intrinsics.checkNotNull(r109);
        r109.getClass();
        Intrinsics.checkNotNullParameter(r101, "text");
        Iterator<T> r110 = r109.f522234a.entrySet().iterator();
        String r111 = r101;
    L21:
        if (r110.hasNext() == false) goto L23;
        Map.Entry r112 = (Map.Entry) r110.next();
        r111 = StringsKt.replace$default(r111, (String) r112.getKey(), (String) r112.getValue(), false, 4, null);
        goto L21
    L23:
        Iterator<T> r113 = r109.f522235b.entrySet().iterator();
    L25:
        if (r113.hasNext() == false) goto L27;
        Map.Entry r114 = (Map.Entry) r113.next();
        r111 = ((Regex) r114.getKey()).replace(r111, (String) r114.getValue());
        goto L25
    L27:
        StringBuilder r115 = new StringBuilder();
        int r116 = r111.length();
        int r117 = 0;
        int r118 = 0;
    L28:
        if (r117 >= r116) goto L37;
        char r119 = r111.charAt(r117);
        if (r119 != '/') goto L33;
        r118 = r118 + 1;
    L33:
        if (r118 > this.f441020b) goto L37;
        r115.append(r119);
        r117 = r117 + 1;
    L37:
        return r115.toString();
    }
}
