package com.bytedance.ee.bear.bitable.utils;

import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import com.larksuite.framework.utils.CollectionUtils;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements ExtraProcessor, ExtraTypeProvider {
    public final List<ParseProcess> a;

    public f() {
        this.a = new ArrayList(2);
    }

    public final Type getExtraType(Object r4, String r5) {
        if (CollectionUtils.isNotEmpty(this.a) == false) goto L12;
        Iterator r0 = ((ArrayList) this.a).iterator();
    L6:
        if (r0.hasNext() == false) goto L20;
        ExtraTypeProvider r1 = (ParseProcess) r0.next();
        if ((r1 instanceof ExtraTypeProvider) == false) goto L6;
        Type r2 = r1.getExtraType(r4, r5);
        if (r2 == null) goto L6;
        return r2;
    L20:
        return null;
    L12:
        return null;
    }

    public final void processExtra(Object r4, String r5, Object r6) {
        if (CollectionUtils.isNotEmpty(this.a) == false) goto L10;
        Iterator r0 = ((ArrayList) this.a).iterator();
    L6:
        if (r0.hasNext() == false) goto L16;
        ExtraProcessor r1 = (ParseProcess) r0.next();
        if ((r1 instanceof ExtraProcessor) == false) goto L6;
        r1.processExtra(r4, r5, r6);
        goto L6
    L16:
        return;
    }
}
