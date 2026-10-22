package com.ss.android.lark.contact.customized.department;

import com.bytedance.lark.pb.basic.v1.Department;
import com.bytedance.lark.pb.contact.v1.GetSubordinateDepartmentsRequestResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mtb.i;

/* JADX INFO: loaded from: classes35.dex */
public final class a<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T> f419099a = null;

    static {
        f419099a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        List<Department> r101 = GetSubordinateDepartmentsRequestResponse.ADAPTER.decode(r100).departments;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Department r104 = (Department) r103.next();
        r102.add(new i(r104.name, r104.f253477id));
        goto L4
    L6:
        return r102;
    }
}
