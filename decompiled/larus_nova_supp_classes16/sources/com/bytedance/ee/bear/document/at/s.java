package com.bytedance.ee.bear.document.at;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ee.bear.at.MentionData;
import com.bytedance.ee.bear.at.MentionTitleResult;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.functions.Function;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s<T, R> implements Function {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ BearUrl c;

    public s(String r1, String r2, BearUrl r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object apply(Object r5) {
        MentionTitleResultExecutor.BatchMentionTitleResult r6 = (MentionTitleResultExecutor.BatchMentionTitleResult) r5;
        Intrinsics.checkNotNullParameter(r6, "batchMentionTitleResult");
        if (((Map) r6.data).get(this.a) == null) goto L29;
        MentionData r0 = (MentionData) ((Map) r6.data).get(this.a);
        String r1 = null;
        if (r0 == null) goto L28;
        String r2 = this.b;
        MentionData r3 = (MentionData) ((HashMap) r6.data).get(r2);
        if (r3 == null) goto L9;
        String r4 = r3.title;
    L11:
        if (TextUtils.isEmpty(r4) == false) goto L17;
        Application r7 = LarkContext.getApplication();
        MentionData r8 = (MentionData) ((HashMap) r6.data).get(r2);
        if (r8 == null) goto L15;
        int r9 = r8.type;
    L16:
        r1 = sbb.e.a(r7, r9);
    L21:
        if (TextUtils.isEmpty(r0.title) == false) goto L26;
        Map<String, Integer> r10 = MentionTitleResultExecutor.a;
        if (r0.type != 38) goto L25;
        String r11 = LarkContext.getApplication().getResources().getString(2131889349);
    L27:
        r0.title = r1 + " > " + r11;
    L30:
        MentionTitleResult r12 = new MentionTitleResult();
        BearUrl r13 = this.c;
        r12.code = r6.code;
        r12.msg = r6.msg;
        r12.data = MentionTitleResultExecutor.a(r13, r0);
        return r12;
    L25:
        r11 = "";
        goto L27
    L26:
        r11 = r0.title;
        goto L27
    L15:
        r9 = -1;
        goto L16
    L17:
        MentionData r14 = (MentionData) ((HashMap) r6.data).get(r2);
        if (r14 == null) goto L21;
        r1 = r14.title;
        goto L21
    L9:
        r4 = null;
        goto L11
    L28:
        r0 = null;
        goto L30
    L29:
        r0 = (MentionData) ((HashMap) r6.data).get(this.b);
        goto L30
    }
}
