package com.bytedance.ee.bear.middleground.comment.sdk;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class CommentNativeSdkImpl$createComment$1$3 extends Lambda implements Function1<List<? extends String>, Unit> {
    public static final CommentNativeSdkImpl$createComment$1$3 INSTANCE = null;

    static {
        INSTANCE = new CommentNativeSdkImpl$createComment$1$3();
    }

    public CommentNativeSdkImpl$createComment$1$3() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
