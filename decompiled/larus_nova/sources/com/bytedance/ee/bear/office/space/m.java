package com.bytedance.ee.bear.office.space;

import com.bytedance.ee.bear.drive.biz.preview.more.save2space.DriveSpaceFileAttachmentExecutor;
import io.reactivex.functions.Consumer;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes18.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Result<Unit>, Unit> f236122a;

    public m(com.larus.drive.sdk.impl.view.preview.b r100) {
        this.f236122a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        DriveSpaceFileAttachmentExecutor.AttachSaveResponse r101 = (DriveSpaceFileAttachmentExecutor.AttachSaveResponse) r100;
        Function1<Result<Unit>, Unit> r102 = this.f236122a;
        Result.Companion r103 = Result.Companion;
        r102.invoke(Result.m9448boximpl(Result.m9449constructorimpl(Unit.INSTANCE)));
    }
}
