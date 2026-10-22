package zlb;

import com.bytedance.lark.pb.space.doc.v1.InlineAITaskStatus;
import com.ss.android.lark.inline.ai.api.ScenarioType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, a> f572826a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f572827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ScenarioType f572828b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f572829c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f572830d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f572831e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f572832f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f572833g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public InlineAITaskStatus f572834h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f572835i;

        public a(String r100, ScenarioType r101, String r102, String r103) {
            long r104 = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r101, "scenario");
            Intrinsics.checkNotNullParameter(r102, "promptId");
            Intrinsics.checkNotNullParameter(r103, "promptType");
            this.f572827a = r100;
            this.f572828b = r101;
            this.f572829c = r102;
            this.f572830d = r103;
            this.f572831e = r104;
        }
    }

    static {
        f572826a = new LinkedHashMap();
    }

    public static void a(InlineAITaskStatus r210) {
        Intrinsics.checkNotNullParameter(r210, "data");
        Map<String, a> r100 = f572826a;
        a r101 = (a) ((LinkedHashMap) r100).get(r210.unique_task_id);
        if (r101 == null) goto L27;
        Intrinsics.checkNotNullParameter(r210, "data");
        r101.f572834h = r210;
        boolean r102 = true;
        r101.f572835i++;
        long r103 = System.currentTimeMillis();
        if (r210.content.length() > 0) goto L9;
        r102 = false;
    L9:
        if (r102 == false) goto L15;
        if (r101.f572832f != 0) goto L13;
        r101.f572832f = r103;
    L13:
        r101.f572833g = r103;
    L15:
        if (Intrinsics.areEqual(r210.task_status, "processing") == true) goto L28;
        int r104 = zlb.a.f572823d;
        ScenarioType r110 = r101.f572828b;
        String r111 = r101.f572829c;
        String r112 = r101.f572830d;
        int r113 = (int) r210.status_code.longValue();
        String r114 = r210.task_status;
        long r105 = r101.f572832f;
        if (r105 <= 0) goto L20;
        int r106 = (int) (r105 - r101.f572831e);
        long r115 = 0;
    L22:
        if (r105 <= r115) goto L24;
        int r116 = (int) (r103 - r105);
    L25:
        zlb.a.C8475a.b(r110, r111, r112, r113, r114, r106, r116, (int) (r103 - r101.f572831e), r210.content.length(), r101.f572835i, 0);
        String r107 = r101.f572827a;
        Intrinsics.checkNotNullParameter(r107, DBDefinition.TASK_ID);
        r100.remove(r107);
        return;
    L24:
        r116 = 0;
        goto L25
    L20:
        r115 = 0;
        r106 = 0;
        goto L22
    L28:
        return;
    }
}
