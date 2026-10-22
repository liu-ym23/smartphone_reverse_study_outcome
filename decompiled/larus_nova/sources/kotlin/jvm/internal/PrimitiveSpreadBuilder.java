package kotlin.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0004H\u0004J\u001d\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0004*\u00028\u0000H$¢\u0006\u0002\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000bX\u0082\u0004¢\u0006\n\n\u0002\u0010\u000e\u0012\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", ExifInterface.GPS_DIRECTION_TRUE, "", "size", "", "(I)V", "position", "getPosition", "()I", "setPosition", "spreads", "", "getSpreads$annotations", "()V", "[Ljava/lang/Object;", "addSpread", "", "spreadArgument", "(Ljava/lang/Object;)V", "toArray", "values", "result", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getSize", "(Ljava/lang/Object;)I", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class PrimitiveSpreadBuilder<T> {
    private int position;
    private final int size;
    private final T[] spreads;

    private static /* synthetic */ void getSpreads$annotations() {
    }

    public abstract int getSize(T r100);

    public final int size() {
        int r100 = this.size - 1;
        int r101 = 0;
        if (r100 < 0) goto L12;
        int r102 = 0;
    L5:
        T r103 = this.spreads[r102];
        if (r103 == null) goto L8;
        int r104 = getSize(r103);
    L9:
        r101 = r101 + r104;
        if (r102 == r100) goto L12;
        r102 = r102 + 1;
        goto L5
    L8:
        r104 = 1;
    L12:
        return r101;
    }

    public final int getPosition() {
        return this.position;
    }

    public PrimitiveSpreadBuilder(int r100) {
        this.size = r100;
        this.spreads = (T[]) new Object[r100];
    }

    public final void addSpread(T r100) {
        Intrinsics.checkNotNullParameter(r100, "spreadArgument");
        T[] r101 = this.spreads;
        int r102 = this.position;
        this.position = r102 + 1;
        r101[r102] = r100;
    }

    public final void setPosition(int r100) {
        this.position = r100;
    }

    public final T toArray(T r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "values");
        Intrinsics.checkNotNullParameter(r101, "result");
        int r102 = this.size - 1;
        int r103 = 0;
        if (r102 < 0) goto L13;
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L5:
        T r107 = this.spreads[r104];
        if (r107 == null) goto L10;
        if (r105 >= r104) goto L9;
        int r108 = r104 - r105;
        System.arraycopy(r100, r105, r101, r106, r108);
        r106 = r106 + r108;
    L9:
        int r109 = getSize(r107);
        System.arraycopy(r107, 0, r101, r106, r109);
        r106 = r106 + r109;
        r105 = r104 + 1;
    L10:
        if (r104 == r102) goto L12;
        r104 = r104 + 1;
        goto L5
    L12:
        r103 = r105;
    L14:
        int r110 = this.size;
        if (r103 >= r110) goto L17;
        System.arraycopy(r100, r103, r101, r106, r110 - r103);
    L17:
        return r101;
    L13:
        r106 = 0;
        goto L14
    }
}
