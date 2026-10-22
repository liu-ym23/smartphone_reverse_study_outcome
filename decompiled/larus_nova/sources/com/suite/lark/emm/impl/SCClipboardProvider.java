package com.suite.lark.emm.impl;

import boc.b;
import com.ss.android.lark.utils.LarkContext;
import doc.e;
import e0c.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes40.dex */
public final class SCClipboardProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f460435a = null;

    static {
        f460435a = LazyKt.lazy(SCClipboardProvider$mMIUIMenuJumpListeners$2.INSTANCE);
    }

    public static b a() {
        return ((com.suite.lark.emm.impl.clipboard.userscope.export.a) k.a(LarkContext.getApplication(), com.suite.lark.emm.impl.clipboard.userscope.export.a.class)).getClipboardManager();
    }

    @JvmStatic
    public static final boolean b() {
        return ((e) k.a(LarkContext.getApplication(), e.class)).Q7();
    }
}
