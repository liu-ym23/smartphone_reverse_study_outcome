package com.ss.android.ugc.aweme.live.preview;

import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/live/preview/LivePreviewPlayerContainerAbility;", "Lcom/bytedance/android/livesdkapi/feed/IPreviewPlayerContainerAbility;", "", "livepreview-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePreviewPlayerContainerAbility implements IPreviewPlayerContainerAbility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f451263a;

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public final Integer getHeight() {
        ViewGroup r100 = this.f451263a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getHeight());
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public final ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup r100 = this.f451263a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLayoutParams();
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public final Integer getLeft() {
        ViewGroup r100 = this.f451263a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getLeft());
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public final Integer getTop() {
        ViewGroup r100 = this.f451263a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getTop());
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public final Float getTranslationX() {
        ViewGroup r100 = this.f451263a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Float.valueOf(r100.getTranslationX());
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public final Float getTranslationY() {
        ViewGroup r100 = this.f451263a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Float.valueOf(r100.getTranslationY());
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public final Integer getWidth() {
        ViewGroup r100 = this.f451263a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getWidth());
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public final void requestLayout() {
        ViewGroup r100 = this.f451263a;
        if (r100 == null) goto L6;
        r100.requestLayout();
        return;
    }

    public LivePreviewPlayerContainerAbility(ViewGroup r100) {
        this.f451263a = r100;
    }

    public static void a(String r100) {
        ALogger.i("LivePreviewPlayerContainerAbility", r100);
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public final void setHeight(Integer r100) {
        StringBuilder r101 = new StringBuilder("height change: ");
        if (r100 == null) goto L5;
        String r102 = String.valueOf(r100.intValue());
    L6:
        r101.append(r102);
        a(r101.toString());
        if (r100 == null) goto L15;
        int r103 = r100.intValue();
        ViewGroup r104 = this.f451263a;
        if (r104 == null) goto L16;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L13;
        r105.height = r103;
    L13:
        r104.requestLayout();
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public final void setLayoutParams(ViewGroup.LayoutParams r100) {
        StringBuilder r101 = new StringBuilder("layoutParams change: ");
        StringBuilder r102 = new StringBuilder("width = ");
        Integer r103 = null;
        if (r100 == null) goto L5;
        Integer r104 = Integer.valueOf(r100.width);
    L6:
        r102.append(r104);
        r102.append("、height = ");
        if (r100 == null) goto L9;
        r103 = Integer.valueOf(r100.height);
    L9:
        r102.append(r103);
        r101.append(r102.toString());
        a(r101.toString());
        if (r100 == null) goto L15;
        ViewGroup r105 = this.f451263a;
        if (r105 == null) goto L16;
        r105.setLayoutParams(r100);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public final void setLeft(Integer r100) {
        StringBuilder r101 = new StringBuilder("left change: ");
        if (r100 == null) goto L5;
        String r102 = String.valueOf(r100.intValue());
    L6:
        r101.append(r102);
        a(r101.toString());
        if (r100 == null) goto L12;
        int r103 = r100.intValue();
        ViewGroup r104 = this.f451263a;
        if (r104 == null) goto L13;
        r104.setLeft(r103);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public final void setTop(Integer r100) {
        StringBuilder r101 = new StringBuilder("top change: ");
        if (r100 == null) goto L5;
        String r102 = String.valueOf(r100.intValue());
    L6:
        r101.append(r102);
        a(r101.toString());
        if (r100 == null) goto L12;
        int r103 = r100.intValue();
        ViewGroup r104 = this.f451263a;
        if (r104 == null) goto L13;
        r104.setTop(r103);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public final void setTranslationX(Float r100) {
        StringBuilder r101 = new StringBuilder("translationX change: ");
        if (r100 == null) goto L5;
        String r102 = String.valueOf(r100.floatValue());
    L6:
        r101.append(r102);
        a(r101.toString());
        if (r100 == null) goto L12;
        float r103 = r100.floatValue();
        ViewGroup r104 = this.f451263a;
        if (r104 == null) goto L13;
        r104.setTranslationX(r103);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public final void setTranslationY(Float r100) {
        StringBuilder r101 = new StringBuilder("translationY change: ");
        if (r100 == null) goto L5;
        String r102 = String.valueOf(r100.floatValue());
    L6:
        r101.append(r102);
        a(r101.toString());
        if (r100 == null) goto L12;
        float r103 = r100.floatValue();
        ViewGroup r104 = this.f451263a;
        if (r104 == null) goto L13;
        r104.setTranslationY(r103);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility
    public final void setWidth(Integer r100) {
        StringBuilder r101 = new StringBuilder("width change: ");
        if (r100 == null) goto L5;
        String r102 = String.valueOf(r100.intValue());
    L6:
        r101.append(r102);
        a(r101.toString());
        if (r100 == null) goto L15;
        int r103 = r100.intValue();
        ViewGroup r104 = this.f451263a;
        if (r104 == null) goto L16;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L13;
        r105.width = r103;
    L13:
        r104.requestLayout();
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
