package com.ss.android.lark.feed.shared.hitpoint;

import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;
import com.ss.android.lark.integrator.im.feed_shared.dependency.f;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.statistics.Statistics;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s5c.d;
import z5c.p3;
import z5c.r;
import z5c.y3;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f421203a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "feedId");
        ((f) heb.a.f484903a.getFeedDependency()).getClass();     // Catch: Throwable -> L9
        FeedFolderCompat r101 = FeedFolderCompat.INSTANCE;     // Catch: Throwable -> L9
        FeedFolder r102 = r101.getMESSAGE_WITHOUT_DOUBAO();     // Catch: Throwable -> L9
        if (r102.isSameFolderWith(r101.getEXPIRED_FOLD()) == false) goto L6;
        String r103 = "expired_fold";
    L7:
        Statistics.sendEvent("feed_chat_click", new JSONObject().put("feed_id", r100).put("feed_type", r103));     // Catch: Throwable -> L9
        return;
    L6:
        r103 = r102.label().toLowerCase(Locale.ROOT);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Log.e("FeedHitPoint", th.getMessage());
    }

    @JvmStatic
    public static final void b(boolean r100) {
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L13
        if (r100 == false) goto L6;
        String r102 = "open";
    L7:
        JSONObject r103 = r101.put("click", r102);     // Catch: Throwable -> L13
        if (r100 == false) goto L10;
        String r104 = "feed_grouping_edit_view";
    L11:
        Statistics.sendEvent("feed_delayed_popup_click", r103.put(PickerReporterConstants.KEY.TARGET, r104).put("click_type", "click"));     // Catch: Throwable -> L13
        return;
    L10:
        r104 = "feed_main_view";
        goto L11
    L6:
        r102 = "esc";
    L13:
        th = move-exception;
        Log.e("FeedHitPoint", th.getMessage());
    }

    @JvmStatic
    public static final void c(boolean r100) {
        if (r100 == false) goto L4;
        s5c.a r101 = r.X2;
    L5:
        s5c.a r102 = p3.f570282c;
        r101.getClass();
        Statistics.sendEvent("feed_msg_guidance_click", d.b.b(r101, r102).plus(y3.f570424p).toJson());
        return;
    L4:
        r101 = r.f570325h;
        goto L5
    }
}
