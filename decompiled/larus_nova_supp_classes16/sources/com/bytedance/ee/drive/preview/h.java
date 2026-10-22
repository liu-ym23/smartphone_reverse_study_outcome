package com.bytedance.ee.drive.preview;

import com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView;
import com.bytedance.ee.bear.drive.view.preview.loadingview.AudioLoadingView;
import com.bytedance.ee.bear.drive.view.preview.loadingview.DocumentLoadingView;
import com.bytedance.ee.bear.drive.view.preview.loadingview.NotSupportLoadingView;
import com.bytedance.ee.bear.drive.view.preview.loadingview.PdfLoadingView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.NotSupportPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.SimpleAudioPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.SimpleDocumentPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.SimplePdfPreviewView;
import com.bytedance.ee.drive.mime.DriveLocalMime;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h {
    public static final HashMap<Integer, Class<? extends AbsPreviewView>> a = null;
    public static final HashMap<Integer, Class<? extends AbsLoadingView>> b = null;

    static {
        HashMap<Integer, Class<? extends AbsPreviewView>> r0 = new HashMap();
        DriveLocalMime r1 = DriveLocalMime.NOT_SUPPORT;
        r0.put(Integer.valueOf(r1.getValue()), NotSupportPreviewView.class);
        DriveLocalMime r2 = DriveLocalMime.DOCUMENT;
        r0.put(Integer.valueOf(r2.getValue()), SimpleDocumentPreviewView.class);
        DriveLocalMime r3 = DriveLocalMime.AUDIO;
        r0.put(Integer.valueOf(r3.getValue()), SimpleAudioPreviewView.class);
        DriveLocalMime r4 = DriveLocalMime.PDF;
        r0.put(Integer.valueOf(r4.getValue()), SimplePdfPreviewView.class);
        a = r0;
        HashMap<Integer, Class<? extends AbsLoadingView>> r5 = new HashMap();
        r5.put(Integer.valueOf(r1.getValue()), NotSupportLoadingView.class);
        r5.put(Integer.valueOf(r2.getValue()), DocumentLoadingView.class);
        r5.put(Integer.valueOf(r3.getValue()), AudioLoadingView.class);
        r5.put(Integer.valueOf(r4.getValue()), PdfLoadingView.class);
        b = r5;
    }
}
