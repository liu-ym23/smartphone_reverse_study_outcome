package j1c;

import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import l1c.d;

/* JADX INFO: loaded from: classes37.dex */
public final class c extends g1c.a<String> implements i1c.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap<String, Biz> f496895d = null;

    public static final class a {
    }

    @Override // g1c.b
    public final boolean isValid() {
        return true;
    }

    static {
        Biz r100 = Biz.Messenger;
        Biz r101 = Biz.Docs;
        Biz r102 = Biz.VideoConference;
        Biz r103 = Biz.Todo;
        f496895d = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("conversation", r100), TuplesKt.to("group", r100), TuplesKt.to("pin", r100), TuplesKt.to("calendar", Biz.Calendar), TuplesKt.to("appCenter", Biz.OpenPlatform), TuplesKt.to("space", r101), TuplesKt.to("wiki", r101), TuplesKt.to("contact", Biz.UserGrowth), TuplesKt.to(IOfflineExtraParser.ParserType.MAIL, Biz.Mail), TuplesKt.to("videochat", r102), TuplesKt.to("videomm", r102), TuplesKt.to(ShareChannel.WX_MOMENTS, Biz.Moments), TuplesKt.to(IOfflineExtraParser.ParserType.TODO, r103), TuplesKt.to("pano", r103), TuplesKt.to("more", Biz.Core)});
    }

    public c() {
        super("");
    }

    @Override // g1c.b
    public final Class<k1c.b<String>> b() {
        return d.class;
    }

    @Override // g1c.a, g1c.b
    public final void e(o1c.c<?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r100, "task");
        Biz r101 = f496895d.get(this.f479633c);
        if (r100.getBiz() != r101) goto L5;
        r100.setPriority(r100.getPriority() + 50);
    L5:
        Log.d("PrimaryTab", "checkCondition, task is " + r100.getClass().getSimpleName() + ", biz is " + r101);
    }
}
