package com.larus.platform.api;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public interface g0 {

    /* JADX INFO: loaded from: classes31.dex */
    public static final class a {
        public static /* synthetic */ void a(g0 r100, String r101, int r102, int r103) {
            if ((r103 & 2) == 0) goto L5;
            boolean r104 = true;
        L7:
            if ((r103 & 4) == 0) goto L9;
            r102 = 2;
        L9:
            r100.Fa(r101, r104, r102, null);
            return;
        L5:
            r104 = false;
            goto L7
        }

        public static /* synthetic */ void b(g0 r100, String r101, boolean r102, int r103) {
            if ((r103 & 4) == 0) goto L5;
            r102 = true;
        L5:
            r100.Ia(r101, null, r102);
        }
    }

    boolean Da();

    void E6();

    boolean Ea();

    void Fa(String r100, boolean r101, int r102, View.OnClickListener r103);

    void Ia(String r100, j r101, boolean r102);

    boolean Ja();

    void Na(Integer r100, CharSequence r101);

    void Qa();

    void Sa(String r100, String r101, boolean r102);

    void Ua();

    void Wa();

    boolean getAudioBtnEnabled();

    View getBackIcon();

    lq9.q getEarphoneState();

    boolean getHasAddBot();

    View getMoreView();

    View getMultitaskManagementIcon();

    View getRedDot();

    View getTitle();

    View getTitleText();

    View getTitleView();

    boolean getTtsBanned();

    boolean getTtsChecked();

    boolean getTtsContinuousTalkChecked();

    boolean getTtsContinuousTalkEnabled();

    View getTtsView();

    boolean i();

    void refresh();

    void setAudioBtnEnabled(boolean r100);

    void setBackBtnEnabled(boolean r100);

    void setBackIconRes(int r100);

    void setBackIconVisible(boolean r100);

    void setCreateNewCvsClickListener(View.OnClickListener r100);

    void setDotEnable(boolean r100);

    void setEarphoneState(lq9.q r100);

    void setHasAddBot(boolean r100);

    void setHasMore(boolean r100);

    void setImmerse(boolean r100);

    void setIsLocalSubConvChange(boolean r100);

    void setMainBot(boolean r100);

    void setMoreBtnEnabled(boolean r100);

    void setOnAddBotClickListener(View.OnClickListener r100);

    void setOnBackClickListener(View.OnClickListener r100);

    void setOnChatHistoryCheckedListener(View.OnClickListener r100);

    void setOnMainClickListener(View.OnClickListener r100);

    void setOnMoreClickListener(View.OnClickListener r100);

    void setOnMultitaskClickListener(View.OnClickListener r100);

    void setOnSearchClickListener(View.OnClickListener r100);

    void setOnSideNavClickListener(View.OnClickListener r100);

    void setOnTtsCheckedListener(View.OnClickListener r100);

    void setOnTtsContinuousTalkCheckedListener(View.OnClickListener r100);

    void setOnTtsContinuousTalkLongClickListener(Function1<? super View, Unit> r100);

    void setOnTtsLongPressAction(Function0<Unit> r100);

    void setRealTimeCallVisible(boolean r100);

    void setRealtimeCallBtnClickListener(View.OnClickListener r100);

    void setRealtimeCallVisibleHookShow(boolean r100);

    void setRedDotBGType(int r100);

    void setRedDotUnreadCount(int r100);

    void setRedDotViewClickListener(View.OnClickListener r100);

    void setRedDotViewVisible(boolean r100);

    void setRedDotVisible(boolean r100);

    void setStatus(String r100);

    void setTitleIcon(boolean r100);

    void setTtsBanned(boolean r100);

    void setTtsChecked(boolean r100);

    void setTtsContinuousTalkChecked(boolean r100);

    void setTtsContinuousTalkEnabled(boolean r100);

    void setTtsContinuousTalkVisible(boolean r100);

    void setTtsGrey(boolean r100);

    void setTtsVisible(boolean r100);

    void va();
}
