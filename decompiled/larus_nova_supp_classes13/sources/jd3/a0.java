package jd3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a0 extends com.bytedance.android.ec.core.event.a {
    public String a;
    public String b;
    public String c;
    public String d;
    public boolean e;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        String r0 = String.valueOf(0);
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r1 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("error_code", r0, r1);
        appendParam("error_message", this.a, r1);
        appendParam("play_url", this.b, r1);
        appendParam("play_backup_url", this.c, r1);
        appendParam("network_status", this.d, r1);
        appendParam("is_all_url_fail", String.valueOf(this.e), r1);
    }

    public a0() {
        super("iesec_video_play_fail");
    }
}
