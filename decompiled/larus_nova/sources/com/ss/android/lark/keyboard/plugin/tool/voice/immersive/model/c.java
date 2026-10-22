package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RichText f430368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SpannableStringBuilder f430369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f430370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f430371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f430372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f430373f;

    public c(RichText r100, SpannableStringBuilder r101, boolean r102, Boolean r103, String r104, boolean r105, int r106) {
        if ((r106 & 2) == 0) goto L6;
        r101 = new SpannableStringBuilder();
    L6:
        if ((r106 & 8) == 0) goto L9;
        r103 = Boolean.FALSE;
    L9:
        if ((r106 & 16) == 0) goto L12;
        r104 = null;
    L12:
        if ((r106 & 32) == 0) goto L14;
        r105 = false;
    L14:
        Intrinsics.checkNotNullParameter(r100, "richTextResult");
        Intrinsics.checkNotNullParameter(r101, "loadingSpan");
        this.f430368a = r100;
        this.f430369b = r101;
        this.f430370c = r102;
        this.f430371d = r103;
        this.f430372e = r104;
        this.f430373f = r105;
    }
}
