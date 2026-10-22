package com.bytedance.android.livesdk.landscapeslide;

import android.view.MotionEvent;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.d1;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0002)*B\u0017\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\u0012\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\"\u0010\u001b\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/landscapeslide/LiveLandSlideContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "getLandFeedSize", "", "delta", "", "checkSlideIntercept", "prefetchSize", "checkLoad", "getRelateRoomIndex", "", "getInitRoomId", "getCurrentRoomId", "Lcom/bytedance/android/livesdk/widget/LiveVerticalViewPager;", "viewPager", "Lcom/bytedance/android/livesdk/vs/a;", "createScrollLimiter", "initRoomId", "J", "Lcom/bytedance/live/datacontext/m;", "isDataReady$delegate", "Lcom/bytedance/live/datacontext/p;", "isDataReady", "()Lcom/bytedance/live/datacontext/m;", "isDataEmpty$delegate", "isDataEmpty", "curRoomId", "getCurRoomId", "()J", "setCurRoomId", "(J)V", "Lcom/bytedance/android/livesdk/landscapeslide/b;", "listProvider", "Lcom/bytedance/android/livesdk/landscapeslide/b;", "Lcom/bytedance/android/livesdk/landscapeslide/LiveLandSlideContext$b;", "listHelper", "Lcom/bytedance/android/livesdk/landscapeslide/LiveLandSlideContext$b;", "<init>", "(Lcom/bytedance/android/livesdk/landscapeslide/b;Lcom/bytedance/android/livesdk/landscapeslide/LiveLandSlideContext$b;)V", "Companion", "a", "b", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLandSlideContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private static String SHARE_KEY = null;
    private static final String TAG = "LiveLandSlideContext";
    private static final List<i> supportEnterSource = null;
    private long curRoomId;
    private final long initRoomId;
    private final p isDataEmpty$delegate;
    private final p isDataReady$delegate;
    private final b listHelper;
    private final com.bytedance.android.livesdk.landscapeslide.b listProvider;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static LiveLandSlideContext a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(LiveLandSlideContext.access$getSHARE_KEY$cp());
            if ((r0 instanceof LiveLandSlideContext) == true) goto L5;
            r0 = null;
        L5:
            LiveLandSlideContext r1 = (LiveLandSlideContext) r0;
            if (r1 != null) goto L8;
            return null;
        L8:
            if (com.bytedance.android.livesdk.utils.landscape.f.a() == true) goto L10;
            return null;
        L10:
            return r1;
        }

        @JvmStatic
        public static boolean b() {
            LiveLandSlideContext r0 = a();
            if (r0 == null) goto L9;
            m<Boolean> r1 = r0.isDataReady();
            if (r1 == null) goto L9;
            Boolean r2 = (Boolean) r1.getValue();
            if (r2 == null) goto L9;
            return r2.booleanValue();
        L9:
            return false;
        }
    }

    public interface b {
    }

    public static final class c implements com.bytedance.android.livesdk.vs.a {
        public float a;
        public final /* synthetic */ LiveLandSlideContext b;
        public final /* synthetic */ LiveVerticalViewPager c;

        public final boolean onInterceptTouchEvent(MotionEvent r4) {
            Intrinsics.checkNotNullParameter(r4, "ev");
            if (r4.getAction() != 0) goto L6;
            this.a = r4.getY();
            this.c.setIgnoreSpeed(false);
        L11:
            return false;
        L6:
            if (r4.getAction() != 2) goto L11;
            if (this.b.checkSlideIntercept(r4.getY() - this.a) == false) goto L11;
            this.c.requestDisallowInterceptTouchEvent(true);
            return true;
        }

        public final boolean onTouchEvent(MotionEvent r5) {
            Intrinsics.checkNotNullParameter(r5, "ev");
            if (this.b.checkSlideIntercept(r5.getY() - this.a) == true) goto L6;
            return false;
        L6:
            if (r5.getAction() != 2) goto L9;
            return true;
        L9:
            if (r5.getAction() != 1) goto L11;
            this.c.setIgnoreSpeed(true);
        L11:
            return false;
        }

        public c(LiveLandSlideContext r1, LiveVerticalViewPager r2) {
            this.b = r1;
            this.c = r2;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LiveLandSlideContext.class, "isDataReady", "isDataReady()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LiveLandSlideContext.class, "isDataEmpty", "isDataEmpty()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
        SHARE_KEY = TAG;
        if (com.bytedance.android.livesdk.utils.landscape.f.a() == false) goto L8;
        List<i> r0 = new ArrayList();
        Iterator r1 = com.bytedance.android.livesdk.utils.landscape.f.a.e().iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        r0.add(new i((String) r1.next(), MatchMode.EQUALS));
    L9:
        supportEnterSource = r0;
        return;
    L8:
        MatchMode r2 = MatchMode.EQUALS;
        r0 = CollectionsKt.listOf(new i[]{new i("homepage_hot_live_cell", r2), new i("homepage_hot_video_head", r2)});
        goto L9
    }

    @JvmStatic
    public static final LiveLandSlideContext getShared() {
        Companion.getClass();
        return a.a();
    }

    @JvmStatic
    public static final boolean isSlideAble() {
        Companion.getClass();
        return a.b();
    }

    public final m<Boolean> isDataEmpty() {
        return (m) this.isDataEmpty$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Boolean> isDataReady() {
        return (m) this.isDataReady$delegate.a(this, $$delegatedProperties[0]);
    }

    private final int getLandFeedSize() {
        return this.listProvider.i() + 1;
    }

    @JvmStatic
    public static final long getSelectedRoom() {
        Companion.getClass();
        LiveLandSlideContext r0 = a.a();
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getCurRoomId();
    }

    @JvmStatic
    public static final boolean isEnable() {
        Companion.getClass();
        if (a.a() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final long getCurrentRoomId() {
        this.listHelper.getClass();
        RoomContext r0 = RoomContext.getShared();
        if (r0 != null) goto L7;
        return -1000;
    L7:
        return ((Room) r0.getRoom().getValue()).getRoomId();
    }

    public final int getRelateRoomIndex() {
        int r0 = this.listHelper.a.b.e.getCurrentItem() - this.listProvider.e();
        if (r0 > 0) goto L7;
        return 0;
    L7:
        return r0;
    }

    public static final /* synthetic */ String access$getSHARE_KEY$cp() {
        return SHARE_KEY;
    }

    public static final /* synthetic */ List access$getSupportEnterSource$cp() {
        return supportEnterSource;
    }

    public final long getCurRoomId() {
        return this.curRoomId;
    }

    public final long getInitRoomId() {
        return this.initRoomId;
    }

    public static final /* synthetic */ void access$setSHARE_KEY$cp(String r0) {
        SHARE_KEY = r0;
    }

    @JvmStatic
    private static final void log(String r1) {
        Companion.getClass();
        f.c(r1, TAG);
    }

    @JvmStatic
    public static final void setCurFragmentKey(Fragment r2) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r2, "fragment");
        access$setSHARE_KEY$cp(TAG + r2.hashCode());
    }

    @JvmStatic
    public static final void setSelectedRoom(long r1) {
        Companion.getClass();
        LiveLandSlideContext r0 = a.a();
        if (r0 == null) goto L6;
        r0.setCurRoomId(r1);
        return;
    }

    public final boolean checkLoad(int r4) {
        int r0 = getRelateRoomIndex();
        if (r0 >= 0) goto L6;
        return false;
    L6:
        if ((getLandFeedSize() - r0) > r4) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean checkSlideIntercept(float r6) {
        Companion.getClass();
        if (a.b() == true) goto L5;
        return false;
    L5:
        float r0 = 0;
        if (r6 <= r0) goto L10;
        if (this.listHelper.a.b.e.getCurrentItem() > this.listProvider.e()) goto L10;
    L13:
        return true;
    L10:
        if (r6 < r0) goto L12;
        return false;
    L12:
        if (getRelateRoomIndex() >= (getLandFeedSize() - 1)) goto L13;
        return false;
    }

    public final com.bytedance.android.livesdk.vs.a createScrollLimiter(LiveVerticalViewPager r2) {
        Intrinsics.checkNotNullParameter(r2, "viewPager");
        return new c(this, r2);
    }

    public final void setCurRoomId(long r1) {
        this.curRoomId = r1;
    }

    public LiveLandSlideContext(com.bytedance.android.livesdk.landscapeslide.b r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "listProvider");
        Intrinsics.checkNotNullParameter(r3, "listHelper");
        this.listProvider = r2;
        this.listHelper = r3;
        String r4 = SHARE_KEY;
        int r0 = com.bytedance.live.datacontext.d.a;
        Intrinsics.checkNotNullParameter(this, "self");
        com.bytedance.live.datacontext.b.a(this, r4);
        ((ti1.h) r3).getClass();
        RoomContext r5 = RoomContext.getShared();
        if (r5 == null) goto L5;
        long r6 = ((Room) r5.getRoom().getValue()).getRoomId();
    L6:
        this.initRoomId = r6;
        Boolean r7 = Boolean.FALSE;
        this.isDataReady$delegate = q.d(this, r7);
        this.isDataEmpty$delegate = q.d(this, r7);
        return;
    L5:
        r6 = -1000;
        goto L6
    }

    @JvmStatic
    public static final Pair<LiveLandSlideContext, Disposable> initAndLoad(final com.bytedance.android.livesdk.landscapeslide.b r1, final b r2) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "listProvider");
        Intrinsics.checkNotNullParameter(r2, "listHelper");
        return com.bytedance.live.datacontext.d.a(new LiveLandSlideContext$Companion$initAndLoad$1(r1, r2));
    }

    @JvmStatic
    public static final boolean checkEnv(String r6, String r7, ds0.d r8) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r6, "enterMerge");
        Intrinsics.checkNotNullParameter(r7, "enterMethod");
        String r0 = r6 + '_' + r7;
        int r2 = i.c;
        if (i.a.a(access$getSupportEnterSource$cp(), r0) == true) goto L5;
        f.c("not support source " + r6 + '_' + r7, TAG);
        return false;
    L5:
        f.c("support source " + r6 + '_' + r7, TAG);
        Room r4 = null;
        if (com.bytedance.android.livesdk.utils.landscape.f.a() == false) goto L15;
        MiddlewareRoomContext r9 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r9 == null) goto L13;
        m r10 = r9.getRoom();
        if (r10 == null) goto L13;
        r4 = (Room) r10.getValue();
    L13:
        if (f.b(r4, "init") == true) goto L38;
        f.c("extension is not horizontal live", TAG);
        return false;
    L38:
        if (PadConfigUtils.a() == false) goto L40;
        return false;
    L40:
        if (a.a() == null) goto L42;
        boolean r11 = true;
    L43:
        if (r11 == true) goto L50;
        return true;
    L50:
        return false;
    L42:
        r11 = false;
        goto L43
    L15:
        IRoomContextService r12 = k.f(IRoomContextService.class);
        if (r12 == null) goto L22;
        o r13 = IRoomContextService.a.a(r12, null, 0, 3);
        if (r13 == null) goto L22;
        m r14 = r13.getRoom();
        if (r14 == null) goto L22;
        r4 = (IRoom) r14.getValue();
    L22:
        if (r4 != null) goto L24;
    L26:
        if (r8 != null) goto L29;
        boolean r15 = d1.a(r4);
    L35:
        if (r15 == true) goto L38;
        f.c("is not game live", TAG);
        return false;
    L29:
        if (d1.a(r8.w()) == false) goto L31;
    L34:
        r15 = true;
        goto L35
    L31:
        if (r8.f().getBoolean("live.intent.extra.is_game_live", false) == true) goto L34;
    L33:
        r15 = false;
        goto L35
    L24:
        if (r4.isMergeVSRoom() != true) goto L26;
        ALogger.i(TAG, "room is VS stream room roomid " + r4.getId());
        goto L33
    }
}
