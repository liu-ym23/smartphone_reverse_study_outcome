package com.ss.android.lark;

import android.content.Context;
import com.ss.android.lark.component.appcontext.LarkAppContext;

/* JADX INFO: loaded from: classes34.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f425765a;

    public interface a {
        String getUserId();
    }

    static {
        f425765a = new f();
    }

    public static Context getContext() {
        return LarkAppContext.inst().getContext();
    }
}
