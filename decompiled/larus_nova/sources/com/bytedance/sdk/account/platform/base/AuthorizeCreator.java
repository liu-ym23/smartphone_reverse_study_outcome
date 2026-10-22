package com.bytedance.sdk.account.platform.base;

import android.content.Context;
import com.bytedance.sdk.account.platform.api.IAuthorizeService;

/* JADX INFO: loaded from: classes3.dex */
public interface AuthorizeCreator<T extends IAuthorizeService> {
    T createService(Context r100);
}
