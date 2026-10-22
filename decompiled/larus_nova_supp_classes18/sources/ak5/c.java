package ak5;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import java.io.Serializable;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T extends Serializable> implements s<T> {
    public final Type a;

    public c(Type r1) {
        this.a = r1;
    }

    @Override // ak5.s
    public final T parse(String r4) {
        return (T) JSON.parseObject(r4, this.a, new Feature[0]);
    L5:
        e = move-exception;
        tt5.a.e("DefaultParser", "parseData: found error", e, false);
        return null;
    }
}
