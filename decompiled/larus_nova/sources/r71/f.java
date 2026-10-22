package r71;

import com.bytedance.android.live.room.api.messagewindow.model.CommonCardInitScene;
import com.bytedance.android.live.room.api.messagewindow.state.source.CardDataState;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f536400d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f536401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CardDataState f536402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CommonCardInitScene f536403c;

    public static final class a {
        @JvmStatic
        public static f a(int r100, CardDataState r101, CommonCardInitScene r102) {
            Intrinsics.checkNotNullParameter(r101, "state");
            Intrinsics.checkNotNullParameter(r102, "initScene");
            return new f(r100, r101, r102);
        }
    }

    static {
    }

    public f(int r100, CardDataState r101, CommonCardInitScene r102) {
        this.f536401a = r100;
        this.f536402b = r101;
        this.f536403c = r102;
    }
}
