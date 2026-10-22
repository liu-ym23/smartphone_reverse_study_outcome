package com.larus.bmhome.chat.list.cell.text.highlight;

import android.os.SystemClock;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockWithLineNumberScrollableSpan;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import io.noties.markwon.ext.tables.TableRowSpan2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import lw8.l;
import va8.p;
import va8.q0;
import va8.r0;

/* JADX INFO: loaded from: classes25.dex */
public final class SearchLandingHighlightHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SearchLandingHighlightHelper f306375a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/text/highlight/SearchLandingHighlightHelper$RawMarkdownBlockKind;", "", "<init>", "(Ljava/lang/String;I)V", "CODE", "TABLE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RawMarkdownBlockKind extends Enum<RawMarkdownBlockKind> {
        public static final RawMarkdownBlockKind CODE = null;
        public static final RawMarkdownBlockKind TABLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RawMarkdownBlockKind[] f306376a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f306377b = null;

        public static EnumEntries<RawMarkdownBlockKind> getEntries() {
            return f306377b;
        }

        static {
            RawMarkdownBlockKind r100 = new RawMarkdownBlockKind("CODE", 0);
            CODE = r100;
            RawMarkdownBlockKind r101 = new RawMarkdownBlockKind("TABLE", 1);
            TABLE = r101;
            RawMarkdownBlockKind[] r102 = {r100, r101};
            f306376a = r102;
            f306377b = EnumEntriesKt.enumEntries(r102);
        }

        public static RawMarkdownBlockKind[] values() {
            return (RawMarkdownBlockKind[]) f306376a.clone();
        }

        public static RawMarkdownBlockKind valueOf(String r100) {
            return (RawMarkdownBlockKind) r27.a.a(RawMarkdownBlockKind.class, r100);
        }

