package com.bytedance.sdk.open.tt;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.base.MediaContent;
import com.bytedance.sdk.open.aweme.common.model.BaseReq;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;
import com.bytedance.sdk.open.douyin.model.ContactHtmlObject;

/* JADX INFO: loaded from: classes22.dex */
public class a {

    /* JADX INFO: renamed from: com.bytedance.sdk.open.tt.a$a, reason: collision with other inner class name */
    public static class C3770a extends BaseReq {
        public ContactHtmlObject htmlObject;
        public String mClientKey;
        public MediaContent mMediaContent;
        public String mState;

        public C3770a() {
        }

        public C3770a(Bundle r100) {
            fromBundle(r100);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public void fromBundle(Bundle r100) {
            this.callerPackage = r100.getString(com.bytedance.sdk.open.tt.b.a.f269788l);
            this.extras = r100.getBundle(com.bytedance.sdk.open.tt.b.a.f269781e);
            this.callerLocalEntry = r100.getString(com.bytedance.sdk.open.tt.b.a.f269789m);
            this.mClientKey = r100.getString(com.bytedance.sdk.open.tt.b.a.f269779c);
            this.mMediaContent = MediaContent.Builder.fromBundle(r100);
            this.htmlObject = ContactHtmlObject.unserialize(r100);
            this.mState = r100.getString(com.bytedance.sdk.open.tt.b.a.f269780d, "");
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public int getType() {
            return 5;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putInt(com.bytedance.sdk.open.tt.b.a.f269786j, getType());
            r100.putBundle(com.bytedance.sdk.open.tt.b.a.f269781e, this.extras);
            r100.putString(com.bytedance.sdk.open.tt.b.a.f269789m, this.callerLocalEntry);
            r100.putString(com.bytedance.sdk.open.tt.b.a.f269780d, this.mState);
            r100.putString(com.bytedance.sdk.open.tt.b.a.f269779c, this.mClientKey);
            MediaContent r101 = this.mMediaContent;
            if (r101 == null) goto L5;
            r100.putAll(MediaContent.Builder.toBundle(r101));
        L5:
            ContactHtmlObject r102 = this.htmlObject;
            if (r102 == null) goto L9;
            r102.serialize(r100);
            return;
        }
    }

    public static class b extends BaseResp {
        public String mState;

        public b() {
        }

        public b(Bundle r100) {
            fromBundle(r100);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public void fromBundle(Bundle r100) {
            this.errorCode = r100.getInt(com.bytedance.sdk.open.tt.b.a.f269784h);
            this.errorMsg = r100.getString(com.bytedance.sdk.open.tt.b.a.f269785i);
            this.extras = r100.getBundle(com.bytedance.sdk.open.tt.b.a.f269781e);
            this.mState = r100.getString(com.bytedance.sdk.open.tt.b.a.f269780d);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public int getType() {
            return 6;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public void toBundle(Bundle r100) {
            r100.putInt(com.bytedance.sdk.open.tt.b.a.f269784h, this.errorCode);
            r100.putString(com.bytedance.sdk.open.tt.b.a.f269785i, this.errorMsg);
            r100.putInt(com.bytedance.sdk.open.tt.b.a.f269786j, getType());
            r100.putBundle(com.bytedance.sdk.open.tt.b.a.f269781e, this.extras);
        }
    }

    public a() {
    }
}
