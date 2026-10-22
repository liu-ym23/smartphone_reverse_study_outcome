package com.ss.android.lark.contact.base.service;

import com.bytedance.lark.pb.basic.v1.ContactInfo;
import com.bytedance.lark.pb.contact.v2.GetExternalContactListResponse;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.sdk.SdkSender;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes35.dex */
public final class e<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<T> f418920a = null;

    static {
        f418920a = new e();
    }

    public e() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        GetExternalContactListResponse r101 = GetExternalContactListResponse.ADAPTER.decode(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        com.ss.android.lark.contact.base.entity.b r102 = new com.ss.android.lark.contact.base.entity.b();
        ArrayList r103 = new ArrayList();
        if (r101.contacts == null) goto L14;
        int r104 = 0;
    L9:
        if (r104 >= r101.contacts.size()) goto L14;
        com.ss.android.lark.contact.base.entity.a r105 = com.ss.android.lark.contact.base.entity.a.a((ContactInfo) ListProtector.get(r101.contacts, r104));
        if (r105 == null) goto L13;
        r103.add(r105);
    L13:
        r104 = r104 + 1;
    L14:
        r102.f418872a = r103;
        r101.has_more.booleanValue();
        return r102;
    }
}
