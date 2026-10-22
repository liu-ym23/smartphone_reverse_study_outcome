package com.ss.android.lark.integrator.flow.chat;

import aqb.j;
import aza.d;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.FeedCard;
import com.bytedance.lark.pb.feed.v1.UpdateFeedCardUnreadRequest;
import com.bytedance.lark.pb.feed.v1.UpdateFeedCardUnreadResponse;
import com.ss.android.lark.feed.app.entity.UpdateUnreadStatusScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserEntryPoint;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.statistics.Statistics;
import dagger.hilt.EntryPoints;
import egb.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import qeb.b;
import z5c.p3;
import z5c.r;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowChatDependencyImpl$feedDependency$1 implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<j> f427913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.android.lark.integrator.flow.chat.a f427914b;

    public static final class a implements SdkSender.IParser<UpdateFeedCardUnreadResponse> {
        public a() {
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final UpdateFeedCardUnreadResponse parse(byte[] r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            return UpdateFeedCardUnreadResponse.ADAPTER.decode(r100);
        }
    }

    @Override // w4b.m
    public final void d() {
    }

    @Override // w4b.m
    public final void e() {
    }

    @Override // w4b.m
    public final void g() {
    }

    @Override // w4b.m
    public final int getBadge() {
        return ((Number) BuildersKt.runBlocking$default(null, new FlowChatDependencyImpl$feedDependency$1$getBadge$1(null), 1, null)).intValue();
    }

    public FlowChatDependencyImpl$feedDependency$1() {
        this.f427913a = new ArrayList();
    }

    @Override // w4b.m
    public final void a(com.ss.android.lark.chat.chatwindow.chat.v2.push.c.b r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (((ArrayList) this.f427913a).contains(r100) == true) goto L8;
        ((ArrayList) this.f427913a).add(r100);
    L8:
        if (this.f427914b != null) goto L25;
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L11:
        if (this.f427914b != null) goto L19;
        com.ss.android.lark.integrator.flow.chat.a r101 = new com.ss.android.lark.integrator.flow.chat.a(this);     // Catch: Throwable -> L22
        this.f427914b = r101;     // Catch: Throwable -> L22
        d r102 = (d) ((OfficeSDKUserEntryPoint) EntryPoints.get(OfficeSDKManager.getOfficeSDKUserComponent(), OfficeSDKUserEntryPoint.class)).getOfficeSDKUserApi().getService(d.class);     // Catch: Exception -> L17 Throwable -> L22
        if (r102 == null) goto L19;
        r102.J5(r101);     // Catch: Exception -> L17 Throwable -> L22
        Unit r103 = Unit.INSTANCE;     // Catch: Exception -> L17 Throwable -> L22
    L17:
        e = move-exception;
        Log.e("FlowChatDependencyImpl", e);     // Catch: Throwable -> L22
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L22
    L19:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    }

    @Override // w4b.m
    public final void c(com.ss.android.lark.chat.chatwindow.chat.v2.push.c.b r100) {
        TypeIntrinsics.asMutableCollection(this.f427913a).remove(r100);
        if (((ArrayList) this.f427913a).isEmpty() == false) goto L17;
        com.ss.android.lark.integrator.flow.chat.a r101 = this.f427914b;
        if (r101 != null) goto L15;
        return;
    L15:
        d r102 = (d) ((OfficeSDKUserEntryPoint) EntryPoints.get(OfficeSDKManager.getOfficeSDKUserComponent(), OfficeSDKUserEntryPoint.class)).getOfficeSDKUserApi().getService(d.class);     // Catch: Exception -> L11
        if (r102 == null) goto L13;
        r102.J5(r101);     // Catch: Exception -> L11
    L13:
        this.f427914b = null;
        return;
    L11:
        e = move-exception;
        Log.e("FlowChatDependencyImpl", e);
        goto L13
    }

    @Override // w4b.m
    public final /* bridge */ /* synthetic */ void f(Long r100, Long r101) {
        r100.longValue();
        r101.longValue();
    }

    @Override // w4b.m
    public final void b(String r100, FeedCard.EntityType r101, boolean r102, UpdateUnreadStatusScene r103) {
        Intrinsics.checkNotNullParameter(r103, "updateUnreadStatusScene");
        Log.i("FlowChatDependencyImpl", "update feed card read status,feedid: " + r100 + ",type:" + r101 + ",targetUnreadStatus:" + r102);
        if (r100 == null) goto L16;
        if (r101 == null) goto L17;
        int r104 = b.f532708a;
        Intrinsics.checkNotNullParameter(r103, "actionScene");
        if (r102 == true) goto L10;
    L14:
        SdkSender.asynSendRequestNonWrap(Command.UPDATE_FEED_CARD_UNREAD, new UpdateFeedCardUnreadRequest.Builder().id(r100).entity_type(r101).mark_as_unread(Boolean.valueOf(r102)), new FlowChatDependencyImpl$feedDependency$1$updateFeedCardUnreadStatus$1(), new a());
        return;
    L10:
        if (r103 != UpdateUnreadStatusScene.FEED_ITEM) goto L12;
        s5c.a r105 = z5c.b.f570154c;
    L13:
        s5c.a r106 = r.T2;
        s5c.a r107 = p3.f570282c;
        r106.getClass();
        JSONObject r108 = s5c.d.b.b(r106, r107).plus(r105).toJson();
        qeb.c.a(r108, false);
        Statistics.sendEvent("feed_press_click", r108);
        goto L14
    L12:
        r105 = z5c.b.f570155d;
        goto L13
    L17:
        return;
    }
}
