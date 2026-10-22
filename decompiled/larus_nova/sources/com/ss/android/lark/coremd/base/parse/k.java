package com.ss.android.lark.coremd.base.parse;

import com.ss.android.lark.coremd.base.theme.BlockQuoteThemeData;
import com.ss.android.lark.coremd.base.theme.CodeBlockThemeData;
import com.ss.android.lark.coremd.base.theme.HeadingThemeData;
import com.ss.android.lark.coremd.base.theme.InlineCodeThemeData;
import com.ss.android.lark.coremd.base.theme.LinkThemeData;
import com.ss.android.lark.coremd.base.theme.ListThemeData;
import com.ss.android.lark.coremd.base.theme.ThematicBreakThemeData;
import com.ss.android.lark.coremd.impl.parse.MarkdownThemeImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public interface k extends com.ss.android.lark.coremd.ext.f, com.ss.android.lark.coremd.ext.h<k> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f419543b = null;

    public static final class a implements k {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ a f419544d = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MarkdownThemeImpl.ThemeExtendImpl f419545c;

        static {
            f419544d = new a();
        }

        @Override // com.ss.android.lark.coremd.base.parse.k
        public final ListThemeData c(j r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            return this.f419545c.c(r100);
        }

        @Override // com.ss.android.lark.coremd.base.parse.k
        public final HeadingThemeData e(j r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            return this.f419545c.e(r100);
        }

        @Override // com.ss.android.lark.coremd.ext.h
        public final com.ss.android.lark.coremd.ext.f a() {
            MarkdownThemeImpl.ThemeExtendImpl r100 = this.f419545c;
            r100.getClass();
            return r100;
        }

        public a() {
            this.f419545c = new MarkdownThemeImpl.ThemeExtendImpl();
        }

        public final BlockQuoteThemeData b(j r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            MarkdownThemeImpl.ThemeExtendImpl r101 = this.f419545c;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "<this>");
            return (BlockQuoteThemeData) r101.f419854h.getValue(r100, MarkdownThemeImpl.ThemeExtendImpl.f419848l[5]);
        }

        public final CodeBlockThemeData d(j r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            MarkdownThemeImpl.ThemeExtendImpl r101 = this.f419545c;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "<this>");
            return (CodeBlockThemeData) r101.f419853g.getValue(r100, MarkdownThemeImpl.ThemeExtendImpl.f419848l[4]);
        }

        public final InlineCodeThemeData f(j r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            MarkdownThemeImpl.ThemeExtendImpl r101 = this.f419545c;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "<this>");
            return (InlineCodeThemeData) r101.f419852f.getValue(r100, MarkdownThemeImpl.ThemeExtendImpl.f419848l[3]);
        }

        public final LinkThemeData g(j r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            MarkdownThemeImpl.ThemeExtendImpl r101 = this.f419545c;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "<this>");
            return (LinkThemeData) r101.f419850d.getValue(r100, MarkdownThemeImpl.ThemeExtendImpl.f419848l[1]);
        }

        public final boolean h(j r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            MarkdownThemeImpl.ThemeExtendImpl r101 = this.f419545c;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "<this>");
            return ((Boolean) r101.f419857k.getValue(r100, MarkdownThemeImpl.ThemeExtendImpl.f419848l[8])).booleanValue();
        }

        public final ThematicBreakThemeData i(j r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            MarkdownThemeImpl.ThemeExtendImpl r101 = this.f419545c;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "<this>");
            return (ThematicBreakThemeData) r101.f419856j.getValue(r100, MarkdownThemeImpl.ThemeExtendImpl.f419848l[7]);
        }
    }

    static {
        f419543b = a.f419544d;
    }

    ListThemeData c(j r100);

    HeadingThemeData e(j r100);
}
