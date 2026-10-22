package com.ss.android.lark.chatwindow.launcher;

import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ILaunchDataInput;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.RealLaunchData;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatLauncherV2_Factory implements Factory<ChatLauncherV2> {
    private final Provider<m> passportProvider;
    private final Provider<Map<RealLaunchData.ChatDirection, Provider<com.ss.android.lark.chatwindow.launcher.starter.a>>> startersProvider;
    private final Provider<Map<ILaunchDataInput.LaunchDataType, Provider<com.ss.android.lark.chatwindow.launcher.transform.a<? extends ILaunchDataInput>>>> transformersProvider;

    @Override // javax.inject.Provider
    public ChatLauncherV2 get() {
        return newInstance(this.passportProvider.get(), this.transformersProvider.get(), this.startersProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatLauncherV2_Factory(Provider<m> r100, Provider<Map<ILaunchDataInput.LaunchDataType, Provider<com.ss.android.lark.chatwindow.launcher.transform.a<? extends ILaunchDataInput>>>> r101, Provider<Map<RealLaunchData.ChatDirection, Provider<com.ss.android.lark.chatwindow.launcher.starter.a>>> r102) {
        this.passportProvider = r100;
        this.transformersProvider = r101;
        this.startersProvider = r102;
    }

    public static ChatLauncherV2_Factory create(Provider<m> r100, Provider<Map<ILaunchDataInput.LaunchDataType, Provider<com.ss.android.lark.chatwindow.launcher.transform.a<? extends ILaunchDataInput>>>> r101, Provider<Map<RealLaunchData.ChatDirection, Provider<com.ss.android.lark.chatwindow.launcher.starter.a>>> r102) {
        return new ChatLauncherV2_Factory(r100, r101, r102);
    }

    public static ChatLauncherV2 newInstance(m r100, Map<ILaunchDataInput.LaunchDataType, Provider<com.ss.android.lark.chatwindow.launcher.transform.a<? extends ILaunchDataInput>>> r101, Map<RealLaunchData.ChatDirection, Provider<com.ss.android.lark.chatwindow.launcher.starter.a>> r102) {
        return new ChatLauncherV2(r100, r101, r102);
    }
}
