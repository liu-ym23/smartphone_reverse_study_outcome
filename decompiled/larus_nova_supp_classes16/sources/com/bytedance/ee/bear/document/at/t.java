package com.bytedance.ee.bear.document.at;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ee.bear.at.MentionData;
import com.bytedance.ee.bear.at.MentionTitleResultList;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t<T, R> implements Function {
    public final /* synthetic */ List<BearUrl> a;

    /* JADX WARN: Multi-variable type inference failed */
    public t(List<? extends BearUrl> r1) {
        this.a = r1;
    }

    public final Object apply(Object r10) {
        MentionTitleResultExecutor.BatchMentionTitleResult r11 = (MentionTitleResultExecutor.BatchMentionTitleResult) r10;
        Intrinsics.checkNotNullParameter(r11, "batchMentionTitleResult");
        List<BearUrl> r0 = this.a;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L51;
        BearUrl r3 = (BearUrl) r2.next();
        String r4 = r3.b;
        boolean r5 = false;
        if (r4 != null) goto L8;
    L11:
        boolean r6 = true;
    L12:
        String r7 = null;
        if (r6 == true) goto L50;
        if (((HashMap) r11.data).containsKey(r4) == false) goto L50;
        String r8 = r3.d.get("blockToken");
        if (r8 != null) goto L20;
    L48:
        r7 = (MentionData) ((HashMap) r11.data).get(r4);
    L49:
        r7 = MentionTitleResultExecutor.a(r3, r7);
        goto L50
    L20:
        if (((HashMap) r11.data).containsKey(r8) == false) goto L48;
        String r9 = (MentionData) ((HashMap) r11.data).get(r8);
        if (r9 == null) goto L49;
        MentionData r12 = (MentionData) ((HashMap) r11.data).get(r4);
        if (r12 == null) goto L26;
        String r13 = r12.title;
    L28:
        if (TextUtils.isEmpty(r13) == false) goto L34;
        Application r14 = LarkContext.getApplication();
        if (r12 == null) goto L32;
        int r16 = r12.type;
    L33:
        r7 = sbb.e.a(r14, r16);
    L36:
        String r17 = ((MentionData) r9).title;
        if (r17 != null) goto L39;
    L40:
        r5 = true;
    L41:
        if (r5 == false) goto L46;
        Map<String, Integer> r18 = MentionTitleResultExecutor.a;
        if (((MentionData) r9).type != 38) goto L45;
        String r19 = LarkContext.getApplication().getResources().getString(2131889349);
    L47:
        ((MentionData) r9).title = r7 + " > " + r19;
        r7 = r9;
        goto L49
    L45:
        r19 = "";
        goto L47
    L46:
        r19 = ((MentionData) r9).title;
        goto L47
    L39:
        if (r17.length() != 0) goto L41;
    L32:
        r16 = -1;
        goto L33
    L34:
        if (r12 == null) goto L36;
        r7 = r12.title;
        goto L36
    L26:
        r13 = null;
    L50:
        r1.add(r7);
        goto L4
    L8:
        if (r4.length() == 0) goto L11;
        r6 = false;
        goto L12
    L51:
        ArrayList r20 = (ArrayList) CollectionsKt.toCollection(r1, new ArrayList());
        MentionTitleResultList r21 = new MentionTitleResultList();
        r21.code = r11.code;
        r21.msg = r11.msg;
        r21.data = r20;
        return r21;
    }
}
