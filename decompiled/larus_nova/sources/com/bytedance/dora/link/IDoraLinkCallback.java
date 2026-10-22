package com.bytedance.dora.link;

import com.bytedance.dora.device.DoraDevice;

/* JADX INFO: loaded from: classes3.dex */
public interface IDoraLinkCallback {

    /* JADX INFO: renamed from: com.bytedance.dora.link.IDoraLinkCallback$-CC, reason: invalid class name */
    /* JADX INFO: loaded from: classes15.dex */
    public final /* synthetic */ class CC {
        public static void $default$onBtConnectStateChanged(IDoraLinkCallback r100, DoraDevice r101, int r102, int r103) {
        }

        public static void $default$onBtStateChanged(IDoraLinkCallback r100, int r101, int r102) {
        }

        public static void $default$onDeviceFound(IDoraLinkCallback r100, DoraDevice r101) {
        }

        public static void $default$onScanFailed(IDoraLinkCallback r100, int r101) {
        }
    }

    void onBtConnectStateChanged(DoraDevice r100, int r101, int r102);

    void onBtStateChanged(int r100, int r101);

    void onDeviceFound(DoraDevice r100);

    void onDoraLinkStateChanged(DoraDevice r100, int r101, int r102);

    void onScanFailed(int r100);
}
