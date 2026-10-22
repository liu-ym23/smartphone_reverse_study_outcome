package ru7;

import java.util.Comparator;

/* JADX INFO: loaded from: classes23.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f539274a = 0;

    /* JADX INFO: renamed from: ru7.a$a, reason: collision with other inner class name */
    public static final class C7537a implements Comparator<mvc.a> {
        public C7537a() {
        }

        @Override // java.util.Comparator
        public final int compare(mvc.a r100, mvc.a r101) {
            mvc.a r102 = r100;
            mvc.a r103 = r101;
            r102.getClass();
            r103.getClass();
            if (r102.a() >= r103.a()) goto L6;
            return 1;
        L6:
            if (r102.a() != r103.a()) goto L8;
            return 0;
        L8:
            return -1;
        }
    }

    static {
        new C7537a();
    }
}
