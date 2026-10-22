package com.ss.android.lark.floating.widget.appfloat;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f421938a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, AppFloatManager> f421939b = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppFloatManager f421940a;

        public a(AppFloatManager r100, int r101, int r102) {
            this.f421940a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AppFloatManager r100 = this.f421940a;     // Catch: Throwable -> L6
            if (r100.f421879e == null) goto L9;
            AppFloatManager.i(r100, null, null, 3);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public c() {
    }

    static {
        f421938a = new c();
        f421939b = new LinkedHashMap();
    }

    public static AppFloatManager a(String r100) {
        Map<String, AppFloatManager> r101 = f421939b;
        if (r100 != null) goto L6;
        r100 = "default";
    L6:
        return (AppFloatManager) ((LinkedHashMap) r101).get(r100);
    }

    public final void update(String r100) {
        Map<String, AppFloatManager> r101 = f421939b;
        if (r100 != null) goto L5;
        r100 = "default";
    L5:
        AppFloatManager r102 = (AppFloatManager) ((LinkedHashMap) r101).get(r100);
        if (r102 == null) goto L11;
        d r103 = r102.f421879e;
        if (r103 == null) goto L12;
        r103.post(new a(r102, r103.getWidth(), r103.getHeight()));
        return;
    L12:
        return;
    }
}
