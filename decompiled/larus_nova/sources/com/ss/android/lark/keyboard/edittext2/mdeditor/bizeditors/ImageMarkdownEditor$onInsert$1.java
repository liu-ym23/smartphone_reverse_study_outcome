package com.ss.android.lark.keyboard.edittext2.mdeditor.bizeditors;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkImageExtend;
import hob.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import okio.ByteString;
import v7b.l;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/coremdbiz/facade/bizext/props/LarkImageExtend;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ImageMarkdownEditor$onInsert$1 extends Lambda implements Function1<LarkImageExtend, Unit> {
    final /* synthetic */ f $data;
    final /* synthetic */ int $height;
    final /* synthetic */ l $image;
    final /* synthetic */ int $width;

    public ImageMarkdownEditor$onInsert$1(l r100, int r101, int r102, f r103) {
        this.$image = r100;
        this.$width = r101;
        this.$height = r102;
        this.$data = r103;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LarkImageExtend r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$LarkImageExtend");
        l r101 = this.$image;
        int r102 = this.$width;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        c r103 = r100.f420019c;
        KProperty<Object>[] r104 = LarkImageExtend.f420018h;
        r103.setValue(r101, r104[0], Integer.valueOf(r102));
        l r105 = this.$image;
        int r106 = this.$height;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        r100.f420020d.setValue(r105, r104[1], Integer.valueOf(r106));
        com.ss.android.lark.widget.span.b.AbstractC5432b<?> r107 = this.$data.f486327a;
        if ((r107 instanceof com.ss.android.lark.widget.span.b.AbstractC5432b.C5433b) == false) goto L6;
        l r108 = this.$image;
        ByteString r109 = ((com.ss.android.lark.widget.span.b.AbstractC5432b.C5433b) r107).f448645g;
        Intrinsics.checkNotNullParameter(r108, "<this>");
        r100.f420022f.setValue(r108, r104[3], r109);
        l r110 = this.$image;
        String r111 = ((com.ss.android.lark.widget.span.b.AbstractC5432b.C5433b) this.$data.f486327a).f448644f;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        r100.f420021e.setValue(r110, r104[2], r111);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(LarkImageExtend r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
