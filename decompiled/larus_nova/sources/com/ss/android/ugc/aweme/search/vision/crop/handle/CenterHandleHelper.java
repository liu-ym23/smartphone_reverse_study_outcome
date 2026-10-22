package com.ss.android.ugc.aweme.search.vision.crop.handle;

import android.graphics.RectF;
import com.ss.android.ugc.aweme.search.vision.crop.edge.Edge;
import com.ss.android.ugc.aweme.search.vision.crop.edge.EdgeSet;

/* JADX INFO: loaded from: classes40.dex */
public class CenterHandleHelper extends HandleHelper {
    public CenterHandleHelper(EdgeSet r100) {
        super(null, null, r100);
    }

    @Override // com.ss.android.ugc.aweme.search.vision.crop.handle.HandleHelper
    public final void a(float r100, float r101, RectF r102, float r103) {
        EdgeSet r104 = this.f453543b;
        Edge r105 = r104.f453537a;
        float r106 = r105.f453534a;
        float r107 = r104.f453538b.f453534a;
        float r108 = r104.f453539c.f453534a;
        float r109 = r100 - ((r106 + r108) / 2.0f);
        float r110 = r101 - ((r107 + r104.f453540d.f453534a) / 2.0f);
        r105.a(r109);
        this.f453543b.f453538b.a(r110);
        this.f453543b.f453539c.a(r109);
        this.f453543b.f453540d.a(r110);
        EdgeSet r111 = this.f453543b;
        if (r111.b(r111.f453537a, r102, r103) == false) goto L5;
        EdgeSet r112 = this.f453543b;
        float r113 = r112.c(r112.f453537a, r102);
        this.f453543b.f453539c.a(r113);
    L8:
        EdgeSet r114 = this.f453543b;
        if (r114.b(r114.f453538b, r102, r103) == false) goto L11;
        EdgeSet r115 = this.f453543b;
        float r116 = r115.c(r115.f453538b, r102);
        this.f453543b.f453540d.a(r116);
        return;
    L11:
        EdgeSet r117 = this.f453543b;
        if (r117.b(r117.f453540d, r102, r103) == false) goto L16;
        EdgeSet r118 = this.f453543b;
        float r119 = r118.c(r118.f453540d, r102);
        this.f453543b.f453538b.a(r119);
        return;
    L16:
        return;
    L5:
        EdgeSet r120 = this.f453543b;
        if (r120.b(r120.f453539c, r102, r103) == false) goto L8;
        EdgeSet r121 = this.f453543b;
        float r122 = r121.c(r121.f453539c, r102);
        this.f453543b.f453537a.a(r122);
        goto L8
    }
}
