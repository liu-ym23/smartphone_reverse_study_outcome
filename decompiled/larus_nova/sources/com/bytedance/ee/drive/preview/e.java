package com.bytedance.ee.drive.preview;

import com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public interface e extends d {
    boolean B1();

    int c3(String r100);

    Class<? extends AbsPreviewView> ca(int r100, z r101);

    Class<? extends AbsLoadingView> f4(int r100, z r101);

    Map<String, String> oc(String r100);

    boolean pa();
}
