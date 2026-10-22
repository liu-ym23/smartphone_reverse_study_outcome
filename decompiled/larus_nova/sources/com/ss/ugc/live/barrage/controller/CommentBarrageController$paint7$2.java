package com.ss.ugc.live.barrage.controller;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Paint;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 15})
final class CommentBarrageController$paint7$2 extends Lambda implements Function0<Paint> {
    final /* synthetic */ d this$0;

    public CommentBarrageController$paint7$2(d r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Paint invoke() {
        Paint r100 = new Paint();
        r100.setStyle(Paint.Style.STROKE);
        r100.setAntiAlias(true);
        this.this$0.getClass();
        r100.setColor(ColorProtector.parseColor(null));
        this.this$0.getClass();
        r100.setStrokeWidth(0.0f);
        r100.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        return r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Paint invoke() {
        return invoke();
    }
}
