package ww7;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.common.data.ApiException;

/* JADX INFO: loaded from: classes23.dex */
public abstract class s<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0<TResult> f561702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f561703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IMessageEntity f561704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t0 f561705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RequestHeader f561706e;

    public abstract void a(ApiException r100, Object r101);

    public s(String r100) {
        this.f561703b = r100;
        this.f561704c = null;
        this.f561705d = new t0(r100);
    }
}
