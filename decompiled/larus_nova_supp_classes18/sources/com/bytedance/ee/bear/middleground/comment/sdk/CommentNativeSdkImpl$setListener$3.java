package com.bytedance.ee.bear.middleground.comment.sdk;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", ResourceData.KEY_ID, "", "commentUUID", "commentType", "", "<unused var>", "invoke", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)V"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class CommentNativeSdkImpl$setListener$3 extends Lambda implements Function4<String, String, Integer, Integer, Unit> {
    final /* synthetic */ a this$0;

    public CommentNativeSdkImpl$setListener$3(a r1) {
        super(4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        invoke((String) r1, (String) r2, ((Number) r3).intValue(), (Integer) r4);
        return Unit.INSTANCE;
    }

    public final void invoke(String r1, String r2, int r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r1, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r2, "commentUUID");
        throw null;
    }
}
