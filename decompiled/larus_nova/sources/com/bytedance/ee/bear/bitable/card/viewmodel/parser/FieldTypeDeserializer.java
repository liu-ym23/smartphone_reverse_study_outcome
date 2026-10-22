package com.bytedance.ee.bear.bitable.card.viewmodel.parser;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import java.lang.reflect.Type;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0004\u001a\u0002H\u0005\"\n\b\u0000\u0010\u0005*\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/viewmodel/parser/FieldTypeDeserializer;", "Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;", "<init>", "()V", "deserialze", ExifInterface.GPS_DIRECTION_TRUE, "", "parser", "Lcom/alibaba/fastjson/parser/DefaultJSONParser;", "type", "Ljava/lang/reflect/Type;", "fieldName", "(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;", "getFastMatchToken", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldTypeDeserializer implements ObjectDeserializer {
    public FieldTypeDeserializer() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public final int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public final <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        Integer r103 = null;
        if (r100 == null) goto L5;
        Object r104 = r100.parse();
    L7:
        if ((r104 instanceof Integer) == false) goto L10;
        r103 = (Integer) r104;
    L12:
        EFieldType.Companion.getClass();
        return (T) EFieldType.a.a(r103);
    L10:
        if ((r104 instanceof Number) == false) goto L12;
        r103 = Integer.valueOf(((Number) r104).intValue());
        goto L12
    L5:
        r104 = null;
        goto L7
    }
}
