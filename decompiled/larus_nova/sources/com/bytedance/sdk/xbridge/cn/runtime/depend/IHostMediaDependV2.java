package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import yd7.j;
import yd7.k;
import zd7.b0;
import zd7.e0;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J(\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostMediaDependV2;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lyd7/j$g;", "params", "Lzd7/b0;", "extra", "Lzd7/b;", "callback", "", "startImageXUpload", "closeImageXUpload", "Lyd7/k$f;", "Lzd7/e0;", "Lzd7/c;", "startVideoUpload", "closeVideoUpload", "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface IHostMediaDependV2 {
    void closeImageXUpload();

    void closeVideoUpload();

    void startImageXUpload(Context r100, j.g r101, b0 r102, zd7.b r103);

    void startVideoUpload(Context r100, k.f r101, e0 r102, zd7.c r103);
}
