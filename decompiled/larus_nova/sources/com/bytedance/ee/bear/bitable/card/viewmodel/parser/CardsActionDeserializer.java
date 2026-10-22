package com.bytedance.ee.bear.bitable.card.viewmodel.parser;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.bytedance.ee.bear.bitable.card.model.enums.ECardsAction;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes15.dex */
public class CardsActionDeserializer implements ObjectDeserializer {
    public CardsActionDeserializer() {
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
        if ((r103 instanceof String) == false) goto L11;
        ECardsAction r104 = ECardsAction.valueOfCamelName((String) r103);
        if (r104 == null) goto L11;
        return r104;
    L11:
        return ECardsAction.UNKNOWN;
    L4:
        r103 = r100.parse();
        goto L6
    }
}
