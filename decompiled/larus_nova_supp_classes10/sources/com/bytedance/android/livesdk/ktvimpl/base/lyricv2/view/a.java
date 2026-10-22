package com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.ktvapi.config.ScrollLyricConfigV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends View {
    public final float a;
    public final int b;
    public int c;
    public final ScrollLyricConfigV2 d;

    public final ScrollLyricConfigV2 getConfig() {
        return this.d;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        float r0 = (r9.getWidth() / 2) - this.a;
        int r1 = r9.getHeight();
        int r2 = this.b;
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L6;
        float r7 = r1 / 2.0f;
        r9.drawCircle((this.a * r4) + r0, r7, r7, ((com.bytedance.android.livesdk.ktvapi.config.a) this.d).c);
        r4 = r4 + 1;
        goto L4
    L6:
        int r5 = this.c;
    L7:
        if (r3 >= r5) goto L9;
        float r6 = r1 / 2.0f;
        r9.drawCircle((this.a * r3) + r0, r6, r6, ((com.bytedance.android.livesdk.ktvapi.config.a) this.d).b);
        r3 = r3 + 1;
        goto L7
    }

    public a(Context r2, ScrollLyricConfigV2 r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "config");
        super(r2, null);
        this.d = r3;
        this.a = UtilityKotlinExtentionsKt.h(10);
        this.b = 3;
    }
}
