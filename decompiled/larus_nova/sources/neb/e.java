package neb;

import com.ss.android.lark.feed.app.entity.UIFeedCard;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
public final class e {
    static {
    }

    @JvmStatic
    public static final boolean a(UIFeedCard r100) {
        if (r100 == null) goto L5;
        boolean r101 = r100.getIsFirstTopRank();
    L6:
        if (r101 == true) goto L8;
        return false;
    L8:
        if (com.ss.android.lark.feed.shared.fg.c.a() == false) goto L12;
        return true;
    L12:
        return false;
    L5:
        r101 = false;
        goto L6
    }
}
