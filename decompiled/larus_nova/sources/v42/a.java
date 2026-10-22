package v42;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.plugin.FeaturePluginType;

/* JADX INFO: loaded from: classes9.dex */
public interface a {
    FeaturePluginType getType();

    void onDestroy();

    void onInit();

    void onLoad();

    void onUnload();
}
