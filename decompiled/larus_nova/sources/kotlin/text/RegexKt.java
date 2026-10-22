package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0014\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082\b\u001a\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002\u001a\u0012\u0010\u0012\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0002¨\u0006\u0014"}, d2 = {"fromInt", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/text/FlagEnum;", "", "value", "", "findNext", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", "from", "input", "", "matchEntire", FilterData.FilterOptionItem.Type.RANGE, "Lkotlin/ranges/IntRange;", "Ljava/util/regex/MatchResult;", "groupIndex", "toInt", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class RegexKt {
    public static final /* synthetic */ IntRange access$range(java.util.regex.MatchResult r100) {
        return range(r100);
    }

    public static final /* synthetic */ int access$toInt(Iterable r100) {
        return toInt(r100);
    }

    private static final /* synthetic */ <T extends Enum<T> & FlagEnum> Set<T> fromInt(final int r100) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        EnumSet r101 = EnumSet.allOf(Enum.class);
        Intrinsics.checkNotNull(r101);
        Intrinsics.needClassReification();
        CollectionsKt.retainAll(r101, new RegexKt$fromInt$1$1(r100));
        return Collections.unmodifiableSet(r101);
    }

    private static final IntRange range(java.util.regex.MatchResult r100) {
        return RangesKt.until(r100.start(), r100.end());
    }

    private static final int toInt(Iterable<? extends FlagEnum> r100) {
        Iterator<? extends FlagEnum> r101 = r100.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L6;
        r102 = r102 | r101.next().getValue();
        goto L4
    L6:
        return r102;
    }

    public static final /* synthetic */ MatchResult access$matchEntire(Matcher r100, CharSequence r101) {
        return matchEntire(r100, r101);
    }

    public static final /* synthetic */ IntRange access$range(java.util.regex.MatchResult r100, int r101) {
        return range(r100, r101);
    }

    private static final MatchResult matchEntire(Matcher r100, CharSequence r101) {
        if (r100.matches() == true) goto L6;
        return null;
    L6:
        return new MatcherMatchResult(r100, r101);
    }

    private static final IntRange range(java.util.regex.MatchResult r100, int r101) {
        return RangesKt.until(r100.start(r101), r100.end(r101));
    }

    public static final /* synthetic */ MatchResult access$findNext(Matcher r100, int r101, CharSequence r102) {
        return findNext(r100, r101, r102);
    }

    private static final MatchResult findNext(Matcher r100, int r101, CharSequence r102) {
        if (r100.find(r101) == true) goto L6;
        return null;
    L6:
        return new MatcherMatchResult(r100, r102);
    }
}
