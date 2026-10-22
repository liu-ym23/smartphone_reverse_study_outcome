package com.ss.android.ugc.aweme.poi.bean;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"com/ss/android/ugc/aweme/poi/bean/PreloadConfig$Switch", "", "Lcom/ss/android/ugc/aweme/poi/bean/PreloadConfig$Switch;", "OFF", "ONLY_PRE_REQUEST", "ONLY_PRE_LOAD", "RRE_REQUEST_AND_RENDER", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum PreloadConfig$Switch extends Enum<PreloadConfig$Switch> {
    public static final PreloadConfig$Switch OFF = null;
    public static final PreloadConfig$Switch ONLY_PRE_LOAD = null;
    public static final PreloadConfig$Switch ONLY_PRE_REQUEST = null;
    public static final PreloadConfig$Switch RRE_REQUEST_AND_RENDER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreloadConfig$Switch[] f451317a = null;

    public static PreloadConfig$Switch valueOf(String r100) {
        return (PreloadConfig$Switch) a.a(PreloadConfig$Switch.class, r100);
    }

    public static PreloadConfig$Switch[] values() {
        return (PreloadConfig$Switch[]) f451317a.clone();
    }

    static {
        PreloadConfig$Switch r100 = new PreloadConfig$Switch("OFF", 0);
        OFF = r100;
        PreloadConfig$Switch r101 = new PreloadConfig$Switch("ONLY_PRE_REQUEST", 1);
        ONLY_PRE_REQUEST = r101;
        PreloadConfig$Switch r102 = new PreloadConfig$Switch("ONLY_PRE_LOAD", 2);
        ONLY_PRE_LOAD = r102;
        PreloadConfig$Switch r103 = new PreloadConfig$Switch("RRE_REQUEST_AND_RENDER", 3);
        RRE_REQUEST_AND_RENDER = r103;
        f451317a = new PreloadConfig$Switch[]{r100, r101, r102, r103};
    }

    public PreloadConfig$Switch(String r100, int r101) {
        super(r100, r101);
    }
}
