package z61;

import com.bytedance.android.live.room.api.messagewindow.process.MsgWindowAdjustSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b extends o70.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f570443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f570444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f570445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f570446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h71.a f570447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MsgWindowAdjustSource f570448f;

    public b() {
        this(false, false, false, false, new h71.a(), MsgWindowAdjustSource.UNKNOWN);
    }

    public final String toString() {
        return "MsgWindowPositionAdjustEvent(isShown=" + this.f570447e.f483968a + ", adjustTopMargin=" + this.f570443a + ", adjustBottomMargin=" + this.f570444b + ", adjustRightMargin=" + this.f570445c + ", adjustLeftMargin=" + this.f570446d + ", topMargin=" + this.f570447e.f483969b + ", bottomMargin=" + this.f570447e.f483971d + ", rightMargin=" + this.f570447e.f483970c + ", leftMargin=" + this.f570447e.f483972e + ", source=" + this.f570448f.getDescription() + ')';
    }

    public b(boolean r100, boolean r101, boolean r102, boolean r103, h71.a r104, MsgWindowAdjustSource r105) {
        Intrinsics.checkNotNullParameter(r104, "adjustConfig");
        Intrinsics.checkNotNullParameter(r105, "source");
        this.f570443a = r100;
        this.f570444b = r101;
        this.f570445c = r102;
        this.f570446d = r103;
        this.f570447e = r104;
        this.f570448f = r105;
    }
}
