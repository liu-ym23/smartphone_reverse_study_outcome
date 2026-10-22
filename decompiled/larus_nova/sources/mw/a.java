package mw;

import android.content.Context;
import com.bytedance.android.gamecp.host_api.model.introducecard.g;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.google.gson.JsonObject;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
import xr.j;

/* JADX INFO: loaded from: classes44.dex */
public interface a extends j {

    /* JADX INFO: renamed from: mw.a$a, reason: collision with other inner class name */
    public static final class C6861a {
        public static /* synthetic */ void a(a r100, Integer r101, String r110, String r111, String r112, String r113, String r114, String r115, int r116) {
            if ((r116 & 1) == 0) goto L5;
            Integer r102 = -1;
        L6:
            String r103 = null;
            if ((r116 & 2) == 0) goto L9;
            String r104 = null;
        L11:
            if ((r116 & 4) == 0) goto L13;
            String r105 = null;
        L15:
            if ((r116 & 8) != 0) goto L18;
            r103 = r112;
        L18:
            String r106 = "";
            if ((r116 & 16) == 0) goto L21;
            String r107 = "";
        L23:
            if ((r116 & 32) == 0) goto L25;
            String r108 = "";
        L27:
            if ((r116 & 64) != 0) goto L30;
            r106 = r115;
        L30:
            r100.setImageLoadReason(r102, r104, r105, r103, r107, r108, r106);
            return;
        L25:
            r108 = r114;
            goto L27
        L21:
            r107 = r113;
            goto L23
        L13:
            r105 = r111;
            goto L15
        L9:
            r104 = r110;
            goto L11
        L5:
            r102 = r101;
            goto L6
        }
    }

    boolean canAutoIntro(String r100, String r101, String r102);

    void checkIntroduceStatus(String r100, String r101, String r102);

    void excExitRoomActionBySetting(String r100);

    int getAllChannelInstallEnable();

    Pair<Boolean, String> getCachedIconBitmap(String r100, String r101, String r102, Function1<? super CloseableReference<CloseableImage>, Unit> r103);

    g getCardData();

    Map<String, Object> getInjectPreviewData(String r100, String r101, String r102);

    JSONObject getJumpExtra(String r100, String r101, String r102);

    String getJumpGameDetailId();

    Map<String, Object> getPreviewTrackParams(String r100, String r101, String r102);

    com.bytedance.android.gamecp.host_api.model.j getPromoteGame();

    ArrayList<com.bytedance.android.gamecp.host_api.model.j> getSimpleGameInfoList(String r100, String r101, String r102);

    JsonObject getToolbarData(String r100, String r101, String r102);

    boolean hasInvokePreviewAction(String r100, String r101, String r102);

    boolean hasToolbarShow();

    void hideIntroduceCard(JsonObject r100, boolean r101, boolean r102);

    void inDegradeScene(boolean r100);

    boolean isCardFromEnter(String r100, String r101, String r102);

    boolean isGameCPRoom(String r100, String r101, String r102);

    boolean isPreviewMergeInteract();

    void onDetailPageCreate();

    void onDetailPageDestroy();

    void onDialogVisibilityChange(boolean r100);

    void onRoomEnter(Context r100, long r101, String r102, String r103, String r104);

    void onRoomExit(long r100);

    void parseToolbarData(long r100, String r101, String r102, CompositeDisposable r103);

    void reportAiTaskEvent(Map<String, String> r100);

    void reportFullLinkEvent(Map<String, String> r100);

    void reportJsbInvokeEvent(Map<String, String> r100);

    void setAllChannelInstallEnable(int r100);

    void setGameDetailDismissed(boolean r100);

    void setImageLoadReason(Integer r100, String r101, String r102, String r103, String r104, String r105, String r106);

    void showInstallIntroCard(String r100, String r101, boolean r102);

    void showInteractionAndEnterRoom(String r100);

    void showIntroduceCard(JsonObject r100, boolean r101, boolean r102);
}
