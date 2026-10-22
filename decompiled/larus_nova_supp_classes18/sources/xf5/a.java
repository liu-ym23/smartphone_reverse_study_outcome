package xf5;

import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.ContentWraper;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.IContent;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.normal.NormalContent;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements wf5.a<NormalContent> {

    /* JADX INFO: renamed from: xf5.a$a, reason: collision with other inner class name */
    public static final class C0331a {
    }

    static {
    }

    public a() {
    }

    @Override // wf5.a
    public final ContentWraper<NormalContent> a(String r5, JsonElement r6) {
        Intrinsics.checkNotNullParameter(r5, "dataType");
        Intrinsics.checkNotNullParameter(r6, "dataJson");
        ContentWraper<NormalContent> r0 = new ContentWraper();
        r0.setData((IContent) new Gson().fromJson(r6, NormalContent.class));     // Catch: Exception -> L26
        NormalContent r7 = (NormalContent) r0.getData();     // Catch: Exception -> L26
        if (r7 == null) goto L24;
        NormalContent r2 = (NormalContent) r0.getData();     // Catch: Exception -> L26
        String r3 = null;
        if (r2 == null) goto L8;
        String r4 = r2.getTranslateStatus();     // Catch: Exception -> L26
    L9:
        if (r4 != null) goto L11;
    L14:
        boolean r8 = true;
    L15:
        if (r8 == false) goto L17;
        String r9 = "default";
    L23:
        r7.setTranslateStatus(r9);     // Catch: Exception -> L26
        goto L24
    L17:
        NormalContent r10 = (NormalContent) r0.getData();     // Catch: Exception -> L26
        if (r10 == null) goto L20;
        r3 = r10.getTranslateStatus();     // Catch: Exception -> L26
    L20:
        if (r3 != null) goto L22;
        r9 = "";
        goto L23
    L22:
        r9 = r3;
        goto L23
    L11:
        if (r4.length() == 0) goto L14;
        r8 = false;
        goto L15
    L8:
        r4 = null;
    L24:
        r0.setDataType(r5);     // Catch: Exception -> L26
    L28:
        return r0;
    L26:
        e = move-exception;
        tt5.a.f("MultiLevelContentParser", e, false);
        goto L28
    }
}
