package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import android.content.DialogInterface;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements DialogInterface.OnClickListener {
    public final /* synthetic */ CommentVoiceMentionPermissionHelper a;
    public final /* synthetic */ CommentVoiceMentionPermissionHelper.a.C0048a b;
    public final /* synthetic */ Function1<Boolean, Unit> c;

    /* JADX WARN: Multi-variable type inference failed */
    public m(CommentVoiceMentionPermissionHelper r1, CommentVoiceMentionPermissionHelper.a.C0048a r2, Function1<? super Boolean, Unit> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r6) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).j0();
        boolean r7 = false;
        jg5.k.a.a.b(false);
        CommentVoiceMentionPermissionHelper r8 = this.a;
        List<String> r0 = this.b.e;
        Function1<Boolean, Unit> r1 = this.c;
        r8.getClass();
        boolean r2 = com.bytedance.ee.bear.middleground.comment.export.e.b();
        Intrinsics.checkNotNullParameter(r0, "requestUserIds");
        if (r2 == true) goto L5;
    L7:
        if (r7 == false) goto L9;
        r8.d(r0, r1);
        return;
    L9:
        r1.invoke(Boolean.TRUE);
        return;
    L5:
        if ((!r0.isEmpty()) == false) goto L7;
        r7 = true;
        goto L7
    }
}
