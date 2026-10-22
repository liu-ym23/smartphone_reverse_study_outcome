package ds0;

import android.app.Dialog;
import com.bytedance.android.live.platformplayer.model.LivePanelType;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LivePanelType f469804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f469805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f469806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<Dialog> f469807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f469808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f469809f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f469810g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f469811h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f469812i;

    public static final class a {
        public static LivePanelType a(String r100) {
            LivePanelType r101 = LivePanelType.AUDIENCE_LIST;
            if (Intrinsics.areEqual(r100, r101.getIdentifier()) == true) goto L25;
            LivePanelType r102 = LivePanelType.HOUR_RANK_LIST;
            if (Intrinsics.areEqual(r100, r102.getIdentifier()) == true) goto L26;
            LivePanelType r103 = LivePanelType.SHOPPING_RANK_LIST;
            if (Intrinsics.areEqual(r100, r103.getIdentifier()) == true) goto L27;
            LivePanelType r104 = LivePanelType.SHOPPING_CAT;
            if (Intrinsics.areEqual(r100, r104.getIdentifier()) == true) goto L28;
            LivePanelType r105 = LivePanelType.RECOGNITION_CONTAINER;
            if (Intrinsics.areEqual(r100, r105.getIdentifier()) == true) goto L29;
            LivePanelType r106 = LivePanelType.LOTTERY;
            if (Intrinsics.areEqual(r100, r106.getIdentifier()) == true) goto L30;
            LivePanelType r107 = LivePanelType.PREDICTOR;
            if (Intrinsics.areEqual(r100, r107.getIdentifier()) == false) goto L24;
            return r107;
        L24:
            return LivePanelType.UN_KNOW;
        L30:
            return r106;
        L29:
            return r105;
        L28:
            return r104;
        L27:
            return r103;
        L26:
            return r102;
        L25:
            return r101;
        }
    }

    static {
    }

    public b() {
        this.f469804a = LivePanelType.UN_KNOW;
        this.f469805b = "undefine";
        this.f469807d = new WeakReference(null);
        this.f469808e = -1;
        this.f469809f = 248;
        this.f469812i = "";
    }

    public final LivePanelType getType() {
        return this.f469804a;
    }

    public final void a(LivePanelType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f469804a = r100;
    }
}
