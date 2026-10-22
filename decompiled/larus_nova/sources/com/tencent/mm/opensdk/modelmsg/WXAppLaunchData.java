package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;

/* JADX INFO: loaded from: classes40.dex */
public final class WXAppLaunchData {
    public static final String ACTION_HANDLE_WXAPPLAUNCH = ".ACTION_HANDLE_WXAPPLAUNCH";
    public static final String ACTION_HANDLE_WXAPP_RESULT = ".ACTION_HANDLE_WXAPP_RESULT";
    public static final String ACTION_HANDLE_WXAPP_SHOW = ".ACTION_HANDLE_WXAPP_SHOW";
    public int launchType;
    public String message;

    public static class Builder {
        public Builder() {
        }

        public static WXAppLaunchData fromBundle(Bundle r100) {
            WXAppLaunchData r101 = new WXAppLaunchData();
            r101.launchType = r100.getInt("_wxapplaunchdata_launchType");
            r101.message = r100.getString("_wxapplaunchdata_message");
            return r101;
        }

        public static Bundle toBundle(WXAppLaunchData r100) {
            Bundle r101 = new Bundle();
            r101.putInt("_wxapplaunchdata_launchType", r100.launchType);
            r101.putString("_wxapplaunchdata_message", r100.message);
            return r101;
        }
    }

    public WXAppLaunchData() {
    }
}
