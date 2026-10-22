package nha;

import android.app.Activity;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activity_stack.IObricActivityStackService;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.WindowLayoutInfo;
import com.obric.assistant.interaction.api.window.IChatWindowActivity;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class g implements cy7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f519192a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f519193b = null;

    public static final class a {
    }

    public g() {
    }

    static {
        f519192a = SetsKt.setOf(new String[]{"long_press_message", "chat_action_bar_click", "chat_action_bar_show", "click_camera", "click_upload_entrance", "click_upload_file_entrance", "click_call", "obric_assistant_launch", ObricActionBarTrackType.EVENT_SEND_MESSAGE_STATUS, "send_message"});
        f519193b = SetsKt.setOf(new String[]{"send_message", ObricActionBarTrackType.EVENT_SEND_MESSAGE_STATUS});
    }

    @Override // cy7.b
    public final void intercept(String r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r110, "name");
        if (r111 != null) goto L5;
        return;
    L5:
        boolean r100 = f519193b.contains(r110);
        boolean r101 = false;
        if (f519192a.contains(r110) == true) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r100 == true) goto L14;
        if (r102 == true) goto L14;
        return;
    L14:
        IAssistantChatWindow r103 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r103 != null) goto L17;
    L19:
        boolean r104 = false;
    L20:
        Activity r105 = null;
        if (r102 == false) goto L33;
        IObricActivityStackService r106 = (IObricActivityStackService) ServiceManager.get().getService(IObricActivityStackService.class);
        if (r106 == null) goto L33;
        List<Activity> r107 = r106.b();
        if (r107 == null) goto L33;
        ListIterator<Activity> r108 = r107.listIterator(r107.size());
    L28:
        if (r108.hasPrevious() == false) goto L32;
        Activity r109 = r108.previous();
        if ((!(r109 instanceof lba.a)) == false) goto L28;
        r105 = r109;
    L32:
        r105 = r105;
    L33:
        if (r104 == false) goto L35;
    L38:
        boolean r112 = true;
    L39:
        if (r112 == false) goto L49;
        if (r100 == false) goto L49;
        if (r103 == null) goto L47;
        WindowLayoutInfo r113 = r103.getWindowLayoutInfo();
        if (r113 == null) goto L47;
        if (r113.isLandscapeWindowLayout() != true) goto L47;
        r101 = true;
    L47:
        if (r101 == false) goto L49;
        r111.put("obric_screen_orientation", "landscape");
    L49:
        if (r102 == false) goto L59;
        FLogger.f375446a.i("WindowParamInterceptor", r110 + " isWindow: " + r112 + ", lastActivity = " + r105);
        if (r112 == false) goto L53;
        String r114 = LiveEndPageData.TAG_WINDOW;
    L54:
        r111.put("obric_panel_type", r114);
        return;
    L53:
        r114 = "activity";
        goto L54
    L59:
        return;
    L35:
        if ((r105 instanceof IChatWindowActivity) == true) goto L38;
        r112 = false;
        goto L39
    L17:
        if (r103.isShowing() != true) goto L19;
        r104 = true;
        goto L20
    L8:
        if (r111.has("obric_panel_type") == true) goto L10;
        r102 = true;
        goto L11
    }
}
