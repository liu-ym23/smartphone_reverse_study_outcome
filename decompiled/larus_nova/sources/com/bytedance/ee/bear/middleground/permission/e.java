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

/* JADX INFO: loaded from: classes18.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<Pair<String, Integer>> f233832a;

    public e(List<Pair<String, Integer>> r100) {
        this.f233832a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Throwable r111 = (Throwable) r110;
        tt5.a.f("ReadPermission", r111, false);
        boolean r100 = r111 instanceof NetService.ServerErrorException;
        if (r100 == false) goto L6;
        int r101 = ((NetService.ServerErrorException) r111).getCode();
    L9:
        if (r100 == false) goto L12;
        String r112 = ((NetService.ServerErrorException) r111).getMsg();
    L15:
        List<ReadPermission> r102 = ReadPermission.f232833g;
        List<Pair<String, Integer>> r103 = this.f233832a;
        Iterator r104 = ((ArrayList) r102).iterator();
    L17:
        if (r104.hasNext() == false) goto L31;
        ReadPermission r105 = (ReadPermission) r104.next();
        if (r112 != null) goto L21;
        String r106 = "";
    L22:
        r105.getClass();
        ArrayList r107 = new ArrayList();
        Iterator<Pair<String, Integer>> r108 = r103.iterator();
    L24:
        if (r108.hasNext() == false) goto L27;
        Pair<String, Integer> r109 = r108.next();
        PermissionDataV2 r113 = new PermissionDataV2();
        r113.setToken(r109.getFirst());
        r113.setCode(r101);
        r113.setMessage(r106);
        r113.setPermission(0);
        r113.setPermission_v2(0);
        r113.setReadAble(false);
        r107.add(r113);
        goto L24
    L27:
        if ((!r107.isEmpty()) == false) goto L17;
        Function1<List<PermissionDataV2>, Unit> r114 = r105.f232839b.get();
        if (r114 == null) goto L17;
        r114.invoke(r107);
        goto L17
    L21:
        r106 = r112;
        goto L22
    L31:
        Map<String, PermissionDataV2> r115 = ReadPermission.f232831e;
        ReadPermission.a.a();
        return;
    L12:
        if ((r111 instanceof NetService.HttpErrorException) == false) goto L14;
        r112 = ((NetService.HttpErrorException) r111).getHttpStr();
        goto L15
    L14:
        r112 = r111.getMessage();
        goto L15
    L6:
        if ((r111 instanceof NetService.HttpErrorException) == false) goto L8;
        r101 = ((NetService.HttpErrorException) r111).getCode();
        goto L9
    L8:
        r101 = -1;
        goto L9
    }
}
