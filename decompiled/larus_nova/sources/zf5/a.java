package zf5;

import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.ContentWraper;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.IContent;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.reaction.ReactionContent;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements wf5.a<ReactionContent> {

    /* JADX INFO: renamed from: zf5.a$a, reason: collision with other inner class name */
    public static final class C8451a {
    }

    static {
    }

    public a() {
    }

    @Override // wf5.a
    public final ContentWraper<ReactionContent> a(String r100, JsonElement r101) {
        Intrinsics.checkNotNullParameter(r100, "dataType");
        Intrinsics.checkNotNullParameter(r101, "dataJson");
        ContentWraper<ReactionContent> r102 = new ContentWraper();
        r102.setData((IContent) new Gson().fromJson(r101, ReactionContent.class));     // Catch: Exception -> L5
        r102.setDataType(r100);     // Catch: Exception -> L5
    L7:
        return r102;
    L5:
        e = move-exception;
        tt5.a.f("ReactionContentParser", e, false);
        goto L7
    }
}
