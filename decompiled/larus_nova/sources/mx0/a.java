package mx0;

import com.bytedance.android.livesdkapi.service.RevMessageHub;
import com.tencent.open.SocialConstants;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;
import u01.l;
import yh6.f;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RevMessageHub f516159a;

    public a(l r100) {
        Intrinsics.checkNotNullParameter(r100, "revMessageHub");
        this.f516159a = r100;
    }

    public final Observable a(f r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        return this.f516159a.observe(r100.f567604a, r100.getType().getType());
    }
}
