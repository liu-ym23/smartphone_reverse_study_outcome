package q72;

import android.graphics.Bitmap;
import com.bytedance.android.live.base.model.data.k;
import com.bytedance.android.live.base.model.message.j0;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements com.bytedance.android.livesdk.interactivity.api.publicscreen.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f531951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f531952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.publicscreen.d f531953c;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean a() {
        return this.f531953c.a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final List<String> b() {
        return this.f531953c.b();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final String d() {
        return this.f531953c.d();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final String e() {
        return this.f531953c.e();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean f() {
        return this.f531953c.f();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean g() {
        return this.f531953c.g();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final CharSequence getChatContent() {
        return this.f531953c.getChatContent();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final k getContentExt() {
        return this.f531953c.getContentExt();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final o1 getLandscapeAreaCommon() {
        return this.f531953c.getLandscapeAreaCommon();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final j0 getMedal() {
        return this.f531953c.getMedal();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final t getMessage() {
        return this.f531953c.getMessage();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final long getMessageId() {
        return this.f531953c.getMessageId();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final int getScore() {
        return this.f531953c.getScore();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final IBaseUser getUserInfo() {
        return this.f531953c.getUserInfo();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean h() {
        return this.f531953c.h();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean i() {
        return this.f531953c.i();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean isSelfSendFake() {
        return this.f531953c.isSelfSendFake();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final int k() {
        return this.f531953c.k();
    }

    public f(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r100) {
        Intrinsics.checkNotNullParameter(r100, "talentMessage");
        this.f531953c = r100;
    }
}
