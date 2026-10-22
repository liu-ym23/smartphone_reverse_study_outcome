package com.larus.office.card.doc.content;

import com.larus.network.FlowHttpConnection;
import com.larus.network.http.ServiceType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\tJ \u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\tJ \u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/larus/office/card/doc/content/OfficeCardDocContentServiceImpl;", "Lcom/larus/office/card/doc/content/IOfficeCardDocContentService;", "<init>", "()V", "getDocumentContent", "", "resourceId", "version", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDocContent", "Lcom/larus/office/card/doc/content/OfficeCardDocContent;", "getDocContentInternal", "Lcom/larus/office/card/doc/content/OfficeCardGetDocContentResponse;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeCardDocContentServiceImpl implements IOfficeCardDocContentService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f361367a = 0;

    public static final class a {
    }

    static {
    }

    public OfficeCardDocContentServiceImpl() {
    }

    @Override // com.larus.office.card.doc.content.IOfficeCardDocContentService
    public final Object a(String r100, int r101, Continuation<? super com.larus.office.card.doc.content.a> r102) {
        if ((r102 instanceof OfficeCardDocContentServiceImpl$getDocContent$1) == false) goto L7;
        OfficeCardDocContentServiceImpl$getDocContent$1 r103 = (OfficeCardDocContentServiceImpl$getDocContent$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        d r108 = (d) r105;
        if (r108 != null) goto L22;
        return null;
    L22:
        return new com.larus.office.card.doc.content.a(r108.a(), r108.b());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r103.label = 1;
        r105 = c(r100, r101, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new OfficeCardDocContentServiceImpl$getDocContent$1(this, r102);
        goto L8
    }

    @Override // com.larus.office.card.doc.content.IOfficeCardDocContentService
    public final Object b(String r100, int r101, Continuation<? super String> r102) {
        if ((r102 instanceof OfficeCardDocContentServiceImpl$getDocumentContent$1) == false) goto L7;
        OfficeCardDocContentServiceImpl$getDocumentContent$1 r103 = (OfficeCardDocContentServiceImpl$getDocumentContent$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        com.larus.office.card.doc.content.a r108 = (com.larus.office.card.doc.content.a) r105;
        if (r108 != null) goto L22;
        return null;
    L22:
        return r108.f361368a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r103.label = 1;
        r105 = a(r100, r101, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new OfficeCardDocContentServiceImpl$getDocumentContent$1(this, r102);
        goto L8
    }

    public final Object c(String r110, int r111, Continuation<? super d> r112) {
        if ((r112 instanceof OfficeCardDocContentServiceImpl$getDocContentInternal$1) == false) goto L7;
        OfficeCardDocContentServiceImpl$getDocContentInternal$1 r100 = (OfficeCardDocContentServiceImpl$getDocContentInternal$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        OfficeCardDocContentServiceImpl$getDocContentInternal$1 r102 = r100;
        Object r113 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L23:
        dm9.a r114 = (dm9.a) r113;
        if ((r114 instanceof dm9.a.b) == true) goto L26;
        return null;
    L26:
        return ((dm9.a.b) r114).f469231a.getData();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        FLogger.f375446a.i("OfficeCardDocContentHelper", "[getDocumentContent] resourceId:" + r110);
        if (r110.length() != 0) goto L17;
        boolean r115 = true;
    L18:
        if (r115 == false) goto L20;
        return null;
    L20:
        OfficeCardDocContentApi.a r116 = OfficeCardDocContentApi.f361363a;
        OfficeCardDocContentServiceImpl$getDocContentInternal$result$1 r105 = new OfficeCardDocContentServiceImpl$getDocContentInternal$result$1(r110, r111, null);
        r102.label = 1;
        r116.getClass();
        FlowHttpConnection r117 = FlowHttpConnection.f359975a;
        r113 = FlowHttpConnection.g(ServiceType.BASIC_SERVICE, OfficeCardDocContentApi.class, r105, false, null, null, null, r102, 248);
        if (r113 != r103) goto L23;
        return r103;
    L17:
        r115 = false;
    L7:
        r100 = new OfficeCardDocContentServiceImpl$getDocContentInternal$1(this, r112);
        goto L8
    }
}
