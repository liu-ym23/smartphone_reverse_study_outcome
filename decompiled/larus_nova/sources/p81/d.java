package p81;

import android.view.View;
import com.bytedance.android.live.profile.ui.component.descriptioncomponent.ProfileMyLiveTopRightEntranceComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View.OnClickListener f528068b;

    public d(String r100, ProfileMyLiveTopRightEntranceComponent.a r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "onClickListener");
        this.f528067a = r100;
        this.f528068b = r101;
    }
}
