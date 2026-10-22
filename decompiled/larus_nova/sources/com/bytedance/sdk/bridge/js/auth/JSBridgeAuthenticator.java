package com.bytedance.sdk.bridge.js.auth;

import com.bytedance.sdk.bridge.auth.AbsBridgeAuthenticator;

/* JADX INFO: loaded from: classes22.dex */
public class JSBridgeAuthenticator extends AbsBridgeAuthenticator<String> {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final JSBridgeAuthenticator f269595a = null;

        static {
            f269595a = new JSBridgeAuthenticator();
        }
    }

    public JSBridgeAuthenticator() {
    }

    public static JSBridgeAuthenticator inst() {
        return a.f269595a;
    }
}
