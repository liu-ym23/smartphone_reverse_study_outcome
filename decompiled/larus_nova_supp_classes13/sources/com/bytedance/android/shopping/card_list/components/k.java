package com.bytedance.android.shopping.card_list.components;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface k extends com.bytedance.android.shopping.card_list.components.a {

    public static final class a {
        public static /* synthetic */ void a(k r9, String r10, boolean r11, com.bytedance.kmp.ec.yata.common.biz.callback.a r12, boolean r13, boolean r14, boolean r15, int r16) {
            if ((r16 & 8) == 0) goto L5;
            boolean r6 = false;
        L7:
            if ((r16 & 16) == 0) goto L9;
            boolean r7 = false;
        L11:
            if ((r16 & 32) == 0) goto L13;
            boolean r8 = false;
        L14:
            r9.c(r10, r11, r12, r6, r7, r8);
            return;
        L13:
            r8 = r15;
            goto L14
        L9:
            r7 = r14;
            goto L11
        L5:
            r6 = r13;
            goto L7
        }
    }

    void a(String r1, com.bytedance.kmp.ec.yata.common.biz.callback.a r2);

    void c(String r1, boolean r2, com.bytedance.kmp.ec.yata.common.biz.callback.a r3, boolean r4, boolean r5, boolean r6);

    boolean isLoading();
}
