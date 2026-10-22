package jd3;

/* JADX INFO: loaded from: classes13.dex */
public final class a0 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f498260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f498261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f498262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f498263e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = String.valueOf(0);
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("error_code", r100, r101);
        appendParam("error_message", this.f498259a, r101);
        appendParam("play_url", this.f498260b, r101);
        appendParam("play_backup_url", this.f498261c, r101);
        appendParam("network_status", this.f498262d, r101);
        appendParam("is_all_url_fail", String.valueOf(this.f498263e), r101);
    }

    public a0() {
        super("iesec_video_play_fail");
    }
}
