package fia;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.trace.ObricActionBarTrackType;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f477427a = 0;

    static {
    }

    public static void a(String r100) {
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L12;
        r100 = "other";
    L12:
        r101.put("enter_method", r100);     // Catch: JSONException -> L8
    L10:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("obric_enter_full_screen");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L8:
        e = move-exception;
        FLogger.f375446a.i("WindowTrackHelper", "mobEnterFullScreen error: " + e);
        goto L10
    }

    public static void b(String r100) {
        JSONObject r101 = new JSONObject();
    L19:
        e = move-exception;
        FLogger.f375446a.i("WindowTrackHelper", "mobSwipeUp error: " + e);
    L21:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("obric_swipeup_panel");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L4:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L6;
        String r104 = "lock_screen";
    L7:
        r101.put(ObricActionBarTrackType.KEY_SHOW_POSITION, r104);     // Catch: JSONException -> L19
        ObricFloatChatPageData.Companion.getClass();     // Catch: JSONException -> L19
        if (Intrinsics.areEqual(r100, ObricFloatChatPageData.access$getCHAT_WINDOW_SIMPLE_NAME$cp()) == false) goto L11;
        String r105 = "global_small_window";
    L17:
        r101.put("obric_window_mode", r105);     // Catch: JSONException -> L19
        goto L21
    L11:
        if (Intrinsics.areEqual(r100, ObricFloatChatPageData.access$getHALF_WINDOW_SIMPLE_NAME$cp()) == false) goto L14;
        r105 = "global_quad_screen";
        goto L17
    L14:
        if (Intrinsics.areEqual(r100, ObricFloatChatPageData.access$getFULL_SCREEN_SIMPLE_NAME$cp()) == false) goto L16;
        r105 = "full_screen";
        goto L17
    L16:
        r105 = "other";
        goto L17
    L6:
        r104 = "unlock_screen";
        goto L7
    }
}
