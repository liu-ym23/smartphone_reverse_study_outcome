package com.larus.im.callback;

import com.bytedance.android.ec.core.event.a;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0012\u001a\u00020\u0000H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/larus/im/callback/IIMError;", "", "code", "", "getCode", "()I", "tips", "", "getTips", "()Ljava/lang/String;", "ext", "", "getExt", "()Ljava/util/Map;", a.KEY_EXCEPTION, "", "getException", "()Ljava/lang/Throwable;", "deepCopy", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IIMError {
    IIMError deepCopy();

    int getCode();

    Throwable getException();

    Map<String, String> getExt();

    String getTips();
}
