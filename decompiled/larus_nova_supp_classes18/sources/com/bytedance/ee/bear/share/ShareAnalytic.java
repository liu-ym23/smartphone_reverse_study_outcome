package com.bytedance.ee.bear.share;

import android.os.RemoteException;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class ShareAnalytic {
    public static final String[] a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    static {
        a = new String[]{"share", "click_add_collaborate", "click_invite_search_bar", "click_collaborate_inviter_next_step", "click_select_perm_inviter", "click_alter_collaborate_perm", "click_send_invite_btn"};
        b = LazyKt.lazy(ShareAnalytic$analyticService$2.INSTANCE);
        c = LazyKt.lazy(ShareAnalytic$accountService$2.INSTANCE);
    }

    @JvmStatic
    public static final void a(com.bytedance.ee.bear.share.export.f r5, String r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r6, "eventName");
        HashMap r0 = new HashMap();
        if (r7 == null) goto L5;
        r0.putAll(r7);
    L5:
        if (r5 == null) goto L28;
        boolean r1 = false;
        if (r5.h().length() != 0) goto L9;
        boolean r8 = true;
    L10:
        if (r8 == false) goto L12;
        String r9 = "0";
    L13:
        r0.put("is_owner", String.valueOf(r5.isOwner()));
        r0.put("create_uid", du5.b.g(r5.d()));
        r0.put("create_time", r9);
        r0.put("create_date", iu5.e.a(CastLongProtector.parseLong(r9)));
        r0.put("from_create_date", iu5.e.b(CastLongProtector.parseLong(r9)));
        r0.put("file_type", sbb.e.c(r5.getDocType()));
        r0.put("file_id", du5.b.g(r5.getObjToken()));
        if (ArraysKt.contains(a, r6) == false) goto L28;
        if (r5.a().length() != 0) goto L18;
        r1 = true;
    L18:
        if (r1 == false) goto L20;
        String r10 = "";
    L21:
        r0.put("file_tenant_id", r10);
        AccountService.Account r11 = ((h0) c.getValue()).G2();
        if (r11 == null) goto L28;
        r0.put("file_is_cross_tenant", String.valueOf(!Intrinsics.areEqual(r11.tenantId, r5.a())));
        goto L28
    L20:
        r10 = du5.b.g(r5.a());
        goto L21
    L12:
        r9 = r5.h();
        goto L13
    L9:
        r8 = false;
    L28:
        ((com.bytedance.ee.bear.contract.d) b.getValue()).v(r6, r0);     // Catch: RemoteException -> L26
        return;
    L26:
        tt5.a.d("ShareAnalytic", r6.concat(" report error"));
    }

    @JvmStatic
    public static final void b(com.bytedance.ee.bear.share.export.f r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "toPlatform");
        HashMap r0 = new HashMap();
        String r1 = "left_slide";
        if (Intrinsics.areEqual("left_slide", r3) == true) goto L6;
        r1 = "docs_pages";
    L6:
        r0.put("source", r1);
        if (r2 == null) goto L9;
        String r6 = "docs";
    L10:
        r0.put("module", r6);
        r0.put("to_platform", r4);
        if (r5 == null) goto L13;
        r0.put("relegated_flag", r5);
    L13:
        if (r2 != null) goto L15;
    L28:
        tt5.a.h("ShareAnalytic", "report share action, " + r0);
        a(r2, "share", r0);
        return;
    L15:
        if (r2.isLinkShareAnyoneEdit() == false) goto L18;
        String r7 = "anyone_with_link_can_edit";
    L27:
        r0.put("permission_type", r7);
        goto L28
    L18:
        if (r2.isLinkShareAnyoneRead() == false) goto L21;
        r7 = "anyone_with_link_can_view";
        goto L27
    L21:
        if (r2.isLinkShareInternalEdit() == false) goto L24;
        r7 = "colleagues_with_link_can_edit";
        goto L27
    L24:
        if (r2.isLinkShareInternalRead() == false) goto L26;
        r7 = "colleagues_with_link_can_view";
        goto L27
    L26:
        r7 = "turn_off_link_sharing";
        goto L27
    L9:
        r6 = DocumentType.FOLDER_NAME;
        goto L10
    }
}
