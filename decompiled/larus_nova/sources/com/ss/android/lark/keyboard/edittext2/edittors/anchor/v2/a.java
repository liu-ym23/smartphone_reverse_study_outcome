package com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2;

import android.text.Spannable;
import com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.UrlInlinePreviewConfig;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class a implements fob.d<hob.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UrlInlinePreviewConfig f429018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<hob.j> f429019b;

    public a() {
        int r100 = UrlInlinePreviewConfig.f428993b;
        UrlInlinePreviewConfig r101 = UrlInlinePreviewConfig.a.a();
        Intrinsics.checkNotNullParameter(r101, "urlPreviewConfig");
        this.f429018a = r101;
        this.f429019b = hob.j.class;
    }

    @Override // fob.d
    public Class<hob.j> getType() {
        return this.f429019b;
    }

    @Override // fob.d
    public final fob.c<Spannable, List<fob.f.b<hob.j>>> a(eob.a r100) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        return new m(this, r100);
    }

    @Override // fob.d
    public final fob.c<RichTextElement.AnchorProperty, hob.j> b(eob.a r100) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        return new d(r100);
    }

    @Override // fob.d
    public final fob.b c(eob.a r100, hob.b r101) {
        hob.j r102 = (hob.j) r101;
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter(r102, "data");
        return new DegradableUrlInlineSpanHolderV2(r102, this.f429018a);
    }
}
