package com.ss.android.ugc.aweme.search.vision.background.image;

import android.content.Context;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import fua.d;

/* JADX INFO: loaded from: classes40.dex */
public class ScaleDragDetector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f453473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f453474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VelocityTracker f453475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f453476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f453477e;

    public ScaleDragDetector(Context r100, d r101) {
        this.f453474b = r101;
        this.f453473a = ViewConfiguration.get(r100).getScaledTouchSlop();
    }
}
