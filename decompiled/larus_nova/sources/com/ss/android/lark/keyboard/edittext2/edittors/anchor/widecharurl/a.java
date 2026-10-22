package com.ss.android.lark.keyboard.edittext2.edittors.anchor.widecharurl;

import android.text.Spannable;
import com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.UrlInlinePreviewConfig;
import com.ss.android.lark.widget.richtext.RichTextElement;
import fob.f;
import hob.j;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class a implements fob.d<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UrlInlinePreviewConfig f429032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<j> f429033b;

    @Override // fob.d
    public Class<j> getType() {
        return this.f429033b;
    }

    public a(UrlInlinePreviewConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "urlPreviewConfig");
        this.f429032a = r100;
        this.f429033b = j.class;
    }

    @Override // fob.d
    public final fob.c<Spannable, List<f.b<j>>> a(eob.a r100) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        return new d(this, r100);
    }

    @Override // fob.d
    public final fob.c<RichTextElement.AnchorProperty, j> b(eob.a r100) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        return new com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.a(r100);
    }

    @Override // fob.d
    public final fob.b c(eob.a r100, hob.b r101) {
        j r102 = (j) r101;
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter(r102, "data");
        return new b(r102, this.f429032a);
    }
}
