package com.ss.android.lark.integrator.ccm.im;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.appsetting.api.SettingManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/integrator/ccm/im/PreloadDocConfig;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class WebContainerResourceLoadTask$enableChatTypes$2 extends Lambda implements Function0<PreloadDocConfig> {
    public static final WebContainerResourceLoadTask$enableChatTypes$2 INSTANCE = null;

    static {
        INSTANCE = new WebContainerResourceLoadTask$enableChatTypes$2();
    }

    public WebContainerResourceLoadTask$enableChatTypes$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PreloadDocConfig invoke() {
        return (PreloadDocConfig) SettingManager.getInstance().get(PreloadDocConfig.class);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ PreloadDocConfig invoke() {
        return invoke();
    }
}
