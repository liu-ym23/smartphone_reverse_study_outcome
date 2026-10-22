package com.ss.android.downloadlib.runtime.impl;

import android.content.Context;
import com.ss.android.download.api.runtime.IAdImageProvider;
import com.ss.android.downloadlib.utils.TTDownloaderLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import l6.d;
import m6.a;
import t6.b;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/ss/android/downloadlib/runtime/impl/AdImageProviderImpl;", "Lcom/ss/android/download/api/runtime/IAdImageProvider;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lm6/a;", "createAdImageView", "", "enableRuntime", "Z", "<init>", "(Z)V", "Companion", "download-impl_release"}, k = 1, mv = {1, 4, 0})
public final class AdImageProviderImpl implements IAdImageProvider {
    public static final Companion Companion = null;
    public static final String TAG = "AdImageProviderImpl";
    private final boolean enableRuntime;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/downloadlib/runtime/impl/AdImageProviderImpl$Companion;", "", "()V", "TAG", "", "download-impl_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AdImageProviderImpl(boolean r100) {
        this.enableRuntime = r100;
    }

    @Override // com.ss.android.download.api.runtime.IAdImageProvider
    public a createAdImageView(Context r100) {
        if (this.enableRuntime == false) goto L7;
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "createAdImageView", "采用了Runtime提供的图片能力");
        b r101 = t6.a.f544652a;
        d r102 = (d) t6.a.C7690a.a(d.class, null);
        if (r102 == null) goto L8;
        r102.a();
    L8:
        return null;
    L7:
        TTDownloaderLogger.INSTANCE.innerLogE(TAG, "createAdImageView", "未开启Runtime能力开关,不使用Runtime能力展示图片");
        goto L8
    }
}