        public RawMarkdownBlockKind(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f306378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f306379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f306380c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f306378a == r101.f306378a) goto L12;
            return false;
        L12:
            if (this.f306379b == r101.f306379b) goto L15;
            return false;
        L15:
            if (this.f306380c == r101.f306380c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f306378a * 31) + this.f306379b) * 31) + this.f306380c;
        }

        public final String toString() {
            return "HighlightRange(start=" + this.f306378a + ", end=" + this.f306379b + ", color=" + this.f306380c + ')';
        }

        public a(int r100, int r101, int r102) {
            this.f306378a = r100;
            this.f306379b = r101;
            this.f306380c = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f306381f = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Integer f306382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f306383b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f306384c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f306385d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final IntRange f306386e;

        public static final class a {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f306382a, r101.f306382a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f306383b, r101.f306383b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f306384c, r101.f306384c) == true) goto L18;
            return false;
        L18:
            if (this.f306385d == r101.f306385d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f306386e, r101.f306386e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.f306382a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((((r102 * 31) + this.f306383b.hashCode()) * 31) + this.f306384c.hashCode()) * 31;
            if (this.f306385d == false) goto L9;
            int r104 = 1231;
        L10:
            int r105 = (r103 + r104) * 31;
            IntRange r106 = this.f306386e;
            if (r106 == null) goto L15;
            r101 = r106.hashCode();
        L15:
            return r105 + r101;
        L9:
            r104 = 1237;
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "LandingTarget(textOffset=" + this.f306382a + ", mode=" + this.f306383b + ", detail=" + this.f306384c + ", preferBlockLanding=" + this.f306385d + ", matchedRange=" + this.f306386e + ')';
        }

        static {
            f306381f = new b(null, "block_top", "", false, 24);
        }

        public b(Integer r100, String r101, String r102, boolean r103, IntRange r104) {
            Intrinsics.checkNotNullParameter(r101, "mode");
            Intrinsics.checkNotNullParameter(r102, "detail");
            this.f306382a = r100;
            this.f306383b = r101;
            this.f306384c = r102;
            this.f306385d = r103;
            this.f306386e = r104;
        }

        public /* synthetic */ b(Integer r100, String r101, String r102, boolean r110, int r111) {
            if ((r111 & 8) == 0) goto L5;
            boolean r103 = false;
        L6:
            this(r100, r101, r102, r103, null);
            return;
        L5:
            r103 = r110;
            goto L6
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f306387a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f306388b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f306387a, r101.f306387a) == true) goto L12;
            return false;
        L12:
            if (this.f306388b == r101.f306388b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f306387a.hashCode() * 31) + this.f306388b;
        }

        public final String toString() {
            return "MarkdownLine(text=" + this.f306387a + ", startIndex=" + this.f306388b + ')';
        }

        public c(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f306387a = r100;
            this.f306388b = r101;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f306389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f306390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f306391c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f306392d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f306389a == r101.f306389a) goto L12;
            return false;
        L12:
            if (this.f306390b == r101.f306390b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f306391c, r101.f306391c) == true) goto L18;
            return false;
        L18:
            if (this.f306392d == r101.f306392d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f306389a * 31) + this.f306390b) * 31) + this.f306391c.hashCode()) * 31) + this.f306392d;
        }

        public final String toString() {
            return "MatchedSpanRange(first=" + this.f306389a + ", last=" + this.f306390b + ", matched=" + this.f306391c + ", matchedFirst=" + this.f306392d + ')';
        }

        public d(int r100, int r101, String r102, int r103) {
            Intrinsics.checkNotNullParameter(r102, "matched");
            this.f306389a = r100;
            this.f306390b = r101;
            this.f306391c = r102;
            this.f306392d = r103;
        }
    }

    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f306393a = null;

        static {
            int[] r100 = new int[RawMarkdownBlockKind.values().length];
            r100[RawMarkdownBlockKind.CODE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[RawMarkdownBlockKind.TABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f306393a = r100;
        }
    }

    public static final class f<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Spanned f306394a;

        public f(Spanned r100) {
            this.f306394a = r100;
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            Spanned r102 = this.f306394a;
            Integer r103 = Integer.valueOf(r102.getSpanStart((usc.e) r100));
            Spanned r104 = this.f306394a;
            return ComparisonsKt.compareValues(r103, Integer.valueOf(r104.getSpanStart((usc.e) r101)));
        }
    }

    static {
        f306375a = new SearchLandingHighlightHelper();
    }

    public SearchLandingHighlightHelper() {
    }

    public static boolean c(TextView r100) {
        CharSequence r101 = r100.getText();
        if ((r101 instanceof Spannable) == true) goto L6;
        r100.setTag(R.id.search_landing_highlight_token, null);
        r100.setTag(R.id.search_landing_highlight_range, null);
        r100.setTag(R.id.search_landing_matched_block_view, null);
        r100.setTag(R.id.search_landing_matched_block_text_offset, null);
        return false;
    L6:
        Object r102 = r100.getTag(R.id.search_landing_highlight_range);
        if ((r102 instanceof a) == false) goto L9;
        a r103 = (a) r102;
    L10:
        boolean r104 = o((Spannable) r101, r103);
        if (r104 == false) goto L13;
        r100.invalidate();
    L13:
        r100.setTag(R.id.search_landing_highlight_token, null);
        r100.setTag(R.id.search_landing_highlight_range, null);
        r100.setTag(R.id.search_landing_matched_block_view, null);
        r100.setTag(R.id.search_landing_matched_block_text_offset, null);
        return r104;
    L9:
        r103 = null;
        goto L10
    }

    public static boolean d(View r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof TextView) == false) goto L9;
        return c((TextView) r100);
    L9:
        if ((r100 instanceof ViewGroup) == false) goto L21;
        Iterator<View> r101 = ViewGroupKt.getChildren((ViewGroup) r100).iterator();
    L12:
        if (r101.hasNext() == false) goto L22;
        View r102 = r101.next();
        f306375a.getClass();
        if (d(r102) == false) goto L12;
        return true;
    L22:
        return false;
    L21:
        return false;
    }

    public static String f(String r100) {
        String r101 = StringsKt.trimStart(r100).toString();
        if (StringsKt.startsWith$default(r101, "```", false, 2, null) == false) goto L6;
        return "```";
    L6:
        if (StringsKt.startsWith$default(r101, "~~~", false, 2, null) == false) goto L9;
        return "~~~";
    L9:
        return null;
    }

    public static boolean l(String r100) {
        String r101 = StringsKt.trim(r100).toString();
        if (StringsKt.contains$default(r101, '|', false, 2, null) == false) goto L27;
        int r102 = 0;
    L6:
        if (r102 >= r101.length()) goto L21;
        char r103 = r101.charAt(r102);
        if (r103 != '|') goto L10;
    L17:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L19;
        r102 = r102 + 1;
        goto L6
    L19:
        boolean r105 = false;
    L22:
        if (r105 == false) goto L28;
        return true;
    L28:
        return false;
    L10:
        if (r103 == '-') goto L17;
        if (r103 == ':') goto L17;
        if (CharsKt.isWhitespace(r103) == true) goto L17;
        r104 = false;
        goto L18
    L21:
        r105 = true;
        goto L22
    L27:
        return false;
    }

    public static String n(String r110) {
        String r111 = StringsKt.replace$default(StringsKt.replace$default(r110, "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if (r111.length() > 32) goto L6;
        return r111;
    L6:
        return StringsKt.take(r111, 32) + "...";
    }

    public static boolean e(String r100, List r101) {
        if (r100.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L25;
        List r103 = r101;
        if ((r103 instanceof Collection) == true) goto L10;
    L12:
        Iterator r104 = r103.iterator();
    L14:
        if (r104.hasNext() == false) goto L18;
        if (StringsKt.contains(r100, (String) r104.next(), true) == false) goto L14;
        boolean r105 = true;
    L19:
        if (r105 == false) goto L26;
        return true;
    L26:
        return false;
    L18:
        r105 = false;
        goto L19
    L10:
        if (r103.isEmpty() == false) goto L12;
    L25:
        return false;
    L5:
        r102 = false;
        goto L6
    }

    public static List g(String r100, String r101) {
        ArrayList r102 = new ArrayList();
        int r103 = 0;
    L4:
        if (r103 > (r100.length() - r101.length())) goto L9;
        int r104 = StringsKt.indexOf(r100, r101, r103, true);
        if (r104 < 0) goto L9;
        int r105 = r101.length() + r104;
        r102.add(RangesKt.until(r104, r105));
        r103 = r105;
    L9:
        return r102;
    }

    public static b h(TextView r310, q0 r311) {
        if ((r310 instanceof CustomMarkdownTextView) == false) goto L5;
        CustomMarkdownTextView r100 = (CustomMarkdownTextView) r310;
    L6:
        if (r100 == null) goto L8;
        int r101 = r0.f553977a;
        List r102 = r0.a(r311.f553974b);
        l r103 = r100.getMarkdownContent();
        if (r103 == null) goto L12;
        SpannableStringBuilder r104 = r103.e();
    L14:
        if ((r104 instanceof Spanned) == false) goto L16;
        Spanned r105 = r104;
    L17:
        String r106 = "markdown block target fallback targetMessageId=";
        if (r105 != null) goto L25;
        b r107 = j(r100, r311, r102, null);
        if (r107 == null) goto L22;
        return r107;
    L22:
        FLogger.f375446a.d("search_landing", "markdown block target fallback targetMessageId=" + r311.f553973a + ", reason=markdown_null");
        return b.f306381f;
    L25:
        if (r105.length() != 0) goto L27;
        boolean r108 = true;
    L28:
        if (r108 == false) goto L34;
        b r109 = j(r100, r311, r102, null);
        if (r109 == null) goto L32;
        return r109;
    L32:
        FLogger.f375446a.d("search_landing", "markdown block target fallback targetMessageId=" + r311.f553973a + ", reason=markdown_empty");
        return b.f306381f;
    L34:
        List r110 = ArraysKt.sortedWith(r105.getSpans(0, r105.length(), usc.e.class), new f(r105));
        Iterator r111 = r110.iterator();
    L35:
        String r112 = "";
        if (r111.hasNext() == false) goto L73;
        usc.e r113 = (usc.e) r111.next();
        int r114 = r105.getSpanStart(r113);
        int r115 = r105.getSpanEnd(r113);
        if (r114 < 0) goto L35;
        if (r115 <= r114) goto L35;
        Intrinsics.checkNotNull(r113);
        String r116 = r311.f553973a;
        if (e(r113.h(), r102) == false) goto L44;
        String r117 = "dataValue";
    L69:
        if (r117 == null) goto L35;
        b r118 = new b(Integer.valueOf(r114), "custom_data_span", "dataType=" + n(r113.getDataType()) + ", span=" + r114 + '-' + r115 + ", dataValueId=" + n(r113.k()) + ", matchedSource=" + r117, true, 16);
        FLogger r119 = FLogger.f375446a;
        StringBuilder r120 = new StringBuilder("markdown block target hit targetMessageId=");
        r120.append(r311.f553973a);
        r120.append(", keyword=");
        r120.append(n(r311.f553974b));
        r120.append(", ");
        r120.append(r118.f306384c);
        r119.d("search_landing", r120.toString());
        return r118;
    L44:
        String r121 = r113.l();
        if (r121 != null) goto L48;
        r121 = "";
    L48:
        if (e(r121, r102) == false) goto L51;
        r117 = "dataExtra";
        goto L69
    L51:
        if (r113.k().length() <= 0) goto L53;
        boolean r122 = true;
    L54:
        if (r122 == false) goto L68;
        wc8.b r123 = wc8.b.f559187a;
        String r124 = r123.c(r116, r113.k(), "search_landing");
        if (r124 != null) goto L59;
        r124 = "";
    L59:
        if (e(r124, r102) == false) goto L61;
        r117 = "cacheByMessage";
        goto L69
    L61:
        String r125 = r123.b(r113.k(), "search_landing");
        if (r125 == null) goto L66;
        r112 = r125;
    L66:
        if (e(r112, r102) == false) goto L68;
        r117 = "cache";
    L68:
        r117 = null;
        goto L69
    L53:
        r122 = false;
        goto L54
    L73:
        Object[] r126 = r105.getSpans(0, r105.length(), jw8.b.class);
        ArrayList r127 = new ArrayList();
        int r128 = r126.length;
        int r129 = 0;
    L74:
        if (r129 >= r128) goto L158;
        jw8.b r130 = (jw8.b) r126[r129];
        Integer r131 = Integer.valueOf(r105.getSpanStart(r130));
        if (r131.intValue() < 0) goto L78;
        boolean r132 = true;
    L79:
        if (r132 == true) goto L82;
        r131 = null;
    L82:
        if (r131 != null) goto L94;
        r131 = r130.getStartIndex();
        if (r131 != null) goto L87;
    L92:
        r131 = null;
    L93:
        if (r131 != null) goto L94;
        Object[] r133 = r126;
        int r210 = r128;
        String r211 = r112;
    L154:
        d r134 = null;
    L155:
        if (r134 == null) goto L157;
        r127.add(r134);
    L157:
        r129 = r129 + 1;
        r126 = r133;
        r128 = r210;
        r112 = r211;
        goto L74
    L87:
        if (r131.intValue() < 0) goto L89;
        boolean r135 = true;
    L90:
        if (r135 == false) goto L92;
    L89:
        r135 = false;
    L94:
        int r136 = r131.intValue();
        Integer r137 = Integer.valueOf(r105.getSpanEnd(r130));
        r133 = r126;
        if (r137.intValue() <= r136) goto L97;
        boolean r138 = true;
    L98:
        if (r138 == true) goto L101;
        r137 = null;
    L101:
        if (r137 != null) goto L113;
        Integer r139 = r130.getEndIndex();
        if (r139 != null) goto L106;
    L111:
        r137 = null;
    L112:
        if (r137 != null) goto L113;
        int r140 = r136 + 1;
    L115:
        String r141 = r130.getCode();
        if (r141 != null) goto L119;
        r141 = r112;
    L119:
        if (r141.length() != 0) goto L121;
        boolean r142 = true;
    L122:
        if (r142 == true) goto L300;
    L131:
        Iterator r143 = r102.iterator();
    L133:
        if (r143.hasNext() == false) goto L138;
        Object r144 = r143.next();
        r210 = r128;
        r211 = r112;
        if (StringsKt.contains(r141, (String) r144, true) == true) goto L139;
        r128 = r210;
        r112 = r211;
    L139:
        String r145 = (String) r144;
        if (r145 == null) goto L154;
        Integer r146 = Integer.valueOf(StringsKt.indexOf$default(r141, r145, 0, true, 2, null));
        if (r146.intValue() < 0) goto L145;
        boolean r147 = true;
    L146:
        if (r147 == true) goto L149;
        r146 = null;
    L149:
        if (r146 == null) goto L151;
        int r148 = r146.intValue() + r136;
    L152:
        r134 = new d(r136, r140 - 1, r145, r148);
        goto L155
    L151:
        r148 = r136;
        goto L152
    L145:
        r147 = false;
        goto L146
    L138:
        r210 = r128;
        r211 = r112;
        r144 = null;
        goto L139
    L300:
        Result.Companion r149 = Result.Companion;     // Catch: Throwable -> L125
        Object r150 = Result.m9449constructorimpl(r105.subSequence(r136, RangesKt.coerceAtMost(r140, r105.length())).toString());     // Catch: Throwable -> L125
    L128:
        if (Result.m9455isFailureimpl(r150) == false) goto L130;
        r150 = r112;
    L130:
        r141 = (String) r150;
    L125:
        th = move-exception;
        Result.Companion r151 = Result.Companion;
        r150 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L128
    L121:
        r142 = false;
        goto L122
    L106:
        if (r139.intValue() <= r136) goto L108;
        boolean r152 = true;
    L109:
        if (r152 == false) goto L111;
        r137 = r139;
        goto L112
    L108:
        r152 = false;
    L113:
        r140 = r137.intValue();
        goto L115
    L97:
        r138 = false;
        goto L98
    L78:
        r132 = false;
        goto L79
    L158:
        Iterator r153 = r127.iterator();
        if (r153.hasNext() == true) goto L161;
        Object r154 = null;
    L170:
        d r155 = (d) r154;
        if (r155 == null) goto L173;
        Integer r156 = Integer.valueOf(r155.f306389a);
        StringBuilder r157 = new StringBuilder("span=");
        r157.append(r155.f306389a);
        r157.append('-');
        r157.append(r155.f306390b + 1);
        r157.append(", matched=");
        SearchLandingHighlightHelper r158 = f306375a;
        String r159 = r155.f306391c;
        r158.getClass();
        r157.append(n(r159));
        String r212 = r157.toString();
        int r160 = r155.f306392d;
        b r161 = new b(r156, "custom_code_span", r212, true, new IntRange(r160, (r155.f306391c.length() + r160) - 1));
        FLogger.f375446a.d("search_landing", "markdown structural block target hit targetMessageId=" + r311.f553973a + ", keyword=" + n(r311.f553974b) + ", type=custom_code, " + r161.f306384c);
        b r162 = r161;
        CustomMarkdownTextView r213 = r100;
        String r214 = "markdown block target fallback targetMessageId=";
        List r215 = r110;
    L292:
        if (r162 == null) goto L294;
        return r162;
    L294:
        b r163 = j(r213, r311, r102, r105.toString());
        if (r163 == null) goto L297;
        return r163;
    L297:
        int r164 = r105.getSpans(0, r105.length(), jw8.b.class).length;
        int r165 = r105.getSpans(0, r105.length(), CodeBlockWithLineNumberScrollableSpan.class).length;
        int r166 = r105.getSpans(0, r105.length(), TableRowSpan2.class).length;
        FLogger.f375446a.d("search_landing", r214 + r311.f553973a + ", keyword=" + n(r311.f553974b) + ", reason=custom_span_miss, spanCount=" + r215.size() + ", customCodeSpanCount=" + r164 + ", codeSpanCount=" + r165 + ", tableSpanCount=" + r166 + ", markdownLength=" + r105.length());
        return b.f306381f;
    L173:
        Object[] r167 = r105.getSpans(0, r105.length(), CodeBlockWithLineNumberScrollableSpan.class);
        ArrayList r168 = new ArrayList();
        int r169 = r167.length;
        int r170 = 0;
    L174:
        if (r170 >= r169) goto L206;
        Object r171 = r167[r170];
        Object[] r172 = r167;
        int r173 = r105.getSpanStart(r171);
        int r174 = r105.getSpanEnd(r171);
        if (r173 < 0) goto L201;
        if (r174 <= r173) goto L201;
        int r216 = r169;
        String r175 = r105.subSequence(r173, r174).toString();
        Iterator r217 = r102.iterator();
    L181:
        if (r217.hasNext() == false) goto L186;
        Object r218 = r217.next();
        List r219 = r110;
        String r220 = r106;
        if (StringsKt.contains(r175, (String) r218, true) == true) goto L187;
        r110 = r219;
        r106 = r220;
    L187:
        String r176 = (String) r218;
        if (r176 == null) goto L202;
        Integer r177 = Integer.valueOf(StringsKt.indexOf$default(r175, r176, 0, true, 2, null));
        if (r177.intValue() < 0) goto L193;
        boolean r178 = true;
    L194:
        if (r178 == true) goto L197;
        r177 = null;
    L197:
        if (r177 == null) goto L199;
        int r179 = r177.intValue() + r173;
    L200:
        d r180 = new d(r173, r174 - 1, r176, r179);
    L203:
        if (r180 == null) goto L205;
        r168.add(r180);
    L205:
        r170 = r170 + 1;
        r167 = r172;
        r169 = r216;
        r110 = r219;
        r106 = r220;
        goto L174
    L199:
        r179 = r173;
        goto L200
    L193:
        r178 = false;
    L202:
        r180 = null;
        goto L203
    L186:
        r220 = r106;
        r219 = r110;
        r218 = null;
    L201:
        r220 = r106;
        r216 = r169;
        r219 = r110;
        goto L202
    L206:
        r214 = r106;
        r215 = r110;
        Iterator r181 = r168.iterator();
        if (r181.hasNext() == true) goto L209;
        Object r182 = null;
    L218:
        d r183 = (d) r182;
        if (r183 == null) goto L221;
        Integer r221 = Integer.valueOf(r183.f306389a);
        StringBuilder r184 = new StringBuilder("span=");
        r184.append(r183.f306389a);
        r184.append('-');
        r184.append(r183.f306390b + 1);
        r184.append(", matched=");
        SearchLandingHighlightHelper r185 = f306375a;
        String r186 = r183.f306391c;
        r185.getClass();
        r184.append(n(r186));
        String r222 = r184.toString();
        int r187 = r183.f306392d;
        r162 = new b(r221, "code_block_span", r222, true, new IntRange(r187, (r183.f306391c.length() + r187) - 1));
        FLogger.f375446a.d("search_landing", "markdown structural block target hit targetMessageId=" + r311.f553973a + ", keyword=" + n(r311.f553974b) + ", type=code, " + r162.f306384c);
        r213 = r100;
        goto L292
    L221:
        Object[] r188 = r105.getSpans(0, r105.length(), TableRowSpan2.class);
        ArrayList r189 = new ArrayList();
        int r190 = r188.length;
        int r191 = 0;
    L222:
        if (r191 >= r190) goto L232;
        TableRowSpan2 r192 = (TableRowSpan2) r188[r191];
        int r193 = r105.getSpanStart(r192);
        int r194 = r105.getSpanEnd(r192);
        if (r193 < 0) goto L228;
        if (r194 <= r193) goto L228;
        IntRange r195 = RangesKt.until(r193, r194);
    L229:
        if (r195 == null) goto L231;
        r189.add(r195);
    L231:
        r191 = r191 + 1;
    L228:
        r195 = null;
        goto L229
    L232:
        List r196 = CollectionsKt.sortedWith(r189, new com.larus.bmhome.chat.list.cell.text.highlight.c());
        Iterator r197 = r196.iterator();
        int r198 = 0;
    L234:
        if (r197.hasNext() == false) goto L250;
        IntRange r199 = (IntRange) r197.next();
        String r200 = r105.subSequence(r199.getFirst(), r199.getLast() + 1).toString();
        List r201 = r102;
        if ((r201 instanceof Collection) == true) goto L238;
    L240:
        Iterator r202 = r201.iterator();
    L242:
        if (r202.hasNext() == false) goto L246;
        if (StringsKt.contains(r200, (String) r202.next(), true) == false) goto L242;
        boolean r203 = true;
    L247:
        if (r203 == true) goto L248;
        r198 = r198 + 1;
        goto L234
    L248:
        int r204 = r198;
    L251:
        if (r204 < 0) goto L263;
        IntRange r205 = (IntRange) ListProtector.get(r196, r204);
        Iterator r206 = r102.iterator();
    L255:
        if (r206.hasNext() == false) goto L260;
        Object r207 = r206.next();
        Iterator r223 = r206;
        if (StringsKt.contains(r105.subSequence(r205.getFirst(), r205.getLast() + 1).toString(), (String) r207, true) == true) goto L258;
        r206 = r223;
        goto L255
    L258:
        Object r208 = r207;
    L261:
        String r209 = (String) r208;
        if (r209 == null) goto L263;
        int r224 = r205.getFirst();
        int r1100 = r204 - 1;
    L266:
        if ((-1) >= r1100) goto L271;
        IntRange r1101 = (IntRange) ListProtector.get(r196, r1100);
        r213 = r100;
        if ((r1101.getLast() + 1) < r224) goto L272;
        r224 = r1101.getFirst();
        r1100 = r1100 - 1;
        r100 = r213;
    L272:
        int r225 = r205.getLast();
        int r226 = r204 + 1;
        int r1102 = r196.size();
    L273:
        if (r226 >= r1102) goto L278;
        IntRange r1103 = (IntRange) ListProtector.get(r196, r226);
        List r1104 = r196;
        int r227 = r1102;
        if (r1103.getFirst() > (r225 + 1)) goto L278;
        r225 = r1103.getLast();
        r226 = r226 + 1;
        r196 = r1104;
        r1102 = r227;
    L278:
        Integer r228 = Integer.valueOf(StringsKt.indexOf$default(r105.subSequence(r205.getFirst(), r205.getLast() + 1).toString(), r209, 0, true, 2, null));
        if (r228.intValue() < 0) goto L281;
        boolean r229 = true;
    L282:
        if (r229 == true) goto L285;
        r228 = null;
    L285:
        if (r228 == null) goto L287;
        int r230 = r205.getFirst() + r228.intValue();
    L288:
        d r231 = new d(r224, r225, r209, r230);
    L289:
        if (r231 == null) goto L291;
        Integer r232 = Integer.valueOf(r231.f306389a);
        StringBuilder r233 = new StringBuilder("span=");
        r233.append(r231.f306389a);
        r233.append('-');
        r233.append(r231.f306390b + 1);
        r233.append(", matched=");
        SearchLandingHighlightHelper r234 = f306375a;
        String r235 = r231.f306391c;
        r234.getClass();
        r233.append(n(r235));
        String r236 = r233.toString();
        int r237 = r231.f306392d;
        r162 = new b(r232, "table_span", r236, true, new IntRange(r237, (r231.f306391c.length() + r237) - 1));
        FLogger.f375446a.d("search_landing", "markdown structural block target hit targetMessageId=" + r311.f553973a + ", keyword=" + n(r311.f553974b) + ", type=table, " + r162.f306384c);
        goto L292
    L291:
        r162 = null;
        goto L292
    L287:
        r230 = r205.getFirst();
        goto L288
    L281:
        r229 = false;
        goto L282
    L271:
        r213 = r100;
        goto L272
    L260:
        r208 = null;
    L263:
        r213 = r100;
        r231 = null;
    L246:
        r203 = false;
        goto L247
    L238:
        if (r201.isEmpty() == false) goto L240;
    L250:
        r204 = -1;
        goto L251
    L209:
        r182 = r181.next();
        if (r181.hasNext() == false) goto L218;
        int r238 = ((d) r182).f306392d;
    L213:
        Object r239 = r181.next();
        int r240 = ((d) r239).f306392d;
        if (r238 <= r240) goto L217;
        r182 = r239;
        r238 = r240;
    L217:
        if (r181.hasNext() == true) goto L213;
    L161:
        r154 = r153.next();
        if (r153.hasNext() == false) goto L170;
        int r241 = ((d) r154).f306392d;
    L165:
        Object r242 = r153.next();
        int r1105 = ((d) r242).f306392d;
        if (r241 <= r1105) goto L169;
        r154 = r242;
        r241 = r1105;
    L169:
        if (r153.hasNext() == true) goto L165;
    L27:
        r108 = false;
        goto L28
    L16:
        r105 = null;
        goto L17
    L12:
        r104 = null;
        goto L14
    L8:
        return b.f306381f;
    L5:
        r100 = null;
        goto L6
    }

    public static Integer i(List r100, int r101) {
        int r102 = RangesKt.coerceAtMost(r101, CollectionsKt.getLastIndex(r100));
        if (r102 < 0) goto L18;
        int r103 = 0;
        Integer r104 = null;
        String r105 = null;
    L5:
        String r106 = f(((c) ListProtector.get(r100, r103)).f306387a);
        if (r106 == null) goto L13;
        if (r104 != null) goto L11;
        r104 = Integer.valueOf(r103);
        r105 = r106;
        goto L13
    L11:
        if (Intrinsics.areEqual(r106, r105) == false) goto L13;
        r104 = null;
        r105 = null;
    L13:
        if (r103 == r102) goto L16;
        r103 = r103 + 1;
        goto L5
    L16:
        return r104;
    L18:
        return null;
    }

    public static boolean k(List r100, int r101) {
        c r102 = (c) CollectionsKt.getOrNull(r100, r101);
        if (r102 == null) goto L31;
        String r103 = r102.f306387a;
        if (r103 == null) goto L33;
        String r104 = null;
        if (StringsKt.contains$default(r103, '|', false, 2, null) == true) goto L10;
        return false;
    L10:
        c r105 = (c) CollectionsKt.getOrNull(r100, r101 - 1);
        if (r105 == null) goto L13;
        String r106 = r105.f306387a;
    L14:
        String r107 = "";
        if (r106 != null) goto L17;
        r106 = "";
    L17:
        c r108 = (c) CollectionsKt.getOrNull(r100, r101 + 1);
        if (r108 == null) goto L20;
        r104 = r108.f306387a;
    L20:
        if (r104 == null) goto L24;
        r107 = r104;
    L24:
        if (l(r106) == false) goto L26;
    L29:
        return true;
    L26:
        if (l(r107) == true) goto L29;
        if (l(r103) == true) goto L29;
        return false;
    L13:
        r106 = null;
        goto L14
    L33:
        return false;
    L31:
        return false;
    }

    public static void m(TextView r100, b r101) {
        r100.setTag(R.id.search_landing_matched_block_view, Boolean.TRUE);
        Integer r102 = r101.f306382a;
        if (r102 != null) goto L5;
    L10:
        r102 = null;
    L11:
        r100.setTag(R.id.search_landing_matched_block_text_offset, r102);
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("mark matched block target view=");
        r104.append(r100.getClass().getSimpleName());
        r104.append(", mode=");
        r104.append(r101.f306383b);
        r104.append(", textOffset=");
        Integer r105 = r101.f306382a;
        if (r105 == null) goto L14;
        int r106 = r105.intValue();
    L15:
        r104.append(r106);
        r104.append(", detail=");
        r104.append(r101.f306384c);
        r103.d("search_landing", r104.toString());
        return;
    L14:
        r106 = -1;
        goto L15
    L5:
        if (r102.intValue() < 0) goto L7;
        boolean r107 = true;
    L8:
        if (r107 == false) goto L10;
    L7:
        r107 = false;
        goto L8
    }

    public static boolean o(Spannable r100, a r110) {
        if (r110 != null) goto L6;
        return false;
    L6:
        if (r110.f306378a >= 0) goto L8;
    L32:
        return false;
    L8:
        if (r110.f306379b > r100.length()) goto L32;
        int r101 = r110.f306378a;
        int r102 = r110.f306379b;
        if (r101 >= r102) goto L32;
        BackgroundColorSpan[] r103 = (BackgroundColorSpan[]) r100.getSpans(r101, r102, BackgroundColorSpan.class);
        Intrinsics.checkNotNull(r103);
        ArrayList r104 = new ArrayList();
        int r105 = r103.length;
        int r106 = 0;
    L13:
        boolean r107 = true;
        if (r106 >= r105) goto L26;
        BackgroundColorSpan r108 = r103[r106];
        if (r100.getSpanStart(r108) == r110.f306378a) goto L18;
    L22:
        r107 = false;
    L23:
        if (r107 == false) goto L25;
        r104.add(r108);
    L25:
        r106 = r106 + 1;
        goto L13
    L18:
        if (r100.getSpanEnd(r108) != r110.f306379b) goto L22;
        if (r108.getBackgroundColor() != r110.f306380c) goto L22;
    L26:
        Iterator r111 = r104.iterator();
    L28:
        if (r111.hasNext() == false) goto L31;
        r100.removeSpan((BackgroundColorSpan) r111.next());
        goto L28
    L31:
        return !r104.isEmpty();
    }

    public static b j(CustomMarkdownTextView r210, q0 r211, List r212, String r213) {
        String r100 = r210.getOriginText();
        boolean r101 = true;
        if (r100 != null) goto L5;
    L10:
        r100 = null;
    L11:
        if (r213 != null) goto L13;
    L21:
        CharSequence r102 = r210.getText();
        if (r102 == null) goto L31;
        String r103 = r102.toString();
        if (r103 == null) goto L31;
        if (r103.length() <= 0) goto L28;
        boolean r104 = true;
    L29:
        if (r104 == false) goto L31;
    L32:
        if (r100 != null) goto L34;
        final String r105 = r103;
    L35:
        if (r105 != null) goto L37;
    L40:
        boolean r106 = true;
    L42:
        if (r106 == false) goto L58;
        FLogger r107 = FLogger.f375446a;
        StringBuilder r108 = new StringBuilder("raw markdown block target miss targetMessageId=");
        r108.append(r211.f553973a);
        r108.append(", reason=source_empty, originEmpty=");
        if (r100 != null) goto L46;
    L49:
        boolean r109 = true;
    L50:
        r108.append(r109);
        r108.append(", renderedEmpty=");
        if (r103 != null) goto L53;
    L56:
        r108.append(r101);
        r107.d("search_landing", r108.toString());
        return null;
    L53:
        if (r103.length() == 0) goto L56;
        r101 = false;
        goto L56
    L46:
        if (r100.length() == 0) goto L49;
        r109 = false;
        goto L50
    L58:
        if (r100 == null) goto L60;
        String r110 = PlayerResolution.SDKKEY.ORIGIN;
    L61:
        Iterator r111 = SequencesKt.mapNotNull(CollectionsKt.asSequence(r212), new com.larus.bmhome.chat.list.cell.text.highlight.b(r105)).iterator();
        if (r111.hasNext() == true) goto L64;
        Object r112 = null;
    L73:
        Pair r113 = (Pair) r112;
        if (r113 != null) goto L77;
        FLogger.f375446a.d("search_landing", "raw markdown block target miss targetMessageId=" + r211.f553973a + ", reason=keyword_miss, source=" + r110 + ", sourceLength=" + r105.length());
        return null;
    L77:
        ArrayList r114 = new ArrayList();
        Iterator r115 = StringsKt.split$default(r105, new char[]{'\n'}, false, 0, 6, null).iterator();
        int r116 = 0;
    L79:
        if (r115.hasNext() == false) goto L81;
        String r117 = (String) r115.next();
        r114.add(new c(r117, r116));
        r116 = r116 + (r117.length() + 1);
        goto L79
    L81:
        ListIterator r118 = r114.listIterator(r114.size());
    L82:
        int r119 = -1;
        if (r118.hasPrevious() == false) goto L90;
        if (((c) r118.previous()).f306388b > ((Number) r113.getFirst()).intValue()) goto L87;
        boolean r120 = true;
    L88:
        if (r120 == false) goto L82;
        int r121 = r118.nextIndex();
    L91:
        int r122 = RangesKt.coerceAtLeast(r121, 0);
        if (r100 != null) goto L94;
    L99:
        RawMarkdownBlockKind r123 = null;
    L100:
        if (r100 != null) goto L102;
    L113:
        int r124 = r122;
    L114:
        c r125 = (c) CollectionsKt.getOrNull(r114, r124);
        if (r125 == null) goto L117;
        String r126 = r125.f306387a;
    L119:
        if (r126 != null) goto L122;
        r126 = "";
    L122:
        if (f(r126) == null) goto L146;
        Iterator<Integer> r127 = new IntRange(r124 + 1, RangesKt.coerceAtMost(r122, CollectionsKt.getLastIndex(r114))).iterator();
    L125:
        if (r127.hasNext() == false) goto L140;
        Integer r128 = r127.next();
        c r129 = (c) CollectionsKt.getOrNull(r114, r128.intValue());
        if (r129 == null) goto L129;
        String r130 = r129.f306387a;
    L130:
        if (r130 != null) goto L133;
        r130 = "";
    L133:
        if ((!StringsKt.isBlank(r130)) == false) goto L137;
        f306375a.getClass();
        if (f(r130) != null) goto L137;
        boolean r131 = true;
    L138:
        if (r131 == false) goto L125;
    L141:
        Integer r132 = r128;
        if (r132 == null) goto L144;
        int r133 = r132.intValue();
    L170:
        if (r100 == null) goto L200;
        c r134 = (c) CollectionsKt.getOrNull(r114, r133);
        if (r134 == null) goto L174;
        String r135 = r134.f306387a;
    L175:
        if (r135 != null) goto L177;
        r135 = "";
    L177:
        CharSequence r136 = r210.getText();
        if (r136 == null) goto L180;
        String r137 = r136.toString();
    L181:
        if (r137 != null) goto L183;
        String r138 = "";
    L184:
        String r139 = StringsKt.trim(StringsKt.trim(StringsKt.trim(StringsKt.trimStart(StringsKt.trim(r135).toString(), new char[]{'#', Typography.greater, '-', '*', '+'})).toString(), new char[]{'|'})).toString();
        if (r139.length() < 2) goto L187;
        boolean r140 = true;
    L188:
        if (r140 == false) goto L190;
        String r141 = r139;
    L191:
        if (r141 == null) goto L199;
        Integer r142 = Integer.valueOf(StringsKt.indexOf$default(r138, r141, 0, true, 2, null));
        if (r142.intValue() < 0) goto L196;
        boolean r143 = true;
    L197:
        if (r143 == false) goto L199;
    L201:
        Integer r144 = r142;
    L203:
        if (r123 != null) goto L205;
        int r145 = -1;
    L206:
        if (r145 == 1) goto L210;
        if (r145 == 2) goto L209;
        String r146 = "raw_markdown_line";
    L211:
        String r147 = r146;
        StringBuilder r148 = new StringBuilder("source=");
        r148.append(r110);
        r148.append(", keywordLine=");
        r148.append(r122);
        r148.append(", blockStartLine=");
        r148.append(r124);
        r148.append(", visualAnchorLine=");
        r148.append(r133);
        r148.append(", renderedOffset=");
        if (r144 == null) goto L214;
        r119 = r144.intValue();
    L214:
        r148.append(r119);
        r148.append(", matched=");
        r148.append(n((String) r113.getSecond()));
        String r149 = r148.toString();
        if (r123 != RawMarkdownBlockKind.CODE) goto L217;
    L220:
        boolean r150 = true;
    L221:
        b r151 = new b(r144, r147, r149, r150, 16);
        FLogger.f375446a.d("search_landing", "raw markdown block target hit targetMessageId=" + r211.f553973a + ", keyword=" + n(r211.f553974b) + ", " + r151.f306384c);
        return r151;
    L217:
        if (r123 == RawMarkdownBlockKind.TABLE) goto L220;
        r150 = false;
        goto L221
    L209:
        r146 = "raw_table_block";
        goto L211
    L210:
        r146 = "raw_code_block";
        goto L211
    L205:
        r145 = e.f306393a[r123.ordinal()];
        goto L206
    L196:
        r143 = false;
    L199:
        r144 = null;
        goto L203
    L190:
        r141 = null;
        goto L191
    L187:
        r140 = false;
        goto L188
    L183:
        r138 = r137;
        goto L184
    L180:
        r137 = null;
        goto L181
    L174:
        r135 = null;
        goto L175
    L200:
        r142 = (Integer) r113.getFirst();
        goto L201
    L144:
        r133 = r122;
    L137:
        r131 = false;
        goto L138
    L129:
        r130 = null;
        goto L130
    L140:
        r128 = null;
        goto L141
    L146:
        if (k(r114, r124) == false) goto L168;
        Iterator<Integer> r152 = new IntRange(r124, RangesKt.coerceAtMost(r122, CollectionsKt.getLastIndex(r114))).iterator();
    L149:
        if (r152.hasNext() == false) goto L164;
        Integer r153 = r152.next();
        c r154 = (c) CollectionsKt.getOrNull(r114, r153.intValue());
        if (r154 == null) goto L153;
        String r155 = r154.f306387a;
    L154:
        if (r155 != null) goto L157;
        r155 = "";
    L157:
        if ((!StringsKt.isBlank(r155)) == false) goto L161;
        f306375a.getClass();
        if (l(r155) == true) goto L161;
        boolean r156 = true;
    L162:
        if (r156 == false) goto L149;
    L165:
        Integer r157 = r153;
        if (r157 == null) goto L168;
        r133 = r157.intValue();
    L161:
        r156 = false;
        goto L162
    L153:
        r155 = null;
        goto L154
    L164:
        r153 = null;
    L168:
        r133 = r124;
        goto L170
    L117:
        r126 = null;
        goto L119
    L102:
        if (r123 != RawMarkdownBlockKind.CODE) goto L107;
        Integer r158 = i(r114, r122);
        if (r158 == null) goto L113;
        r124 = r158.intValue();
        goto L114
    L107:
        if (r123 != RawMarkdownBlockKind.TABLE) goto L113;
        r124 = r122;
    L109:
        if (r124 <= 0) goto L114;
        int r159 = r124 - 1;
        if (k(r114, r159) == false) goto L114;
        r124 = r159;
        goto L109
    L94:
        if (i(r114, r122) == null) goto L97;
        r123 = RawMarkdownBlockKind.CODE;
        goto L100
    L97:
        if (k(r114, r122) == false) goto L99;
        r123 = RawMarkdownBlockKind.TABLE;
        goto L100
    L87:
        r120 = false;
        goto L88
    L90:
        r121 = -1;
        goto L91
    L64:
        r112 = r111.next();
        if (r111.hasNext() == false) goto L73;
        int r160 = ((Number) ((Pair) r112).getFirst()).intValue();
    L68:
        Object r161 = r111.next();
        int r162 = ((Number) ((Pair) r161).getFirst()).intValue();
        if (r160 <= r162) goto L72;
        r112 = r161;
        r160 = r162;
    L72:
        if (r111.hasNext() == true) goto L68;
    L60:
        r110 = "rendered";
        goto L61
    L37:
        if (r105.length() == 0) goto L40;
        r106 = false;
        goto L42
    L34:
        r105 = r100;
        goto L35
    L28:
        r104 = false;
    L31:
        r103 = null;
        goto L32
    L13:
        if (r213.length() <= 0) goto L15;
        boolean r163 = true;
    L16:
        if (r163 == false) goto L18;
        r103 = r213;
    L19:
        if (r103 == null) goto L21;
    L18:
        r103 = null;
        goto L19
    L15:
        r163 = false;
        goto L16
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r164 = true;
    L8:
        if (r164 == false) goto L10;
    L7:
        r164 = false;
        goto L8
    }

    public static /* synthetic */ boolean b(SearchLandingHighlightHelper r110, CustomMarkdownTextView r111, q0 r112, p r113, boolean r114, int r115) {
        if ((r115 & 8) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r115 & 16) == 0) goto L9;
        boolean r101 = true;
    L11:
        if ((r115 & 32) == 0) goto L13;
        long r116 = SystemClock.elapsedRealtime();
    L15:
        return r110.a(r111, r112, r113, r100, r101, r116);
    L13:
        r116 = 0;
        goto L15
    L9:
        r101 = false;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }

    public final boolean a(final TextView r210, final q0 r211, final p r212, boolean r213, boolean r214, long r215) {
        if (r210 != null) goto L5;
        return false;
    L5:
        if (r211 != null) goto L8;
        c(r210);
        return false;
    L8:
        CharSequence r100 = r210.getText();
        if (r100 != null) goto L11;
        return false;
    L11:
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("landing pipeline enter targetMessageId=");
        r102.append(r211.f553973a);
        r102.append(", keyword=");
        r102.append(n(r211.f553974b));
        r102.append(", textLength=");
        r102.append(r100.length());
        r102.append(", view=");
        r102.append(r210.getClass().getSimpleName());
        r102.append(", layoutReady=");
        if (r210.getLayout() == null) goto L14;
        boolean r110 = true;
    L15:
        r102.append(r110);
        r102.append(", allowBlockLandingOnMiss=");
        r102.append(r213);
        r102.append(", allowRetryBeforeDraw=");
        r102.append(r214);
        r102.append(", sinceOpenMs=");
        long r111 = r211.f553976d;
        long r112 = -1;
        if (r111 <= 0) goto L18;
        long r113 = RangesKt.coerceAtLeast(r215 - r111, 0);
    L19:
        r102.append(r113);
        r101.d("search_landing", r102.toString());
        if (r213 == false) goto L22;
        m(r210, b.f306381f);
    L22:
        String r103 = r100.toString();
        String r114 = r211.f553974b;
        Intrinsics.checkNotNullParameter(r103, "text");
        Intrinsics.checkNotNullParameter(r114, "keyword");
        if (r103.length() != 0) goto L25;
        boolean r115 = true;
    L26:
        Integer r116 = null;
        if (r115 == false) goto L29;
        List r104 = CollectionsKt.emptyList();
    L40:
        IntRange r105 = (IntRange) CollectionsKt.firstOrNull(r104);
        if (r105 != null) goto L64;
        FLogger r106 = FLogger.f375446a;
        StringBuilder r117 = new StringBuilder("highlight miss targetMessageId=");
        r117.append(r211.f553973a);
        r117.append(", keyword=");
        r117.append(n(r211.f553974b));
        r117.append(", textLength=");
        r117.append(r100.length());
        r117.append(", view=");
        r117.append(r210.getClass().getSimpleName());
        r117.append(", allowBlockLandingOnMiss=");
        r117.append(r213);
        r117.append(", pipelineCostMs=");
        r117.append(SystemClock.elapsedRealtime() - r215);
        r117.append(", sinceOpenMs=");
        long r118 = SystemClock.elapsedRealtime();
        long r107 = r211.f553976d;
        if (r107 <= 0) goto L45;
        long r108 = RangesKt.coerceAtLeast(r118 - r107, 0);
    L46:
        r117.append(r108);
        r106.d("search_landing", r117.toString());
        if (r100.length() != 0) goto L49;
        boolean r216 = true;
    L50:
        if (r216 == false) goto L60;
        if (r210.getLayout() != null) goto L60;
        if (r214 == false) goto L60;
        StringBuilder r109 = new StringBuilder("schedule retry targetMessageId=");
        r109.append(r211.f553973a);
        r109.append(", keyword=");
        r109.append(n(r211.f553974b));
        r109.append(", allowBlockLandingOnMiss=");
        r109.append(r213);
        r109.append(", pipelineCostMs=");
        r109.append(SystemClock.elapsedRealtime() - r215);
        r109.append(", sinceOpenMs=");
        long r119 = SystemClock.elapsedRealtime();
        long r120 = r211.f553976d;
        if (r120 <= 0) goto L57;
        r112 = RangesKt.coerceAtLeast(r119 - r120, 0);
    L57:
        r109.append(r112);
        r106.d("search_landing", r109.toString());
        r210.getViewTreeObserver().addOnPreDrawListener(new com.larus.bmhome.chat.list.cell.text.highlight.d(r210, r211, r212, r213, r215));
        return false;
    L60:
        if (r213 == false) goto L62;
        m(r210, h(r210, r211));
    L62:
        return false;
    L49:
        r216 = false;
        goto L50
    L45:
        r108 = -1;
        goto L46
    L64:
        if (r213 == false) goto L66;
        b r121 = h(r210, r211);
    L67:
        if (r121 != null) goto L69;
    L79:
        r121 = null;
    L80:
        if (r121 == null) goto L83;
        f306375a.getClass();
        m(r210, r121);
    L83:
        if (r121 == null) goto L85;
        FLogger.f375446a.d("search_landing", "prefer markdown block landing targetMessageId=" + r211.f553973a + ", keyword=" + n(r211.f553974b) + ", range=" + r105.getFirst() + '-' + r105.getLast() + ", blockTargetMode=" + r121.f306383b + ", blockTargetDetail=" + r121.f306384c);
    L85:
        FLogger r122 = FLogger.f375446a;
        StringBuilder r123 = new StringBuilder("highlight hit targetMessageId=");
        r123.append(r211.f553973a);
        r123.append(", keyword=");
        r123.append(n(r211.f553974b));
        r123.append(", range=");
        r123.append(r105.getFirst());
        r123.append('-');
        r123.append(r105.getLast());
        r123.append(", textLength=");
        r123.append(r100.length());
        r123.append(", view=");
        r123.append(r210.getClass().getSimpleName());
        r123.append(", pipelineCostMs=");
        r123.append(SystemClock.elapsedRealtime() - r215);
        r123.append(", sinceOpenMs=");
        long r124 = SystemClock.elapsedRealtime();
        long r125 = r211.f553976d;
        if (r125 <= 0) goto L88;
        r112 = RangesKt.coerceAtLeast(r124 - r125, 0);
    L88:
        r123.append(r112);
        r122.d("search_landing", r123.toString());
        boolean r126 = r100 instanceof Spannable;
        if (r126 == false) goto L91;
        Spannable r127 = (Spannable) r100;
    L92:
        if (r127 != null) goto L94;
        r127 = new SpannableStringBuilder(r100);
    L94:
        boolean r128 = !r126;
        Object r129 = r210.getTag(R.id.search_landing_highlight_range);
        if ((r129 instanceof a) == false) goto L97;
        a r130 = (a) r129;
    L98:
        o(r127, r130);
        if ((r210 instanceof CustomMarkdownTextView) == false) goto L101;
        int r131 = ((CustomMarkdownTextView) r210).getSelectedColor();
    L110:
        r127.setSpan(new BackgroundColorSpan(r131), r105.getFirst(), r105.getLast() + 1, 33);
        final Object r132 = new Object();
        r210.setTag(R.id.search_landing_highlight_token, r132);
        r210.setTag(R.id.search_landing_highlight_range, new a(r105.getFirst(), r105.getLast() + 1, r131));
        if (r128 == false) goto L113;
        r210.setText(r127, TextView.BufferType.SPANNABLE);
    L115:
        if (r212 == null) goto L117;
        r212.Py(r211);
    L117:
        r210.postDelayed(new com.larus.bmhome.chat.list.cell.text.highlight.a(r210, r132, r212, r211), r211.f553975c);
        return true;
    L113:
        r210.invalidate();
        goto L115
    L101:
        Integer r133 = Integer.valueOf(r210.getHighlightColor());
        if (r133.intValue() == 0) goto L104;
        boolean r134 = true;
    L105:
        if (r134 == false) goto L107;
        r116 = r133;
    L107:
        if (r116 == null) goto L109;
        r131 = r116.intValue();
        goto L110
    L109:
        r131 = ContextCompat.getColor(r210.getContext(), v19.c.b(R.attr.larus_primary_transparent_9, r210.getContext(), R.color.larus_primary_transparent_9));
        goto L110
    L104:
        r134 = false;
        goto L105
    L97:
        r130 = null;
        goto L98
    L91:
        r127 = null;
        goto L92
    L69:
        if (r121.f306385d == false) goto L76;
        Intrinsics.checkNotNullParameter(r105, FilterData.FilterOptionItem.Type.RANGE);
        IntRange r135 = r121.f306386e;
        if (r135 != null) goto L73;
        boolean r136 = false;
    L74:
        if (r136 == false) goto L76;
        boolean r137 = true;
    L77:
        if (r137 == false) goto L79;
    L73:
        r136 = Intrinsics.areEqual(r135, r105);
    L76:
        r137 = false;
        goto L77
    L66:
        r121 = null;
        goto L67
    L29:
        Iterator r138 = r0.a(r114).iterator();
    L31:
        if (r138.hasNext() == false) goto L35;
        Object r217 = r138.next();
        f306375a.getClass();
        if ((!((ArrayList) g(r103, (String) r217)).isEmpty()) == false) goto L31;
    L36:
        String r139 = (String) r217;
        if (r139 != null) goto L39;
        r104 = CollectionsKt.emptyList();
        goto L40
    L39:
        r104 = g(r103, r139);
        goto L40
    L35:
        r217 = null;
        goto L36
    L25:
        r115 = false;
        goto L26
    L18:
        r113 = -1;
        goto L19
    L14:
        r110 = false;
        goto L15
    }
}
