package com.bytedance.ee.bear.bitable.card.viewmodel.parser;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.bytedance.ee.bear.bitable.card.model.enums.ECardType;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes15.dex */
public class CardTypeDeserializer implements ObjectDeserializer {
    public CardTypeDeserializer() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public final Object deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        if (r100 != null) goto L4;
        Object r103 = null;
    L6:
        if ((r103 instanceof String) == false) goto L16;
        String r104 = (String) r103;
        r104.getClass();
        if (r104.equals(DocumentType.BITABLE_NAME) == true) goto L15;
        if (r104.equals("jira") == true) goto L18;
        return ECardType.UNKNOWN;
    L18:
        return ECardType.JIRA;
    L15:
        return ECardType.BITABLE;
    L16:
        return ECardType.UNKNOWN;
    L4:
        r103 = r100.parse();
        goto L6
    }
}
