package com.bytedance.ee.bear.document.like;

import android.text.TextUtils;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.chameleon.AbsChameleonService;
import du5.b;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public final class OfficeLikeListLaunchWebService extends AbsChameleonService {

    public static class LikeListJsData implements NonProguard {
        private int refer_type;
        private String token;

        public LikeListJsData() {
        }

        public String toString() {
            return "LikeListJsData{token='" + b.g(this.token) + "', refer_type=" + this.refer_type + '}';
        }

        public int getRefer_type() {
            return this.refer_type;
        }

        public String getToken() {
            return this.token;
        }

        public void setRefer_type(int r100) {
            this.refer_type = r100;
        }

        public void setToken(String r100) {
            this.token = r100;
        }
    }

    public static class a implements i<LikeListJsData> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            LikeListJsData r102 = (LikeListJsData) r100;
            tt5.a.h("OfficeLikeListLaunchWebService", "open like list, data: " + r102);
            if (r102 != null) goto L5;
        L8:
            tt5.a.k("OfficeLikeListLaunchWebService", "open like list failed, data is invalid");
            return;
        L5:
            if (TextUtils.isEmpty(r102.getToken()) == true) goto L8;
            ((h) org.koin.java.a.a(h.class)).w2("/doc/like/activity").i("doc_token", r102.getToken()).j("ref_type", r102.getRefer_type()).i("from", "from_click").e();
        }
    }

    public OfficeLikeListLaunchWebService() {
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonService, vv4.a
    public final void onAttachToWeb(k r100) {
        super.onAttachToWeb(r100);
        bindBridgeHandlerAutoUnbind("biz.util.openlikesList", new a());
    }
}
