package com.ss.android.lark.contact.base.contact_search;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.base.fragment.BaseFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f418805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BaseFragment f418806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FragmentActivity f418807c;

    public g0() {
    }

    public final FragmentActivity getActivity() {
        return this.f418807c;
    }

    public final <T extends View> T a(int r100) {
        View r101 = this.f418805a;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException(PlayerResolution.SDKKEY.ORIGIN);
        r101 = null;
    L7:
        return (T) r101.findViewById(r100);
    }

    public g0(View r100, BaseFragment r101) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        this();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f418805a = r100;
        this.f418806b = r101;
        this.f418807c = r101.getActivity();
    }
}
