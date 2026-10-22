package com.larus.network.http;

import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/larus/network/http/AsyncThrowable;", "", "code", "", "msg", "", LynxError.LYNX_THROWABLE, "<init>", "(JLjava/lang/String;Ljava/lang/Throwable;)V", "getCode", "()J", "toString", "Companion", "network_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AsyncThrowable extends Throwable {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AsyncThrowable f360114a = null;
    private final long code;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        f360114a = new AsyncThrowable(-999, "", ServerThrowable.INSTANCE);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "AsyncThrowable[" + this.code + ':' + getMessage() + ']';
    }

    public static final /* synthetic */ AsyncThrowable access$getDEFAULT$cp() {
        return f360114a;
    }

    public final long getCode() {
        return this.code;
    }

    public AsyncThrowable(long r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
        super(r101, r102);
        this.code = r100;
    }
}
