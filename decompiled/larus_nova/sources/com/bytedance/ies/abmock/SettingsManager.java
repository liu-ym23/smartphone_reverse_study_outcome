package com.bytedance.ies.abmock;

import com.bytedance.ies.abmock.datacenter.init.IABMockInitConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import i06.d;
import j06.b;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes19.dex */
public class SettingsManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f245614a;

    public class a extends b<d> {
        @Override // j06.b
        public final d b() {
            IABMockInitConfig r100 = (IABMockInitConfig) ServiceManager.get().getService(IABMockInitConfig.class);
            if (r100 == null) goto L8;
            r100.getSettingsValueProvider();
            return null;
        L8:
            return null;
        }

        public a() {
        }
    }

    public d getSettingsValueProvider() {
        return this.f245614a.a();
    }

    public SettingsManager() {
        this.f245614a = new a();
        new ArrayList();
    }
}
