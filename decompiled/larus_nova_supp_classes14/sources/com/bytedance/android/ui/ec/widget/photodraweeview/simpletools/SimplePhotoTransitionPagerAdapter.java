package com.bytedance.android.ui.ec.widget.photodraweeview.simpletools;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPhotoDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00162\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/simpletools/SimplePhotoTransitionPagerAdapter;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionPagerAdapter;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/simpletools/SimplePhotoTransitionPagerAdapter$PhotoVH;", "()V", "urls", "", "", "getUrls", "()Ljava/util/List;", "setUrls", "(Ljava/util/List;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "PhotoVH", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimplePhotoTransitionPagerAdapter extends TransitionPagerAdapter<PhotoVH> {
    public static final Companion Companion = null;
    public static final int PHOTO = 1;
    private List<String> urls;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/simpletools/SimplePhotoTransitionPagerAdapter$Companion;", "", "()V", "PHOTO", "", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/simpletools/SimplePhotoTransitionPagerAdapter$PhotoVH;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", "transitionPhotoDraweeView", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionPhotoDraweeView;", "(Lcom/bytedance/android/ui/ec/widget/photodraweeview/simpletools/SimplePhotoTransitionPagerAdapter;Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionPhotoDraweeView;)V", "getTransitionPhotoDraweeView", "()Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionPhotoDraweeView;", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class PhotoVH extends TransitionViewHolder {
        final /* synthetic */ SimplePhotoTransitionPagerAdapter this$0;
        private final TransitionPhotoDraweeView transitionPhotoDraweeView;

        public final TransitionPhotoDraweeView getTransitionPhotoDraweeView() {
            return this.transitionPhotoDraweeView;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PhotoVH(SimplePhotoTransitionPagerAdapter r2, TransitionPhotoDraweeView r3) {
            Intrinsics.checkNotNullParameter(r3, "transitionPhotoDraweeView");
            this.this$0 = r2;
            super(r3);
            this.transitionPhotoDraweeView = r3;
            r3.setMaxScaleFactor(4.0f);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public int getItemViewType(int r1) {
        return 1;
    }

    public int getItemCount() {
        List<String> r0 = this.urls;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public SimplePhotoTransitionPagerAdapter() {
    }

    public final List<String> getUrls() {
        return this.urls;
    }

    public final void setUrls(List<String> r1) {
        this.urls = r1;
    }

    public void onBindViewHolder(PhotoVH r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        TransitionPhotoDraweeView r5 = r3.getTransitionPhotoDraweeView();
        PipelineDraweeControllerBuilder r0 = Fresco.newDraweeControllerBuilder();
        List<String> r1 = this.urls;
        if (r1 == null) goto L5;
        String r6 = (String) ListProtector.get(r1, r4);
    L6:
        r5.setController(r0.setUri(r6).build());
        return;
    L5:
        r6 = null;
        goto L6
    }

    /* JADX INFO: renamed from: onCreateViewHolder, reason: collision with other method in class */
    public PhotoVH m517onCreateViewHolder(ViewGroup r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        return new PhotoVH(this, new TransitionPhotoDraweeView(r8.getContext(), null, 0, 6, null));
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((PhotoVH) r1, r2);
    }

    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return m517onCreateViewHolder(r1, r2);
    }
}
