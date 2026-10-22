package com.bytedance.ee.bear.templates.horizontal;

import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.templates.scene.TopicData;
import com.bytedance.ee.bear.templates.scene.TopicDataResult;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HorizontalTemplateModel f239109a;

    public e(HorizontalTemplateModel r100) {
        this.f239109a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        TopicDataResult r101 = (TopicDataResult) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        ArrayList<TemplateV4> r102 = ((TopicData) r101.data).getTemplates();
        if (r102 != null) goto L5;
        r102 = new ArrayList();
    L5:
        HorizontalTemplates r103 = new HorizontalTemplates(2, r102, null, ((TopicData) r101.data).getHasMore());
        if (hu5.a.d(r103.getTemplates()) == true) goto L8;
        ((aw4.a) this.f239109a.f239091e.getValue()).a((String) this.f239109a.f239092f.getValue(), r103);
    L8:
        return r103;
    }
}
