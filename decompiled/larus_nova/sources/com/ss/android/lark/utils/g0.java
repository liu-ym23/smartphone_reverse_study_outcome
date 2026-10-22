package com.ss.android.lark.utils;

import com.bytedance.supervisor.token.Token;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes38.dex */
public interface g0 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f444709a;

        public a(boolean r100) {
            this.f444709a = r100;
        }
    }

    void requestPermissions(Token r100, String[] r101, Function1<? super a, Unit> r102);
}
