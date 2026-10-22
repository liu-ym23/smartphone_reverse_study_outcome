package com.vivo.push.ups;

import android.content.Context;
import android.os.Bundle;
import com.vivo.push.PushClient;

/* JADX INFO: loaded from: classes41.dex */
public class VUpsManager {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static VUpsManager f462520a;

        static {
            f462520a = new VUpsManager();
        }

        public static /* synthetic */ VUpsManager a() {
            return f462520a;
        }
    }

    public void onCommandResult(Context r100, Bundle r101) {
    }

    public static VUpsManager getInstance() {
        return a.a();
    }

    public VUpsManager() {
    }

    public void turnOffPush(Context r100, UPSTurnCallback r101) {
        PushClient.getInstance(r100).turnOffPush(new d(this, r101));
    }

    public void turnOnPush(Context r100, UPSTurnCallback r101) {
        PushClient.getInstance(r100).turnOnPush(new c(this, r101));
    }

    public void unRegisterToken(Context r100, UPSRegisterCallback r101) {
        PushClient.getInstance(r100).turnOffPush(new b(this, r101));
    }

    public void registerToken(Context r100, String r101, String r102, String r103, UPSRegisterCallback r104) {
        PushClient.getInstance(r100).turnOnPush(new com.vivo.push.ups.a(this, r104));
    }
}
