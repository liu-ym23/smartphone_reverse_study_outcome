package com.larus.bmhome.chat.plugin.image4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import z19.j;
import z19.r;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/plugin/image4/view/ImageViewWithLastMotion;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Lcom/larus/common_ui/widget/ILastMotionView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "lastMotionDelegate", "Lcom/larus/common_ui/widget/LastMotionViewDelegate;", "lastMotionX", "", "getLastMotionX", "()Ljava/lang/Float;", "lastMotionY", "getLastMotionY", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageViewWithLastMotion extends SimpleDraweeView implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f308475a;

    @Override // z19.j
    public Float getLastMotionX() {
        return this.f308475a.f569704a;
    }

    @Override // z19.j
    public Float getLastMotionY() {
        return this.f308475a.f569705b;
    }

    public ImageViewWithLastMotion(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f308475a.a(r100);
        return super.onTouchEvent(r100);
    }

    public ImageViewWithLastMotion(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f308475a = new r();
    }
}
