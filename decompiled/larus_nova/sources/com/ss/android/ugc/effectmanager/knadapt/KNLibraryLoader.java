package com.ss.android.ugc.effectmanager.knadapt;

import com.ss.android.ugc.effectmanager.DownloadableModelSupportLibraryLoader;
import com.ss.ugc.effectplatform.algorithm.f;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/effectmanager/knadapt/KNLibraryLoader;", "Lcom/ss/ugc/effectplatform/algorithm/f;", "", "soName", "", "loadLibrary", "Lcom/ss/android/ugc/effectmanager/DownloadableModelSupportLibraryLoader;", "oldLibraryLoader", "Lcom/ss/android/ugc/effectmanager/DownloadableModelSupportLibraryLoader;", "<init>", "(Lcom/ss/android/ugc/effectmanager/DownloadableModelSupportLibraryLoader;)V", "effectmanager_release"}, k = 1, mv = {1, 4, 0})
public final class KNLibraryLoader implements f {
    private final DownloadableModelSupportLibraryLoader oldLibraryLoader;

    public KNLibraryLoader(DownloadableModelSupportLibraryLoader r100) {
        this.oldLibraryLoader = r100;
    }

    @Override // com.ss.ugc.effectplatform.algorithm.f
    public void loadLibrary(String r100) {
        this.oldLibraryLoader.loadLibrary(r100);
    }
}
