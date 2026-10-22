package com.bytedance.ee.bear.office.list.adapter;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class OfficeDocumentAdapter$longPressActionContextFactory$2 extends FunctionReferenceImpl implements Function0<com.bytedance.ee.bear.more.office.e> {
    public OfficeDocumentAdapter$longPressActionContextFactory$2(Object r8) {
        super(0, r8, OfficeDocumentAdapter.class, "provideLarkActionService", "provideLarkActionService()Lcom/bytedance/ee/bear/more/office/OfficeLongPressLarkActionService;", 0);
    }

    public final com.bytedance.ee.bear.more.office.e invoke() {
        OfficeDocumentAdapter r0 = (OfficeDocumentAdapter) ((CallableReference) this).receiver;
        int r1 = OfficeDocumentAdapter.C;
        r0.getClass();
        int r2 = com.bytedance.ee.bear.list.office.longpress.r.a;
        return com.bytedance.ee.bear.list.office.longpress.a.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m396invoke() {
        return invoke();
    }
}
