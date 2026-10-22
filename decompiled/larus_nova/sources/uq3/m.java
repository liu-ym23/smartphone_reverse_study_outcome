package uq3;

import com.bytedance.android.ec.model.ECUrlModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f551242d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECUrlModel f551243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f551244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f551245c;

    public static final class a {
    }

    static {
    }

    public m(ECUrlModel r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        Intrinsics.checkNotNullParameter(r101, "jumpUrl");
        Intrinsics.checkNotNullParameter("window_private_message", "name");
        this.f551243a = r100;
        this.f551244b = r101;
        this.f551245c = "window_private_message";
    }
}
