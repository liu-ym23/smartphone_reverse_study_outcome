package com.vivo.push.i;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String[] f462390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<String> f462391b;

    /* JADX INFO: renamed from: com.vivo.push.i.a$a, reason: collision with other inner class name */
    public static class C5550a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f462392a;

        static {
            f462392a = new a(0);
        }

        public static /* synthetic */ a a() {
            return f462392a;
        }
    }

    static {
        f462390a = new String[]{"com.vivo.pushservice", "com.vivo.pushdemo.test", "com.vivo.sdk.test"};
    }

    public final boolean b() {
        ArrayList<String> r100 = this.f462391b;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.size() == 0) goto L10;
        return true;
    L10:
        return false;
    }

    private a() {
        this.f462391b = null;
        this.f462391b = new ArrayList();
    }

    public static a a() {
        return C5550a.a();
    }

    public /* synthetic */ a(byte r100) {
        this();
    }
}
