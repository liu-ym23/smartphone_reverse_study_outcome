package com.ss.android.lark.notification.export.speech.setting;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/notification/export/speech/setting/ResourceUrlConfigValue;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ResourceUrlConfig$VALUE$2 extends Lambda implements Function0<ResourceUrlConfigValue> {
    public static final ResourceUrlConfig$VALUE$2 INSTANCE = null;

    static {
        INSTANCE = new ResourceUrlConfig$VALUE$2();
    }

    public ResourceUrlConfig$VALUE$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ResourceUrlConfigValue invoke() {
        ResourceUrlConfigValue r100 = (ResourceUrlConfigValue) SettingManager.getInstance().get(ResourceUrlConfigValue.class);     // Catch: Exception -> L8
        if (r100 != null) goto L6;
        r100 = new ResourceUrlConfigValue(null, 1, null);     // Catch: Exception -> L8
    L6:
        Log.i("ResourceUrlConfig", "ResourceUrlConfig=" + r100);     // Catch: Exception -> L8
        return r100;
    L8:
        Log.i("ResourceUrlConfig", "get ResourceUrlConfig failed.");
        return new ResourceUrlConfigValue(null, 1, null);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ResourceUrlConfigValue invoke() {
        return invoke();
    }
}
