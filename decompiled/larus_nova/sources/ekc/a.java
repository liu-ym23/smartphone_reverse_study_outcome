package ekc;

import com.larksuite.framework.callback.IGetDataCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IGetDataCallback<String> f472971a;

    public a(String r100, String r101, IGetDataCallback<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f472971a = r102;
    }
}
