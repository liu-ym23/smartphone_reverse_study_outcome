package com.larus.timonkit.api;

import android.content.ClipData;
import android.content.ClipDescription;
import com.larus.init.task.j0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u001c\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\u0013"}, d2 = {"Lcom/larus/timonkit/api/ITimonKitService;", "", "initTimon", "", "isAcceptPrivacy", "Lkotlin/Function0;", "", "initUpc", "getPrimaryClip", "Landroid/content/ClipData;", "token", "", "getPrimaryClipDescription", "Landroid/content/ClipDescription;", "setPrimaryClip", "clipData", "hasPrimaryClip", "clearPrimaryClip", "getPrimaryClipWithPattern", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ITimonKitService {
    void a();

    boolean b(String r100);

    ClipData c(String r100);

    ClipDescription d(String r100);

    void e(ClipData r100, String r101);

    ClipData f(String r100);

    void g(j0 r100);

    void h(String r100);
}
