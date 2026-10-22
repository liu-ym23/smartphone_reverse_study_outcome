package com.ss.android.ugc.aweme.search.vision.crop.handle;

import android.graphics.RectF;
import com.ss.android.ugc.aweme.search.vision.crop.edge.Edge;
import com.ss.android.ugc.aweme.search.vision.crop.edge.EdgePair;
import com.ss.android.ugc.aweme.search.vision.crop.edge.EdgeSet;

/* JADX INFO: loaded from: classes40.dex */
public abstract class HandleHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EdgePair f453542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EdgeSet f453543b;

    public HandleHelper(Edge r100, Edge r101, EdgeSet r102) {
        this.f453542a = new EdgePair(r100, r101);
        this.f453543b = r102;
    }

    public void a(float r110, float r111, RectF r112, float r113) {
        EdgePair r100 = this.f453542a;
        Edge r101 = r100.f453535a;
        Edge r102 = r100.f453536b;
        if (r101 == null) goto L5;
        this.f453543b.a(r101, r110, r111, r112, r113);
    L5:
        if (r102 == null) goto L8;
        this.f453543b.a(r102, r110, r111, r112, r113);
        return;
    }
}
