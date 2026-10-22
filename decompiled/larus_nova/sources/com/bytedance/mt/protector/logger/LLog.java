package com.bytedance.mt.protector.logger;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0082 ¨\u0006\t"}, d2 = {"Lcom/bytedance/mt/protector/logger/LLog;", "", "", "tag", "msg", "", "nativePrintCompleteLog", "<init>", "()V", "protector_release"}, k = 1, mv = {1, 4, 0})
public final class LLog {

    public static final class a {
        public a() {
        }
    }

    public LLog() {
    }

    private final native void nativePrintCompleteLog(String r100, String r101);

    static {
        new LLog();
        new AtomicBoolean(false);
        new AtomicBoolean(false);
        new a();
        System.getProperty("line.separator");
    }
}
