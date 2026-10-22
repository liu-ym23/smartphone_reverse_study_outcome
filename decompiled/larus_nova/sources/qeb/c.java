package qeb;

import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f532709a = null;

        static {
            int[] r100 = new int[FeedActionType.values().length];
            r100[FeedActionType.FLAG_MARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[FeedActionType.TOPPING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[FeedActionType.MARK_UNREAD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f532709a = r100;
        }
    }

    public static final void a(JSONObject r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == false) goto L5;
        String r102 = "feed_top";
    L6:
        r100.put("action_location", r102);
        return;
    L5:
        r102 = "feed_item";
        goto L6
    }
}
