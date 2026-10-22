package com.lynx.devtoolwrapper;

import android.app.Dialog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes32.dex */
public class DevToolOverlayDelegate {
    private OverlayService mService;

    /* JADX INFO: renamed from: com.lynx.devtoolwrapper.DevToolOverlayDelegate$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SingletonHelper {
        private static final DevToolOverlayDelegate INSTANCE = null;

        private SingletonHelper() {
        }

        static {
            INSTANCE = new DevToolOverlayDelegate(null);
        }

        public static /* synthetic */ DevToolOverlayDelegate access$100() {
            return INSTANCE;
        }
    }

    private DevToolOverlayDelegate() {
    }

    public ArrayList<Integer> getAllVisibleOverlaySign() {
        OverlayService r100 = this.mService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAllVisibleOverlaySign();
    }

    public ArrayList<Dialog> getGlobalOverlayView() {
        OverlayService r100 = this.mService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getGlobalOverlayView();
    }

    public static DevToolOverlayDelegate getInstance() {
        return SingletonHelper.access$100();
    }

    public /* synthetic */ DevToolOverlayDelegate(AnonymousClass1 r100) {
        this();
    }

    public void init(OverlayService r100) {
        this.mService = r100;
    }
}
