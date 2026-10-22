package com.larus.business.markdown.impl.markwon.custom.title;

import android.text.NoCopySpan;
import com.larus.business.markdown.api.FullScreenDetailType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c implements NoCopySpan, gw8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f320668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f320669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f320670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FullScreenDetailType f320671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f320672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f320673f;

    @Override // gw8.b
    public final String a() {
        return this.f320670c;
    }

    @Override // gw8.b
    public final String getContent() {
        return this.f320669b;
    }

    @Override // gw8.b
    public final String getInfo() {
        return this.f320668a;
    }

    @Override // gw8.b
    public FullScreenDetailType getType() {
        return this.f320671d;
    }

    @Override // gw8.b
    public final boolean isPreview() {
        return this.f320673f;
    }

    public /* synthetic */ c(String r100, String r101, String r110, FullScreenDetailType r111, boolean r112) {
        this(r100, r101, r110, r111, r112, false);
    }

    public c(String r100, String r101, String r102, FullScreenDetailType r103, boolean r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "copyContent");
        Intrinsics.checkNotNullParameter(r103, "type");
        this.f320668a = r100;
        this.f320669b = r101;
        this.f320670c = r102;
        this.f320671d = r103;
        this.f320672e = r104;
        this.f320673f = r105;
    }
}
