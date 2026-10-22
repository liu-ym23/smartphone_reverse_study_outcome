package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TTMonitorProvider {
    public TTMonitorProvider() {
    }

    public abstract void handleApiResult(boolean r100, String r101, String r102, String r103, long r104, long r105, long r106, long r110, long r111, long r112, long r113, long r114, long r210, long r211, boolean r212, long r213, long r214, long r310, String r311, String r312, String r313, int r314, int r315, String r316, String r317);

    public abstract boolean handleApiSample(String r100, String r101);

    public abstract void sendAppMonitorEvent(String r100, String r101);
}
