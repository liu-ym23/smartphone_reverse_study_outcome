package com.bytedance.ee.bear.share;

import android.os.RemoteException;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class ShareAnalytic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f236994a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f236995b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f236996c = null;

    static {
        f236994a = new String[]{"share", "click_add_collaborate", "click_invite_search_bar", "click_collaborate_inviter_next_step", "click_select_perm_inviter", "click_alter_collaborate_perm", "click_send_invite_btn"};
        f236995b = LazyKt.lazy(ShareAnalytic$analyticService$2.INSTANCE);
        f236996c = LazyKt.lazy(ShareAnalytic$accountService$2.INSTANCE);
    }

    @JvmStatic
    public static final void a(com.bytedance.ee.bear.share.export.f r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r101, "eventName");
        HashMap r103 = new HashMap();
        if (r102 == null) goto L5;
        r103.putAll(r102);
    L5:
        if (r100 == null) goto L28;
        boolean r104 = false;
        if (r100.h().length() != 0) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L12;
        String r106 = "0";
    L13:
        r103.put("is_owner", String.valueOf(r100.isOwner()));
        r103.put("create_uid", du5.b.g(r100.d()));
        r103.put("create_time", r106);
        r103.put("create_date", iu5.e.a(CastLongProtector.parseLong(r106)));
        r103.put("from_create_date", iu5.e.b(CastLongProtector.parseLong(r106)));
        r103.put("file_type", sbb.e.c(r100.getDocType()));
        r103.put("file_id", du5.b.g(r100.getObjToken()));
        if (ArraysKt.contains(f236994a, r101) == false) goto L28;
        if (r100.a().length() != 0) goto L18;
        r104 = true;
    L18:
        if (r104 == false) goto L20;
        String r107 = "";
    L21:
        r103.put("file_tenant_id", r107);
        AccountService$Account r108 = ((h0) f236996c.getValue()).G2();
        if (r108 == null) goto L28;
        r103.put("file_is_cross_tenant", String.valueOf(!Intrinsics.areEqual(r108.tenantId, r100.a())));
        goto L28
    L20:
        r107 = du5.b.g(r100.a());
        goto L21
    L12:
        r106 = r100.h();
        goto L13
    L9:
        r105 = false;
    L28:
        ((com.bytedance.ee.bear.contract.d) f236995b.getValue()).v(r101, r103);     // Catch: RemoteException -> L26
        return;
    L26:
        tt5.a.d("ShareAnalytic", r101.concat(" report error"));
    }

    @JvmStatic
    public static final void b(com.bytedance.ee.bear.share.export.f r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "toPlatform");
        HashMap r104 = new HashMap();
        String r105 = "left_slide";
        if (Intrinsics.areEqual("left_slide", r101) == true) goto L6;
        r105 = "docs_pages";
    L6:
        r104.put("source", r105);
        if (r100 == null) goto L9;
        String r106 = "docs";
    L10:
        r104.put(EventConstant.Key.MODULE, r106);
        r104.put("to_platform", r102);
        if (r103 == null) goto L13;
        r104.put("relegated_flag", r103);
    L13:
        if (r100 != null) goto L15;
    L28:
        tt5.a.h("ShareAnalytic", "report share action, " + r104);
        a(r100, "share", r104);
        return;
    L15:
        if (r100.isLinkShareAnyoneEdit() == false) goto L18;
        String r107 = "anyone_with_link_can_edit";
    L27:
        r104.put("permission_type", r107);
        goto L28
    L18:
        if (r100.isLinkShareAnyoneRead() == false) goto L21;
        r107 = "anyone_with_link_can_view";
        goto L27
    L21:
        if (r100.isLinkShareInternalEdit() == false) goto L24;
        r107 = "colleagues_with_link_can_edit";
        goto L27
    L24:
        if (r100.isLinkShareInternalRead() == false) goto L26;
        r107 = "colleagues_with_link_can_view";
        goto L27
    L26:
        r107 = "turn_off_link_sharing";
        goto L27
    L9:
        r106 = DocumentType.FOLDER_NAME;
        goto L10
    }
}
