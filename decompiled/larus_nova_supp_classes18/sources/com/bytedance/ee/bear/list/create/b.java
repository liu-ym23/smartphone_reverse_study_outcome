package com.bytedance.ee.bear.list.create;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.lark.biz.bitable.BitableTabFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final Context a;
    public final m b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final DocumentCreateInfo h;
    public final Fragment i;

    public final Context getContext() {
        return this.a;
    }

    public b(Context r1, m r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public b(Context r8, String r9, String r10, String r11, DocumentCreateInfo r12) {
        this(r8, r9, r10, r11, r12, null);
    }

    public b(Context r1, String r2, String r3, String r4, DocumentCreateInfo r5, BitableTabFragment r6) {
        this.a = r1;
        this.d = "";
        this.e = r2;
        this.g = r3;
        this.h = r5;
        this.f = r4;
        this.i = r6;
    }
}
