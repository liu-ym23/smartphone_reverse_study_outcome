package i81;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.bytedance.android.live.base.model.user.f;
import com.bytedance.android.livehostapi.business.depend.share.IShareDirectTypeCallback;
import com.bytedance.android.livehostapi.business.depend.share.IUgShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f488544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f488545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f488546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ShareParams f488547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f488548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f488549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f488550g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f488551h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Object> f488552i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<String, Unit> f488553j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f488554k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Boolean f488555l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Dialog f488556m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final JSONObject f488557n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final IUgShareCallback f488558o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final IShareDirectTypeCallback f488559p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f488560q;

    /* JADX INFO: renamed from: i81.a$a, reason: collision with other inner class name */
    public static final class C6239a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f488561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Activity f488562b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f f488563c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ShareParams f488564d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List<String> f488565e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<String> f488566f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f488567g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f488568h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Map<String, Object> f488569i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Function1<? super String, Unit> f488570j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f488571k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f488572l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Dialog f488573m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public JSONObject f488574n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public IUgShareCallback f488575o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public IShareDirectTypeCallback f488576p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f488577q;

        public C6239a() {
            this(null);
        }

        public final a a() {
            return new a(this.f488561a, this.f488562b, this.f488563c, this.f488564d, this.f488565e, this.f488566f, this.f488567g, this.f488568h, this.f488569i, this.f488570j, this.f488571k, Boolean.valueOf(this.f488572l), this.f488573m, this.f488574n, this.f488575o, this.f488576p, this.f488577q);
        }

        public C6239a(Object r100) {
            this.f488561a = null;
            this.f488562b = null;
            this.f488563c = null;
            this.f488564d = null;
            this.f488565e = null;
            this.f488566f = null;
            this.f488567g = null;
            this.f488568h = null;
            this.f488569i = null;
            this.f488570j = null;
            this.f488571k = null;
            this.f488572l = false;
            this.f488573m = null;
            this.f488574n = null;
            this.f488575o = null;
            this.f488576p = null;
            this.f488577q = false;
        }
    }

    public final String toString() {
        return "LiveShareParams(context=" + this.f488544a + ", activity=" + this.f488545b + ", contactUser=" + this.f488546c + ", shareParams=" + this.f488547d + ", fansGroupIdList=" + this.f488548e + ", videoFilePathList=" + this.f488549f + ", conversationId=" + this.f488550g + ", text=" + this.f488551h + ", activityParams=" + this.f488552i + ", callback=" + this.f488553j + ", reportType=" + this.f488554k + ", sharePosterEnable=" + this.f488555l + ')';
    }

    public final Activity getActivity() {
        return this.f488545b;
    }

    public final Context getContext() {
        return this.f488544a;
    }

    public a(Context r100, Activity r101, f r102, ShareParams r103, List r104, List r105, String r106, String r110, Map r111, Function1 r112, String r113, Boolean r114, Dialog r115, JSONObject r116, IUgShareCallback r117, IShareDirectTypeCallback r118, boolean r119) {
        this.f488544a = r100;
        this.f488545b = r101;
        this.f488546c = r102;
        this.f488547d = r103;
        this.f488548e = r104;
        this.f488549f = r105;
        this.f488550g = r106;
        this.f488551h = r110;
        this.f488552i = r111;
        this.f488553j = r112;
        this.f488554k = r113;
        this.f488555l = r114;
        this.f488556m = r115;
        this.f488557n = r116;
        this.f488558o = r117;
        this.f488559p = r118;
        this.f488560q = r119;
    }
}
