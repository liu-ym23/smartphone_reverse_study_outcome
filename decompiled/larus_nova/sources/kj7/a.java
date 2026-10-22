package kj7;

import android.content.Context;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.bytedance.ug.sdk.luckycat.impl.utils.u;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f503714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f503715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f503716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f503717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f503718e;

    /* JADX INFO: renamed from: kj7.a$a, reason: collision with other inner class name */
    public static class C6563a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f503719a = null;

        static {
            f503719a = new a();
        }
    }

    public a() {
        Context r100 = m.a.f271349a.f();
        u r101 = u.b(r100, "polaris_setting");
        u r102 = u.b(r100, "red_packet");
        u r103 = u.b(r100, "invitation_code_sp");
        Boolean r104 = Boolean.FALSE;
        this.f503714a = r101.d("key_redpacket_guide_has_show", r104);
        this.f503715b = r102.c("red_packet_settings", "");
        this.f503716c = r103.d("invitation_code_upload_succeed_flag", r104);
        this.f503717d = r103.c("invitation_code", "");
        r101.e("last_update_profit_remind_config_time");
        this.f503718e = r101.f271527a.getLong("last_update_profit_remind_config_time", 0);
    }
}
