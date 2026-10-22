package com.ss.android.lark.biz.im.api;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class ShortcutInfoLoadResult implements Serializable {
    public List<FeedPreviewInfo> feedInfos;
    public List<Shortcut> shortcuts;

    public ShortcutInfoLoadResult(List<Shortcut> r100, List<FeedPreviewInfo> r101) {
        this.shortcuts = r100;
        this.feedInfos = r101;
    }
}
