package com.ss.ugc.live.barrage.controller;

import android.graphics.Paint;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Paint;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 15})
final class CommentBarrageController$danmakuLinePaint$2 extends Lambda implements Function0<Paint> {
    public static final CommentBarrageController$danmakuLinePaint$2 INSTANCE = null;

    static {
        INSTANCE = new CommentBarrageController$danmakuLinePaint$2();
    }

    public CommentBarrageController$danmakuLinePaint$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Paint invoke() {
        Paint r100 = new Paint();
        r100.setStyle(Paint.Style.STROKE);
        r100.setAntiAlias(true);
        r100.setColor(-65536);
        r100.setStrokeWidth(6.0f);
        return r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Paint invoke() {
        return invoke();
    }
}
