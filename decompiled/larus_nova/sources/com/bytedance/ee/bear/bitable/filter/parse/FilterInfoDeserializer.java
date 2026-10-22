package com.bytedance.ee.bear.bitable.filter.parse;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.bytedance.ee.bear.bitable.filter.model.FilterInfo;
import java.lang.reflect.Type;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J9\u0010\u0006\u001a\u0004\u0018\u0001H\u0007\"\n\b\u0000\u0010\u0007*\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/parse/FilterInfoDeserializer;", "Lcom/bytedance/ee/bear/bitable/filter/parse/SafeDeserializer;", "Lcom/bytedance/ee/bear/bitable/filter/model/FilterInfo;", "Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;", "<init>", "()V", "deserialze", ExifInterface.GPS_DIRECTION_TRUE, "", "parser", "Lcom/alibaba/fastjson/parser/DefaultJSONParser;", "type", "Ljava/lang/reflect/Type;", "fieldName", "(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;", "getFastMatchToken", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterInfoDeserializer extends SafeDeserializer<FilterInfo> implements ObjectDeserializer {
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public final int getFastMatchToken() {
        return 12;
    }

    public FilterInfoDeserializer() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public final <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        if (r100 == null) goto L11;
        Object r103 = r100.parse();
        if (r103 == null) goto L11;
        T r104 = (T) SafeDeserializer.f211884a.getValue().fromJson(JSON.toJSONString(r103), FilterInfo.class);
        if (r104 == null) goto L11;
        return r104;
    L9:
        e = move-exception;
        tt5.a.b("SafeDeserializer", "deserialize fastjson " + e + ". json:" + r103 + ". type:" + r101);
    L11:
        return null;
    }
}
