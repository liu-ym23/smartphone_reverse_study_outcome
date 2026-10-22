package com.ss.android.lark.coremdbiz.facade.link.parser;

import android.text.Spanned;
import com.ss.android.lark.coremd.base.parse.r;
import v7b.n;

/* JADX INFO: loaded from: classes35.dex */
public interface b {

    public interface a<T extends dab.a> {
        Spanned a(r<n> r100, T r101);

        Class<T> getType();
    }

    void a();

    Spanned b(r<n> r100, dab.a r101);

    void c(a<?> r100);
}
