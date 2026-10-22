package dh3;

import com.obric.trace.ObricActionBarTrackType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f468585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f468586b;

    /* JADX INFO: renamed from: dh3.a$a, reason: collision with other inner class name */
    public static final class C5669a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        if (this.f468585a == false) goto L5;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, "guess_you_like_product", com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);
    L5:
        appendParam(ObricActionBarTrackType.KEY_SHOW_POSITION, String.valueOf(this.f468586b));
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
    }
}
