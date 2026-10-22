package com.bytedance.ee.bear.lark.selector.auth;

import com.bytedance.lark.pb.space.doc.v1.GetMessageDocPermissionsResponse;
import com.ss.android.lark.doc.entity.DocPermission;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements SdkSender.IParser<Map<String, Map<String, List<DocPermission>>>> {
    public a() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Map<String, Map<String, List<DocPermission>>> parse(byte[] r110) throws IOException {
        HashMap r100 = new HashMap();
        Map<String, GetMessageDocPermissionsResponse.PermissionListInfo> r111 = GetMessageDocPermissionsResponse.ADAPTER.decode(r110).message_id2permission_list_info;
        if (r111.isEmpty() == true) goto L22;
        Iterator<Map.Entry<String, GetMessageDocPermissionsResponse.PermissionListInfo>> r112 = r111.entrySet().iterator();
    L7:
        if (r112.hasNext() == false) goto L22;
        Map.Entry<String, GetMessageDocPermissionsResponse.PermissionListInfo> r101 = r112.next();
        String r102 = r101.getKey();
        Map<String, GetMessageDocPermissionsResponse.PermissionListInfo.PermissionList> r103 = r101.getValue().doc_url2permission_list;
        if (r103.isEmpty() == true) goto L7;
        HashMap r104 = new HashMap();
        Iterator<Map.Entry<String, GetMessageDocPermissionsResponse.PermissionListInfo.PermissionList>> r105 = r103.entrySet().iterator();
    L13:
        if (r105.hasNext() == false) goto L21;
        Map.Entry<String, GetMessageDocPermissionsResponse.PermissionListInfo.PermissionList> r106 = r105.next();
        String r107 = r106.getKey();
        List<com.bytedance.lark.pb.basic.v1.DocPermission.Permission> r108 = r106.getValue().permissions;
        ArrayList r109 = new ArrayList();
        HashSet r113 = new HashSet();
        Iterator<com.bytedance.lark.pb.basic.v1.DocPermission.Permission> r114 = r108.iterator();
    L16:
        if (r114.hasNext() == false) goto L20;
        com.bytedance.lark.pb.basic.v1.DocPermission.Permission r115 = r114.next();
        if (r113.contains(r115.code) == true) goto L16;
        DocPermission r116 = new DocPermission();
        r116.setPermName(r115.name);
        r116.setPermCode(r115.code.intValue());
        r116.setIsSet(true);
        r109.add(r116);
        r113.add(r115.code);
        goto L16
    L20:
        r104.put(r107, r109);
        goto L13
    L21:
        r100.put(r102, r104);
    L22:
        return r100;
    }
}
