package com.ss.android.ugc.effectmanager.knadapt;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/effectmanager/knadapt/UseKNPlatform;", "", "()V", "enableKNPlatform", "", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class UseKNPlatform {
    public static final UseKNPlatform INSTANCE = null;
    public static boolean enableKNPlatform;

    private UseKNPlatform() {
    }

    static {
        INSTANCE = new UseKNPlatform();
        enableKNPlatform = true;
    }
}
