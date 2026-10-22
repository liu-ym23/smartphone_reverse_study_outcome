package lr4;

import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;

/* JADX INFO: loaded from: classes15.dex */
public final class a {
    public static final boolean a(FieldCompositeType r100) {
        if (r100 == null) goto L4;
        EFieldType r101 = r100.getType();
    L6:
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101 != EFieldType.SINGLE_SELECT) goto L11;
    L12:
        return true;
    L11:
        if (r101 == EFieldType.MULTI_SELECT) goto L12;
        return false;
    L4:
        r101 = null;
        goto L6
    }

    public static final boolean b(EFieldType r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100 != EFieldType.DATE_TIME) goto L8;
    L11:
        return true;
    L8:
        if (r100 == EFieldType.CREATED_TIME) goto L11;
        if (r100 == EFieldType.MODIFIED_TIME) goto L11;
        return false;
    }
}
