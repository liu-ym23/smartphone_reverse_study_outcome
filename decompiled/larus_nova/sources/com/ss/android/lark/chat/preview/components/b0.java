package com.ss.android.lark.chat.preview.components;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.larus.nova.R;
import com.ss.android.lark.chat.preview.components.view.FlowLayout;
import com.ss.android.lark.export.entity.preview.KeyTag;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b0 extends FlowLayout.a<FlowLayout.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<KeyTag> f416011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a0 f416012b;

    @Override // com.ss.android.lark.chat.preview.components.view.FlowLayout.a
    public final int a() {
        return this.f416011a.size();
    }

    public b0(a0 r100) {
        this.f416012b = r100;
        r100.getClass();
        ArrayList<KeyTag> r101 = new ArrayList();
        if (r100.f416007f.getMixedTags() == null) goto L5;
        List<KeyTag> r102 = r100.f416007f.getMixedTags();
        Intrinsics.checkNotNull(r102);
        r101.addAll(r102);
    L5:
        this.f416011a = r101;
    }

    @Override // com.ss.android.lark.chat.preview.components.view.FlowLayout.a
    public final a0.a c(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        TextView r101 = new TextView(r100.getContext());
        ViewGroup.MarginLayoutParams r102 = new ViewGroup.MarginLayoutParams(-2, -2);
        int r103 = (int) h18.d.b(r100.getContext(), 2);
        r102.setMargins(0, r103, (int) h18.d.b(r100.getContext(), 6), r103);
        r101.setLayoutParams(r102);
        return new a0.a(r101);
    }

    @Override // com.ss.android.lark.chat.preview.components.view.FlowLayout.a
    public final void b(FlowLayout.c r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Context r103 = r100.f416122a.getContext();
        KeyTag r104 = (KeyTag) ListProtector.get(this.f416011a, r101);
        Intrinsics.checkNotNull(r103);
        UDTagsDrawable.d.a r105 = new UDTagsDrawable.d.a(r103);
        r105.f285353c = r104.getTag();
        a0 r106 = this.f416012b;
        ThemeColor r107 = r104.getBackgroundColor();
        r106.getClass();
        if (r107 == null) goto L5;
        int r108 = com.ss.android.lark.export.entity.preview.a.a(r107, r103, null);
    L6:
        r105.a(r108);
        a0 r109 = this.f416012b;
        ThemeColor r110 = r104.getTextColor();
        r109.getClass();
        if (r110 == null) goto L9;
        int r111 = com.ss.android.lark.export.entity.preview.a.a(r110, r103, null);
    L10:
        r105.f285354d = r111;
        UDTagsDrawable.d r112 = r105.b();
        UDTagsDrawable.a r113 = new UDTagsDrawable.a(r103);
        r113.a(r112);
        if (r102 <= 0) goto L13;
        r113.f285332f = r102;
    L13:
        r100.f416122a.setBackground(r113.b());
        return;
    L9:
        r111 = r103.getResources().getColor(R.color.ud_N600);
        goto L10
    L5:
        r108 = r103.getResources().getColor(R.color.udtoken_tag_neutral_bg_normal);
        goto L6
    }
}
