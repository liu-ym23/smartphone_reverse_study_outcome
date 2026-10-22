package com.bytedance.android.shopping.router;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.l;
import com.bytedance.android.shopping.commentfeed.model.CommentDetailParams;
import com.bytedance.android.shopping.commentfeed.view.CommentDetailActivity;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements bf.c {
    public b() {
    }

    public final void a() {
    }

    public final String b() {
        return "ec_comment_detail";
    }

    public final boolean c(Context r13, Uri r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "uri");
        int r0 = ac3.a.a;
        String r16 = r14.toString();
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r16, "url");
        Uri r17 = UriProtector.parse(r16);
        String r1 = UriProtector.getQueryParameter(r17, PdpOpenThirdParam.KEY_PRODUCT_ID);
        if (r1 != null) goto L5;
        String r4 = "";
    L6:
        String r3 = UriProtector.getQueryParameter(r17, "comment_id");
        if (r3 != null) goto L9;
        String r5 = "";
    L10:
        String r6 = UriProtector.getQueryParameter(r17, "comment_cursor");
        if (r6 == null) goto L13;
        long r7 = CastLongProtector.parseLong(r6);
    L14:
        String r8 = UriProtector.getQueryParameter(r17, "comment_entrance");
        if (r8 != null) goto L17;
        r8 = "";
    L17:
        List r2 = CollectionsKt.mutableListOf(new l.a[]{new l.a(PdpOpenThirdParam.KEY_PRODUCT_ID, "presence"), new l.a("comment_id", "presence")});
        JSONObject r9 = new JSONObject();
        r9.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r4);
        r9.put("comment_entrance", r8);
        int r10 = l.a;
        l.b(r17.toString(), "show_comment_detail_page", r9, r2);
        if (TextUtils.isEmpty(r4) == false) goto L20;
    L25:
        return true;
    L20:
        if (TextUtils.isEmpty(r5) == true) goto L25;
        if (r7 < 0) goto L25;
        CommentDetailParams r18 = new CommentDetailParams(r4, r5, r7, r8);
        int r11 = CommentDetailActivity.k;
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r18, "param");
        Intent r19 = new Intent(r13, CommentDetailActivity.class);
        r19.putExtra("comment_detail", r18);
        Unit r110 = Unit.INSTANCE;
        r13.startActivity(r19);
        goto L25
    L13:
        r7 = -1;
        goto L14
    L9:
        r5 = r3;
        goto L10
    L5:
        r4 = r1;
        goto L6
    }
}
