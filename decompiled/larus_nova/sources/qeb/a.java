package qeb;

import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends q5c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f532707a = 0;

    /* JADX INFO: renamed from: qeb.a$a, reason: collision with other inner class name */
    public static final class C7319a {
        @JvmStatic
        public static void a(String r100, UIFeedCard r101) {
            Intrinsics.checkNotNullParameter(r100, "click");
            Intrinsics.checkNotNullParameter(r101, "uiFeedCard");
            JSONObject r102 = new JSONObject();
            r102.put("click", r100);
            r102.put(PickerReporterConstants.KEY.TARGET, "none");
            c.a(r102, r101.getIsDisplayInShortcut());
            Statistics.sendEvent("feed_press_click", r102);
        }
    }

    static {
    }
}
