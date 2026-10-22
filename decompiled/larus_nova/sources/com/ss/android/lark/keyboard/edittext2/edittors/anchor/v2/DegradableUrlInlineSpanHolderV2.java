package com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2;

import com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.UrlInlinePreviewConfig;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class DegradableUrlInlineSpanHolderV2 extends com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f429008g = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f429009e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f429010f;

    @Override // fob.b
    public final Object e() {
        return (com.ss.android.lark.widget.light.span.h) this.f429010f.getValue();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.d
    public final void j() {
        a(new DegradableUrlInlineSpanHolderV2$prepareAnchorSpan$1(this));
    }

    public DegradableUrlInlineSpanHolderV2(hob.j r100, UrlInlinePreviewConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "anchorInfo");
        Intrinsics.checkNotNullParameter(r101, "urlPreviewConfig");
        super(r100, r101);
        this.f429009e = Intrinsics.areEqual(((HashMap) r100.f486306c).get("key::use::wide::character:regex"), Boolean.TRUE);
        this.f429010f = LazyKt.lazy(new DegradableUrlInlineSpanHolderV2$extraSpan$2(this));
    }
}
