package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.CreateNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationInsert;
import com.bytedance.ee.util.info.AppInfoUtils;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y1<T, R> implements Function {
    public final /* synthetic */ WikiTreeModel a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ IOperationInsert.TreeNodeInsertParams d;

    public y1(WikiTreeModel r1, String r2, String r3, IOperationInsert.TreeNodeInsertParams r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object apply(Object r9) {
        up5.b r10 = (up5.b) r9;
        Intrinsics.checkNotNullParameter(r10, "parent");
        if (r10.b() == true) goto L5;
        e3 r0 = this.a.workspace;
        TreeNode r11 = (TreeNode) r10.a();
        ((ConcurrentHashMap) r0.g).put(r11.wiki_token, r11);
    L5:
        String r3 = this.b;
        String r4 = this.c;
        IOperationInsert.TreeNodeInsertParams r1 = this.d;
        CreateNodePuller.Params r12 = new CreateNodePuller.Params(r3, r4, r1.title, r1.documentType, this.a.getChainPushUuid(r3));
        IOperationInsert.TreeNodeInsertParams r2 = this.d;
        String r5 = r2.templateToken;
        boolean r6 = false;
        if (r5 != null) goto L8;
    L11:
        boolean r7 = true;
    L12:
        if (r7 == true) goto L14;
        r12.template_token = r2.templateToken;
    L14:
        String r8 = r2.extInfo;
        if (r8 != null) goto L17;
    L18:
        r6 = true;
    L19:
        if (r6 == true) goto L21;
        r12.ext_info_str = r2.extInfo;
    L21:
        Flowable r13 = new CreateNodePuller(this.a.netService).d(r12);
        if (this.d.offlineCreateEnable == false) goto L31;
        boolean r14 = !AppInfoUtils.f().booleanValue();
        if (com.bytedance.ee.bear.list.create.a.a(this.d.documentType) == false) goto L29;
        if (r14 == false) goto L30;
        String r15 = this.b;
        String r16 = this.c;
        IOperationInsert.TreeNodeInsertParams r17 = this.d;
        return com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.h.a(r15, r16, r17.title, r17.documentType, this.a.userComponentAbility);
    L30:
        return r13;
    L29:
        return r13;
    L31:
        return r13;
    L17:
        if (StringsKt.isBlank(r8) == false) goto L19;
    L8:
        if (StringsKt.isBlank(r5) == true) goto L11;
        r7 = false;
        goto L12
    }
}
