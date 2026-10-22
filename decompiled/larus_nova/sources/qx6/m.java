package qx6;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f535146a = null;

    static {
        f535146a = CollectionsKt.listOf(new String[]{UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, "homepage_fresh", "homepage_follow", "homepage_familiar"});
    }

    public static boolean a(HashMap r100) {
        if (r100 == null) goto L8;
        String r101 = (String) r100.get("detail_enter_page");
        if (r101 != null) goto L7;
        return false;
    L7:
        return !f535146a.contains(r101);
    L8:
        return false;
    }
}
