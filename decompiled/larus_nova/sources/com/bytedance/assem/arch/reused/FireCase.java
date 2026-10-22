package com.bytedance.assem.arch.reused;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/assem/arch/reused/FireCase;", "", "Default", "HostAttach", "HostDetach", "HostResume", "HostStop", "HostBind", "assem_release"}, k = 1, mv = {1, 4, 0})
public final enum FireCase extends Enum<FireCase> {
    public static final FireCase Default = null;
    public static final FireCase HostAttach = null;
    public static final FireCase HostBind = null;
    public static final FireCase HostDetach = null;
    public static final FireCase HostResume = null;
    public static final FireCase HostStop = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FireCase[] f192945a = null;

    static {
        FireCase r100 = new FireCase("Default", 0);
        Default = r100;
        FireCase r101 = new FireCase("HostAttach", 1);
        HostAttach = r101;
        FireCase r102 = new FireCase("HostDetach", 2);
        HostDetach = r102;
        FireCase r103 = new FireCase("HostResume", 3);
        HostResume = r103;
        FireCase r104 = new FireCase("HostStop", 4);
        HostStop = r104;
        FireCase r105 = new FireCase("HostBind", 5);
        HostBind = r105;
        f192945a = new FireCase[]{r100, r101, r102, r103, r104, r105};
    }

    public static FireCase valueOf(String r100) {
        return (FireCase) r27.a.a(FireCase.class, r100);
    }

    public static FireCase[] values() {
        return (FireCase[]) f192945a.clone();
    }

    public FireCase(String r100, int r101) {
        super(r100, r101);
    }
}
