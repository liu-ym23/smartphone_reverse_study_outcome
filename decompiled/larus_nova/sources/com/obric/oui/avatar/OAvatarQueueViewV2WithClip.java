package com.obric.oui.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/avatar/OAvatarQueueViewV2WithClip;", "Landroid/view/View;", "", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OAvatarQueueViewV2WithClip extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Bitmap> f398765a;

    public OAvatarQueueViewV2WithClip(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OAvatarQueueViewV2WithClip(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
    }

    public OAvatarQueueViewV2WithClip(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100, r101, r102);
        new Paint().setAntiAlias(true);
        this.f398765a = new ArrayList();
    }

    public /* synthetic */ OAvatarQueueViewV2WithClip(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
