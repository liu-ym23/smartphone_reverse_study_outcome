package ev5;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ruler.base.models.ExprException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends v97.a {
    public h() {
        super("is_empty");
    }

    @Override // v97.b
    public final Object a(List<? extends Object> r100) {
        boolean r101 = true;
        if (((ArrayList) r100).size() != 1) goto L32;
        Object r102 = ListProtector.get(r100, 0);
        if (r102 == null) goto L7;
        boolean r103 = r102 instanceof Collection;
    L8:
        if (r103 == false) goto L17;
        Collection r104 = (Collection) r102;
        if (r104 == null) goto L16;
        if (r104.isEmpty() == true) goto L16;
        r101 = false;
    L16:
        return Boolean.valueOf(r101);
    L17:
        if (r102 == null) goto L19;
        boolean r105 = r102 instanceof String;
    L20:
        if (r105 == false) goto L30;
        CharSequence r106 = (CharSequence) r102;
        if (r106 == null) goto L28;
        if (r106.length() == 0) goto L28;
        r101 = false;
    L28:
        return Boolean.valueOf(r101);
    L30:
        return Boolean.FALSE;
    L19:
        r105 = true;
        goto L20
    L7:
        r103 = true;
        goto L8
    L32:
        throw new ExprException(105, "params error");
    }
}
