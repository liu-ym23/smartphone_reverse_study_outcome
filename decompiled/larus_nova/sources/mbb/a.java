package mbb;

import com.ss.android.lark.larkicon.IconScene;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f512801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IconScene f512802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f512803c;

    public a(boolean r100, IconScene r101, long r102) {
        this.f512801a = r100;
        this.f512802b = r101;
        this.f512803c = r102;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        boolean r100 = c.f512807a;
        c.j(this.f512801a, this.f512802b, true, this.f512803c);
    }
}
