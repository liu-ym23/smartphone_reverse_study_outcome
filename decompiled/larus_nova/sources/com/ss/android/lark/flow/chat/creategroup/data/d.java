package com.ss.android.lark.flow.chat.creategroup.data;

import com.bytedance.lark.pb.basic.v1.ActionType;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.DeniedReason;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v2.ContactProfile;
import com.bytedance.lark.pb.contact.v2.UserRelation;
import com.bytedance.lark.pb.im.v2.GetContactsDoubaoWithDeniedReasonRequest;
import com.bytedance.lark.pb.im.v2.GetContactsDoubaoWithDeniedReasonResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.contact.base.entity.mobile.util.ContactMobileUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f422058a = 0;

    static {
    }

    public d() {
    }

    public static int b(char r100) {
        if (r100 != ' ') goto L5;
        return 36;
    L5:
        boolean r101 = false;
        if ('a' <= r100) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L14;
        return 35 - (r100 - 'a');
    L14:
        if ('0' <= r100) goto L16;
    L18:
        if (r101 == true) goto L24;
        return -1;
    L24:
        return 9 - (r100 - '0');
    L16:
        if (r100 >= ':') goto L18;
        r101 = true;
        goto L18
    L8:
        if (r100 >= '{') goto L10;
        r102 = true;
        goto L11
    }

    public static String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        String r101 = ContactMobileUtils.c(r100);
        boolean r102 = true;
        if (r101.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        char r104 = r101.charAt(0);
    L10:
        if ('A' <= r104) goto L12;
    L14:
        boolean r105 = false;
    L15:
        if (r105 == false) goto L18;
        return String.valueOf(r104);
    L18:
        if ('a' <= r104) goto L20;
    L22:
        r102 = false;
    L23:
        if (r102 == true) goto L28;
        return "#";
    L28:
        return String.valueOf(Character.toUpperCase(r104));
    L20:
        if (r104 >= '{') goto L22;
    L12:
        if (r104 >= '[') goto L14;
        r105 = true;
        goto L15
    L8:
        r104 = '#';
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Pair a(boolean r310, Long r311) {
        GetContactsDoubaoWithDeniedReasonRequest.Builder r100 = new GetContactsDoubaoWithDeniedReasonRequest.Builder();
        if (r310 == false) goto L5;
        r100.strategy(SyncDataStrategy.LOCAL);
    L6:
        r100.action_type = ActionType.INVITE_SAME_CHAT;
        if (r311 == null) goto L9;
        r100.chat_id = r311;
    L9:
        Command r101 = Command.GET_CONTACTS_DOUBAO_WITH_DENIED_REASON;
        final ProtoAdapter<GetContactsDoubaoWithDeniedReasonResponse> r102 = GetContactsDoubaoWithDeniedReasonResponse.ADAPTER;
        SdkSender.d r103 = SdkSender.syncSendMayError(r101, r100, new b(r102));
        if (r103.f439868b == null) goto L16;
        StringBuilder r104 = new StringBuilder("getContactsDoubao error fromLocal=");
        r104.append(r310);
        r104.append(' ');
        ErrorResult r105 = r103.f439868b;
        if (r105 == null) goto L14;
        String r106 = r105.getMessage();
    L15:
        r104.append(r106);
        Log.i("FlowGroupCreateContactRepository", r104.toString());
        goto L16
    L14:
        r106 = null;
    L16:
        GetContactsDoubaoWithDeniedReasonResponse r107 = (GetContactsDoubaoWithDeniedReasonResponse) r103.f439867a;
        if (r107 == null) goto L19;
        List<ContactProfile> r108 = r107.contacts;
    L20:
        List<ContactProfile> r109 = r108;
        boolean r110 = true;
        if (r109 != null) goto L23;
    L26:
        boolean r111 = true;
    L27:
        if (r111 == false) goto L29;
        Log.i("FlowGroupCreateContactRepository", "getContactsDoubao empty fromLocal=" + r310);
        return new Pair(CollectionsKt.emptyList(), r103.f439868b);
    L29:
        Log.i("FlowGroupCreateContactRepository", "getContactsDoubao success fromLocal=" + r310 + " count=" + r108.size());
        ArrayList r112 = new ArrayList();
        Iterator r113 = r108.iterator();
    L31:
        if (r113.hasNext() == false) goto L68;
        ContactProfile r114 = (ContactProfile) r113.next();
        int r115 = a.f422041o;
        if (r107 == null) goto L35;
        Map<Long, DeniedReason> r116 = r107.id2denied_reason;
    L36:
        if (r107 == null) goto L38;
        List<Long> r117 = r107.in_chat_chatter_ids;
    L39:
        Intrinsics.checkNotNullParameter(r114, "contactProfile");
        if (r116 != null) goto L42;
    L45:
        boolean r118 = true;
    L46:
        if (r118 == true) goto L54;
        Long r119 = r114.feishu_user_id;
        if (r119 == null) goto L54;
        if (r116.containsKey(r119) == false) goto L54;
        DeniedReason r120 = r116.get(r119);
    L55:
        if (r117 != null) goto L57;
    L59:
        boolean r210 = false;
    L60:
        long r121 = r114.feishu_user_id.longValue();
        long r122 = r114.db_user_id.longValue();
        String r123 = r114.name;
        String r124 = r114.alias;
        String r125 = r114.display_name;
        String r126 = r114.display_name_pinyin;
        String r127 = r114.avatar_key;
        String r128 = r114.doubao_key;
        boolean r211 = r114.is_b_user.booleanValue();
        boolean r212 = r114.is_contact_deleted.booleanValue();
        boolean r213 = r114.is_resigned.booleanValue();
        UserRelation r129 = r114.relation;
        if (r129 == null) goto L63;
        int r130 = e.f422059f;
        Intrinsics.checkNotNullParameter(r129, "relation");
        e r214 = new e(r129.is_friend.booleanValue(), r129.request_user_apply.booleanValue(), r129.request_user_apply_id.longValue(), r129.request_user_apply_reason, r129.target_user_apply.booleanValue());
    L64:
        if (r120 != null) goto L66;
        List r215 = null;
    L67:
        r112.add(new a(r121, r122, r123, r124, r125, r126, r127, r128, r211, r212, r210, r213, r214, r215));
        r113 = r113;
        r110 = true;
        goto L31
    L66:
        r215 = CollectionsKt.listOf(r120);
        goto L67
    L63:
        r214 = null;
        goto L64
    L57:
        if (r117.contains(r114.feishu_user_id) != r110) goto L59;
        r210 = true;
    L54:
        r120 = null;
        goto L55
    L42:
        if (r116.isEmpty() == true) goto L45;
        r118 = false;
        goto L46
    L38:
        r117 = null;
        goto L39
    L35:
        r116 = null;
        goto L36
    L68:
        Intrinsics.checkNotNullParameter(r112, "contactList");
        CollectionsKt.sortWith(r112, c.f422057a);
        return new Pair(r112, null);
    L23:
        if (r109.isEmpty() == true) goto L26;
        r111 = false;
        goto L27
    L19:
        r108 = null;
        goto L20
    L5:
        r100.strategy(SyncDataStrategy.FORCE_SERVER);
        goto L6
    }
}
