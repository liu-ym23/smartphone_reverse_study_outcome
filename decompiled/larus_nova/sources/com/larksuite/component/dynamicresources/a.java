package com.larksuite.component.dynamicresources;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile C3910a f283994a;

    /* JADX INFO: renamed from: com.larksuite.component.dynamicresources.a$a, reason: collision with other inner class name */
    public class C3910a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, Long> f283995a;

        public C3910a() {
            this.f283995a = new ConcurrentHashMap();
        }
    }

    static {
        f283994a = new C3910a();
    }
}
