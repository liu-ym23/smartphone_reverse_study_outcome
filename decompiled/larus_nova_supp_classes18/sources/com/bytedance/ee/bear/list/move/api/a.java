package com.bytedance.ee.bear.list.move.api;

import android.app.Application;
import android.content.res.Resources;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.net.DefaultResponse;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.move.api.a$a, reason: collision with other inner class name */
    public static final class C0024a<T, R> implements Function {
        public final /* synthetic */ String a;
        public final /* synthetic */ Integer b;
        public final /* synthetic */ boolean c;

        public C0024a(String r1, Integer r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object apply(Object r11) {
            DefaultResponse r12 = (DefaultResponse) r11;
            Intrinsics.checkNotNullParameter(r12, "it");
            JSONObject r13 = JSONObjectProtectorUtils.getJSONObject(new JSONObject((String) ((Result) r12).data), WikiFolderPushPlugin.DATA);
            int r0 = JSONObjectProtectorUtils.getInt(r13, "link_share_entity");
            int r1 = JSONObjectProtectorUtils.getInt(r13, "link_share_source");
            if (r13.optInt("show_alert", 2) != 2) goto L5;
            boolean r14 = true;
        L6:
            String r5 = this.a;
            String r6 = "";
            if (r5 != null) goto L10;
            r5 = "";
        L10:
            if (r5.length() <= 100) goto L16;
            StringBuilder r7 = new StringBuilder();
            String r8 = this.a;
            if (r8 == null) goto L14;
            String r9 = r8.substring(0, 100);
        L15:
            r7.append(r9);
            r7.append("...");
            String r10 = r7.toString();
        L19:
            tt5.a.h("MoveNodeHintPuller", "pullMoveNodeHint... success, link_share_entity = " + r0 + ", link_share_source = " + r1 + ", show_alert = " + r14);
            if (r14 == false) goto L24;
            if (r1 == 1) goto L24;
            if (r1 == 2) goto L24;
            String r2 = a.a(this.a, this.b);
        L51:
            return new Pair(Boolean.valueOf(r14), r2);
        L24:
            if (r1 != 1) goto L26;
            int r3 = 2131888800;
        L27:
            Application r15 = eu5.b.a;
            Pair[] r16 = new Pair[3];
            if (TextUtils.isEmpty(r10) == false) goto L32;
            Integer r17 = this.b;
            if (r17 == null) goto L32;
            r6 = sbb.e.a(eu5.b.a, r17.intValue());
        L35:
            r16[0] = TuplesKt.to("parentnode", r6);
            Resources r4 = eu5.b.a.getResources();
            if (this.c == false) goto L38;
            int r18 = 2131887757;
        L39:
            r16[1] = TuplesKt.to(DocumentType.DOC_NAME, r4.getString(r18));
            int r19 = a.a;
            Resources r20 = eu5.b.a.getResources();
            switch(r0) {
                case 2: goto L47;
                case 3: goto L46;
                case 4: goto L45;
                case 5: goto L44;
                case 6: goto L43;
                case 7: goto L42;
                default: goto L48;
            };
        L42:
            int r21 = 2131888774;
        L49:
            r16[2] = TuplesKt.to("perm", r20.getString(r21));
            r2 = xo5.a.d(r15, r3, MapsKt.mapOf(r16));
            goto L51
        L43:
            r21 = 2131888776;
            goto L49
        L44:
            r21 = 2131888763;
            goto L49
        L45:
            r21 = 2131888765;
            goto L49
        L46:
            r21 = 2131888769;
            goto L49
        L47:
            r21 = 2131888772;
            goto L49
        L48:
            r21 = 2131888768;
            goto L49
        L38:
            r18 = 2131887745;
        L32:
            if (r10 == null) goto L35;
            r6 = r10;
            goto L35
        L26:
            r3 = 2131888799;
            goto L27
        L14:
            r9 = null;
            goto L15
        L16:
            r10 = this.a;
            if (r10 != null) goto L19;
            r10 = "";
            goto L19
        L5:
            r14 = false;
            goto L6
        }
    }

    static {
    }

    @JvmStatic
    public static final String a(String r4, Integer r5) {
        Application r0 = eu5.b.a;
        if (r4 != null) goto L5;
        String r2 = "";
    L7:
        if (r2.length() <= 100) goto L12;
        if (r4 == null) goto L10;
        r4 = r4.substring(0, 100);
    L18:
        return xo5.a.c(r0, 2131888801, "parentnode", r4);
    L10:
        r4 = null;
        goto L18
    L12:
        if (TextUtils.isEmpty(r4) == false) goto L15;
        if (r5 == null) goto L15;
        r4 = sbb.e.a(eu5.b.a, r5.intValue());
    L15:
        if (r4 != null) goto L18;
        r4 = "";
        goto L18
    L5:
        r2 = r4;
        goto L7
    }

    @JvmStatic
    public static final Flowable<Pair<Boolean, String>> b(NetService r4, String r5, Integer r6, boolean r7, String r8, Integer r9, String r10) {
        Intrinsics.checkNotNullParameter(r4, "netService");
        NetService.f r0 = new NetService.f("/space/api/suite/permission/move_node_hint/");
        ((NetService.e) r0).c = 1;
        r0.d(MapsKt.mapOf(new Pair[]{TuplesKt.to("src_token", r5), TuplesKt.to("src_type", String.valueOf(r6)), TuplesKt.to("dest_token", r8), TuplesKt.to("dest_type", String.valueOf(r9))}));
        return r4.Vc(new ax4.a()).a(r0).map(new C0024a(r10, r9, r7));
    }
}
