package com.bytedance.bpea.entry.api.device.info;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class SettingsEntry$Companion$getSecureAndroidIdUnsafe$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Context $context;

    public SettingsEntry$Companion$getSecureAndroidIdUnsafe$1(Context r100) {
        this.$context = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        ContentResolver r100 = this.$context.getContentResolver();
        f06.c r101 = new f06.c();
        Object[] r110 = {r100, "android_id"};
        f06.b r111 = new f06.b();
        f06.d r112 = r101.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r110, "java.lang.String", r111);
        if (r112.f474982a == false) goto L5;
        r101.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r110, null, r111, false);
        return (String) r112.f474983b;
    L5:
        String r102 = Settings.Secure.getString(r100, "android_id");
        r101.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r110, r102, r111, true);
        return r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
