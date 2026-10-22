package com.bytedance.kmp.ec.yata.common.platform;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "SDK内部工具类")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003J\u0006\u0010\t\u001a\u00020\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/platform/YataPlatformAtomicLong;", "Ljava/io/Serializable;", "initialValue", "", "(J)V", "atomicLong", "Ljava/util/concurrent/atomic/AtomicLong;", "addAndGet", "delta", MonitorConstants.CONNECT_TYPE_GET, "toString", "", "yata-common-kmp_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
public final class YataPlatformAtomicLong implements Serializable {
    private final AtomicLong atomicLong;

    public final long get() {
        return this.atomicLong.get();
    }

    public String toString() {
        return this.atomicLong.toString();
    }

    public YataPlatformAtomicLong(long r100) {
        this.atomicLong = new AtomicLong(r100);
    }

    public final long addAndGet(long r100) {
        return this.atomicLong.addAndGet(r100);
    }
}
