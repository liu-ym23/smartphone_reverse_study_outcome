package com.ss.android.lark.integrator.im.feed_shared.dependency;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.ss.android.lark.dto.draft.Draft;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes36.dex */
public final class k implements peb.b.j {
    public k() {
    }

    @Override // peb.b.j
    @Nullable
    public final String a(List<Chatter.ChatterCustomStatus> r100) {
        nmb.a.a().getCoreDependency().m();
        return null;
    }

    @Override // peb.b.j
    public final RichText b(String r100) {
        Draft r101 = (Draft) JSON.parseObject(r100, Draft.class);
        RichText r102 = r101.contentRichText;
        if (r102 == null) goto L6;
        return r102;
    L6:
        if (TextUtils.isEmpty(r101.title) == false) goto L10;
        return r101.postRichText;
    L10:
        return com.ss.android.lark.widget.richtext.c.c(r101.title);
    }
}
