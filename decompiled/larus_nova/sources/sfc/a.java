package sfc;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.statistics.Statistics;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C7605a f541747a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f541748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f541749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f541750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f541751e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f541752f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f541753g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f541754h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final List<Integer> f541755i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final List<Integer> f541756j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final List<Integer> f541757k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static b f541758l;

    /* JADX INFO: renamed from: sfc.a$a, reason: collision with other inner class name */
    public static final class C7605a {
        public C7605a() {
        }

        public static void c() {
            Intrinsics.checkNotNullParameter("thickness", SocialConstants.PARAM_ACT);
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L9
            if (a.f541758l == null) goto L6;
            Statistics.sendEvent("public_pic_edit_mosaic_click", new JSONObject().put("click", "thickness").put(PickerReporterConstants.KEY.TARGET, "none"));     // Catch: Throwable -> L9
            Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L9
        L7:
            Object r102 = Result.m9449constructorimpl(r101);     // Catch: Throwable -> L9
        L11:
            Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
            if (r103 == null) goto L17;
            Log.e("HitPointHelper", "sendPicEditMosaicClickEvent error. t: " + r103.getMessage());
            return;
        L17:
            return;
        L6:
            r101 = null;
        L9:
            th = move-exception;
            Result.Companion r104 = Result.Companion;
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L11
        }

        public static void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_ACT);
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
            if (a.f541758l == null) goto L6;
            Statistics.sendEvent("public_pic_edit_click", new JSONObject().put("click", r100));     // Catch: Throwable -> L9
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L9
        L7:
            Object r103 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L9
        L11:
            Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
            if (r104 == null) goto L17;
            Log.e("HitPointHelper", "sendPicEditClickEvent error. t: " + r104.getMessage());
            return;
        L17:
            return;
        L6:
            r102 = null;
        L9:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L11
        }

        public static void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_ACT);
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
            if (a.f541758l == null) goto L6;
            Statistics.sendEvent("public_pic_edit_graph_click", new JSONObject().put("click", r100).put(PickerReporterConstants.KEY.TARGET, "none"));     // Catch: Throwable -> L9
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L9
        L7:
            Object r103 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L9
        L11:
            Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
            if (r104 == null) goto L17;
            Log.e("HitPointHelper", "sendPicEditGraphClickEvent error. t: " + r104.getMessage());
            return;
        L17:
            return;
        L6:
            r102 = null;
        L9:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L11
        }

        public static String d(List r100) {
            Iterator r101 = r100.iterator();
            String r102 = "";
        L4:
            if (r101.hasNext() == false) goto L6;
            r102 = r102 + ((Number) r101.next()).intValue() + ", ";
            goto L4
        L6:
            return r102;
        }
    }

    public interface b {
    }

    static {
        f541747a = new C7605a();
        f541755i = new ArrayList();
        f541756j = new ArrayList();
        f541757k = new ArrayList();
    }
}
