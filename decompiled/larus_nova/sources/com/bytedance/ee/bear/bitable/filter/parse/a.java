package com.bytedance.ee.bear.bitable.filter.parse;

import com.alibaba.fastjson.parser.ParserConfig;
import com.bytedance.ee.bear.bitable.filter.model.FilterInfo;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends ParserConfig {
    public a() {
        putDeserializer(FilterInfo.class, new FilterInfoDeserializer());
    }
}
