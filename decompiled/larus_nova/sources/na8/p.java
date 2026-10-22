package na8;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.larus.utils.logger.FLogger;
import com.larus.xbridge.IXBridgeApi;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class p implements gk5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f518480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f518481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IvyBridgeMethod.a f518482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f518483d;

    @Override // gk5.a
    public final void onCancel() {
        if (this.f518480a.compareAndSet(false, true) == false) goto L5;
        FLogger.f375446a.i("OfficeCCMH5JSBMethod", "handle cancelled, method=" + this.f518481b.f518476b);
        bx7.c.c(this.f518481b, this.f518482c, -7, "User cancelled", 8);
        this.f518481b.i(this);
        return;
    L5:
        a("cancel");
    }

    public final void a(String r100) {
        FLogger.f375446a.w("OfficeCCMH5JSBMethod", "ignore duplicate callback, method=" + this.f518481b.f518476b + ", type=" + r100);
    }

    @Override // gk5.a
    public final void onEvent(JSONObject r100) {
        Intrinsics.checkNotNullParameter("biz.forms.onFrameRecorded", "name");
        Intrinsics.checkNotNullParameter(r100, "data");
        if (Intrinsics.areEqual("biz.forms.onFrameRecorded", this.f518481b.f518477c) == true) goto L6;
        FLogger.f375446a.w("OfficeCCMH5JSBMethod", "drop unexpected event, method=" + this.f518481b.f518476b + ", event=biz.forms.onFrameRecorded");
        return;
    L6:
        IXBridgeApi.Companion r101 = IXBridgeApi.f379669a;
        this.f518481b.getClass();
        r101.b("biz.forms.onFrameRecorded", o.g(r100), this.f518483d);
        FLogger.f375446a.i("OfficeCCMH5JSBMethod", "send event, method=" + this.f518481b.f518476b + ", event=biz.forms.onFrameRecorded, containerId=" + this.f518483d);
        if (this.f518481b.f(r100) == false) goto L10;
        this.f518481b.i(this);
        return;
    }

    @Override // gk5.a
    public final void onSuccess(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (this.f518480a.compareAndSet(false, true) == false) goto L5;
        FLogger.f375446a.i("OfficeCCMH5JSBMethod", "handle success, method=" + this.f518481b.f518476b);
        o r101 = this.f518481b;
        IvyBridgeMethod.a r102 = this.f518482c;
        r101.getClass();
        bx7.c.d(r101, r102, o.g(r100));
        return;
    L5:
        a("success");
    }

    @Override // gk5.a
    public final void onFailure(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        if (this.f518480a.compareAndSet(false, true) == false) goto L5;
        FLogger.f375446a.w("OfficeCCMH5JSBMethod", "handle failure, method=" + this.f518481b.f518476b + ", code=" + r100);
        bx7.c.c(this.f518481b, this.f518482c, r100, r101, 8);
        this.f518481b.i(this);
        return;
    L5:
        a("failure");
    }

    public p(AtomicBoolean r100, o r101, ux7.d.C7943d r102, String r103) {
        this.f518480a = r100;
        this.f518481b = r101;
        this.f518482c = r102;
        this.f518483d = r103;
    }
}
