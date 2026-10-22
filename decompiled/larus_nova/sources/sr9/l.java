package sr9;

import android.content.Context;
import android.view.View;
import com.larus.platform.api.g0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class l implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f543248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f543249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f543250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public lq9.q f543251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f543252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f543253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f543254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f543255h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f543256i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f543257j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f543258k;

    @Override // com.larus.platform.api.g0
    public final void E6() {
    }

    @Override // com.larus.platform.api.g0
    public final boolean Ea() {
        return false;
    }

    @Override // com.larus.platform.api.g0
    public final void Fa(String r100, boolean r101, int r102, View.OnClickListener r103) {
    }

    @Override // com.larus.platform.api.g0
    public final void Ia(String r100, com.larus.platform.api.j r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "title");
    }

    @Override // com.larus.platform.api.g0
    public final void Na(Integer r100, CharSequence r101) {
    }

    @Override // com.larus.platform.api.g0
    public final void Qa() {
    }

    @Override // com.larus.platform.api.g0
    public final void Sa(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "iconUri");
        Intrinsics.checkNotNullParameter(r101, "iconUrl");
    }

    @Override // com.larus.platform.api.g0
    public final void Ua() {
    }

    @Override // com.larus.platform.api.g0
    public final void Wa() {
    }

    @Override // com.larus.platform.api.g0
    public final View getBackIcon() {
        return null;
    }

    @Override // com.larus.platform.api.g0
    public final View getMoreView() {
        return null;
    }

    @Override // com.larus.platform.api.g0
    public final View getMultitaskManagementIcon() {
        return null;
    }

    @Override // com.larus.platform.api.g0
    public final View getRedDot() {
        return null;
    }

    @Override // com.larus.platform.api.g0
    public final View getTitleText() {
        return null;
    }

    @Override // com.larus.platform.api.g0
    public final View getTtsView() {
        return null;
    }

    @Override // com.larus.platform.api.g0
    public final void refresh() {
    }

    @Override // com.larus.platform.api.g0
    public final void setBackBtnEnabled(boolean r100) {
    }

    @Override // com.larus.platform.api.g0
    public final void setBackIconRes(int r100) {
    }

    @Override // com.larus.platform.api.g0
    public final void setBackIconVisible(boolean r100) {
    }

    @Override // com.larus.platform.api.g0
    public final void setHasMore(boolean r100) {
    }

    @Override // com.larus.platform.api.g0
    public final void setImmerse(boolean r100) {
    }

    @Override // com.larus.platform.api.g0
    public final void setIsLocalSubConvChange(boolean r100) {
    }

    @Override // com.larus.platform.api.g0
    public final void setMoreBtnEnabled(boolean r100) {
    }

    @Override // com.larus.platform.api.g0
    public final void setOnAddBotClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.larus.platform.api.g0
    public final void setOnBackClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.larus.platform.api.g0
    public final void setOnMainClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.larus.platform.api.g0
    public final void setOnMoreClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.larus.platform.api.g0
    public final void setOnTtsCheckedListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.larus.platform.api.g0
    public final void setOnTtsContinuousTalkCheckedListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.larus.platform.api.g0
    public final void setOnTtsContinuousTalkLongClickListener(Function1<? super View, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "longClickAction");
    }

    @Override // com.larus.platform.api.g0
    public final void setRealTimeCallVisible(boolean r100) {
    }

    @Override // com.larus.platform.api.g0
    public final void setRealtimeCallVisibleHookShow(boolean r100) {
    }

    @Override // com.larus.platform.api.g0
    public final void setRedDotBGType(int r100) {
    }

    @Override // com.larus.platform.api.g0
    public final void setRedDotUnreadCount(int r100) {
    }

    @Override // com.larus.platform.api.g0
    public final void setRedDotViewClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.larus.platform.api.g0
    public final void setRedDotViewVisible(boolean r100) {
    }

    @Override // com.larus.platform.api.g0
    public final void setStatus(String r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
    }

    @Override // com.larus.platform.api.g0
    public final void setTitleIcon(boolean r100) {
    }

    @Override // com.larus.platform.api.g0
    public final void setTtsContinuousTalkVisible(boolean r100) {
    }

    @Override // com.larus.platform.api.g0
    public final void setTtsGrey(boolean r100) {
    }

    @Override // com.larus.platform.api.g0
    public final void setTtsVisible(boolean r100) {
    }

    @Override // com.larus.platform.api.g0
    public final void va() {
    }

    @Override // com.larus.platform.api.g0
    public final boolean Da() {
        return this.f543254g;
    }

    @Override // com.larus.platform.api.g0
    public final boolean Ja() {
        return this.f543255h;
    }

    @Override // com.larus.platform.api.g0
    public final boolean getAudioBtnEnabled() {
        return this.f543253f;
    }

    @Override // com.larus.platform.api.g0
    public final lq9.q getEarphoneState() {
        return this.f543251d;
    }

    @Override // com.larus.platform.api.g0
    public final boolean getHasAddBot() {
        return this.f543249b;
    }

    @Override // com.larus.platform.api.g0
    public final View getTitle() {
        return this.f543248a;
    }

    @Override // com.larus.platform.api.g0
    public final View getTitleView() {
        return this.f543248a;
    }

    @Override // com.larus.platform.api.g0
    public final boolean getTtsBanned() {
        return this.f543252e;
    }

    @Override // com.larus.platform.api.g0
    public final boolean getTtsChecked() {
        return this.f543250c;
    }

    @Override // com.larus.platform.api.g0
    public final boolean getTtsContinuousTalkChecked() {
        return this.f543258k;
    }

    @Override // com.larus.platform.api.g0
    public final boolean getTtsContinuousTalkEnabled() {
        return this.f543257j;
    }

    @Override // com.larus.platform.api.g0
    public final boolean i() {
        return this.f543256i;
    }

    public l(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f543248a = new View(r100);
        this.f543251d = new lq9.q(false, false);
        this.f543252e = true;
    }

    @Override // com.larus.platform.api.g0
    public final void setAudioBtnEnabled(boolean r100) {
        this.f543253f = r100;
    }

    @Override // com.larus.platform.api.g0
    public final void setCreateNewCvsClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.larus.platform.api.g0
    public final void setDotEnable(boolean r100) {
        this.f543255h = r100;
    }

    @Override // com.larus.platform.api.g0
    public final void setEarphoneState(lq9.q r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f543251d = r100;
    }

    @Override // com.larus.platform.api.g0
    public final void setHasAddBot(boolean r100) {
        this.f543249b = r100;
    }

    @Override // com.larus.platform.api.g0
    public final void setMainBot(boolean r100) {
        this.f543254g = r100;
    }

    @Override // com.larus.platform.api.g0
    public final void setOnChatHistoryCheckedListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.larus.platform.api.g0
    public final void setOnMultitaskClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.larus.platform.api.g0
    public final void setOnSearchClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.larus.platform.api.g0
    public final void setOnSideNavClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.larus.platform.api.g0
    public final void setOnTtsLongPressAction(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "longClickAction");
    }

    @Override // com.larus.platform.api.g0
    public final void setRealtimeCallBtnClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.larus.platform.api.g0
    public final void setRedDotVisible(boolean r100) {
        this.f543256i = r100;
    }

    @Override // com.larus.platform.api.g0
    public final void setTtsBanned(boolean r100) {
        this.f543252e = r100;
    }

    @Override // com.larus.platform.api.g0
    public final void setTtsChecked(boolean r100) {
        this.f543250c = r100;
    }

    @Override // com.larus.platform.api.g0
    public final void setTtsContinuousTalkChecked(boolean r100) {
        this.f543258k = r100;
    }

    @Override // com.larus.platform.api.g0
    public final void setTtsContinuousTalkEnabled(boolean r100) {
        this.f543257j = r100;
    }
}
