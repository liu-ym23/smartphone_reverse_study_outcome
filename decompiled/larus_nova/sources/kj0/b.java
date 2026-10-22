package kj0;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r100, int r101, String r102, int r103) {
            if ((r103 & 2) == 0) goto L5;
            r102 = "";
        L5:
            r100.setSelfDisciplineStatus(r101, r102, null);
        }
    }

    void addExtraLog(Map<String, String> r100);

    boolean canShowContributionPanelItem();

    void fastStartSelfDiscipline();

    c0.b getToolbarBehavior();

    boolean isSelfDisciplineOn();

    void logUpdateRoomIntro(String r100);

    void setSelfDisciplineStatus(int r100, String r101, Long r102);

    void showManagePanel(String r100);

    boolean supportSelfDiscipline();
}
