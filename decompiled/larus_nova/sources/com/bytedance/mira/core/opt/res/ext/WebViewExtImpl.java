package com.bytedance.mira.core.opt.res.ext;

import android.content.Context;
import com.bytedance.mira.util.ReflectUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public abstract class WebViewExtImpl implements IWebViewExt {
    protected static final Field sProviderLockField = null;

    public WebViewExtImpl() {
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IWebViewExt
    public void init(Context r100) {
    }

    static {
        Field r100 = ReflectUtils.findDeclaredField(Class.forName("android.webkit.WebViewFactory"), "sProviderLock");     // Catch: Throwable -> L4
    L5:
        sProviderLockField = r100;
        return;
    L4:
        r100 = null;
        goto L5
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IWebViewExt
    public Object getProviderLock() {
        return ReflectUtils.readDeclaredField(sProviderLockField, null);
    }
}
