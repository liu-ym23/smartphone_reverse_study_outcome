package com.ss.android.lark.commonmark.internal;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import v7b.v;

/* JADX INFO: loaded from: classes35.dex */
public final class l extends y7b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v7b.m f417238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<CharSequence> f417239b;

    public static class a extends y7b.b {
        public a() {
        }

        @Override // y7b.e
        public final d a(y7b.g r100, h.a r101) {
            h r102 = (h) r100;
            if (r102.f417212h >= 4) goto L5;
            return null;
        L5:
            if (r102.f417213i == false) goto L7;
            return null;
        L7:
            if ((r102.h().a() instanceof v) == true) goto L13;
            d r103 = new d(new y7b.d[]{new l()});
            r103.f417185c = r102.f417208d + 4;
            return r103;
        L13:
            return null;
        }
    }

    @Override // y7b.a, y7b.d
    public final void c() {
        int r100 = ((ArrayList) this.f417239b).size() - 1;
    L3:
        int r101 = 0;
        if (r100 < 0) goto L12;
        CharSequence r102 = (CharSequence) ListProtector.get(this.f417239b, r100);
        if (a8b.b.c(r102, 0, r102.length()) != r102.length()) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r100 = r100 - 1;
        goto L3
    L8:
        r103 = false;
    L12:
        StringBuilder r104 = new StringBuilder();
    L14:
        if (r101 >= (r100 + 1)) goto L16;
        r104.append((CharSequence) ListProtector.get(this.f417239b, r101));
        r101 = r101 + 1;
        goto L14
    L16:
        this.f417238a.getClass();
    }

    public l() {
        this.f417238a = new v7b.m();
        this.f417239b = new ArrayList();
    }

    @Override // y7b.d
    public final v7b.a a() {
        return this.f417238a;
    }

    @Override // y7b.a, y7b.d
    public final void e(w7b.f r100) {
        List<CharSequence> r101 = this.f417239b;
        ArrayList r102 = (ArrayList) r101;
        r102.add(r100.f558606a);
    }

    @Override // y7b.d
    public final y7b.c h(y7b.g r100) {
        h r101 = (h) r100;
        if (r101.f417212h < 4) goto L7;
        return new b(-1, r101.f417208d + 4, false);
    L7:
        if (r101.f417213i == true) goto L9;
        return null;
    L9:
        return y7b.c.a(r101.f417210f);
    }
}
