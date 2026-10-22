package com.bytedance.locallife.dito.log.error;

import com.bytedance.locallife.dito.log.ReportType;

/* JADX INFO: loaded from: classes21.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.locallife.dito.log.error.a$a, reason: collision with other inner class name */
    public static final class C3659a {
        public static String getType(a r100) {
            return r100.getClass().getSimpleName();
        }
    }

    boolean a();

    ReportType b();

    String getType();
}
