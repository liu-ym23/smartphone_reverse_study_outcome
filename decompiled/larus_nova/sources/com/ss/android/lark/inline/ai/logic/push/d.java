package com.ss.android.lark.inline.ai.logic.push;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.C5058b f427343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f427344b;

    public d(b.C5058b r100, String r101) {
        this.f427343a = r100;
        this.f427344b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        b.C5058b r101 = this.f427343a;
        String r102 = this.f427344b;
        new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        Exception r103 = new Exception((Throwable) r100);
        ErrorResult r104 = new ErrorResult(0);
        ErrorResult.access$002(r104, -1);
        ErrorResult.access$102(r104, -9999);
        ErrorResult.access$202(r104, 0);
        ErrorResult.access$302(r104, r103);
        ErrorResult.access$402(r104, "");
        ErrorResult.access$502(r104, "");
        ErrorResult.access$602(r104, "");
        ErrorResult.access$702(r104, "");
        ErrorResult.access$802(r104, 0);
        ErrorResult.access$902(r104, null);
        ErrorResult.access$1002(r104, null);
        ErrorResult.access$1102(r104, null);
        monitor-enter(r101);
        List r105 = (List) ((LinkedHashMap) r101.f427339a).get(r102);     // Catch: Throwable -> L15
        if (r105 == null) goto L10;
        Iterator<T> r106 = r105.iterator();     // Catch: Throwable -> L15
    L8:
        if (r106.hasNext() == false) goto L10;
        ((IGetDataCallback) r106.next()).onError(r104);     // Catch: Throwable -> L15
    L10:
        List r107 = (List) ((LinkedHashMap) r101.f427339a).get(r102);     // Catch: Throwable -> L15
        if (r107 == null) goto L13;
        r107.clear();     // Catch: Throwable -> L15
    L13:
        monitor-exit(r101);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
