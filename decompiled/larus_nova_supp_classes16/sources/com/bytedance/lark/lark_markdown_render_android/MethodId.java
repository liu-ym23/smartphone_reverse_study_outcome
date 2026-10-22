package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u000eJ\r\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u000eJ\u0010\u0010\u0013\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0017"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/MethodId;", "", "value", "", "constructor-impl", "(J)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "methodKey", "methodKey-impl", "methodSig", "methodSig-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class MethodId {
    private final long value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ MethodId m485boximpl(long r1) {
        return new MethodId(r1);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m486constructorimpl(long r0) {
        return r0;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m487equalsimpl(long r4, Object r6) {
        if ((r6 instanceof MethodId) == true) goto L6;
        return false;
    L6:
        if (r4 == ((MethodId) r6).m493unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m488equalsimpl0(long r1, long r3) {
        if (r1 != r3) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m489hashCodeimpl(long r2) {
        return (int) (r2 ^ (r2 >>> 32));
    }

    /* JADX INFO: renamed from: methodKey-impl, reason: not valid java name */
    public static final int m490methodKeyimpl(long r1) {
        return (int) (r1 >> 32);
    }

    /* JADX INFO: renamed from: methodSig-impl, reason: not valid java name */
    public static final int m491methodSigimpl(long r0) {
        return (int) r0;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m492toStringimpl(long r2) {
        return "MethodId(value=" + r2 + ')';
    }

    public boolean equals(Object r3) {
        return m487equalsimpl(this.value, r3);
    }

    public int hashCode() {
        return m489hashCodeimpl(this.value);
    }

    public String toString() {
        return m492toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m493unboximpl() {
        return this.value;
    }

    private /* synthetic */ MethodId(long r1) {
        this.value = r1;
    }
}
