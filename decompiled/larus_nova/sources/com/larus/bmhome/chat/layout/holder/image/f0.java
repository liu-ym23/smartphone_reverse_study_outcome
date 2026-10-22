package com.larus.bmhome.chat.layout.holder.image;

import android.net.Uri;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.Message;
import java.util.HashMap;

/* JADX INFO: loaded from: classes25.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Long> f303825a;

    public static final class a {
    }

    static {
    }

    public f0() {
        this.f303825a = new HashMap();
    }

    public static String a(Message r100, String r101) {
        return r100.getMessageId() + "_" + r101;
    }

    public final void b(Message r100, String r101, boolean r102, Uri r103, boolean r104, String r110, boolean r111, int r112) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r103 != null) goto L6;
        return;
    L6:
        String r105 = a(r100, r101);
        Long r106 = this.f303825a.get(r105);
        by7.a r107 = new by7.a("generate_image_load_success");
        r107.d("image_format", r110);
        r107.d(MusicAppletPage.KEY_MESSAGE_ID, r100.getMessageId());
        r107.d("image_id", r101);
        r107.d("is_from_cache", Integer.valueOf(r102 ? 1 : 0));
        r107.d("conversation_id", r100.getConversationId());
        if (r106 == null) goto L9;
        r106.longValue();
        r107.d("duration", Long.valueOf(System.currentTimeMillis() - r106.longValue()));
    L9:
        r107.d("is_intermediate", Integer.valueOf(r104 ? 1 : 0));
        r107.d("url", r103.toString());
        r107.d("is_scroll_box", Integer.valueOf(r111 ? 1 : 0));
        r107.d("position", Integer.valueOf(r112 + 1));
        r107.b();
    }
}
