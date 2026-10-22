package r5;

import android.os.FileObserver;
import com.obric.sva.sdk.data.ISmModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e extends FileObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f536130a;

    public e(a r100, String r101) {
        this.f536130a = r100;
        super(r101, ISmModel.VERSION_0600);
    }

    @Override // android.os.FileObserver
    public final void onEvent(int r100, String r101) {
        if (r100 != 512) goto L5;
    L7:
        d r102 = f.f536131a;
        a r103 = this.f536130a;
        Intrinsics.checkNotNullParameter(r103, "info");
        String r104 = r103.f536119b;
        d r105 = f.f536131a;
        if (r105 == null) goto L10;
        a r106 = r105.remove(r104);
    L10:
        f.f536132b.remove(r104);
        return;
    L5:
        if (r100 == 1024) goto L7;
    }
}
