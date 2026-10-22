package y48;

import com.larus.asr.config.builder.ChatSpeakerElementKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f566127b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<ChatSpeakerElementKey, i> f566128a;

    public static final class a {
        public static p a() {
            EnumEntries<ChatSpeakerElementKey> r100 = ChatSpeakerElementKey.getEntries();
            int r101 = i.f566101j;
            LinkedHashMap r102 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r100, 10)), 16));
            Iterator<ChatSpeakerElementKey> r103 = r100.iterator();
        L4:
            if (r103.hasNext() == false) goto L7;
            ChatSpeakerElementKey r104 = r103.next();
            r102.put(r104, i.a.a(r104));
            goto L4
        L7:
            return new p(r102);
        }
    }

    static {
    }

    public final List<i> a() {
        ChatSpeakerElementKey[] r100 = ChatSpeakerElementKey.values();
        ArrayList r101 = new ArrayList(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.add(b(r100[r103]));
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public p(Map<ChatSpeakerElementKey, i> r100) {
        Intrinsics.checkNotNullParameter(r100, "values");
        this.f566128a = r100;
    }

    public final i b(ChatSpeakerElementKey r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        i r101 = this.f566128a.get(r100);
        if (r101 != null) goto L6;
        int r102 = i.f566101j;
        return i.a.a(r100);
    L6:
        return r101;
    }
}
