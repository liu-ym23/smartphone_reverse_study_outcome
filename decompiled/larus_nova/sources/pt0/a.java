package pt0;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.base.d;
import com.bytedance.android.live.profile.ui.base.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ComponentType f530626a;

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void b(d r100) {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void e(ProfileSkin r100) {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void f() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "newUser");
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return this.f530626a;
    }

    public a(ComponentType.StandardHonourWall r100) {
        Intrinsics.checkNotNullParameter(r100, "componentType");
        this.f530626a = r100;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
    }
}
