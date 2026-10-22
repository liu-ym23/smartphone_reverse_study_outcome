package sn;

import com.bytedance.android.ec.store.window.popup.entity.PopupActionType;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PopupActionType f542616a;

    public static final class a extends d {
        public a() {
            super(PopupActionType.CLOSE_SELF);
        }
    }

    public static final class b {
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f542617b;

        public c(long r100) {
            super(PopupActionType.DELAYED_CLOSE_SELF);
            this.f542617b = r100;
        }
    }

    /* JADX INFO: renamed from: sn.d$d, reason: collision with other inner class name */
    public static final class C7629d extends d {
    }

    static {
    }

    public d(PopupActionType r100) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        this.f542616a = r100;
    }
}
