package com.ss.android.lark.chameleon;

import android.content.res.Configuration;
import com.bytedance.ee.bear.browser.plugin.t;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chameleon/ChameleonContainerLifecycleListener;", "", "onPluginHostCreated", "", "pluginHost", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "pluginMounter", "Lkotlin/Function0;", "onPreCreateTitleBar", "onPreCreateUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onPreFragmentViewCreated", "onPreFragmentStart", "onPreFragmentResume", "onPreFragmentPause", "onPreFragmentStop", "onPreFragmentDestroyView", "onPreFragmentDestroy", "onPreConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ChameleonContainerLifecycleListener {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onPreConfigurationChanged(ChameleonContainerLifecycleListener r100, ChameleonPluginHost r101, Configuration r102) {
            Intrinsics.checkNotNullParameter(r101, "pluginHost");
            Intrinsics.checkNotNullParameter(r102, "newConfig");
        }

        public static void onPreCreateTitleBar(ChameleonContainerLifecycleListener r100, ChameleonPluginHost r101) {
            Intrinsics.checkNotNullParameter(r101, "pluginHost");
        }

        public static void onPreCreateUIContainer(ChameleonContainerLifecycleListener r100, ChameleonPluginHost r101, t r102) {
            Intrinsics.checkNotNullParameter(r101, "pluginHost");
            Intrinsics.checkNotNullParameter(r102, "uiContainer");
        }

        public static void onPreFragmentDestroy(ChameleonContainerLifecycleListener r100, ChameleonPluginHost r101) {
            Intrinsics.checkNotNullParameter(r101, "pluginHost");
        }

        public static void onPreFragmentDestroyView(ChameleonContainerLifecycleListener r100, ChameleonPluginHost r101) {
            Intrinsics.checkNotNullParameter(r101, "pluginHost");
        }

        public static void onPreFragmentPause(ChameleonContainerLifecycleListener r100, ChameleonPluginHost r101) {
            Intrinsics.checkNotNullParameter(r101, "pluginHost");
        }

        public static void onPreFragmentResume(ChameleonContainerLifecycleListener r100, ChameleonPluginHost r101) {
            Intrinsics.checkNotNullParameter(r101, "pluginHost");
        }

        public static void onPreFragmentStart(ChameleonContainerLifecycleListener r100, ChameleonPluginHost r101) {
            Intrinsics.checkNotNullParameter(r101, "pluginHost");
        }

        public static void onPreFragmentStop(ChameleonContainerLifecycleListener r100, ChameleonPluginHost r101) {
            Intrinsics.checkNotNullParameter(r101, "pluginHost");
        }

        public static void onPreFragmentViewCreated(ChameleonContainerLifecycleListener r100, ChameleonPluginHost r101) {
            Intrinsics.checkNotNullParameter(r101, "pluginHost");
        }

        public static void onPluginHostCreated(ChameleonContainerLifecycleListener r100, ChameleonPluginHost r101, Function0<Unit> r102) {
            Intrinsics.checkNotNullParameter(r101, "pluginHost");
            Intrinsics.checkNotNullParameter(r102, "pluginMounter");
            r102.invoke();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onPluginHostCreated$default(ChameleonContainerLifecycleListener r100, ChameleonPluginHost r101, Function0 r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = AnonymousClass1.INSTANCE;
        L6:
            r100.onPluginHostCreated(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPluginHostCreated");
        }
    }

    void onPluginHostCreated(ChameleonPluginHost r100, Function0<Unit> r101);

    void onPreConfigurationChanged(ChameleonPluginHost r100, Configuration r101);

    void onPreCreateTitleBar(ChameleonPluginHost r100);

    void onPreCreateUIContainer(ChameleonPluginHost r100, t r101);

    void onPreFragmentDestroy(ChameleonPluginHost r100);

    void onPreFragmentDestroyView(ChameleonPluginHost r100);

    void onPreFragmentPause(ChameleonPluginHost r100);

    void onPreFragmentResume(ChameleonPluginHost r100);

    void onPreFragmentStart(ChameleonPluginHost r100);

    void onPreFragmentStop(ChameleonPluginHost r100);

    void onPreFragmentViewCreated(ChameleonPluginHost r100);
}
