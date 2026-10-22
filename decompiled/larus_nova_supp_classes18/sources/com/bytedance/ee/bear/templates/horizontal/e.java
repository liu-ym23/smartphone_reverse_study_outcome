package com.bytedance.ee.bear.templates.horizontal;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.templates.scene.TopicData;
import com.bytedance.ee.bear.templates.scene.TopicDataResult;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T, R> implements Function {
    public final /* synthetic */ HorizontalTemplateModel a;

    public e(HorizontalTemplateModel r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ee.bear.templates.horizontal.HorizontalTemplates, java.io.Serializable, java.lang.Object] */
    public final Object apply(Object r5) {
        TopicDataResult r6 = (TopicDataResult) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        ArrayList<TemplateV4> r1 = ((TopicData) ((Result) r6).data).getTemplates();
        if (r1 != null) goto L5;
        r1 = new ArrayList();
    L5:
        ?? r0 = new HorizontalTemplates(2, r1, null, ((TopicData) ((Result) r6).data).getHasMore());
        if (hu5.a.d(r0.getTemplates()) == true) goto L8;
        ((aw4.a) this.a.e.getValue()).a((String) this.a.f.getValue(), r0);
    L8:
        return r0;
    }
}
