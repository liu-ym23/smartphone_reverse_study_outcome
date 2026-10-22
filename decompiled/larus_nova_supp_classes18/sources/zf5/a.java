package zf5;

import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.ContentWraper;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.IContent;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.reaction.ReactionContent;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements wf5.a<ReactionContent> {

    /* JADX INFO: renamed from: zf5.a$a, reason: collision with other inner class name */
    public static final class C0346a {
    }

    static {
    }

    public a() {
    }

    @Override // wf5.a
    public final ContentWraper<ReactionContent> a(String r4, JsonElement r5) {
        Intrinsics.checkNotNullParameter(r4, "dataType");
        Intrinsics.checkNotNullParameter(r5, "dataJson");
        ContentWraper<ReactionContent> r0 = new ContentWraper();
        r0.setData((IContent) new Gson().fromJson(r5, ReactionContent.class));     // Catch: Exception -> L5
        r0.setDataType(r4);     // Catch: Exception -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        tt5.a.f("ReactionContentParser", e, false);
        goto L7
    }
}
