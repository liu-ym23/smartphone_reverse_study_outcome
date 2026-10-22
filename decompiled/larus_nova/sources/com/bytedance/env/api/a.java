package com.bytedance.env.api;

import android.app.Activity;
import android.content.Context;
import java.util.Iterator;
import java.util.Map;
import kotlin.NotImplementedError;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements EnvManagerApi {
    public a() {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void addOnEnvConfigChangeListener(e r100) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void init(Context r100) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void initEnvConfig(b r100) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void initGeckoConfig(d r100) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final boolean isFloatingWindowVisible() {
        return true;
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void reboot() {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void removeOnEnvConfigChangeListener(e r100) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void setAutoRebootEnable(boolean r100) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void setEnvConfig(b r100) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void setEnvWindowEnable(boolean r100) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void setFloatingWindowRemovable(boolean r100) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void setFloatingWindowVisible(boolean r100) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void setGeckoConfig(d r100) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final b getEnvConfig() {
        return new b(null, null, 15);
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final d getGeckoConfig() {
        return new d(0);
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final String getEnvLane() {
        return getEnvConfig().b();
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final int getEnvType() {
        EnvType r100 = getEnvConfig().a();
        Iterator<Map.Entry<Integer, EnvType>> r101 = c.f243175a.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Map.Entry<Integer, EnvType> r102 = r101.next();
        int r103 = r102.getKey().intValue();
        if (r102.getValue() != r100) goto L4;
        return r103;
    L8:
        return 0;
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void openDialog(Activity r100) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public final void setEnvConfig(int r100, String r101) {
        EnvType r102 = c.f243175a.get(Integer.valueOf(r100));
        if (r102 == null) goto L6;
        new b(r102, r101, 12);
        return;
    }
}
