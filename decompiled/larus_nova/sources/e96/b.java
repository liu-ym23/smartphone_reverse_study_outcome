package e96;

import com.bytedance.interaction.game.base.settings.model.IInteractiveSettings;
import com.bytedance.news.common.settings.SettingsUpdateListener;
import com.bytedance.news.common.settings.api.SettingsData;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements SettingsUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f471507a = null;

    static {
        f471507a = new b();
    }

    public b() {
    }

    @Override // com.bytedance.news.common.settings.SettingsUpdateListener
    public final void onSettingsUpdate(SettingsData r100) {
        IInteractiveSettings r101 = (IInteractiveSettings) g37.a.c("interactive_sdk").b(IInteractiveSettings.class);
        com.bytedance.interaction.game.base.settings.model.d r102 = r101.getPredefineConfig();
        int r103 = f96.a.f475971a;
        StringBuilder r104 = new StringBuilder("predefine settings:");
        if (r102 == null) goto L5;
        Boolean r105 = r102.b();
    L6:
        r104.append(r105);
        f96.a.a("interactive_settings", r104.toString(), null);
        if (r102 == null) goto L9;
        Map<Class<?>, Object> r106 = c.f471508a;
        c.a(com.bytedance.interaction.game.base.settings.model.d.class, r102);
    L9:
        com.bytedance.interaction.game.base.settings.model.b r107 = r101.getInteractiveGameConfigs();
        if (r107 == null) goto L13;
        Map<Class<?>, Object> r108 = c.f471508a;
        c.a(d96.a.class, r107);
        return;
    L13:
        return;
    L5:
        r105 = null;
        goto L6
    }
}
