package com.bytedance.ee.bear.docsemoji;

import android.content.Context;
import android.widget.ImageView;
import sz7.q;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements uz4.a {
    public a() {
    }

    @Override // uz4.a
    public final void b(String r110, String r111, ImageView r112) {
        q r100 = new q(r112.getContext());
        q.d(r100, r110, r111, -1, -1, null, false, null);
        r112.setImageDrawable(r100);
    }

    @Override // uz4.a
    public final q a(Context r110, String r111, String r112, int r113) {
        q r100 = new q(r110);
        q.d(r100, r111, r112, -1, -1, r110.getDrawable(r113), false, null);
        return r100;
    }

    @Override // uz4.a
    public final void c(String r100, String r101, int r102, ImageView r103) {
        r103.setImageDrawable(a(r103.getContext(), r100, r101, r102));
    }

    @Override // uz4.a
    public final void d(String r110, String r111, int r112, ImageView r113, boolean r114) {
        Context r100 = r113.getContext();
        q r101 = new q(r100);
        q.d(r101, r110, r111, -1, -1, r100.getDrawable(r112), r114, 0);
        r113.setImageDrawable(r101);
    }
}
