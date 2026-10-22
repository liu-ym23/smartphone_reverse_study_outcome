package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.middleground.permission.collaborator.NotNotifyUserEntity;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static NotNotifyUserEntity f(JSONObject r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        NotNotifyUserEntity r0 = new NotNotifyUserEntity();
        r0.setId(r2.optString(ResourceData.KEY_ID));
        r0.setName(r2.optString("name"));
        r0.setCn_name(r2.optString("cn_name"));
        r0.setEn_name(r2.optString("en_name"));
        r0.setEmail(r2.optString("email"));
        r0.setSuid(r2.optString("suid"));
        r0.setAvatar_url(r2.optString("avatar_url"));
        r0.setTenant_name(r2.optString("tenant_name"));
        r0.setTenant_id(r2.optString("tenant_id"));
        return r0;
    }

    public static List a(JSONObject r9, ArrayList r10) {
        Intrinsics.checkNotNullParameter(r9, "failMembersObj");
        Intrinsics.checkNotNullParameter(r10, "selectedUsers");
        ArrayList r0 = new ArrayList();
        JSONArray r11 = r9.optJSONArray(String.valueOf(10027));
        if (r11 != null) goto L5;
    L24:
        return r0;
    L5:
        if (r11.length() <= 0) goto L24;
        int r1 = r11.length();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L24;
        JSONObject r3 = r11.optJSONObject(r2);
        NotNotifyUserEntity r4 = null;
        if (r3 == null) goto L21;
        NotNotifyUserEntity r5 = new NotNotifyUserEntity();
        r5.setId(r3.optString("owner_id"));
        r5.setOwnerType(r3.optInt("owner_type"));
        r5.setPermission(r3.optInt("permission"));
        String r6 = r5.getId();
        Iterator r7 = r10.iterator();
    L13:
        if (r7.hasNext() == false) goto L17;
        UserInfo r8 = (UserInfo) r7.next();
        if (TextUtils.equals(r6, r8.getId()) == false) goto L13;
    L18:
        if (r8 != null) goto L20;
        tt5.a.k("BlockUserParser", "getMemberById()... not found");
        goto L21
    L20:
        r5.setName(r8.getName(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a()));
        r5.setCn_name(r8.getCnName());
        r5.setAvatar_url(r8.getAvatarUrl());
        r5.setTenant_id(r8.getTenantId());
        r5.setTenant_name(r8.getTenantName());
        r4 = r5;
        goto L21
    L17:
        r8 = null;
    L21:
        if (r4 == null) goto L23;
        r0.add(r4);
    L23:
        r2 = r2 + 1;
        goto L7
    }

    @JvmStatic
    public static final ArrayList<NotNotifyUserEntity> c(int r1, JSONObject r2) {
        ArrayList<NotNotifyUserEntity> r0 = new ArrayList();
        if (r2 == null) goto L5;
        JSONArray r3 = r2.optJSONArray(String.valueOf(r1));
    L6:
        if (r3 != null) goto L8;
    L10:
        return r0;
    L8:
        if (r3.length() <= 0) goto L10;
        r0.add(new NotNotifyUserEntity());
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    @JvmStatic
    public static final int e(int r4, JSONObject r5) {
        Iterator<String> r0 = r5.keys();
    L4:
        if (r0 == null) goto L8;
        boolean r3 = true;
        if (r0.hasNext() != true) goto L8;
    L9:
        if (r3 == false) goto L13;
        if (r5.optInt(r0.next()) != r4) goto L4;
        return r4;
    L13:
        return 0;
    L8:
        r3 = false;
        goto L9
    }

    @JvmStatic
    public static final ArrayList<NotNotifyUserEntity> b(int r5, JSONObject r6, JSONObject r7) {
        ArrayList<NotNotifyUserEntity> r0 = new ArrayList();
        if (r6 == null) goto L5;
        Iterator<String> r2 = r6.keys();
    L6:
        if (r2 == null) goto L10;
        boolean r4 = true;
        if (r2.hasNext() != true) goto L10;
    L11:
        if (r4 == false) goto L20;
        String r3 = r2.next();
        if (r6.optInt(r3) != r5) goto L6;
        if (r7 == null) goto L16;
        JSONObject r8 = r7.optJSONObject(r3);
    L17:
        NotNotifyUserEntity r9 = f(r8);
        if (r9 == null) goto L6;
        r0.add(r9);
        goto L6
    L16:
        r8 = null;
        goto L17
    L20:
        return r0;
    L10:
        r4 = false;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    @JvmStatic
    public static final ArrayList<NotNotifyUserEntity> d(int r5, JSONObject r6, JSONObject r7) {
        ArrayList<NotNotifyUserEntity> r0 = new ArrayList();
        if (r6 == null) goto L5;
        JSONArray r8 = r6.optJSONArray(String.valueOf(r5));
    L6:
        if (r8 != null) goto L8;
    L20:
        return r0;
    L8:
        if (r8.length() <= 0) goto L20;
        int r9 = r8.length();
        int r2 = 0;
    L10:
        if (r2 >= r9) goto L20;
        String r3 = r8.optString(r2);
        if (TextUtils.isEmpty(r3) == true) goto L19;
        if (r7 == null) goto L15;
        JSONObject r4 = r7.optJSONObject(r3);
    L16:
        NotNotifyUserEntity r10 = f(r4);
        if (r10 == null) goto L19;
        r0.add(r10);
        goto L19
    L15:
        r4 = null;
    L19:
        r2 = r2 + 1;
        goto L10
    L5:
        r8 = null;
        goto L6
    }
}
