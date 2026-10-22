package vf8;

import com.larus.bmhome.chat.list.cell.loading.LoadingType;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g extends xc8.b {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f554604a = null;

        static {
            int[] r100 = new int[LoadingType.values().length];
            r100[LoadingType.IN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[LoadingType.OUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f554604a = r100;
        }
    }

    @Override // xc8.b
    public final int d() {
        LoadingType r100 = i.a(this.f563233a);
        if (r100 != null) goto L5;
        int r101 = -1;
    L7:
        if (r101 != 1) goto L9;
        return 0;
    L9:
        if (r101 != 2) goto L15;
        return 1;
    L15:
        return -1;
    L5:
        r101 = a.f554604a[r100.ordinal()];
        goto L7
    }

    public g(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "loadingMessage");
        super(r100);
    }
}
