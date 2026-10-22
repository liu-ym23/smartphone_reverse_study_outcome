package com.ss.android.lark.contact.base.entity;

import com.bytedance.lark.pb.basic.v1.ContactInfo;
import com.bytedance.lark.pb.basic.v1.ContactOperation;
import com.bytedance.lark.pb.basic.v1.UserInfo;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f418869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f418870b;

    public a() {
    }

    public static a a(ContactInfo r100) {
        c r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        a r102 = new a();
        UserInfo r103 = r100.user_info;
        if (r103 == null) goto L9;
        r101 = new c();
        r101.f418875a = r103.avatar_key;
        r101.f418876b = r103.user_name;
        r101.f418877c = r103.name_py;
        r101.f418878d = r103.tenant_name;
        r103.last_seven_day_online_minutes.intValue();
        r101.f418879e = r103.user_id;
        r101.f418880f = r103.tenant_id;
        r101.f418881g = r103.alias;
        r101.f418882h = r103.description;
        r101.f418883i = r103.agree_time.longValue();
        r101.f418884j = r103.is_special_focus.booleanValue();
        r101.f418885k = r103.name_with_another_name;
        r101.f418886l = r103.tenant_name_status;
        r101.f418887m = r103.certification_info;
    L9:
        r102.f418869a = r101;
        ContactOperation r104 = r100.f253463op;
        if (r104 != ContactOperation.OPERATION_ADD) goto L13;
        int r105 = 1;
    L19:
        r102.f418870b = r105;
        return r102;
    L13:
        if (r104 != ContactOperation.OPERATION_DELETE) goto L16;
        r105 = 2;
        goto L19
    L16:
        if (r104 != ContactOperation.OPERATION_UPDATE) goto L18;
        r105 = 3;
        goto L19
    L18:
        r105 = 0;
        goto L19
    }
}
