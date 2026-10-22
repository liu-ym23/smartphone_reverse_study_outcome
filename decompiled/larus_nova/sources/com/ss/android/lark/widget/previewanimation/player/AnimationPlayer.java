package com.ss.android.lark.widget.previewanimation.player;

import android.graphics.Canvas;
import android.os.Parcelable;
import android.view.ViewGroup;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0000¢\u0006\u0002\b\u000bJ\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0005H&J\u0014\u0010\u0010\u001a\u00020\u00052\n\u0010\b\u001a\u00060\tj\u0002`\nH&J\u001c\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH&¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/widget/previewanimation/player/AnimationPlayer;", "Landroid/os/Parcelable;", "<init>", "()V", "playCurrentFrame", "", "canvas", "Landroid/graphics/Canvas;", "progress", "", "Lcom/ss/android/lark/widget/previewanimation/toolkit/Progress;", "playCurrentFrame$photo_picker_release", "onEnter", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", d.f25928r, "beforePlayFrame", "onPlayFrame", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AnimationPlayer implements Parcelable {
    public AnimationPlayer() {
    }

    public abstract void a();

    public abstract void b(ViewGroup r100);

    public abstract void c();

    public abstract void d(Canvas r100, float r101);
}
