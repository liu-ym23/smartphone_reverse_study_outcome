package com.bytedance.live.photoviewer.transition;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.live.photoviewer.PhotoDraweeView;
import com.bytedance.live.photoviewer.ZoomableControllerImp;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zj6.c;
import zj6.e;
import zj6.f;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B)\b\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/live/photoviewer/transition/TransitionPhotoDraweeView;", "Lcom/bytedance/live/photoviewer/PhotoDraweeView;", "Lzj6/e;", "", "enabled", "transitionEnabled", "Z", "getTransitionEnabled", "()Z", "setTransitionEnabled", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "photoviewer_release"}, k = 1, mv = {1, 4, 0})
public final class TransitionPhotoDraweeView extends PhotoDraweeView implements e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f255719h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f255720i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashSet<c> f255721j;

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TransitionPhotoDraweeView f255722a;

        public a(TransitionPhotoDraweeView r100) {
            this.f255722a = r100;
        }

        @Override // zj6.c
        public final void onTransitionBegin(int r100) {
            Iterator<T> r101 = this.f255722a.f255721j.iterator();
        L4:
            if (r101.hasNext() == false) goto L7;
            ((c) r101.next()).onTransitionBegin(r100);
            goto L4
        L7:
            if (r100 != 2) goto L13;
            TransitionPhotoDraweeView r102 = this.f255722a;
            if (r102.f255720i != 0.0f) goto L14;
            r102.f255720i = 1.0f;
            return;
        L14:
            return;
        }

        @Override // zj6.c
        public final void onTransitionEnd(int r100) {
            Iterator<T> r101 = this.f255722a.f255721j.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((c) r101.next()).onTransitionEnd(r100);
            goto L4
        }

        @Override // zj6.c
        public final void onTransitionChanged(int r100, float r101) {
            Iterator<T> r102 = this.f255722a.f255721j.iterator();
        L4:
            if (r102.hasNext() == false) goto L7;
            ((c) r102.next()).onTransitionChanged(r100, r101);
            goto L4
        L7:
            if (r100 != 3) goto L10;
            this.f255722a.f255720i = r101;
        L10:
            if (r100 != 2) goto L16;
            TransitionPhotoDraweeView r103 = this.f255722a;
            float r104 = r103.f255720i;
            if (r104 <= 0) goto L17;
            r103.setAlpha((1 / r104) * r101);
            return;
        L17:
            return;
        }
    }

    public TransitionPhotoDraweeView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TransitionPhotoDraweeView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final boolean getTransitionEnabled() {
        return false;
    }

    @Override // com.bytedance.live.photoviewer.PhotoDraweeView
    public final ZoomableControllerImp f() {
        f r100 = new f(new wj6.e(), getContext());
        this.f255719h = r100;
        return r100;
    }

    @Override // com.bytedance.live.photoviewer.PhotoDraweeView
    public final wj6.a j() {
        f r100 = this.f255719h;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("controllerImp");
    L6:
        return new wj6.f(r100);
    }

    @Override // zj6.e
    public final void a(c r100) {
        this.f255721j.remove(r100);
    }

    @Override // zj6.e
    public final void d(c r100) {
        this.f255721j.add(r100);
    }

    public final void setTransitionEnabled(boolean r100) {
        f r101 = this.f255719h;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("controllerImp");
    L5:
        r101.C = r100;
    }

    public TransitionPhotoDraweeView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f255721j = new LinkedHashSet();
        a r103 = new a(this);
        f r104 = this.f255719h;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("controllerImp");
    L5:
        r104.d(r103);
    }

    public /* synthetic */ TransitionPhotoDraweeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
