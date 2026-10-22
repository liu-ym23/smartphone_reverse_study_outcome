package com.larus.community.api.spi;

import android.content.Context;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.community.impl.detail.CreationDetailActivity;
import com.larus.community.impl.detail.CreationDetailFragment;
import com.larus.platform.api.creation.UserCreation;
import com.ss.android.lark.utils.statistics.PerfLog;
import e29.a;
import e29.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001c\u0010\u0010\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J2\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\fH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010$\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0015H\u0016J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J$\u0010)\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0012H\u0016JH\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010*\u001a\u0004\u0018\u00010\u00122\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030.H\u0016J\u0010\u00100\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0001H\u0016J\u0018\u00101\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u0007H\u0016J\u0010\u00103\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u00104\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u0007H\u0016J!\u00106\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\b\u00105\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u00107¨\u00068"}, d2 = {"Lcom/larus/community/api/spi/ICommunityHostBehaviorProvider;", "", "onCreationPublishSuccess", "", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "handleCreationPublishLanding", "", "currentActivity", "Landroid/app/Activity;", "getPendingPublishedCreation", "arguments", "Landroid/os/Bundle;", "showPendingPublishedCreationNotice", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "consumePendingPublishedCreation", "creationId", "", "openCreationDetailFromFeed", "creationFeedType", "", "detailArguments", "sourceProfileUserId", "openCreationDetailFromRoute", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "openChatBelowCommunityHostIfNeeded", "isChatDoublePage", "params", "getCommunityHostUiPolicy", "Lcom/larus/community/api/spi/CommunityHostUiPolicy;", "getCommunityCreatePageExtra", "shouldShowCreationFeedDebugLabel", "getCreationDetailChromePolicy", "Lcom/larus/community/api/spi/CommunityDetailChromePolicy;", "getCreationDetailBottomPadding", "rootView", "Landroid/view/View;", "nativeNavigationHeight", "handleCreationDetailExit", "handleCreationDetailAuthorClick", "currentUserId", "updateCreationDetailOwnerMenu", "owner", "onSetPrivate", "Lkotlin/Function0;", "onDelete", "clearCreationDetailOwnerMenu", "onCreationDetailFullscreenChanged", "isFullscreen", "shouldShowCreationDetailBottomShareAction", "getCreationDetailOpenNewChatPageOnSend", "defaultValue", "getCreationDetailDoSameLandingType", "(Landroidx/fragment/app/Fragment;Ljava/lang/Integer;)Ljava/lang/Integer;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICommunityHostBehaviorProvider {
    Bundle a(Fragment r100);

    void b(Fragment r100, boolean r101);

    Integer c(Fragment r100);

    e d(Fragment r100);

    boolean e(Fragment r100, UserCreation r101, String r102);

    boolean f(Fragment r100);

    boolean g(Fragment r100);

    boolean h(Fragment r100);

    void i(Fragment r100, UserCreation r101);

    boolean j(Bundle r100, String r101);

    void k(FragmentActivity r100, UserCreation r101);

    boolean l(Fragment r100);

    void m(Object r100, Fragment r101, UserCreation r102, String r103, Function0<Unit> r104, Function0<Unit> r105);

    void n(UserCreation r100);

    UserCreation o(Bundle r100);

    a p(Fragment r100);

    boolean q(Fragment r100, UserCreation r101, int r102, Bundle r103, String r104);

    boolean r(Context r100, Bundle r101);

    void s(Object r100);

    boolean t(CreationDetailActivity r100, boolean r101, Bundle r102);

    int u(CreationDetailFragment r100, ConstraintLayout r101, int r102);
}
