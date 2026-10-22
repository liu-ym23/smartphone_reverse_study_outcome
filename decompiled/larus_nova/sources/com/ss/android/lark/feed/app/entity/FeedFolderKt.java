package com.ss.android.lark.feed.app.entity;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\u001a\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"getRuleForFolder", "Lcom/ss/android/lark/feed/app/entity/FeedFolder$AdditionRule;", "", "folderId", "", "feed-export_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class FeedFolderKt {
    public static final FeedFolder.AdditionRule getRuleForFolder(List<FeedFolder.AdditionRule> r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (((FeedFolder.AdditionRule) r103).getFolderId() != r101) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L4;
    L13:
        return (FeedFolder.AdditionRule) r103;
    L8:
        r104 = false;
        goto L9
    L11:
        r103 = null;
        goto L13
    }
}
