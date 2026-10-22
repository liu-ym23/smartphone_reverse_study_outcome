package com.larus.im.internal.network.adapter.impl.v2.converter;

import com.google.protobuf.Message;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.internal.network.proto2.AvAudioUplink;
import com.larus.im.internal.network.proto2.AvCmd;
import com.larus.im.internal.network.proto2.AvUplink;
import com.larus.im.service.audio.ModalType;
import com.larus.im.service.audio.cmd.TargetVideoSourceType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import we9.i;

/* JADX INFO: loaded from: classes30.dex */
public final class f implements je9.c<xe9.f, AvUplink.UplinkMessage.Builder> {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f349035a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f349036b = null;

        static {
            int[] r100 = new int[ModalType.values().length];
            r100[ModalType.VIDEO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L4:
            f349035a = r100;
            int[] r101 = new int[TargetVideoSourceType.values().length];
            r101[TargetVideoSourceType.VIDEO_SOURCE_CAMERA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L14:
            r101[TargetVideoSourceType.VIDEO_SOURCE_SCREEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L20:
            r101[TargetVideoSourceType.VIDEO_SOURCE_DEFAULT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L8:
            f349036b = r101;
        }
    }

    public f() {
    }

    @Override // je9.c
    public final void a(Message.Builder r100, xe9.e r101) {
        AvUplink.UplinkMessage.Builder r102 = (AvUplink.UplinkMessage.Builder) r100;
        xe9.f r103 = (xe9.f) r101;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Intrinsics.checkNotNullParameter(r103, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r103, "<this>");
        r102.setEvent(AvCmd.AVCMD.COMMAND_SIGNAL_UPLINK);
        Intrinsics.checkNotNullParameter(r103, "<this>");
        boolean r104 = r103 instanceof i;
        if (r104 == false) goto L5;
        AvCmd.CommandEventType r105 = AvCmd.CommandEventType.SWITCH_MODAL;
    L6:
        r102.setVideoEvent(r105);
        AvUplink.UplinkBody.Builder r106 = r102.getUplinkBodyBuilder();
        if (r106 != null) goto L9;
        r106 = AvUplink.UplinkBody.newBuilder();
    L9:
        AvUplink.VideoUplinkBody.Builder r107 = r106.getVideoBodyBuilder();
        if (r107 != null) goto L12;
        r107 = AvUplink.VideoUplinkBody.newBuilder();
    L12:
        Intrinsics.checkNotNull(r107);
        if (r104 == false) goto L33;
        AvUplink.VideoSwitchModal.Builder r108 = r107.getSwitchModalBuilder();
        if (r108 != null) goto L17;
        r108 = AvUplink.VideoSwitchModal.newBuilder();
    L17:
        i r109 = (i) r103;
        ModalType r110 = r109.f559433b;
        if (a.f349035a[r110.ordinal()] != 1) goto L20;
        AvUplink.ModalType r111 = AvUplink.ModalType.MODAL_TYPE_VIDEO;
    L21:
        r108.setModalType(r111);
        TargetVideoSourceType r112 = r109.f559434c;
        int r113 = a.f349036b[r112.ordinal()];
        if (r113 != 1) goto L24;
        AvUplink.VideoSourceType r114 = AvUplink.VideoSourceType.VIDEO_SOURCE_CAMERA;
    L32:
        r108.setSourceType(r114);
        r108.setChat(AvAudioUplink.ChatConfig.newBuilder().setConversationId(r109.f559432a.f554433a).setBotId(r109.f559432a.f554437e).setUid(r109.f559432a.f554434b).setCallId(r109.f559432a.f554435c).setLocalCallId(r109.f559432a.f554436d).putAllExtra(r109.f559432a.f554443k).build());
        r107.setSwitchModal(r108);
        goto L33
    L24:
        if (r113 != 2) goto L26;
        r114 = AvUplink.VideoSourceType.VIDEO_SOURCE_SCREEN;
        goto L32
    L26:
        if (r113 != 3) goto L29;
        r114 = AvUplink.VideoSourceType.VIDEO_SOURCE_DEFAULT;
        goto L32
    L29:
        throw new NoWhenBranchMatchedException();
    L20:
        r111 = AvUplink.ModalType.MODAL_TYPE_AUDIO;
    L33:
        r106.setVideoBody(r107);
        r102.setUplinkBody(r106);
        return;
    L5:
        r105 = AvCmd.CommandEventType.COMMON_UNUSED;
        goto L6
    }
}
