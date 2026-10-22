package com.larus.bmhome.actionbar.model;

import java.util.List;

/* JADX INFO: loaded from: classes25.dex */
public interface k1 {

    public static final class a {
        public static /* synthetic */ String a(k1 r100, String r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            return r100.c(r101, null);
        }
    }

    String a();

    List<String> b(List<String> r100);

    String c(String r100, List<String> r101);
}
