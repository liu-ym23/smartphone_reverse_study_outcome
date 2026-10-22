package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class LazyFieldLite {
    private ByteString bytes;
    private ExtensionRegistryLite extensionRegistry;
    private volatile boolean isDirty;
    protected volatile MessageLite value;

    public int getSerializedSize() {
        if (this.isDirty == false) goto L7;
        return this.value.getSerializedSize();
    L7:
        return this.bytes.size();
    }

    public void ensureInitialized(MessageLite r100) {
        if (this.value == null) goto L5;
        return;
    L5:
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (this.value == null) goto L22;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L22:
        if (this.bytes == null) goto L13;
        this.value = r100.getParserForType().parseFrom(this.bytes, this.extensionRegistry);     // Catch: IOException -> L19 Throwable -> L16
    L21:
        goto L14
    L13:
        this.value = r100;     // Catch: IOException -> L19 Throwable -> L16
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
    }

    public MessageLite getValue(MessageLite r100) {
        ensureInitialized(r100);
        return this.value;
    }

    public MessageLite setValue(MessageLite r100) {
        MessageLite r101 = this.value;
        this.value = r100;
        this.bytes = null;
        this.isDirty = true;
        return r101;
    }
}
