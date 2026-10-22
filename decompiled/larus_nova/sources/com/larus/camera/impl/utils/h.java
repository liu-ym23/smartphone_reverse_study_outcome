package com.larus.camera.impl.utils;

import android.animation.Animator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Animator> f322774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f322775b;

    public final void a() {
        this.f322775b = false;
        CollectionsKt.removeAll(this.f322774a, new g());
    }

    public h() {
        this.f322774a = new LinkedHashSet();
    }
}
