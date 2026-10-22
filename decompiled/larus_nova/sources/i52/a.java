package i52;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.e;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessageBinderType;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessageModelType;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessagePluginType;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a implements h52.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f488278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IBaseUser f488279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f488280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f488281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IPublicAreaCommon f488282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f488283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a5 f488284g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f488285h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h52.c.a f488286i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MessageModelType f488287j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MessageBinderType f488288k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MessagePluginType f488289l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f488290m;

    @Override // h52.c
    public final h52.c.a getTextInfo() {
        h52.c.a r100 = this.f488286i;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textInfo");
    L5:
        return r100;
    }

    @Override // h52.c
    public final MessageBinderType a() {
        return this.f488288k;
    }

    @Override // h52.c
    public final e b() {
        return this.f488283f;
    }

    @Override // h52.c
    public final long d() {
        return this.f488285h;
    }

    @Override // h52.c
    public final long getMessageId() {
        return this.f488290m;
    }

    @Override // h52.c
    public final IBaseUser getUser() {
        return this.f488279b;
    }

    @Override // h52.c
    public final void c(com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.d r100) {
        this.f488283f = r100;
    }

    public a(MessageModelType r100, MessageBinderType r101, MessagePluginType r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "modelType");
        Intrinsics.checkNotNullParameter(r101, "binderType");
        Intrinsics.checkNotNullParameter(r102, "pluginType");
        this.f488287j = r100;
        this.f488288k = r101;
        this.f488289l = r102;
        this.f488290m = r103;
        this.f488278a = true;
        this.f488285h = System.currentTimeMillis();
    }
}
