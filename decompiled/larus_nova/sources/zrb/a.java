package zrb;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends iua.a<Boolean> {

    /* JADX INFO: renamed from: zrb.a$a, reason: collision with other inner class name */
    public static final class C8489a {
    }

    static {
    }

    @Override // iua.a
    public final boolean isSticky() {
        return true;
    }

    @Override // iua.a
    public final iua.b getLarkExperimentInfo() {
        return new iua.b("perf_enter_chat_optimize", "enter chat optimize experiment experiment A/B test");
    }

    public a() {
    }

    @Override // iua.a
    public final Boolean getDefault() {
        return Boolean.TRUE;
    }
}
