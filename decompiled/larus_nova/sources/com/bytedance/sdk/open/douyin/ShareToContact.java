package com.bytedance.sdk.open.douyin;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.base.InviteCardObject;
import com.bytedance.sdk.open.aweme.base.JoinGroupObject;

/* JADX INFO: loaded from: classes22.dex */
public class ShareToContact extends com.bytedance.sdk.open.tt.a {

    public static class Request extends com.bytedance.sdk.open.tt.a.C3770a {
        public InviteCardObject mInviteCard;
        public JoinGroupObject mJoinGroupObject;

        public Request() {
        }

        public Request(Bundle r100) {
            super(r100);
            fromBundle(r100);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public boolean checkArgs() {
            InviteCardObject r100 = this.mInviteCard;
            if (r100 == null) goto L9;
            if (r100.checkArgs() == true) goto L9;
            return false;
        L9:
            return super.checkArgs();
        }

        @Override // com.bytedance.sdk.open.tt.a.C3770a, com.bytedance.sdk.open.aweme.common.model.BaseReq
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.mInviteCard = InviteCardObject.unserialize(r100);
            this.mJoinGroupObject = JoinGroupObject.unserialize(r100);
        }

        @Override // com.bytedance.sdk.open.tt.a.C3770a, com.bytedance.sdk.open.aweme.common.model.BaseReq
        public int getType() {
            return 5;
        }

        @Override // com.bytedance.sdk.open.tt.a.C3770a, com.bytedance.sdk.open.aweme.common.model.BaseReq
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            InviteCardObject r101 = this.mInviteCard;
            if (r101 == null) goto L5;
            r101.serialize(r100);
        L5:
            JoinGroupObject r102 = this.mJoinGroupObject;
            if (r102 == null) goto L9;
            r102.serialize(r100);
            return;
        }
    }

    public static class Response extends com.bytedance.sdk.open.tt.a.b {
        public Response() {
        }

        public Response(Bundle r100) {
            fromBundle(r100);
        }
    }

    public ShareToContact() {
    }
}
