package com.larus.bmhome.view.actionbar.custom;

import java.util.List;

/* JADX INFO: loaded from: classes26.dex */
public interface w2 {

    public static final class a {
        public static /* synthetic */ String a(w2 r110, String r111, com.larus.bmhome.actionbar.model.r r112, List r113, com.larus.bmhome.actionbar.model.p1 r114, fq8.e r115, int r116, com.larus.bmhome.instruction.f2 r117, int r118) {
            if ((r118 & 8) == 0) goto L5;
            com.larus.bmhome.actionbar.model.p1 r100 = null;
        L7:
            if ((r118 & 16) == 0) goto L9;
            fq8.e r101 = null;
        L11:
            if ((r118 & 32) == 0) goto L13;
            int r102 = -1;
        L15:
            if ((r118 & 64) == 0) goto L17;
            com.larus.bmhome.instruction.f2 r103 = null;
        L19:
            return r110.b(r111, r112, r113, r100, r101, r102, r103);
        L17:
            r103 = r117;
            goto L19
        L13:
            r102 = r116;
            goto L15
        L9:
            r101 = r115;
            goto L11
        L5:
            r100 = r114;
            goto L7
        }
    }

    String a(String r100);

    String b(String r100, com.larus.bmhome.actionbar.model.r r101, List<com.larus.bmhome.actionbar.model.u> r102, com.larus.bmhome.actionbar.model.p1 r103, fq8.e r104, int r105, com.larus.bmhome.instruction.f2 r106);

    String c();
}
