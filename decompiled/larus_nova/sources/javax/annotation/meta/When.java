package javax.annotation.meta;

import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum When extends Enum<When> {
    public static final When ALWAYS = null;
    public static final When MAYBE = null;
    public static final When NEVER = null;
    public static final When UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ When[] f497975a = null;

    static {
        When r100 = new When("ALWAYS", 0);
        ALWAYS = r100;
        When r101 = new When("UNKNOWN", 1);
        UNKNOWN = r101;
        When r102 = new When("MAYBE", 2);
        MAYBE = r102;
        When r103 = new When("NEVER", 3);
        NEVER = r103;
        f497975a = new When[]{r100, r101, r102, r103};
    }

    public static When[] values() {
        return (When[]) f497975a.clone();
    }

    public static When valueOf(String r100) {
        return (When) a.a(When.class, r100);
    }

    public When(String r100, int r101) {
        super(r100, r101);
    }
}
