package kotlin.text;

import android.util.EventsUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0096\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0096\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "size", XmlPullParser.NO_NAMESPACE, "getSize", "()I", "get", "index", "name", XmlPullParser.NO_NAMESPACE, "isEmpty", XmlPullParser.NO_NAMESPACE, "iterator", XmlPullParser.NO_NAMESPACE, "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class MatcherMatchResult$groups$1 extends AbstractCollection<MatchGroup> implements MatchNamedGroupCollection {
    final /* synthetic */ MatcherMatchResult this$0;

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return false;
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return MatcherMatchResult.access$getMatchResult(this.this$0).groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<MatchGroup> iterator() {
        return SequencesKt.map(CollectionsKt.asSequence(CollectionsKt.getIndices(this)), new iterator.1(this)).iterator();
    }

    public MatcherMatchResult$groups$1(MatcherMatchResult r1) {
        this.this$0 = r1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object r2) {
        if (r2 != null) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == true) goto L9;
        return false;
    L9:
        return contains((MatchGroup) r2);
    L4:
        r0 = r2 instanceof MatchGroup;
        goto L5
    }

    @Override // kotlin.text.MatchGroupCollection
    public MatchGroup get(int r4) {
        IntRange r0 = RegexKt.access$range(MatcherMatchResult.access$getMatchResult(this.this$0), r4);
        if (r0.getStart().intValue() >= 0) goto L7;
        return null;
    L7:
        return new MatchGroup(MatcherMatchResult.access$getMatchResult(this.this$0).group(r4), r0);
    }

    public /* bridge */ boolean contains(MatchGroup r1) {
        return super.contains(r1);
    }

    @Override // kotlin.text.MatchNamedGroupCollection
    public MatchGroup get(String r3) {
        Intrinsics.checkNotNullParameter(r3, "name");
        return PlatformImplementationsKt.IMPLEMENTATIONS.getMatchResultNamedGroup(MatcherMatchResult.access$getMatchResult(this.this$0), r3);
    }
}
