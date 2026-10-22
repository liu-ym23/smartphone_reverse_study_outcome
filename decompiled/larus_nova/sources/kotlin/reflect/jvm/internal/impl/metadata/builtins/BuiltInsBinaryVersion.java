package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;

/* JADX INFO: loaded from: classes5.dex */
public final class BuiltInsBinaryVersion extends BinaryVersion {
    public static final Companion Companion = null;
    public static final BuiltInsBinaryVersion INSTANCE = null;
    public static final BuiltInsBinaryVersion INVALID_VERSION = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final BuiltInsBinaryVersion readFrom(InputStream r100) {
            Intrinsics.checkNotNullParameter(r100, "stream");
            DataInputStream r101 = new DataInputStream(r100);
            IntRange r102 = new IntRange(1, r101.readInt());
            ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
            Iterator<Integer> r104 = r102.iterator();
        L4:
            if (r104.hasNext() == false) goto L6;
            ((IntIterator) r104).nextInt();
            r103.add(Integer.valueOf(r101.readInt()));
            goto L4
        L6:
            int[] r105 = CollectionsKt.toIntArray(r103);
            return new BuiltInsBinaryVersion(Arrays.copyOf(r105, r105.length));
        }
    }

    static {
        Companion = new Companion(null);
        INSTANCE = new BuiltInsBinaryVersion(new int[]{1, 0, 7});
        INVALID_VERSION = new BuiltInsBinaryVersion(new int[0]);
    }

    public boolean isCompatibleWithCurrentCompilerVersion() {
        return isCompatibleTo(INSTANCE);
    }

    public BuiltInsBinaryVersion(int... r100) {
        Intrinsics.checkNotNullParameter(r100, "numbers");
        super(Arrays.copyOf(r100, r100.length));
    }
}
