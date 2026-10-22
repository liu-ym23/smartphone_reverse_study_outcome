package kotlin.collections.builders;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0019\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlin/collections/builders/SerializedCollection;", "Ljava/io/Externalizable;", "()V", "collection", "", "tag", "", "(Ljava/util/Collection;I)V", "readExternal", "", "input", "Ljava/io/ObjectInput;", "readResolve", "", "writeExternal", BdpAppEventConstant.PARAMS_OUTPUT, "Ljava/io/ObjectOutput;", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SerializedCollection implements Externalizable {
    public static final Companion Companion = null;
    private static final long serialVersionUID = 0;
    public static final int tagList = 0;
    public static final int tagSet = 1;
    private Collection<?> collection;
    private final int tag;

    /* JADX INFO: loaded from: classes41.dex */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/collections/builders/SerializedCollection$Companion;", "", "()V", "serialVersionUID", "", "tagList", "", "tagSet", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SerializedCollection() {
        this(CollectionsKt.emptyList(), 0);
    }

    private final Object readResolve() {
        return this.collection;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        byte r101 = r100.readByte();
        int r102 = r101 & 1;
        if ((r101 & (-2)) != 0) goto L25;
        int r103 = r100.readInt();
        if (r103 < 0) goto L23;
        int r104 = 0;
        if (r102 != 0) goto L9;
        List r105 = CollectionsKt.createListBuilder(r103);
    L17:
        if (r104 >= r103) goto L19;
        r105.add(r100.readObject());
        r104 = r104 + 1;
        goto L17
    L19:
        List r106 = CollectionsKt.build(r105);
    L20:
        this.collection = r106;
        return;
    L9:
        if (r102 != 1) goto L15;
        Set r107 = SetsKt.createSetBuilder(r103);
    L11:
        if (r104 >= r103) goto L13;
        r107.add(r100.readObject());
        r104 = r104 + 1;
        goto L11
    L13:
        r106 = SetsKt.build(r107);
        goto L20
    L15:
        throw new InvalidObjectException("Unsupported collection type tag: " + r102 + '.');
    L23:
        throw new InvalidObjectException("Illegal size value: " + r103 + '.');
    L25:
        throw new InvalidObjectException("Unsupported flags value: " + r101 + '.');
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_OUTPUT);
        r100.writeByte(this.tag);
        r100.writeInt(this.collection.size());
        Iterator<?> r101 = this.collection.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.writeObject(r101.next());
        goto L4
    }

    public SerializedCollection(Collection<?> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "collection");
        this.collection = r100;
        this.tag = r101;
    }
}
