package com.bytedance.ee.bear.bitable.card.viewmodel.parser;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.bytedance.ee.bear.bitable.card.model.enums.EFieldUneditableReason;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes15.dex */
public class FieldUneditableReasonDeserializer implements ObjectDeserializer {
    public FieldUneditableReasonDeserializer() {
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
        if ((r103 instanceof String) == false) goto L59;
        String r104 = (String) r103;
        r104.getClass();
        byte r105 = -1;
        switch(r104.hashCode()) {
            case -1272477825: goto L44;
            case -1033583632: goto L40;
            case -1006804125: goto L36;
            case -848553846: goto L32;
            case 77525771: goto L28;
            case 456549215: goto L24;
            case 470787310: goto L20;
            case 1546293045: goto L16;
            case 2024529734: goto L12;
            default: goto L47;
        };
    L47:
        switch(r105) {
            case 0: goto L58;
            case 1: goto L68;
            case 2: goto L67;
            case 3: goto L66;
            case 4: goto L65;
            case 5: goto L64;
            case 6: goto L63;
            case 7: goto L62;
            case 8: goto L61;
            default: goto L60;
        };
    L60:
        return EFieldUneditableReason.OTHERS;
    L61:
        return EFieldUneditableReason.LANDSCAPE_READONLY;
    L62:
        return EFieldUneditableReason.ATTACHMENT_FORBIDDEN_IN_PRO;
    L63:
        return EFieldUneditableReason.SUITE_NO_EDIT_PERM;
    L64:
        return EFieldUneditableReason.IS_SYNC_TABLE;
    L65:
        return EFieldUneditableReason.FIELD_NOT_SUPPORT_EDIT;
    L66:
        return EFieldUneditableReason.IS_EXTEND_FIELD;
    L67:
        return EFieldUneditableReason.OTHERS;
    L68:
        return EFieldUneditableReason.EDIT_AFTER_SUBMIT;
    L58:
        return EFieldUneditableReason.DRILL_DOWN_NOT_SUPPORT_EDIT;
    L12:
        if (r104.equals("landscape_readonly") == false) goto L47;
        r105 = 8;
        goto L47
    L16:
        if (r104.equals("attachment_forbidden_in_pro") == false) goto L47;
        r105 = 7;
        goto L47
    L20:
        if (r104.equals("suite_no_edit_perm") == false) goto L47;
        r105 = 6;
        goto L47
    L24:
        if (r104.equals("is_sync_table") == false) goto L47;
        r105 = 5;
        goto L47
    L28:
        if (r104.equals("field_not_support_edit") == false) goto L47;
        r105 = 4;
        goto L47
    L32:
        if (r104.equals("is_extend_field") == false) goto L47;
        r105 = 3;
        goto L47
    L36:
        if (r104.equals("others") == false) goto L47;
        r105 = 2;
        goto L47
    L40:
        if (r104.equals("edit_after_submit") == false) goto L47;
        r105 = 1;
        goto L47
    L44:
        if (r104.equals("drill_down_not_support_edit") == false) goto L47;
        r105 = 0;
        goto L47
    L59:
        return EFieldUneditableReason.OTHERS;
    L4:
        r103 = r100.parse();
        goto L6
    }
}
