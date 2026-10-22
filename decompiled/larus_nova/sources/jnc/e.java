package jnc;

import com.story.ai.biz.comment.utils.LoadMoreManagerByPreload;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes38.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LoadMoreManagerByPreload.c f499812a;

    public /* synthetic */ e(LoadMoreManagerByPreload.c r100) {
        this.f499812a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function0<Unit> r100 = this.f499812a.f459920b;
        if (r100 == null) goto L6;
        r100.invoke();
        return;
    }
}
