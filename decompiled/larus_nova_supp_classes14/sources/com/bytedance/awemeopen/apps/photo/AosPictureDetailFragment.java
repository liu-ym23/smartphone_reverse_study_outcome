package com.bytedance.awemeopen.apps.photo;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment;
import com.bytedance.awemeopen.apps.photo.viewmodel.AosPictureDetailViewModel;
import com.bytedance.awemeopen.export.api.picturedetail.AosPictureDetailConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/awemeopen/apps/photo/AosPictureDetailFragment;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosBaseFragment;", "Lcom/bytedance/awemeopen/apps/photo/viewmodel/AosPictureDetailViewModel;", "Ln54/a;", "<init>", "()V", "a", "ao_apps_photo_release"}, k = 1, mv = {1, 7, 1})
public final class AosPictureDetailFragment extends AosBaseFragment<AosPictureDetailViewModel> implements n54.a {
    public final Lazy g;
    public AosPictureDetailConfig h;
    public n54.b i;
    public final Map<Integer, View> j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void S90() {
        ((LinkedHashMap) this.j).clear();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final int X90() {
        return 2131558649;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Y90() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void Z90() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final Class<AosPictureDetailViewModel> da0() {
        return AosPictureDetailViewModel.class;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final Fragment f() {
        return this;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void initView() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    public AosPictureDetailFragment() {
        this.j = new LinkedHashMap();
        this.g = LazyKt.lazy(new AosPictureDetailFragment$layout$2(this));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final Boolean onBackPressed() {
        AosPictureDetailLayout r0 = (AosPictureDetailLayout) this.g.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r0.g());
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void ba0(Bundle r2) {
        Bundle r3 = getArguments();
        if (r3 == null) goto L6;
        AosPictureDetailConfig r4 = (AosPictureDetailConfig) r3.getParcelable("PICTURE_DETAIL_CONFIG_KEY");
        if (r4 == null) goto L6;
    L7:
        this.h = r4;
        return;
    L6:
        r4 = new AosPictureDetailConfig();
        goto L7
    }

    public final void setUserVisibleHint(boolean r1) {
        super.setUserVisibleHint(r1);
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        FrameLayout r6 = (FrameLayout) r4.findViewById(2131382084);
        AosPictureDetailLayout r7 = (AosPictureDetailLayout) this.g.getValue();
        if (r7 == null) goto L5;
        Intrinsics.checkNotNullParameter(this, "fragment");
        r7.w = this;
    L5:
        AosPictureDetailLayout r8 = (AosPictureDetailLayout) this.g.getValue();
        if (r8 == null) goto L8;
        Bundle r0 = new Bundle();
        r0.putParcelable("PICTURE_DETAIL_CONFIG_KEY", this.h);
        r8.setArguments(r0);
    L8:
        AosPictureDetailLayout r9 = (AosPictureDetailLayout) this.g.getValue();
        if (r9 == null) goto L11;
        r9.b();
    L11:
        AosPictureDetailLayout r10 = (AosPictureDetailLayout) this.g.getValue();
        if (r10 == null) goto L15;
        r6.addView(r10.getView());
        getLifecycle().addObserver(r10);
        r10.setPageListener(this.i);
        return;
    }
}
