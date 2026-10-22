package com.ss.android.lark.feed.shared.fg;

import com.ss.android.lark.biz.im.api.b0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f421183a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f421184b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f421185c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, Boolean> f421186d = null;

    public class a implements b0 {
        public a() {
        }
    }

    static {
        f421185c = new Object();
        new a();
        HashMap r100 = new HashMap();
        f421186d = r100;
        Boolean r101 = Boolean.TRUE;
        r100.put("feed.shortcut", r101);
        r100.put("urgent.urgentList", r101);
        r100.put("secretChat", r101);
        r100.put("label", r101);
    }
}
