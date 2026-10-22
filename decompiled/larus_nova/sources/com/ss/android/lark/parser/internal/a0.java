package com.ss.android.lark.parser.internal;

import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.chat.entity.tag.TagDataItem;
import com.ss.android.lark.chat.entity.tag.TagRelationTypeEnum;
import com.ss.android.lark.chat.entity.tag.TagTypeEnum;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes37.dex */
public final class a0 {
    static {
    }

    @JvmStatic
    public static final TagData a(com.bytedance.lark.pb.basic.v1.TagData r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        List<com.bytedance.lark.pb.basic.v1.TagData.TagDataItem> r101 = r100.tag_data_items;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L10;
        com.bytedance.lark.pb.basic.v1.TagData.TagDataItem r104 = (com.bytedance.lark.pb.basic.v1.TagData.TagDataItem) r103.next();
        String r105 = r104.text_val;
        TagTypeEnum.a r106 = TagTypeEnum.Companion;
        int r107 = r104.req_tag_type.getValue();
        r106.getClass();
        TagTypeEnum r108 = TagTypeEnum.a.a(r107);
        TagRelationTypeEnum.a r109 = TagRelationTypeEnum.Companion;
        int r110 = r104.resp_tag_type.getValue();
        r109.getClass();
        r102.add(new TagDataItem(r105, r108, TagRelationTypeEnum.a.a(r110), r104.priority));
        goto L7
    L10:
        return new TagData(r102);
    }
}
