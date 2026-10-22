package com.ss.android.lark.feed.shared.page.unreadAI;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "old", "", "", "new", AbsMethodDelegate.TAG_INVOKE, "(Ljava/util/List;Ljava/util/List;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class UnreadAIFeedListener$1 extends Lambda implements Function2<List<? extends String>, List<? extends String>, Boolean> {
    public static final UnreadAIFeedListener$1 INSTANCE = null;

    static {
        INSTANCE = new UnreadAIFeedListener$1();
    }

    public UnreadAIFeedListener$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(List<String> r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "old");
        Intrinsics.checkNotNullParameter(r101, "new");
        Iterator<T> r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        if (r100.contains((String) r102.next()) == true) goto L4;
        return Boolean.FALSE;
    L10:
        return Boolean.TRUE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(List<? extends String> r100, List<? extends String> r101) {
        return invoke2(r100, r101);
    }
}
