package com.bytedance.android.livesdk.mergecomponents.context;

import android.content.Context;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.AnimationCenterScheduler;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.BottomToolbarViewModel;
import com.bytedance.android.livesdk.toolbarservice.api.IToolbarService;
import com.bytedance.android.livesdkapi.arch.CommonRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.arch.IInjectBusinessContext;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.room.handler.toolbar.LiveTbArchUtils;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ToolbarInjectContext implements IInjectBusinessContext {
    public ToolbarInjectContext() {
    }

    public final void injectPreviewBusinessDataCenter(DataCenter r1, Room r2) {
    }

    public final void injectPreviewRoomController(DataCenter r1, Room r2) {
        IInjectBusinessContext.DefaultImpls.injectPreviewRoomController(this, r1, r2);
    }

    public final void injectPreviewBusinessRoomContext(Context r7, CommonRoomContext r8, DataCenter r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        if (r9 == null) goto L45;
        boolean r0 = r8 instanceof RoomContext;
        Room r1 = null;
        if (r0 == true) goto L7;
        CommonRoomContext r2 = null;
    L8:
        final RoomContext r3 = (RoomContext) r2;
        if (r3 != null) goto L11;
    L18:
        if (r0 == true) goto L20;
        CommonRoomContext r10 = null;
    L21:
        RoomContext r11 = (RoomContext) r10;
        if (r11 == null) goto L26;
        j r12 = r11.getAnimationCenterScheduler();
        if (r12 == null) goto L26;
        r12.d(new AnimationCenterScheduler(r9));
    L26:
        if (r8 == null) goto L46;
        m r13 = r8.getRoom();
        if (r13 == null) goto L47;
        Room r14 = (Room) r13.getValue();
        if (r14 != null) goto L32;
        return;
    L32:
        if (r14.isGameCPRoom() == false) goto L34;
        r1 = r14;
    L34:
        if (r1 != null) goto L36;
        return;
    L36:
        if (a0.c(r9) == false) goto L38;
        String r15 = ILiveRoomControllerProvider.ProviderSource.PREVIEW.name();
    L39:
        IHostGameCP r16 = k.f(IHostGameCP.class);
        if (r16 == null) goto L50;
        IGameCpLiveService r17 = r16.getGameCpLiveService();
        if (r17 == null) goto L51;
        r17.injectPreviewToolbarData(r1.getRoomId(), z.d(r9, Long.valueOf(r1.getRoomId())), r15);
        return;
    L51:
        return;
    L50:
        return;
    L38:
        r15 = ILiveRoomControllerProvider.ProviderSource.DEFAULT.name();
        goto L39
    L47:
        return;
    L46:
        return;
    L20:
        r10 = r8;
        goto L21
    L11:
        if (LiveTbArchUtils.INSTANCE.enableOpt(r9) == false) goto L17;
        j r4 = r3.getTbContext();
        IToolbarService r5 = k.f(IToolbarService.class);
        if (r5 == null) goto L15;
        DataContext r18 = r5.initTbContext(r7, r3, r9);
    L16:
        r4.d(r18);
        r3.getCompactTbLoader().e(new ToolbarInjectContext$injectPreviewBusinessRoomContext$1$1$1(r3));
        r3.getTbCompConfigRegister().e(new ToolbarInjectContext$injectPreviewBusinessRoomContext$1$1$2(r3));
        goto L18
    L15:
        r18 = null;
        goto L16
    L17:
        r3.getCommonSlotViewModel().d(new BottomToolbarViewModel(r7, r9, false));
        r3.getCompactTbLoader().e(new ToolbarInjectContext$injectPreviewBusinessRoomContext$1$1$3(r3));
        r3.getTbCompConfigRegister().e(new ToolbarInjectContext$injectPreviewBusinessRoomContext$1$1$4(r3));
        goto L18
    L7:
        r2 = r8;
        goto L8
    }
}
