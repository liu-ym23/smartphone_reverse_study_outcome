package com.bytedance.ee.bear.tts.impl.model;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.tts.tone.TtsToneBean;
import com.bytedance.ee.bear.tts.tone.TtsToneListBean;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class TtsToneModel {
    public final String a;
    public final int b;
    public TtsToneListBean c;
    public boolean d;
    public long e;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ee/bear/tts/impl/model/TtsToneModel$TtsToneListResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/tts/tone/TtsToneListBean;", "<init>", "()V", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TtsToneListResult extends Result<TtsToneListBean> {
        public TtsToneListResult() {
        }
    }

    public static final class a {
    }

    public static final class b implements NetService.c<TtsToneListResult> {
        public b() {
        }

        public final Result parse(String r11) {
            tt5.a.h("TtsToneModel", "TtsToneInfoParser-parse, json: " + r11);
        L10:
            JSONObject r12 = new JSONObject();
        L11:
            TtsToneListResult r0 = new TtsToneListResult();
            TtsToneListBean r1 = new TtsToneListBean();
            JSONObject r2 = r12.optJSONObject("default_speaker");
            if (r2 == null) goto L14;
            TtsToneBean r5 = new TtsToneBean();
            r5.setToneId(r2.optString("speaker_id"));
            r5.setToneName(r2.optString("name"));
            r1.setDefaultTone(r5);
        L14:
            JSONArray r13 = r12.optJSONArray("speakers");
            if (r13 == null) goto L24;
            ArrayList<TtsToneBean> r3 = new ArrayList();
            int r6 = r13.length();
            int r7 = 0;
        L17:
            if (r7 >= r6) goto L23;
            JSONObject r8 = r13.optJSONObject(r7);
            if (r8 == null) goto L22;
            TtsToneBean r9 = new TtsToneBean();
            r9.setToneId(r8.optString("speaker_id"));
            r9.setToneName(r8.optString("name"));
            r3.add(r9);
        L22:
            r7 = r7 + 1;
            goto L17
        L23:
            r1.setToneList(r3);
        L24:
            ((Result) r0).data = r1;
            return r0;
        L4:
            if (r11 != null) goto L6;
            r11 = "";
        L6:
            r12 = new JSONObject(r11).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Exception -> L10
            if (r12 != null) goto L11;
            r12 = new JSONObject();     // Catch: Exception -> L10
            goto L11
        }
    }

    static {
    }

    public TtsToneModel(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "docToken");
        this.a = r2;
        this.b = r3;
    }

    public final Object a(String r4, Continuation<? super TtsToneListBean> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new TtsToneModel$reload$2(r4, this, null), r5);
    }
}
