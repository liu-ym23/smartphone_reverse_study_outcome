package kw2;

import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f506384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f506385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Element<?> f506386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f506387d;

    public a(String r100, String r101, Element<?> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "tag");
        this.f506384a = r100;
        this.f506385b = r101;
        this.f506386c = r102;
        this.f506387d = r103;
    }

    public /* synthetic */ a(String r100, String r101, Element r102, int r103) {
        if ((r103 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r103 & 8) == 0) goto L8;
        boolean r104 = true;
    L9:
        this(r100, r101, r102, r104);
        return;
    L8:
        r104 = false;
        goto L9
    }
}
