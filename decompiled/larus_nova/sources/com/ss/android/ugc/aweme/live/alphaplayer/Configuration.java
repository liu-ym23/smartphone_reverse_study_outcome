package com.ss.android.ugc.aweme.live.alphaplayer;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes40.dex */
public class Configuration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f451007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LifecycleOwner f451008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f451009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f451010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f451011e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f451012f;

    public final Configuration a() {
        Configuration r100 = new Configuration();
        r100.f451007a = this.f451007a;
        r100.f451008b = this.f451008b;
        r100.f451009c = this.f451009c;
        r100.f451010d = this.f451010d;
        r100.f451011e = this.f451011e;
        r100.f451012f = this.f451012f;
        return r100;
    }

    public Configuration() {
        this.f451009c = 0;
        this.f451010d = "alpha-play-thread";
        this.f451011e = false;
        this.f451012f = false;
    }

    public Context getContext() {
        return this.f451007a;
    }
}
