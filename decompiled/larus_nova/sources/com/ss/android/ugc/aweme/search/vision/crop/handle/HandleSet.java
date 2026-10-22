package com.ss.android.ugc.aweme.search.vision.crop.handle;

import com.ss.android.ugc.aweme.search.vision.crop.edge.EdgeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/crop/handle/HandleSet;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HandleSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handle f453544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handle f453545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handle f453546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handle f453547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handle f453548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handle f453549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handle f453550g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handle f453551h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handle f453552i;

    public HandleSet(EdgeSet r100) {
        Intrinsics.checkNotNullParameter(r100, "edgeSet");
        this.f453544a = new Handle(new CornerHandleHelper(r100.f453538b, r100.f453537a, r100));
        this.f453545b = new Handle(new CornerHandleHelper(r100.f453538b, r100.f453539c, r100));
        this.f453546c = new Handle(new CornerHandleHelper(r100.f453540d, r100.f453537a, r100));
        this.f453547d = new Handle(new CornerHandleHelper(r100.f453540d, r100.f453539c, r100));
        this.f453548e = new Handle(new VerticalHandleHelper(r100.f453537a, r100));
        this.f453549f = new Handle(new HorizontalHandleHelper(r100.f453538b, r100));
        this.f453550g = new Handle(new VerticalHandleHelper(r100.f453539c, r100));
        this.f453551h = new Handle(new HorizontalHandleHelper(r100.f453540d, r100));
        this.f453552i = new Handle(new CenterHandleHelper(r100));
    }
}
