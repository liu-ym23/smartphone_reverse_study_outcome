package com.bytedance.ee.bear.list.create;

import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l {
    public final String a;
    public final String b;
    public final Integer c;
    public final Boolean d;
    public final Boolean e;
    public final Boolean f;
    public final String g;
    public final Boolean h;
    public final String i;
    public final Boolean j;
    public final String k;
    public final String l;
    public CreateSelectResult m;
    public String n;
    public Integer o;
    public er5.c p;

    public l(String r11, int r12, boolean r13, String r14) {
        CreateSelectResult.CREATOR.getClass();
        this(r11, r12, "", true, "", r13, r14, null, CreateSelectResult.a.b());
    }

    public l(String r3, int r4, String r5, boolean r6, String r7, boolean r8, String r9, String r10, CreateSelectResult r11) {
        Intrinsics.checkNotNullParameter(r11, "createSelectResult");
        this.c = 0;
        Boolean r0 = Boolean.FALSE;
        this.d = r0;
        this.e = r0;
        this.f = r0;
        this.h = r0;
        this.j = r0;
        this.n = "";
        this.a = r3;
        this.b = "";
        this.c = Integer.valueOf(r4);
        this.d = r0;
        this.e = r0;
        this.f = r0;
        this.g = r5;
        this.h = Boolean.valueOf(r6);
        this.i = r7;
        this.j = Boolean.valueOf(r8);
        this.k = r9;
        this.l = r10;
        this.m = r11;
        this.n = "";
    }

    public l(String r3, String r4, int r5, boolean r6, String r7, boolean r8, String r9, String r10, CreateSelectResult r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "createSelectResult");
        Intrinsics.checkNotNullParameter(r12, "spaceId");
        this.c = 0;
        Boolean r0 = Boolean.FALSE;
        this.d = r0;
        this.e = r0;
        this.f = r0;
        this.h = r0;
        this.j = r0;
        this.n = "";
        this.a = r3;
        this.b = r4;
        this.c = Integer.valueOf(r5);
        this.d = Boolean.valueOf(r6);
        this.e = r0;
        this.f = r0;
        this.g = r7;
        this.h = Boolean.valueOf(r8);
        this.i = r9;
        this.j = r0;
        this.k = "";
        this.l = r10;
        this.m = r11;
        this.n = r12;
    }
}
