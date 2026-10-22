package com.bytedance.ee.bear.middleground.permission;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.PermissionDataV2;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ List<Pair<String, Integer>> a;

    public e(List<Pair<String, Integer>> r1) {
        this.a = r1;
    }

    public final void accept(Object r11) {
        NetService.ServerErrorException r12 = (Throwable) r11;
        tt5.a.f("ReadPermission", r12, false);
        boolean r0 = r12 instanceof NetService.ServerErrorException;
        if (r0 == false) goto L6;
        int r2 = r12.getCode();
    L9:
        if (r0 == false) goto L12;
        String r13 = r12.getMsg();
    L15:
        List<ReadPermission> r1 = ReadPermission.g;
        List<Pair<String, Integer>> r3 = this.a;
        Iterator r4 = ((ArrayList) r1).iterator();
    L17:
        if (r4.hasNext() == false) goto L31;
        ReadPermission r5 = (ReadPermission) r4.next();
        if (r13 != null) goto L21;
        String r6 = "";
    L22:
        r5.getClass();
        ArrayList r7 = new ArrayList();
        Iterator<Pair<String, Integer>> r8 = r3.iterator();
    L24:
        if (r8.hasNext() == false) goto L27;
        Pair<String, Integer> r9 = r8.next();
        PermissionDataV2 r10 = new PermissionDataV2();
        r10.setToken((String) r9.getFirst());
        r10.setCode(r2);
        r10.setMessage(r6);
        r10.setPermission(0);
        r10.setPermission_v2(0);
        r10.setReadAble(false);
        r7.add(r10);
        goto L24
    L27:
        if ((!r7.isEmpty()) == false) goto L17;
        Function1<List<PermissionDataV2>, Unit> r14 = r5.b.get();
        if (r14 == null) goto L17;
        r14.invoke(r7);
        goto L17
    L21:
        r6 = r13;
        goto L22
    L31:
        Map<String, PermissionDataV2> r15 = ReadPermission.e;
        ReadPermission.a.a();
        return;
    L12:
        if ((r12 instanceof NetService.HttpErrorException) == false) goto L14;
        r13 = ((NetService.HttpErrorException) r12).getHttpStr();
        goto L15
    L14:
        r13 = r12.getMessage();
        goto L15
    L6:
        if ((r12 instanceof NetService.HttpErrorException) == false) goto L8;
        r2 = ((NetService.HttpErrorException) r12).getCode();
        goto L9
    L8:
        r2 = -1;
        goto L9
    }
}
