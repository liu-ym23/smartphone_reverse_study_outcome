package com.bytedance.locallife;

import android.content.Context;
import android.net.Uri;
import com.ss.android.lark.utils.statistics.PerfLog;
import gl6.c;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/locallife/ILocalLifeService;", "", "isBaseSdkInit", "", "handleSchema", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "matchSchema", "initBaseSdk", "", "getXVideoBehavior", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILocalLifeService {
    void a();

    boolean b(Uri r100);

    boolean c();

    c d();

    boolean handleSchema(Context r100, Uri r101);
}
