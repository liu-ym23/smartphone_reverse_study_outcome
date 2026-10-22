package com.larksuite.component.dynamicresources;

import com.ss.android.lark.component.appcontext.LarkAppContext;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f283996a = false;

    static {
        f283996a = LarkAppContext.inst().buildConfig().isUsPackage();
    }
}
