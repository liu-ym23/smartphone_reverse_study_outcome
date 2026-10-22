package com.edu.onetex.latex.icon;

import android.os.Handler;
import android.os.Looper;
import com.edu.onetex.latex.LaTeXEngine;
import com.edu.onetex.latex.LaTeXParam;
import java.util.concurrent.CountDownLatch;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\b\u0010\t\u001a\u0004\u0018\u00010\bJ\n\u0010\n\u001a\u0004\u0018\u00010\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/edu/onetex/latex/icon/LaTeXIconBuilder;", "", "latexParam", "Lcom/edu/onetex/latex/LaTeXParam;", "(Lcom/edu/onetex/latex/LaTeXParam;)V", "nIconBuilder", "", "awaitBuild", "Lcom/edu/onetex/latex/icon/LaTeXIcon;", "build", "internalBuild", "Companion", "onetex_release"}, k = 1, mv = {1, 4, 2})
public final class LaTeXIconBuilder {
    public static final Companion Companion = null;
    private static final Lazy latexParseHandler$delegate = null;
    private static final Lazy mainThreadHandler$delegate = null;
    private final LaTeXParam latexParam;
    private long nIconBuilder;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0082 J\u0011\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082 R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/edu/onetex/latex/icon/LaTeXIconBuilder$Companion;", "", "()V", "latexParseHandler", "Landroid/os/Handler;", "getLatexParseHandler", "()Landroid/os/Handler;", "latexParseHandler$delegate", "Lkotlin/Lazy;", "mainThreadHandler", "getMainThreadHandler", "mainThreadHandler$delegate", "nBuild", "", "nBuilder", "nParse", "latexParam", "Lcom/edu/onetex/latex/LaTeXParam;", "onetex_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final Handler getLatexParseHandler() {
            return (Handler) LaTeXIconBuilder.access$getLatexParseHandler$cp().getValue();
        }

        private final Handler getMainThreadHandler() {
            return (Handler) LaTeXIconBuilder.access$getMainThreadHandler$cp().getValue();
        }

        private final native long nBuild(long r100);

        private final native long nParse(LaTeXParam r100);

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static final /* synthetic */ Handler access$getLatexParseHandler$p(Companion r100) {
            return r100.getLatexParseHandler();
        }

        public static final /* synthetic */ Handler access$getMainThreadHandler$p(Companion r100) {
            return r100.getMainThreadHandler();
        }

        public static final /* synthetic */ long access$nBuild(Companion r100, long r101) {
            return r100.nBuild(r101);
        }

        public static final /* synthetic */ long access$nParse(Companion r100, LaTeXParam r101) {
            return r100.nParse(r101);
        }
    }

    static {
        Companion = new Companion(null);
        latexParseHandler$delegate = LazyKt.lazy(LaTeXIconBuilder$Companion$latexParseHandler$2.INSTANCE);
        mainThreadHandler$delegate = LazyKt.lazy(LaTeXIconBuilder$Companion$mainThreadHandler$2.INSTANCE);
    }

    private final LaTeXIcon internalBuild() {
        Companion r100 = Companion;
        long r101 = Companion.access$nParse(r100, this.latexParam);
        this.nIconBuilder = r101;
        long r102 = Companion.access$nBuild(r100, r101);
        if (r102 != 0) goto L7;
        return null;
    L7:
        return new LaTeXIcon(r102, this.latexParam);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LaTeXIcon awaitBuild() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L6;
        LaTeXEngine.INSTANCE.setAsyncParse$onetex_release(false);
        LaTeXEngine.onReceiveLog("LaTeXIconBuilder", "主线程解析", false);
        return internalBuild();
    L6:
        final Ref.ObjectRef r100 = new Ref.ObjectRef();
        r100.element = null;
        final CountDownLatch r101 = new CountDownLatch(1);
        if (LaTeXEngine.INSTANCE.getAsyncParse() == false) goto L9;
        LaTeXEngine.onReceiveLog("LaTeXIconBuilder", "子线程解析", false);
        Handler r102 = Companion.access$getLatexParseHandler$p(Companion);
    L10:
        r102.post(new AnonymousClass1(this, r100, r101));
        r101.await();     // Catch: InterruptedException -> L14
    L13:
        return (LaTeXIcon) r100.element;
    L9:
        LaTeXEngine.onReceiveLog("LaTeXIconBuilder", "子线程切换至主线程解析", false);
        r102 = Companion.access$getMainThreadHandler$p(Companion);
        goto L10
    }

    public final LaTeXIcon build() {
        return internalBuild();
    }

    public static final /* synthetic */ Lazy access$getLatexParseHandler$cp() {
        return latexParseHandler$delegate;
    }

    public static final /* synthetic */ Lazy access$getMainThreadHandler$cp() {
        return mainThreadHandler$delegate;
    }

    public LaTeXIconBuilder(LaTeXParam r100) {
        Intrinsics.checkNotNullParameter(r100, "latexParam");
        this.latexParam = r100;
    }

    public static final /* synthetic */ LaTeXIcon access$internalBuild(LaTeXIconBuilder r100) {
        return r100.internalBuild();
    }
}
