package yp4;

import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;

/* JADX INFO: loaded from: classes15.dex */
public final class i {
    public static String a(Integer r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (r100.intValue() != 0) goto L10;
        return "integer";
    L10:
        if (r100.intValue() != 1) goto L14;
        return "digital_round_1";
    L14:
        if (r100.intValue() != 2) goto L17;
        return "digital_round_2";
    L17:
        return "";
    }

    public static String b(Integer r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        FieldConfigMetaModel.NumberFormatType[] r101 = FieldConfigMetaModel.NumberFormatType.values();
        if (r101 != null) goto L8;
    L17:
        return "";
    L8:
        if (r101.length <= 0) goto L17;
        int r102 = 0;
    L11:
        if (r102 >= r101.length) goto L17;
        if (r101[r102].getValue() == r100.intValue()) goto L15;
        r102 = r102 + 1;
        goto L11
    L15:
        return r101[r102].name().toLowerCase();
    }
}
