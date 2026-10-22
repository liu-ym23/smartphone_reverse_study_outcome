package xr1;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.base.model.user.f;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f564828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f564829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f564830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ShareParams f564831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f564832e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f564833f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f564834g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f564835h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Object> f564836i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<String, Unit> f564837j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f564838k;

    public final String toString() {
        return "LiveShareParams(context=" + this.f564828a + ", activity=" + this.f564829b + ", contactUser=" + this.f564830c + ", shareParams=" + this.f564831d + ", fansGroupIdList=" + this.f564832e + ", videoFilePathList=" + this.f564833f + ", conversationId=" + this.f564834g + ", text=" + this.f564835h + ", activityParams=" + this.f564836i + ", callback=" + this.f564837j + ", reportType=" + this.f564838k + ')';
    }

    public final Activity getActivity() {
        return this.f564829b;
    }

    public final Context getContext() {
        return this.f564828a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Context r100, Activity r101, f r102, ShareParams r103, List<String> r104, List<String> r105, String r106, String r107, Map<String, Object> r108, Function1<? super String, Unit> r110, String r111) {
        this.f564828a = r100;
        this.f564829b = r101;
        this.f564830c = r102;
        this.f564831d = r103;
        this.f564832e = r104;
        this.f564833f = r105;
        this.f564834g = r106;
        this.f564835h = r107;
        this.f564836i = r108;
        this.f564837j = r110;
        this.f564838k = r111;
    }
}
