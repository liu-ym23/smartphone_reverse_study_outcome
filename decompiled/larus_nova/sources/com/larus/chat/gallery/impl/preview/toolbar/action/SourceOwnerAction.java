package com.larus.chat.gallery.impl.preview.toolbar.action;

import com.larus.chat.gallery.api.PreviewSourceAction;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class SourceOwnerAction implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.chat.gallery.api.q f324706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PreviewSourceAction f324707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f324708c;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.chat.gallery.impl.preview.toolbar.action.o
    public final Object a(l0 r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof SourceOwnerAction$execute$1) == false) goto L7;
        SourceOwnerAction$execute$1 r102 = (SourceOwnerAction$execute$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L22:
        if (this.f324708c != null) goto L24;
        FLogger.f375446a.w("SourceOwnerAction", "unsupported source action: action=" + this.f324707b);
        return Unit.INSTANCE;
    L24:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        String r107 = r100.f324766a.f565427b;
        if (this.f324706a.l(this.f324707b, r107) == true) goto L28;
        o r108 = this.f324708c;
        if (r108 == null) goto L22;
        r102.label = 1;
        if (r108.a(r100, r102) != r105) goto L22;
        return r105;
    L28:
        if (this.f324706a.v(this.f324707b, r107, new k0(r100)) == true) goto L31;
        FLogger.f375446a.w("SourceOwnerAction", "source rejected action: action=" + this.f324707b);
    L31:
        return Unit.INSTANCE;
    L7:
        r102 = new SourceOwnerAction$execute$1(this, r101);
        goto L8
    }

    public SourceOwnerAction(com.larus.chat.gallery.api.q r100, PreviewSourceAction r101, o r102) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "action");
        this.f324706a = r100;
        this.f324707b = r101;
        this.f324708c = r102;
    }
}
