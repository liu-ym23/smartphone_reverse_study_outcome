package x8c;

import com.ss.android.eventbus.BaseEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c extends BaseEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f562960a;

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "todoGuid");
        this.f562960a = r100;
    }
}
