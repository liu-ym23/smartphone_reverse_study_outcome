package com.ss.android.lark.myai.chat.quickactions;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class QuickActionsTemplateFormatter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f432857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f432858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IntRange f432859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IntRange f432860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IntRange f432861e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IntRange f432862f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IntRange f432863g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IntRange f432864h;

    public static final class a {
    }

    static {
    }

    public QuickActionsTemplateFormatter() {
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.NONE;
        Lazy r101 = LazyKt.lazy(r100, QuickActionsTemplateFormatter$quickActionParamTemplate$2.INSTANCE);
        this.f432857a = r101;
        Lazy r102 = LazyKt.lazy(r100, QuickActionsTemplateFormatter$quickActionTemplate$2.INSTANCE);
        this.f432858b = r102;
        int r103 = StringsKt.indexOf$default((String) r101.getValue(), "{value}", 0, false, 6, null);
        int r104 = StringsKt.indexOf$default((String) r102.getValue(), "{content}", 0, false, 6, null);
        this.f432859c = new IntRange(0, 11);
        this.f432860d = new IntRange(0, r103);
        this.f432861e = new IntRange(r103, r103 + 7);
        this.f432862f = new IntRange(0, 9);
        this.f432863g = new IntRange(0, r104);
        this.f432864h = new IntRange(r104, r104 + 9);
    }
}
