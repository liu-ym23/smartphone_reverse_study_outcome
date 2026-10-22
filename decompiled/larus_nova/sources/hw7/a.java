package hw7;

import android.content.Context;
import com.hihonor.cloudservice.common.ApiException;
import com.hihonor.cloudservice.support.api.clients.Status;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import kw7.e;

/* JADX INFO: loaded from: classes23.dex */
public final class a implements ew7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f487427a;

    public final void a(ErrorStatus r100) {
        this.f487427a.a(new ApiException(new Status(r100.f276629a, r100.f276630b, null)));
    }

    public a(Context r100, String r101, e r102) {
        this.f487427a = r102;
    }
}
