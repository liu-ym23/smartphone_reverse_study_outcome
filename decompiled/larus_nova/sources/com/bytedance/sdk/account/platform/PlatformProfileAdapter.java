package com.bytedance.sdk.account.platform;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;

/* JADX INFO: loaded from: classes22.dex */
public abstract class PlatformProfileAdapter extends BaseAccountAdapter {

    public class ProfileCallback extends ob7.a {
        final /* synthetic */ PlatformProfileAdapter this$0;

        public ProfileCallback(PlatformProfileAdapter r100) {
            this.this$0 = r100;
        }

        public void onSuccess(ob7.c r100) {
            this.this$0.onProfileSuccess(r100);
        }

        @Override // sa7.h
        public /* bridge */ /* synthetic */ void onSuccess(ua7.b r100) {
            onSuccess((ob7.c) r100);
        }

        public void onError(ob7.c r100, int r101) {
            this.this$0.onProfileError(r100);
        }

        @Override // sa7.h
        public /* bridge */ /* synthetic */ void onError(ua7.b r100, int r101) {
            onError((ob7.c) r100, r101);
        }
    }

    public abstract /* synthetic */ void onProfileError(ob7.c r100);

    public abstract /* synthetic */ void onProfileSuccess(ob7.c r100);

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onError(AuthorizeErrorResponse r100) {
        ob7.c r101 = new ob7.c(false);
        setAuthorizeErrorInfo(r101, r100);
        onProfileError(r101);
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onSuccess(Bundle r100) {
        f.a r101 = BaseAccountAdapter.delegateMap.get(this.platform);
        if (r101 == null) goto L6;
        r101.createProfile(this).requestProfile(r100);
        return;
    }

    public PlatformProfileAdapter(Context r100, String r101, String r102) {
        super(r100, r101, r102);
    }
}
