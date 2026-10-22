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
public final class b implements com.bytedance.android.livesdk.interactivity.api.publicscreen.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f531923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f531924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f531925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.d f531926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f531927e;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean a() {
        return this.f531926d.a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final List<String> b() {
        return this.f531926d.b();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final String d() {
        return this.f531926d.d();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final String e() {
        return this.f531926d.e();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean f() {
        return this.f531926d.f();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean g() {
        return this.f531926d.g();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final CharSequence getChatContent() {
        return this.f531926d.getChatContent();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final k getContentExt() {
        return this.f531926d.getContentExt();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final o1 getLandscapeAreaCommon() {
        return this.f531926d.getLandscapeAreaCommon();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final j0 getMedal() {
        return this.f531926d.getMedal();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final t getMessage() {
        return this.f531926d.getMessage();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final long getMessageId() {
        return this.f531926d.getMessageId();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final int getScore() {
        return this.f531926d.getScore();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final IBaseUser getUserInfo() {
        return this.f531926d.getUserInfo();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean h() {
        return this.f531926d.h();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean i() {
        return this.f531926d.i();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean isSelfSendFake() {
        return this.f531926d.isSelfSendFake();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final int k() {
        return this.f531926d.k();
    }

    public b(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "carnivalMessage");
        this.f531926d = r100;
        this.f531927e = r101;
    }
}
