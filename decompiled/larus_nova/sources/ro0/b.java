package ro0;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import kotlin.jvm.internal.Intrinsics;
import tlc.d;
import vlc.l;

/* JADX INFO: loaded from: classes46.dex */
public abstract class b<T extends d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f538751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OpenPlatformContext f538752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.openplatform.impl.base.utils.a f538753c;

    public static final class a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f538754a;

        public a(b r100) {
            this.f538754a = r100;
        }

        @Override // vlc.l
        public final void onMessage(d r100) {
            b r101 = this.f538754a;
            if (r100 == null) goto L7;
            r101.b(r100);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type T");
        }
    }

    public abstract MessageType a();

    public abstract void b(T r100);

    public b(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        this.f538753c = new com.bytedance.android.live.openplatform.impl.base.utils.a();
        this.f538752b = r100;
        this.f538751a = new a(this);
    }
}
