package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u000eJ\r\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u000eJ\u0010\u0010\u0013\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0017"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/MethodId;", "", "value", "", "constructor-impl", "(J)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "methodKey", "methodKey-impl", "methodSig", "methodSig-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class MethodId {
    private final long value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ MethodId m8405boximpl(long r100) {
        return new MethodId(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m8406constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m8407equalsimpl(long r100, Object r101) {
        if ((r101 instanceof MethodId) == true) goto L6;
        return false;
    L6:
        if (r100 == ((MethodId) r101).m8413unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m8408equalsimpl0(long r100, long r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m8409hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    /* JADX INFO: renamed from: methodKey-impl, reason: not valid java name */
    public static final int m8410methodKeyimpl(long r100) {
        return (int) (r100 >> 32);
    }

    /* JADX INFO: renamed from: methodSig-impl, reason: not valid java name */
    public static final int m8411methodSigimpl(long r100) {
        return (int) r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m8412toStringimpl(long r100) {
        return "MethodId(value=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m8407equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m8409hashCodeimpl(this.value);
    }

    public String toString() {
        return m8412toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m8413unboximpl() {
        return this.value;
    }

    private /* synthetic */ MethodId(long r100) {
        this.value = r100;
    }
}
