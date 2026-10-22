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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements SdkSender.IParser<Map<String, Map<String, List<DocPermission>>>> {
    public a() {
    }

    public final Object parse(byte[] r12) throws IOException {
        HashMap r0 = new HashMap();
        Map r13 = ((GetMessageDocPermissionsResponse) GetMessageDocPermissionsResponse.ADAPTER.decode(r12)).message_id2permission_list_info;
        if (r13.isEmpty() == true) goto L22;
        Iterator r14 = r13.entrySet().iterator();
    L7:
        if (r14.hasNext() == false) goto L22;
        Map.Entry r1 = (Map.Entry) r14.next();
        String r2 = (String) r1.getKey();
        Map r3 = ((GetMessageDocPermissionsResponse.PermissionListInfo) r1.getValue()).doc_url2permission_list;
        if (r3.isEmpty() == true) goto L7;
        HashMap r4 = new HashMap();
        Iterator r5 = r3.entrySet().iterator();
    L13:
        if (r5.hasNext() == false) goto L21;
        Map.Entry r6 = (Map.Entry) r5.next();
        String r7 = (String) r6.getKey();
        List r8 = ((GetMessageDocPermissionsResponse.PermissionListInfo.PermissionList) r6.getValue()).permissions;
        ArrayList r9 = new ArrayList();
        HashSet r10 = new HashSet();
        Iterator r11 = r8.iterator();
    L16:
        if (r11.hasNext() == false) goto L20;
        com.bytedance.lark.pb.basic.v1.DocPermission.Permission r16 = (com.bytedance.lark.pb.basic.v1.DocPermission.Permission) r11.next();
        if (r10.contains(r16.code) == true) goto L16;
        DocPermission r17 = new DocPermission();
        r17.setPermName(r16.name);
        r17.setPermCode(r16.code.intValue());
        r17.setIsSet(true);
        r9.add(r17);
        r10.add(r16.code);
        goto L16
    L20:
        r4.put(r7, r9);
        goto L13
    L21:
        r0.put(r2, r4);
    L22:
        return r0;
    }
}
