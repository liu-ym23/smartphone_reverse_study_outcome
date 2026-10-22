package tt1;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.announcement.AnnouncementApi;
import com.bytedance.android.livesdk.announcement.highlight.e0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f547527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBaseCallbackSchemaHandler.SchemaCallback f547528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f547529c;

    public i(k r100, IBaseCallbackSchemaHandler.SchemaCallback r101, String r102) {
        this.f547527a = r100;
        this.f547528b = r101;
        this.f547529c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((AnnouncementApi.SubscribeRequestResponse) ((BaseResponse) r100).data).getResponseStatus() != 1) goto L11;
        IBaseCallbackSchemaHandler.SchemaCallback r101 = this.f547528b;
        if (r101 == null) goto L8;
        r101.onSuccess(0, "");
    L8:
        if (Intrinsics.areEqual(this.f547529c, "1") == false) goto L12;
        this.f547527a.getClass();
        xs2.b.a().post(new e0(false));
        return;
    L12:
        return;
    }
}
