package com.larus.bmhome.instruction;

import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes26.dex */
public interface h extends m1a.a {

    public static final class a {
        public static /* synthetic */ void a(h r100, com.larus.bmhome.actionbar.model.z0 r101, int r102, Function0 r103, int r104) {
            if ((r104 & 16) == 0) goto L5;
            r103 = null;
        L5:
            r100.h50(r101, r102, null, r103);
        }
    }

    f EI();

    com.larus.bmhome.actionbar.model.z0 Kp(String r100);

    String S20();

    void h50(com.larus.bmhome.actionbar.model.z0 r100, int r101, aq8.e r102, Function0 r103);

    void nT(String r100);

    void qz(Map<String, String> r100, String r101);

    void updateConversationId(String r100, String r101);
}
