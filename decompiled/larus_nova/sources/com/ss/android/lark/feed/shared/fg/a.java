package com.ss.android.lark.feed.shared.fg;

import com.ss.android.lark.biz.im.api.b0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f421178a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f421179b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f421180c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f421181d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Boolean> f421182e = null;

    /* JADX INFO: renamed from: com.ss.android.lark.feed.shared.fg.a$a, reason: collision with other inner class name */
    public class C4965a implements b0 {
        public C4965a() {
        }
    }

    static {
        f421181d = new Object();
        new C4965a();
        HashMap r100 = new HashMap();
        f421182e = r100;
        Boolean r101 = Boolean.TRUE;
        r100.put("feed.shortcut", r101);
        r100.put("urgent.urgentList", r101);
        r100.put("secretChat", r101);
        r100.put("label", r101);
    }

    public static void a() {
        if (f421178a == false) goto L5;
        return;
    L5:
        Object r100 = f421181d;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (f421178a == false) goto L11;
        monitor-exit(r100);     // Catch: Throwable -> L14
        return;
    L11:
        peb.b.InterfaceC7189b r101 = heb.a.f484903a.getAppConfigDependency();     // Catch: Throwable -> L14
        r101.c();     // Catch: Throwable -> L14
        r101.a();     // Catch: Throwable -> L14
        f421179b = false;     // Catch: Throwable -> L14
        r101.a();     // Catch: Throwable -> L14
        r101.a();     // Catch: Throwable -> L14
        r101.a();     // Catch: Throwable -> L14
        f421180c = false;     // Catch: Throwable -> L14
        f421178a = true;     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
    }
}
