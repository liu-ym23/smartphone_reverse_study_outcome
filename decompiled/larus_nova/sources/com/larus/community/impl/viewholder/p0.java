package com.larus.community.impl.viewholder;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.utils.e1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes27.dex */
public final class p0 extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CreationVideoViewHolder f330093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Integer> f330094b;

    public p0(CreationVideoViewHolder r100, Ref.ObjectRef<Integer> r101) {
        this.f330093a = r100;
        this.f330094b = r101;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        super.onFinalImageSet(r100, r101, r102);
        boolean r103 = r0.f330105a;
        if (r0.f330105a == false) goto L10;
        CreationVideoViewHolder r104 = this.f330093a;
        if (r104.f330024p == false) goto L7;
        return;
    L7:
        if (this.f330094b.element == null) goto L12;
        e1.x(r104.f330010b);
        return;
    L12:
        return;
    }
}
