package it1;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.helper.EnterRoomTimeTracer;
import com.bytedance.android.livesdk.chatroom.helper.f;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;

/* JADX INFO: loaded from: classes8.dex */
public final class a {
    public static String d(SparseArray<EnterRoomTimeTracer.a> r110) {
        if (r110 != null) goto L5;
        return "";
    L5:
        StringBuilder r100 = new StringBuilder("taskType:+0,timeStep:");
        r100.append(System.currentTimeMillis());
        r100.append(",from_type:");
        String r101 = k1.c();
        r101.getClass();
        byte r102 = -1;
        switch(r101.hashCode()) {
            case -1271119582: goto L17;
            case 1207523109: goto L13;
            case 1691937916: goto L9;
            default: goto L20;
        };
    L20:
        switch(r102) {
            case 0: goto L27;
            case 1: goto L24;
            case 2: goto L22;
            default: goto L21;
        };
    L21:
        String r103 = k1.c();
    L28:
        r100.append(r103);
        r100.append("\n");
        StringBuilder r104 = new StringBuilder(r100.toString());
        EnterRoomTimeTracer.EventName r105 = EnterRoomTimeTracer.EventName.start_enter_room;
        EnterRoomTimeTracer.EventName r106 = EnterRoomTimeTracer.EventName.playing;
        r104.append(b(r110, "total_duration", r105, r106));
        EnterRoomTimeTracer.EventName r107 = EnterRoomTimeTracer.EventName.start_setup;
        r104.append(b(r110, "param_build", r105, r107));
        r104.append(b(r110, "feed_request", EnterRoomTimeTracer.EventName.start_request_feed, EnterRoomTimeTracer.EventName.end_request_feed));
        EnterRoomTimeTracer.EventName r108 = EnterRoomTimeTracer.EventName.end_setup;
        r104.append(b(r110, "start_page", r107, r108));
        EnterRoomTimeTracer.EventName r109 = EnterRoomTimeTracer.EventName.room_container_build;
        r104.append(b(r110, "page_init", r108, r109));
        EnterRoomTimeTracer.EventName r111 = EnterRoomTimeTracer.EventName.play_container_build;
        r104.append(b(r110, "room_container_build", r109, r111));
        EnterRoomTimeTracer.EventName r112 = EnterRoomTimeTracer.EventName.play_container_end;
        r104.append(b(r110, "play_container_build", r111, r112));
        r104.append(b(r110, "wait_playing", r112, r106));
        EnterRoomTimeTracer.EventName r113 = EnterRoomTimeTracer.EventName.start_pull_stream;
        EnterRoomTimeTracer.EventName r114 = EnterRoomTimeTracer.EventName.stream_start;
        r104.append(b(r110, AbsMethodDelegate.TAG_INVOKE, r113, r114));
        EnterRoomTimeTracer.EventName r115 = EnterRoomTimeTracer.EventName.stream_first_frame_render_end;
        r104.append(b(r110, "stream_duration", r114, r115));
        EnterRoomTimeTracer.EventName r116 = EnterRoomTimeTracer.EventName.stream_sdk_dns_analysis_end;
        r104.append(b(r110, "sdk_dns_analysis", r114, r116));
        EnterRoomTimeTracer.EventName r117 = EnterRoomTimeTracer.EventName.stream_player_dns_analysis_end;
        r104.append(b(r110, "player_dns_analysis", r116, r117));
        EnterRoomTimeTracer.EventName r118 = EnterRoomTimeTracer.EventName.stream_tcp_connect_end;
        r104.append(b(r110, "tcp_connect", r117, r118));
        EnterRoomTimeTracer.EventName r119 = EnterRoomTimeTracer.EventName.stream_tcp_first_package_end;
        r104.append(b(r110, "tcp_first_package", r118, r119));
        EnterRoomTimeTracer.EventName r120 = EnterRoomTimeTracer.EventName.stream_first_video_package_end;
        r104.append(b(r110, "first_video_package", r119, r120));
        EnterRoomTimeTracer.EventName r121 = EnterRoomTimeTracer.EventName.stream_first_video_frame_decode_end;
        r104.append(b(r110, "first_video_decode", r120, r121));
        r104.append(b(r110, "first_frame_render", r121, r115));
        EnterRoomTimeTracer.EventName r122 = EnterRoomTimeTracer.EventName.first_frame;
        r104.append(b(r110, "callback", r115, r122));
        long r123 = a(r110, EnterRoomTimeTracer.EventName.stream_video_device_wait_start, EnterRoomTimeTracer.EventName.stream_video_device_wait_end);
        r104.append(c("first_frame_view", a(r110, r114, r115) - r123));
        r104.append(c("video_device_wait", r123));
        r104.append(b(r110, "find_stream_info", EnterRoomTimeTracer.EventName.stream_find_stream_info_start, EnterRoomTimeTracer.EventName.stream_find_stream_info_end));
        r104.append(b(r110, "finger_scroll", r113, r105));
        r104.append(b(r110, "first_frame_wait_playing", r122, r106));
        return r104.toString() + "\n";
    L22:
        r103 = "PREVIEW";
        goto L28
    L27:
        r103 = "ATTENTION";
        goto L28
    L24:
        if ("click".equals(f.C) == false) goto L26;
        r103 = "LIVE_BTN";
        goto L28
    L26:
        r103 = "SLIDE";
        goto L28
    L9:
        if (r101.equals(UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT) == false) goto L20;
        r102 = 2;
        goto L20
    L13:
        if (r101.equals("live_merge") == false) goto L20;
        r102 = 1;
        goto L20
    L17:
        if (r101.equals("homepage_follow") == false) goto L20;
        r102 = 0;
        goto L20
    }

    public static String c(String r100, long r101) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return "";
    L7:
        return r100 + " : " + r101 + ",";
    }

    public static long a(SparseArray<EnterRoomTimeTracer.a> r100, EnterRoomTimeTracer.EventName r101, EnterRoomTimeTracer.EventName r102) {
        EnterRoomTimeTracer.a r103 = r100.get(r101.ordinal());
        EnterRoomTimeTracer.a r104 = r100.get(r102.ordinal());
        if (r103 == null) goto L12;
        if (r104 == null) goto L14;
        long r105 = r103.f106402b;
        if (r105 <= 0) goto L15;
        long r106 = r104.f106402b;
        if (r106 > 0) goto L11;
        return -1;
    L11:
        return r106 - r105;
    L15:
        return -1;
    L14:
        return -1;
    L12:
        return -1;
    }

    public static String b(SparseArray<EnterRoomTimeTracer.a> r100, String r101, EnterRoomTimeTracer.EventName r102, EnterRoomTimeTracer.EventName r103) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.get(EnterRoomTimeTracer.EventName.start_enter_room.ordinal()) != null) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return "";
    L8:
        if (r100.get(r102.ordinal()) != null) goto L10;
        return "";
    L10:
        if (r100.get(r103.ordinal()) != null) goto L13;
        return "";
    L13:
        return r101 + " : " + a(r100, r102, r103) + ",";
    }
}
