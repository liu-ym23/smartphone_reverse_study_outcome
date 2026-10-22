package com.bytedance.upc;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\bH&J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\bH&J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\bH&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/upc/IUpc;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/upc/a;", "configuration", "", "init", "", com.bytedance.android.ec.core.event.a.KEY_DID, "uid", "start", "scheme", "", "open", "load", "settings", "updateSettings", "com.bytedance.upc"}, k = 1, mv = {1, 4, 0})
public interface IUpc {
    void init(Context r100, a r101);

    boolean load(String r100);

    boolean open(String r100);

    void start(String r100, String r101);

    void updateSettings(String r100);
}
