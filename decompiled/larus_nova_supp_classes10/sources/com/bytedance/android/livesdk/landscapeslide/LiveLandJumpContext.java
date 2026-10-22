package com.bytedance.android.livesdk.landscapeslide;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.d1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.live.datacontext.DataContext;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/landscapeslide/LiveLandJumpContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lds0/d;", "session", "", "isGameLive", "checkIsNotSupportLandFromDrawer", "mHasCheck", "Z", "", "mRoomId", "J", "Lcom/bytedance/android/livesdk/landscapeslide/d;", "mInitLandscapeFeedFunc", "Lcom/bytedance/android/livesdk/landscapeslide/d;", "Lcom/bytedance/android/livesdk/landscapeslide/g;", "mLiveRoomOrientation", "Lcom/bytedance/android/livesdk/landscapeslide/g;", "mSupportLandscape", "<init>", "()V", "Companion", "a", "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLandJumpContext extends DataContext {
    public static final a Companion = null;
    private static String SHARE_KEY = null;
    private static final String TAG = "LiveLandJumpContext";
    private static final List<i> supportSource = null;
    private boolean mHasCheck;
    private d mInitLandscapeFeedFunc;
    private g mLiveRoomOrientation;
    private long mRoomId;
    private boolean mSupportLandscape;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static LiveLandJumpContext a() {
            DataContext r1 = null;
            if (com.bytedance.android.livesdk.utils.landscape.b.a() == true) goto L5;
            return null;
        L5:
            DataContext r0 = com.bytedance.live.datacontext.d.d(LiveLandJumpContext.access$getSHARE_KEY$cp());
            if ((r0 instanceof LiveLandJumpContext) == false) goto L10;
            r1 = r0;
        L10:
            return (LiveLandJumpContext) r1;
        }

        @JvmStatic
        public static boolean b(Bundle r6) {
            Bundle r0 = m0.a(r6);
            String r1 = "";
            if (r0 != null) goto L5;
            String r2 = "";
        L6:
            Bundle r3 = m0.a(r6);
            if (r3 == null) goto L10;
            r1 = r3.getString("enter_method", "");
        L10:
            int r4 = i.c;
            if (i.a.a(LiveLandJumpContext.access$getSupportSource$cp(), r2 + '_' + r1) == true) goto L15;
            ALogger.i(LiveLandJumpContext.TAG, "not from landscape drawer:" + r2 + '_' + r1);
            return false;
        L15:
            if (r6.getInt("live.intent.extra.SCREEN_ORIENTATION", -1) == 0) goto L18;
            ALogger.i(LiveLandJumpContext.TAG, "not from landscape drawer: not landscape");
            return false;
        L18:
            return true;
        L5:
            r2 = r0.getString("enter_from_merge", "");
            goto L6
        }

        @JvmStatic
        public static void c(ds0.d r8) {
            Intrinsics.checkNotNullParameter(r8, "roomSession");
            if (com.bytedance.android.livesdk.utils.landscape.b.a() == true) goto L5;
            return;
        L5:
            f2.b(2131920809, 0);
            long r2 = r8.x();
            String r9 = r8.getUserId();
            IMiddlewareUserService r0 = k.f(IMiddlewareUserService.class);
            if (r0 == null) goto L10;
            com.bytedance.android.livesdk.user.e r1 = r0.user();
            if (r1 == null) goto L10;
            String r3 = r1.n();
        L11:
            j0.l().sendLog("livesdk_portrait_toast_show", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("is_support_landscape", BDLocationException.ERROR_TIMEOUT), TuplesKt.to("pre_room_orientation", "1"), TuplesKt.to("user_id", String.valueOf(r3)), TuplesKt.to("anchor_id", String.valueOf(r9)), TuplesKt.to("room_id", String.valueOf(r2))}), new Object[0]);
            return;
        L10:
            r3 = null;
            goto L11
        }
    }

    @JvmStatic
    public static final LiveLandJumpContext getShared() {
        Companion.getClass();
        return a.a();
    }

    @JvmStatic
    public static final void showToast(ds0.d r1) {
        Companion.getClass();
        a.c(r1);
    }

    static {
        Companion = new a();
        SHARE_KEY = TAG;
        MatchMode r2 = MatchMode.EQUALS;
        supportSource = CollectionsKt.listOf(new i[]{new i("drawer_[a-zA-Z]+_drawer_[\\w]+", MatchMode.REGEX), new i("drawer_hot_live_history", r2), new i("general_search_drawer_cover", r2)});
    }

    public LiveLandJumpContext() {
        this.mRoomId = -1;
    }

    public static final /* synthetic */ String access$getSHARE_KEY$cp() {
        return SHARE_KEY;
    }

    public static final /* synthetic */ List access$getSupportSource$cp() {
        return supportSource;
    }

    public static final /* synthetic */ boolean access$getMHasCheck$p(LiveLandJumpContext r0) {
        return r0.mHasCheck;
    }

    public static final /* synthetic */ d access$getMInitLandscapeFeedFunc$p(LiveLandJumpContext r0) {
        return r0.mInitLandscapeFeedFunc;
    }

    public static final /* synthetic */ g access$getMLiveRoomOrientation$p(LiveLandJumpContext r0) {
        return r0.mLiveRoomOrientation;
    }

    public static final /* synthetic */ long access$getMRoomId$p(LiveLandJumpContext r2) {
        return r2.mRoomId;
    }

    public static final /* synthetic */ void access$setSHARE_KEY$cp(String r0) {
        SHARE_KEY = r0;
    }

    @JvmStatic
    private static final boolean isFromLandscapeDrawer(Bundle r1) {
        Companion.getClass();
        return a.b(r1);
    }

    private final boolean isGameLive(ds0.d r3) {
        if (d1.a(r3.w()) == false) goto L5;
    L6:
        return true;
    L5:
        if (r3.f().getBoolean("live.intent.extra.is_game_live", false) == true) goto L6;
        return false;
    }

    public final boolean checkIsNotSupportLandFromDrawer(ds0.d r8) {
        Intrinsics.checkNotNullParameter(r8, "session");
        com.bytedance.android.livesdk.utils.landscape.b.c("checkIsNotSupportLandFromDrawer");
        if (this.mHasCheck == false) goto L7;
        ALogger.d(TAG, "has check");
        return false;
    L7:
        if (r8.x() == this.mRoomId) goto L11;
        ALogger.d(TAG, "not room match");
        return false;
    L11:
        if (r8.isVideoHorizontal() == false) goto L13;
    L16:
        Room r0 = r8.w();
        if (r0 != null) goto L19;
    L26:
        boolean r1 = true;
    L27:
        if (r1 == true) goto L31;
        ALogger.i(TAG, "not enable switch");
        this.mHasCheck = true;
        return true;
    L31:
        if (isGameLive(r8) == true) goto L34;
        ALogger.i(TAG, "is not game live");
        this.mHasCheck = true;
        return true;
    L34:
        this.mSupportLandscape = true;
        this.mHasCheck = true;
        return false;
    L19:
        if (r0.getRoomAuthStatus() == null) goto L26;
        if (r0.getRoomAuthStatus().isEnableSwitchLandscape() == true) goto L26;
        if (r0.isPaidRoom() == true) goto L26;
        r1 = false;
        goto L27
    L13:
        if (e5.f(r8.getScreenOrientation()) == false) goto L16;
        ALogger.i(TAG, "w < h , show toast");
        this.mHasCheck = true;
        return true;
    }

    public static final /* synthetic */ void access$setMHasCheck$p(LiveLandJumpContext r0, boolean r1) {
        r0.mHasCheck = r1;
    }

    public static final /* synthetic */ void access$setMInitLandscapeFeedFunc$p(LiveLandJumpContext r0, d r1) {
        r0.mInitLandscapeFeedFunc = r1;
    }

    public static final /* synthetic */ void access$setMLiveRoomOrientation$p(LiveLandJumpContext r0, g r1) {
        r0.mLiveRoomOrientation = r1;
    }

    public static final /* synthetic */ void access$setMRoomId$p(LiveLandJumpContext r0, long r1) {
        r0.mRoomId = r1;
    }

    @JvmStatic
    public static final void init(Fragment r2, Bundle r3, g r4, d r5) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "bundle");
        Intrinsics.checkNotNullParameter(r4, "orientation");
        Intrinsics.checkNotNullParameter(r5, "func");
        if (com.bytedance.android.livesdk.utils.landscape.b.a() == false) goto L25;
        com.bytedance.android.livesdk.utils.landscape.b.c("LiveLandJumpContext start init");
        access$setSHARE_KEY$cp(TAG + r2.hashCode());
        if (a.b(r3) == true) goto L9;
        return;
    L9:
        if (r3.getInt("live.intent.extra.EXTRA_ENTER_MULTI_TAB_TYPE", -1) != 1) goto L27;
        com.bytedance.live.datacontext.d.c(com.bytedance.live.datacontext.d.b(r2, null).a(LiveLandJumpContext.class), access$getSHARE_KEY$cp());
        LiveLandJumpContext r6 = a.a();
        if (r6 == null) goto L14;
        access$setMRoomId$p(r6, r3.getLong("live.intent.extra.ROOM_ID"));
    L14:
        LiveLandJumpContext r7 = a.a();
        if (r7 == null) goto L17;
        access$setMInitLandscapeFeedFunc$p(r7, r5);
    L17:
        LiveLandJumpContext r8 = a.a();
        if (r8 == null) goto L20;
        access$setMLiveRoomOrientation$p(r8, r4);
    L20:
        LiveLandJumpContext r9 = a.a();
        if (r9 == null) goto L23;
        access$setMHasCheck$p(r9, false);
    L23:
        com.bytedance.android.livesdk.utils.landscape.b.c("LiveLandJumpContext end init");
        return;
    L27:
        return;
    }
}
