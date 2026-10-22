package com.bytedance.iesgurd.settings;

import android.content.Context;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.iesgurd.core.GlobalManager;
import ez5.g;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f250847b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f250848a;

    public static final class a {
    }

    static {
    }

    public final GlobalConfigSettings a() {
        String r100 = g.a.f474886a.a(this.f250848a, "gecko_settings", null);
        if (r100 == null) goto L10;
        sy5.b r101 = sy5.b.f543888b;     // Catch: Throwable -> L7
        return (GlobalConfigSettings) sy5.b.f543888b.f543890a.fromJson(r100, GlobalConfigSettings.class);
    L11:
        return null;
    L10:
        return null;
    }

    public b() {
        this.f250848a = GlobalManager.f250642k.getContext();
    }
}
