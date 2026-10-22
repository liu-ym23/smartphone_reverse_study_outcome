package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.middleground.permission.collaborator.NotNotifyUserEntity;
import com.bytedance.ee.bear.share.export.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f233189a = 0;

    static {
    }

    public static NotNotifyUserEntity f(JSONObject r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        NotNotifyUserEntity r101 = new NotNotifyUserEntity();
        r101.setId(r100.optString("id"));
        r101.setName(r100.optString("name"));
        r101.setCn_name(r100.optString("cn_name"));
        r101.setEn_name(r100.optString("en_name"));
        r101.setEmail(r100.optString("email"));
        r101.setSuid(r100.optString("suid"));
        r101.setAvatar_url(r100.optString("avatar_url"));
        r101.setTenant_name(r100.optString("tenant_name"));
        r101.setTenant_id(r100.optString("tenant_id"));
        return r101;
    }

    public static List a(JSONObject r100, ArrayList r110) {
        Intrinsics.checkNotNullParameter(r100, "failMembersObj");
        Intrinsics.checkNotNullParameter(r110, "selectedUsers");
        ArrayList r101 = new ArrayList();
        JSONArray r102 = r100.optJSONArray(String.valueOf(10027));
        if (r102 != null) goto L5;
    L24:
        return r101;
    L5:
        if (r102.length() <= 0) goto L24;
        int r103 = r102.length();
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L24;
        JSONObject r105 = r102.optJSONObject(r104);
        NotNotifyUserEntity r106 = null;
        if (r105 == null) goto L21;
        NotNotifyUserEntity r107 = new NotNotifyUserEntity();
        r107.setId(r105.optString("owner_id"));
        r107.setOwnerType(r105.optInt("owner_type"));
        r107.setPermission(r105.optInt("permission"));
        String r108 = r107.getId();
        Iterator r109 = r110.iterator();
    L13:
        if (r109.hasNext() == false) goto L17;
        UserInfo r111 = (UserInfo) r109.next();
        if (TextUtils.equals(r108, r111.getId()) == false) goto L13;
    L18:
        if (r111 != null) goto L20;
        tt5.a.k("BlockUserParser", "getMemberById()... not found");
        goto L21
    L20:
        r107.setName(r111.getName(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a()));
        r107.setCn_name(r111.getCnName());
        r107.setAvatar_url(r111.getAvatarUrl());
        r107.setTenant_id(r111.getTenantId());
        r107.setTenant_name(r111.getTenantName());
        r106 = r107;
        goto L21
    L17:
        r111 = null;
    L21:
        if (r106 == null) goto L23;
        r101.add(r106);
    L23:
        r104 = r104 + 1;
        goto L7
    }

    @JvmStatic
    public static final ArrayList<NotNotifyUserEntity> c(int r100, JSONObject r101) {
        ArrayList<NotNotifyUserEntity> r102 = new ArrayList();
        if (r101 == null) goto L5;
        JSONArray r103 = r101.optJSONArray(String.valueOf(r100));
    L6:
        if (r103 != null) goto L8;
    L10:
        return r102;
    L8:
        if (r103.length() <= 0) goto L10;
        r102.add(new NotNotifyUserEntity());
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @JvmStatic
    public static final int e(int r100, JSONObject r101) {
        Iterator<String> r102 = r101.keys();
    L4:
        if (r102 == null) goto L8;
        boolean r103 = true;
        if (r102.hasNext() != true) goto L8;
    L9:
        if (r103 == false) goto L13;
        if (r101.optInt(r102.next()) != r100) goto L4;
        return r100;
    L13:
        return 0;
    L8:
        r103 = false;
        goto L9
    }

    @JvmStatic
    public static final ArrayList<NotNotifyUserEntity> b(int r100, JSONObject r101, JSONObject r102) {
        ArrayList<NotNotifyUserEntity> r103 = new ArrayList();
        if (r101 == null) goto L5;
        Iterator<String> r104 = r101.keys();
    L6:
        if (r104 == null) goto L10;
        boolean r105 = true;
        if (r104.hasNext() != true) goto L10;
    L11:
        if (r105 == false) goto L20;
        String r106 = r104.next();
        if (r101.optInt(r106) != r100) goto L6;
        if (r102 == null) goto L16;
        JSONObject r107 = r102.optJSONObject(r106);
    L17:
        NotNotifyUserEntity r108 = f(r107);
        if (r108 == null) goto L6;
        r103.add(r108);
        goto L6
    L16:
        r107 = null;
        goto L17
    L20:
        return r103;
    L10:
        r105 = false;
        goto L11
    L5:
        r104 = null;
        goto L6
    }

    @JvmStatic
    public static final ArrayList<NotNotifyUserEntity> d(int r100, JSONObject r101, JSONObject r102) {
        ArrayList<NotNotifyUserEntity> r103 = new ArrayList();
        if (r101 == null) goto L5;
        JSONArray r104 = r101.optJSONArray(String.valueOf(r100));
    L6:
        if (r104 != null) goto L8;
    L20:
        return r103;
    L8:
        if (r104.length() <= 0) goto L20;
        int r105 = r104.length();
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L20;
        String r107 = r104.optString(r106);
        if (TextUtils.isEmpty(r107) == true) goto L19;
        if (r102 == null) goto L15;
        JSONObject r108 = r102.optJSONObject(r107);
    L16:
        NotNotifyUserEntity r109 = f(r108);
        if (r109 == null) goto L19;
        r103.add(r109);
        goto L19
    L15:
        r108 = null;
    L19:
        r106 = r106 + 1;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
