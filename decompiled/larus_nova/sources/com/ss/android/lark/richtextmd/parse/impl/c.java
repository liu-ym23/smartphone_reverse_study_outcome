package com.ss.android.lark.richtextmd.parse.impl;

import android.content.Context;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.coremd.utils.BISURelocator;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextExtraInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements b3c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f439643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RichTextElement f439644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BISURelocator f439645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RichTextExtraInfo f439646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b.C5274b f439647e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Context f439648f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ b f439649g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ RichTextExtraInfo f439650h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Map<String, RichTextElement> f439651i;

    @Override // b3c.b
    public final RichTextExtraInfo b() {
        return this.f439646d;
    }

    @Override // b3c.b
    public final b.C5274b c() {
        return this.f439647e;
    }

    @Override // b3c.b
    public final BISURelocator d() {
        return this.f439645c;
    }

    @Override // b3c.b
    public Context getContext() {
        return this.f439643a;
    }

    @Override // b3c.b
    public final RichTextElement getElement() {
        return this.f439644b;
    }

    @Override // b3c.b
    public final b3c.a a(RichTextElement.RichTextTag r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        return this.f439649g.f439639b.get(r100);
    }

    @Override // b3c.b
    public final c e(RichTextElement r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        b r101 = this.f439649g;
        Context r102 = this.f439648f;
        Map<String, RichTextElement> r103 = this.f439651i;
        RichTextExtraInfo r104 = this.f439650h;
        int r105 = b.f439637f;
        r101.getClass();
        return new c(r102, r100, r101, r104, r103);
    }

    @Override // b3c.b
    public final RichTextElement getElementById(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        return this.f439651i.get(r100);
    }

    public c(Context r100, RichTextElement r101, b r102, RichTextExtraInfo r103, Map r104) {
        this.f439648f = r100;
        this.f439649g = r102;
        this.f439650h = r103;
        this.f439651i = r104;
        this.f439643a = r100;
        this.f439644b = r101;
        this.f439645c = r102.f439641d;
        this.f439646d = r103;
        this.f439647e = r102.f439642e;
    }
}
