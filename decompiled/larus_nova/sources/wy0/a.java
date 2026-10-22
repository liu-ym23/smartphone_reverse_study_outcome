package wy0;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a<P, R> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public a() {
    }

    public final void j(R r100) {
        if (r100 != null) goto L4;
        finishWithSuccess();
        return;
    L4:
        finishWithResult(r100);
    }
}
