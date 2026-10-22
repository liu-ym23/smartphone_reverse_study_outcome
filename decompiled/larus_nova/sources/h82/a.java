package h82;

import com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardPortraitInputDialog;
import com.bytedance.android.livesdkapi.interact.RefreshVSMessageBoardDataEvent;
import io.reactivex.functions.Consumer;
import j82.e;
import j82.f;

/* JADX INFO: loaded from: classes9.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VSMsgBoardPortraitInputDialog f484056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f484057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j82.a f484058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f f484059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ j82.c f484060e;

    public a(VSMsgBoardPortraitInputDialog r100, e r101, j82.a r102, f r103, j82.c r104) {
        this.f484056a = r100;
        this.f484057b = r101;
        this.f484058c = r102;
        this.f484059d = r103;
        this.f484060e = r104;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        RefreshVSMessageBoardDataEvent r101 = (RefreshVSMessageBoardDataEvent) r100;
        e r102 = this.f484057b;
        if (r102 == null) goto L5;
        r102.i();
    L5:
        j82.a r103 = this.f484058c;
        if (r103 == null) goto L8;
        r103.f(this.f484056a.f137204v);
    L8:
        f r104 = this.f484059d;
        if (r104 == null) goto L11;
        r104.h(this.f484056a.f137204v);
    L11:
        j82.c r105 = this.f484060e;
        if (r105 == null) goto L15;
        r105.n(this.f484056a.f137204v);
        return;
    }
}
