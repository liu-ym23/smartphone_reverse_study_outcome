package com.huawei.hms.core.aidl;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class MessageCodecV2 extends MessageCodec {
    public MessageCodecV2() {
    }

    @Override // com.huawei.hms.core.aidl.MessageCodec
    public List<Object> readList(Type r100, Bundle r101) throws InstantiationException, IllegalAccessException {
        int r102 = r101.getInt("_list_size_");
        ArrayList r103 = new ArrayList(r102);
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L23;
        Object r105 = r101.get("_list_item_" + r104);
        if (r105.getClass().isPrimitive() == false) goto L7;
    L21:
        r103.add(r105);
    L22:
        r104 = r104 + 1;
        goto L3
    L7:
        if ((r105 instanceof String) == true) goto L21;
        if ((r105 instanceof Serializable) == true) goto L21;
        if ((r105 instanceof Bundle) == false) goto L22;
        Bundle r106 = (Bundle) r105;
        int r107 = r106.getInt("_val_type_", -1);
        if (r107 == 1) goto L20;
        if (r107 != 0) goto L18;
        r103.add(decode(r106, (IMessageEntity) ((Class) ((ParameterizedType) r100).getActualTypeArguments()[0]).newInstance()));
        goto L22
    L18:
        throw new InstantiationException("Unknown type can not be supported");
    L20:
        throw new InstantiationException("Nested List can not be supported");
    L23:
        return r103;
    }

    @Override // com.huawei.hms.core.aidl.MessageCodec
    public void writeList(String r100, List r101, Bundle r102) {
        Bundle r103 = new Bundle();
        r103.putInt("_val_type_", 1);
        r103.putInt("_list_size_", r101.size());
        int r104 = 0;
    L4:
        if (r104 >= r101.size()) goto L6;
        writeValue("_list_item_" + r104, ListProtector.get(r101, r104), r103);
        r104 = r104 + 1;
        goto L4
    L6:
        r102.putBundle(r100, r103);
    }
}
