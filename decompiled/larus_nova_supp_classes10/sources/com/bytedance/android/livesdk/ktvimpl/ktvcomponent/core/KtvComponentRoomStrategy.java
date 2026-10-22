package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.ktvimpl.base.util.e;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.KtvComponentSingleBroadcastStrategy;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.b;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.g;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.h;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.i;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.n;
import hd0.c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 92\u00020\u00012\u00020\u0002:\u0001:B\u000f\u0012\u0006\u00105\u001a\u000204¢\u0006\u0004\b7\u00108J\b\u0010\u0004\u001a\u00020\u0003H\u0002J.\u0010\u000e\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J!\u0010\u0017\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u001d\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J&\u0010!\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010 \u001a\u00020\u0007J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\rH\u0014R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106¨\u0006;"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/core/KtvComponentRoomStrategy;", "Lcom/bytedance/android/livesdk/ktvimpl/base/util/e;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/core/strategey/a;", "getCurrentKtvStrategy", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "ktvMusic", "", "requestType", "Lcom/bytedance/android/live/liveinteract/api/chatroom/model/LinkApplyType;", "applyType", "Ltf0/b;", "applyCallback", "", "ktvApply", "Lh80/a;", "", "consumer", "cancelApply", "", "songId", "Lrj0/b;", "listener", "checkAudienceSingEnablePermission", "(Ljava/lang/Long;Lrj0/b;)V", "Landroid/content/Context;", "context", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "checkPermision", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "requestPage", "permit", "", "ktvAddSongLimitNum", "onCleared", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/core/strategey/KtvComponentSingleBroadcastStrategy;", "singleBroadcastStrategy", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/core/strategey/KtvComponentSingleBroadcastStrategy;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/core/strategey/b;", "singleAudienceStrategy", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/core/strategey/b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/core/strategey/g;", "videoTalkRoomStrategy", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/core/strategey/g;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/core/strategey/h;", "voiceTalkRoomStrategy", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/core/strategey/h;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/core/strategey/i;", "pkStrategy", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/core/strategey/i;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/ui/a;", "ktvUIStrategy", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/ui/a;", "<init>", "(Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/ui/a;)V", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentRoomStrategy extends ViewModel implements e {
    public static final a Companion = null;
    public static final String TAG = "KtvComponentRoomStrategy";
    private final com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a ktvUIStrategy;
    private final i pkStrategy;
    private final b singleAudienceStrategy;
    private final KtvComponentSingleBroadcastStrategy singleBroadcastStrategy;
    private final g videoTalkRoomStrategy;
    private final h voiceTalkRoomStrategy;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.a getCurrentKtvStrategy() {
        int r0 = k.n(IInteractService.class).getCurrentScene();
        ALogger.w("KtvComponent_MergeMode", "KtvComponentRoomStrategy: getCurrentKtvStrategy, currentScene=" + r0 + ", ");
        if (r0 == 4) goto L30;
        if (r0 == 5) goto L36;
        if (r0 == 8) goto L35;
        if (r0 == 12) goto L35;
        if (r0 == 16) goto L16;
        ArrayList<Integer> r1 = ke2.a.a;
        if (ke2.a.d(this.ktvUIStrategy.getDataCenter()) == false) goto L32;
        return this.pkStrategy;
    L32:
        return this.singleBroadcastStrategy;
    L16:
        o r2 = m.i();
        if (r2 == null) goto L23;
        com.bytedance.live.datacontext.m r3 = r2.getRoom();
        if (r3 == null) goto L23;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L23;
        boolean r5 = r4.isLiveTypeAudio();
    L24:
        if (r5 == false) goto L34;
        return this.voiceTalkRoomStrategy;
    L34:
        return this.videoTalkRoomStrategy;
    L23:
        r5 = false;
    L35:
        return this.videoTalkRoomStrategy;
    L36:
        return this.voiceTalkRoomStrategy;
    L30:
        return this.singleAudienceStrategy;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public int ktvAddSongLimitNum() {
        if (j.i() == false) goto L7;
        return ((Number) vm2.h.g2.getValue(null, vm2.h.a[161(0xa1, float:2.26E-43)])).intValue();
    L7:
        return ((Number) vm2.h.h2.getValue(null, vm2.h.a[162(0xa2, float:2.27E-43)])).intValue();
    }

    public void onCleared() {
        super.onCleared();
        KtvComponentSingleBroadcastStrategy r0 = this.singleBroadcastStrategy;
        r0.getClass();
        c.f().e((Observer) r0.e.getValue());
        MutableLiveData<d> r1 = KtvComponentContext.Companion.a();
        if (r1 == null) goto L5;
        r1.removeObserver((com.ss.android.ugc.aweme.compat.nullable.Observer) r0.d.getValue());
    L5:
        getCurrentKtvStrategy().release();
    }

    public KtvComponentRoomStrategy(com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a r4) {
        Intrinsics.checkNotNullParameter(r4, "ktvUIStrategy");
        this.ktvUIStrategy = r4;
        KtvComponentSingleBroadcastStrategy r0 = new KtvComponentSingleBroadcastStrategy(r4);
        c.f().c((Observer) r0.e.getValue());
        MutableLiveData<d> r1 = KtvComponentContext.Companion.a();
        if (r1 == null) goto L5;
        r1.observeForever((com.ss.android.ugc.aweme.compat.nullable.Observer) r0.d.getValue());
    L5:
        Unit r2 = Unit.INSTANCE;
        this.singleBroadcastStrategy = r0;
        this.singleAudienceStrategy = new b(r4);
        this.videoTalkRoomStrategy = new g(r4);
        this.voiceTalkRoomStrategy = new h(r4);
        this.pkStrategy = new i();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public void cancelApply(h80.a<Boolean> r4) {
        getCurrentKtvStrategy().cancelApply(r4);
        if (r4 == null) goto L6;
        int r5 = ke2.b.a;
        LinkedHashMap r6 = new LinkedHashMap();
        ke2.b.j(r6);
        r6.put("request_page", "live_song_apply_page");
        r6.put("is_live_song", "1");
        r6.put("function_type", k.n(IInteractService.class).getFunctionTypeForLog());
        j0.l().sendLog("livesdk_guest_apply_withdraw", r6, new Object[0]);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public void checkAudienceSingEnablePermission(Long r5, rj0.b r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L9;
        n<Boolean> r1 = r0.isAudienceEnableSing();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        boolean r3 = r2.booleanValue();
    L11:
        if (j.i() == true) goto L18;
        if (r3 == true) goto L18;
        if (r5 == null) goto L15;
        long r4 = r5.longValue();
    L16:
        com.bytedance.android.live.ktv.common.util.i.a(r4, -1);
        r6.onFailed(null);
        f2.b(2131918298, 0);
        return;
    L15:
        r4 = 0;
    L18:
        r6.onSuccess();
        return;
    L9:
        r3 = false;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public void checkPermision(Context r4, IRoom r5, rj0.b r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "room");
        Intrinsics.checkNotNullParameter(r6, "listener");
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L9;
        n<Boolean> r1 = r0.isAudienceEnableSing();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        boolean r3 = r2.booleanValue();
    L11:
        if (j.i() == true) goto L15;
        if (r3 == true) goto L15;
        r6.onFailed(null);
        f2.b(2131918297, 0);
        return;
    L15:
        getCurrentKtvStrategy().checkPermision(r4, r5, r6);
        return;
    L9:
        r3 = false;
        goto L11
    }

    public final void permit(IBaseUser r2, h80.a<Boolean> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r3, "consumer");
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        getCurrentKtvStrategy().Fh(r2, r3);
        IInteractService r5 = k.f(IInteractService.class);
        if (r5 == null) goto L6;
        r5.logPermit(r2, r4);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public void ktvApply(KtvMusic r2, String r3, LinkApplyType r4, tf0.b r5) {
        Intrinsics.checkNotNullParameter(r4, "applyType");
        getCurrentKtvStrategy().ktvApply(r2, r3, r4, r5);
    }

    public static /* synthetic */ void permit$default(KtvComponentRoomStrategy r0, IBaseUser r1, h80.a r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = "live_song_accept_button";
    L5:
        r0.permit(r1, r2, r3);
    }
}
