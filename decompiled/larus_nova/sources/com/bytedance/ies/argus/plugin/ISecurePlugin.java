package com.bytedance.ies.argus.plugin;

import com.bytedance.ies.argus.plugin.c;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes19.dex */
public abstract class ISecurePlugin<INSTANCE extends c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f246070a;

    public abstract SecLinkPluginHandler a(String r100);

    public abstract Class<INSTANCE> b();

    public abstract boolean c();

    public abstract SecurePluginType d();

    public ISecurePlugin() {
        this.f246070a = LazyKt.lazy(new ISecurePlugin$pluginName$2(this));
    }
}
