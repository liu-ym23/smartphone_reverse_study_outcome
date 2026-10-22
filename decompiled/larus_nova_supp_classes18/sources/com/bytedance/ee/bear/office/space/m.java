package com.bytedance.ee.bear.office.space;

import com.bytedance.ee.bear.drive.biz.preview.more.save2space.DriveSpaceFileAttachmentExecutor;
import io.reactivex.functions.Consumer;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ Function1<Result<Unit>, Unit> a;

    public m(com.larus.drive.sdk.impl.view.preview.b r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        DriveSpaceFileAttachmentExecutor.AttachSaveResponse r3 = (DriveSpaceFileAttachmentExecutor.AttachSaveResponse) r2;
        Function1<Result<Unit>, Unit> r4 = this.a;
        Result.Companion r0 = Result.Companion;
        r4.invoke(Result.box-impl(Result.constructor-impl(Unit.INSTANCE)));
    }
}
