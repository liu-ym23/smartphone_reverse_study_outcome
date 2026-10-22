package com.ss.android.lark.keyboard.edittext2.edittors.anchor.widecharurl;

import com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.UrlInlinePreviewConfig;
import hob.j;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f429034e = 0;

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.d
    public final void j() {
        if (Intrinsics.areEqual(((HashMap) this.f429005b.f486306c).get("key::use::wide::character:regex"), Boolean.TRUE) == false) goto L6;
        a(new DegradableUrlInlineSpanHolder$preparePossibleAnchorSpan$1(this));
        return;
    }

    public b(j r100, UrlInlinePreviewConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "anchorInfo");
        Intrinsics.checkNotNullParameter(r101, "urlPreviewConfig");
        super(r100, r101);
    }
}
