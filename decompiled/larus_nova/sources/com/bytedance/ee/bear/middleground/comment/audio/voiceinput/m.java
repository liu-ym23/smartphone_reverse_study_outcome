package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import android.content.DialogInterface;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class m implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentVoiceMentionPermissionHelper f230494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CommentVoiceMentionPermissionHelper.a.C3295a f230495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f230496c;

    /* JADX WARN: Multi-variable type inference failed */
    public m(CommentVoiceMentionPermissionHelper r100, CommentVoiceMentionPermissionHelper.a.C3295a r101, Function1<? super Boolean, Unit> r102) {
        this.f230494a = r100;
        this.f230495b = r101;
        this.f230496c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).j0();
        boolean r102 = false;
        jg5.k.a.f499019a.b(false);
        CommentVoiceMentionPermissionHelper r103 = this.f230494a;
        List<String> r104 = this.f230495b.f230380e;
        Function1<Boolean, Unit> r105 = this.f230496c;
        r103.getClass();
        boolean r106 = com.bytedance.ee.bear.middleground.comment.export.e.b();
        Intrinsics.checkNotNullParameter(r104, "requestUserIds");
        if (r106 == true) goto L5;
    L7:
        if (r102 == false) goto L9;
        r103.d(r104, r105);
        return;
    L9:
        r105.invoke(Boolean.TRUE);
        return;
    L5:
        if ((!r104.isEmpty()) == false) goto L7;
        r102 = true;
        goto L7
    }
}
