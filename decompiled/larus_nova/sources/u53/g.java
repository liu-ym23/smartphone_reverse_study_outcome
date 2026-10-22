package u53;

/* JADX INFO: loaded from: classes12.dex */
public final class g extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f548828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f548829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f548830c;

    public static final class a {
    }

    static {
    }

    public g() {
        super("comment_pic_sub_to_final_duration");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = String.valueOf(this.f548828a);
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("type", r100, r101);
        appendParam("duration", String.valueOf(this.f548829b), r101);
        appendParam("is_first_pic", String.valueOf(this.f548830c), r101);
    }

    public final int getType() {
        return this.f548828a;
    }
}
