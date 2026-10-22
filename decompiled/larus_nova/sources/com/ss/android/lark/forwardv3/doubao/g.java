package com.ss.android.lark.forwardv3.doubao;

import android.os.Bundle;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.data.ForwardTargetChatterInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetGroupChatInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetShieldP2PChatInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetThreadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g {
    public static final Bundle a(Map r110) {
        ArrayList<String> r100 = new ArrayList(r110.size());
        ArrayList<String> r101 = new ArrayList(r110.size());
        ArrayList<String> r102 = new ArrayList(r110.size());
        ArrayList<String> r103 = new ArrayList(r110.size());
        ArrayList<String> r104 = new ArrayList(r110.size());
        ArrayList<Integer> r105 = new ArrayList(r110.size());
        ArrayList<String> r106 = new ArrayList(r110.size());
        Iterator r111 = r110.entrySet().iterator();
    L4:
        if (r111.hasNext() == false) goto L18;
        Map.Entry r107 = (Map.Entry) r111.next();
        String r108 = (String) r107.getKey();
        ForwardTargetBaseInfoNew r109 = (ForwardTargetBaseInfoNew) r107.getValue();
        npc.c r112 = new npc.c();
        String r113 = r109.f425268a;
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r112.f520073a = r113;
        String r114 = r109.f425270c;
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r112.f520074b = r114;
        String r115 = r109.f425269b;
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r112.f520075c = r115;
        if ((r109 instanceof ForwardTargetChatterInfo) == false) goto L9;
        r112.f520077e = 1;
    L17:
        r100.add(r108);
        r101.add(r112.f520073a);
        r102.add(r112.f520074b);
        r103.add(r112.f520075c);
        r104.add(r112.f520076d);
        r105.add(Integer.valueOf(r112.f520077e));
        r106.add(r112.f520078f);
        goto L4
    L9:
        if ((r109 instanceof ForwardTargetShieldP2PChatInfo) == false) goto L12;
        r112.f520077e = 1;
        goto L17
    L12:
        if ((r109 instanceof ForwardTargetGroupChatInfo) == false) goto L15;
        r112.f520077e = 2;
        goto L17
    L15:
        if ((r109 instanceof ForwardTargetThreadInfo) == false) goto L17;
        r112.f520077e = 3;
        String r116 = ((ForwardTargetThreadInfo) r109).f425298h;
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r112.f520076d = r116;
        goto L17
    L18:
        Bundle r117 = new Bundle();
        r117.putStringArrayList("doubao_forward_result_message_ids", r100);
        r117.putStringArrayList("doubao_forward_result_target_ids", r101);
        r117.putStringArrayList("doubao_forward_result_avatar_keys", r102);
        r117.putStringArrayList("doubao_forward_result_names", r103);
        r117.putStringArrayList("doubao_forward_result_thread_ids", r104);
        r117.putIntegerArrayList("doubao_forward_result_target_types", r105);
        r117.putStringArrayList("doubao_forward_result_p2p_chat_ids", r106);
        return r117;
    }
}
