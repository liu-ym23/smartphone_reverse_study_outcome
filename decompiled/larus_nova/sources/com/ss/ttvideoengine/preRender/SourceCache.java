package com.ss.ttvideoengine.preRender;

import android.text.TextUtils;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoModelCache;
import com.ss.ttvideoengine.fetcher.FetcherApiHelper;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.source.DirectUrlSource;
import com.ss.ttvideoengine.source.Source;
import com.ss.ttvideoengine.source.VidPlayAuthTokenSource;
import com.ss.ttvideoengine.source.VideoModelSource;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes34.dex */
public class SourceCache implements Timer.TimerListener {
    private static final String TAG = "PreRender_SourceCache";
    private final CopyOnWriteArrayList<SourceCacheListener> mListeners;
    private Source mSource;
    private final Timer mTimer;

    public void start() {
        this.mTimer.addTimerListener(this);
        this.mTimer.start();
    }

    public void stop() {
        this.mTimer.removeTimerListener(this);
        this.mTimer.stop();
        this.mListeners.clear();
        this.mSource = null;
    }

    @Override // com.ss.ttvideoengine.preRender.Timer.TimerListener
    public void trigger() {
        Source r100 = this.mSource;
        if (r100 != null) goto L6;
        stop();
        return;
    L6:
        String r101 = "";
        if ((r100 instanceof DirectUrlSource) == false) goto L12;
        DirectUrlSource.UrlItem r102 = ((DirectUrlSource) r100).firstItem();
        if (r102 == null) goto L28;
        r101 = r102.getCacheKey();
    L28:
        if (TextUtils.isEmpty(r101) == false) goto L31;
        stop();
        return;
    L31:
        DataLoaderHelper.DataLoaderCacheInfo r103 = TTVideoEngine.getCacheInfo(r101);
        Iterator<SourceCacheListener> r104 = this.mListeners.iterator();
    L33:
        if (r104.hasNext() == false) goto L35;
        r104.next().onCacheSize(r100, r103.mMediaSize);
        goto L33
    L35:
        return;
    L12:
        if ((r100 instanceof VideoModelSource) == false) goto L19;
        VideoModelSource r105 = (VideoModelSource) r100;
        IVideoModel r106 = r105.videoModel();
        if (r106 == null) goto L28;
        VideoInfo r107 = r106.getVideoInfo(r105.resolution());
        if (r107 == null) goto L28;
        r101 = r107.getValueStr(15);
        goto L28
    L19:
        if ((r100 instanceof VidPlayAuthTokenSource) == false) goto L28;
        VidPlayAuthTokenSource r108 = (VidPlayAuthTokenSource) r100;
        FetcherApiHelper r109 = new FetcherApiHelper(r108.playAuthToken(), r108.encodeType());
        VideoModelCache.VideoModelCacheInfo r110 = VideoModelCache.getInstance().get(r108.vid(), r109.getAPIString());
        if (r110 == null) goto L28;
        VideoModel r111 = r110.model;
        if (r111 == null) goto L28;
        VideoInfo r112 = r111.getVideoInfo(r108.resolution());
        if (r112 == null) goto L28;
        r101 = r112.getValueStr(15);
        goto L28
    }

    public SourceCache(Timer r100) {
        this.mListeners = new CopyOnWriteArrayList();
        this.mTimer = r100;
    }

    public void addSourceCacheListener(SourceCacheListener r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mListeners.contains(r100) == true) goto L8;
        this.mListeners.add(r100);
        return;
    }

    public void removeSourceCacheListener(SourceCacheListener r100) {
        this.mListeners.remove(r100);
    }

    public void setSource(Source r100) {
        this.mSource = r100;
    }
}
