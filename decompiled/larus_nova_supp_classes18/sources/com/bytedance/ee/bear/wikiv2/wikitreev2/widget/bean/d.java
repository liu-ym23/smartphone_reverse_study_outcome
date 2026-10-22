package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean;

import android.text.TextUtils;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DefaultDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import oj5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static final WikiInfo b(TreeNode r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        WikiInfo r0 = new WikiInfo();
        ((Result) r0).code = 0;
        r0.setSpaceId(r3.space_id);
        r0.setObjType(r3.obj_type);
        r0.setObjToken(r3.obj_token);
        r0.setWikiToken(r3.wiki_token);
        r0.setInSpace(false);
        return r0;
    }

    public static final WikiInfo c(WikiHomePageV2 r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        WikiInfo r0 = new WikiInfo();
        ((Result) r0).code = 0;
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r0.setSpaceId(r3);
        r0.setObjType(r2.objType);
        r0.setObjToken(r2.objToken);
        r0.setWikiToken(r2.wikiToken);
        r0.setInSpace(false);
        return r0;
    }

    public static final f a(final TreeNode r55, BenefitStore r56, BenefitStore r57, com.bytedance.ee.bear.more.b r58) {
        Intrinsics.checkNotNullParameter(r55, "<this>");
        Intrinsics.checkNotNullParameter(r56, "userBenefitStore");
        Intrinsics.checkNotNullParameter(r57, "resBenefitStore");
        String r11 = r55.obj_token;
        int r3 = r55.obj_type;
        String r1 = r55.title;
        if (r3 != sbb.e.l.b) goto L5;
        String r2 = com.bytedance.ee.util.io.a.c(r1);
    L6:
        String r21 = r2;
        boolean r4 = r55.isShortcut();
        String r10 = r55.getObjUrl();
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNull(r11);
        f r5 = new f(r3, r10, r11, r55.wiki_token, null, 7160);
        String r8 = r55.getUrl();
        if (TextUtils.isEmpty(r8) == true) goto L9;
        r5.E = r8;
    L9:
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNull(r21);
        DocMetaInfo r9 = new DocMetaInfo(r1, false, null, null, null, null, null, null, r21, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -258, 63, null);
        Intrinsics.checkNotNullParameter(r9, "docMetaInfo");
        r5.g = r9;
        r5.p = r4;
        DocPermission r6 = new DocPermission(new DefaultDocUserPermission(), new WikiInfoConvertKt$toMoreInfo$1(r55));
        Intrinsics.checkNotNullParameter(r6, "docPermission");
        r5.i = r6;
        if (r58 == null) goto L14;
        f r7 = r5;
        Map<String, Boolean> r0 = r58.H(r3, true, r55.isShortcut(), r57, r56);
        if (r0 == null) goto L15;
    L16:
        Intrinsics.checkNotNullParameter(r0, "itemHasBenefitMap");
        r7.J = r0;
        return r7;
    L15:
        r0 = new LinkedHashMap();
        goto L16
    L14:
        r7 = r5;
        goto L15
    L5:
        r2 = "";
        goto L6
    }
}
