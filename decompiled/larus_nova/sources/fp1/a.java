package fp1;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.PanelButtonStatusSource;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f478227a = 0;

    static {
    }

    public static h a(Object r100) {
        if ((r100 instanceof mk1.a) == false) goto L17;
        mk1.a r101 = (mk1.a) r100;
        int r102 = r101.f514293a;
        if (r102 != 3) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L13;
        IRoomAuthStatusStyle r104 = r101.f514295c;
        if (r104 == null) goto L13;
        String r105 = r104.getContent();
        if (r105 == null) goto L13;
    L15:
        return new h(r102, PanelButtonStatusSource.ROOM_AUTH, r105);
    L13:
        r105 = "";
        goto L15
    L7:
        r103 = false;
        goto L8
    L17:
        if ((r100 instanceof h) == true) goto L19;
        return null;
    L19:
        return (h) r100;
    }
}
