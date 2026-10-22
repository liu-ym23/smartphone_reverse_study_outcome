package com.larus.audio.audiov3.task.sami.v2.flow;

import com.mammon.audiosdk.SAMICoreCallBackListener;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements SAMICoreCallBackListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<SAMICoreCallBackListener> f288580a;

    public b(SAMICoreCallBackListener... r100) {
        Intrinsics.checkNotNullParameter(r100, "listeners");
        CopyOnWriteArrayList<SAMICoreCallBackListener> r101 = new CopyOnWriteArrayList();
        this.f288580a = r101;
        CollectionsKt.addAll(r101, r100);
    }

    @Override // com.mammon.audiosdk.SAMICoreCallBackListener
    public final void onMessageReceived(SAMICoreCallBackEventType r100, SAMICoreBlock r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "data");
        Iterator<T> r102 = this.f288580a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((SAMICoreCallBackListener) r102.next()).onMessageReceived(r100, r101);
        goto L4
    }
}
