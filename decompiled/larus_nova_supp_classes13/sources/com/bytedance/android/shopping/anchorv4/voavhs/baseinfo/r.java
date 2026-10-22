package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.widget.TextView;
import androidx.collection.LruCache;
import com.bytedance.android.shopping.anchorv4.dto.elements.IconsWithSpaceElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import io.reactivex.functions.Action;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r implements Action {
    public final /* synthetic */ InlineLongTitleComponentView a;
    public final /* synthetic */ List b;
    public final /* synthetic */ IconsWithSpaceElement c;
    public final /* synthetic */ List d;
    public final /* synthetic */ TextElement e;
    public final /* synthetic */ TextView f;

    /* JADX WARN: Multi-variable type inference failed */
    public r(InlineLongTitleComponentView r1, List r2, IconsWithSpaceElement r3, List r4, TextElement r5, InlineLongTitleComponentView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void run() {
        InlineLongTitleComponentView r0 = this.a;
        List<h> r1 = this.b;
        IconsWithSpaceElement r2 = this.c;
        if (r2 == null) goto L5;
        int r3 = r2.getSpace();
    L6:
        List<h> r4 = this.d;
        IconsWithSpaceElement r5 = this.c;
        if (r5 == null) goto L9;
        int r6 = r5.getSpace();
    L10:
        TextElement r7 = this.e;
        TextView r8 = this.f;
        LruCache<String, h> r9 = InlineLongTitleComponentView.d;
        r0.z(r1, r3, r4, r6, r7, r8);
        return;
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }
}
