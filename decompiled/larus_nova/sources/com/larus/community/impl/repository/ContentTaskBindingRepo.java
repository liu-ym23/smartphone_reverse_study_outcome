package com.larus.community.impl.repository;

import com.larus.community.impl.api.ContentTaskBindingApi;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class ContentTaskBindingRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ContentTaskBindingRepo f329762a = null;

    static {
        f329762a = new ContentTaskBindingRepo();
    }

    public ContentTaskBindingRepo() {
    }

    public final Object a(String r100, String r101, String r102, Continuation<? super Unit> r103) {
        if ((r103 instanceof ContentTaskBindingRepo$checkAndSaveContentTaskBinding$1) == false) goto L7;
        ContentTaskBindingRepo$checkAndSaveContentTaskBinding$1 r104 = (ContentTaskBindingRepo$checkAndSaveContentTaskBinding$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        ResultKt.throwOnFailure(r106);
    L27:
        dm9.a r109 = (dm9.a) r106;
        if ((r109 instanceof dm9.a.b) == false) goto L31;
        FLogger.f375446a.i("ContentTaskBindingRepo", "saveContentTaskBinding success");
    L34:
        return Unit.INSTANCE;
    L31:
        if ((r109 instanceof dm9.a.C5690a) == false) goto L34;
        FLogger.f375446a.e("ContentTaskBindingRepo", "saveContentTaskBinding failed: " + ((dm9.a.C5690a) r109).f469230c);
        goto L34
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        if (r100 != null) goto L17;
    L20:
        boolean r110 = true;
    L21:
        if (r110 == false) goto L34;
        if (o0.d(r101) == false) goto L34;
        ContentTaskBindingApi.Companion r111 = ContentTaskBindingApi.f328804a;
        ContentTaskBindingRepo$checkAndSaveContentTaskBinding$result$1 r112 = new ContentTaskBindingRepo$checkAndSaveContentTaskBinding$result$1(r101, r102, null);
        r104.label = 1;
        r111.getClass();
        r106 = ContentTaskBindingApi.Companion.a(r112, r104);
        if (r106 != r107) goto L27;
        return r107;
    L17:
        if (r100.length() == 0) goto L20;
        r110 = false;
    L7:
        r104 = new ContentTaskBindingRepo$checkAndSaveContentTaskBinding$1(this, r103);
        goto L8
    }
}
