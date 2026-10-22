package com.edu.onetex.latex.icon;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b'\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H&J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/edu/onetex/latex/icon/AbsLaTeXIconBuilder;", "", "nativePtr", "", "paramPtr", "(JJ)V", "build", "Lcom/edu/onetex/latex/icon/LaTeXIcon;", "finalize", "", "setSize", "size", "", "setStyle", "style", "setType", "type", "Companion", "onetex_release"}, k = 1, mv = {1, 4, 2})
public abstract class AbsLaTeXIconBuilder {
    public static final Companion Companion = null;
    private long nativePtr;
    private long paramPtr;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0082 J\u0019\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0082 J\u0019\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\nH\u0082 J\u0019\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\nH\u0082 ¨\u0006\u000f"}, d2 = {"Lcom/edu/onetex/latex/icon/AbsLaTeXIconBuilder$Companion;", "", "()V", "nFinalize", "", "ptr", "", "paramPtr", "nSetSize", "size", "", "nSetStyle", "style", "nSetType", "type", "onetex_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final native void nFinalize(long r100, long r101);

        private final native void nSetSize(long r100, int r101);

        private final native void nSetStyle(long r100, int r101);

        private final native void nSetType(long r100, int r101);

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static final /* synthetic */ void access$nFinalize(Companion r100, long r101, long r102) {
            r100.nFinalize(r101, r102);
        }

        public static final /* synthetic */ void access$nSetSize(Companion r100, long r101, int r102) {
            r100.nSetSize(r101, r102);
        }

        public static final /* synthetic */ void access$nSetStyle(Companion r100, long r101, int r102) {
            r100.nSetStyle(r101, r102);
        }

        public static final /* synthetic */ void access$nSetType(Companion r100, long r101, int r102) {
            r100.nSetType(r101, r102);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public abstract LaTeXIcon build();

    public final void finalize() {
        long r100 = this.nativePtr;
        if (r100 == 0) goto L6;
        Companion.access$nFinalize(Companion, r100, this.paramPtr);
        this.nativePtr = 0;
        return;
    }

    public final void setSize(int r100) {
        Companion.access$nSetSize(Companion, this.nativePtr, r100);
    }

    public final void setStyle(int r100) {
        Companion.access$nSetStyle(Companion, this.nativePtr, r100);
    }

    public final void setType(int r100) {
        Companion.access$nSetType(Companion, this.nativePtr, r100);
    }

    public AbsLaTeXIconBuilder(long r100, long r101) {
        this.nativePtr = r100;
        this.paramPtr = r101;
    }
}
