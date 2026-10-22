package com.ss.android.lark.chat.utils;

import com.ss.android.lark.chatbase.BasePageStore;

/* JADX INFO: loaded from: classes35.dex */
public final class y implements hya.c<String, f5b.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f416750a;

    public static final class a<T> implements hya.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<T> f416751a = null;

        static {
            f416751a = new a();
        }

        public a() {
        }

        @Override // hya.a
        public final Object a(Object r100) {
            f5b.b r101 = (f5b.b) r100;
            if (r101 == null) goto L5;
            r101.setForceUpdate(true);
            return r101;
        L5:
            return null;
        }
    }

    @Override // hya.c
    public final hya.b<String> b() {
        return new BasePageStore.e(this.f416750a);
    }

    @Override // hya.c
    public final hya.a<f5b.b> a() {
        return a.f416751a;
    }

    public y(String r100) {
        this.f416750a = r100;
    }
}
