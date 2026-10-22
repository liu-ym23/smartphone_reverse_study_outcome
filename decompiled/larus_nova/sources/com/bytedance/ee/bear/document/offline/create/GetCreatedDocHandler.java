package com.bytedance.ee.bear.document.offline.create;

import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import fo5.d;
import h25.b;
import h25.c;
import java.io.Serializable;
import tb5.i;
import tb5.m;
import tt5.a;

/* JADX INFO: loaded from: classes16.dex */
public class GetCreatedDocHandler implements i<OfflineJSData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f220404a;

    public static class OfflineJSData implements Serializable {
        private String fakeToken;

        public OfflineJSData() {
        }

        public String toString() {
            return "OfflineJSData{fakeToken='" + this.fakeToken + "'}";
        }

        public String getFakeToken() {
            return this.fakeToken;
        }

        public void setFakeToken(String r100) {
            this.fakeToken = r100;
        }
    }

    public GetCreatedDocHandler() {
    }

    public BearUrl a() {
        return null;
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, m r101) {
        a.h("GetCreatedDocHandler", "GetCreatedDocHandler.handle: 35 ");
        this.f220404a = r101;
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).I(((OfflineJSData) r100).getFakeToken()).observeOn(d.d()).subscribe(new b(this), new c());
    }
}
