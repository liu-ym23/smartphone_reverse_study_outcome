package com.ss.android.lark.chat.message.menu.v2;

import com.alibaba.gaiax.render.view.GXViewKey;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DragPanelLayout f415667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UDShadowLayout f415668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f415669c;

    public a(DragPanelLayout r100, UDShadowLayout r101) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, GXViewKey.VIEW_TYPE_SHADOW_LAYOUT);
        this.f415667a = r100;
        this.f415668b = r101;
        this.f415669c = 0.0f;
    }
}
