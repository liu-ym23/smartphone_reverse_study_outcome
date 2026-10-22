package com.ss.android.lark.chat.base.view.recycleview;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import zdc.c;

/* JADX INFO: loaded from: classes35.dex */
public final class ItemShineManager<T extends c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f411796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g2b.c f411797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b.InterfaceC4792b f411798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f411799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g2b.a f411800e;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ItemShineStyle {
        public static final int CONSTANT_SHINE = 1;
        public static final int NONE = -1;
        public static final int SHORT_SHINE = 0;
    }

    public final void a() {
        int r100 = this.f411799d;
        if (r100 != 0) goto L5;
        b r101 = new b(this.f411796a, this.f411798c);
        r101.f411814b = this.f411797b;
        r101.f411816d = 100;
        this.f411800e = r101;
        return;
    L5:
        if (r100 != 1) goto L11;
        this.f411800e = new a(this.f411796a, this.f411797b, this.f411798c);
        return;
    }

    public static void b(View r100) {
        Object r101 = r100.getTag(R.id.reset_background);
        if ((r101 instanceof Drawable) == false) goto L6;
        r100.setBackground((Drawable) r101);
        return;
    }

    public ItemShineManager(RecyclerView r100, g2b.c r101, b.InterfaceC4792b r102) {
        this.f411799d = 0;
        this.f411796a = r100;
        this.f411797b = r101;
        this.f411798c = r102;
    }
}
