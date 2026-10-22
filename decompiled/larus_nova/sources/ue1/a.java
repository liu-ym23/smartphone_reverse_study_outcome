package ue1;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.record.u;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f549790a = 0;

    public static String b() {
        return u.c(s1.getContext(), "record" + System.currentTimeMillis() + ".mp4");
    }

    static {
    }

    public static void a(ArrayList r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() <= 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.record.b r102 = new com.bytedance.android.livesdk.chatroom.record.b();
        String[][] r103 = new String[1][];
        Object[] r104 = r100.toArray(new String[0]);
        if (r104 == null) goto L15;
        r103[0] = (String[]) r104;
        r102.execute1(r103);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L17:
        return;
    L6:
        r101 = false;
        goto L7
    }
}
