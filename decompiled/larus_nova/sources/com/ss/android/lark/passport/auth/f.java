package com.ss.android.lark.passport.auth;

import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes37.dex */
public interface f {

    public static final class a {
        public static /* synthetic */ Map a(f r100, String r101, String r102) {
            return r100.a(r101, r102, IPassportAuthHeaderService$authHeaders$1.INSTANCE);
        }
    }

    Map<String, String> a(String r100, String r101, Function1<? super Map<String, String>, ? extends Map<String, String>> r102);
}
