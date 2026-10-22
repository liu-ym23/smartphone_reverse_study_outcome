package com.ss.android.lark.keyboard.edittext2.mdeditor;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.ss.android.lark.coremd.base.parse.b;
import com.ss.android.lark.coremd.base.parse.f;
import com.ss.android.lark.coremd.base.parse.g;
import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.ext.l;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor;
import com.ss.android.lark.keyboard.edittext2.base.c;
import com.ss.android.lark.keyboard.edittext2.base.d;
import com.ss.android.lark.keyboard.edittext2.mdeditor.plugins.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import t9b.e;
import v7b.n;
import v7b.s;

/* JADX INFO: loaded from: classes36.dex */
public final class MarkdownNodeEditor extends BaseFunctionEditor<s> implements c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f429172g = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f429173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<? extends g> f429174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<? extends f> f429175e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j f429176f;

    public static final class a implements com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a<MarkdownNodeEditor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f429177a;

        @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a
        public final Class<MarkdownNodeEditor> a() {
            return this.f429177a.f428961a;
        }

        public a() {
            this.f429177a = new d(MarkdownNodeEditor.class);
        }
    }

    static {
        f429172g = new a();
    }

    public final Function1<n, CharSequence> U() {
        return new MarkdownNodeEditor$asLinkParser$1(this);
    }

    public MarkdownNodeEditor() {
        this.f429173c = new com.ss.android.lark.coremd.impl.parse.a();
        Intrinsics.checkNotNullParameter(t9b.d.f545145a, "<this>");
        this.f429174d = CollectionsKt.listOf(i.f429198a);
        this.f429175e = new ArrayList();
        e r100 = e.f545146a;
        this.f429176f = com.ss.android.lark.keyboard.edittext2.mdeditor.config.a.b();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor, com.ss.android.lark.keyboard.edittext2.base.a
    public final void G(com.ss.android.lark.keyboard.edittext2.base.a r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        MarkdownNodeEditor r101 = (MarkdownNodeEditor) r100;
        this.f429174d = r101.f429174d;
        this.f429173c = r101.f429173c;
        this.f429175e = r101.f429175e;
        this.f429176f = r101.f429176f;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final void S(SpannableStringBuilder r100, s r101, int r102) {
        s r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r103, "data");
        b r104 = this.f429173c.b(com.ss.android.lark.coremd.base.parse.c.a(LarkContextExtend.f419979s, new MarkdownNodeEditor$onInsert$context$1(this)));
        t9b.b r105 = t9b.b.f545143a;
        com.ss.android.lark.coremd.impl.parse.b.a r106 = t9b.b.a(context());
        l.b(r106, this.f429174d);
        r106.c(this.f429176f);
        l.a(r106, this.f429175e);
        Spannable r107 = (Spannable) r106.a(r103, r104);
        List<String> r108 = com.ss.android.lark.keyboard.edittext2.utils.b.f429249a;
        com.ss.android.lark.keyboard.edittext2.utils.b.d(r107, 0, r107.length());
        r100.insert(r102, r107);
    }
}
