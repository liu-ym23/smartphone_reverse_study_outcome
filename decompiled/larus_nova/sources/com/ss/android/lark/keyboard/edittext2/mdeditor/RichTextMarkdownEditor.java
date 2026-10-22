package com.ss.android.lark.keyboard.edittext2.mdeditor;

import android.text.SpannableStringBuilder;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.ext.g;
import com.ss.android.lark.coremd.impl.parse.MarkdownThemeImpl;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor;
import com.ss.android.lark.keyboard.edittext2.utils.e;
import com.ss.android.lark.richtextmd.parse.ext.b;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes36.dex */
public class RichTextMarkdownEditor extends RichTextEditor {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public b f429178u;

    public RichTextMarkdownEditor() {
        com.ss.android.lark.richtextmd.parse.a.f439609a.getClass();
        this.f429178u = com.ss.android.lark.richtextmd.parse.a.f439610b;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor, com.ss.android.lark.keyboard.edittext2.base.a
    public final void G(com.ss.android.lark.keyboard.edittext2.base.a r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f429178u = ((RichTextMarkdownEditor) r100).f429178u;
    }

    public j Y(j r100) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        MarkdownThemeImpl r101 = r100.clone();
        g.a(r101, LarkThemeExtend.f419998m, new RichTextMarkdownEditor$interceptTheme$1(this));
        return r101;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor
    public final void X(SpannableStringBuilder r100, RichText r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "data");
        t9b.a r102 = t9b.a.f545142a;
        com.ss.android.lark.richtextmd.parse.impl.b r103 = com.ss.android.lark.richtextmd.parse.ext.a.b(context());
        com.ss.android.lark.richtextmd.parse.ext.a.a(r103, new RichTextMarkdownEditor$onInsert$node$1(this));
        s r104 = r103.b(r101);
        MarkdownNodeEditor r105 = (MarkdownNodeEditor) e.b(q(MarkdownNodeEditor.f429172g));
        j r106 = Y(r105.f429176f);
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r105.f429176f = r106;
        r105.R(r104, r100);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor, com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final /* bridge */ /* synthetic */ void S(SpannableStringBuilder r100, RichText r101, int r102) {
        X(r100, r101);
    }
}
