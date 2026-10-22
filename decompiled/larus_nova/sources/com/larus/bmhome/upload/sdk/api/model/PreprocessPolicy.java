package com.larus.bmhome.upload.sdk.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/upload/sdk/api/model/PreprocessPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "Auto", "ForceEnable", "Disabled", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreprocessPolicy extends Enum<PreprocessPolicy> {
    public static final PreprocessPolicy Auto = null;
    public static final PreprocessPolicy Disabled = null;
    public static final PreprocessPolicy ForceEnable = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreprocessPolicy[] f314814a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f314815b = null;

    public static EnumEntries<PreprocessPolicy> getEntries() {
        return f314815b;
    }

    static {
        PreprocessPolicy r100 = new PreprocessPolicy("Auto", 0);
        Auto = r100;
        PreprocessPolicy r101 = new PreprocessPolicy("ForceEnable", 1);
        ForceEnable = r101;
        PreprocessPolicy r102 = new PreprocessPolicy("Disabled", 2);
        Disabled = r102;
        PreprocessPolicy[] r103 = {r100, r101, r102};
        f314814a = r103;
        f314815b = EnumEntriesKt.enumEntries(r103);
    }

    public static PreprocessPolicy[] values() {
        return (PreprocessPolicy[]) f314814a.clone();
    }

    public static PreprocessPolicy valueOf(String r100) {
        return (PreprocessPolicy) a.a(PreprocessPolicy.class, r100);
    }

    public PreprocessPolicy(String r100, int r101) {
        super(r100, r101);
    }
}
