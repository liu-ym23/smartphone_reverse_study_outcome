package com.ss.android.lark.image.uploader.entity;

import android.content.Context;
import com.ss.android.lark.image.uploader.upload.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import hlb.d;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class ImageUploadTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f426375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f426376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<d> f426377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public flb.a f426378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public flb.b f426379e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public dlb.a f426380f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f426381g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f426382h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f426383i;

    public final String toString() {
        return "ImageUploadTask_" + ((String) this.f426383i.getValue());
    }

    public final Context getContext() {
        return this.f426375a;
    }

    public ImageUploadTask(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f426375a = r100;
        this.f426376b = new ArrayList();
        this.f426377c = new ArrayList();
        this.f426382h = true;
        this.f426383i = LazyKt.lazy(new ImageUploadTask$taskId$2(this));
    }
}
