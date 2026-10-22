package ej7;

import android.app.Activity;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.ug.sdk.luckycat.api.depend.l;
import com.bytedance.ug.sdk.luckycat.impl.bigredpacket.model.RedPacketModel;
import com.bytedance.ug.sdk.luckycat.impl.manager.c;
import com.bytedance.ug.sdk.luckycat.impl.manager.i;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.bytedance.ug.sdk.luckycat.impl.model.d;
import com.bytedance.ug.sdk.luckycat.impl.model.e;
import com.bytedance.ug.sdk.luckycat.impl.utils.u;
import com.bytedance.ug.sdk.luckycat.utils.j;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RedPacketModel f472881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f472882b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f472883a = null;

        static {
            f472883a = new b();
        }
    }

    @Override // com.bytedance.ug.sdk.luckycat.utils.j.a
    public final void handleMsg(Message r100) {
    }

    public b() {
        if (Looper.myLooper() != null) goto L5;
        Looper r100 = Looper.getMainLooper();
    L6:
        new j(r100, this);
        i.a.f271322a.getClass();
        this.f472882b = u.a().d("key_had_try_show_big_red_packet", Boolean.FALSE);
        String r101 = u.a().c("key_big_red_packet_data", "");
        if (TextUtils.isEmpty(r101) == true) goto L12;
        RedPacketModel r102 = RedPacketModel.extract(r101);
        if (r102 == null) goto L13;
        this.f472881a = r102;
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r100 = Looper.myLooper();
        goto L6
    }

    public final void a(Activity r100, String r101) {
        e.b(0);
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f472881a.isPop() == true) goto L9;
        e.b(-1);
        d.f(r101, "server_not_pop");
        return;
    L9:
        m r102 = m.a.f271349a;
        if (r102.r() == false) goto L13;
        e.b(-2);
        d.f(r101, "is_login");
        return;
    L13:
        this.f472881a.setFrom(r101);
        l r103 = r102.f271339g;
        if (r103 == null) goto L16;
        r103.d();
    L16:
        l r104 = c.b();
        if (r104 == null) goto L19;
        r104.d();
    L19:
        e.b(-3);
        d.f(r101, "ui_error");
    }
}
