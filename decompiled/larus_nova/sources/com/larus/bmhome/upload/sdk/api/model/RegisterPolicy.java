package com.larus.bmhome.upload.sdk.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/upload/sdk/api/model/RegisterPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "Auto", "ForceEnable", "Disabled", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RegisterPolicy extends Enum<RegisterPolicy> {
    public static final RegisterPolicy Auto = null;
    public static final RegisterPolicy Disabled = null;
    public static final RegisterPolicy ForceEnable = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RegisterPolicy[] f314816a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f314817b = null;

    public static EnumEntries<RegisterPolicy> getEntries() {
        return f314817b;
    }

    static {
        RegisterPolicy r100 = new RegisterPolicy("Auto", 0);
        Auto = r100;
        RegisterPolicy r101 = new RegisterPolicy("ForceEnable", 1);
        ForceEnable = r101;
        RegisterPolicy r102 = new RegisterPolicy("Disabled", 2);
        Disabled = r102;
        RegisterPolicy[] r103 = {r100, r101, r102};
        f314816a = r103;
        f314817b = EnumEntriesKt.enumEntries(r103);
    }

    public static RegisterPolicy[] values() {
        return (RegisterPolicy[]) f314816a.clone();
    }

    public static RegisterPolicy valueOf(String r100) {
        return (RegisterPolicy) a.a(RegisterPolicy.class, r100);
    }

    public RegisterPolicy(String r100, int r101) {
        super(r100, r101);
    }
}
