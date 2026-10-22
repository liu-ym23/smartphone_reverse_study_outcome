package tt1;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.announcement.AnnouncementApi;
import com.bytedance.android.livesdk.announcement.highlight.e0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f547523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBaseCallbackSchemaHandler.SchemaCallback f547524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f547525c;

    public g(k r100, IBaseCallbackSchemaHandler.SchemaCallback r101, String r102) {
        this.f547523a = r100;
        this.f547524b = r101;
        this.f547525c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((AnnouncementApi.SubscribeRequestResponse) ((BaseResponse) r100).data).getResponseStatus() != 1) goto L11;
        IBaseCallbackSchemaHandler.SchemaCallback r101 = this.f547524b;
        if (r101 == null) goto L8;
        r101.onSuccess(0, "");
    L8:
        if (Intrinsics.areEqual(this.f547525c, "1") == false) goto L12;
        this.f547523a.getClass();
        xs2.b.a().post(new e0(true));
        return;
    L12:
        return;
    }
}
