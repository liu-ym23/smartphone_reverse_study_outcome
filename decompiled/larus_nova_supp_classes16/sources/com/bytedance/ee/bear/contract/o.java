package com.bytedance.ee.bear.contract;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.DocContainerInfo;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.DocObjInfo;
import com.bytedance.ee.bear.PageviewResult;
import com.bytedance.ee.bear.at.MentionTitleResult;
import com.bytedance.ee.bear.at.MentionTitleResultList;
import com.bytedance.ee.bear.document.at.MentionTitleResultExecutor;
import com.bytedance.ee.bear.document.export.more.ExportMoreItemV2;
import com.bytedance.ee.bear.document.pageview.PageWordViewModel;
import com.bytedance.ee.bear.document.q4;
import com.bytedance.ee.bear.domain.BearUrl;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import n35.r;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o implements com.bytedance.ee.bear.d {

    public class a implements r {
        public a() {
        }

        @Override // n35.r
        public final void j(String r2) {
            ((rc5.a) org.koin.java.a.a(rc5.a.class)).j(r2);
        }
    }

    public o() {
    }

    static {
        List<r> r0 = n35.l.a;
        a r1 = new a();
        Intrinsics.checkNotNullParameter(r1, "listener");
        ((ArrayList) n35.l.a).add(r1);
    }

    public final ExportMoreItemV2 a(FragmentActivity r2) {
        return new ExportMoreItemV2(r2);
    }

    public final LiveData<PageviewResult> c(FragmentActivity r2) {
        return ((PageWordViewModel) ViewModelProviders.of(r2).get(PageWordViewModel.class)).getPageWordResult();
    }

    public final Flowable<DocMetaInfo> b(String r2, int r3) {
        int r0 = t05.a.a;
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        return t05.a.a(r2, r3);
    }

    public final Flowable<DocContainerInfo> d(String r1, int r2) {
        return w05.a.a(r1, r2);
    }

    public final Flowable<DocObjInfo> e(String r10, int r11) {
        if (r10 != null) goto L6;
        r10 = "";
    L6:
        return u05.a.a(new q4(r10, r11, ((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.a(com.bytedance.ee.bear.contract.route.parcelable.a.class)).m(), true, true, true, "obj_detail"), false);
    }

    public final Flowable<MentionTitleResult> f(BearUrl r8, NetService r9) {
        Map<String, Integer> r0 = MentionTitleResultExecutor.a;
        Intrinsics.checkNotNullParameter(r8, "bearUrl");
        Intrinsics.checkNotNullParameter(r9, "netService");
        String r1 = r8.b;
        JSONArray r2 = new JSONArray();
        r2.put(r1);
        String r3 = r8.d.get("blockToken");
        if (r8.d.containsKey("blockType") == false) goto L6;
        if (r3 == null) goto L6;
        JSONArray r4 = new JSONArray();
        r4.put(r8.d.get("blockToken"));
    L7:
        JSONObject r5 = new JSONObject();
        r5.put(String.valueOf(sbb.e.g(r8.a)), r2);
        if (r4 == null) goto L10;
        r5.put(String.valueOf(MentionTitleResultExecutor.a.get(r8.d.get("blockType"))), r4);
    L10:
        JSONObject r6 = new JSONObject();
        r6.put("tokens", r5);
        NetService.f r7 = new NetService.f("api/meta/batch");
        r7.c = 1;
        r7.j = r6.toString();
        return r9.Rb(MentionTitleResultExecutor.BatchMentionTitleResult.class).a(r7).map(new com.bytedance.ee.bear.document.at.s(r3, r1, r8));
    L6:
        r4 = null;
        goto L7
    }

    public final Flowable<MentionTitleResultList> g(List<BearUrl> r7, NetService r8) {
        Map<String, Integer> r0 = MentionTitleResultExecutor.a;
        Intrinsics.checkNotNullParameter(r7, "bearUrls");
        Intrinsics.checkNotNullParameter(r8, "netService");
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<T> r2 = r7.iterator();
    L4:
        if (r2.hasNext() == false) goto L22;
        BearUrl r3 = (BearUrl) r2.next();
        String r4 = r3.a;
        String r5 = r3.b;
        if (r5 == null) goto L4;
        String r6 = String.valueOf(sbb.e.g(r4));
        Object r9 = r1.get(r6);
        if (r9 != null) goto L11;
        r9 = new ArrayList();
        r1.put(r6, r9);
    L11:
        ((List) r9).add(r5);
        String r10 = r3.d.get("blockType");
        String r11 = r3.d.get("blockToken");
        if (r10 == null) goto L4;
        if (r11 == null) goto L4;
        Integer r12 = MentionTitleResultExecutor.a.get(r10);
        if (r12 == null) goto L4;
        String r13 = r12.toString();
        if (r13 == null) goto L4;
        Object r14 = r1.get(r13);
        if (r14 != null) goto L21;
        r14 = new ArrayList();
        r1.put(r13, r14);
    L21:
        ((List) r14).add(r11);
        goto L4
    L22:
        JSONObject r16 = new JSONObject();
        Iterator r17 = r1.entrySet().iterator();
    L24:
        if (r17.hasNext() == false) goto L26;
        Map.Entry r18 = (Map.Entry) r17.next();
        r16.put((String) r18.getKey(), new JSONArray((List) r18.getValue()));
        goto L24
    L26:
        JSONObject r19 = new JSONObject();
        r19.put("tokens", r16);
        NetService.f r20 = new NetService.f("api/meta/batch");
        r20.c = 1;
        r20.j = r19.toString();
        return r8.Rb(MentionTitleResultExecutor.BatchMentionTitleResult.class).a(r20).map(new com.bytedance.ee.bear.document.at.t(r7));
    }

    public final boolean h(FragmentActivity r3, com.bytedance.ee.bear.d.a r4, com.bytedance.ee.bear.list.office.longpress.n r5) {
        com.bytedance.ee.bear.document.export.e.a.C0073a r0 = new com.bytedance.ee.bear.document.export.e.a.C0073a();
        r0.a = r4.a;
        r0.b = r4.b;
        r0.c = r4.c;
        r0.d = r4.d;
        r0.e = r4.e;
        r0.f = r4.f;
        r0.g = r4.g;
        r0.h = r4.h;
        r0.i = false;
        r0.j = "";
        r0.k = r4.i;
        r0.l = r4.j;
        r0.m = r4.k;
        r0.n = r4.l;
        r0.o = r4.m;
        return new com.bytedance.ee.bear.document.export.e(r3, new com.bytedance.ee.bear.document.export.e.a(r0), null, new p(r5)).p();
    }
}
