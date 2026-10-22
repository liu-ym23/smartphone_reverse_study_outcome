package mb9;

import android.os.Bundle;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f512793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<Integer> f512794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f512795c;

    /* JADX INFO: renamed from: mb9.a$a, reason: collision with other inner class name */
    public static final class C6794a {
    }

    static {
    }

    public static String a(int r100) {
        if (r100 != PageType.Chat.getType()) goto L6;
        return "chat";
    L6:
        if (r100 != PageType.VIDEO.getType()) goto L9;
        return "video_tab";
    L9:
        if (r100 != PageType.AWEME_FEED.getType()) goto L12;
        return "feed";
    L12:
        if (r100 != PageType.AI_GENERATE.getType()) goto L14;
        return "create_feed_top_tab";
    L14:
        FLogger.f375446a.e("ChatMultiTabFactory", "illegal page type: " + r100);
        return "";
    }

    public a(Bundle r100, ArrayList<Integer> r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "tabs");
        this.f512793a = r100;
        this.f512794b = r101;
        this.f512795c = r102;
    }
}
