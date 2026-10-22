package com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown;

import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class RichTextInlineTagData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Integer> f435759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Style f435760b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/markdown/RichTextInlineTagData$Style;", "", "<init>", "(Ljava/lang/String;I)V", "BOLD", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        public static final Style BOLD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Style[] f435761a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f435762b = null;

        public static EnumEntries<Style> getEntries() {
            return f435762b;
        }

        static {
            Style r100 = new Style();
            BOLD = r100;
            Style[] r101 = {r100};
            f435761a = r101;
            f435762b = EnumEntriesKt.enumEntries(r101);
        }

        public Style() {
            super("BOLD", 0);
        }

        public static Style[] values() {
            return (Style[]) f435761a.clone();
        }

        public static Style valueOf(String r100) {
            return (Style) r27.a.a(Style.class, r100);
        }
    }

    public RichTextInlineTagData(List<Integer> r100, Style r101) {
        Intrinsics.checkNotNullParameter(r100, "indexData");
        Intrinsics.checkNotNullParameter(r101, "style");
        this.f435759a = r100;
        this.f435760b = r101;
    }
}
