package com.bytedance.ee.bear.bitable.utils;

import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import com.larksuite.framework.utils.CollectionUtils;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements ExtraProcessor, ExtraTypeProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ParseProcess> f216276a;

    public f() {
        this.f216276a = new ArrayList(2);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider
    public final Type getExtraType(Object r100, String r101) {
        if (CollectionUtils.isNotEmpty(this.f216276a) == false) goto L12;
        Iterator r102 = ((ArrayList) this.f216276a).iterator();
    L6:
        if (r102.hasNext() == false) goto L20;
        ParseProcess r103 = (ParseProcess) r102.next();
        if ((r103 instanceof ExtraTypeProvider) == false) goto L6;
        Type r104 = ((ExtraTypeProvider) r103).getExtraType(r100, r101);
        if (r104 == null) goto L6;
        return r104;
    L20:
        return null;
    L12:
        return null;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ExtraProcessor
    public final void processExtra(Object r100, String r101, Object r102) {
        if (CollectionUtils.isNotEmpty(this.f216276a) == false) goto L10;
        Iterator r103 = ((ArrayList) this.f216276a).iterator();
    L6:
        if (r103.hasNext() == false) goto L16;
        ParseProcess r104 = (ParseProcess) r103.next();
        if ((r104 instanceof ExtraProcessor) == false) goto L6;
        ((ExtraProcessor) r104).processExtra(r100, r101, r102);
        goto L6
    L16:
        return;
    }
}
