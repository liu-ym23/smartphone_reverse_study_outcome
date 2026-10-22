package vab;

import com.ss.android.lark.im.sdk.ImSdkProxy;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f553986a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f553987b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f553988c = false;

    static {
        f553986a = ImSdkProxy.c().isFeatureGatingEnable("messagecard.translate.support");
        f553987b = ImSdkProxy.c().isFeatureGatingEnable("messagecard.translate.force_enable_translate");
        f553988c = ImSdkProxy.c().isFeatureGatingEnable("messenger.setting.mention_user_group");
    }
}
