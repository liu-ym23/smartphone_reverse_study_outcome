package xr;

import android.content.Context;
import android.view.View;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes44.dex */
public interface j extends o {
    void fillGameCpTrackAttrMap(Map<String, String> r100, String r101, boolean r102);

    String getCurrentGameId();

    Object getGameCpRoomControllerProvider();

    Pair<Boolean, String> getIntroduceCardEnterData(String r100, Function2<? super zr.b, ? super Boolean, Unit> r101);

    List<String> getPendingIntroduceCardMessage();

    Object getPreloadToolbarHandler(String r100, String r101, String r102);

    View getTrackRootView(String r100);

    boolean isCardVisible();

    void isCleanModeChange(boolean r100);

    Boolean isIntroducingCardManually(String r100, String r101, String r102);

    boolean isPOI();

    void onAnchorClickToolbarIcon();

    void onAudienceClickMoreIcon(Context r100, String r101, boolean r102);

    void onCardDataRaw(String r100, long r101);

    void onMoveToFold(boolean r100, int r101);

    void onOrientationChange(int r100);

    void onReplaceResult(boolean r100, int r101);

    void preloadImage(String r100);

    void roomEnterGameCpForPreload(String r100, String r101, String r102, String r103, String r104);

    void sendResultGameStatus(Context r100, boolean r101, String r102, boolean r103);

    void setParentView(View r100, Boolean r101);
}
