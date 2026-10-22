package com.bytedance.ee.bear.document.at;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ee.bear.at.MentionData;
import com.bytedance.ee.bear.at.MentionTitleResultList;
import com.bytedance.ee.bear.domain.BearUrl;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class t<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<BearUrl> f219128a;

    /* JADX WARN: Multi-variable type inference failed */
    public t(List<? extends BearUrl> r100) {
        this.f219128a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r110) {
        MentionTitleResultExecutor.BatchMentionTitleResult r111 = (MentionTitleResultExecutor.BatchMentionTitleResult) r110;
        Intrinsics.checkNotNullParameter(r111, "batchMentionTitleResult");
        List<BearUrl> r100 = this.f219128a;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L51;
        BearUrl r103 = (BearUrl) r102.next();
        String r104 = r103.f222561b;
        boolean r105 = false;
        if (r104 != null) goto L8;
    L11:
        boolean r106 = true;
    L12:
        MentionData r107 = null;
        String r108 = null;
        MentionData r109 = null;
        r107 = null;
        if (r106 == true) goto L50;
        if (((HashMap) r111.data).containsKey(r104) == false) goto L50;
        String r112 = r103.f222563d.get("blockToken");
        if (r112 != null) goto L20;
    L48:
        r109 = (MentionData) ((HashMap) r111.data).get(r104);
    L49:
        r107 = MentionTitleResultExecutor.a(r103, r109);
        goto L50
    L20:
        if (((HashMap) r111.data).containsKey(r112) == false) goto L48;
        MentionData r113 = (MentionData) ((HashMap) r111.data).get(r112);
        if (r113 == null) goto L49;
        MentionData r114 = (MentionData) ((HashMap) r111.data).get(r104);
        if (r114 == null) goto L26;
        String r115 = r114.title;
    L28:
        if (TextUtils.isEmpty(r115) == false) goto L34;
        Application r116 = LarkContext.getApplication();
        if (r114 == null) goto L32;
        int r117 = r114.type;
    L33:
        r108 = sbb.e.a(r116, r117);
    L36:
        String r118 = r113.title;
        if (r118 != null) goto L39;
    L40:
        r105 = true;
    L41:
        if (r105 == false) goto L46;
        Map<String, Integer> r119 = MentionTitleResultExecutor.f219086a;
        if (r113.type != 38) goto L45;
        String r120 = LarkContext.getApplication().getResources().getString(R.string.LarkCCM_Docx_Board);
    L47:
        r113.title = r108 + " > " + r120;
        r109 = r113;
        goto L49
    L45:
        r120 = "";
        goto L47
    L46:
        r120 = r113.title;
        goto L47
    L39:
        if (r118.length() != 0) goto L41;
    L32:
        r117 = -1;
        goto L33
    L34:
        if (r114 == null) goto L36;
        r108 = r114.title;
        goto L36
    L26:
        r115 = null;
    L50:
        r101.add(r107);
        goto L4
    L8:
        if (r104.length() == 0) goto L11;
        r106 = false;
        goto L12
    L51:
        ArrayList r121 = (ArrayList) CollectionsKt.toCollection(r101, new ArrayList());
        MentionTitleResultList r122 = new MentionTitleResultList();
        r122.code = r111.code;
        r122.msg = r111.msg;
        r122.data = r121;
        return r122;
    }
}
