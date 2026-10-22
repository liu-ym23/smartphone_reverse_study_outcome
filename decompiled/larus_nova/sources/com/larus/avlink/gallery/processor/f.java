package com.larus.avlink.gallery.processor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes25.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Job> f292682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f292683b;

    public f() {
        this.f292682a = Collections.synchronizedList(new ArrayList());
    }
}
