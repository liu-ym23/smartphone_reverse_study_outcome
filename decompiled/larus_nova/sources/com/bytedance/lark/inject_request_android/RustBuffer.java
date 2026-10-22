package com.bytedance.lark.inject_request_android;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/lark/inject_request_android/RustBuffer;", "Lcom/sun/jna/Structure;", "()V", "capacity", "", "data", "Lcom/sun/jna/Pointer;", "len", "ByValue", "Companion", "inject_request_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Structure.FieldOrder({"capacity", "len", "data"})
public class RustBuffer extends Structure {
    public static final a Companion = null;
    public int capacity;
    public Pointer data;
    public int len;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/lark/inject_request_android/RustBuffer$ByValue;", "Lcom/bytedance/lark/inject_request_android/RustBuffer;", "Lcom/sun/jna/Structure$ByValue;", "()V", "inject_request_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ByValue extends RustBuffer implements Structure.ByValue {
        public ByValue() {
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public RustBuffer() {
    }
}
