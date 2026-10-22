package com.bytedance.bdturing.livedetect.pty;

import android.graphics.PointF;
import android.graphics.RectF;
import com.bytedance.bdturing.livedetect.camera.ImageDataWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public final List<List<PointF>> a;
    public final List<RectF> b;
    public ArrayList<Float> c;
    public ImageDataWrapper d;
    public int e;
    public String f;

    public c() {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.e = -1;
        this.f = "";
    }
}
