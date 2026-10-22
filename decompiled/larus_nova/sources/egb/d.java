package egb;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: classes36.dex */
public final /* synthetic */ class d {
    public static /* synthetic */ void a(e r100, Context r101, int r102, Message r110, String r111, boolean r112, Fragment r113, int r114) {
        if ((r114 & 16) == 0) goto L5;
        boolean r103 = false;
    L6:
        r100.d(r101, r102, r110, r111, r103, null);
        return;
    L5:
        r103 = r112;
        goto L6
    }
}
