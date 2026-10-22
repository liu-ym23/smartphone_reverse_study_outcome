package com.bytedance.assem.arch.reused;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/assem/arch/reused/FireCase;", "", "Default", "HostAttach", "HostDetach", "HostResume", "HostStop", "HostBind", "assem_release"}, k = 1, mv = {1, 4, 0})
public final enum FireCase extends Enum<FireCase> {
    public static final FireCase Default = null;
    public static final FireCase HostAttach = null;
    public static final FireCase HostBind = null;
    public static final FireCase HostDetach = null;
    public static final FireCase HostResume = null;
    public static final FireCase HostStop = null;
    public static final /* synthetic */ FireCase[] a = null;

    static {
        FireCase r1 = new FireCase("Default", 0);
        Default = r1;
        FireCase r2 = new FireCase("HostAttach", 1);
        HostAttach = r2;
        FireCase r3 = new FireCase("HostDetach", 2);
        HostDetach = r3;
        FireCase r4 = new FireCase("HostResume", 3);
        HostResume = r4;
        FireCase r5 = new FireCase("HostStop", 4);
        HostStop = r5;
        FireCase r6 = new FireCase("HostBind", 5);
        HostBind = r6;
        a = new FireCase[]{r1, r2, r3, r4, r5, r6};
    }

    public static FireCase valueOf(String r1) {
        return (FireCase) r27.a.a(FireCase.class, r1);
    }

    public static FireCase[] values() {
        return (FireCase[]) a.clone();
    }

    public FireCase(String r1, int r2) {
        super(r1, r2);
    }
}
