package xf5;

import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.ContentWraper;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.IContent;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.normal.NormalContent;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements wf5.a<NormalContent> {

    /* JADX INFO: renamed from: xf5.a$a, reason: collision with other inner class name */
    public static final class C8229a {
    }

    static {
    }

    public a() {
    }

    @Override // wf5.a
    public final ContentWraper<NormalContent> a(String r100, JsonElement r101) {
        Intrinsics.checkNotNullParameter(r100, "dataType");
        Intrinsics.checkNotNullParameter(r101, "dataJson");
        ContentWraper<NormalContent> r102 = new ContentWraper();
        r102.setData((IContent) new Gson().fromJson(r101, NormalContent.class));     // Catch: Exception -> L26
        NormalContent r103 = (NormalContent) r102.getData();     // Catch: Exception -> L26
        if (r103 == null) goto L24;
        NormalContent r104 = (NormalContent) r102.getData();     // Catch: Exception -> L26
        String r105 = null;
        if (r104 == null) goto L8;
        String r106 = r104.getTranslateStatus();     // Catch: Exception -> L26
    L9:
        if (r106 != null) goto L11;
    L14:
        boolean r107 = true;
    L15:
        if (r107 == false) goto L17;
        String r108 = "default";
    L23:
        r103.setTranslateStatus(r108);     // Catch: Exception -> L26
        goto L24
    L17:
        NormalContent r109 = (NormalContent) r102.getData();     // Catch: Exception -> L26
        if (r109 == null) goto L20;
        r105 = r109.getTranslateStatus();     // Catch: Exception -> L26
    L20:
        if (r105 != null) goto L22;
        r108 = "";
        goto L23
    L22:
        r108 = r105;
        goto L23
    L11:
        if (r106.length() == 0) goto L14;
        r107 = false;
        goto L15
    L8:
        r106 = null;
    L24:
        r102.setDataType(r100);     // Catch: Exception -> L26
    L28:
        return r102;
    L26:
        e = move-exception;
        tt5.a.f("MultiLevelContentParser", e, false);
        goto L28
    }
}
