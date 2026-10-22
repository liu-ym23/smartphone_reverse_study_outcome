package com.ss.android.download.api.settings;

import com.ss.android.downloadlib.runtime.impl.AdSDKSettingsProviderImpl;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Reflection;
import o6.a;
import o6.b;
import o6.c;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/ss/android/download/api/settings/TTDownloadSettingsAdapter;", "Lo6/a;", "Lcom/ss/android/download/api/settings/TTDownloadSettingsModel;", "Lo6/c;", "obtainSettingsManager", "", "getSettingsKey", "()Ljava/lang/String;", "settingsKey", "Ljava/lang/Class;", "getSettingsModelClass", "()Ljava/lang/Class;", "settingsModelClass", "<init>", "()V", "download-api_release"}, k = 1, mv = {1, 4, 0})
public final class TTDownloadSettingsAdapter extends a<TTDownloadSettingsModel> {
    public static final TTDownloadSettingsAdapter INSTANCE = null;

    @Override // o6.a
    public String getSettingsKey() {
        return AdSDKSettingsProviderImpl.TTDOWNLOADER_SETTING_KEY;
    }

    static {
        INSTANCE = new TTDownloadSettingsAdapter();
    }

    @Override // o6.a
    public c obtainSettingsManager() {
        Class r100 = JvmClassMappingKt.getJavaClass(Reflection.getOrCreateKotlinClass(b.class));
        t6.b r101 = t6.a.f544652a;
        b r102 = (b) t6.a.C7690a.a(r100, null);
        if (r102 == null) goto L5;
        r102.a();
    L5:
        return null;
    }

    private TTDownloadSettingsAdapter() {
    }

    @Override // o6.a
    public Class<TTDownloadSettingsModel> getSettingsModelClass() {
        return TTDownloadSettingsModel.class;
    }
}
