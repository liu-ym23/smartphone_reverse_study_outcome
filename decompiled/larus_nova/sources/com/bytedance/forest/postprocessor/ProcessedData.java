package com.bytedance.forest.postprocessor;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.forest.model.Response;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010$\u001a\u00028\u0000¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0007\u001a\u00020\u0004H\u0010¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0010¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0004H\u0010¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0010¢\u0006\u0004\b\u000f\u0010\u0010J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u001d\u0010\u001e\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001aH\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010 \u001a\u00020\u001fH\u0016R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010$\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/bytedance/forest/postprocessor/ProcessedData;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/forest/model/k;", "", "isCacheProvided$forest_release", "()Z", "isCacheProvided", "isCacheReady$forest_release", "isCacheReady", "isCacheClear$forest_release", "isCacheClear", "Lcom/bytedance/forest/model/Response;", "response", "", "tryLoadToMemory$forest_release", "(Lcom/bytedance/forest/model/Response;)V", "tryLoadToMemory", "", "provideBytes", "Ljava/io/InputStream;", "provideInputStream", "supportReuse", "", "size", "close", "Lkotlin/Function0;", "onFulFilled", "fulfillListener$forest_release", "(Lkotlin/jvm/functions/Function0;)V", "fulfillListener", "", "toString", "I", "getSize", "()I", "data", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "<init>", "(ILjava/lang/Object;)V", "forest_release"}, k = 1, mv = {1, 4, 0})
public class ProcessedData<T> extends com.bytedance.forest.model.k {
    private final T data;
    private final int size;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.bytedance.forest.model.k
    public boolean isCacheClear$forest_release() {
        return false;
    }

    @Override // com.bytedance.forest.model.k
    public boolean isCacheProvided$forest_release() {
        return true;
    }

    @Override // com.bytedance.forest.model.k
    public boolean isCacheReady$forest_release() {
        return true;
    }

    @Override // com.bytedance.forest.model.k
    public byte[] provideBytes() {
        return null;
    }

    @Override // com.bytedance.forest.model.k
    public InputStream provideInputStream(Response r100) {
        return null;
    }

    @Override // com.bytedance.forest.model.k
    public boolean supportReuse() {
        return true;
    }

    @Override // com.bytedance.forest.model.k
    public void tryLoadToMemory$forest_release(Response r100) {
    }

    public String toString() {
        return super.toString() + "{data=" + this.data.getClass().getCanonicalName() + ", size=" + this.size + '}';
    }

    public final T getData() {
        return this.data;
    }

    public final int getSize() {
        return this.size;
    }

    @Override // com.bytedance.forest.model.k
    public int size() {
        return this.size;
    }

    @Override // com.bytedance.forest.model.k
    public void fulfillListener$forest_release(Function0<Unit> r100) {
        r100.invoke();
    }

    public ProcessedData(int r100, T r101) {
        this.size = r100;
        this.data = r101;
    }
}
