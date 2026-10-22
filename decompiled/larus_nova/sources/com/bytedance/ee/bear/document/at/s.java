package com.bytedance.ee.bear.document.at;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ee.bear.at.MentionData;
import com.bytedance.ee.bear.at.MentionTitleResult;
import com.bytedance.ee.bear.domain.BearUrl;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.functions.Function;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class s<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f219119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f219120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BearUrl f219121c;

    public s(String r100, String r101, BearUrl r102) {
        this.f219119a = r100;
        this.f219120b = r101;
        this.f219121c = r102;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        MentionTitleResultExecutor.BatchMentionTitleResult r101 = (MentionTitleResultExecutor.BatchMentionTitleResult) r100;
        Intrinsics.checkNotNullParameter(r101, "batchMentionTitleResult");
        if (((Map) r101.data).get(this.f219119a) == null) goto L29;
        MentionData r102 = (MentionData) ((Map) r101.data).get(this.f219119a);
        String r103 = null;
        if (r102 == null) goto L28;
        String r104 = this.f219120b;
        MentionData r105 = (MentionData) ((HashMap) r101.data).get(r104);
        if (r105 == null) goto L9;
        String r106 = r105.title;
    L11:
        if (TextUtils.isEmpty(r106) == false) goto L17;
        Application r107 = LarkContext.getApplication();
        MentionData r108 = (MentionData) ((HashMap) r101.data).get(r104);
        if (r108 == null) goto L15;
        int r109 = r108.type;
    L16:
        r103 = sbb.e.a(r107, r109);
    L21:
        if (TextUtils.isEmpty(r102.title) == false) goto L26;
        Map<String, Integer> r110 = MentionTitleResultExecutor.f219086a;
        if (r102.type != 38) goto L25;
        String r111 = LarkContext.getApplication().getResources().getString(R.string.LarkCCM_Docx_Board);
    L27:
        r102.title = r103 + " > " + r111;
    L30:
        MentionTitleResult r112 = new MentionTitleResult();
        BearUrl r113 = this.f219121c;
        r112.code = r101.code;
        r112.msg = r101.msg;
        r112.data = MentionTitleResultExecutor.a(r113, r102);
        return r112;
    L25:
        r111 = "";
        goto L27
    L26:
        r111 = r102.title;
        goto L27
    L15:
        r109 = -1;
        goto L16
    L17:
        MentionData r114 = (MentionData) ((HashMap) r101.data).get(r104);
        if (r114 == null) goto L21;
        r103 = r114.title;
        goto L21
    L9:
        r106 = null;
        goto L11
    L28:
        r102 = null;
        goto L30
    L29:
        r102 = (MentionData) ((HashMap) r101.data).get(this.f219120b);
        goto L30
    }
}
