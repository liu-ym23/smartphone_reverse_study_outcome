package com.obric.assistant.actionbar.service;

import com.larus.bmhome.actionbar.model.z0;
import com.obric.assistant.spi.actionbar.IObricActionBarTrackService;
import com.obric.trace.ObricActionBarTrackType;
import java.util.List;
import kotlin.Metadata;
import qha.e;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&¢\u0006\u0002\u0010\fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0005H&JK\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\u0017J \u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H&J \u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u001c\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bH&J(\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H&J \u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\bH&J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\bH&J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020%H&¨\u0006)"}, d2 = {"Lcom/obric/assistant/actionbar/service/IObricActionBarTrackServiceExt;", "Lcom/obric/assistant/spi/actionbar/IObricActionBarTrackService;", "mobChatActionBarShow", "", "actionBarList", "", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "position", "", "actionBarKeyList", "", "", "([Ljava/lang/String;)V", "traceType", "Lcom/obric/trace/ObricActionBarTrackType;", "Lcom/obric/assistant/view/actionbar/custom/ObricBaseSegment;", "mobChatActionBarClick", "clickV2Option", "customActionBarItem", "botId", "conversationId", "", "clickPosition", "(Ljava/lang/String;Lcom/obric/trace/ObricActionBarTrackType;Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Ljava/lang/String;JLjava/lang/Integer;)V", "mobObricActionBarBoardShow", "mobObricActionPanelShow", "currentActionBar", "mobObricActionBarBoardClick", "mobObricActionBarBoardLeave", "leaveMethod", "mobObricActionBarLv3BoardShow", "mobObricActionBarLv3BoardClick", "clickV3Option", "mapToObricActionBarTrackType", "itemId", "mapToActionBarV2Option", "isAssistantActionBar", "", "actionBarKey", "setIsClickModeChangeButton", "isClickModeChangeButton", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricActionBarTrackServiceExt extends IObricActionBarTrackService {

    public static final class a {
        public static /* synthetic */ void a(ObricActionBarTrackServiceExtDelegate r110, String r111, ObricActionBarTrackType r112, z0 r113, String r114, long r115, Integer r116, int r117) {
            if ((r117 & 1) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r117 & 2) == 0) goto L9;
            ObricActionBarTrackType r101 = null;
        L11:
            if ((r117 & 32) == 0) goto L13;
            Integer r102 = null;
        L14:
            r110.f(r100, r101, r113, r114, r115, r102);
            return;
        L13:
            r102 = r116;
            goto L14
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }
    }

    boolean a(String r100);

    void b(List<? extends e> r100);

    String c(int r100);

    void d(String r100);

    void e();

    void f(String r100, ObricActionBarTrackType r101, z0 r102, String r103, long r104, Integer r105);

    void g(z0 r100, String r101, long r102);

    void i(String r100, long r101);

    void j(List<z0> r100, int r101);

    void l(String r100, long r101);

    void m(String[] r100);

    void o(ObricActionBarTrackType r100);

    void q(String r100, z0 r101, String r102, long r103);

    void s(String r100, String r101, long r102);

    ObricActionBarTrackType u(int r100);
}
