package sn7;

import android.content.Intent;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.manager.h;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements no7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f542663a = null;

    public static class a implements IUiListener {
        public a() {
        }

        @Override // com.tencent.tauth.IUiListener
        public final void onCancel() {
            new kn7.b(10001, ShareChannelType.QQ);
            h.g.f272345a.getClass();
        }

        @Override // com.tencent.tauth.IUiListener
        public final void onComplete(Object r100) {
            new kn7.b(10000, ShareChannelType.QQ);
            r100.toString();
            h.g.f272345a.getClass();
        }

        @Override // com.tencent.tauth.IUiListener
        public final void onError(UiError r100) {
            kn7.b r101 = new kn7.b(10002, ShareChannelType.QQ);
            r101.f504256b = r100.errorCode;
            h.g.f272345a.getClass();
        }

        @Override // com.tencent.tauth.IUiListener
        public final void onWarning(int r100) {
            new kn7.b(10003, ShareChannelType.QQ).f504256b = r100;
            h.g.f272345a.getClass();
        }
    }

    public c() {
    }

    static {
        f542663a = new a();
    }

    @Override // no7.c
    public final void a(int r100, int r101, Intent r102) {
        Tencent.onActivityResultData(r100, r101, r102, f542663a);
    }
}
