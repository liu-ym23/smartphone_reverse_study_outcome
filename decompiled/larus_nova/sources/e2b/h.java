package e2b;

import com.bytedance.lark.pb.basic.v1.Message;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f470865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f470866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f470867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f470868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f470869e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Message.PartialReplyInfo f470870f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f470871g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f470872h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Scene f470873i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MonitorMessageSendCallback f470874j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f470875k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f470876l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.ss.android.lark.chat.entity.message.a f470877m;

    public interface a {
        void a(PolarisFileWrapper r100);
    }

    public final MonitorMessageSendCallback a() {
        if (this.f470874j != null) goto L6;
        this.f470874j = new MonitorMessageSendCallback();
    L6:
        return this.f470874j;
    }

    public h(String r100, List<String> r101) {
        this.f470872h = false;
        this.f470865a = r100;
        this.f470866b = r101;
        this.f470875k = new e2b.a(this);
        this.f470876l = ImSdkProxy.c().isFeatureGatingEnable("lark.android.img.convert.to.webp");
    }
}
